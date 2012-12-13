package org.m2ling.presentation;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.m2ling.common.configuration.Conf;
import org.m2ling.presentation.i18n.Msg;
import org.m2ling.presentation.principles.PrinciplesM2App;
import org.m2ling.presentation.studio.StudioM2App;

import com.google.inject.Inject;
import com.google.inject.servlet.SessionScoped;
import com.vaadin.Application;
import com.vaadin.terminal.Terminal;
import com.vaadin.terminal.ThemeResource;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.Window.Notification;

@SuppressWarnings("serial")
@SessionScoped
public class M2lingApplication extends Application {
	private Window mainWindow;

	private MenuBar menu;

	private Logger logger;

	private PrinciplesM2App principlesApp;

	private StudioM2App studioApp;

	@SuppressWarnings("unused")
	private M2App currentApp;

	private VerticalLayout root;

	private final Msg msg;

	@Inject
	public M2lingApplication(Logger logger, PrinciplesM2App principles, StudioM2App studioApp, Conf conf, Msg msg) {
		super();
		this.logger = logger;
		this.principlesApp = principles;
		this.studioApp = studioApp;
		this.msg = msg;
	}

	@Override
	public void init() {
		mainWindow = new Window("m2ling");
		setTheme("m2ling_theme");
		setMainWindow(mainWindow);
		// Use all the screen size
		root = (VerticalLayout) mainWindow.getContent();
		root.setWidth("100%");
		// Needs to be undefined to allow vertical scrolling
		root.setHeight("-1");
		initMenu();
		root.setSpacing(true);
		// set m2principles app by default
		setApp(principlesApp);
	}

	private void initMenu() {
		menu = new MenuBar();
		menu.setWidth("100%");
		menu.setHeight("30px");
		menu.setStyleName("app");
		// m2principles
		menu.addItem(msg.get("app.1"), null, new MenuBar.Command() {
			public void menuSelected(MenuBar.MenuItem selectedItem) {
				setApp(principlesApp);
			}
		});
		// m2studio
		menu.addItem(msg.get("app.2"), null, new MenuBar.Command() {
			public void menuSelected(MenuBar.MenuItem selectedItem) {
				setApp(studioApp);
			}
		});
	}

	private void setApp(M2App app) {
		root.removeAllComponents();
		// Logo
		ThemeResource resLogo = new ThemeResource("img/m2ling_logo.png");
		Embedded logo = new Embedded(null, resLogo);
		root.addComponent(logo);
		root.addComponent(menu);
		root.addComponent(app);
		this.currentApp = app;
	}

	/**
	 * Note that this works only when application is actually started. If an exception occurs during
	 * application loading (including guice proactive object graph loading), it can't be reached.
	 */
	@Override
	public void terminalError(Terminal.ErrorEvent event) {
		logger.log(Level.SEVERE, "Untrapped error", event.getThrowable());
		// Some custom behavior.
		if (getMainWindow() != null) {
			getMainWindow().showNotification(msg.get("error.0"), Notification.TYPE_ERROR_MESSAGE);
		}
	}
}

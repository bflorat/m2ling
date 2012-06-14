package org.m2ling.presentation;

import java.util.logging.Logger;

import org.m2ling.presentation.principles.PrinciplesMainFrame;
import org.m2ling.presentation.widgets.MainFrame;

import com.google.inject.Inject;
import com.vaadin.Application;
import com.vaadin.terminal.Terminal;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.Window.Notification;

public class M2lingApplication extends Application {

	private static final long serialVersionUID = 912752897192337109L;

	private Window mainWindow;

	private MainFrame mframe;

	private MenuBar menu;

	@Inject
	private Logger logger;

	@Inject
	private PrinciplesMainFrame principlesFrame;

	private Panel currentApp;

	@Override
	public void init() {
		mainWindow = new Window("m2ling");
		setTheme("m2ling_theme");
		setMainWindow(mainWindow);
		// Use all the screen size
		mainWindow.getContent().setSizeFull();
		initMenu();
		mframe = new MainFrame();
		VerticalLayout rootLayout = (VerticalLayout) mainWindow.getContent();
		mainWindow.addComponent(menu);
		mainWindow.addComponent(mframe);
		rootLayout.setSpacing(true);
		rootLayout.setExpandRatio(mframe, 100);
		// set m2principles app by default
		setApp(principlesFrame);
	}

	@SuppressWarnings("serial")
	private void initMenu() {
		menu = new MenuBar();
		menu.setWidth("100%");
		menu.setHeight("30px");
		menu.setStyleName("app");

		// m2principles
		menu.addItem("m2principles", null, new MenuBar.Command() {
			public void menuSelected(MenuBar.MenuItem selectedItem) {
				setApp(principlesFrame);
			}
		});
	}

	private void setApp(Panel app) {
		if (app != this.currentApp) {
			mframe.resetAccordion();
			mframe.getAppPanel().setContent(app);
			this.currentApp = app;
		} else {
			logger.warning("Tried to apply existing application : " + app);
		}
	}

	@Override
	public void terminalError(Terminal.ErrorEvent event) {
		// Call the default implementation.
		super.terminalError(event);
		// Some custom behaviour.
		if (getMainWindow() != null) {
			getMainWindow().showNotification("An unchecked exception occured!", event.getThrowable().toString(),
					Notification.TYPE_ERROR_MESSAGE);
		}
	}

}

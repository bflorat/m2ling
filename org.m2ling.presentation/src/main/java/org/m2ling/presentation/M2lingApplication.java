package org.m2ling.presentation;

import java.util.List;
import java.util.logging.Logger;

import org.m2ling.presentation.principles.PrinciplesGuiModule;
import org.m2ling.presentation.widgets.SidebarEntry;

import com.google.inject.Inject;
import com.google.inject.servlet.SessionScoped;
import com.vaadin.Application;
import com.vaadin.terminal.Terminal;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.Window.Notification;

@SuppressWarnings("serial")
@SessionScoped
public class M2lingApplication extends Application {

	private Window mainWindow;

	private MainFrame mframe;

	private MenuBar menu;

	private Logger logger;

	private PrinciplesGuiModule principlesGuiModule;

	private GuiModule currentApp;

	@Inject
	public M2lingApplication(Logger logger, PrinciplesGuiModule principles) {
		super();
		this.logger = logger;
		this.principlesGuiModule = principles;
	}

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
		setApp(principlesGuiModule);
	}

	private void initMenu() {
		menu = new MenuBar();
		menu.setWidth("100%");
		menu.setHeight("30px");
		menu.setStyleName("app");

		// m2principles
		menu.addItem("m2principles", null, new MenuBar.Command() {
			public void menuSelected(MenuBar.MenuItem selectedItem) {
				setApp(principlesGuiModule);
			}
		});
	}

	private void setApp(GuiModule app) {
		mframe.resetAccordion();
		mframe.getAppPanel().removeAllComponents();
		mframe.getAppPanel().addComponent(app);
		List<SidebarEntry> entries = app.getEntries();
		for (SidebarEntry entry : entries) {
			mframe.getAccordion().addTab(entry, entry.getLabel(), null, 0);
			if (entry.isDefaultEntry()) {
				mframe.getAccordion().setSelectedTab(entry);
			}
		}
		this.currentApp = app;
	}

	@Override
	public void terminalError(Terminal.ErrorEvent event) {
		// Call the default implementation.
		super.terminalError(event);
		// Some custom behavior.
		if (getMainWindow() != null) {
			getMainWindow().showNotification("An unchecked exception occured!", event.getThrowable().toString(),
					Notification.TYPE_ERROR_MESSAGE);
		}
	}

}

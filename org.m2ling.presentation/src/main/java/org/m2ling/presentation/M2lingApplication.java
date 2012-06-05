package org.m2ling.presentation;

import java.util.List;

import com.google.common.collect.Lists;
import com.vaadin.Application;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

public class M2lingApplication extends Application {

	private static final long serialVersionUID = 912752897192337109L;

	private Window mainWindow;

	private MainFrame mframe;

	private MenuBar menu;

	/**
	 * List of available applications. TODO : call a service to get available applications for
	 * currently logged-in user.
	 **/
	private List<String> availableApps = Lists.newArrayList("Principles", "Configuration");

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
	}

	private void initMenu() {
		menu = new MenuBar();
		menu.setWidth("100%");
		menu.setHeight("30px");
		for (String app : availableApps) {
			menu.addItem(app, null, null);
		}
		menu.setStyleName("app");
	}

}

package org.m2ling.presentation;

import java.util.List;

import com.google.common.collect.Lists;
import com.vaadin.Application;
import com.vaadin.terminal.ThemeResource;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.Window;

public class M2lingApplication extends Application {

	private static final long serialVersionUID = 912752897192337109L;

	private Window mainWindow;

	/**
	 * List of available applications. TODO : call a service to get available applications for
	 * currently loged-in user.
	 **/
	private List<String> availableApps = Lists.asList("m2principles",null);
	 
	@Override
	public void init() {
		mainWindow = new Window("m2ling");
		setTheme("m2ling_theme");
		setMainWindow(mainWindow);
		initAppsSelector();
	}

	private void initAppsSelector() {
		TabSheet tabs = new TabSheet();
		tabs.setHeight("132px");
		tabs.setWidth("100%");

		// logo
		ThemeResource resLogo = new ThemeResource("img/m2ling_logo.png");
		Embedded logo = new Embedded(null, resLogo);

		// Build the final tab sheet and adds it to the main window
		tabs.addTab(logo).setStyleName("logo");
		for (String app : availableApps){
			TabSheet tabsApp = new TabSheet();
			tabs.addTab(tabsApp,app).setStyleName("app");
		}
		mainWindow.addComponent(tabs);
	}
}

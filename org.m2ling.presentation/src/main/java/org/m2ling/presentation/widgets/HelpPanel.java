/**
 * Copyright (C) 2012 Bertrand Florat
 *
 * @author "Bertrand Florat <bertrand@florat.net>"
 */
package org.m2ling.presentation.widgets;

import com.vaadin.terminal.ThemeResource;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.NativeButton;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

/**
 * Collapsible help panel
 */
@SuppressWarnings("serial")
public class HelpPanel extends CustomComponent {
	private final Panel hiddenPanel;

	/**
	 * Build an Help panel with provided text
	 * 
	 * 
	 * @param text
	 *           text to display
	 */
	public HelpPanel(String text) {
		VerticalLayout vl = new VerticalLayout();
		vl.setWidth("100%");
		vl.setHeight("-1");
		NativeButton button = new NativeButton();
		button.setIcon(new ThemeResource("img/16/help.png"));
		button.setStyleName("borderless");
		button.addListener(new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				hiddenPanel.setVisible(!hiddenPanel.isVisible());
			}
		});
		hiddenPanel = new Panel();
		hiddenPanel.setVisible(false);
		hiddenPanel.setWidth("100%");
		hiddenPanel.setHeight("200px");
		hiddenPanel.addStyleName("help-panel");
		Label label = new Label(text, Label.CONTENT_RAW);
		label.setWidth("100%");
		label.setHeight("-1");
		hiddenPanel.addComponent(label);
		vl.addComponent(button);
		vl.addComponent(hiddenPanel);
		setCompositionRoot(vl);
	}
}

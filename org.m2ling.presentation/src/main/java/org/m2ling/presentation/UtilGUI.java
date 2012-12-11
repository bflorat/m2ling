/**
 * Copyright (C) 2012 Bertrand Florat
 *
 * @author "Bertrand Florat <bertrand@florat.net>"
 */
package org.m2ling.presentation;

import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;

/**
 * Various fine GUI utilities
 */
public class UtilGUI {
	
	public static HorizontalLayout getComponentWithLabel(String label,Component component){
		Label labelEnumeration = new Label(label);
		HorizontalLayout enumerationLayout = new HorizontalLayout();
		enumerationLayout.setWidth("100%");
		enumerationLayout.setHeight("-1");
		enumerationLayout.addComponent(labelEnumeration);
		enumerationLayout.addComponent(component);
		return enumerationLayout;
	}
	
}

/**
 * Copyright (C) 2012 Bertrand Florat
 *
 * @author "Bertrand Florat <bertrand@florat.net>"
 */
package org.m2ling.presentation;

import java.util.List;

import org.m2ling.presentation.widgets.SidebarEntry;

import com.vaadin.ui.VerticalLayout;

/**
 * A m2ling application
 */
@SuppressWarnings("serial")
public abstract class GuiModule extends VerticalLayout {

	@Override
	abstract public void attach();

	/** Order list of accordion entries **/
	abstract public List<SidebarEntry> getEntries();

}

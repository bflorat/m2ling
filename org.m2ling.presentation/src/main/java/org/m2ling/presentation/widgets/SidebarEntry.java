/**
 * Copyright (C) 2012 Bertrand Florat
 *
 * @author "Bertrand Florat <bertrand@florat.net>"
 */
package org.m2ling.presentation.widgets;

import com.vaadin.ui.Panel;

/**
 * Encapsulate information we need to build an entry of the sidebar accordion.
 */
@SuppressWarnings("serial")
public abstract class SidebarEntry extends Panel {

	/** Should this entry be shown at startup ? */
	private boolean defaultEntry = false;

	/**
	 * @return the defaultEntry
	 */
	public boolean isDefaultEntry() {
		return defaultEntry;
	}

	/**
	 * @param defaultEntry
	 *           the defaultEntry to set
	 */
	public void setDefaultEntry(boolean defaultEntry) {
		this.defaultEntry = defaultEntry;
	}

	/**
	 * @return the caption used in the accordion
	 */
	public abstract String getLabel();

	public SidebarEntry() {
		super();
	}

	@Override
	public abstract void attach();

	public String toString() {
		return getLabel() + " / " + this.getDebugId();
	}
}

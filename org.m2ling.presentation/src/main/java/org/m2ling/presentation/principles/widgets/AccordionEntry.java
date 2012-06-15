/**
 * Copyright (C) 2012 Bertrand Florat
 *
 * @author "Bertrand Florat <bertrand@florat.net>"
 */
package org.m2ling.presentation.principles.widgets;

import com.vaadin.ui.Panel;

/**
 * Encapsulate information we need to build an entry of the sidebar accordion.
 */
public class AccordionEntry {
	private String caption;
	private Panel panel;
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
	 * @return the caption
	 */
	public String getCaption() {
		return caption;
	}

	/**
	 * @return the panel
	 */
	public Panel getPanel() {
		return panel;
	}

	public AccordionEntry(String caption, Panel panel) {
		this.caption = caption;
		this.panel = panel;
	}

	public boolean equals(Object other) {
		AccordionEntry otherEntry = (AccordionEntry) other;
		if (otherEntry == null || otherEntry.getCaption() == null || otherEntry.getPanel() == null) {
			return false;
		}
		return otherEntry.getCaption().equals(getCaption()) && otherEntry.getPanel().equals(getPanel());
	}

	public String toString() {
		return this.caption + " / " + this.panel.getDebugId();
	}
}

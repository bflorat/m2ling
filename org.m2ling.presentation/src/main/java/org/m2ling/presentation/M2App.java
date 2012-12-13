/**
 * Copyright (C) 2012 Bertrand Florat
 *
 * @author "Bertrand Florat <bertrand@florat.net>"
 */
package org.m2ling.presentation;

import com.vaadin.ui.Panel;

/**
 * A m2ling application
 */
@SuppressWarnings("serial")
public abstract class M2App extends Panel {
	@Override
	abstract public void attach();

}

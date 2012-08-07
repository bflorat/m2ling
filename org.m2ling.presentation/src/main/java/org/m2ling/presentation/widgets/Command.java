/**
 * Copyright (C) 2012 Bertrand Florat
 *
 * @author "Bertrand Florat <bertrand@florat.net>"
 */
package org.m2ling.presentation.widgets;

/**
 * Something to do
 */
public interface Command {
	/** Action to execute */
	void execute();

	/** A label for the execution */
	String getLabel();
}

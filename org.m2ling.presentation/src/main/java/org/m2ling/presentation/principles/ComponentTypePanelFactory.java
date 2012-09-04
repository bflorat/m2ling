/**
 * Copyright (C) 2012 Bertrand Florat
 *
 * @author "Bertrand Florat <bertrand@florat.net>"
 */
package org.m2ling.presentation.principles;

/**
 * Produces CT panels using the assisted injection pattern
 */
public interface ComponentTypePanelFactory {
	ComponentTypesPanel getCTPanelFor(String vpID);
}

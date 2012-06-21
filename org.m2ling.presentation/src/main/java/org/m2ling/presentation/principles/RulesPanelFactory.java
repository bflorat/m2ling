/**
 * Copyright (C) 2012 Bertrand Florat
 *
 * @author "Bertrand Florat <bertrand@florat.net>"
 */
package org.m2ling.presentation.principles;

import org.m2ling.presentation.principles.model.ViewPointBean;

/**
 * Produces Rules panels using the assisted injection pattern
 */
public interface RulesPanelFactory {

	RulesPanel getRulesPanelFor(ViewPointBean vp);

}

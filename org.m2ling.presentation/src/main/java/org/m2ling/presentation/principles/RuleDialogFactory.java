/**
 * Copyright (C) 2012 Bertrand Florat
 *
 * @author "Bertrand Florat <bertrand@florat.net>"
 */
package org.m2ling.presentation.principles;

import org.m2ling.presentation.principles.model.RuleBean;

/**
 * Produces rule dialogs using the assisted injection pattern
 */
public interface RuleDialogFactory {
	/**
	 * Build a RuleDialog for given arguments
	 * 
	 * @param bean
	 *           the rule bean encapsulating all rule data
	 * @return a RuleDialog for given arguments
	 */
	RuleDialog getRuleDialogFor(RuleBean bean);
}

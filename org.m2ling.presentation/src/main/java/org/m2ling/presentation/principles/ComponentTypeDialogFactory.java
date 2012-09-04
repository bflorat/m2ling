/**
 * Copyright (C) 2012 Bertrand Florat
 *
 * @author "Bertrand Florat <bertrand@florat.net>"
 */
package org.m2ling.presentation.principles;

import org.m2ling.presentation.principles.model.RuleBean;

import com.vaadin.data.util.BeanItem;

/**
 * Produces CT dialogs using the assisted injection pattern
 */
public interface ComponentTypeDialogFactory {
	
	//TODO
	RuleDialog getRuleDialogFor(BeanItem<RuleBean> beanItem);
}

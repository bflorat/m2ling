/**
 * Copyright (C) 2012 Bertrand Florat
 *
 * @author "Bertrand Florat <bertrand@florat.net>"
 */
package org.m2ling.presentation.principles;

import org.m2ling.presentation.principles.model.ComponentTypeBean;
import org.m2ling.presentation.principles.model.RuleBean;
import org.m2ling.presentation.principles.model.ViewPointBean;

import com.vaadin.data.util.BeanItem;

/**
 * Produces viewpoint panels using the assisted injection pattern
 */
public interface PrinciplesGUIFactory {
	ViewPointPanel getViewPointPanelFor(ViewPointBean bean);

	ComponentTypeDialog getComponentTypeDialogFor(BeanItem<ComponentTypeBean> beanItem);

	ComponentTypesPanel getCTPanelFor(String vpID);

	RuleDialog getRuleDialogFor(BeanItem<RuleBean> beanItem);

	ViewPointDialog getViewPointDialogFor(ViewPointBean bean);
	
	RulesPanel getRulesPanelFor(String vp);
}
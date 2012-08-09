/**
 * Copyright (C) 2012 Bertrand Florat
 *
 * @author "Bertrand Florat <bertrand@florat.net>"
 */
package org.m2ling.presentation.binding;

import org.m2ling.presentation.principles.RuleDialog;
import org.m2ling.presentation.principles.RuleDialogFactory;
import org.m2ling.presentation.principles.RulesPanel;
import org.m2ling.presentation.principles.RulesPanelFactory;
import org.m2ling.presentation.principles.ViewPointDialog;
import org.m2ling.presentation.principles.ViewPointDialogFactory;
import org.m2ling.presentation.principles.ViewPointPanel;
import org.m2ling.presentation.principles.ViewPointPanelFactory;
import org.m2ling.service.principles.RuleService;
import org.m2ling.service.principles.RuleServiceImpl;
import org.m2ling.service.principles.ViewPointService;
import org.m2ling.service.principles.ViewPointServiceImpl;

import com.google.inject.AbstractModule;
import com.google.inject.assistedinject.FactoryModuleBuilder;

/**
 * Guice bindings for m2principles features of presentation tiers
 */
public class PresentationPrincipleGuiceModule extends AbstractModule {
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.inject.AbstractModule#configure()
	 */
	@Override
	protected void configure() {
		{// Injection bindings
			bind(ViewPointService.class).to(ViewPointServiceImpl.class);
			bind(RuleService.class).to(RuleServiceImpl.class);
			install(new FactoryModuleBuilder().implement(ViewPointDialog.class, ViewPointDialog.class).build(
					ViewPointDialogFactory.class));
			install(new FactoryModuleBuilder().implement(ViewPointPanel.class, ViewPointPanel.class).build(
					ViewPointPanelFactory.class));
			install(new FactoryModuleBuilder().implement(RulesPanel.class, RulesPanel.class)
					.build(RulesPanelFactory.class));
			install(new FactoryModuleBuilder().implement(RuleDialog.class, RuleDialog.class)
					.build(RuleDialogFactory.class));
		}
	}
}

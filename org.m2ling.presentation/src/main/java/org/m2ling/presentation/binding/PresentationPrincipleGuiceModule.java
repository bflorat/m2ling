/**
 * Copyright (C) 2012 Bertrand Florat
 *
 * @author "Bertrand Florat <bertrand@florat.net>"
 */
package org.m2ling.presentation.binding;

import org.m2ling.presentation.principles.ComponentTypeDialog;
import org.m2ling.presentation.principles.ComponentTypesPanel;
import org.m2ling.presentation.principles.LinkTypeDialog;
import org.m2ling.presentation.principles.LinkTypesPanel;
import org.m2ling.presentation.principles.PrinciplesGUIFactory;
import org.m2ling.presentation.principles.RuleDialog;
import org.m2ling.presentation.principles.RulesPanel;
import org.m2ling.presentation.principles.ViewPointDialog;
import org.m2ling.presentation.principles.ViewPointPanel;
import org.m2ling.service.principles.ComponentTypeService;
import org.m2ling.service.principles.ComponentTypeServiceImpl;
import org.m2ling.service.principles.LinkTypeService;
import org.m2ling.service.principles.LinkTypeServiceImpl;
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
			bind(ComponentTypeService.class).to(ComponentTypeServiceImpl.class);
			bind(LinkTypeService.class).to(LinkTypeServiceImpl.class);
			install(new FactoryModuleBuilder().implement(ViewPointDialog.class, ViewPointDialog.class)
					.implement(ViewPointPanel.class, ViewPointPanel.class).implement(RulesPanel.class, RulesPanel.class)
					.implement(RuleDialog.class, RuleDialog.class)
					.implement(ComponentTypesPanel.class, ComponentTypesPanel.class)
					.implement(ComponentTypeDialog.class, ComponentTypeDialog.class)
					.implement(LinkTypesPanel.class, LinkTypesPanel.class)
					.implement(LinkTypeDialog.class, LinkTypeDialog.class).build(PrinciplesGUIFactory.class));
		}
	}
}

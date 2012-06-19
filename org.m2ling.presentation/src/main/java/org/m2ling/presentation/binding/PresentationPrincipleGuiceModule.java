/**
 * Copyright (C) 2012 Bertrand Florat
 *
 * @author "Bertrand Florat <bertrand@florat.net>"
 */
package org.m2ling.presentation.binding;

import org.m2ling.presentation.principles.PrinciplesGuiModule;
import org.m2ling.presentation.principles.ViewPointDialog;
import org.m2ling.presentation.principles.ViewPointDialogFactory;
import org.m2ling.presentation.principles.ViewPointPanel;
import org.m2ling.presentation.principles.ViewPointPanelFactory;
import org.m2ling.service.principles.ViewPointService;
import org.m2ling.service.principles.impl.ViewPointServiceImpl;

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
			bind(PrinciplesGuiModule.class);
			install(new FactoryModuleBuilder().implement(ViewPointDialog.class, ViewPointDialog.class).build(
					ViewPointDialogFactory.class));
			install(new FactoryModuleBuilder().implement(ViewPointPanel.class, ViewPointPanel.class).build(
					ViewPointPanelFactory.class));
		}
	}
}

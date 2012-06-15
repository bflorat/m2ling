/**
 * Copyright (C) 2012 Bertrand Florat
 *
 * @author "Bertrand Florat <bertrand@florat.net>"
 */
package org.m2ling.presentation.binding;

import org.m2ling.common.dto.binding.M2lingGuiceModule;
import org.m2ling.presentation.principles.PrinciplesGuiModule;
import org.m2ling.service.principles.ViewPointService;
import org.m2ling.service.principles.impl.ViewPointServiceImpl;

/**
 * Guice bindings for m2principles features of presentation tiers
 */
public class PresentationPrincipleGuiceModule extends M2lingGuiceModule {

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
		}
	}

}

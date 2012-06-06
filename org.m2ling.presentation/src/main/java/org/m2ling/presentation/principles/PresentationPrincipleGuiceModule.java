/**
 * Copyright (C) 2012 Bertrand Florat
 *
 * @author "Bertrand Florat <bertrand@florat.net>"
 */
package org.m2ling.presentation.principles;

import org.m2ling.service.principles.ViewPointService;
import org.m2ling.service.principles.impl.ViewPointServiceImpl;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

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
			bind(PrinciplesMainFrame.class);
		}
	}

}

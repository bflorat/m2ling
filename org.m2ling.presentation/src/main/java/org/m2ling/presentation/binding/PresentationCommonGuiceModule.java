/**
 * Copyright (C) 2012 Bertrand Florat
 *
 * @author "Bertrand Florat <bertrand@florat.net>"
 */
package org.m2ling.presentation.binding;

import org.m2ling.service.core.TagService;
import org.m2ling.service.core.TagServiceImpl;

import com.google.inject.AbstractModule;

/**
 * Guice bindings for common features of presentation tiers
 */
public class PresentationCommonGuiceModule extends AbstractModule {
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.inject.AbstractModule#configure()
	 */
	@Override
	protected void configure() {
		{// Injection bindings
			bind(TagService.class).to(TagServiceImpl.class);
		}
	}
}

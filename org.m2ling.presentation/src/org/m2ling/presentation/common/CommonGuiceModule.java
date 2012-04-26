/**
 * Copyright (C) 2012 Bertrand Florat
 *
 * @author "Bertrand Florat <bertrand@florat.net>"
 */
package org.m2ling.presentation.common;

import org.m2ling.service.core.TagService;
import org.m2ling.service.core.impl.TagServiceImpl;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

/**
 * Guice bindings for common features of presentation tiers
 */
public class CommonGuiceModule extends AbstractModule {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.inject.AbstractModule#configure()
	 */
	@Override
	protected void configure() {
		{// Injection bindings
			bind(TagService.class).to(TagServiceImpl.class).in(Singleton.class);
		}
	}

}

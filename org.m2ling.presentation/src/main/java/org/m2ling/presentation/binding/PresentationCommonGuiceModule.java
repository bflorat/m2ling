/**
 * Copyright (C) 2012 Bertrand Florat
 *
 * @author "Bertrand Florat <bertrand@florat.net>"
 */
package org.m2ling.presentation.binding;

import org.m2ling.common.dto.binding.M2lingGuiceModule;
import org.m2ling.service.core.TagService;
import org.m2ling.service.core.impl.TagServiceImpl;

/**
 * Guice bindings for common features of presentation tiers
 */
public class PresentationCommonGuiceModule extends M2lingGuiceModule {

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

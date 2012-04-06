/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.service.principles;

import org.m2ling.service.principles.impl.ViewPointServiceImpl;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

/**
 * Guice module for all service layer tests.
 * 
 * @author Bertrand Florat <bertrand@florat.net>
 * 
 */
public class GuiceModule extends AbstractModule {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.inject.AbstractModule#configure()
	 */
	@Override
	protected void configure() {
		bind(ViewPointService.class).to(ViewPointServiceImpl.class).in(Singleton.class);
	}

}

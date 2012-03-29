/**
 * Copyright (C) Bertrand Florat
 */
package org.m2ling.service;

import org.m2ling.service.principles.ViewPointService;
import org.m2ling.service.principles.impl.ViewPointServiceMockImpl;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

/**
 * @author bflorat
 * 
 */
public abstract class AbstractTestCase extends AbstractModule {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.inject.AbstractModule#configure()
	 */
	@Override
	protected void configure() {
		bind(ViewPointService.class).to(ViewPointServiceMockImpl.class).in(Singleton.class);
	}

}

/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.service.common;

import org.m2ling.common.security.ACResource;
import org.m2ling.common.security.impl.ACResourceInterceptorImpl;
import org.m2ling.persistence.PersistenceManager;
import org.m2ling.persistence.impl.PersistenceManagerTeneoImpl;
import org.m2ling.service.util.CoreUtil;
import org.m2ling.service.util.DTOConverter;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.google.inject.matcher.Matchers;

/**
 * Guice configuration common to every m2ling service
 * 
 * @author "Bertrand Florat <bertrand@florat.net>"
 * 
 */
public class CommonGuiceModule extends AbstractModule {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.inject.AbstractModule#configure()
	 */
	@Override
	protected void configure() {

		{ // Bindings
			bind(PersistenceManager.class).to(PersistenceManagerTeneoImpl.class).in(Singleton.class);
			bind(CoreUtil.class);
			bind(DTOConverter.FromDTO.class);
			bind(DTOConverter.ToDTO.class);
		}

		{// AOP bindings
			// Bind every @ACResource method
			// TODO : implement a production intercepter
			bindInterceptor(Matchers.any(), Matchers.annotatedWith(ACResource.class), new ACResourceInterceptorImpl());
			// Bind every @ACResource class
			bindInterceptor(Matchers.annotatedWith(ACResource.class), Matchers.any(), new ACResourceInterceptorImpl());
		}
	}
}

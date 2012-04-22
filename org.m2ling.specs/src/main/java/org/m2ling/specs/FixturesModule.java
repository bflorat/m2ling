/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.specs;

import org.m2ling.security.ACResource;
import org.m2ling.service.core.TagService;
import org.m2ling.service.core.impl.TagServiceImpl;
import org.m2ling.service.principles.ViewPointService;
import org.m2ling.service.principles.impl.ViewPointServiceImpl;
import org.m2ling.soa.Context;
import org.m2ling.utils.ACResourceInterceptorMockImpl;
import org.m2ling.utils.Mocked;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.google.inject.matcher.Matchers;

/**
 * 
 * Central place for m2ling fixtures
 * 
 * @author Bertrand Florat <bertrand@florat.net>
 * 
 */
public class FixturesModule extends AbstractModule {

	public static FixturesModule INSTANCE = new FixturesModule();

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.inject.AbstractModule#configure()
	 */
	@Override
	protected void configure() {
		m2principle();
	}

	private void m2principle() {
		// Injection binding
		bind(ViewPointService.class).to(ViewPointServiceImpl.class).in(Singleton.class);
		bind(TagService.class).to(TagServiceImpl.class).in(Singleton.class);

		Context context = Context.newContext(Context.Entry.USER, "hceheo").add(Context.Entry.PWD_HASH,
				"8f7d88e901a5ad3a05d8cc0de93313fd76028f8c");
		bind(Context.class).annotatedWith(Mocked.class).toInstance(context);

		// AOP binding
		{
			// Bind every @ACResource method
			bindInterceptor(Matchers.any(), Matchers.annotatedWith(ACResource.class), new ACResourceInterceptorMockImpl());
			// Bind every @ACResource class
			bindInterceptor(Matchers.annotatedWith(ACResource.class), Matchers.any(), new ACResourceInterceptorMockImpl());
		}
	}

}

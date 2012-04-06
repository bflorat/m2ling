/**
 * Copyright (C) Bertrand Florat
 */
package org.m2ling.service;

import org.m2ling.service.common.TagService;
import org.m2ling.service.core.impl.TagServiceImpl;
import org.m2ling.service.principles.ViewPointService;
import org.m2ling.service.principles.impl.ViewPointServiceImpl;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

/**
 * 
 * Central place for m2ling fixtures
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
	
	private void m2principle(){
		bind(ViewPointService.class).to(ViewPointServiceImpl.class).in(Singleton.class);
		bind(TagService.class).to(TagServiceImpl.class).in(Singleton.class);
	}

}

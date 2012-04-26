/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.specs;

import org.m2ling.persistence.PersistenceManager;
import org.m2ling.persistence.impl.PersistenceManagerXMIImpl;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

/**
 * 
 * Default fixtures specific bindings to be injected into services
 * 
 * @author Bertrand Florat <bertrand@florat.net>
 * 
 */
public class FixturesModule extends AbstractModule {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.inject.AbstractModule#configure()
	 */
	@Override
	protected void configure() {
		{// Injection bindings
			bind(PersistenceManager.class).to(PersistenceManagerXMIImpl.class).in(Singleton.class);
		}
	}

}

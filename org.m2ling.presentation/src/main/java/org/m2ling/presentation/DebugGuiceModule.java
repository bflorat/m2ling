/**
 * Copyright (C) 2012 Bertrand Florat
 *
 * @author "Bertrand Florat <bertrand@florat.net>"
 */
package org.m2ling.presentation;

import org.m2ling.persistence.PersistenceManager;
import org.m2ling.persistence.impl.PersistenceManagerXMIImpl;

import com.google.inject.AbstractModule;

/**
 * Additional Guice bindings that can be set on debug. Only token into account when
 * Consts.M2LING_DEBUG_VARIABLE_NAME environment variable is set to true.
 */
public class DebugGuiceModule extends AbstractModule {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.inject.AbstractModule#configure()
	 */
	@Override
	protected void configure() {
		{// Injection bindings
			bind(PersistenceManager.class).to(PersistenceManagerXMIImpl.class);
		}
	}

}

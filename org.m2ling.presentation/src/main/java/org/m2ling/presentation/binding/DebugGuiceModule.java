/**
 * Copyright (C) 2012 Bertrand Florat
 *
 * @author "Bertrand Florat <bertrand@florat.net>"
 */
package org.m2ling.presentation.binding;

import org.m2ling.persistence.PersistenceManager;
import org.m2ling.persistence.impl.PersistenceManagerTeneoImpl;
import org.m2ling.persistence.impl.PersistenceManagerXMIImpl;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

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
		{ // constants binding
			bindConst(PersistenceManagerTeneoImpl.SpecificConfiguration.CONF_TENEO_USER, "test");

		}
	}

	private void bindConst(String key, String value) {
		bindConstant().annotatedWith(Names.named(key)).to(value);
	}

}

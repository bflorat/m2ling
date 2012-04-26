/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.service.util;

import java.util.logging.Level;

import org.m2ling.common.utils.Mocked;
import org.m2ling.persistence.PersistenceManager;
import org.m2ling.service.common.CommonGuiceModule;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Module;

/**
 * Access to injected persistence manager
 * 
 * @author "Bertrand Florat <bertrand@florat.net>"
 * 
 */

public class PersistenceManagerFactory {

	@Inject
	@Mocked
	static Class<? extends Module> specificModuleClass;

	@Inject
	private static java.util.logging.Logger logger;

	private static final PersistenceManager PMANAGER;

	static {
		Injector finalInjector = null;
		if (specificModuleClass == null) {
			finalInjector = Guice.createInjector(new CommonGuiceModule());
		} else {
			Module specificModule = null;
			try {
				specificModule = (Module) specificModuleClass.newInstance();
			} catch (InstantiationException e) {
				logger.log(Level.SEVERE, "Can't create specific module", e);
			} catch (IllegalAccessException e) {
				logger.log(Level.SEVERE, "Can't create specific module", e);
			}
			if (specificModule != null) {
				finalInjector = Guice.createInjector(specificModule);
			}
		}
		PMANAGER = finalInjector.getInstance(PersistenceManager.class);
	}

	
	
	
	public PersistenceManager getPersistenceManager() {
		return PMANAGER;
	}

}

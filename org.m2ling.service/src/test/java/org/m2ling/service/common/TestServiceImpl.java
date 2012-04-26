/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.service.common;

import static junit.framework.Assert.assertTrue;

import org.junit.Test;
import org.m2ling.common.utils.Utils;
import org.m2ling.persistence.PersistenceManager;
import org.m2ling.persistence.impl.PersistenceManagerTeneoImpl;
import org.m2ling.persistence.impl.PersistenceManagerXMIImpl;
import org.m2ling.service.principles.impl.ViewPointServiceImpl;

import com.google.inject.AbstractModule;
import com.google.inject.Module;
import com.google.inject.Singleton;

/**
 * @author "Bertrand Florat <bertrand@florat.net>"
 * 
 */
public class TestServiceImpl {

	@Test
	public void noSpecificBindingsInjection() {
		ViewPointServiceImpl sampleServiceImpl = Utils.newInstance(ViewPointServiceImpl.class,null);
		assertTrue(sampleServiceImpl.getPersistenceManager() instanceof PersistenceManagerTeneoImpl);
	}

	@Test
	public void pmOverriding() {
		Module specific = new AbstractModule() {

			@Override
			protected void configure() {
				bind(PersistenceManager.class).to(PersistenceManagerXMIImpl.class).in(Singleton.class);
			}
		};
		ViewPointServiceImpl sampleServiceImpl = Utils.newInstance(ViewPointServiceImpl.class, specific);
		assertTrue(sampleServiceImpl.getPersistenceManager() instanceof PersistenceManagerXMIImpl);
	}

}

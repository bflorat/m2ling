/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.service.common;

import static junit.framework.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.junit.Test;
import org.m2ling.common.utils.Utils;
import org.m2ling.persistence.PersistenceManager;
import org.m2ling.persistence.impl.PersistenceManagerTeneoImpl;
import org.m2ling.persistence.impl.PersistenceManagerXMIImpl;
import org.m2ling.service.principles.impl.ViewPointServiceImpl;

import com.google.inject.AbstractModule;
import com.google.inject.Module;
import com.google.inject.name.Names;

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
				bind(PersistenceManager.class).to(PersistenceManagerXMIImpl.class);
			// Mock model URI
				File file = new File("src/test/resources/mocks/tests.m2ling");
				URI uri = null;
				try {
					uri = URI.createURI("file://" + file.getCanonicalPath());
				} catch (IOException e) {
					e.printStackTrace();
				}
				bind(URI.class).annotatedWith(Names.named("XMI_FILE")).toInstance(uri);
			}
		};
		ViewPointServiceImpl sampleServiceImpl = Utils.newInstance(ViewPointServiceImpl.class, specific);
		assertTrue(sampleServiceImpl.getPersistenceManager() instanceof PersistenceManagerXMIImpl);
	}

}

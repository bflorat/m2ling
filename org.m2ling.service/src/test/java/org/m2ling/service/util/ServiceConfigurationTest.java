/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.service.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.hibernate.cfg.Environment;
import org.junit.Test;
import org.m2ling.common.dto.binding.M2lingGuiceModule;
import org.m2ling.common.test_utils.TestHelper;
import org.m2ling.common.utils.Consts;
import org.m2ling.common.utils.Utils;
import org.m2ling.persistence.PersistenceManager;
import org.m2ling.persistence.impl.PersistenceManagerTeneoImpl;
import org.m2ling.service.AbstractTestCase;

/**
 * @author "Bertrand Florat <bertrand@florat.net>"
 * 
 */
public class ServiceConfigurationTest extends AbstractTestCase {

	@Test
	public void confInjected() {
		M2lingGuiceModule module = new M2lingGuiceModule() {
			@Override
			protected void configure() {
				bind(PersistenceManager.class).to(PersistenceManagerTeneoImpl.class);
				bind(PersistenceManagerTeneoImpl.SpecificConfiguration.class);
				bindConst(PersistenceManagerTeneoImpl.SpecificConfiguration.CONF_TENEO_CASCADE_POLICY, "foo");
			}
		};
		
		PersistenceManager pm = getInstanceWithModule(PersistenceManager.class, module);
		//ServiceConfiguration conf = getInstanceWithModule(ServiceConfiguration.class, module);
	//	assertEquals("foo",
	//			conf.getSystemProperty(PersistenceManagerTeneoImpl.SpecificConfiguration.CONF_TENEO_CASCADE_POLICY));
	}

	@Test
	public void regularMode() {
		Map<String, String> newenv = new HashMap<String, String>();
		newenv.put(Consts.M2LING_DEBUG_VARIABLE_NAME, "false");
		Utils.setEnv(newenv);
		ServiceConfiguration conf = new ServiceConfiguration();
		assertEquals("org.h2.Driver", conf.getSystemProperty(Environment.DRIVER));
		assertTrue(new File(TestHelper.getUTStorage().getAbsolutePath() + File.separator + Consts.CONF_SERVICE_FILENAME)
				.exists());
	}

	@Test
	public void debugMode() {
		// debug mode is by default in AbstractTestCase
		assertEquals(System.getenv(Consts.M2LING_HOME_VARIABLE_NAME), TestHelper.getUTStorage().getAbsolutePath());
		ServiceConfiguration conf = new ServiceConfiguration();
		assertEquals("org.h2.Driver", conf.getSystemProperty(Environment.DRIVER));
		assertTrue(new File(TestHelper.getUTStorage().getAbsolutePath() + File.separator + Consts.CONF_SERVICE_FILENAME)
				.exists());
	}
}

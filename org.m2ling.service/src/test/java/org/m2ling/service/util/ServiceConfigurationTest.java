/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.service.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.junit.Test;
import org.m2ling.common.test_utils.TestHelper;
import org.m2ling.common.utils.Consts;
import org.m2ling.common.utils.Utils;
import org.m2ling.persistence.impl.PersistenceManagerTeneoImpl;
import org.m2ling.service.AbstractTestCase;

/**
 * @author "Bertrand Florat <bertrand@florat.net>"
 * 
 */
public class ServiceConfigurationTest extends AbstractTestCase {

	@Test
	public void confOverriden() {
		Properties confOverriden = new Properties();
		confOverriden.put(PersistenceManagerTeneoImpl.SpecificConfiguration.CONF_TENEO_DRIVER, "foo");
		ServiceConfiguration conf = new ServiceConfiguration(confOverriden, logger);
		assertEquals(conf.getSystemProperty(PersistenceManagerTeneoImpl.SpecificConfiguration.CONF_TENEO_DRIVER), "foo");
	}

	@Test
	public void debugUnset() {
		// unset debug mode (activated by default by parent class)
		Map<String, String> newenv = new HashMap<String, String>();
		newenv.put(Consts.M2LING_DEBUG_VARIABLE_NAME, "false");
		Utils.setEnv(newenv);
		ServiceConfiguration conf = new ServiceConfiguration(null, logger);
		conf.register(new PersistenceManagerTeneoImpl.SpecificConfiguration());
		assertEquals(conf.getSystemProperty(PersistenceManagerTeneoImpl.SpecificConfiguration.CONF_TENEO_DRIVER),
				"org.h2.Driver");
		// check that service conf file has been created
		assertTrue(new File(TestHelper.getUTStorage().getAbsolutePath() + File.separator + Consts.CONF_SERVICE_FILENAME)
				.exists());
	}

	@Test
	public void debugSet() {
		Map<String, String> newenv = new HashMap<String, String>();
		newenv.put(Consts.M2LING_HOME_VARIABLE_NAME, TestHelper.getUTStorage().getAbsolutePath());
		Utils.setEnv(newenv);
		assertEquals(System.getenv(Consts.M2LING_HOME_VARIABLE_NAME), TestHelper.getUTStorage().getAbsolutePath());
		ServiceConfiguration conf = new ServiceConfiguration(null, logger);
		conf.register(new PersistenceManagerTeneoImpl.SpecificConfiguration());
		assertEquals(conf.getSystemProperty(PersistenceManagerTeneoImpl.SpecificConfiguration.CONF_TENEO_HBM2DDL_AUTO),
				"create");
		assertFalse(new File(TestHelper.getUTStorage().getAbsolutePath() + File.separator + Consts.CONF_SERVICE_FILENAME)
				.exists());
	}
}

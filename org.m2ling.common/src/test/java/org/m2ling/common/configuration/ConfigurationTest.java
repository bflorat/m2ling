package org.m2ling.common.configuration;

/**
 * Copyright (C) 2012 Bertrand Florat
 */
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.junit.Test;
import org.m2ling.common.utils.Consts;
import org.m2ling.common.utils.M2lingUnitTest;
import org.m2ling.common.utils.Utils;

/**
 * @author "Bertrand Florat <bertrand@florat.net>"
 * 
 */
public class ConfigurationTest extends M2lingUnitTest {
	@Test
	public void confOverriden() {
		Properties confOverriden = new Properties();
		confOverriden.put(SpecificConfigurationMock.param1, "foo");
		Configuration conf = new Configuration(confOverriden, logger);
		assertEquals(conf.getSystemProperty(SpecificConfigurationMock.param1), "foo");
	}

	@Test
	public void debugUnset() {
		// unset debug mode (activated by default by parent class)
		Map<String, String> newenv = new HashMap<String, String>();
		newenv.put(Consts.M2LING_DEBUG_VARIABLE_NAME, "false");
		Utils.setEnv(newenv);
		Configuration conf = new Configuration(null, logger);
		conf.register(new SpecificConfigurationMock());
		assertEquals(conf.getSystemProperty(SpecificConfigurationMock.param1), "value_param1");
		// check that service conf file has been created
		assertTrue(new File(getUTStorage().getAbsolutePath() + File.separator + Consts.CONF_FILENAME).exists());
	}

	@Test
	public void debugSet() {
		Map<String, String> newenv = new HashMap<String, String>();
		newenv.put(Consts.M2LING_HOME_VARIABLE_NAME, getUTStorage().getAbsolutePath());
		Utils.setEnv(newenv);
		assertEquals(System.getenv(Consts.M2LING_HOME_VARIABLE_NAME), getUTStorage().getAbsolutePath());
		Configuration conf = new Configuration(null, logger);
		conf.register(new SpecificConfigurationMock());
		assertEquals(conf.getSystemProperty(SpecificConfigurationMock.param1), "value_param1_debug");
		assertFalse(new File(getUTStorage().getAbsolutePath() + File.separator + Consts.CONF_FILENAME).exists());
	}
}

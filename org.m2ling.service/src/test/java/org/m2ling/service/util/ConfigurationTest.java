/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.service.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.hibernate.cfg.Environment;
import org.junit.Test;
import org.m2ling.common.test_utils.TestHelper;
import org.m2ling.common.utils.Consts;
import org.m2ling.service.AbstractTestCase;

/**
 * @author "Bertrand Florat <bertrand@florat.net>"
 * 
 */
public class ConfigurationTest extends AbstractTestCase{

	@Test
	public void confInjected() {
		Properties confInjected = new Properties();
		confInjected.put(Environment.DRIVER, "foo");
		Configuration conf = new Configuration(confInjected);
		assertEquals(conf.getSystemProperty(Environment.DRIVER), "foo");
	}

	@Test
	public void envVariableUnset() {
		Configuration conf = new Configuration(null);
		assertEquals(conf.getSystemProperty(Environment.DRIVER), "org.h2.Driver");
		assertTrue(new File(TestHelper.getUTStorage().getAbsolutePath() + File.separator + Configuration.CONF_FILENAME)
				.exists());
	}

	@Test
	public void envVariableSetNoFile() {
		Map<String, String> newenv = new HashMap<String, String>();
		newenv.put(Consts.M2LING_HOME_VARIABLE_NAME, TestHelper.getUTStorage().getAbsolutePath());
		TestHelper.setEnv(newenv);
		assertEquals(System.getenv(Consts.M2LING_HOME_VARIABLE_NAME), TestHelper.getUTStorage().getAbsolutePath());
		Configuration conf = new Configuration(null);
		assertEquals(conf.getSystemProperty(Environment.DRIVER), "org.h2.Driver");
		assertTrue(new File(TestHelper.getUTStorage().getAbsolutePath() + File.separator + Configuration.CONF_FILENAME)
				.exists());
	}
}

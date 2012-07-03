/**
 * Copyright (C) 2012 Bertrand Florat
 *
 * @author "Bertrand Florat <bertrand@florat.net>"
 */
package org.m2ling.common.utils;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.junit.After;
import org.junit.Before;
import org.m2ling.common.configuration.Configuration;
import org.m2ling.common.utils.Consts;
import org.m2ling.common.utils.Utils;

/**
 * General UT implementation for any m2lign layer
 */
public class M2lingUnitTest {

	protected Logger logger = Logger.getAnonymousLogger();

	
	/**
	 * Return the root file storage for temporary UT files.
	 * 
	 * @return the root file storage for temporary UT files
	 */
	public File getUTStorage() {
		return new File(System.getProperty("java.io.tmpdir") + "/m2ling");
	}
	
	/**
	 * Default setup code
	 */
	@Before
	public void setUp() {
		// Set M2LING_HOME variable for test mode
		Map<String, String> newenv = new HashMap<String, String>();
		newenv.put(Consts.M2LING_HOME_VARIABLE_NAME, getUTStorage().getAbsolutePath());
		newenv.put(Consts.M2LING_DEBUG_VARIABLE_NAME, "true");
		Utils.setEnv(newenv);
		// Drop the configuration files
		Configuration conf = new Configuration(null, logger);
		conf.getConfigurationFile().delete();
	}
	
	/**
	 * Default tear down code
	 */
	@After
	public void tearDown() {

	}


}

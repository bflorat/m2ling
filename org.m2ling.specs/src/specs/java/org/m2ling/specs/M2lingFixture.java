/**
 * Copyright (C) 2012 Bertrand Florat
 *
 * @author "Bertrand Florat <bertrand@florat.net>"
 */
package org.m2ling.specs;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.concordion.api.extension.Extensions;
import org.concordion.integration.junit3.ConcordionTestCase;
import org.junit.After;
import org.junit.Before;
import org.m2ling.common.utils.Consts;
import org.m2ling.common.utils.Utils;

/**
 * Main parent class for m2ling fixtures
 */
@Extensions({MyCssExtension.class})
public abstract class M2lingFixture extends ConcordionTestCase {
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
		newenv.put(Consts.M2LING_HOME, getUTStorage().getAbsolutePath());
		newenv.put(Consts.M2LING_DEBUG, "true");
		Utils.setEnv(newenv);
	}

	/**
	 * Default tear down code
	 */
	@After
	public void tearDown() {
	}
}

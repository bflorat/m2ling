/**
 * Copyright (C) 2012 Bertrand Florat
 *
 * @author "Bertrand Florat <bertrand@florat.net>"
 */
package org.m2ling.common.test_utils;

import java.io.File;

/**
 * UT helper methods
 */
public class TestHelper {

	

	/**
	 * Return the root file storage for temporary UT files.
	 * 
	 * @return the root file storage for temporary UT files
	 */
	public static File getUTStorage() {
		return new File(System.getProperty("java.io.tmpdir") + "/m2ling");
	}

}

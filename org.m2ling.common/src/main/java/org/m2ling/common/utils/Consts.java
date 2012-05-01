/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.common.utils;

import java.io.File;

/**
 * 
 * General m2ling constaints
 * 
 * @author "Bertrand Florat <bertrand@florat.net>"
 * 
 */
public class Consts {

	/** Tags separator **/
	public static final char TAGS_SEPARATOR = ',';

	/** M2ling configuration home directory system variable name */
	public static final String M2LING_HOME_VARIABLE_NAME = "M2LING_HOME";

	/** M2LING_HOME_VARIABLE_NAME default value */
	public static final String M2LING_HOME_DEFAULT_ABS_PATH = System.getProperty("user.home") + File.separator
			+ "m2ling";

}

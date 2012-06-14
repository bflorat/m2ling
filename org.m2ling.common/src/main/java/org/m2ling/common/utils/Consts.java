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

	/** M2ling debug mode system variable name */
	public static final String M2LING_DEBUG_VARIABLE_NAME = "M2LING_DEBUG";

	/** M2LING_HOME_VARIABLE_NAME default value */
	public static final String M2LING_HOME_DEFAULT_ABS_PATH = System.getProperty("user.home") + File.separator
			+ "m2ling";

	/** Database name */
	public static final String DATABASE_NAME = "m2ling";

	/** Default XMI extension */
	public static final String XMI_EXTENSION = "m2ling";

	/** Configuration file name */
	public static final String CONF_FILENAME = "m2ling_config.xml";

	/** view points Icons storage location relative to M2LING_DEBUG_VARIABLE_NAME */
	public static final String CONF_VP_ICONS_LOCATION = "icons" + File.separatorChar + "viewpoints";

	/** Max icon size in bytes */
	public static final long CONF_ICONS_MAX_SIZE_BYTES = 5000000l;

}

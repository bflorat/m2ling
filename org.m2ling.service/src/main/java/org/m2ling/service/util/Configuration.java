/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.service.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.m2ling.common.utils.Consts;

import com.google.common.base.Strings;
import com.google.inject.Inject;

/**
 * 
 * Load, store and manages m2ling configuration and parameters.
 * 
 * @author "Bertrand Florat <bertrand@florat.net>"
 * 
 */
public class Configuration {

	private static final String CONF_FILENAME = "services_config.xml";

	@Inject
	private Logger logger;

	/** System properties for services */
	private Properties systemProperties;

	/**
	 * @param systemProperties
	 *           a list of forced configuration entries
	 */
	public Configuration(Properties systemProperties) {
		super();
		this.systemProperties = systemProperties;
	}

	public Configuration() {
		this(null);
	}

	/**
	 * Return the system property value for given key. If the key is unknown, null is returned.
	 * 
	 * @param key
	 *           the property name
	 * 
	 * @return the system property value for given key
	 */
	public String getSystemProperty(String key) {
		if (systemProperties == null) {
			systemProperties = getSystemProperties();
		}
		// Note that at this point, systemProperties should not be null (maybe void however)
		return systemProperties.getProperty(key);
	}

	/**
	 * Return the service system properties.
	 * 
	 * <p>
	 * If {@code M2LING_HOME} environment variable is set and configuration file exists and is
	 * correct, we return its content.
	 * </p>
	 * 
	 * @throw IllegalStateException in all other cases
	 * 
	 * @return the service system properties
	 */
	public Properties getSystemProperties() {
		Properties result = null;
		File fileConf = null;
		String m2lingHome = System.getenv(Consts.M2LING_HOME_VARIABLE_NAME);
		if (Strings.isNullOrEmpty(m2lingHome)) {
			throw new IllegalStateException(Consts.M2LING_HOME_VARIABLE_NAME
					+ " environement variable not set, configuration can't be loaded");
		}
		fileConf = new File(m2lingHome + File.pathSeparator + CONF_FILENAME);
		if (!fileConf.exists()) {
			throw new IllegalStateException(Consts.M2LING_HOME_VARIABLE_NAME
					+ " variable name defined but no corresponding " + fileConf.getAbsolutePath() + " file");
		} else {
			try {
				result = new Properties();
				result.loadFromXML(new FileInputStream(fileConf));
			} catch (Exception e) {
				String msg = "Corrupted configuration file : " + fileConf.getAbsolutePath();
				logger.log(Level.SEVERE, msg, e);
				throw new IllegalStateException(msg, e);
			}
		}
		return result;
	}

}

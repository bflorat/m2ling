/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.service.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.cfg.Environment;
import org.m2ling.common.utils.Consts;

import com.google.common.base.Strings;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * 
 * Load, store and manages m2ling configuration and parameters.
 * 
 * @author "Bertrand Florat <bertrand@florat.net>"
 * 
 */
@Singleton
public class Configuration {

	protected static final String CONF_FILENAME = "services_config.xml";

	@Inject
	private Logger logger;

	/** System properties for services */
	private Properties systemProperties;

	/**
	 * @param systemProperties
	 *           a list of forced configuration entries
	 * @param logger
	 *           an associated logger (UT purpose only, the logger is field-injected otherwise)
	 */
	public Configuration(Properties systemProperties, Logger logger) {
		super();
		this.systemProperties = systemProperties;
		if (logger != null) {
			this.logger = logger;
		}
	}

	public Configuration() {
		this(null,null);
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
	 * <p>
	 * If {@code M2LING_HOME} environment variable is set but the configuration file can't be found,
	 * a default configuration file is written down and the default configuration is returned.
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
		fileConf = new File(m2lingHome + File.separator + CONF_FILENAME);
		if (!fileConf.exists()) {
			String msg = Consts.M2LING_HOME_VARIABLE_NAME + " variable name defined but no corresponding "
					+ fileConf.getAbsolutePath() + " file";
			Properties conf = null;
			try {
				conf = getDefaultConfiguration();
				fileConf.getParentFile().mkdirs();
				conf.storeToXML(new FileOutputStream(fileConf), "M2ling service layer configuration file.");
				logger.info(msg + ". Default file created.");
				return conf;
			} catch (Exception e) {
				logger.log(Level.SEVERE, fileConf.getAbsolutePath() + " file can't be written", e);
				throw new IllegalStateException(msg);
			}
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

	/**
	 * Return a set of default configuration values.
	 * 
	 * @return
	 */
	public Properties getDefaultConfiguration() {
		String home = System.getProperty("user.home");
		Properties result = new Properties();
		result.put(Environment.DRIVER, "org.h2.Driver");
		result.put(Environment.USER, "admin");
		result.put(Environment.URL, "jdbc:h2:" + home + "/databases/m2ling");
		result.put(Environment.PASS, "changeoninstall");
		result.put(Environment.DIALECT, org.hibernate.dialect.H2Dialect.class.getName());
		return result;
	}

}

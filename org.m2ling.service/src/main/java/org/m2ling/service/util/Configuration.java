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

import org.eclipse.emf.teneo.PersistenceOptions;
import org.hibernate.cfg.Environment;
import org.m2ling.common.utils.Consts;

import com.google.common.base.Strings;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * 
 * Load, store and manages m2ling configuration and configuration.
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
	 * Build a configuration with explicit properties (UT purpose only)
	 * 
	 * @param systemProperties
	 *           a list of forced configuration entries
	 */
	public Configuration(Properties systemProperties) {
		super();
		this.systemProperties = systemProperties;
		this.logger = Logger.getAnonymousLogger();
	}

	@Inject
	public Configuration() {
		super();
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
	 * If systemProperties have been forced using the constructor, it is simply returned.
	 * </p>
	 * <p>
	 * If {@code M2LING_HOME} environment variable is set and configuration file exists and is
	 * correct, we return its content.
	 * </p>
	 * <p>
	 * If {@code M2LING_HOME} environment variable is not set, it is forced to
	 * M2LING_HOME_DEFAULT_ABS_PATH
	 * </p>
	 * <p>
	 * If {@code M2LING_HOME} environment variable is set but the configuration file can't be found,
	 * a default configuration file is written down and the default configuration is returned.
	 * </p>
	 * 
	 * @throw IllegalStateException if the configuration can't be neither read nor created
	 * 
	 * @return the service system properties
	 */
	public Properties getSystemProperties() {
		if (this.systemProperties != null) {
			return this.systemProperties;
		}
		Properties result = null;
		File fileConf = getServiceConfFile();
		if (!fileConf.exists()) {
			String msg = Consts.M2LING_HOME_VARIABLE_NAME + " variable name defined but no corresponding "
					+ fileConf.getAbsolutePath() + " file";
			Properties conf = null;
			try {
				conf = getDefaultConfiguration();
				// Make sure to create full directory structure
				fileConf.getParentFile().mkdirs();
				// Store the configuration in XML, not property to ensure best unicode support
				conf.storeToXML(new FileOutputStream(fileConf), "M2ling service layer configuration file.");
				System.out.println("******* 3 " + logger);

				logger.info(msg + ". Default file created.");
				System.out.println("******* 4");

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
	 * Return service configuration file (actual filesystem existence is not verified)
	 * 
	 * @return service configuration file
	 */
	public File getServiceConfFile() {
		File fileConf = null;
		String m2lingHome = System.getenv(Consts.M2LING_HOME_VARIABLE_NAME);
		if (Strings.isNullOrEmpty(m2lingHome)) {
			m2lingHome = Consts.M2LING_HOME_DEFAULT_ABS_PATH;
			logger.warning(Consts.M2LING_HOME_VARIABLE_NAME + " environment variable not set, default path is used : "
					+ Consts.M2LING_HOME_DEFAULT_ABS_PATH);
		}
		fileConf = new File(m2lingHome + File.separator + CONF_FILENAME);
		return fileConf;
	}

	/**
	 * Return a set of default configuration values.
	 * 
	 * @return a set of default configuration values.
	 */
	public static Properties getDefaultConfiguration() {
		Properties result = new Properties();
		result.put(Environment.DRIVER, "org.h2.Driver");
		result.put(Environment.USER, "sa");
		result.put(Environment.URL, "jdbc:h2:" + Consts.M2LING_HOME_DEFAULT_ABS_PATH + File.separator
				+ Consts.DATABASE_NAME);
		result.put(Environment.PASS, "");
		result.put(Environment.DIALECT, org.hibernate.dialect.H2Dialect.class.getName());
		result.put(PersistenceOptions.CASCADE_POLICY_ON_NON_CONTAINMENT, "REFRESH,PERSIST,MERGE");
		result.put(PersistenceOptions.EAV_MAPPING, "false");
		return result;
	}

	/**
	 * Return a set of default configuration values in test mode.
	 * 
	 * @return a set of default configuration values in test mode.
	 */
	public static Properties getDefaultTestConfiguration() {
		Properties result = new Properties();
		result.put(Environment.DRIVER, "org.h2.Driver");
		result.put(Environment.USER, "sa");
		result.put(Environment.URL, "jdbc:h2:" + Consts.M2LING_HOME_DEFAULT_ABS_PATH + File.separator
				+ Consts.DATABASE_NAME + ";TRACE_LEVEL_FILE=3");
		result.put(Environment.PASS, "");
		result.put(Environment.DIALECT, org.hibernate.dialect.H2Dialect.class.getName());
		result.put(PersistenceOptions.CASCADE_POLICY_ON_NON_CONTAINMENT, "REFRESH,PERSIST,MERGE");
		// Force schema drop
		result.put(Environment.HBM2DDL_AUTO, "create");
		result.put(PersistenceOptions.EAV_MAPPING, "false");
		return result;
	}

}

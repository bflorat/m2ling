/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.service.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.m2ling.common.utils.Consts;
import org.m2ling.common.utils.Utils;

import com.google.common.base.Strings;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * 
 * Load, store and manages m2ling services configuration and configuration.
 * 
 * 
 * @author "Bertrand Florat <bertrand@florat.net>"
 * 
 */
@Singleton
public class ServiceConfiguration {

	Set<SpecificConfiguration> specificConfs = new HashSet<ServiceConfiguration.SpecificConfiguration>(10);

	public interface SpecificConfiguration {
		/**
		 * Return default configuration values. Can be overridden by constants injection.
		 * 
		 * @return default configuration values
		 */
		Properties getDefaultConfiguration();

		/**
		 * Return default configuration values in debug mode. Can be overridden by constants
		 * injection.
		 * 
		 * @return default configuration values in debug mode
		 */
		Properties getDefaultDebugConfiguration();
	}

	public void register(SpecificConfiguration specific) {
		specificConfs.add(specific);
	}

	private Logger logger;

	/** System properties */
	private Properties systemProperties;

	/** Overriding properties */
	private Properties override;

	/**
	 * Build a global configuration for services
	 * @param override overriding properties or null of none
	 * @param logger
	 */
	@Inject
	public ServiceConfiguration(Properties override, Logger logger) {
		super();
		this.logger = logger;
		this.override = override;
	}

	/**
	 * Return the system property value for given key. If the key is unknown, null is returned.
	 * <p>
	 * Search in this order:
	 * <ul>
	 * <li>Overriding property if any</li>
	 * <li>Configuration file if any</li>
	 * <li>Default configuration</li>
	 * </ul>
	 * </p>
	 * 
	 * @param key
	 *           the property name
	 * 
	 * @return the system property value for given key
	 */
	public String getSystemProperty(String key) {
		if (override != null && override.containsKey(key)) {
			return override.getProperty(key);
		}
		return getSystemProperties().getProperty(key);
	}

	/**
	 * Return a sub-set of properties for provided keys
	 * 
	 * @param keys
	 */
	public Properties getSystemProperties(String... keys) {
		Properties out = new Properties();
		for (String key : keys) {
			out.setProperty(key, getSystemProperty(key));
		}
		return out;
	}

	/**
	 * Return the service system properties.
	 * 
	 * <p>
	 * In debug mode, we return default configuration.
	 * </p>
	 * <p>
	 * In regular mode, we read the configuration file (created in the {@code getServiceConfFile()}
	 * method if it doesn't yet exist).
	 * </p>
	 * 
	 * @throw IllegalStateException if the configuration can't be read
	 * 
	 * @return the service system properties
	 */
	private Properties getSystemProperties() {
		if (this.systemProperties != null) {
			return this.systemProperties;
		}
		// In debug mode, do not read the conf file
		if (Utils.isDebugMode()) {
			return getDefaultConfiguration();
		}
		Properties result;
		File fileConf = getServiceConfFile();
		try {
			result = new Properties();
			result.loadFromXML(new FileInputStream(fileConf));
		} catch (Exception e) {
			String msg = "Corrupted configuration file : " + fileConf.getAbsolutePath();
			logger.log(Level.SEVERE, msg, e);
			throw new IllegalStateException(msg, e);
		}
		return result;
	}

	/**
	 * Return service configuration file and create it if it doesn't exist.
	 * 
	 * @return service configuration file
	 * @throw IllegalStateException if configuration file can't be created
	 */
	public File getServiceConfFile() {
		File fileConf = null;
		String m2lingHome = System.getenv(Consts.M2LING_HOME_VARIABLE_NAME);
		if (Strings.isNullOrEmpty(m2lingHome)) {
			m2lingHome = Consts.M2LING_HOME_DEFAULT_ABS_PATH;
			logger.warning(Consts.M2LING_HOME_VARIABLE_NAME + " environment variable not set, default path is used : "
					+ Consts.M2LING_HOME_DEFAULT_ABS_PATH);
		}
		fileConf = new File(m2lingHome + File.separator + Consts.CONF_SERVICE_FILENAME);
		if (!fileConf.exists()) {
			logger.warning(Consts.M2LING_HOME_VARIABLE_NAME + " variable name defined but no corresponding "
					+ fileConf.getAbsolutePath() + " file");
			try {
				// Make sure to create full directory structure
				fileConf.getParentFile().mkdirs();
				Properties conf = getDefaultConfiguration();
				// Store the configuration in XML, not property to ensure best unicode support
				conf.storeToXML(new FileOutputStream(fileConf), "M2ling service layer configuration file.");
				logger.info("Services configuration file created at : " + fileConf.getAbsolutePath());
			} catch (Exception e) {
				logger.log(Level.SEVERE, fileConf.getAbsolutePath() + " file can't be written", e);
				throw new IllegalStateException("Can't create configuration file at : " + fileConf.getAbsolutePath());
			}
		}
		return fileConf;
	}

	/**
	 * Return a set of default configuration values.
	 * 
	 * @return a set of default configuration values.
	 */
	private Properties getDefaultConfiguration() {
		Properties result = new Properties();
		if (Utils.isDebugMode()) {
			// Add debug configurations
			for (SpecificConfiguration specific : specificConfs) {
				result.putAll(specific.getDefaultDebugConfiguration());
			}
		} else {
			// Add regular configurations
			for (SpecificConfiguration specific : specificConfs) {
				result.putAll(specific.getDefaultConfiguration());
			}
		}
		return result;
	}
}
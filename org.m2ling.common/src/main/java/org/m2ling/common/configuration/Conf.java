/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.common.configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Nullable;

import org.m2ling.common.utils.Consts;
import org.m2ling.common.utils.Utils;

import com.google.common.base.Strings;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

/**
 * 
 * Load, store and manages m2ling configuration.
 * 
 * <p>
 * This class is layer-generic as each specific configuration from a layer or another (like
 * PersistenceManagerTeneoImpl for instance) register its own specific configuration into this
 * registry using the {@code Configuration.register()} method.
 * </p>
 * <p>
 * If several layers are installed on a single machine (like it is today : presentation and service
 * layer are packaged in the same war), all layers configurations are mixed into a single
 * configuration file.
 * </p>
 * 
 * 
 * @author "Bertrand Florat <bertrand@florat.net>"
 * 
 */
@Singleton
public class Conf {
	Set<SpecificConfiguration> specificConfs = new HashSet<Conf.SpecificConfiguration>(10);
	private Logger logger;
	/** Conf file properties */
	private Properties fileProperties;
	/** Overriding properties */
	private Properties override;

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

	/**
	 * Build a global configuration
	 * 
	 * @param override
	 *           overriding properties or null of none
	 * @param logger
	 * @param bootstrapSpecificConf
	 *           possible bootstraping specific configuration. Useful to ensure the conf is
	 *           registrated during a complexe application startup.
	 */
	@Inject
	public Conf(Properties override, Logger logger,
			@Nullable @Named("bootstrap") SpecificConfiguration bootstrapSpecificConf) {
		super();
		this.logger = logger;
		this.override = override;
		if (bootstrapSpecificConf != null) {
			register(bootstrapSpecificConf);
		}
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
	 * Return the system property value for given key as booolean
	 * @param key
	 * @return the system property value for given key as booolean
	 */
	public boolean getBoolean(String key) {
		return Boolean.parseBoolean(getSystemProperty(key));
	}

	/**
	 * Return a sub-set of properties for provided keys, a defensive copy of the system properties is
	 * returned.
	 * 
	 * @return a sub-set of properties for provided keys
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
	 * Return the system properties.
	 * 
	 * <p>
	 * In debug mode, we return default configuration.
	 * </p>
	 * <p>
	 * In regular mode, we read the configuration file if required (created in the
	 * {@code getConfigurationFile()} method if it doesn't yet exist).
	 * </p>
	 * <p>
	 * The result (apart from conf file loading) is not cached to allow runtime registration of
	 * specific configurations.
	 * </p>
	 * 
	 * @throw IllegalStateException if the configuration can't be read
	 * 
	 * @return the system properties
	 */
	private Properties getSystemProperties() {
		// In debug mode, do not read the conf file
		if (Utils.isDebugMode()) {
			return getDefaultConfiguration();
		}
		Properties result = getDefaultConfiguration();
		if (fileProperties == null) {
			File fileConf = getConfigurationFile();
			try {
				fileProperties = new Properties();
				fileProperties.loadFromXML(new FileInputStream(fileConf));
			} catch (Exception e) {
				String msg = "Corrupted configuration file : " + fileConf.getAbsolutePath();
				logger.log(Level.SEVERE, msg, e);
				throw new IllegalStateException(msg, e);
			}
		}
		// Override defaults
		if (fileProperties != null) {
			Enumeration<?> names = fileProperties.propertyNames();
			while (names.hasMoreElements()) {
				String name = (String) names.nextElement();
				result.setProperty(name, fileProperties.getProperty(name));
			}
		}
		return result;
	}

	/**
	 * Return m2ling configuration top directory path.
	 * 
	 * @return m2ling configuration top directory path
	 */
	public static String getHomeDirectoryPath() {
		String m2lingHome = System.getenv(Consts.M2LING_HOME);
		if (Strings.isNullOrEmpty(m2lingHome)) {
			m2lingHome = Consts.M2LING_HOME_DEFAULT_ABS_PATH;
		}
		return m2lingHome;
	}

	/**
	 * Return configuration file and create it if it doesn't exist.
	 * 
	 * @return configuration file
	 * @throw IllegalStateException if configuration file can't be created
	 */
	public File getConfigurationFile() {
		File fileConf = null;
		String m2lingHome = getHomeDirectoryPath();
		fileConf = new File(m2lingHome + File.separator + Consts.CONF_FILENAME);
		if (!fileConf.exists()) {
			logger.warning(Consts.M2LING_HOME + " variable name defined but no corresponding "
					+ fileConf.getAbsolutePath() + " file");
			try {
				// Make sure to create full directory structure
				fileConf.getParentFile().mkdirs();
				Properties conf = getDefaultConfiguration();
				// Store the configuration in XML, not property to ensure best unicode support
				conf.storeToXML(new FileOutputStream(fileConf), "M2ling configuration file.");
				logger.info("Configuration file created at : " + fileConf.getAbsolutePath());
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

/**
 * Copyright (C) 2012 Bertrand Florat
 *
 * @author "Bertrand Florat <bertrand@florat.net>"
 */
package org.m2ling.presentation.principles.utils;

import java.util.Locale;
import java.util.Properties;

import org.m2ling.common.configuration.Conf;

import com.google.inject.Singleton;

/**
 * 
 */
/**
 * List of available properties for this implementation. <br/>
 * Overridden values can be injected (for testing purpose).
 * 
 * @author "Bertrand Florat <bertrand@florat.net>"
 * 
 */
@Singleton
public class SpecificConfiguration implements Conf.SpecificConfiguration {
	public static final String CONF_PRESENTATION_DEFAULT_LOCALE = "org.m2ling.presentation.default_locale";

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.m2ling.service.util.ServiceConfiguration.SpecificConfiguration#getDefaultConfiguration ()
	 */
	public Properties getDefaultConfiguration() {
		Properties result = new Properties();
		result.put(CONF_PRESENTATION_DEFAULT_LOCALE, Locale.ENGLISH.getDisplayName());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.m2ling.service.util.ServiceConfiguration.SpecificConfiguration#getDefaultTestConfiguration
	 * ()
	 */
	public Properties getDefaultDebugConfiguration() {
		Properties result = new Properties();
		result.put(CONF_PRESENTATION_DEFAULT_LOCALE, Locale.ENGLISH.getDisplayName());
		return result;
	}
}
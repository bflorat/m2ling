/**
 * Copyright (C) 2012 Bertrand Florat
 *
 * @author "Bertrand Florat <bertrand@florat.net>"
 */
package org.m2ling.presentation.i18n;

import java.util.Locale;
import java.util.ResourceBundle;

import org.m2ling.common.configuration.Conf;
import org.m2ling.common.exceptions.FunctionalException;
import org.m2ling.common.exceptions.TechnicalException;
import org.m2ling.common.utils.UTF8Control;
import org.m2ling.presentation.principles.utils.SpecificConfiguration;

import com.google.common.base.Strings;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * Utility class to get i18n labels
 */
@Singleton
public class Msg {
	private final ResourceBundle bundle;
	private final Locale locale;

	@Inject
	public Msg(Conf conf) {
		locale = new Locale(conf.getSystemProperty(SpecificConfiguration.CONF_PRESENTATION_DEFAULT_LOCALE));
		bundle = ResourceBundle.getBundle("org.m2ling.presentation.i18n.messages", locale, new UTF8Control());
	}
	
	/**
	 * Return global m2ling default locale used (can't be changed until next server startup) 
	 * @return
	 */
	public Locale getDefaultLocale(){
		return this.locale;
	}

	/**
	 * Return translated string for given key.
	 * 
	 * @param key
	 * @return translated string for given key
	 */
	public String get(String key) {
		return bundle.getString(key);
	}

	/**
	 * Provide an HTML human readable and internationalized view of a m2ling exception
	 * 
	 * @param ex
	 *           : the exception to display
	 * @return a human readable and internationalized view of a m2ling exception
	 */
	public String humanMessage(FunctionalException ex) {
		return humanMessage(ex.getCode().name(), ex.getDetails());
	}

	/**
	 * Provide an HTML human readable and internationalized view of a m2ling exception
	 * 
	 * @param ex
	 *           : the exception to display
	 * 
	 * @return a human readable and internationalized view of a m2ling exception
	 */
	public String humanMessage(TechnicalException ex) {
		return humanMessage(ex.getCode().name(), ex.getDetails());
	}

	private String humanMessage(String code, String details) {
		String out = "[" + code + "] ";
		out += get("fcode." + code);
		if (Strings.isNullOrEmpty(details)) {
			out += details;
		}
		return out;
	}
}

/**
 * Copyright (C) 2012 Bertrand Florat
 *
 * @author "Bertrand Florat <bertrand@florat.net>"
 */
package org.m2ling.presentation.i18n;

import java.util.Locale;
import java.util.ResourceBundle;

import org.m2ling.common.exceptions.FunctionalException;
import org.m2ling.common.exceptions.TechnicalException;
import org.m2ling.common.utils.UTF8Control;

import com.google.common.base.Strings;

/**
 * Utility class to get i18n labels
 */
public class Msg {
	private static ResourceBundle bundle = ResourceBundle.getBundle("org.m2ling.presentation.i18n.messages",
			Locale.ENGLISH, new UTF8Control());

	/**
	 * Return translated string for given key.
	 * 
	 * @param key
	 * @return translated string for given key
	 */
	public static String get(String key) {
		return bundle.getString(key);
	}

	/**
	 * Provide an HTML human readable and internationalized view of a m2ling exception
	 * 
	 * @param ex
	 *           : the exception to display
	 * @return a human readable and internationalized view of a m2ling exception
	 */
	public static String humanMessage(FunctionalException ex) {
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
	public static String humanMessage(TechnicalException ex) {
		return humanMessage(ex.getCode().name(), ex.getDetails());
	}

	private static String humanMessage(String code, String details) {
		String out = "[" + code + "] ";
		out += get("fcode." + code);
		if (Strings.isNullOrEmpty(details)) {
			out += details;
		}
		return out;
	}
}

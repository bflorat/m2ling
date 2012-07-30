/**
 * Copyright (C) 2012 Bertrand Florat
 *
 * @author "Bertrand Florat <bertrand@florat.net>"
 */
package org.m2ling.presentation.i18n;

import java.util.Locale;
import java.util.ResourceBundle;

import org.m2ling.common.utils.UTF8Control;

/**
 * Utility class to get i18n labels
 */
public class Msg {
	private static ResourceBundle bundle = ResourceBundle.getBundle("org.m2ling.presentation.i18n.messages",
			Locale.ENGLISH, new UTF8Control());

	/**
	 * Return translated string for given key.
	 * @param key
	 * @return translated string for given key
	 */
	public static String get(String key) {
		return bundle.getString(key);
	}
}

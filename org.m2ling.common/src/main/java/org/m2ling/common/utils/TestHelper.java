/**
 * Copyright (C) 2012 Bertrand Florat
 *
 * @author "Bertrand Florat <bertrand@florat.net>"
 */
package org.m2ling.common.utils;

import java.io.File;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Map;

/**
 * UT helper methods
 */
public class TestHelper {

	/**
	 * Set environment variable (into JVM memory only) Credit :
	 * http://stackoverflow.com/questions/318239/how-do-i-set-environment-variables-from-java
	 */
	public static void setEnv(Map<String, String> newenv) throws RuntimeException {
		try {
			Class<?>[] classes = Collections.class.getDeclaredClasses();
			Map<String, String> env = System.getenv();
			for (Class<?> cl : classes) {
				if ("java.util.Collections$UnmodifiableMap".equals(cl.getName())) {
					Field field = cl.getDeclaredField("m");
					field.setAccessible(true);
					Object obj = field.get(env);
					@SuppressWarnings("unchecked")
					Map<String, String> map = (Map<String, String>) obj;
					map.clear();
					map.putAll(newenv);
				}
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Return the root file storage for temporary UT files.
	 * 
	 * @return the root file storage for temporary UT files
	 */
	public static File getUTStorage() {
		return new File(System.getProperty("java.io.tmpdir") + "/m2ling");
	}

}

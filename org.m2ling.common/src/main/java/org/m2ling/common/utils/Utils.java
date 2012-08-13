/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.common.utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.m2ling.common.exceptions.FunctionalException;

import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.inject.Module;

/**
 * 
 * Various low level and transfers helper methods .
 * 
 * @author "Bertrand Florat <bertrand@florat.net>"
 * 
 */
public class Utils {
	/**
	 * Return a list from an iterable (convenient when using guava Splitter that only return an
	 * iterable for now).
	 * 
	 * @param it
	 *           a iterable
	 * @return a list from an iterable.
	 */
	public static <T> List<T> listFromIterable(Iterable<T> it) {
		{// Controls
			if (it == null) {
				throw new IllegalArgumentException("Null iterable");
			}
		}
		List<T> out = new ArrayList<T>(10);
		for (T t : it) {
			out.add(t);
		}
		return out;
	}

	/**
	 * Return a string list as a comma-separated string.
	 * 
	 * @param list
	 * @return a comma-separated string. If list is empty, "" is returned.
	 * @throws IllegalArgumentException
	 *            if the list is null or if one of its element is null or empty
	 */
	public static String stringListAsString(List<String> list) {
		{// Controls
			if (list == null) {
				throw new IllegalArgumentException("Null list");
			}
			if (list.size() == 0) {
				return "";
			}
		}
		StringBuilder sb = new StringBuilder();
		for (String s : list) {
			if (Strings.isNullOrEmpty(s)) {
				throw new IllegalArgumentException("Null or empty list element : " + s);
			}
			sb.append(s).append(',');
		}
		// Drop last trailing comma
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}

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
					map.putAll(newenv);
				}
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Return whether we are running in debug mode.
	 * 
	 * @return whether we are running in debug mode
	 */
	public static boolean isDebugMode() {
		String dev = System.getenv(Consts.M2LING_DEBUG_VARIABLE_NAME);
		return (!Strings.isNullOrEmpty(dev) && "true".equals(dev));
	}

	/**
	 * Return a list from a string representation.
	 * 
	 * @param string
	 *           the comma-separated string representation
	 * @return a list from a string representation
	 */
	public static List<String> stringListFromString(String string) {
		if ("".equals(string)) {
			return new ArrayList<String>(0);
		}
		Iterable<String> it = Splitter.on(',').trimResults().split(string);
		return listFromIterable(it);
	}

	/**
	 * Test in a list contains duplicate entries
	 * 
	 * @param list
	 * @return whether the list contains duplicates
	 */
	public static boolean containsDup(List<String> list) {
		Set<String> set = new HashSet<String>(list);
		return set.size() < list.size();
	}

	/**
	 * Instantiate provided class using constructor. For tests only as it is a bad practice.
	 * 
	 * @param clazz
	 *           the class to instantiate
	 * @param module
	 *           optional overridden module, null if no module overridden.
	 * @return an instance of clazz
	 * @throws IllegalArgumentException
	 *            if an error occurred
	 */
	@SuppressWarnings("unchecked")
	public static <T> T newInstance(Class<T> clazz, Module module) {
		T result = null;
		try {
			Constructor<?> constructor;
			if (module == null) {
				constructor = clazz.getDeclaredConstructor();
				constructor.setAccessible(true);
				result = (T) constructor.newInstance();
			} else {
				constructor = clazz.getDeclaredConstructor(Module.class);
				constructor.setAccessible(true);
				result = (T) constructor.newInstance(module);
			}
		} catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
		return result;
	}

	/**
	 * Common checks on tags
	 * 
	 * @param tags
	 * @throws FunctionalException
	 *            if one of the tags is too long
	 * @throws FunctionalException
	 *            if a tag duplication is detected
	 * 
	 */
	public static void checkTags(List<String> tags) throws FunctionalException {
		int index = 1;
		for (String tag : tags) {
			if (tag.length() > Consts.MAX_LABEL_SIZE) {
				throw new FunctionalException(FunctionalException.Code.SIZE_EXCEEDED, null, "tag #" + index);
			}
			index++;
		}
		if (Utils.containsDup(tags)) {
			throw new FunctionalException(FunctionalException.Code.DUPLICATES, null, null);
		}
	}

	/**
	 * Generic toString() method that display all declared fields sorted alphabetically/ignore case.
	 * <p>
	 * If a field is not initialized, the string <null> is displayed
	 * </p>
	 * 
	 * @param obj
	 */
	public static String toString(Object obj) {
		StringBuilder sb = new StringBuilder();
		List<Field> fields = Arrays.asList(obj.getClass().getDeclaredFields());
		Collections.sort(fields, new Comparator<Field>() {
			@Override
			public int compare(Field o1, Field o2) {
				return o1.getName().compareToIgnoreCase(o2.getName());
			}
		});
		for (Field field : fields) {
			field.setAccessible(true);
			sb.append(field.getName());
			sb.append('=');
			try {
				if (field.get(obj) == null) {
					sb.append("<null>");
				} else {
					sb.append(field.get(obj).toString());
				}
			} catch (Exception e) {
				// Should not append
				e.printStackTrace();
			}
			sb.append(' ');
		}
		return sb.toString();
	}
	
	/**
	 * Return the provided non null string or "" if null
	 * @param s provided string
	 * @return the provided non null string or "" if null
	 */
	public static String nonull(String s) {
		if (s == null) {
			return "";
		} else {
			return s;
		}
	}
}

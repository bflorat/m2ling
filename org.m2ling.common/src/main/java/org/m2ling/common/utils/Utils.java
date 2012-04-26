/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.common.utils;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

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
	 * Return a list of tags as a String.
	 * 
	 * @param list
	 * @return a list of tags as a String. If list is empty, "" is returned.
	 * @throws IllegalArgumentException
	 *            if the list is null or if one of its element is null or empty
	 */
	public static String tagsAsString(List<String> list) {
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
	 * Return a tag list from a string representation.
	 * 
	 * @param tagsAsString
	 *           the string representation
	 * @return a tag list from a string representation
	 */
	public static List<String> tagsFromString(String tagsAsString) {
		Iterable<String> it = Splitter.on(',').trimResults().split(tagsAsString);
		return listFromIterable(it);
	}

	/**
	 * Instantiate provided class using constructor. For tests only as it is a bad practice.
	 * 
	 * @param clazz
	 *           the class to instantiate
	 * @param module
	 *           optional overidden module, null if no module overidden.
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

}

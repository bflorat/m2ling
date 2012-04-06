/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.utils;

import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Strings;

/**
 * 
 * Various low level and transverse helper methods .
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
			sb.append(',');
		}
		// Drop last trailing comma
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}

}

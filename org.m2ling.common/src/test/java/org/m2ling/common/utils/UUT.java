/**
 * Copyright (C) 2012 Bertrand Florat
 *
 * @author "Bertrand Florat <bertrand@florat.net>"
 */
package org.m2ling.common.utils;

/**
 * Various utilities for UT usage
 */
public class UUT {
	/**
	 * Return a shuffle string of given size
	 * 
	 * @param size
	 *           the size
	 * @return a shuffle string of given size
	 */
	public static final String getShuffleString(int size) {
		StringBuilder sb = new StringBuilder(size);
		while (sb.length() < size) {
			sb.append((int) Math.random() * 10);
		}
		return sb.toString();
	}
	
	/**
	 * Transform a "null" string into null  and "space" into " "
	 * @param s
	 * @return
	 */
	public static final String nul(String s){
		if ("null".equals(s)){
			return null;
		}
		else if ("space".equals(s)){
			return " ";
		}
		return s;
	}
}

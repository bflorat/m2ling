/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.exceptions;

/**
 * Common usage NotFound exception. 
 * 
 * @author "Bertrand Florat <bertrand@florat.net>"
 *
 */
public class NotFoundException extends RuntimeException {

	/**
	 * @param string
	 */
	public NotFoundException(String string) {
		super(string);
	}
	
	/**
	 * @param string
	 */
	public NotFoundException() {
		super();
	}

	private static final long serialVersionUID = -7181953398525733944L;

}

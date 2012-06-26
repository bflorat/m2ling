/**
 * Copyright (C) 2012 Bertrand Florat
 *
 * @author "Bertrand Florat <bertrand@florat.net>"
 */
package org.m2ling.common.exceptions;

import javax.annotation.Nullable;

/**
 * A functional exception caused by faulty arguments for instance. <br>
 * This is a checked exception type.
 */
public class FunctionalException extends Exception {

	private String details;
	private Code code;

	private static final long serialVersionUID = -8262214820561085011L;

	/**
	 * Build a functional exception. <br>
	 * Example : new FunctionalException(Code.TARGET_NOT_FOUND,<a NullPointerException>,<a viewpoint
	 * id>);
	 * 
	 * @param code
	 * @param msg
	 *           message
	 * @param origin
	 *           : any source exception (can be null)
	 * @param detail
	 *           : additional details (can be null)
	 */
	public FunctionalException(Code code, String msg, @Nullable Throwable origin, @Nullable String details) {
		super(msg, origin);
		this.code = code;
		this.details = details;
	}

	public Code getCode() {
		return code;
	}

	public String getDetails() {
		return details;
	}

	public enum Code {
		TARGET_NOT_FOUND,
		SIZE_EXCEEDED,
		DUPLICATES,
		NULL_ARGUMENT,
		ILLEGAL_ARGUMENT
	}

	/**
	 * Return a derivated string mixing message and details.
	 * @return a derivated string mixing message and details
	 */
	public String getDetailedMessage() {
		StringBuilder sb = new StringBuilder(getMessage());
		if (details != null) {
			sb.append(" / ");
			sb.append(details);
		}
		return sb.toString();
	}

}

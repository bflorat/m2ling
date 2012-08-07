/**
 * Copyright (C) 2012 Bertrand Florat
 *
 * @author "Bertrand Florat <bertrand@florat.net>"
 */
package org.m2ling.common.exceptions;

import javax.annotation.Nullable;

/**
 * A technical exception caused by a database downtime or an internal bug for instance. <br>
 * This is a unchecked exception as clients can't recover it most of the time.
 */
public class TechnicalException extends RuntimeException {
	private static final long serialVersionUID = -433556787666L;
	private String details;
	private Code code;

	/**
	 * Build a technical exception. <br>
	 * Example : new TechnicalException(Code.TRANSACTION_FAILED,<a JTS exception>,<a viewpoint id>); <br>
	 * Note that the internalized label associated with the error is provided in the presentation
	 * layer. In case of API-style call, the label will be available from the API documentation.
	 * 
	 * @param code
	 * @param origin
	 *           : any source exception (can be null)
	 * @param detail
	 *           : additional details (can be null)
	 */
	public TechnicalException(Code code, @Nullable Throwable origin, @Nullable String details) {
		super("Technical error code " + code.name(), origin);
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
		UNKNOWN, TRANSACTION_FAILED, NOT_YET_IMPLEMENTED, ILLEGAL_STATE
	}

	/**
	 * Return a derivated string mixing message and details.
	 * 
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

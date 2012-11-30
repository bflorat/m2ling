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
	 * Example : new FunctionalException(Code.TARGET_NOT_FOUND,<a viewpoint id>); <br>
	 * Note that the internalized label associated with the error is provided in the presentation
	 * layer. In case of API-style call, the label will be available from the API documentation.
	 * 
	 * @param code
	 * @param origin
	 *           : any source exception (can be null)
	 * @param detail
	 *           : additional details (can be null)
	 */
	public FunctionalException(Code code, @Nullable Throwable origin, @Nullable String details) {
		super("Functional error code " + code.name() + " /details: " + details, origin);
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
		VOID_ARGUMENT,
		ILLEGAL_ARGUMENT,
		TAGS_NOT_SUPPORTED,
		TAGS_SEPARATOR,
		INVALID_STATUS,
		INVALID_REFERENCE_TYPE,
		STATUS_USED,
		VP_IN_USE,
		BOUND_TYPE_BOUND,
		INVALID_TYPE,
		LOCAL_BINDING,
		WRONG_IF,
		NULL_BOUND_TYPE_ENUMERATION,
		INVALID_FORMAT,
		CT_EXISTING_COMP,
		CT_EXISTING_BINDING,
		CT_INSUFFISENT_IF,
		CT_REFERENCE_IN_USE,
		CT_CANNOT_CHANGE_BINDING,
		NONE_TARGET,
		LT_EXISTING_LINK,
		NONE_SOURCES_TYPES,
		NONE_DEST_TYPES,
		LT_ILLEGAL_ACCESS_TYPE,
		LT_ILLEGAL_TEMPORALITY,
		COMP_ILLEGAL_REFERENCE,
		COMP_REF_IN_USE,
		COMP_EXISTING_INSTANCE,
		COMP_ILLEGAL_BINDING,
		COMP_EXISTING_BINDING,
		COMP_MISSING_BINDING,	
		LINK_IN_USE,
		LINK_ILLEGAL_SOURCE_OR_DEST,
		LI_ILLEGAL_SOURCE_OR_DEST
		
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

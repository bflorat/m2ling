/**
 * Copyright (C) Bertrand Florat
 */
package org.m2ling.dto.core;

/**
 * Tag DTO object used between layers.
 * 
 * @author bflorat
 */
public class ViewPointDTO {

	private final String name;
	private final String[] tags;

	ViewPointDTO(final String name) {
		this.name = name;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

}

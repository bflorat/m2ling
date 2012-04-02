/**
 * Copyright (C) Bertrand Florat
 */
package org.m2ling.dto.core;

/**
 * Common factory producing core package DTOs. All DTO classes are immutable so
 * defenssive copy are discouraged.
 * 
 * @author bflorat
 * 
 */
public class CoreDTOFactory {

	/**
	 * Create a new viewpoint DTO from given parameters.
	 * 
	 * @param name
	 *            the VP name
	 * @return a VP DTO containing all useful VP data.
	 */
	public static ViewPointDTO newViewPointDTO(String name) {
		return new ViewPointDTO(name);
	}

}

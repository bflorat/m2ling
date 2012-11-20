/**
 * Copyright (C) 2012 Bertrand Florat 
 */
package org.m2ling.service.models;

import java.util.List;

import org.m2ling.common.dto.core.ViewDTO;
import org.m2ling.common.exceptions.FunctionalException;
import org.m2ling.common.exceptions.TechnicalException;
import org.m2ling.common.soa.Context;

/**
 * General contract for views services implementations.
 * <p>
 * All the methods take a context argument containing credentials and any useful technical data
 * <p>
 * All the methods can throw a TechnicalException in case of technical issue.
 * </p>
 * <p>
 * All the methods can throw an IllegalAccessException if current user has not the authorization to
 * access the viewpoint.
 * </p>
 */
public interface ViewService {
	/**
	 * Update an existing view given a view DTO.
	 * 
	 * @param vDTO
	 *           the view DTO
	 * @throws FunctionalException
	 *            if the view doesn't exist or if one of the DTO entry is faulty
	 */
	void updateView(Context context, ViewDTO vDTO) throws FunctionalException;

	/**
	 * Create a new view given a view DTO.
	 * 
	 * @param vDTO
	 *           the view DTO
	 * @throws FunctionalException
	 *            if the DTO entry is faulty
	 */
	void createView(Context context, ViewDTO vDTO) throws FunctionalException;

	/**
	 * Return all available views given user authorization and realm. If none views are available, a
	 * void list is returned.
	 * <p>
	 * Views are sorted by name.
	 * </p>
	 * 
	 * @return all available views DTO for current user.
	 * @throws TechnicalException  in case of issue
	 * @throws FunctionalException if id is null or void
	 */
	List<ViewDTO> getAllViews(Context context) throws FunctionalException, TechnicalException;

	/**
	 * Return the view DTO given an ID if it exist, null otherwise.
	 * 
	 * @return the view DTO given an ID if it exist, null otherwise
	 * @throws FunctionalException
	 *            if id is null or void
	 * 
	 */
	ViewDTO getViewByID(Context context, String id) throws FunctionalException;

	/**
	 * Drop the given view if it exists.
	 * 
	 * @param id
	 *           the view id
	 * @throws FunctionalException
	 *            if view doesn't exist.
	 */
	void deleteView(Context context, String id) throws FunctionalException;
}

/**
 * Copyright (C) 2012 Bertrand Florat 
 */
package org.m2ling.service.principles;

import java.util.List;

import org.m2ling.common.dto.core.ViewPointDTO;
import org.m2ling.common.exceptions.FunctionalException;
import org.m2ling.common.soa.Context;

/**
 * General contract for viewpoints services implementations.
 * <p>
 * All the methods take a context argument containing credentials and any useful technical data
 * <p>
 * All the methods can throw a TechnicalException in case of technical issue.
 * </p>
 * <p>
 * All the methods cab throw an IllegalAccessException if current user has not the authorization to
 * access the viewpoint.
 * </p>
 */
public interface ViewPointService {
	/**
	 * Update an existing view point given a view point given a viewpoint DTO.
	 * 
	 * @param vpDTO
	 *           the view point DTO
	 * @throws FunctionalException
	 *            if the viewpoint doesn't exist or if one of the DTO entry is faulty
	 */
	void updateViewPoint(Context context, ViewPointDTO vpDTO) throws FunctionalException;

	/**
	 * Create a new view point given a viewpoint DTO.
	 * 
	 * @param vpDTO
	 *           the view point DTO
	 * @throws FunctionalException
	 *            if a viewpoint already exist with the provided name or if one of the DTO entry is
	 *            faulty
	 */
	void createViewPoint(Context context, ViewPointDTO vpDTO) throws FunctionalException;

	/**
	 * Return all available viewpoints given user authorization and realm. If none viewpoints are
	 * available, a void list is returned.
	 * <p>
	 * Viewpoints are sorted by name.
	 * </p>
	 * 
	 * @return all available viewpoints DTO for current user.
	 */
	List<ViewPointDTO> getAllViewPoints(Context context);

	/**
	 * Return the viewpoint DTO given a VP name (unique) if it exist, null otherwise.
	 * 
	 * @return the viewpoint DTO given a VP name (unique) if it exist, null otherwise
	 */
	ViewPointDTO getViewPointByName(Context context, String name);

	/**
	 * Return the viewpoint DTO given an ID if it exist, null otherwise.
	 * 
	 * @return the viewpoint DTO given an ID if it exist, null otherwise
	 * 
	 */
	ViewPointDTO getViewPointByID(Context context, String id);

	/**
	 * Drop the given viewpoint if it exists.
	 * 
	 * @param vpDTO
	 *           the view point DTO
	 * @throws FunctionalException
	 *            if viewpoint doesn't exist.
	 */
	void deleteViewPoint(Context context, ViewPointDTO vpDTO) throws FunctionalException;
}

package org.m2ling.service.principles;

import java.util.List;

import org.m2ling.common.dto.core.ViewPointDTO;

/**
 * Copyright (C) 2012 Bertrand Florat General contract for viewpoints services implementations
 */

public interface ViewPointService {
	/**
	 * Update an existing view point given a view point given a viewpoint DTO. Note that some
	 * uncatched exceptions can occur for example if the viewpoint cannot be persisted. The method
	 * require the associated authorization to be called.
	 * 
	 * @param vpDTO
	 *           the view point DTO
	 * @throws IllegalStateException
	 *            if the viewpoint doesn't exist.
	 * @throws IllegalAccessException
	 *            if the caller has not required authorization to call this method.
	 */
	void updateViewPoint(ViewPointDTO vpDTO);

	/**
	 * Create a new view point given a viewpoint DTO. Note that some uncatched exceptions can occur
	 * for example if the viewpoint cannot be persisted. The method require the associated
	 * authorization to be called.
	 * 
	 * @param vpDTO
	 *           the view point DTO
	 * @throws IllegalStateException
	 *            if the viewpoint already exist if a viewpoint already exist with the provided name
	 * @throws IllegalAccessException
	 *            if the caller has not required authorization to call this method.
	 */
	void createViewPoint(ViewPointDTO vpDTO);

	/**
	 * Return all available viewpoints given user authorization and realm. If none viewpoints are
	 * available, a void list is returned.
	 * 
	 * @return all available viewpoints DTO for current user.
	 */
	List<ViewPointDTO> getAllViewPoints();

	/**
	 * Return the viewpoint DTO given a VP name (unique) if it exist, null otherwise.
	 * 
	 * @throws IllegalAccessException
	 *            if current user has not the authorization to access the viewpoint.
	 */
	ViewPointDTO getViewPointByName(String name);

	/**
	 * Drop the given viewpoint if it exists. 
	 * @param vpDTO the view point DTO
	 * 
	 * @throws IllegalArgumentException
	 *            if viewpoint doesn't exist.
	 */
	void deleteViewPoint(ViewPointDTO vpDTO);

}

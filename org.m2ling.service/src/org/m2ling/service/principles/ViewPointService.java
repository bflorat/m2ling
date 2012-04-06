package org.m2ling.service.principles;

import java.util.List;

import org.m2ling.dto.core.ViewPointDTO;

/**
 * Copyright (C) 2012 Bertrand Florat General contract for viewpoints services
 * implementations
 */

public interface ViewPointService {
	/**
	 * Given a view point given a viewpoint DTO. Note that some uncatched
	 * exceptions can occur for example if the viewpoint cannot be persisted.
	 * The method require the associated authorization to be called.
	 * 
	 * @param vp
	 *            the view point DTO
	 * @throws IllegalStateException
	 *             if the viewpoint already exist.
	 * @throws IllegalAccessException
	 *             if the caller has not required authorization to call this
	 *             method.
	 */
	void createViewPoint(ViewPointDTO vpDTO);

	/**
	 * Return all available viewpoints given user authorization and realm. If
	 * none viewpoints are available, a void list is returned.
	 * 
	 * @return all available viewpoints DTO for current user.
	 */
	List<ViewPointDTO> getAllViewPoints();

	/**
	 * Return the viewpoint DTO given a VP name (unique) if it exist, null
	 * otherwise.
	 * 
	 * @throws IllegalAccessException
	 *             if current user has not the authorization to access the
	 *             viewpoint.
	 */
	ViewPointDTO getViewPointByName(String name);

}

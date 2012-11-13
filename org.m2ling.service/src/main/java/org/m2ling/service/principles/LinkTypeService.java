/**
 * Copyright (C) 2012 Bertrand Florat 
 */
package org.m2ling.service.principles;

import java.util.List;

import org.m2ling.common.dto.core.ComponentTypeDTO;
import org.m2ling.common.dto.core.LinkTypeDTO;
import org.m2ling.common.exceptions.FunctionalException;
import org.m2ling.common.soa.Context;

/**
 * General contract for link types implementations.
 * <p>
 * All the methods can throw a TechnicalException in case of technical issue.
 * </p>
 * <p>
 * All the methods can throw an IllegalAccessException if current user has not the authorization to
 * access the viewpoint.
 * </p>
 */
public interface LinkTypeService {
	/**
	 * Update an existing link type.
	 * 
	 * @param ltDTO
	 *           the link type
	 * @throws FunctionalException
	 *            if the lt doesn't exist or if one of the lt DTO entry is faulty
	 */
	void updateLT(Context context, LinkTypeDTO ltDTO) throws FunctionalException;

	/**
	 * Create a new link type for provided viewpoint.
	 * 
	 * @param ltDTO
	 *           the link type
	 * @throws FunctionalException
	 *            if the viewpoint doesn't exist
	 * @throws FunctionalException
	 *            if the DTO entry is faulty
	 */
	void createLT(Context context, LinkTypeDTO ltDTO) throws FunctionalException;

	/**
	 * Return an alphabetically ordered list of available LT given a viewpoint ID. If none LT is
	 * available, a void list is returned.
	 * 
	 * <p>
	 * LT are sorted by name.
	 * </p>
	 * 
	 * 
	 * @param viewpoint
	 * @throws FunctionalException
	 *            if the viewpoint doesn't exist
	 * @return all available LT for given viewpoint
	 */
	List<LinkTypeDTO> getAllLT(Context context, String vp) throws FunctionalException;

	/**
	 * Return the LT DTO given an ID if it exist, null otherwise.
	 * 
	 * @return the viewpoint DTO given an ID if it exist, null otherwise
	 * @throws FunctionalException
	 *            id id is null or void
	 * 
	 */
	LinkTypeDTO getLTByID(Context context, String id) throws FunctionalException;

	/**
	 * Drop the given LT if it exists.
	 * 
	 * @param id
	 *           the LT DTO
	 * 
	 * @throws FunctionalException
	 *            if id is null or void
	 * @throws FunctionalException
	 *            if the LT doesn't exist.
	 */
	void deleteLT(Context context, LinkTypeDTO dto) throws FunctionalException;
}

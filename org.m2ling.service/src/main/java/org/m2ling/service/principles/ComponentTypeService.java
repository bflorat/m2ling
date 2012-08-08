/**
 * Copyright (C) 2012 Bertrand Florat 
 */
package org.m2ling.service.principles;

import java.util.List;

import org.m2ling.common.dto.core.ComponentTypeDTO;
import org.m2ling.common.exceptions.FunctionalException;
import org.m2ling.common.soa.Context;

/**
 * General contract for component types implementations.
 * <p>
 * All the methods can throw a TechnicalException in case of technical issue.
 * </p>
 * <p>
 * All the methods cab throw an IllegalAccessException if current user has not the authorization to
 * access the viewpoint.
 * </p>
 */
public interface ComponentTypeService {
	/**
	 * Update an existing component type.
	 * 
	 * @param ctDTO
	 *           the component type
	 * @throws FunctionalException
	 *            if the ct doesn't exist or if one of the ct DTO entry is faulty
	 */
	void updateCT(Context context, ComponentTypeDTO ctDTO) throws FunctionalException;

	/**
	 * Create a new component type for provided viewpoint.
	 * 
	 * @param ctDTO
	 *           the component type
	 * @throws FunctionalException
	 *            if the viewpoint doesn't exist
	 * @throws FunctionalException
	 *            if a ct already exist with id or name or if one of the DTO entry is faulty
	 */
	void createCT(Context context, ComponentTypeDTO ctDTO) throws FunctionalException;

	/**
	 * Return all available CT given a viewpoint ID. If none CT is available, a void list is
	 * returned.
	 * 
	 * <p>
	 * CT are sorted by name.
	 * </p>
	 * 
	 * 
	 * @param viewpoint
	 * @throws FunctionalException
	 *            if the viewpoint doesn't exist
	 * @return all available CT for given viewpoint
	 */
	List<ComponentTypeDTO> getAllCT(Context context, String vp) throws FunctionalException;

	/**
	 * Drop the given CT if it exists.
	 * 
	 * @param ct
	 *           the CT DTO
	 * @throws FunctionalException
	 *            if the CT doesn't exist.
	 */
	void deleteCT(Context context, ComponentTypeDTO ct) throws FunctionalException;
}

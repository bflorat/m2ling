/**
 * Copyright (C) 2012 Bertrand Florat 
 */
package org.m2ling.service.models;

import java.util.List;

import org.m2ling.common.dto.core.ComponentInstanceDTO;
import org.m2ling.common.exceptions.FunctionalException;
import org.m2ling.common.soa.Context;

/**
 * General contract for component instance (CI) implementations.
 * <p>
 * All the methods can throw a TechnicalException in case of technical issue.
 * </p>
 * <p>
 * All the methods can throw an IllegalAccessException if current user has not the authorization to
 * access the view.
 * </p>
 */
public interface ComponentInstanceService {
	/**
	 * Update an existing CI.
	 * 
	 * @param ciDTO
	 *           the CI data
	 * @throws FunctionalException
	 *            if the CI doesn't exist or if one of the CI DTO entry is faulty
	 */
	void updateCI(Context context, ComponentInstanceDTO ciDTO) throws FunctionalException;

	/**
	 * Create a new CI for provided view.
	 * 
	 * @param ciDTO
	 *           the CI
	 * @throws FunctionalException
	 *            if the view doesn't exist
	 * @throws FunctionalException
	 *            if the DTO entry is faulty
	 */
	void createCI(Context context, ComponentInstanceDTO ciDTO) throws FunctionalException;

	/**
	 * Return an alphabetically ordered list of available CIs given a view ID. If none CI is
	 * available, a void list is returned.
	 * 
	 * <p>
	 * CIs are sorted by name.
	 * </p>
	 * 
	 * 
	 * @param vID
	 *           the view ID
	 * @throws FunctionalException
	 *            if the viewpoint doesn't exist
	 * @return all available CIs for given viewpoint
	 */
	List<ComponentInstanceDTO> getAllCI(Context context, String vID) throws FunctionalException;

	/**
	 * Return the CI DTO given an ID if it exist, null otherwise.
	 * 
	 * @return the CI DTO given an ID if it exist, null otherwise
	 * @throws FunctionalException
	 *            if id is null or void
	 * 
	 */
	ComponentInstanceDTO getCIByID(Context context, String id) throws FunctionalException;

	/**
	 * Drop the given CI if it exists.
	 * 
	 * @param id
	 *           the CI id
	 * 
	 * @throws FunctionalException
	 *            if id is null or void
	 * @throws FunctionalException
	 *            if the Component doesn't exist.
	 */
	void deleteCI(Context context, String id) throws FunctionalException;
}

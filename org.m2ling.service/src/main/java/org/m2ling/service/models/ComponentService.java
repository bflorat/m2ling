/**
 * Copyright (C) 2012 Bertrand Florat 
 */
package org.m2ling.service.models;

import java.util.List;

import org.m2ling.common.dto.core.ComponentDTO;
import org.m2ling.common.exceptions.FunctionalException;
import org.m2ling.common.soa.Context;

/**
 * General contract for component implementations.
 * <p>
 * All the methods can throw a TechnicalException in case of technical issue.
 * </p>
 * <p>
 * All the methods can throw an IllegalAccessException if current user has not the authorization to
 * access the view.
 * </p>
 */
public interface ComponentService {
	/**
	 * Update an existing component.
	 * 
	 * @param compDTO
	 *           the component
	 * @throws FunctionalException
	 *            if the component doesn't exist or if one of the component DTO entry is faulty
	 */
	void updateComponent(Context context, ComponentDTO compDTO) throws FunctionalException;

	/**
	 * Create a new component for provided view.
	 * 
	 * @param compDTO
	 *           the component
	 * @param vID
	 *           view ID
	 * @throws FunctionalException
	 *            if the view doesn't exist
	 * @throws FunctionalException
	 *            if the DTO entry is faulty
	 */
	void createComponent(Context context, ComponentDTO compDTO, String vID) throws FunctionalException;

	/**
	 * Return an alphabetically ordered list of available Component given a view ID. If none
	 * Component is available, a void list is returned.
	 * 
	 * <p>
	 * Components are sorted by name.
	 * </p>
	 * 
	 * 
	 * @param vID
	 *           the view ID
	 * @throws FunctionalException
	 *            if the viewpoint doesn't exist
	 * @return all available Component for given viewpoint
	 */
	List<ComponentDTO> getAllComponents(Context context, String vID) throws FunctionalException;

	/**
	 * Return the Component DTO given an ID if it exist, null otherwise.
	 * 
	 * @return the Component DTO given an ID if it exist, null otherwise
	 * @throws FunctionalException
	 *            id id is null or void
	 * 
	 */
	ComponentDTO getComponentByID(Context context, String id) throws FunctionalException;

	/**
	 * Drop the given Component if it exists.
	 * 
	 * @param id
	 *           the Component DTO
	 * 
	 * @throws FunctionalException
	 *            if id is null or void
	 * @throws FunctionalException
	 *            if the Component doesn't exist.
	 */
	void deleteComponent(Context context, ComponentDTO dto) throws FunctionalException;
}

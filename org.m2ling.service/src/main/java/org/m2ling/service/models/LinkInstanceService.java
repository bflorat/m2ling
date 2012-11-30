/**
 * Copyright (C) 2012 Bertrand Florat 
 */
package org.m2ling.service.models;

import java.util.List;

import org.m2ling.common.dto.core.LinkInstanceDTO;
import org.m2ling.common.exceptions.FunctionalException;
import org.m2ling.common.soa.Context;

/**
 * General contract for link instances implementations.
 * <p>
 * All the methods can throw a TechnicalException in case of technical issue.
 * </p>
 * <p>
 * All the methods can throw an IllegalAccessException if current user has not the authorization to
 * access the viewpoint.
 * </p>
 */
public interface LinkInstanceService {
	/**
	 * Update an existing LI.
	 * 
	 * @param dto
	 *           the LI
	 * @throws FunctionalException
	 *            if the LI doesn't exist or if one of the link DTO entry is faulty
	 */
	void updateLinkInstance(Context context, LinkInstanceDTO dto) throws FunctionalException;

	/**
	 * Create a new LI for provided view.
	 * 
	 * @param dto
	 *           the LI
	 * @throws FunctionalException
	 *            if the viewpoint doesn't exist
	 * @throws FunctionalException
	 *            if the DTO entry is faulty
	 */
	void createLinkInstance(Context context, LinkInstanceDTO dto) throws FunctionalException;
	

	/**
	 * Return an alphabetically ordered list of available LI given a view ID. If none LI is
	 * available, a void list is returned.
	 * 
	 * <p>
	 * LI are sorted by name.
	 * </p>
	 * 
	 * 
	 * @param vID
	 *           : view ID
	 * @throws FunctionalException
	 *            if the viewpoint doesn't exist
	 * @return all available links for given viewpoint
	 */
	List<LinkInstanceDTO> getAllLinkInstances(Context context, String vID) throws FunctionalException;

	/**
	 * Return the LI DTO given an ID if it exist, null otherwise.
	 * 
	 * @return the viewpoint DTO given an ID if it exist, null otherwise
	 * @throws FunctionalException
	 *            id id is null or void
	 * 
	 */
	LinkInstanceDTO getLinkInstanceByID(Context context, String id) throws FunctionalException;

	/**
	 * Drop the given LI if it exists.
	 * 
	 * @param id
	 *           the LI id
	 * 
	 * @throws FunctionalException
	 *            if id is null or void
	 * @throws FunctionalException
	 *            if the Link doesn't exist.
	 */
	void deleteLinkInstance(Context context, String id) throws FunctionalException;
}

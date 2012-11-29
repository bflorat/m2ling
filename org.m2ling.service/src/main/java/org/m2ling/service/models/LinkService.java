/**
 * Copyright (C) 2012 Bertrand Florat 
 */
package org.m2ling.service.models;

import java.util.List;

import org.m2ling.common.dto.core.LinkDTO;
import org.m2ling.common.exceptions.FunctionalException;
import org.m2ling.common.soa.Context;

/**
 * General contract for links implementations.
 * <p>
 * All the methods can throw a TechnicalException in case of technical issue.
 * </p>
 * <p>
 * All the methods can throw an IllegalAccessException if current user has not the authorization to
 * access the viewpoint.
 * </p>
 */
public interface LinkService {
	/**
	 * Update an existing link.
	 * 
	 * @param linkDTO
	 *           the link
	 * @throws FunctionalException
	 *            if the link doesn't exist or if one of the link DTO entry is faulty
	 */
	void updateLink(Context context, LinkDTO linkDTO) throws FunctionalException;

	/**
	 * Create a new link type for provided viewpoint.
	 * 
	 * @param linkDTO
	 *           the link type
	 * @throws FunctionalException
	 *            if the viewpoint doesn't exist
	 * @throws FunctionalException
	 *            if the DTO entry is faulty
	 */
	void createLink(Context context, LinkDTO linkDTO) throws FunctionalException;

	/**
	 * Return an alphabetically ordered list of available links given a view ID. If none link is
	 * available, a void list is returned.
	 * 
	 * <p>
	 * Links are sorted by name.
	 * </p>
	 * 
	 * 
	 * @param vID
	 *           : view ID
	 * @throws FunctionalException
	 *            if the viewpoint doesn't exist
	 * @return all available links for given viewpoint
	 */
	List<LinkDTO> getAllLinks(Context context, String vID) throws FunctionalException;

	/**
	 * Return the Link DTO given an ID if it exist, null otherwise.
	 * 
	 * @return the viewpoint DTO given an ID if it exist, null otherwise
	 * @throws FunctionalException
	 *            id id is null or void
	 * 
	 */
	LinkDTO getLinkByID(Context context, String id) throws FunctionalException;

	/**
	 * Drop the given Link if it exists.
	 * 
	 * @param id
	 *           the Link id
	 * 
	 * @throws FunctionalException
	 *            if id is null or void
	 * @throws FunctionalException
	 *            if the Link doesn't exist.
	 */
	void deleteLink(Context context, String id) throws FunctionalException;
}

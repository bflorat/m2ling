/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.service.common;

import java.util.List;

import org.m2ling.common.dto.core.AbstractCommonDTO;
import org.m2ling.common.dto.core.AccessType;
import org.m2ling.common.dto.core.HasNameAndIdDTO;
import org.m2ling.common.exceptions.FunctionalException;
import org.m2ling.common.utils.Consts;
import org.m2ling.common.utils.Utils;
import org.m2ling.domain.core.Type;
import org.m2ling.domain.core.ViewPoint;
import org.m2ling.persistence.PersistenceManager;
import org.m2ling.service.util.DomainExplorer;
import org.m2ling.service.util.DTOConverter;

/**
 * Common code for service checkers
 * 
 * @author "Bertrand Florat <bertrand@florat.net>"
 * 
 */
public abstract class ServiceChecker {
	protected ReferenceHelper refHelper;

	/** The persistence manager bringing persistence features to the services */
	protected PersistenceManager pmanager;

	/** DTO to domain object converter */
	protected DTOConverter.FromDTO fromDTO;

	/** Utilities class */
	protected DomainExplorer explorer;

	protected ServiceChecker(PersistenceManager pm, DomainExplorer explorer, DTOConverter.FromDTO fromDTO,
			ReferenceHelper refHelper) {
		this.explorer = explorer;
		this.fromDTO = fromDTO;
		this.pmanager = pm;
		this.refHelper = refHelper;
	}

	protected void checkNullDTO(final AbstractCommonDTO dto) throws FunctionalException {
		if (dto == null) {
			throw new FunctionalException(FunctionalException.Code.NULL_ARGUMENT, null, "(name)");
		}
	}

	protected void checkNameWhenRequired(final AbstractCommonDTO dto, AccessType access) throws FunctionalException {
		if (access == AccessType.CREATE || access == AccessType.UPDATE) {
			if (dto.getName() == null) {
				throw new FunctionalException(FunctionalException.Code.NULL_ARGUMENT, null, "(name)");
			}
			if (dto.getName() != null && "".equals(dto.getName().trim())) {
				throw new FunctionalException(FunctionalException.Code.VOID_ARGUMENT, null, "(name)");
			}
			checkNameWhenNotRequired(dto, access);
		}
	}

	protected void checkNameWhenNotRequired(final AbstractCommonDTO dto, AccessType access) throws FunctionalException {
		if (access == AccessType.CREATE || access == AccessType.UPDATE) {
			if (dto.getName() != null && dto.getName().length() > Consts.MAX_LABEL_SIZE) {
				throw new FunctionalException(FunctionalException.Code.SIZE_EXCEEDED, null, "(name)");
			}
		}
	}

	/**
	 * Check id format and detect dup items
	 * 
	 * @param dto
	 * @throws FunctionalException
	 */
	protected void checkIdFormat(final AbstractCommonDTO dto, AccessType access) throws FunctionalException {
		// Check id
		if (dto.getId() == null) {
			throw new FunctionalException(FunctionalException.Code.NULL_ARGUMENT, null, "(id)");
		}
		if (Utils.isNullOrEmptyAfterTrim(dto.getId().trim())) {
			throw new FunctionalException(FunctionalException.Code.VOID_ARGUMENT, null, "(id)");
		}
		if (dto.getId().length() > 100) {
			throw new FunctionalException(FunctionalException.Code.SIZE_EXCEEDED, null, "(id)");
		}
	}

	/**
	 * Detect dup or unexisting items
	 * 
	 * @param dto
	 * @throws FunctionalException
	 */
	protected void checkItemExistence(final AbstractCommonDTO dto, AccessType access) throws FunctionalException {
		if (access == AccessType.CREATE) {
			// Check for existing item with the same id
			if (explorer.getItemByTypeAndID(getManagedType(), dto.getId()) != null) {
				throw new FunctionalException(FunctionalException.Code.DUPLICATES, null, "id=" + dto.getId());
			}
		}
		if (access == AccessType.DELETE || access == AccessType.READ) {
			if (explorer.getItemByTypeAndID(getManagedType(), dto.getId()) == null) {
				throw new FunctionalException(FunctionalException.Code.TARGET_NOT_FOUND, null, "id=" + dto.getId());
			}
		}
	}

	/**
	 * Check comment
	 * 
	 * @param comment
	 *           the provided comment
	 * @throws FunctionalException
	 *            if the comment has a wrong format
	 */
	protected void checkComment(final String comment) throws FunctionalException {
		if (comment != null && comment.length() > Consts.MAX_TEXT_SIZE) {
			throw new FunctionalException(FunctionalException.Code.SIZE_EXCEEDED, null, "(comment)");
		}
	}

	/**
	 * Check description when a value is not mandatory
	 * 
	 * @param description
	 *           the provided description
	 * @throws FunctionalException
	 *            if the description has a wrong format
	 */
	protected void checkDescriptionNotMandatory(final String description) throws FunctionalException {
		if (description != null && description.length() > Consts.MAX_TEXT_SIZE) {
			throw new FunctionalException(FunctionalException.Code.SIZE_EXCEEDED, null, "(description)");
		}
	}

	/**
	 * Check description when a non null/void value is mandatory
	 * 
	 * @param description
	 *           the provided description
	 * @throws FunctionalException
	 *            if the description has a wrong format
	 */
	protected void checkDescriptionMandatory(final String description) throws FunctionalException {
		if (description == null) {
			throw new FunctionalException(FunctionalException.Code.NULL_ARGUMENT, null, "(description)");
		}
		if ("".equals(description.trim())) {
			throw new FunctionalException(FunctionalException.Code.VOID_ARGUMENT, null, "(description)");
		}
		checkDescriptionNotMandatory(description);
	}

	/**
	 * Checks on tags
	 * 
	 * @param tags
	 * @throws FunctionalException
	 *            if the tags rules are not satisfied
	 * 
	 */
	protected void checkTags(List<String> tags) throws FunctionalException {
		if (tags == null) {
			throw new FunctionalException(FunctionalException.Code.NULL_ARGUMENT, null, "(tags)");
		}
		int index = 1;
		for (String tag : tags) {
			if (tag == null) {
				throw new FunctionalException(FunctionalException.Code.NULL_ARGUMENT, null, "tag #" + index);
			}
			if (Utils.isNullOrEmptyAfterTrim(tag.trim())) {
				throw new FunctionalException(FunctionalException.Code.VOID_ARGUMENT, null, "tag #" + index);
			}
			if (tag.length() > Consts.MAX_LABEL_SIZE) {
				throw new FunctionalException(FunctionalException.Code.SIZE_EXCEEDED, null, "tag #" + index);
			}
			index++;
		}
		if (Utils.containsDup(tags)) {
			throw new FunctionalException(FunctionalException.Code.DUPLICATES, null, null);
		}
	}

	/**
	 * Check the status. null is allowed
	 * 
	 * @param vp
	 *           the viewpoint associated with the item whose status is checked
	 * @param status
	 *           the status to check
	 * @throws FunctionalException
	 *            if the status is not in VP status literal list
	 */
	protected void checkStatus(HasNameAndIdDTO vp, String status) throws FunctionalException {
		if (vp == null || vp.getId() == null) {
			throw new FunctionalException(FunctionalException.Code.NULL_ARGUMENT, null, "(viewpoint)");
		}
		ViewPoint storedVP = explorer.getViewPointByID(vp.getId());
		if (storedVP == null) {
			throw new FunctionalException(FunctionalException.Code.TARGET_NOT_FOUND, null, "Viewpoint id=" + vp.getId());
		}
		if (storedVP.getStatusLiterals() != null && status != null && !storedVP.getStatusLiterals().contains(status)) {
			throw new FunctionalException(FunctionalException.Code.INVALID_STATUS, null, null);
		}
	}

	/**
	 * Check the status. null is allowed
	 * 
	 * @param vpID
	 *           the viewpoint ID associated with the item shose status is checked
	 * @param status
	 *           the status to check
	 * @throws FunctionalException
	 *            if the status is not in VP status literal list
	 */
	protected void checkStatus(String vpID, String status) throws FunctionalException {
		checkStatus(new HasNameAndIdDTO.Builder(vpID, null).build(), status);
	}

	/**
	 * Return item type managed by this service
	 * 
	 * @return item type managed by this service
	 */
	protected abstract Type getManagedType();
}

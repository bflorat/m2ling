/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.service.common;

import java.util.List;
import java.util.logging.Logger;

import org.m2ling.common.configuration.Conf;
import org.m2ling.common.dto.core.AbstractCommonDTO;
import org.m2ling.common.dto.core.AccessType;
import org.m2ling.common.dto.core.HasNameAndIdDTO;
import org.m2ling.common.exceptions.FunctionalException;
import org.m2ling.common.exceptions.FunctionalException.Code;
import org.m2ling.common.utils.Consts;
import org.m2ling.common.utils.Utils;
import org.m2ling.domain.core.Type;
import org.m2ling.domain.core.ViewPoint;
import org.m2ling.persistence.PersistenceManager;
import org.m2ling.service.util.CoreUtil;
import org.m2ling.service.util.DTOConverter;

import com.google.common.base.Strings;

/**
 * @author "Bertrand Florat <bertrand@florat.net>"
 * 
 *         Common services code and top of the injection tree for service layer.
 * 
 *         <p>
 *         Each service can override or extend the Guice bindings by instantiating in a static bloc
 *         the <code>specificBindings</code> field.
 *         </p>
 * 
 *         </p>Example :</p>
 * 
 *         <pre>
 *  {@code
 * static {
 * 	specificBindings = new AbstractModule() {
 * 		{@literal @Override}
 * 			protected void configure() {
 * 				bind(PersistenceManager.class).to(PersistenceManagerXMIImpl.class).in(Singleton.class);
 * 			}
 * 		};
 * 	}
 * }
 * </pre>
 */
abstract public class ServiceImpl {
	/** The persistence manager bringing persistence features to the services */
	protected PersistenceManager pmanager;

	/** DTO to domain object converter */
	protected DTOConverter.FromDTO fromDTO;

	/** Domain object to DTO converter */
	protected DTOConverter.ToDTO toDTO;

	/** Utilities class */
	protected CoreUtil util;

	/** Configuration */
	protected Conf conf;

	/** the logger */
	protected java.util.logging.Logger logger;

	protected ServiceImpl(PersistenceManager pm, CoreUtil util, DTOConverter.FromDTO fromDTO, DTOConverter.ToDTO toDTO,
			Conf conf, Logger logger) {
		this.util = util;
		this.fromDTO = fromDTO;
		this.toDTO = toDTO;
		this.pmanager = pm;
		this.conf = conf;
		this.logger = logger;
	}

	protected void checkIdAndName(final AbstractCommonDTO dto, AccessType access, boolean nullNameAllowed)
			throws FunctionalException {
		// Nullity
		if (dto == null) {
			throw new FunctionalException(Code.NULL_ARGUMENT, null, null);
		}
		// Check id
		if (dto.getId() == null) {
			throw new FunctionalException(FunctionalException.Code.NULL_ARGUMENT, null, "(id)");
		}
		if (Strings.isNullOrEmpty(dto.getId().trim())) {
			throw new FunctionalException(FunctionalException.Code.VOID_ARGUMENT, null, "(id)");
		}
		if (dto.getId().length() > 40) {
			throw new FunctionalException(FunctionalException.Code.SIZE_EXCEEDED, null, "(id)");
		}
		// Check name
		if (access == AccessType.CREATE || access == AccessType.UPDATE) {
			if (!nullNameAllowed && dto.getName() == null) {
				throw new FunctionalException(FunctionalException.Code.NULL_ARGUMENT, null, "(name)");
			}
			if (dto.getName() != null && "".equals(dto.getName().trim())) {
				throw new FunctionalException(FunctionalException.Code.VOID_ARGUMENT, null, "(name)");
			}
			if (dto.getName() != null && dto.getName().length() > Consts.MAX_LABEL_SIZE) {
				throw new FunctionalException(FunctionalException.Code.SIZE_EXCEEDED, null, "(name)");
			}
		}
		if (access == AccessType.CREATE) {
			// Check for existing item with the same id
			if (util.getItemByTypeAndID(getManagedType(), dto.getId()) != null) {
				throw new FunctionalException(FunctionalException.Code.DUPLICATES, null, "id=" + dto.getId());
			}
		}
		if (access == AccessType.DELETE) {
			if (util.getItemByTypeAndID(getManagedType(), dto.getId()) == null) {
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
	 * Check description
	 * 
	 * @param description
	 *           the provided description
	 * @throws FunctionalException
	 *            if the description has a wrong format
	 */
	protected void checkDescription(final String description, final boolean descriptionMandatory)
			throws FunctionalException {
		if (description == null && descriptionMandatory) {
			throw new FunctionalException(FunctionalException.Code.NULL_ARGUMENT, null, "(description)");
		}
		if (descriptionMandatory && description != null && "".equals(description.trim())) {
			throw new FunctionalException(FunctionalException.Code.VOID_ARGUMENT, null, "(description)");
		}
		if (description != null && description.length() > Consts.MAX_TEXT_SIZE) {
			throw new FunctionalException(FunctionalException.Code.SIZE_EXCEEDED, null, "(description)");
		}
	}

	/**
	 * Checks on tags
	 * 
	 * @param tags
	 * @throws FunctionalException
	 *            if the tags rules are not satified
	 * 
	 */
	protected void checkTags(List<String> tags) throws FunctionalException {
		int index = 1;
		for (String tag : tags) {
			if (tag == null) {
				throw new FunctionalException(FunctionalException.Code.NULL_ARGUMENT, null, "tag #" + index);
			}
			if (Strings.isNullOrEmpty(tag.trim())) {
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
	 *           the viewpoint associated with the item shose status is checked
	 * @param status
	 *           the status to check
	 * @throws FunctionalException
	 *            if the status is not in VP status literal list
	 */
	protected void checkStatus(HasNameAndIdDTO vp, String status) throws FunctionalException {
		if (vp == null) {
			throw new FunctionalException(FunctionalException.Code.NULL_ARGUMENT, null, "(viewpoint)");
		}
		ViewPoint storedVP = util.getViewPointByID(vp.getId());
		if (storedVP == null) {
			throw new FunctionalException(FunctionalException.Code.TARGET_NOT_FOUND, null, "Viewpoint id=" + vp.getId());
		}
		if (status != null && !storedVP.getStatusLiterals().contains(status)) {
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

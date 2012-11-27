/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.service.common;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.m2ling.common.configuration.Conf;
import org.m2ling.common.dto.core.AbstractCommonDTO;
import org.m2ling.common.dto.core.AccessType;
import org.m2ling.common.dto.core.HasNameAndIdDTO;
import org.m2ling.common.exceptions.FunctionalException;
import org.m2ling.common.exceptions.TechnicalException;
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
		if (access == AccessType.DELETE) {
			if (util.getItemByTypeAndID(getManagedType(), dto.getId()) == null) {
				throw new FunctionalException(FunctionalException.Code.TARGET_NOT_FOUND, null, "id=" + dto.getId());
			}
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
	protected void checkID(final AbstractCommonDTO dto, AccessType access) throws FunctionalException {
		// Check id
		if (dto.getId() == null) {
			throw new FunctionalException(FunctionalException.Code.NULL_ARGUMENT, null, "(id)");
		}
		if (Strings.isNullOrEmpty(dto.getId().trim())) {
			throw new FunctionalException(FunctionalException.Code.VOID_ARGUMENT, null, "(id)");
		}
		if (dto.getId().length() > 100) {
			throw new FunctionalException(FunctionalException.Code.SIZE_EXCEEDED, null, "(id)");
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
		ViewPoint storedVP = util.getViewPointByID(vp.getId());
		if (storedVP == null) {
			throw new FunctionalException(FunctionalException.Code.TARGET_NOT_FOUND, null, "Viewpoint id=" + vp.getId());
		}
		if (storedVP.getStatusLiterals() != null && !storedVP.getStatusLiterals().contains(status)) {
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

	/**
	 * Final method called when exiting a service on any error
	 * 
	 * @param ex
	 *           the initial exception
	 * @throws FunctionalException
	 *            if a functional exception occurred bellow
	 * @throws TechnicalException
	 *            if any exception (especially runtime exception) occurred bellow
	 */
	protected void handleAnyException(Exception ex) throws FunctionalException, TechnicalException {
		if (ex instanceof FunctionalException) {
			logger.log(Level.FINE, "Error when processing the service", ex);
			throw (FunctionalException) ex;
		} else if (ex instanceof TechnicalException) {
			logger.log(Level.FINE, "Error when processing the service", ex);
			throw (TechnicalException) ex;
		} else {
			logger.log(Level.FINE, "Error when processing the service", ex);
			// Wrap any uncatched exception into a new TechnicalException
			throw new TechnicalException(org.m2ling.common.exceptions.TechnicalException.Code.UNKNOWN, ex, null);
		}
	}

	/**
	 * Final method called when exiting a service that may may only throw technical errors
	 * 
	 * @param ex
	 *           the initial exception
	 * @throws TechnicalException
	 *            if any exception (especially runtime exception) occurred bellow
	 */
	protected void handleTechException(Exception ex) throws TechnicalException {
		if (ex instanceof TechnicalException) {
			logger.log(Level.FINE, "Error when processing the service", ex);
			throw (TechnicalException) ex;
		} else {
			logger.log(Level.FINE, "Error when processing the service", ex);
			// Wrap any uncatched exception into a new TechnicalException
			throw new TechnicalException(org.m2ling.common.exceptions.TechnicalException.Code.UNKNOWN, ex, null);
		}
	}
}

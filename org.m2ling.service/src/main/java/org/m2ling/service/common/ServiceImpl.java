/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.service.common;

import java.util.logging.Logger;

import org.m2ling.common.configuration.Conf;
import org.m2ling.common.dto.core.AbstractCommonDTO;
import org.m2ling.common.dto.core.AccessType;
import org.m2ling.common.exceptions.FunctionalException;
import org.m2ling.common.exceptions.FunctionalException.Code;
import org.m2ling.common.utils.Consts;
import org.m2ling.domain.core.Type;
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
			if (util.getItemByTypeAndID(getType(), dto.getId()) != null) {
				throw new FunctionalException(FunctionalException.Code.DUPLICATES, null, "id=" + dto.getId());
			}
			// Check for existing item with the same name
			if (util.getItemByTypeAndName(getType(), dto.getName()) != null) {
				throw new FunctionalException(FunctionalException.Code.DUPLICATE_NAME, null, "name=" + dto.getId());
			}
		}
		if (access == AccessType.DELETE) {
			if (util.getItemByTypeAndID(getType(), dto.getId()) == null) {
				throw new FunctionalException(FunctionalException.Code.TARGET_NOT_FOUND, null, "id=" + dto.getId());
			}
		}
	}

	/**
	 * Return item type managed by this service
	 * 
	 * @return item type managed by this service
	 */
	protected abstract Type getType();
}

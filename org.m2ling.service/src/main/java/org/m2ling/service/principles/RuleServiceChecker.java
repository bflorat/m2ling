/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.service.principles;

import org.m2ling.common.dto.core.AccessType;
import org.m2ling.common.dto.core.RuleDTO;
import org.m2ling.common.exceptions.FunctionalException;
import org.m2ling.common.utils.Consts;
import org.m2ling.common.utils.Utils;
import org.m2ling.domain.core.Type;
import org.m2ling.domain.core.ViewPoint;
import org.m2ling.persistence.PersistenceManager;
import org.m2ling.service.common.ReferenceHelper;
import org.m2ling.service.common.ServiceChecker;
import org.m2ling.service.util.DomainExplorer;
import org.m2ling.service.util.DTOConverter.FromDTO;

import com.google.inject.Inject;

/**
 * @author "Bertrand Florat <bertrand@florat.net>"
 * 
 */
public class RuleServiceChecker extends ServiceChecker {
	@Inject
	protected RuleServiceChecker(PersistenceManager pm, DomainExplorer explorer, FromDTO fromDTO, ReferenceHelper refHelper) {
		super(pm, explorer, fromDTO, refHelper);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Type getManagedType() {
		return Type.RULE;
	}

	/**
	 * Centralize all service entry verifications
	 * 
	 * @param dto
	 * @param access
	 *           : type of access
	 * @throws FunctionalException
	 */
	void checkDTO(final RuleDTO dto, AccessType access) throws FunctionalException {
		checkNullDTO(dto);
		checkIdFormat(dto, access);
		checkItemExistence(dto, access);
		checkNameWhenRequired(dto, access);
		if (access == AccessType.CREATE || access == AccessType.UPDATE) {
			ViewPoint vp = explorer.getViewPointByID(dto.getViewPointId());
			if (vp == null) {
				throw new FunctionalException(FunctionalException.Code.TARGET_NOT_FOUND, null, "viewpoint="
						+ dto.getViewPointId());
			}
			checkStatus(dto.getViewPointId(), dto.getStatus());
			checkDescriptionMandatory(dto.getDescription());
			checkRationale(dto);
			checkExceptions(dto);
			checkComment(dto.getComment());
			checkTags(dto.getTags());
		}
	}

	/**
	 * @param dto
	 * @throws FunctionalException
	 */
	private void checkExceptions(final RuleDTO dto) throws FunctionalException {
		if (dto.getExceptions() != null && dto.getExceptions().length() > Consts.MAX_TEXT_SIZE) {
			throw new FunctionalException(FunctionalException.Code.SIZE_EXCEEDED, null, "(exceptions)");
		}
	}

	/**
	 * @param dto
	 * @throws FunctionalException
	 */
	private void checkRationale(final RuleDTO dto) throws FunctionalException {
		if (dto.getRationale() == null) {
			throw new FunctionalException(FunctionalException.Code.NULL_ARGUMENT, null, "(rationale)");
		}
		if (Utils.isNullOrEmptyAfterTrim(dto.getRationale())) {
			throw new FunctionalException(FunctionalException.Code.VOID_ARGUMENT, null, "(rationale)");
		}
		if (dto.getRationale().length() > Consts.MAX_TEXT_SIZE) {
			throw new FunctionalException(FunctionalException.Code.SIZE_EXCEEDED, null, "(rationale)");
		}
	}
	
}

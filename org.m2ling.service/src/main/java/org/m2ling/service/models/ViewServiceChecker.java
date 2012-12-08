/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.service.models;

import org.m2ling.common.dto.core.AccessType;
import org.m2ling.common.dto.core.HasNameAndIdDTO;
import org.m2ling.common.dto.core.ViewDTO;
import org.m2ling.common.exceptions.FunctionalException;
import org.m2ling.common.exceptions.FunctionalException.Code;
import org.m2ling.domain.core.Type;
import org.m2ling.domain.core.ViewPoint;
import org.m2ling.persistence.PersistenceManager;
import org.m2ling.service.common.ReferenceHelper;
import org.m2ling.service.common.ServiceChecker;
import org.m2ling.service.util.CoreUtil;
import org.m2ling.service.util.DTOConverter.FromDTO;

import com.google.inject.Inject;

/**
 * @author "Bertrand Florat <bertrand@florat.net>"
 * 
 */
public class ViewServiceChecker extends ServiceChecker {
	@Inject
	protected ViewServiceChecker(PersistenceManager pm, CoreUtil util, FromDTO fromDTO, ReferenceHelper refHelper) {
		super(pm, util, fromDTO, refHelper);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Type getManagedType() {
		return Type.VIEW;
	}

	/**
	 * Centralize all service entry verifications
	 * 
	 * @param dto
	 *           : Link DTO to check
	 * @param access
	 *           : access type used to discriminate the check
	 * @throws FunctionalException
	 */
	void checkDTO(final ViewDTO dto, final AccessType access) throws FunctionalException {
		checkNullDTO(dto);
		checkID(dto, access);
		if (access == AccessType.CREATE || access == AccessType.UPDATE) {
			checkNameWhenRequired(dto, access);
			checkVP(dto, access);
			checkDescriptionMandatory(dto.getDescription());
			checkComment(dto.getComment());
			checkStatus(dto.getViewpoint(), dto.getStatus());
			checkTags(dto.getTags());
		}
	}

	void checkVP(final ViewDTO dto, final AccessType access) throws FunctionalException {
		HasNameAndIdDTO vpDTO = dto.getViewpoint();
		if (access == AccessType.CREATE) {
			if (vpDTO == null) {
				throw new FunctionalException(Code.NULL_ARGUMENT, null, "(viewpoint id)");
			} else if (vpDTO.getId() == null || "".equals(vpDTO.getId().trim())) {
				throw new FunctionalException(Code.VOID_ARGUMENT, null, "(viewpoint id)");
			} else {
				ViewPoint vp = util.getViewPointByID(vpDTO.getId());
				if (vp == null) {
					throw new FunctionalException(Code.TARGET_NOT_FOUND, null, "Viewpoint id=" + vpDTO.getId());
				}
			}
		}
	}
}

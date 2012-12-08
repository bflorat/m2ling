/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.service.models;

import org.m2ling.common.dto.core.AccessType;
import org.m2ling.common.dto.core.HasNameAndIdDTO;
import org.m2ling.common.dto.core.LinkInstanceDTO;
import org.m2ling.common.exceptions.FunctionalException;
import org.m2ling.domain.core.ComponentInstance;
import org.m2ling.domain.core.Link;
import org.m2ling.domain.core.LinkInstance;
import org.m2ling.domain.core.Type;
import org.m2ling.domain.core.View;
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
public class LinkInstanceServiceChecker extends ServiceChecker {
	@Inject
	protected LinkInstanceServiceChecker(PersistenceManager pm, CoreUtil util, FromDTO fromDTO, ReferenceHelper refHelper) {
		super(pm, util, fromDTO, refHelper);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Type getManagedType() {
		return Type.LINK_INSTANCE;
	}

	/**
	 * Centralize all service entry verifications
	 * 
	 * @param dto
	 *           : LI DTO to check
	 * @param access
	 *           : access type used to discriminate the check
	 * @throws FunctionalException
	 */
	void checkDTO(final LinkInstanceDTO dto, final AccessType access) throws FunctionalException {
		LinkInstance target = null;
		View view = null;
		Link link = null;
		checkNullDTO(dto);
		checkID(dto, access);
		if (access == AccessType.CREATE || access == AccessType.UPDATE) {
			target = util.getLinkInstanceByID(dto.getId());
			if (access == AccessType.CREATE) {
				checkLink(dto);
				link = util.getLinkByID(dto.getLink().getId());
			} else {
				link = target.getLink();
			}
			checkNameWhenRequired(dto, access);
			// Check associated view existence
			if (access == AccessType.CREATE) {
				checkViewIDFormat(dto);
				view = util.getViewByID(dto.getView().getId());
			} else {// vID is ignored for access != create
				view = util.getViewByItem(target);
			}
			if (view == null) {
				throw new FunctionalException(FunctionalException.Code.TARGET_NOT_FOUND, null, "(view)");
			}
			checkDescriptionNotMandatory(dto.getDescription());
			checkStatus(view.getViewPoint().getId(), dto.getStatus());
			checkComment(dto.getComment());
			checkTags(dto.getTags());
			checkSourceAndDestinationFormat(dto);
			checkSourceAndDestinationExistence(dto);
			checkSourceAndDestinationConformToLink(dto, link);
		}
	}

	private void checkSourceAndDestinationExistence(final LinkInstanceDTO dto) throws FunctionalException {
		HasNameAndIdDTO sourceCIDTO = dto.getSource();
		if (util.getComponentInstanceByID(sourceCIDTO.getId()) == null) {
			throw new FunctionalException(FunctionalException.Code.TARGET_NOT_FOUND, null, "(source component instance)");
		}
		HasNameAndIdDTO destCIDTO = dto.getDestination();
		if (util.getComponentInstanceByID(destCIDTO.getId()) == null) {
			throw new FunctionalException(FunctionalException.Code.TARGET_NOT_FOUND, null,
					"(destination component instance)" + destCIDTO.getId());
		}
	}

	private void checkLink(final LinkInstanceDTO dto) throws FunctionalException {
		if (dto.getLink() == null || dto.getLink().getId() == null) {
			throw new FunctionalException(FunctionalException.Code.NULL_ARGUMENT, null, "(Link)");
		}
		if ("".equals(dto.getLink().getId().trim())) {
			throw new FunctionalException(FunctionalException.Code.VOID_ARGUMENT, null, "(Link)");
		}
		if (util.getLinkByID(dto.getLink().getId()) == null) {
			throw new FunctionalException(FunctionalException.Code.TARGET_NOT_FOUND, null, "(Link)");
		}
	}

	private void checkSourceAndDestinationConformToLink(final LinkInstanceDTO dto, final Link link)
			throws FunctionalException {
		HasNameAndIdDTO sourceDTO = dto.getSource();
		ComponentInstance sourceInstance = util.getComponentInstanceByID(sourceDTO.getId());
		if (sourceInstance == null || !link.getSources().contains(sourceInstance.getComponent())) {
			throw new FunctionalException(FunctionalException.Code.LI_ILLEGAL_SOURCE_OR_DEST, null,
					"link instance source=" + dto.getSource());
		}
		HasNameAndIdDTO destDTO = dto.getDestination();
		ComponentInstance destInstance = util.getComponentInstanceByID(destDTO.getId());
		if (destInstance == null || !link.getDestinations().contains(destInstance.getComponent())) {
			throw new FunctionalException(FunctionalException.Code.LI_ILLEGAL_SOURCE_OR_DEST, null,
					"link instance destination=" + dto.getDestination());
		}
	}

	private void checkSourceAndDestinationFormat(final LinkInstanceDTO dto) throws FunctionalException {
		if (dto.getSource() == null || dto.getSource().getId() == null) {
			throw new FunctionalException(FunctionalException.Code.NULL_ARGUMENT, null, "(source component instance)");
		}
		if (dto.getDestination() == null || dto.getDestination().getId() == null) {
			throw new FunctionalException(FunctionalException.Code.NULL_ARGUMENT, null, "(destination component instance)");
		}
	}

	private void checkViewIDFormat(final LinkInstanceDTO dto) throws FunctionalException {
		if (dto.getView() == null || dto.getView().getId() == null) {
			throw new FunctionalException(FunctionalException.Code.NULL_ARGUMENT, null, "(view)");
		}
		if ("".equals(dto.getView().getId().trim())) {
			throw new FunctionalException(FunctionalException.Code.VOID_ARGUMENT, null, "(view)");
		}
	}
}

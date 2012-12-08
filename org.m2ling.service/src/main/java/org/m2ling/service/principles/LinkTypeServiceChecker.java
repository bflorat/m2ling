/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.service.principles;

import java.util.List;

import org.m2ling.common.dto.core.AccessType;
import org.m2ling.common.dto.core.HasNameAndIdDTO;
import org.m2ling.common.dto.core.LinkTypeDTO;
import org.m2ling.common.exceptions.FunctionalException;
import org.m2ling.common.exceptions.FunctionalException.Code;
import org.m2ling.domain.core.Component;
import org.m2ling.domain.core.ComponentType;
import org.m2ling.domain.core.Link;
import org.m2ling.domain.core.LinkAccessType;
import org.m2ling.domain.core.LinkTemporality;
import org.m2ling.domain.core.LinkType;
import org.m2ling.domain.core.Type;
import org.m2ling.domain.core.View;
import org.m2ling.domain.core.ViewPoint;
import org.m2ling.persistence.PersistenceManager;
import org.m2ling.service.common.ReferenceHelper;
import org.m2ling.service.common.ServiceChecker;
import org.m2ling.service.util.DomainExplorer;
import org.m2ling.service.util.DTOConverter.FromDTO;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * @author "Bertrand Florat <bertrand@florat.net>"
 * 
 */
public class LinkTypeServiceChecker extends ServiceChecker {
	@Inject
	protected LinkTypeServiceChecker(PersistenceManager pm, DomainExplorer explorer, FromDTO fromDTO, ReferenceHelper refHelper) {
		super(pm, explorer, fromDTO, refHelper);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Type getManagedType() {
		return Type.LINK_TYPE;
	}

	/**
	 * Centralize all service entry verifications
	 * 
	 * @param dto
	 * @param access
	 *           : access type used to discriminate the check
	 * @throws FunctionalException
	 */
	void checkDTO(final LinkTypeDTO dto, AccessType access) throws FunctionalException {
		checkNullDTO(dto);
		checkID(dto, access);
		checkNameWhenRequired(dto, access);
		// check before deletion
		if (access == AccessType.DELETE) {
			checkBeforeDeletion(dto, access);
		} else if (access == AccessType.CREATE || access == AccessType.UPDATE) {
			// Check associated viewpoint existence
			if (dto.getViewPoint() == null || dto.getViewPoint().getId() == null) {
				throw new FunctionalException(FunctionalException.Code.NULL_ARGUMENT, null, "(viewpoint)");
			}
			ViewPoint vp = explorer.getViewPointByID(dto.getViewPoint().getId());
			if (vp == null) {
				throw new FunctionalException(FunctionalException.Code.TARGET_NOT_FOUND, null, "viewpoint="
						+ dto.getViewPoint().getId());
			}
			checkDescriptionMandatory(dto.getDescription());
			checkStatus(dto.getViewPoint(), dto.getStatus());
			checkComment(dto.getComment());
			checkTags(dto.getTags());
			checkSourcesAndDestsSize(dto);
			// Note that sources and destinations items unicity is implicitly managed by the fact that
			// they are Set
			checkCTsExistence(dto);
			if (access == AccessType.UPDATE) {
				LinkType lt = explorer.getLinkTypeByID(dto.getId());
				checkRemovedCTNotInUse(dto, lt);
			}
			checkAccessAndTemporalityTypes(dto, access);
		}
	}

	private void checkBeforeDeletion(final LinkTypeDTO dto, AccessType access) throws FunctionalException {
		LinkType type = explorer.getLinkTypeByID(dto.getId());
		// Check rule #LT-20 : none link of this type
		for (View view : pmanager.getRoot().getViews()) {
			for (Link link : view.getLinks()) {
				if (link.getType().equals(type)) {
					throw new FunctionalException(FunctionalException.Code.LT_EXISTING_LINK, null, "link name="
							+ link.getName());
				}
			}
		}
	}

	private void checkRemovedCTNotInUse(final LinkTypeDTO dto, LinkType lt) throws FunctionalException {
		List<ComponentType> droppedSourceTypes = Lists.newArrayList(lt.getSourceTypes());
		for (HasNameAndIdDTO ctDTO : dto.getSourcesTypes()) {
			ComponentType ct = explorer.getComponentTypeByID(ctDTO.getId());
			droppedSourceTypes.remove(ct);
		}
		List<ComponentType> droppedDestTypes = Lists.newArrayList(lt.getDestinationTypes());
		for (HasNameAndIdDTO ctDTO : dto.getDestinationsTypes()) {
			ComponentType ct = explorer.getComponentTypeByID(ctDTO.getId());
			droppedDestTypes.remove(ct);
		}
		if (droppedDestTypes.size() > 0 || droppedSourceTypes.size() > 0) {
			for (View v : explorer.getViewsByVPID(dto.getViewPoint().getId())) {
				for (Link link : v.getLinks()) {
					List<Component> comps = explorer.getComponentForArchitectureItems(link.getSources());
					for (Component comp : comps) {
						if (droppedSourceTypes.contains(comp.getType())) {
							throw new FunctionalException(Code.LT_EXISTING_LINK, null, "component=" + comp.getName());
						}
					}
					comps = explorer.getComponentForArchitectureItems(link.getDestinations());
					for (Component comp : comps) {
						if (droppedDestTypes.contains(comp.getType())) {
							throw new FunctionalException(Code.LT_EXISTING_LINK, null, "component=" + comp.getName());
						}
					}
				}
			}
		}
	}

	private void checkSourcesAndDestsSize(final LinkTypeDTO dto) throws FunctionalException {
		if (dto.getSourcesTypes().size() == 0) {
			throw new FunctionalException(FunctionalException.Code.NONE_SOURCES_TYPES, null, "link name=" + dto.getName());
		}
		if (dto.getDestinationsTypes().size() == 0) {
			throw new FunctionalException(FunctionalException.Code.NONE_DEST_TYPES, null, "link name=" + dto.getName());
		}
	}

	private void checkCTsExistence(final LinkTypeDTO dto) throws FunctionalException {
		for (HasNameAndIdDTO ctDTO : dto.getSourcesTypes()) {
			if (explorer.getComponentTypeByID(ctDTO.getId()) == null) {
				throw new FunctionalException(FunctionalException.Code.TARGET_NOT_FOUND, null, "(link type source)");
			}
		}
		for (HasNameAndIdDTO ctDTO : dto.getDestinationsTypes()) {
			if (explorer.getComponentTypeByID(ctDTO.getId()) == null) {
				throw new FunctionalException(FunctionalException.Code.TARGET_NOT_FOUND, null, "(link type destination)");
			}
		}
	}

	private void checkAccessAndTemporalityTypes(final LinkTypeDTO dto, AccessType access) throws FunctionalException {
		try {
			LinkAccessType.valueOf(dto.getLinkAccessType());
		} catch (Exception iea) {
			throw new FunctionalException(FunctionalException.Code.LT_ILLEGAL_ACCESS_TYPE, null, "link name="
					+ dto.getName());
		}
		try {
			LinkTemporality.valueOf(dto.getLinkTemporality());
		} catch (Exception iea) {
			throw new FunctionalException(FunctionalException.Code.LT_ILLEGAL_TEMPORALITY, null, "link name="
					+ dto.getName());
		}
	}
}

/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.service.models;

import java.util.List;

import org.m2ling.common.dto.core.AccessType;
import org.m2ling.common.dto.core.HasNameAndIdDTO;
import org.m2ling.common.dto.core.LinkDTO;
import org.m2ling.common.exceptions.FunctionalException;
import org.m2ling.common.exceptions.FunctionalException.Code;
import org.m2ling.domain.core.ArchitectureItem;
import org.m2ling.domain.core.Component;
import org.m2ling.domain.core.ComponentInstance;
import org.m2ling.domain.core.Link;
import org.m2ling.domain.core.LinkInstance;
import org.m2ling.domain.core.LinkType;
import org.m2ling.domain.core.Type;
import org.m2ling.domain.core.View;
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
public class LinkServiceChecker extends ServiceChecker {
	@Inject
	protected LinkServiceChecker(PersistenceManager pm, DomainExplorer explorer, FromDTO fromDTO, ReferenceHelper refHelper) {
		super(pm, explorer, fromDTO, refHelper);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Type getManagedType() {
		return Type.LINK;
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
	void checkDTO(final LinkDTO dto, final AccessType access) throws FunctionalException {
		Link target = null;
		View view = null;
		LinkType lt = null;
		checkNullDTO(dto);
		checkIdFormat(dto, access);
		checkItemExistence(dto, access);
		checkNameWhenRequired(dto, access);
		target = explorer.getLinkByID(dto.getId());
		if (access == AccessType.DELETE) {
			checkNoLinkInstancesForLink(target, access);
		} else if (access == AccessType.CREATE || access == AccessType.UPDATE) {
			if (access == AccessType.CREATE) {
				checkType(dto);
				lt = explorer.getLinkTypeByID(dto.getLinkType().getId());
			} else {
				lt = target.getType();
			}
			// Check associated view existence
			if (access == AccessType.CREATE) {
				checkViewIDFormat(dto);
				view = explorer.getViewByID(dto.getView().getId());
			} else {// vID is ignored for access != create
				view = explorer.getViewByItem(target);
			}
			if (view == null) {
				throw new FunctionalException(FunctionalException.Code.TARGET_NOT_FOUND, null, "(view)");
			}
			checkDescriptionNotMandatory(dto.getDescription());
			checkStatus(view.getViewPoint().getId(), dto.getStatus());
			checkComment(dto.getComment());
			checkTags(dto.getTags());
			// Note that sources and destinations items unicity is implicitly managed by the fact that
			// they are Set collections
			checkSourcesAndDestinationsSize(dto);
			checkSourcesAndDestinationsExistence(dto);
			checkSourcesAndDestinationsConformToLT(dto, lt);
			if (access == AccessType.UPDATE) {
				checkRemovedComponentsNotInUse(dto, target, view);
			}
		}
	}

	private void checkNoLinkInstancesForLink(final Link target, final AccessType access) throws FunctionalException {
		View view = (View) target.eContainer();
		for (LinkInstance li : view.getLinkInstances()) {
			if (li.getLink().equals(target)) {
				throw new FunctionalException(FunctionalException.Code.LINK_IN_USE, null, "link instance name="
						+ li.getName());
			}
		}
	}

	private void checkSourcesAndDestinationsExistence(final LinkDTO dto) throws FunctionalException {
		// nullity of sources and destinations
		if (dto.getSources() == null) {
			throw new FunctionalException(FunctionalException.Code.NULL_ARGUMENT, null, "(source component)");
		}
		if (dto.getDestinations() == null) {
			throw new FunctionalException(FunctionalException.Code.NULL_ARGUMENT, null, "(destination component)");
		}
		// check existence of sources and destination Components
		for (HasNameAndIdDTO compDTO : dto.getSources()) {
			if (explorer.getComponentByID(compDTO.getId()) == null) {
				throw new FunctionalException(FunctionalException.Code.TARGET_NOT_FOUND, null, "(source component)");
			}
		}
		for (HasNameAndIdDTO compDTO : dto.getDestinations()) {
			if (explorer.getComponentByID(compDTO.getId()) == null) {
				throw new FunctionalException(FunctionalException.Code.TARGET_NOT_FOUND, null, "(destination component)"
						+ compDTO.getId());
			}
		}
	}

	private void checkType(final LinkDTO dto) throws FunctionalException {
		if (dto.getLinkType() == null || dto.getLinkType().getId() == null) {
			throw new FunctionalException(FunctionalException.Code.NULL_ARGUMENT, null, "(Link type)");
		}
		if ("".equals(dto.getLinkType().getId().trim())) {
			throw new FunctionalException(FunctionalException.Code.VOID_ARGUMENT, null, "(Link type)");
		}
		if (explorer.getLinkTypeByID(dto.getLinkType().getId()) == null) {
			throw new FunctionalException(FunctionalException.Code.TARGET_NOT_FOUND, null, "(Link type)");
		}
	}

	private void checkSourcesAndDestinationsConformToLT(final LinkDTO dto, final LinkType lt) throws FunctionalException {
		for (HasNameAndIdDTO compDTO : dto.getSources()) {
			Component comp = explorer.getComponentByID(compDTO.getId());
			if (comp == null || !lt.getSourceTypes().contains(comp.getType())) {
				throw new FunctionalException(FunctionalException.Code.LINK_ILLEGAL_SOURCE_OR_DEST, null, "link source="
						+ dto.getSources());
			}
		}
		for (HasNameAndIdDTO compDTO : dto.getDestinations()) {
			Component comp = explorer.getComponentByID(compDTO.getId());
			if (comp == null || !lt.getDestinationTypes().contains(comp.getType())) {
				throw new FunctionalException(FunctionalException.Code.LINK_ILLEGAL_SOURCE_OR_DEST, null, "link source="
						+ dto.getSources());
			}
		}
	}

	private void checkSourcesAndDestinationsSize(final LinkDTO dto) throws FunctionalException {
		if (dto.getSources().size() == 0) {
			throw new FunctionalException(FunctionalException.Code.NONE_SOURCES_TYPES, null, "link name=" + dto.getName());
		}
		if (dto.getDestinations().size() == 0) {
			throw new FunctionalException(FunctionalException.Code.NONE_DEST_TYPES, null, "link name=" + dto.getName());
		}
	}

	private void checkViewIDFormat(final LinkDTO dto) throws FunctionalException {
		if (dto.getView() == null || dto.getView().getId() == null) {
			throw new FunctionalException(FunctionalException.Code.NULL_ARGUMENT, null, "(view)");
		}
		if ("".equals(dto.getView().getId().trim())) {
			throw new FunctionalException(FunctionalException.Code.VOID_ARGUMENT, null, "(view)");
		}
	}

	private void checkRemovedComponentsNotInUse(final LinkDTO dto, Link target, View view) throws FunctionalException {
		List<ArchitectureItem> droppedSourceComponents = Lists.newArrayList(target.getSources());
		for (HasNameAndIdDTO compDTO : dto.getSources()) {
			Component comp = explorer.getComponentByID(compDTO.getId());
			droppedSourceComponents.remove(comp);
		}
		List<ArchitectureItem> droppedDestComponents = Lists.newArrayList(target.getDestinations());
		for (HasNameAndIdDTO compDTO : dto.getDestinations()) {
			Component comp = explorer.getComponentByID(compDTO.getId());
			droppedDestComponents.remove(comp);
		}
		if (droppedSourceComponents.size() > 0) {
			for (LinkInstance li : view.getLinkInstances()) {
				ComponentInstance ci = li.getSource();
				Component comp = ci.getComponent();
				if (droppedSourceComponents.contains(comp)) {
					throw new FunctionalException(Code.LINK_IN_USE, null, "Source component instance=" + ci.getName());
				}
			}
		}
		if (droppedDestComponents.size() > 0) {
			for (LinkInstance li : view.getLinkInstances()) {
				ComponentInstance ci = li.getDestination();
				Component comp = ci.getComponent();
				if (droppedDestComponents.contains(comp)) {
					throw new FunctionalException(Code.LINK_IN_USE, null, "Destination component instance=" + ci.getName());
				}
			}
		}
	}
}

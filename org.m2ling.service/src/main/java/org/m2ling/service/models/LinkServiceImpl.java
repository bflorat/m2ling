/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.service.models;

import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

import org.m2ling.common.configuration.Conf;
import org.m2ling.common.dto.core.AccessType;
import org.m2ling.common.dto.core.HasNameAndIdDTO;
import org.m2ling.common.dto.core.LinkDTO;
import org.m2ling.common.exceptions.FunctionalException;
import org.m2ling.common.exceptions.FunctionalException.Code;
import org.m2ling.common.soa.Context;
import org.m2ling.domain.Root;
import org.m2ling.domain.core.ArchitectureItem;
import org.m2ling.domain.core.Component;
import org.m2ling.domain.core.ComponentInstance;
import org.m2ling.domain.core.Link;
import org.m2ling.domain.core.LinkInstance;
import org.m2ling.domain.core.LinkType;
import org.m2ling.domain.core.Type;
import org.m2ling.domain.core.View;
import org.m2ling.persistence.PersistenceManager;
import org.m2ling.service.common.ServiceImpl;
import org.m2ling.service.util.CoreUtil;
import org.m2ling.service.util.DTOConverter;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * Nominal implementation for LinkService
 * 
 * @author "Bertrand Florat <bertrand@florat.net>"
 * 
 */
@Singleton
public class LinkServiceImpl extends ServiceImpl implements LinkService {
	/**
	 * Protected constructor to prevent direct instantiation
	 */
	@Inject
	protected LinkServiceImpl(PersistenceManager pm, CoreUtil util, DTOConverter.FromDTO fromDTO,
			DTOConverter.ToDTO toDTO, Conf conf, Logger logger) {
		super(pm, util, fromDTO, toDTO, conf, logger);
	}

	private void checkNoLinkInstancesForLink(final Link target, final AccessType access) throws FunctionalException {
		View view = util.getViewByItem(target);
		for (LinkInstance li : view.getLinkInstances()) {
			if (li.getLink().equals(target)) {
				throw new FunctionalException(FunctionalException.Code.LINK_IN_USE, null, "link instance name="
						+ li.getName());
			}
		}
	}

	private void checkSourcesAndDestinationsExistence(final LinkDTO dto) throws FunctionalException {
		// check existence of sources and destination Components
		for (HasNameAndIdDTO compDTO : dto.getSources()) {
			if (util.getComponentByID(compDTO.getId()) == null) {
				throw new FunctionalException(FunctionalException.Code.TARGET_NOT_FOUND, null, "(source component)");
			}
		}
		for (HasNameAndIdDTO compDTO : dto.getDestinations()) {
			if (util.getComponentByID(compDTO.getId()) == null) {
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
		if (util.getLinkTypeByID(dto.getLinkType().getId()) == null) {
			throw new FunctionalException(FunctionalException.Code.TARGET_NOT_FOUND, null, "(Link type)");
		}
	}

	private void checkSourcesAndDestinationsConformToLT(final LinkDTO dto, final LinkType lt) throws FunctionalException {
		for (HasNameAndIdDTO compDTO : dto.getSources()) {
			Component comp = util.getComponentByID(compDTO.getId());
			if (comp == null || !lt.getSourceTypes().contains(comp.getType())) {
				throw new FunctionalException(FunctionalException.Code.LINK_ILLEGAL_SOURCE_OR_DEST, null, "link source="
						+ dto.getSources());
			}
		}
		for (HasNameAndIdDTO compDTO : dto.getDestinations()) {
			Component comp = util.getComponentByID(compDTO.getId());
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
		checkID(dto, access);
		checkNameWhenRequired(dto, access);
		// item existence (except for creation access)
		if (access != AccessType.CREATE) {
			target = util.getLinkByID(dto.getId());
			if (target == null) {
				throw new FunctionalException(FunctionalException.Code.TARGET_NOT_FOUND, null, dto.toString());
			}
		}
		if (access == AccessType.CREATE) {
			checkType(dto);
			lt = util.getLinkTypeByID(dto.getLinkType().getId());
		} else {
			lt = target.getType();
		}
		if (access == AccessType.CREATE || access == AccessType.UPDATE) {
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
			// Note that sources and destinations items unicity is implicitly managed by the fact that
			checkSourcesAndDestinationsSize(dto);
			checkSourcesAndDestinationsExistence(dto);
			checkSourcesAndDestinationsConformToLT(dto, lt);
			if (access == AccessType.UPDATE) {
				checkRemovedComponentsNotInUse(dto, target, view);
			}
		}
		if (access == AccessType.DELETE) {
			checkNoLinkInstancesForLink(target, access);
		}
	}

	private void checkRemovedComponentsNotInUse(final LinkDTO dto, Link target, View view) throws FunctionalException {
		List<ArchitectureItem> droppedSourceComponents = Lists.newArrayList(target.getSources());
		for (HasNameAndIdDTO compDTO : dto.getSources()) {
			Component comp = util.getComponentByID(compDTO.getId());
			droppedSourceComponents.remove(comp);
		}
		List<ArchitectureItem> droppedDestComponents = Lists.newArrayList(target.getDestinations());
		for (HasNameAndIdDTO compDTO : dto.getDestinations()) {
			Component comp = util.getComponentByID(compDTO.getId());
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

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateLink(final Context context, final LinkDTO dto) throws FunctionalException {
		try {
			// Controls
			checkDTO(dto, AccessType.UPDATE);
			// Processing
			Link link = util.getLinkByID(dto.getId());
			link.setName(dto.getName());
			link.setDescription(dto.getDescription());
			link.setComment(dto.getComment());
			List<String> tags = link.getTags();
			tags.clear();
			tags.addAll(dto.getTags());
			List<ArchitectureItem> sources = link.getSources();
			sources.clear();
			for (HasNameAndIdDTO compDTO : dto.getSources()) {
				Component comp = util.getComponentByID(compDTO.getId());
				sources.add(comp);
			}
			List<ArchitectureItem> destinations = link.getDestinations();
			destinations.clear();
			for (HasNameAndIdDTO compDTO : dto.getDestinations()) {
				Component comp = util.getComponentByID(compDTO.getId());
				destinations.add(comp);
			}
			link.setStatus(dto.getStatus());
			pmanager.commit();
		} catch (Exception anyError) {
			handleAnyException(anyError);
		}
	}

	@Override
	public void createLink(final Context context, final LinkDTO dto) throws FunctionalException {
		try {
			// Controls
			checkDTO(dto, AccessType.CREATE);
			// Processing
			Link link = fromDTO.newLink(dto);
			// Add the item
			View view = util.getViewByID(dto.getView().getId());
			view.getLinks().add(link);
			pmanager.commit();
		} catch (Exception anyError) {
			handleAnyException(anyError);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<LinkDTO> getAllLinks(final Context context, final String vID) throws FunctionalException {
		List<LinkDTO> out = Lists.newArrayList();
		try {
			// Controls
			if (util.getViewByID(vID) == null) {
				throw new FunctionalException(Code.TARGET_NOT_FOUND, null, "ViewID=" + vID);
			}
			Root root = pmanager.getRoot();
			for (View checked : root.getViews()) {
				if (checked.getId().equals(vID)) {
					List<Link> links = checked.getLinks();
					for (Link link : links) {
						LinkDTO dto = toDTO.getLinkDTO(link);
						out.add(dto);
					}
					break;
				}
			}
			Collections.sort(out);
		} catch (Exception anyError) {
			handleAnyException(anyError);
		}
		return out;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteLink(final Context context, final String id) throws FunctionalException {
		try {
			// Controls
			LinkDTO dto = new LinkDTO.Builder(id,null,null).build();
			checkDTO(dto, AccessType.DELETE);
			Link link = util.getLinkByID(dto.getId());
			View view = (View) link.eContainer();
			view.getLinks().remove(link);
			pmanager.commit();
		} catch (Exception anyError) {
			handleAnyException(anyError);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public LinkDTO getLinkByID(Context context, String id) throws FunctionalException {
		LinkDTO out = null;
		try {
			// Controls
			if (id == null || Strings.isNullOrEmpty(id.trim())) {
				throw new FunctionalException(FunctionalException.Code.NULL_ARGUMENT, null, "(id)");
			}
			Link link = util.getLinkByID(id);
			if (link != null) {
				out = toDTO.getLinkDTO(link);
			}
		} catch (Exception anyError) {
			handleAnyException(anyError);
		}
		return out;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Type getManagedType() {
		return Type.LINK;
	}
}

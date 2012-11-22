/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.service.principles;

import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

import org.m2ling.common.configuration.Conf;
import org.m2ling.common.dto.core.AccessType;
import org.m2ling.common.dto.core.HasNameAndIdDTO;
import org.m2ling.common.dto.core.LinkTypeDTO;
import org.m2ling.common.exceptions.FunctionalException;
import org.m2ling.common.exceptions.FunctionalException.Code;
import org.m2ling.common.soa.Context;
import org.m2ling.domain.Root;
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
import org.m2ling.service.common.ServiceImpl;
import org.m2ling.service.util.CoreUtil;
import org.m2ling.service.util.DTOConverter;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * Nominal implementation for LinkTypeService
 * 
 * @author "Bertrand Florat <bertrand@florat.net>"
 * 
 */
@Singleton
public class LinkTypeServiceImpl extends ServiceImpl implements LinkTypeService {
	/**
	 * Protected constructor to prevent direct instantiation
	 */
	@Inject
	protected LinkTypeServiceImpl(PersistenceManager pm, CoreUtil util, DTOConverter.FromDTO fromDTO,
			DTOConverter.ToDTO toDTO, Conf conf, Logger logger) {
		super(pm, util, fromDTO, toDTO, conf, logger);
	}

	private void checkBeforeDeletion(final LinkTypeDTO dto, AccessType access) throws FunctionalException {
		LinkType type = util.getLinkTypeByID(dto.getId());
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

	private void checkSourcesAndDestTypes(final LinkTypeDTO dto, AccessType access) throws FunctionalException {
		/*
		 * Note that sources and destinations items unicity is implicitly managed by the fact that
		 * they are Set
		 */
		// Rule #LT32
		if (dto.getSourcesTypes().size() == 0) {
			throw new FunctionalException(FunctionalException.Code.LT_NONE_SOURCES_TYPES, null, "link name="
					+ dto.getName());
		}
		// Rule #LT33
		if (dto.getDestinationsTypes().size() == 0) {
			throw new FunctionalException(FunctionalException.Code.LT_NONE_DEST_TYPES, null, "link name=" + dto.getName());
		}
		// check existence of sources and destination CTs
		for (HasNameAndIdDTO ctDTO : dto.getSourcesTypes()) {
			if (util.getComponentTypeByID(ctDTO.getId()) == null) {
				throw new FunctionalException(FunctionalException.Code.TARGET_NOT_FOUND, null, "link type source id="
						+ ctDTO.getId());
			}
		}
		for (HasNameAndIdDTO ctDTO : dto.getDestinationsTypes()) {
			if (util.getComponentTypeByID(ctDTO.getId()) == null) {
				throw new FunctionalException(FunctionalException.Code.TARGET_NOT_FOUND, null, "link type destination id="
						+ ctDTO.getId());
			}
		}
		if (access == AccessType.UPDATE) {
			LinkType lt = util.getLinkTypeByID(dto.getId());
			// Rules #LT30 and #LT31 : do not drop a source or destination type
			// if used by a existing link
			// - Compute dropped source CT
			List<ComponentType> droppedSourceTypes = Lists.newArrayList(lt.getSourceTypes());
			for (HasNameAndIdDTO ctDTO : dto.getSourcesTypes()) {
				ComponentType ct = util.getComponentTypeByID(ctDTO.getId());
				droppedSourceTypes.remove(ct);
			}
			List<ComponentType> droppedDestTypes = Lists.newArrayList(lt.getDestinationTypes());
			for (HasNameAndIdDTO ctDTO : dto.getDestinationsTypes()) {
				ComponentType ct = util.getComponentTypeByID(ctDTO.getId());
				droppedDestTypes.remove(ct);
			}
			// - Check only if some types have been dropped
			if (droppedDestTypes.size() > 0 || droppedSourceTypes.size() > 0) {
				for (View v : util.getViewsByVPID(dto.getViewPoint().getId())) {
					for (Link link : v.getLinks()) {
						List<Component> comps = util.getComponentForArchitectureItems(link.getSources());
						for (Component comp : comps) {
							if (droppedSourceTypes.contains(comp.getType())) {
								throw new FunctionalException(Code.LT_EXISTING_LINK, null, "component=" + comp.getName());
							}
						}
						comps = util.getComponentForArchitectureItems(link.getDestinations());
						for (Component comp : comps) {
							if (droppedDestTypes.contains(comp.getType())) {
								throw new FunctionalException(Code.LT_EXISTING_LINK, null, "component=" + comp.getName());
							}
						}
					}
				}
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

	/**
	 * Centralize all service entry verifications
	 * 
	 * @param dto
	 * @param access
	 *           : access type used to discriminate the check
	 * @throws FunctionalException
	 */
	void checkDTO(final LinkTypeDTO dto, AccessType access) throws FunctionalException {
		LinkType target = null;
		checkNullDTO(dto);
		checkID(dto, access);
		checkNameWhenRequired(dto, access);
		// item existence (except for creation access)
		if (access != AccessType.CREATE) {
			target = util.getLinkTypeByID(dto.getId());
			if (target == null) {
				throw new FunctionalException(FunctionalException.Code.TARGET_NOT_FOUND, null, dto.toString());
			}
		}
		// check before deletion
		if (access == AccessType.DELETE) {
			checkBeforeDeletion(dto, access);
		}
		if (access == AccessType.CREATE || access == AccessType.UPDATE) {
			// Check associated viewpoint existence
			if (dto.getViewPoint() == null || dto.getViewPoint().getId() == null) {
				throw new FunctionalException(FunctionalException.Code.NULL_ARGUMENT, null, "(viewpoint)");
			}
			ViewPoint vp = util.getViewPointByID(dto.getViewPoint().getId());
			if (vp == null) {
				throw new FunctionalException(FunctionalException.Code.TARGET_NOT_FOUND, null, "viewpoint="
						+ dto.getViewPoint().getId());
			}
			checkDescriptionMandatory(dto.getDescription());
			checkStatus(dto.getViewPoint(), dto.getStatus());
			checkComment(dto.getComment());
			checkTags(dto.getTags());
			checkSourcesAndDestTypes(dto, access);
			checkAccessAndTemporalityTypes(dto, access);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateLT(final Context context, final LinkTypeDTO dto) throws FunctionalException {
		try {
			// Controls
			checkDTO(dto, AccessType.UPDATE);
			// Processing
			LinkType lt = util.getLinkTypeByID(dto.getId());
			lt.setName(dto.getName());
			lt.setDescription(dto.getDescription());
			lt.setComment(dto.getComment());
			List<String> tags = lt.getTags();
			tags.clear();
			tags.addAll(dto.getTags());
			lt.setLinkAccessType(LinkAccessType.valueOf(dto.getLinkAccessType()));
			lt.setLinkTemporality(LinkTemporality.valueOf(dto.getLinkTemporality()));
			List<ComponentType> sources = lt.getSourceTypes();
			sources.clear();
			for (HasNameAndIdDTO ctDTO : dto.getSourcesTypes()) {
				ComponentType ct = util.getComponentTypeByID(ctDTO.getId());
				sources.add(ct);
			}
			List<ComponentType> destinations = lt.getDestinationTypes();
			destinations.clear();
			for (HasNameAndIdDTO ctDTO : dto.getDestinationsTypes()) {
				ComponentType ct = util.getComponentTypeByID(ctDTO.getId());
				destinations.add(ct);
			}
			lt.setStatus(dto.getStatus());
			pmanager.commit();
		} catch (Exception anyError) {
			handleAnyException(anyError);
		}
	}

	@Override
	public void createLT(final Context context, final LinkTypeDTO dto) throws FunctionalException {
		try {
			// Controls
			checkDTO(dto, AccessType.CREATE);
			// Processing
			LinkType lt = fromDTO.newLinkType(dto);
			// Add the item
			ViewPoint vp = util.getViewPointByID(dto.getViewPoint().getId());
			vp.getLinkTypes().add(lt);
			pmanager.commit();
		} catch (Exception anyError) {
			handleAnyException(anyError);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<LinkTypeDTO> getAllLT(final Context context, final String vp) throws FunctionalException {
		List<LinkTypeDTO> out = Lists.newArrayList();
		try {
			// Controls
			if (util.getViewPointByID(vp) == null) {
				throw new FunctionalException(Code.TARGET_NOT_FOUND, null, "Viewpoint=" + vp.toString());
			}
			Root root = pmanager.getRoot();
			for (ViewPoint checked : root.getViewPoints()) {
				if (checked.getId().equals(vp)) {
					List<LinkType> lts = checked.getLinkTypes();
					for (LinkType lt : lts) {
						LinkTypeDTO dto = toDTO.getLinkTypeDTO(lt);
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
	public void deleteLT(final Context context, final LinkTypeDTO dto) throws FunctionalException {
		try {
			// Controls
			checkDTO(dto, AccessType.DELETE);
			LinkType type = util.getLinkTypeByID(dto.getId());
			ViewPoint vp = (ViewPoint) type.eContainer();
			vp.getLinkTypes().remove(type);
			pmanager.commit();
		} catch (Exception anyError) {
			handleAnyException(anyError);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public LinkTypeDTO getLTByID(Context context, String id) throws FunctionalException {
		LinkTypeDTO out = null;
		try {
			// Controls
			if (id == null || Strings.isNullOrEmpty(id.trim())) {
				throw new FunctionalException(FunctionalException.Code.NULL_ARGUMENT, null, "(id)");
			}
			LinkType lt = util.getLinkTypeByID(id);
			if (lt != null) {
				out = toDTO.getLinkTypeDTO(lt);
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
		return Type.LINK_TYPE;
	}
}

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
import org.m2ling.common.utils.Consts;
import org.m2ling.common.utils.Utils;
import org.m2ling.domain.Root;
import org.m2ling.domain.core.ComponentType;
import org.m2ling.domain.core.Link;
import org.m2ling.domain.core.LinkAccessType;
import org.m2ling.domain.core.LinkTemporality;
import org.m2ling.domain.core.LinkType;
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

	private void checkIdAndName(final LinkTypeDTO dto, AccessType access) throws FunctionalException {
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
			if (dto.getName() == null) {
				throw new FunctionalException(FunctionalException.Code.NULL_ARGUMENT, null, "(name)");
			}
			if ("".equals(dto.getName().trim())) {
				throw new FunctionalException(FunctionalException.Code.VOID_ARGUMENT, null, "(name)");
			}
			if (dto.getName().length() > Consts.MAX_LABEL_SIZE) {
				throw new FunctionalException(FunctionalException.Code.SIZE_EXCEEDED, null, "(name)");
			}
		}
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
		// Rule #LT-01
		if (dto.getSourcesTypes().size() == 0) {
			throw new FunctionalException(FunctionalException.Code.LT_NONE_SOURCES_TYPES, null, "link name="
					+ dto.getName());
		}
		// Rule #LT-02
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
	}

	private void checkAccessAndTemporalityTypes(final LinkTypeDTO dto, AccessType access) throws FunctionalException {
		try {
			LinkAccessType.valueOf(dto.getLinkAccessType());
		} catch (Exception iea) {
			throw new FunctionalException(FunctionalException.Code.LT_ILLEGAL_ACCESS_TYPE, null, "link name="
					+ dto.getName());
		}
		try {
			LinkTemporality.valueOf(dto.getTemporality());
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
		checkIdAndName(dto, access);
		// item existence (except for creation access)
		if (access != AccessType.CREATE) {
			target = util.getLinkTypeByID(dto.getId());
			if (target == null) {
				throw new FunctionalException(FunctionalException.Code.TARGET_NOT_FOUND, null, dto.toString());
			}
		}
		// Check associated viewpoint existence
		if (dto.getViewPoint() == null || dto.getViewPoint().getId() == null) {
			throw new FunctionalException(FunctionalException.Code.NULL_ARGUMENT, null, "(viewpoint)");
		}
		ViewPoint vp = util.getViewPointByID(dto.getViewPoint().getId());
		if (vp == null) {
			throw new FunctionalException(FunctionalException.Code.TARGET_NOT_FOUND, null, "viewpoint="
					+ dto.getViewPoint().getId());
		}
		// check before deletion
		if (access == AccessType.DELETE) {
			checkBeforeDeletion(dto, access);
		}
		if (access == AccessType.CREATE) {
			// Check for existing item with the same id
			for (LinkType item : vp.getLinkTypes()) {
				if (item.getId().equals(dto.getId())) {
					throw new FunctionalException(FunctionalException.Code.DUPLICATES, null, "id=" + dto.getId());
				}
			}
			// Check for existing item with the same name
			for (LinkType item : vp.getLinkTypes()) {
				if (item.getName().equals(dto.getName())) {
					throw new FunctionalException(FunctionalException.Code.DUPLICATE_NAME, null, "name=" + dto.getName());
				}
			}
		}
		if (access == AccessType.CREATE || access == AccessType.UPDATE) {
			// Description
			if (dto.getDescription() == null) {
				throw new FunctionalException(FunctionalException.Code.NULL_ARGUMENT, null, "(description)");
			}
			if ("".equals(dto.getDescription().trim())) {
				throw new FunctionalException(FunctionalException.Code.VOID_ARGUMENT, null, "(description)");
			}
			if (dto.getDescription().length() > Consts.MAX_TEXT_SIZE) {
				throw new FunctionalException(FunctionalException.Code.SIZE_EXCEEDED, null, "(description)");
			}
			// Comment
			if (dto.getComment() != null && dto.getComment().length() > Consts.MAX_TEXT_SIZE) {
				throw new FunctionalException(FunctionalException.Code.SIZE_EXCEEDED, null, "(comment)");
			}
			// Tags
			Utils.checkTags(dto.getTags());
			// Sources and destination
			checkSourcesAndDestTypes(dto, access);
			// Access type and temporality
			checkAccessAndTemporalityTypes(dto, access);
		}
	}

	@Override
	public void updateLT(final Context context, final LinkTypeDTO dto) throws FunctionalException {
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
		lt.setLinkTemporality(LinkTemporality.valueOf(dto.getTemporality()));
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
		pmanager.commit();
	}

	@Override
	public void createLT(final Context context, final LinkTypeDTO dto) throws FunctionalException {
		// Controls
		checkDTO(dto, AccessType.CREATE);
		// Processing
		LinkType lt = fromDTO.newLinkType(dto);
		// Add the item
		ViewPoint vp = util.getViewPointByID(dto.getViewPoint().getId());
		vp.getLinkTypes().add(lt);
		pmanager.commit();
	}

	@Override
	public List<LinkTypeDTO> getAllLT(final Context context, final String vp) throws FunctionalException {
		{// Controls
			if (util.getViewPointByID(vp) == null) {
				throw new FunctionalException(Code.TARGET_NOT_FOUND, null, "Viewpoint=" + vp.toString());
			}
		}
		Root root = pmanager.getRoot();
		List<LinkTypeDTO> out = Lists.newArrayList();
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
		return out;
	}

	@Override
	public void deleteLT(final Context context, final LinkTypeDTO dto) throws FunctionalException {
		{// Controls
			checkDTO(dto, AccessType.DELETE);
		}
		LinkType type = util.getLinkTypeByID(dto.getId());
		ViewPoint vp = (ViewPoint) type.eContainer();
		vp.getLinkTypes().remove(type);
		pmanager.commit();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.m2ling.service.principles.LinkTypeService#getLTByID(org.m2ling.common.soa.Context,
	 * java.lang.String)
	 */
	@Override
	public LinkTypeDTO getLTByID(Context context, String id) throws FunctionalException {
		{// Controls
			if (id == null || Strings.isNullOrEmpty(id.trim())) {
				throw new FunctionalException(FunctionalException.Code.NULL_ARGUMENT, null, "(id)");
			}
		}
		LinkType lt = util.getLinkTypeByID(id);
		if (lt == null) {
			return null;
		}
		return toDTO.getLinkTypeDTO(lt);
	}
}
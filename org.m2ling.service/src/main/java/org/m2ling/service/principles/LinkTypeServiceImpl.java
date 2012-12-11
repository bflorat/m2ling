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
import org.m2ling.common.utils.Utils;
import org.m2ling.domain.Root;
import org.m2ling.domain.core.ComponentType;
import org.m2ling.domain.core.LinkAccessType;
import org.m2ling.domain.core.LinkTemporality;
import org.m2ling.domain.core.LinkType;
import org.m2ling.domain.core.ViewPoint;
import org.m2ling.persistence.PersistenceManager;
import org.m2ling.service.common.ServiceImpl;
import org.m2ling.service.util.DomainExplorer;
import org.m2ling.service.util.DTOConverter;

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
	private LinkTypeServiceChecker checker;

	/**
	 * Protected constructor to prevent direct instantiation
	 */
	@Inject
	protected LinkTypeServiceImpl(PersistenceManager pm, DomainExplorer explorer, DTOConverter.FromDTO fromDTO,
			DTOConverter.ToDTO toDTO, Conf conf, Logger logger, LinkTypeServiceChecker checker) {
		super(pm, explorer, fromDTO, toDTO, conf, logger);
		this.checker = checker;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateLT(final Context context, final LinkTypeDTO dto) throws FunctionalException {
		try {
			// Controls
			checker.checkDTO(dto, AccessType.UPDATE);
			// Processing
			LinkType lt = explorer.getLinkTypeByID(dto.getId());
			lt.setName(dto.getName());
			lt.setDescription(dto.getDescription());
			lt.setComment(dto.getComment());
			List<String> tags = lt.getTags();
			tags.clear();
			tags.addAll(dto.getTags());
			if (dto.getLinkAccessType() != null) {
				lt.setLinkAccessType(LinkAccessType.valueOf(dto.getLinkAccessType()));
			} else {
				lt.setLinkAccessType(LinkAccessType.UNSET);
			}
			if (dto.getLinkTemporality() != null) {
				lt.setLinkTemporality(LinkTemporality.valueOf(dto.getLinkTemporality()));
			} else {
				lt.setLinkTemporality(LinkTemporality.UNSET);
			}
			List<ComponentType> sources = lt.getSourceTypes();
			sources.clear();
			for (HasNameAndIdDTO ctDTO : dto.getSourcesTypes()) {
				ComponentType ct = explorer.getComponentTypeByID(ctDTO.getId());
				sources.add(ct);
			}
			List<ComponentType> destinations = lt.getDestinationTypes();
			destinations.clear();
			for (HasNameAndIdDTO ctDTO : dto.getDestinationsTypes()) {
				ComponentType ct = explorer.getComponentTypeByID(ctDTO.getId());
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
			checker.checkDTO(dto, AccessType.CREATE);
			// Processing
			LinkType lt = fromDTO.newLinkType(dto);
			// Add the item
			ViewPoint vp = explorer.getViewPointByID(dto.getViewPoint().getId());
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
			if (explorer.getViewPointByID(vp) == null) {
				throw new FunctionalException(Code.TARGET_NOT_FOUND, null, "Viewpoint id=" + vp);
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
	public void deleteLT(final Context context, final String id) throws FunctionalException {
		try {
			// Controls
			LinkTypeDTO dto = new LinkTypeDTO.Builder(null, id, null).build();
			checker.checkDTO(dto, AccessType.DELETE);
			LinkType type = explorer.getLinkTypeByID(dto.getId());
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
			if (id == null || Utils.isNullOrEmptyAfterTrim(id)) {
				throw new FunctionalException(FunctionalException.Code.NULL_ARGUMENT, null, "(id)");
			}
			LinkType lt = explorer.getLinkTypeByID(id);
			if (lt != null) {
				out = toDTO.getLinkTypeDTO(lt);
			}
		} catch (Exception anyError) {
			handleAnyException(anyError);
		}
		return out;
	}
}

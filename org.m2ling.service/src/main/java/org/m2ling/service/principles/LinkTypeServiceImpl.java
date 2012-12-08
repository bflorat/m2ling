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
import org.m2ling.domain.core.ComponentType;
import org.m2ling.domain.core.LinkAccessType;
import org.m2ling.domain.core.LinkTemporality;
import org.m2ling.domain.core.LinkType;
import org.m2ling.domain.core.ViewPoint;
import org.m2ling.persistence.PersistenceManager;
import org.m2ling.service.common.ServiceImpl;
import org.m2ling.service.util.CoreUtil;
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
	protected LinkTypeServiceImpl(PersistenceManager pm, CoreUtil util, DTOConverter.FromDTO fromDTO,
			DTOConverter.ToDTO toDTO, Conf conf, Logger logger, LinkTypeServiceChecker checker) {
		super(pm, util, fromDTO, toDTO, conf, logger);
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
			checker.checkDTO(dto, AccessType.CREATE);
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
			LinkType lt = util.getLinkTypeByID(id);
			if (lt != null) {
				out = toDTO.getLinkTypeDTO(lt);
			}
		} catch (Exception anyError) {
			handleAnyException(anyError);
		}
		return out;
	}
}

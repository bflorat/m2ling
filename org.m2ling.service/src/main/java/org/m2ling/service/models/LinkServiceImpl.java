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
import org.m2ling.common.utils.Utils;
import org.m2ling.domain.Root;
import org.m2ling.domain.core.ArchitectureItem;
import org.m2ling.domain.core.Component;
import org.m2ling.domain.core.Link;
import org.m2ling.domain.core.View;
import org.m2ling.persistence.PersistenceManager;
import org.m2ling.service.common.ServiceImpl;
import org.m2ling.service.util.DomainExplorer;
import org.m2ling.service.util.DTOConverter;

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
	private LinkServiceChecker checker;

	/**
	 * Protected constructor to prevent direct instantiation
	 */
	@Inject
	protected LinkServiceImpl(PersistenceManager pm, DomainExplorer explorer, DTOConverter.FromDTO fromDTO,
			DTOConverter.ToDTO toDTO, Conf conf, Logger logger, LinkServiceChecker checker) {
		super(pm, explorer, fromDTO, toDTO, conf, logger);
		this.checker = checker;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateLink(final Context context, final LinkDTO dto) throws FunctionalException {
		try {
			// Controls
			checker.checkDTO(dto, AccessType.UPDATE);
			// Processing
			Link link = explorer.getLinkByID(dto.getId());
			link.setName(dto.getName());
			link.setDescription(dto.getDescription());
			link.setComment(dto.getComment());
			List<String> tags = link.getTags();
			tags.clear();
			tags.addAll(dto.getTags());
			List<ArchitectureItem> sources = link.getSources();
			sources.clear();
			for (HasNameAndIdDTO compDTO : dto.getSources()) {
				Component comp = explorer.getComponentByID(compDTO.getId());
				sources.add(comp);
			}
			List<ArchitectureItem> destinations = link.getDestinations();
			destinations.clear();
			for (HasNameAndIdDTO compDTO : dto.getDestinations()) {
				Component comp = explorer.getComponentByID(compDTO.getId());
				destinations.add(comp);
			}
			link.setStatus(dto.getStatus());
			pmanager.commit();
		} catch (Exception anyError) {
			handleAnyException(anyError);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void createLink(final Context context, final LinkDTO dto) throws FunctionalException {
		try {
			// Controls
			checker.checkDTO(dto, AccessType.CREATE);
			// Processing
			Link link = fromDTO.newLink(dto);
			// Add the item
			View view = explorer.getViewByID(dto.getView().getId());
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
			if (explorer.getViewByID(vID) == null) {
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
			LinkDTO dto = new LinkDTO.Builder(id, null, null).build();
			checker.checkDTO(dto, AccessType.DELETE);
			Link link = explorer.getLinkByID(dto.getId());
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
			if (id == null || Utils.isNullOrEmptyAfterTrim(id)) {
				throw new FunctionalException(FunctionalException.Code.NULL_ARGUMENT, null, "(id)");
			}
			Link link = explorer.getLinkByID(id);
			if (link != null) {
				out = toDTO.getLinkDTO(link);
			}
		} catch (Exception anyError) {
			handleAnyException(anyError);
		}
		return out;
	}
}

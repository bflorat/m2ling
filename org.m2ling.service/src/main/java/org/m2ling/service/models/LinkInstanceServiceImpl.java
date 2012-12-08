/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.service.models;

import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

import org.m2ling.common.configuration.Conf;
import org.m2ling.common.dto.core.AccessType;
import org.m2ling.common.dto.core.LinkInstanceDTO;
import org.m2ling.common.exceptions.FunctionalException;
import org.m2ling.common.exceptions.FunctionalException.Code;
import org.m2ling.common.soa.Context;
import org.m2ling.common.utils.Utils;
import org.m2ling.domain.Root;
import org.m2ling.domain.core.ComponentInstance;
import org.m2ling.domain.core.LinkInstance;
import org.m2ling.domain.core.View;
import org.m2ling.persistence.PersistenceManager;
import org.m2ling.service.common.ServiceImpl;
import org.m2ling.service.util.CoreUtil;
import org.m2ling.service.util.DTOConverter;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * Nominal implementation for LinkInstanceService
 * 
 * @author "Bertrand Florat <bertrand@florat.net>"
 * 
 */
@Singleton
public class LinkInstanceServiceImpl extends ServiceImpl implements LinkInstanceService {
	private LinkInstanceServiceChecker checker;

	/**
	 * Protected constructor to prevent direct instantiation
	 */
	@Inject
	protected LinkInstanceServiceImpl(PersistenceManager pm, CoreUtil util, DTOConverter.FromDTO fromDTO,
			DTOConverter.ToDTO toDTO, Conf conf, Logger logger, LinkInstanceServiceChecker checker) {
		super(pm, util, fromDTO, toDTO, conf, logger);
		this.checker = checker;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateLinkInstance(final Context context, final LinkInstanceDTO dto) throws FunctionalException {
		try {
			// Controls
			checker.checkDTO(dto, AccessType.UPDATE);
			// Processing
			LinkInstance instance = util.getLinkInstanceByID(dto.getId());
			instance.setName(dto.getName());
			instance.setDescription(dto.getDescription());
			instance.setComment(dto.getComment());
			List<String> tags = instance.getTags();
			tags.clear();
			tags.addAll(dto.getTags());
			ComponentInstance ci = util.getComponentInstanceByID(dto.getSource().getId());
			instance.setSource(ci);
			ci = util.getComponentInstanceByID(dto.getDestination().getId());
			instance.setDestination(ci);
			instance.setStatus(dto.getStatus());
			pmanager.commit();
		} catch (Exception anyError) {
			handleAnyException(anyError);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void createLinkInstance(final Context context, final LinkInstanceDTO dto) throws FunctionalException {
		try {
			// Controls
			checker.checkDTO(dto, AccessType.CREATE);
			// Processing
			LinkInstance instance = fromDTO.newLinkInstance(dto);
			// Add the item
			View view = util.getViewByID(dto.getView().getId());
			view.getLinkInstances().add(instance);
			pmanager.commit();
		} catch (Exception anyError) {
			handleAnyException(anyError);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<LinkInstanceDTO> getAllLinkInstances(final Context context, final String vID) throws FunctionalException {
		List<LinkInstanceDTO> out = Lists.newArrayList();
		try {
			// Controls
			if (util.getViewByID(vID) == null) {
				throw new FunctionalException(Code.TARGET_NOT_FOUND, null, "ViewID=" + vID);
			}
			Root root = pmanager.getRoot();
			for (View checked : root.getViews()) {
				if (checked.getId().equals(vID)) {
					List<LinkInstance> instances = checked.getLinkInstances();
					for (LinkInstance instance : instances) {
						LinkInstanceDTO dto = toDTO.getLinkInstanceDTO(instance);
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
	public void deleteLinkInstance(final Context context, final String id) throws FunctionalException {
		try {
			// Controls
			LinkInstanceDTO dto = new LinkInstanceDTO.Builder(id, null, null).build();
			checker.checkDTO(dto, AccessType.DELETE);
			LinkInstance li = util.getLinkInstanceByID(dto.getId());
			View view = (View) li.eContainer();
			view.getLinks().remove(li);
			pmanager.commit();
		} catch (Exception anyError) {
			handleAnyException(anyError);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public LinkInstanceDTO getLinkInstanceByID(Context context, String id) throws FunctionalException {
		LinkInstanceDTO out = null;
		try {
			// Controls
			if (id == null || Utils.isNullOrEmptyAfterTrim(id)) {
				throw new FunctionalException(FunctionalException.Code.NULL_ARGUMENT, null, "(id)");
			}
			LinkInstance li = util.getLinkInstanceByID(id);
			if (li != null) {
				out = toDTO.getLinkInstanceDTO(li);
			}
		} catch (Exception anyError) {
			handleAnyException(anyError);
		}
		return out;
	}
}

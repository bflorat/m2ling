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
import org.m2ling.common.dto.core.LinkInstanceDTO;
import org.m2ling.common.exceptions.FunctionalException;
import org.m2ling.common.exceptions.FunctionalException.Code;
import org.m2ling.common.soa.Context;
import org.m2ling.domain.Root;
import org.m2ling.domain.core.ComponentInstance;
import org.m2ling.domain.core.Link;
import org.m2ling.domain.core.LinkInstance;
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
 * Nominal implementation for LinkInstanceService
 * 
 * @author "Bertrand Florat <bertrand@florat.net>"
 * 
 */
@Singleton
public class LinkInstanceServiceImpl extends ServiceImpl implements LinkInstanceService {
	/**
	 * Protected constructor to prevent direct instantiation
	 */
	@Inject
	protected LinkInstanceServiceImpl(PersistenceManager pm, CoreUtil util, DTOConverter.FromDTO fromDTO,
			DTOConverter.ToDTO toDTO, Conf conf, Logger logger) {
		super(pm, util, fromDTO, toDTO, conf, logger);
	}

	private void checkSourceAndDestinationExistence(final LinkInstanceDTO dto) throws FunctionalException {
		HasNameAndIdDTO ciDTO = dto.getSource();
		if (util.getComponentInstanceByID(ciDTO.getId()) == null) {
			throw new FunctionalException(FunctionalException.Code.TARGET_NOT_FOUND, null, "(source component instance)");
		}
		ciDTO = dto.getDestination();
		if (util.getComponentInstanceByID(ciDTO.getId()) == null) {
			throw new FunctionalException(FunctionalException.Code.TARGET_NOT_FOUND, null,
					"(destination component instance)" + ciDTO.getId());
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
		if (dto.getSource() == null) {
			throw new FunctionalException(FunctionalException.Code.NULL_ARGUMENT, null, "(source component instance)");
		}
		if (dto.getDestination() == null) {
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
		checkNameWhenRequired(dto, access);
		// item existence (except for creation access)
		if (access != AccessType.CREATE) {
			target = util.getLinkInstanceByID(dto.getId());
			if (target == null) {
				throw new FunctionalException(FunctionalException.Code.TARGET_NOT_FOUND, null, dto.toString());
			}
		}
		if (access == AccessType.CREATE) {
			checkLink(dto);
			link = util.getLinkByID(dto.getLink().getId());
		} else {
			link = target.getLink();
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
			checkSourceAndDestinationFormat(dto);
			checkSourceAndDestinationExistence(dto);
			checkSourceAndDestinationConformToLink(dto, link);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateLinkInstance(final Context context, final LinkInstanceDTO dto) throws FunctionalException {
		try {
			// Controls
			checkDTO(dto, AccessType.UPDATE);
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
			checkDTO(dto, AccessType.CREATE);
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
	public LinkInstanceDTO getLinkInstanceByID(Context context, String id) throws FunctionalException {
		LinkInstanceDTO out = null;
		try {
			// Controls
			if (id == null || Strings.isNullOrEmpty(id.trim())) {
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

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Type getManagedType() {
		return Type.LINK_INSTANCE;
	}
}

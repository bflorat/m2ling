/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.service.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

import org.m2ling.common.configuration.Conf;
import org.m2ling.common.dto.core.AccessType;
import org.m2ling.common.dto.core.HasNameAndIdDTO;
import org.m2ling.common.dto.core.ViewDTO;
import org.m2ling.common.exceptions.FunctionalException;
import org.m2ling.common.exceptions.FunctionalException.Code;
import org.m2ling.common.soa.Context;
import org.m2ling.common.utils.Consts;
import org.m2ling.common.utils.Utils;
import org.m2ling.domain.Root;
import org.m2ling.domain.core.Component;
import org.m2ling.domain.core.Type;
import org.m2ling.domain.core.View;
import org.m2ling.domain.core.ViewPoint;
import org.m2ling.persistence.PersistenceManager;
import org.m2ling.service.common.ServiceImpl;
import org.m2ling.service.util.CoreUtil;
import org.m2ling.service.util.DTOConverter;

import com.google.common.base.Strings;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * 
 * View service nominal implementation
 * 
 * @author "Bertrand Florat <bertrand@florat.net>"
 * 
 */
@Singleton
public class ViewServiceImpl extends ServiceImpl implements ViewService {
	/**
	 * Protected constructor to prevent direct instantiation
	 */
	@Inject
	protected ViewServiceImpl(PersistenceManager pm, CoreUtil util, DTOConverter.FromDTO fromDTO,
			DTOConverter.ToDTO toDTO, Conf conf, Logger logger) {
		super(pm, util, fromDTO, toDTO, conf, logger);
	}

	void checkDTO(final ViewDTO dto, final AccessType access) throws FunctionalException {
		ViewPoint vp = null;
		checkIdAndName(dto, access, false);
		// Check VP
		checkVP(dto, access);
		if (access == AccessType.CREATE) {
			// VP existence
			vp = util.getViewPointByID(dto.getViewpoint().getId());
			if (vp == null) {
				throw new FunctionalException(Code.TARGET_NOT_FOUND, null, "Viewpoint name=" + dto.getViewpoint().getName());
			}
		}
		if (access == AccessType.CREATE || access == AccessType.UPDATE) {
			// Description
			if (dto.getDescription() != null && dto.getDescription().length() > Consts.MAX_TEXT_SIZE) {
				throw new FunctionalException(FunctionalException.Code.SIZE_EXCEEDED, null, "(description)");
			}
			// Comment
			if (dto.getComment() != null && dto.getComment().length() > Consts.MAX_TEXT_SIZE) {
				throw new FunctionalException(FunctionalException.Code.SIZE_EXCEEDED, null, "(comment)");
			}
			// Tags
			Utils.checkTags(dto.getTags());
		}
	}

	void checkVP(final ViewDTO dto, final AccessType access) throws FunctionalException {
		HasNameAndIdDTO vpDTO = dto.getViewpoint();
		if (access == AccessType.CREATE) {
			if (vpDTO == null) {
				throw new FunctionalException(Code.NULL_ARGUMENT, null, "(viewpoint id)");
			} else if (vpDTO.getId() == null || "".equals(vpDTO.getId().trim())) {
				throw new FunctionalException(Code.VOID_ARGUMENT, null, "(viewpoint id)");
			} else {
				ViewPoint vp = util.getViewPointByID(vpDTO.getId());
				if (vp == null) {
					throw new FunctionalException(Code.TARGET_NOT_FOUND, null, "Viewpoint id=" + vpDTO.getId());
				}
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.m2ling.service.principles.ViewService#getAllViews(org.m2ling.common.soa.Context)
	 */
	public List<ViewDTO> getAllViews(final Context context) {
		List<ViewDTO> vDTOs = new ArrayList<ViewDTO>(10);
		Root root = pmanager.getRoot();
		for (View vp : root.getViews()) {
			ViewDTO dto = toDTO.getViewDTO(vp);
			vDTOs.add(dto);
		}
		Collections.sort(vDTOs);
		return vDTOs;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.m2ling.service.principles.ViewService#getViewByID(org.m2ling.common.soa.Context,
	 * java.lang.String)
	 */
	@Override
	public ViewDTO getViewByID(final Context context, String id) throws FunctionalException {
		{// controls
			if (id == null || Strings.isNullOrEmpty(id.trim())) {
				throw new FunctionalException(FunctionalException.Code.NULL_ARGUMENT, null, "(id)");
			}
		}
		View vp = util.getViewByID(id);
		if (vp == null) {
			return null;
		}
		return toDTO.getViewDTO(vp);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.m2ling.service.principles.ViewService#createView(org.m2ling.common.soa.Context,
	 * org.m2ling.common.dto.core.ViewDTO)
	 */
	@Override
	public void createView(final Context context, final ViewDTO dto) throws FunctionalException {
		// test DTO
		checkDTO(dto, AccessType.CREATE);
		// Processing
		View view = fromDTO.newView(dto);
		Root root = pmanager.getRoot();
		root.getViews().add(view);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.m2ling.service.principles.ViewService#updateView(org.m2ling.common.soa.Context,
	 * org.m2ling.common.dto.core.ViewDTO)
	 */
	@Override
	public void updateView(final Context context, final ViewDTO vDTO) throws FunctionalException {
		// tests
		checkDTO(vDTO, AccessType.UPDATE);
		// Processing (note that VP can't be changed so we don't set here)
		View view = util.getViewByID(vDTO.getId());
		view.setName(vDTO.getName());
		view.setDescription(vDTO.getDescription());
		view.setComment(vDTO.getComment());
		List<String> tags = view.getTags();
		tags.clear();
		tags.addAll(vDTO.getTags());
		// TODO Check that status is valid
		view.setStatus(vDTO.getStatus());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.m2ling.service.principles.ViewService#deleteView(org.m2ling.common.soa.Context,
	 * java.lang.String)
	 */
	@Override
	public void deleteView(final Context context, final String id) throws FunctionalException {
		View view = util.getViewByID(id);
		if (view == null) {
			throw new FunctionalException(FunctionalException.Code.TARGET_NOT_FOUND, null, "id=" + id);
		}
		// Check if one of this view component is used as bound component
		// (Note : no need to check component instances binding as the component check prevent the
		// bound component instance deletion)
		for (View v : pmanager.getRoot().getViews()) {
			if (v.equals(view)) {
				continue;
			}
			for (Component comp : v.getComponents()) {
				if (view.getComponents().contains(comp.getBoundComponent())) {
					throw new FunctionalException(FunctionalException.Code.VP_IN_USE, null, "(" + v.getName() + ")");
				}
			}
		}
		pmanager.getRoot().getViews().remove(view);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.m2ling.service.common.ServiceImpl#getType()
	 */
	@Override
	protected Type getManagedType() {
		return Type.VIEW;
	}
}

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
import org.m2ling.common.dto.core.ViewDTO;
import org.m2ling.common.exceptions.FunctionalException;
import org.m2ling.common.exceptions.FunctionalException.Code;
import org.m2ling.common.soa.Context;
import org.m2ling.common.utils.Consts;
import org.m2ling.common.utils.Utils;
import org.m2ling.domain.Root;
import org.m2ling.domain.core.Component;
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
 * View service nomimal implementation
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

	private void checkIdAndName(final ViewDTO dto, AccessType access) throws FunctionalException {
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
		if (access == AccessType.CREATE) {
			// Check for existing item with the same id
			List<View> vps = pmanager.getRoot().getViews();
			for (View item : vps) {
				if (item.getId().equals(dto.getId())) {
					throw new FunctionalException(FunctionalException.Code.DUPLICATES, null, "id=" + dto.getId());
				}
			}
			// Check for existing item with the same name
			for (View item : vps) {
				if (item.getName().equals(dto.getName())) {
					throw new FunctionalException(FunctionalException.Code.DUPLICATE_NAME, null, "name=" + dto.getName());
				}
			}
		}
	}

	void checkDTO(final ViewDTO dto, final AccessType access) throws FunctionalException {
		View vp = null;
		checkIdAndName(dto, access);
		if (access != AccessType.CREATE) {
			// view existence
			vp = util.getViewByID(dto.getId());
			if (vp == null) {
				throw new FunctionalException(Code.TARGET_NOT_FOUND, null, dto.getId());
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
	public void createView(final Context context, final ViewDTO vDTO) throws FunctionalException {
		// test DTO
		checkDTO(vDTO, AccessType.CREATE);
		// Processing
		View vp = fromDTO.newView(vDTO);
		Root root = pmanager.getRoot();
		if (root.getViews().contains(vp)) {
			throw new IllegalStateException("View already exist");
		}
		// Check for view point with the same name
		for (View vpChecked : root.getViews()) {
			if (vpChecked.getName().equals(vDTO.getName())) {
				throw new IllegalStateException("View already exist with name : " + vDTO.getName());
			}
		}
		root.getViews().add(vp);
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
		// Processing
		View view = util.getViewByID(vDTO.getId());
		view.setName(vDTO.getName());
		ViewPoint vp = util.getViewPointByID(vDTO.getId());
		view.setViewPoint(vp);
		view.setDescription(vDTO.getDescription());
		view.setComment(vDTO.getComment());
		List<String> tags = view.getTags();
		tags.clear();
		tags.addAll(vDTO.getTags());
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
		// Drop associated item
		for (Component comp : view.getComponents()) {
			// TODO, call a component service
			// no need for dropping links, instances and groups : done by these services
		}
		pmanager.getRoot().getViews().remove(view);
	}
}

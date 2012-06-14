/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.service.principles.impl;

import java.util.ArrayList;
import java.util.List;

import org.m2ling.common.dto.core.ViewPointDTO;
import org.m2ling.domain.Root;
import org.m2ling.domain.core.ViewPoint;
import org.m2ling.service.common.ServiceImpl;
import org.m2ling.service.principles.ViewPointService;
import org.m2ling.service.util.CoreUtil;
import org.m2ling.service.util.DTOConverter;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author "Bertrand Florat <bertrand@florat.net>"
 * 
 */
@Singleton
public class ViewPointServiceImpl extends ServiceImpl implements ViewPointService {

	@Inject
	CoreUtil util;

	/**
	 * Protected constructor to prevent direct instantiation
	 */
	protected ViewPointServiceImpl() {
		super();
	}

	public List<ViewPointDTO> getAllViewPoints() {
		List<ViewPointDTO> vpDTOs = new ArrayList<ViewPointDTO>(10);
		Root root = getPersistenceManager().getRoot();
		for (ViewPoint vp : root.getViewPoints()) {
			ViewPointDTO dto = DTOConverter.ToDTO.getViewPointDTO(vp);
			vpDTOs.add(dto);
		}
		return vpDTOs;
	}

	@Override
	public ViewPointDTO getViewPointByName(String name) {
		Root root = getPersistenceManager().getRoot();
		for (ViewPoint vp : root.getViewPoints()) {
			if (name.equals(vp.getName())) {
				return DTOConverter.ToDTO.getViewPointDTO(vp);
			}
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.m2ling.service.principles.ViewPointService#createViewPoint(org.m2ling
	 * .dto.core.ViewPointDTO)
	 */
	@Override
	public void createViewPoint(ViewPointDTO vpDTO) {
		ViewPoint vp = fromDTO.newViewPoint(vpDTO);
		Root root = getPersistenceManager().getRoot();
		if (root.getViewPoints().contains(vp)) {
			throw new IllegalStateException("View point already exist");
		}
		// Check for view point with the same name
		for (ViewPoint vpChecked : root.getViewPoints()) {
			if (vpChecked.getName().equals(vpDTO.getName())) {
				throw new IllegalStateException("View point already exist with name : " + vpDTO.getName());
			}
		}
		root.getViewPoints().add(vp);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.m2ling.service.principles.ViewPointService#updateViewPoint(org.m2ling.common.dto.core.
	 * ViewPointDTO)
	 */
	@Override
	public void updateViewPoint(ViewPointDTO vpDTO) {
		ViewPoint vp = util.getViewPointByName(vpDTO.getName(), false);
		if (vp == null) {
			throw new IllegalStateException("View point doesn't exists : " + vpDTO.getName());
		}
		vp.setName(vpDTO.getName());
		vp.setDescription(vpDTO.getDescription());
		List<String> status = vp.getStatusLiterals();
		status.clear();
		status.addAll(vpDTO.getStatusLiterals());
		vp.setComment(vpDTO.getComment());
		List<String> tags = vp.getTags();
		tags.clear();
		tags.addAll(vpDTO.getTags());
	}

}

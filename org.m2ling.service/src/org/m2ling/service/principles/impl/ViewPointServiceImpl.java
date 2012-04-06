/**
 * Copyright (C) Bertrand Florat
 */
package org.m2ling.service.principles.impl;

import java.util.ArrayList;
import java.util.List;

import org.m2ling.domain.core.CoreFactory;
import org.m2ling.domain.core.Root;
import org.m2ling.domain.core.ViewPoint;
import org.m2ling.dto.core.ViewPointDTO;
import org.m2ling.persistence.ModelFactory;
import org.m2ling.service.principles.ViewPointService;
import org.m2ling.service.util.DTOConverter;

import com.google.inject.Singleton;

/**
 * @author "Bertrand Florat <bertrand@florat.net>"
 * 
 */
@Singleton
public final class ViewPointServiceImpl implements ViewPointService {

	ViewPointServiceImpl() {
		super();
	}

	public List<ViewPointDTO> getAllViewPoints() {
		List<ViewPointDTO> vpDTOs = new ArrayList<ViewPointDTO>(10);
		Root root = ModelFactory.getRoot();
		for (ViewPoint vp : root.getViewPoints()) {
			ViewPointDTO dto = DTOConverter.ToDTO.getViewPointDTO(vp);
			vpDTOs.add(dto);
		}
		return vpDTOs;
	}

	@Override
	public ViewPointDTO getViewPointByName(String name) {
		Root root = ModelFactory.getRoot();
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
		ViewPoint vp = CoreFactory.eINSTANCE.createViewPoint();
		vp.setName(vpDTO.getName());
		Root root = ModelFactory.getRoot();
		root.getViewPoints().add(vp);
	}

}

/**
 * Copyright (C) Bertrand Florat
 */
package org.m2ling.service.principles.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.m2ling.domain.core.CoreFactory;
import org.m2ling.domain.core.Root;
import org.m2ling.domain.core.ViewPoint;
import org.m2ling.dto.core.ViewPointDTO;
import org.m2ling.service.principles.ViewPointService;
import org.m2ling.service.util.DTOConverter;

import com.google.inject.Singleton;

@Singleton
public final class ViewPointServiceImpl implements ViewPointService {

	// TODO
	Root root = CoreFactory.eINSTANCE.createRoot();

	ViewPointServiceImpl() {
		super();
	}

	public List<ViewPointDTO> getAllViewPoints() {
		List<ViewPointDTO> vpDTOs = new ArrayList<ViewPointDTO>(10);
		for (ViewPoint vp : root.getViewpoints()) {
			ViewPointDTO dto = DTOConverter.ToDTO.getViewPointDTO(vp);
			vpDTOs.add(dto);
		}
		return vpDTOs;
	}

	@Override
	public ViewPointDTO getViewPointByName(String name) {
		for (ViewPoint vp : root.getViewpoints()) {
			if (name.equals(vp.getName())) {
				return DTOConverter.ToDTO.getViewPointDTO(vp);
			}
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.m2ling.service.principles.ViewPointService#createViewPoint(org.m2ling
	 * .dto.core.ViewPointDTO)
	 */
	@Override
	public void createViewPoint(ViewPointDTO vpDTO) {
		ViewPoint vp = CoreFactory.eINSTANCE.createViewPoint();
		vp.setName(vpDTO.getName());
		root.getViewpoints().add(vp);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.m2ling.service.principles.ViewPointService#applyTags(java.lang.String
	 * [])
	 */
	@Override
	public void applyTags(String name, String... tags) {
		ViewPoint vp = null;
		for (ViewPoint v : root.getViewpoints()) {
			if (name.equals(v.getName())) {
				vp = v;
			}
		}
		if (vp == null) {
			throw new IllegalArgumentException("Viewpoint doesn't exist : "
					+ name);
		}
		vp.setTags(tags);
	}

}

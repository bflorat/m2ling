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
import org.m2ling.service.util.DTOConverter;

import com.google.inject.Module;

/**
 * @author "Bertrand Florat <bertrand@florat.net>"
 * 
 */
public final class ViewPointServiceImpl extends ServiceImpl implements ViewPointService {
	
	/**
	 * Protected constructor to prevent direct instantiation
	 */
	protected ViewPointServiceImpl() {
		super();
	}

	/**
	 * @see ServiceImpl
	 */
	protected ViewPointServiceImpl(Module additionalTestModule) {
		super(additionalTestModule);
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
		root.getViewPoints().add(vp);
	}

}

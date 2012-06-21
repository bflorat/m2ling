/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.service.principles.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.m2ling.common.configuration.Configuration;
import org.m2ling.common.dto.core.ViewPointDTO;
import org.m2ling.common.exceptions.FunctionalException;
import org.m2ling.common.utils.Consts;
import org.m2ling.common.utils.Utils;
import org.m2ling.domain.Root;
import org.m2ling.domain.core.ViewPoint;
import org.m2ling.persistence.PersistenceManager;
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

	/**
	 * Protected constructor to prevent direct instantiation
	 */
	@Inject
	protected ViewPointServiceImpl(PersistenceManager pm, CoreUtil util, DTOConverter.FromDTO fromDTO,
			DTOConverter.ToDTO toDTO, Configuration conf) {
		super();
		this.util = util;
		this.toDTO = toDTO;
		this.pmanager = pm;
		this.conf = conf;
	}

	private void checkDTO(final ViewPointDTO vpDTO) throws FunctionalException {
		// Name
		if (vpDTO.getName().length() > Consts.MAX_LABEL_SIZE) {
			throw new FunctionalException(FunctionalException.Code.SIZE_EXCEEDED, "Name too long", null, null);
		}
		// Status literals
		int index = 1;
		for (String literal : vpDTO.getStatusLiterals()) {
			if (literal.length() > Consts.MAX_LABEL_SIZE) {
				throw new FunctionalException(FunctionalException.Code.SIZE_EXCEEDED, "Status literal name is too long",
						null, "status #" + index);
			}
			index++;
		}
		if (Utils.containsDup(vpDTO.getStatusLiterals())) {
			throw new FunctionalException(FunctionalException.Code.DUPLICATES, "Status literal contains duplicates", null,
					null);
		}
		// Description
		if (vpDTO.getDescription().length() > Consts.MAX_TEXT_SIZE) {
			throw new FunctionalException(FunctionalException.Code.SIZE_EXCEEDED, "Description too long", null, null);
		}
		// Comment
		if (vpDTO.getComment().length() > Consts.MAX_TEXT_SIZE) {
			throw new FunctionalException(FunctionalException.Code.SIZE_EXCEEDED, "Comment too long", null, null);
		}
		// Tags
		index = 1;
		for (String tag : vpDTO.getTags()) {
			if (tag.length() > Consts.MAX_LABEL_SIZE) {
				throw new FunctionalException(FunctionalException.Code.SIZE_EXCEEDED, "Tag is too long", null, "tag #"
						+ index);
			}
			index++;
		}
		if (Utils.containsDup(vpDTO.getTags())) {
			throw new FunctionalException(FunctionalException.Code.DUPLICATES, "Tags contains duplicates", null, null);
		}
	}

	public List<ViewPointDTO> getAllViewPoints() {
		List<ViewPointDTO> vpDTOs = new ArrayList<ViewPointDTO>(10);
		Root root = pmanager.getRoot();
		for (ViewPoint vp : root.getViewPoints()) {
			ViewPointDTO dto = toDTO.getViewPointDTO(vp);
			vpDTOs.add(dto);
		}
		Collections.sort(vpDTOs);
		return vpDTOs;
	}

	@Override
	public ViewPointDTO getViewPointByName(final String name) {
		Root root = pmanager.getRoot();
		for (ViewPoint vp : root.getViewPoints()) {
			if (name.equals(vp.getName())) {
				return toDTO.getViewPointDTO(vp);
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
	public void createViewPoint(final ViewPointDTO vpDTO) throws FunctionalException {
		// test DTO
		checkDTO(vpDTO);

		ViewPoint vp = fromDTO.newViewPoint(vpDTO);
		Root root = pmanager.getRoot();
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
	public void updateViewPoint(final ViewPointDTO vpDTO) throws FunctionalException {
		// tests
		ViewPoint vp = util.getViewPointByID(vpDTO.getId());
		if (vp == null) {
			throw new IllegalStateException("View point doesn't exists : " + vpDTO.getId());
		}
		checkDTO(vpDTO);
		// Processing
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.m2ling.service.principles.ViewPointService#deleteViewPoint(org.m2ling.common.dto
	 * .core.ViewPointDTO)
	 */
	@Override
	public void deleteViewPoint(final ViewPointDTO vpDTO) throws FunctionalException {
		ViewPoint vp = util.getViewPointByID(vpDTO.getId());
		if (vp == null) {
			throw new FunctionalException(FunctionalException.Code.TARGET_NOT_FOUND, "View point doesn't exists", null,
					vpDTO.toString());
		}
		pmanager.getRoot().getViewPoints().remove(vp);
	}

}

/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.service.principles;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

import org.eclipse.emf.common.util.EList;
import org.m2ling.common.configuration.Conf;
import org.m2ling.common.dto.core.AccessType;
import org.m2ling.common.dto.core.ViewPointDTO;
import org.m2ling.common.exceptions.FunctionalException;
import org.m2ling.common.exceptions.FunctionalException.Code;
import org.m2ling.common.soa.Context;
import org.m2ling.common.utils.Consts;
import org.m2ling.common.utils.Utils;
import org.m2ling.domain.Root;
import org.m2ling.domain.core.Component;
import org.m2ling.domain.core.ComponentType;
import org.m2ling.domain.core.Link;
import org.m2ling.domain.core.LinkType;
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
 * @author "Bertrand Florat <bertrand@florat.net>"
 * 
 */
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
			DTOConverter.ToDTO toDTO, Conf conf, Logger logger) {
		super(pm, util, fromDTO, toDTO, conf, logger);
	}

	private void checkIdAndName(final ViewPointDTO dto, AccessType access) throws FunctionalException {
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
			List<ViewPoint> vps = pmanager.getRoot().getViewPoints();
			for (ViewPoint item : vps) {
				if (item.getId().equals(dto.getId())) {
					throw new FunctionalException(FunctionalException.Code.DUPLICATES, null, "id=" + dto.getId());
				}
			}
			// Check for existing item with the same name
			for (ViewPoint item : vps) {
				if (item.getName().equals(dto.getName())) {
					throw new FunctionalException(FunctionalException.Code.DUPLICATE_NAME, null, "name=" + dto.getName());
				}
			}
		}
	}

	void checkDTO(final ViewPointDTO dto, final AccessType access) throws FunctionalException {
		ViewPoint vp = null;
		checkIdAndName(dto, access);
		if (access != AccessType.CREATE) {
			// VP existence
			vp = util.getViewPointByID(dto.getId());
			if (vp == null) {
				throw new FunctionalException(Code.TARGET_NOT_FOUND, null, dto.getId());
			}
		}
		if (access == AccessType.CREATE || access == AccessType.UPDATE) {
			// Status literals
			if (dto.getStatusLiterals() == null) {
				throw new FunctionalException(FunctionalException.Code.NULL_ARGUMENT, null, "(statusLiteral)");
			}
			int index = 1;
			for (String literal : dto.getStatusLiterals()) {
				if (literal == null) {
					throw new FunctionalException(FunctionalException.Code.NULL_ARGUMENT, null, "statusLiteral #" + index);
				}
				if (Strings.isNullOrEmpty(literal.trim())) {
					throw new FunctionalException(FunctionalException.Code.VOID_ARGUMENT, null, "statusLiteral #" + index);
				}
				if (literal.length() > Consts.MAX_LABEL_SIZE) {
					throw new FunctionalException(FunctionalException.Code.SIZE_EXCEEDED, null, "statusLiteral #" + index);
				}
				index++;
			}
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
		if (access == AccessType.UPDATE) {
			EList<String> droppedStatusLiterals = vp.getStatusLiterals();
			for (String literal : dto.getStatusLiterals()) {
				droppedStatusLiterals.remove(literal);
			}
			// Check if a HasStatus item maps a status that has has been dropped
			for (String sl : droppedStatusLiterals) {
				if (util.containsStatusLiteral(vp.getId(), sl)) {
					throw new FunctionalException(FunctionalException.Code.STATUS_USED, null, "(status literal)");
				}
			}
			// Note that status literal unicity is ensure by the use of a Set in DTO
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.m2ling.service.principles.ViewPointService#getAllViewPoints(org.m2ling.common.soa.Context)
	 */
	public List<ViewPointDTO> getAllViewPoints(final Context context) {
		List<ViewPointDTO> vpDTOs = new ArrayList<ViewPointDTO>(10);
		Root root = pmanager.getRoot();
		for (ViewPoint vp : root.getViewPoints()) {
			ViewPointDTO dto = toDTO.getViewPointDTO(vp);
			vpDTOs.add(dto);
		}
		Collections.sort(vpDTOs);
		return vpDTOs;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.m2ling.service.principles.ViewPointService#getViewPointByName(org.m2ling.common.soa.Context
	 * , java.lang.String)
	 */
	@Override
	public ViewPointDTO getViewPointByName(final Context context, final String name) throws FunctionalException {
		{// Controls
			if (name == null) {
				throw new FunctionalException(FunctionalException.Code.NULL_ARGUMENT, null, "(name)");
			}
			if (Strings.isNullOrEmpty(name.trim())) {
				throw new FunctionalException(FunctionalException.Code.VOID_ARGUMENT, null, "(name)");
			}
		}
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
	 * @see
	 * org.m2ling.service.principles.ViewPointService#getViewPointByID(org.m2ling.common.soa.Context,
	 * java.lang.String)
	 */
	@Override
	public ViewPointDTO getViewPointByID(final Context context, String id) throws FunctionalException {
		{// controls
			if (id == null || Strings.isNullOrEmpty(id.trim())) {
				throw new FunctionalException(FunctionalException.Code.NULL_ARGUMENT, null, "(id)");
			}
		}
		ViewPoint vp = util.getViewPointByID(id);
		if (vp == null) {
			return null;
		}
		return toDTO.getViewPointDTO(vp);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.m2ling.service.principles.ViewPointService#createViewPoint(org.m2ling.common.soa.Context,
	 * org.m2ling.common.dto.core.ViewPointDTO)
	 */
	@Override
	public void createViewPoint(final Context context, final ViewPointDTO vpDTO) throws FunctionalException {
		// test DTO
		checkDTO(vpDTO, AccessType.CREATE);
		// Processing
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
	 * org.m2ling.service.principles.ViewPointService#updateViewPoint(org.m2ling.common.soa.Context,
	 * org.m2ling.common.dto.core.ViewPointDTO)
	 */
	@Override
	public void updateViewPoint(final Context context, final ViewPointDTO vpDTO) throws FunctionalException {
		// tests
		checkDTO(vpDTO, AccessType.UPDATE);
		// Processing
		ViewPoint vp = util.getViewPointByID(vpDTO.getId());
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
	 * @see
	 * org.m2ling.service.principles.ViewPointService#deleteViewPoint(org.m2ling.common.soa.Context,
	 * java.lang.String)
	 */
	@Override
	public void deleteViewPoint(final Context context, final String id) throws FunctionalException {
		ViewPoint vp = util.getViewPointByID(id);
		if (vp == null) {
			throw new FunctionalException(FunctionalException.Code.TARGET_NOT_FOUND, null, "id=" + id);
		}
		// Check for existing components or links using this vp
		EList<ComponentType> compTypes = vp.getComponentTypes();
		EList<LinkType> linkTypes = vp.getLinkTypes();
		for (View view : pmanager.getRoot().getViews()) {
			// test local VP component presence
			if (view.getViewPoint().equals(vp)) {
				for (Component comp : view.getComponents()) {
					if (compTypes.contains(comp.getType())) {
						throw new FunctionalException(FunctionalException.Code.VP_IN_USE, null, "(" + view.getName() + "/"
								+ comp.getName() + ")");
					}
				}
				for (Link link : view.getLinks()) {
					if (linkTypes.contains(link.getType())) {
						throw new FunctionalException(FunctionalException.Code.VP_IN_USE, null, "(" + view.getName() + "/"
								+ link.getName() + ")");
					}
				}
			}
			// Check for components from others VP bound to types from this VP
			else {
				for (Component comp : view.getComponents()) {
					ComponentType ct = comp.getType().getBoundType();
					if (ct != null && compTypes.contains(ct)) {
						throw new FunctionalException(FunctionalException.Code.VP_IN_USE, null, "(" + view.getName() + "/"
								+ comp.getName() + ")");
					}
				}
			}
		}
		pmanager.getRoot().getViewPoints().remove(vp);
	}
}

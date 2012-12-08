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
import org.m2ling.common.soa.Context;
import org.m2ling.domain.Root;
import org.m2ling.domain.core.ComponentType;
import org.m2ling.domain.core.View;
import org.m2ling.domain.core.ViewPoint;
import org.m2ling.persistence.PersistenceManager;
import org.m2ling.service.common.ServiceImpl;
import org.m2ling.service.util.CoreUtil;
import org.m2ling.service.util.DTOConverter;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * Viewpoint service nominal implementation
 * 
 * @author "Bertrand Florat <bertrand@florat.net>"
 * 
 */
@Singleton
public class ViewPointServiceImpl extends ServiceImpl implements ViewPointService {
	private ViewPointServiceChecker checker;

	/**
	 * Protected constructor to prevent direct instantiation
	 */
	@Inject
	protected ViewPointServiceImpl(PersistenceManager pm, CoreUtil util, DTOConverter.FromDTO fromDTO,
			DTOConverter.ToDTO toDTO, Conf conf, Logger logger, ViewPointServiceChecker checker) {
		super(pm, util, fromDTO, toDTO, conf, logger);
		this.checker = checker;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<ViewPointDTO> getAllViewPoints(final Context context) {
		List<ViewPointDTO> out = new ArrayList<ViewPointDTO>(10);
		try {
			Root root = pmanager.getRoot();
			for (ViewPoint vp : root.getViewPoints()) {
				ViewPointDTO dto = toDTO.getViewPointDTO(vp);
				out.add(dto);
			}
			Collections.sort(out);
		} catch (Exception ex) {
			handleTechException(ex);
		}
		return out;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ViewPointDTO getViewPointByID(final Context context, String id) throws FunctionalException {
		ViewPointDTO out = null;
		try {
			ViewPoint vp = util.getViewPointByID(id);
			if (vp != null) {
				out = toDTO.getViewPointDTO(vp);
			}
		} catch (Exception ex) {
			handleAnyException(ex);
		}
		return out;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void createViewPoint(final Context context, final ViewPointDTO vpDTO) throws FunctionalException {
		try {
			// test DTO
			checker.checkDTO(vpDTO, AccessType.CREATE);
			// Processing
			ViewPoint vp = fromDTO.newViewPoint(vpDTO);
			Root root = pmanager.getRoot();
			root.getViewPoints().add(vp);
		} catch (Exception ex) {
			handleAnyException(ex);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateViewPoint(final Context context, final ViewPointDTO vpDTO) throws FunctionalException {
		try {
			// tests
			checker.checkDTO(vpDTO, AccessType.UPDATE);
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
			vp.setStatus(vpDTO.getStatus());
		} catch (Exception ex) {
			handleAnyException(ex);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteViewPoint(final Context context, final String id) throws FunctionalException {
		try {
			ViewPoint vp = util.getViewPointByID(id);
			if (vp == null) {
				throw new FunctionalException(FunctionalException.Code.TARGET_NOT_FOUND, null, "id=" + id);
			}
			// Check for existing views using this vp
			EList<ComponentType> compTypes = vp.getComponentTypes();
			for (View view : pmanager.getRoot().getViews()) {
				// check for views of this type
				if (view.getViewPoint().equals(vp)) {
					throw new FunctionalException(FunctionalException.Code.VP_IN_USE, null, "View: " + view.getName());
				}
			}
			// Check for components from others VP bound to types from this VP
			for (ViewPoint vpToCheck : pmanager.getRoot().getViewPoints()) {
				if (!vpToCheck.equals(vp)) {
					for (ComponentType ct : vpToCheck.getComponentTypes()) {
						ComponentType boundCT = ct.getBoundType();
						if (boundCT != null && compTypes.contains(boundCT)) {
							throw new FunctionalException(FunctionalException.Code.VP_IN_USE, null, "Component type: "
									+ vpToCheck.getName() + "/" + ct.getName() + ")");
						}
					}
				}
			}
			pmanager.getRoot().getViewPoints().remove(vp);
		} catch (Exception ex) {
			handleAnyException(ex);
		}
	}
}

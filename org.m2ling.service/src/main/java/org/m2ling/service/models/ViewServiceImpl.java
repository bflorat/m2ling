/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.service.models;

import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

import org.m2ling.common.configuration.Conf;
import org.m2ling.common.dto.core.AccessType;
import org.m2ling.common.dto.core.ViewDTO;
import org.m2ling.common.exceptions.FunctionalException;
import org.m2ling.common.soa.Context;
import org.m2ling.common.utils.Utils;
import org.m2ling.domain.Root;
import org.m2ling.domain.core.Component;
import org.m2ling.domain.core.View;
import org.m2ling.persistence.PersistenceManager;
import org.m2ling.service.common.ServiceImpl;
import org.m2ling.service.util.DomainExplorer;
import org.m2ling.service.util.DTOConverter;

import com.google.common.collect.Lists;
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
	private ViewServiceChecker checker;

	/**
	 * Protected constructor to prevent direct instantiation
	 */
	@Inject
	protected ViewServiceImpl(PersistenceManager pm, DomainExplorer explorer, DTOConverter.FromDTO fromDTO,
			DTOConverter.ToDTO toDTO, Conf conf, Logger logger, ViewServiceChecker checker) {
		super(pm, explorer, fromDTO, toDTO, conf, logger);
		this.checker = checker;
	}

	/**
	 * {@inheritDoc}
	 **/
	@Override
	public List<ViewDTO> getAllViews(final Context context) throws FunctionalException {
		List<ViewDTO> out = Lists.newArrayList();
		try {
			Root root = pmanager.getRoot();
			for (View vp : root.getViews()) {
				ViewDTO dto = toDTO.getViewDTO(vp);
				out.add(dto);
			}
			Collections.sort(out);
		} catch (Exception anyError) {
			handleAnyException(anyError);
		}
		return out;
	}

	/**
	 * {@inheritDoc}
	 **/
	@Override
	public ViewDTO getViewByID(final Context context, String id) throws FunctionalException {
		ViewDTO out = null;
		try {
			// Controls
			if (id == null || Utils.isNullOrEmptyAfterTrim(id)) {
				throw new FunctionalException(FunctionalException.Code.NULL_ARGUMENT, null, "(id)");
			}
			View vp = explorer.getViewByID(id);
			if (vp != null) {
				out = toDTO.getViewDTO(vp);
			}
		} catch (Exception anyError) {
			handleAnyException(anyError);
		}
		return out;
	}

	/**
	 * {@inheritDoc}
	 **/
	@Override
	public void createView(final Context context, final ViewDTO dto) throws FunctionalException {
		try {
			// test DTO
			checker.checkDTO(dto, AccessType.CREATE);
			// Processing
			View view = fromDTO.newView(dto);
			Root root = pmanager.getRoot();
			root.getViews().add(view);
		} catch (Exception anyError) {
			handleAnyException(anyError);
		}
	}

	/**
	 * {@inheritDoc}
	 **/
	@Override
	public void updateView(final Context context, final ViewDTO vDTO) throws FunctionalException {
		try {
			// tests
			checker.checkDTO(vDTO, AccessType.UPDATE);
			// Processing (note that VP can't be changed so we don't set here)
			View view = explorer.getViewByID(vDTO.getId());
			view.setName(vDTO.getName());
			view.setDescription(vDTO.getDescription());
			view.setComment(vDTO.getComment());
			List<String> tags = view.getTags();
			tags.clear();
			tags.addAll(vDTO.getTags());
			// TODO Check that status is valid
			view.setStatus(vDTO.getStatus());
		} catch (Exception anyError) {
			handleAnyException(anyError);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteView(final Context context, final String id) throws FunctionalException {
		try {
			View view = explorer.getViewByID(id);
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
		} catch (Exception anyError) {
			handleAnyException(anyError);
		}
	}
}

/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.service.principles;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

import org.m2ling.common.configuration.Conf;
import org.m2ling.common.dto.core.AccessType;
import org.m2ling.common.dto.core.ComponentTypeDTO;
import org.m2ling.common.dto.core.HasNameAndIdDTO;
import org.m2ling.common.exceptions.FunctionalException;
import org.m2ling.common.exceptions.FunctionalException.Code;
import org.m2ling.common.soa.Context;
import org.m2ling.domain.Root;
import org.m2ling.domain.core.ArchitectureItem;
import org.m2ling.domain.core.ComponentType;
import org.m2ling.domain.core.ViewPoint;
import org.m2ling.persistence.PersistenceManager;
import org.m2ling.service.common.ServiceImpl;
import org.m2ling.service.util.CoreUtil;
import org.m2ling.service.util.DTOConverter;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * Nominal implementation for ComponentTypeService
 * 
 * @author "Bertrand Florat <bertrand@florat.net>"
 * 
 */
@Singleton
public class ComponentTypeServiceImpl extends ServiceImpl implements ComponentTypeService {
	private ComponentTypeServiceChecker checker;

	/**
	 * Protected constructor to prevent direct instantiation
	 */
	@Inject
	protected ComponentTypeServiceImpl(PersistenceManager pm, CoreUtil util, DTOConverter.FromDTO fromDTO,
			DTOConverter.ToDTO toDTO, Conf conf, Logger logger, ComponentTypeServiceChecker checker) {
		super(pm, util, fromDTO, toDTO, conf, logger);
		this.checker = checker;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateCT(final Context context, final ComponentTypeDTO dto) throws FunctionalException {
		try {
			// Controls
			checker.checkDTO(dto, AccessType.UPDATE);
			// Processing
			ComponentType ct = util.getComponentTypeByID(dto.getId());
			ct.setName(dto.getName());
			ct.setDescription(dto.getDescription());
			ct.setComment(dto.getComment());
			List<String> tags = ct.getTags();
			tags.clear();
			tags.addAll(dto.getTags());
			ComponentType boundType = null;
			if (dto.getBoundType() != null) {
				boundType = util.getComponentTypeByID(dto.getBoundType().getId());
			}
			ct.setBoundType(boundType);
			ct.setInstantiationFactor(dto.getInstantiationFactor());
			List<ArchitectureItem> enumeration = ct.getEnumeration();
			enumeration.clear();
			List<ArchitectureItem> newEnumeration = new ArrayList<ArchitectureItem>(dto.getEnumeration().size());
			for (HasNameAndIdDTO comp : dto.getEnumeration()) {
				ArchitectureItem ai = util.getComponentOrGroupByID(comp.getId());
				newEnumeration.add(ai);
			}
			enumeration.addAll(newEnumeration);
			ct.setStatus(dto.getStatus());
			pmanager.commit();
		} catch (Exception anyError) {
			handleAnyException(anyError);
		}
	}

	@Override
	public void createCT(final Context context, final ComponentTypeDTO dto) throws FunctionalException {
		try {
			// Controls
			checker.checkDTO(dto, AccessType.CREATE);
			// Processing
			ComponentType ct = fromDTO.newComponentType(dto);
			// Add the item
			ViewPoint vp = util.getViewPointByID(dto.getViewPoint().getId());
			vp.getComponentTypes().add(ct);
			pmanager.commit();
		} catch (Exception anyError) {
			handleAnyException(anyError);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<ComponentTypeDTO> getAllCT(final Context context, final String vp) throws FunctionalException {
		List<ComponentTypeDTO> out = Lists.newArrayList();
		try {
			// Controls
			if (util.getViewPointByID(vp) == null) {
				throw new FunctionalException(Code.TARGET_NOT_FOUND, null, "Viewpoint=" + vp.toString());
			}
			Root root = pmanager.getRoot();
			for (ViewPoint checked : root.getViewPoints()) {
				if (checked.getId().equals(vp)) {
					List<ComponentType> cts = checked.getComponentTypes();
					for (ComponentType ct : cts) {
						ComponentTypeDTO dto = toDTO.getComponentTypeDTO(ct);
						out.add(dto);
					}
					break;
				}
			}
			Collections.sort(out);
		} catch (Exception anyError) {
			handleAnyException(anyError);
		}
		return out;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteCT(final Context context, final String id) throws FunctionalException {
		try {
			// Controls
			ComponentTypeDTO dto = new ComponentTypeDTO.Builder(null, id, null).build();
			checker.checkDTO(dto, AccessType.DELETE);
			ComponentType ctToDelete = util.getComponentTypeByID(dto.getId());
			ViewPoint vp = (ViewPoint) ctToDelete.eContainer();
			vp.getComponentTypes().remove(ctToDelete);
			pmanager.commit();
		} catch (Exception anyError) {
			handleAnyException(anyError);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ComponentTypeDTO getCTByID(Context context, String id) throws FunctionalException {
		ComponentTypeDTO out = null;
		try {
			// Controls
			ComponentType ct = util.getComponentTypeByID(id);
			if (ct != null) {
				out = toDTO.getComponentTypeDTO(ct);
			}
		} catch (Exception anyError) {
			handleAnyException(anyError);
		}
		return out;
	}
}

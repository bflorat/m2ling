/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.service.principles.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

import org.m2ling.common.configuration.Conf;
import org.m2ling.common.dto.core.AccessType;
import org.m2ling.common.dto.core.ComponentTypeDTO;
import org.m2ling.common.dto.core.ReferenceDTO;
import org.m2ling.common.exceptions.FunctionalException;
import org.m2ling.common.exceptions.FunctionalException.Code;
import org.m2ling.common.soa.Context;
import org.m2ling.common.utils.Consts;
import org.m2ling.common.utils.Utils;
import org.m2ling.domain.Root;
import org.m2ling.domain.core.ArchitectureItem;
import org.m2ling.domain.core.ComponentType;
import org.m2ling.domain.core.ReferenceType;
import org.m2ling.domain.core.Type;
import org.m2ling.domain.core.ViewPoint;
import org.m2ling.persistence.PersistenceManager;
import org.m2ling.service.common.ServiceImpl;
import org.m2ling.service.principles.ComponentTypeService;
import org.m2ling.service.util.CoreUtil;
import org.m2ling.service.util.DTOConverter;

import com.google.common.base.Strings;
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
	/**
	 * Protected constructor to prevent direct instantiation
	 */
	@Inject
	protected ComponentTypeServiceImpl(PersistenceManager pm, CoreUtil util, DTOConverter.FromDTO fromDTO,
			DTOConverter.ToDTO toDTO, Conf conf, Logger logger) {
		super(pm, util, fromDTO, toDTO, conf, logger);
	}

	/**
	 * Centralize all service entry verifications
	 * 
	 * @param dto
	 * @param access
	 *           : access type used to discriminate the check
	 * @throws FunctionalException
	 */
	private void checkDTO(final ComponentTypeDTO dto, AccessType access) throws FunctionalException {
		// Nullity
		if (dto == null) {
			throw new FunctionalException(Code.NULL_ARGUMENT, null, null);
		}
		// item existence (except for creation access)
		if (access != AccessType.CREATE) {
			ComponentType ct = util.getComponentTypeByID(dto.getId());
			if (ct == null) {
				throw new FunctionalException(FunctionalException.Code.TARGET_NOT_FOUND, null, dto.toString());
			}
		}
		// Name
		if (access == AccessType.CREATE || access == AccessType.UPDATE) {
			if (dto.getName().length() == 0) {
				throw new FunctionalException(FunctionalException.Code.NULL_ARGUMENT, null, dto.toString());
			}
			if (dto.getName().length() > Consts.MAX_LABEL_SIZE) {
				throw new FunctionalException(FunctionalException.Code.SIZE_EXCEEDED, null, "name");
			}
		}
		// Check associated viewpoint existence
		ViewPoint vp = util.getViewPointByID(dto.getViewPointId());
		if (vp == null) {
			throw new FunctionalException(FunctionalException.Code.TARGET_NOT_FOUND, null, "viewpoint="
					+ dto.getViewPointId());
		}
		if (access == AccessType.CREATE) {
			// Check for existing item with the same id
			for (ComponentType item : vp.getComponentTypes()) {
				if (item.getId().equals(dto.getId())) {
					throw new FunctionalException(FunctionalException.Code.DUPLICATES, null, "id=" + dto.getId());
				}
			}
			// Check for existing item with the same name
			for (ComponentType item : vp.getComponentTypes()) {
				if (item.getName().equals(dto.getName())) {
					throw new FunctionalException(FunctionalException.Code.DUPLICATE_NAME, null, "name=" + dto.getName());
				}
			}
		}
		if (access == AccessType.CREATE || access == AccessType.UPDATE) {
			// Description
			if (dto.getDescription().length() > Consts.MAX_TEXT_SIZE) {
				throw new FunctionalException(FunctionalException.Code.SIZE_EXCEEDED, null, "(description)");
			}
			// Comment
			if (dto.getComment().length() > Consts.MAX_TEXT_SIZE) {
				throw new FunctionalException(FunctionalException.Code.SIZE_EXCEEDED, null, "(comment)");
			}
			// Tags
			Utils.checkTags(dto.getTags());
			// References
			List<ReferenceDTO> references = dto.getReferences();
			if (references == null) {
				throw new FunctionalException(FunctionalException.Code.NULL_ARGUMENT, null, "(references)");
			}
			for (ReferenceDTO refDTO : references) {
				if (ReferenceType.get(refDTO.getType()) == null) {
					throw new FunctionalException(FunctionalException.Code.INVALID_REFERENCE_TYPE, null, dto.toString());
				}
			}
			// Instantiation factor
			if (dto.getInstantiationFactor() < 0) {
				throw new FunctionalException(FunctionalException.Code.ILLEGAL_ARGUMENT, null, "instantiationFactor="
						+ dto.getInstantiationFactor());
			}
			if (dto.getInstantiationFactor() > 0 && !dto.isReifiable()) {
				throw new FunctionalException(FunctionalException.Code.NON_REIFIABLE_IFACTOR_SET, null, dto.toString());
			}
			// Bound type
			if (!Strings.isNullOrEmpty(dto.getBoundTypeID())) {
				// Check if the bound type exists in this VP or another one
				ComponentType ct = (ComponentType) util.getItemByTypeAndID(Type.COMPONENT_TYPE, dto.getBoundTypeID());
				if (ct == null) {
					throw new FunctionalException(FunctionalException.Code.TARGET_NOT_FOUND, null, "boundTypeID="
							+ dto.getBoundTypeID());
				}
			}
			// Enumeration
			List<String> enumeration = dto.getEnumeration();
			if (enumeration == null) {
				throw new FunctionalException(FunctionalException.Code.NULL_ARGUMENT, null, "(enumeration)");
			}
			if (dto.getEnumeration().size() > 0) {
			}
		}
	}

	@Override
	public void updateCT(final Context context, final ComponentTypeDTO dto) throws FunctionalException {
		// Controls
		checkDTO(dto, AccessType.UPDATE);
		// Processing
		ComponentType ct = util.getComponentTypeByID(dto.getId());
		ct.setName(dto.getName());
		ct.setDescription(dto.getDescription());
		ct.setComment(dto.getComment());
		List<String> tags = ct.getTags();
		tags.clear();
		tags.addAll(dto.getTags());
		ComponentType boundType = util.getComponentTypeByID(dto.getBoundTypeID());
		ct.setBoundType(boundType);
		ct.setInstantiationFactor(dto.getInstantiationFactor());
		ct.setReifiable(dto.isReifiable());
		List<ArchitectureItem> enumeration = ct.getEnumeration();
		enumeration.clear();
		List<ArchitectureItem> newEnumeration = new ArrayList<ArchitectureItem>(dto.getEnumeration().size());
		for (String compID : dto.getEnumeration()) {
			ArchitectureItem ai = util.getComponentByID(compID);
			newEnumeration.add(ai);
		}
		enumeration.addAll(newEnumeration);
	}

	@Override
	public void createCT(final Context context, final ComponentTypeDTO dto) throws FunctionalException {
		// Controls
		checkDTO(dto, AccessType.CREATE);
		// Processing
		ComponentType ct = fromDTO.newComponentType(dto);
		// Add the item
		ViewPoint vp = util.getViewPointByID(dto.getViewPointId());
		vp.getComponentTypes().add(ct);
	}

	@Override
	public List<ComponentTypeDTO> getAllCT(final Context context, final String vp) throws FunctionalException {
		{// Controls
			if (util.getViewPointByID(vp) == null) {
				throw new FunctionalException(Code.TARGET_NOT_FOUND, null, "Viewpoint=" + vp.toString());
			}
		}
		Root root = pmanager.getRoot();
		List<ComponentTypeDTO> out = Lists.newArrayList();
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
		return out;
	}

	@Override
	public void deleteCT(final Context context, final ComponentTypeDTO dto) throws FunctionalException {
		// Controls
		checkDTO(dto, AccessType.DELETE);
		ComponentType type = util.getComponentTypeByID(dto.getId());
		ViewPoint vp = (ViewPoint) type.eContainer();
		vp.getComponentTypes().remove(type);
	}
}

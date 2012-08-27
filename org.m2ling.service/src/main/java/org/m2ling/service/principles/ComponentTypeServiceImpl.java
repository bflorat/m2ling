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
import org.m2ling.common.dto.core.ReferenceDTO;
import org.m2ling.common.exceptions.FunctionalException;
import org.m2ling.common.exceptions.FunctionalException.Code;
import org.m2ling.common.soa.Context;
import org.m2ling.common.utils.Consts;
import org.m2ling.common.utils.Utils;
import org.m2ling.domain.Root;
import org.m2ling.domain.core.ArchitectureItem;
import org.m2ling.domain.core.Component;
import org.m2ling.domain.core.ComponentType;
import org.m2ling.domain.core.ReferenceType;
import org.m2ling.domain.core.Type;
import org.m2ling.domain.core.View;
import org.m2ling.domain.core.ViewPoint;
import org.m2ling.persistence.PersistenceManager;
import org.m2ling.service.common.ServiceImpl;
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
	void checkDTO(final ComponentTypeDTO dto, AccessType access) throws FunctionalException {
		ComponentType target = null;
		// Nullity
		if (dto == null) {
			throw new FunctionalException(Code.NULL_ARGUMENT, null, null);
		}
		// Check id
		if (dto.getId() == null){
			throw new FunctionalException(FunctionalException.Code.NULL_ARGUMENT, null, "(id)");
		}
		if (Strings.isNullOrEmpty(dto.getId().trim())){
			throw new FunctionalException(FunctionalException.Code.VOID_ARGUMENT, null, "(id)");
		}
		if (dto.getId().length() > 40) {
			throw new FunctionalException(FunctionalException.Code.SIZE_EXCEEDED, null, "(id)");
		}
		// Check name
		if (access == AccessType.CREATE || access == AccessType.UPDATE) {
			// Name can be null
			if (dto.getName() != null) {
				if ("".equals(dto.getName().trim())) {
					throw new FunctionalException(FunctionalException.Code.VOID_ARGUMENT, null, "(name)");
				}
				if (dto.getName().length() > Consts.MAX_LABEL_SIZE) {
					throw new FunctionalException(FunctionalException.Code.SIZE_EXCEEDED, null, "(name)");
				}
			}
		}
		// item existence (except for creation access)
		if (access != AccessType.CREATE) {
			target = util.getComponentTypeByID(dto.getId());
			if (target == null) {
				throw new FunctionalException(FunctionalException.Code.TARGET_NOT_FOUND, null, dto.toString());
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
			if (dto.getDescription() != null && dto.getDescription().length() > Consts.MAX_TEXT_SIZE) {
				throw new FunctionalException(FunctionalException.Code.SIZE_EXCEEDED, null, "(description)");
			}
			// Comment
			if (dto.getComment() != null && dto.getComment().length() > Consts.MAX_TEXT_SIZE) {
				throw new FunctionalException(FunctionalException.Code.SIZE_EXCEEDED, null, "(comment)");
			}
			// Tags
			Utils.checkTags(dto.getTags());
			// References
			List<ReferenceDTO> references = dto.getReferences();
			// Check global nullity
			if (references == null) {
				throw new FunctionalException(FunctionalException.Code.NULL_ARGUMENT, null, "(references)");
			}
			for (ReferenceDTO refDTO : references) {
				// check reference nullity
				if (refDTO == null) {
					throw new FunctionalException(FunctionalException.Code.NULL_ARGUMENT, null, "(references)");
				}
				// check reference type
				if (ReferenceType.get(refDTO.getType()) == null) {
					throw new FunctionalException(FunctionalException.Code.INVALID_REFERENCE_TYPE, null, dto.toString());
				}
				// check reference targets and type
				if (refDTO.getTargets() == null) {
					throw new FunctionalException(FunctionalException.Code.NULL_ARGUMENT, null, "(references/target)");
				}
				// check targets non-existence
				for (String targetID : refDTO.getTargets()) {
					if (util.getComponentTypeByID(targetID) == null) {
						throw new FunctionalException(FunctionalException.Code.TARGET_NOT_FOUND, null, "(references/target)");
					}
				}
			}
			// Instantiation factor, -1 or any positive value is valid
			if (dto.getInstantiationFactor() < 0 && dto.getInstantiationFactor() != -1) {
				throw new FunctionalException(FunctionalException.Code.WRONG_IF, null, "instantiationFactor="
						+ dto.getInstantiationFactor());
			}
			if ((dto.getInstantiationFactor() > 0 || dto.getInstantiationFactor() == -1) && !dto.isReifiable()) {
				throw new FunctionalException(FunctionalException.Code.NON_REIFIABLE_IFACTOR_SET, null, dto.toString());
			}
			if (dto.getInstantiationFactor() == 0 && dto.isReifiable()) {
				throw new FunctionalException(FunctionalException.Code.NON_REIFIABLE_IFACTOR_SET, null, dto.toString());
			}
			// Bound type
			if (dto.getBoundTypeID() != null) {
				// Check if the bound type exists
				ComponentType boundCT = (ComponentType) util.getItemByTypeAndID(Type.COMPONENT_TYPE, dto.getBoundTypeID());
				if (boundCT == null) {
					throw new FunctionalException(FunctionalException.Code.TARGET_NOT_FOUND, null, "boundTypeID="
							+ dto.getBoundTypeID());
				}
				// Check that the bound type is from another VP
				ViewPoint vpBoundType = (ViewPoint) boundCT.eContainer();
				if (vpBoundType.equals(vp)) {
					throw new FunctionalException(FunctionalException.Code.LOCAL_BINDING, null, null);
				}
				// Check if the bound type is not bounded itself
				if (boundCT.getBoundType() != null) {
					throw new FunctionalException(FunctionalException.Code.BOUND_TYPE_BOUND, null, "boundTypeID="
							+ dto.getBoundTypeID());
				}
				// Check for bound types that we don't try to set a reifiable flag or a instantiation
				// factor different from bound type
				if (boundCT.isReifiable() != dto.isReifiable()) {
					throw new FunctionalException(FunctionalException.Code.DELTA_BINDING_REIFIABLE, null,
							"boundType reifiable=" + boundCT.isReifiable());
				}
				if (boundCT.getInstantiationFactor() != dto.getInstantiationFactor()) {
					throw new FunctionalException(FunctionalException.Code.DELTA_BINDING_IF, null,
							"boundType instantiation factor=" + boundCT.getInstantiationFactor());
				}
			}
			// Enumeration, the list should contain a list of component ids from bound-type type
			List<String> enumeration = dto.getEnumeration();
			if (enumeration == null) {
				throw new FunctionalException(FunctionalException.Code.NULL_ARGUMENT, null, "(enumeration)");
			}
			// enumeration can't be provided without associated binding type
			if (enumeration.size() > 0 && dto.getBoundTypeID() == null) {
				throw new FunctionalException(FunctionalException.Code.NULL_BOUND_TYPE_ENUMERATION, null, "(bound type)");
			}
			// Check that every every component or component group exists and is of boundtype
			for (String compId : enumeration) {
				ArchitectureItem item = null;
				item = util.getComponentByID(compId);
				// unknown component ? ok, search in groups
				if (item == null) {
					item = util.getComponentGroupByID(compId);
				}
				// still nothing ? leave in error
				if (item == null) {
					throw new FunctionalException(FunctionalException.Code.TARGET_NOT_FOUND, null, "(enumeration)");
				}
				// check that every component or group share the same CT = bound type
				ComponentType ct = util.getComponentTypeForArchitectureItem(item);
				if (!ct.getId().equals(dto.getBoundTypeID())) {
					throw new FunctionalException(FunctionalException.Code.INVALID_TYPE, null, "(enumeration)");
				}
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
	public void deleteCT(final Context context, final String id) throws FunctionalException {
		{// Controls
			if (id == null || Strings.isNullOrEmpty(id.trim())) {
				throw new FunctionalException(FunctionalException.Code.NULL_ARGUMENT, null, "(id)");
			}
		}
		ComponentType type = util.getComponentTypeByID(id);
		if (type == null) {
			throw new FunctionalException(FunctionalException.Code.TARGET_NOT_FOUND, null, "id=" + id);
		}
		// Check CT20 : none component of this type
		for (View view : pmanager.getRoot().getViews()) {
			for (Component comp : view.getComponents()) {
				if (comp.getType().equals(type)) {
					throw new FunctionalException(FunctionalException.Code.CT_EXISTING_COMP, null,
							"component name=" + comp.getName());
				}
			}
		}
		// Check CT21 : none CT binding against this CT
		for (ViewPoint vp : pmanager.getRoot().getViewPoints()) {
			for (ComponentType ct : vp.getComponentTypes()) {
				if (!(ct.equals(type)) && type.equals(ct.getBoundType())) {
					throw new FunctionalException(FunctionalException.Code.CT_EXISTING_BINDING, null,
							"componenet type name=" + ct.getName());
				}
			}
		}
		ViewPoint vp = (ViewPoint) type.eContainer();
		vp.getComponentTypes().remove(type);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.m2ling.service.principles.ComponentTypeService#getCTByID(org.m2ling.common.soa.Context,
	 * java.lang.String)
	 */
	@Override
	public ComponentTypeDTO getCTByID(Context context, String id) throws FunctionalException {
		{// Controls
			if (id == null || Strings.isNullOrEmpty(id.trim())) {
				throw new FunctionalException(FunctionalException.Code.NULL_ARGUMENT, null, "(id)");
			}
		}
		ComponentType ct = util.getComponentTypeByID(id);
		if (ct == null) {
			return null;
		}
		return toDTO.getComponentTypeDTO(ct);
	}
}

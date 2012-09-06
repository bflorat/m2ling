/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.service.principles;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EcoreUtil.EqualityHelper;
import org.m2ling.common.configuration.Conf;
import org.m2ling.common.dto.core.AccessType;
import org.m2ling.common.dto.core.ComponentTypeDTO;
import org.m2ling.common.dto.core.HasNameAndIdDTO;
import org.m2ling.common.dto.core.ReferenceDTO;
import org.m2ling.common.exceptions.FunctionalException;
import org.m2ling.common.exceptions.FunctionalException.Code;
import org.m2ling.common.soa.Context;
import org.m2ling.common.utils.Consts;
import org.m2ling.common.utils.Utils;
import org.m2ling.domain.Root;
import org.m2ling.domain.core.ArchitectureItem;
import org.m2ling.domain.core.Component;
import org.m2ling.domain.core.ComponentInstance;
import org.m2ling.domain.core.ComponentType;
import org.m2ling.domain.core.HasNameAndID;
import org.m2ling.domain.core.Reference;
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
	 * Return whether the reference list contains the reference ref
	 * 
	 * @param list
	 * @param ref
	 * @return whether the reference list contains the reference ref
	 */
	private boolean containsRef(List<Reference> list, Reference checked) {
		EqualityHelper eh = new EcoreUtil.EqualityHelper();
		for (Reference ref : list) {
			if (eh.equals(ref, checked)) {
				return true;
			}
		}
		return false;
	}

	private void checkIF(final ComponentTypeDTO dto, AccessType access) throws FunctionalException {
		int ifactor = dto.getInstantiationFactor();
		int maxNbInstances = 0;
		for (Component comp : util.getComponentsForCTID(dto.getId())) {
			List<ComponentInstance> instances = util.getComponentsInstancesForComponentID(comp.getId());
			if (instances.size() > maxNbInstances) {
				maxNbInstances = instances.size();
			}
		}
		// Instantiation factor, -1 or any positive value is valid
		if (ifactor < 0 && ifactor != -1) {
			throw new FunctionalException(FunctionalException.Code.WRONG_IF, null, "instantiationFactor="
					+ dto.getInstantiationFactor());
		}
		// check CT-31
		if (ifactor != -1 && ifactor < maxNbInstances) {
			throw new FunctionalException(FunctionalException.Code.CT_INSUFFISENT_IF, null, dto.toString());
		}
	}

	private void checkBoundType(final ComponentTypeDTO dto, AccessType access) throws FunctionalException {
		if (dto.getBoundType() != null && dto.getBoundType().getId() != null) {
			// Check if the bound type exists
			ComponentType boundCT = (ComponentType) util.getItemByTypeAndID(Type.COMPONENT_TYPE, dto.getBoundType()
					.getId());
			if (boundCT == null) {
				throw new FunctionalException(FunctionalException.Code.TARGET_NOT_FOUND, null, "boundTypeID="
						+ dto.getBoundType().getId());
			}
			// Check that the bound type is from another VP
			ViewPoint vp = util.getViewPointByID(dto.getViewPoint().getId());
			ViewPoint vpBoundType = (ViewPoint) boundCT.eContainer();
			if (vpBoundType.equals(vp)) {
				throw new FunctionalException(FunctionalException.Code.LOCAL_BINDING, null, null);
			}
			// Check if the bound type is not bounded itself
			if (boundCT.getBoundType() != null) {
				throw new FunctionalException(FunctionalException.Code.BOUND_TYPE_BOUND, null, "boundTypeID="
						+ dto.getBoundType().getId());
			}
			if (boundCT.getInstantiationFactor() != dto.getInstantiationFactor()) {
				throw new FunctionalException(FunctionalException.Code.DELTA_BINDING_IF, null,
						"boundType instantiation factor=" + boundCT.getInstantiationFactor());
			}
		}
	}

	private void checkIdAndName(final ComponentTypeDTO dto, AccessType access) throws FunctionalException {
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
	}

	private void checkReferences(final ComponentTypeDTO dto, AccessType access) throws FunctionalException {
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
			for (HasNameAndIdDTO target : refDTO.getTargets()) {
				if (target == null) {
					throw new FunctionalException(FunctionalException.Code.NULL_ARGUMENT, null, "(references/target)");
				}
				if (util.getComponentTypeByID(target.getId()) == null) {
					throw new FunctionalException(FunctionalException.Code.TARGET_NOT_FOUND, null, "(references/target)");
				}
			}
		}
		// check that we don't drop a used reference
		if (access == AccessType.UPDATE) {
			List<Reference> dtoRefs = new ArrayList<Reference>();
			for (ReferenceDTO r : dto.getReferences()) {
				dtoRefs.add(fromDTO.newReference(r));
			}
			ComponentType ct = util.getComponentTypeByID(dto.getId());
			EList<Reference> currentRefs = ct.getReferences();
			for (Reference currentRef : currentRefs) {
				if (!containsRef(dtoRefs, currentRef)) {
					// a reference has been dropped
					for (Component comp : util.getComponentsForCTID(dto.getId())) {
						for (Reference compRef : comp.getReferences()) {
							for (HasNameAndID target : compRef.getTargets()) {
								Component compTarget = (Component) target;
								if (currentRef.getTargets().contains(compTarget.getType())) {
									throw new FunctionalException(FunctionalException.Code.CT_REFERENCE_IN_USE, null,
											"component=" + comp.getName());
								}
							}
						}
					}
				}
			}
		}
	}

	private void checkEnumeration(final ComponentTypeDTO dto, AccessType access) throws FunctionalException {
		List<HasNameAndIdDTO> enumeration = dto.getEnumeration();
		if (enumeration == null) {
			throw new FunctionalException(FunctionalException.Code.NULL_ARGUMENT, null, "(enumeration)");
		}
		// enumeration can't be provided without associated binding type
		if (enumeration.size() > 0 && (dto.getBoundType() == null || dto.getBoundType().getId() == null)) {
			throw new FunctionalException(FunctionalException.Code.NULL_BOUND_TYPE_ENUMERATION, null, "(bound type)");
		}
		// Check that every every component or component group exists and is of boundtype
		for (HasNameAndIdDTO comp : enumeration) {
			if (comp == null || comp.getId() == null) {
				throw new FunctionalException(FunctionalException.Code.NULL_ARGUMENT, null, "(enumeration)");
			}
			ArchitectureItem item = null;
			item = util.getComponentByID(comp.getId());
			// unknown component ? ok, search in groups
			if (item == null) {
				item = util.getComponentGroupByID(comp.getId());
			}
			// still nothing ? leave in error
			if (item == null) {
				throw new FunctionalException(FunctionalException.Code.TARGET_NOT_FOUND, null, "(enumeration)");
			}
			// check that every component or group share the same CT = bound type
			ComponentType ct = util.getComponentTypeForArchitectureItem(item);
			if (!ct.getId().equals(dto.getBoundType().getId())) {
				throw new FunctionalException(FunctionalException.Code.INVALID_TYPE, null, "(enumeration)");
			}
		}
	}

	private void checkBeforeDeletion(final ComponentTypeDTO dto, AccessType access) throws FunctionalException {
		ComponentType type = util.getComponentTypeByID(dto.getId());
		// Check CT20 : none component of this type
		for (View view : pmanager.getRoot().getViews()) {
			for (Component comp : view.getComponents()) {
				if (comp.getType().equals(type)) {
					throw new FunctionalException(FunctionalException.Code.CT_EXISTING_COMP, null, "component name="
							+ comp.getName());
				}
			}
		}
		// Check CT21 : none CT binding against this CT
		for (ViewPoint vp : pmanager.getRoot().getViewPoints()) {
			for (ComponentType ct : vp.getComponentTypes()) {
				if (!(ct.equals(type)) && type.equals(ct.getBoundType())) {
					throw new FunctionalException(FunctionalException.Code.CT_EXISTING_BINDING, null, "component type name="
							+ ct.getName());
				}
			}
		}
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
		checkIdAndName(dto, access);
		// item existence (except for creation access)
		if (access != AccessType.CREATE) {
			target = util.getComponentTypeByID(dto.getId());
			if (target == null) {
				throw new FunctionalException(FunctionalException.Code.TARGET_NOT_FOUND, null, dto.toString());
			}
		}
		// Check associated viewpoint existence
		if (dto.getViewPoint() == null || dto.getViewPoint().getId() == null) {
			throw new FunctionalException(FunctionalException.Code.NULL_ARGUMENT, null, "(viewpoint)");
		}
		ViewPoint vp = util.getViewPointByID(dto.getViewPoint().getId());
		if (vp == null) {
			throw new FunctionalException(FunctionalException.Code.TARGET_NOT_FOUND, null, "viewpoint="
					+ dto.getViewPoint().getId());
		}
		// check before deletion
		if (access == AccessType.DELETE) {
			checkBeforeDeletion(dto, access);
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
			checkReferences(dto, access);
			// Instantiation factor
			checkIF(dto, access);
			// Bound type
			checkBoundType(dto, access);
			// Enumeration, the list should contain a list of component ids from bound-type type
			checkEnumeration(dto, access);
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
			ArchitectureItem ai = util.getComponentByID(comp.getId());
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
		ViewPoint vp = util.getViewPointByID(dto.getViewPoint().getId());
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
		{// Controls
			checkDTO(dto, AccessType.DELETE);
		}
		ComponentType type = util.getComponentTypeByID(dto.getId());
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

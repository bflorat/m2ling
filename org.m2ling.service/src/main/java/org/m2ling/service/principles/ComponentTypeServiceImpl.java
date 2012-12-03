/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.service.principles;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import org.eclipse.emf.common.util.EList;
import org.m2ling.common.configuration.Conf;
import org.m2ling.common.dto.core.AccessType;
import org.m2ling.common.dto.core.ComponentTypeDTO;
import org.m2ling.common.dto.core.HasNameAndIdDTO;
import org.m2ling.common.dto.core.ReferenceDTO;
import org.m2ling.common.exceptions.FunctionalException;
import org.m2ling.common.exceptions.FunctionalException.Code;
import org.m2ling.common.soa.Context;
import org.m2ling.domain.Root;
import org.m2ling.domain.core.ArchitectureItem;
import org.m2ling.domain.core.Component;
import org.m2ling.domain.core.ComponentInstance;
import org.m2ling.domain.core.ComponentType;
import org.m2ling.domain.core.HasNameAndID;
import org.m2ling.domain.core.Reference;
import org.m2ling.domain.core.Type;
import org.m2ling.domain.core.View;
import org.m2ling.domain.core.ViewPoint;
import org.m2ling.persistence.PersistenceManager;
import org.m2ling.service.common.ReferenceHelper;
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
	private ReferenceHelper refHelper;

	/**
	 * Protected constructor to prevent direct instantiation
	 */
	@Inject
	protected ComponentTypeServiceImpl(PersistenceManager pm, CoreUtil util, DTOConverter.FromDTO fromDTO,
			DTOConverter.ToDTO toDTO, Conf conf, Logger logger, ReferenceHelper refHelper) {
		super(pm, util, fromDTO, toDTO, conf, logger);
		this.refHelper = refHelper;
	}

	private void checkIF(final ComponentTypeDTO dto, AccessType access, final ComponentType ct)
			throws FunctionalException {
		int ifactor = dto.getInstantiationFactor();
		int maxNbInstances = 0;
		// Instantiation factor, -1 or any positive value is valid
		if (ifactor < 0 && ifactor != -1) {
			throw new FunctionalException(FunctionalException.Code.WRONG_IF, null, "instantiationFactor="
					+ dto.getInstantiationFactor());
		}
		if (access == AccessType.UPDATE) {
			for (Component comp : util.getComponentsForCTID(dto.getId())) {
				List<ComponentInstance> instances = util.getComponentsInstancesForComponentID(comp.getId());
				if (instances.size() > maxNbInstances) {
					maxNbInstances = instances.size();
				}
			}
			// check CT-31
			if (ifactor != -1 && ifactor < maxNbInstances) {
				throw new FunctionalException(FunctionalException.Code.CT_INSUFFISENT_IF, null, dto.toString());
			}
		}
	}

	private void checkBoundType(final ComponentTypeDTO dto, AccessType access, final ComponentType target)
			throws FunctionalException {
		if (access == AccessType.UPDATE) {
			checkNoIllegalBindingChange(dto, target);
		}
		if (!isNullBinding(dto)) {
			ComponentType boundCT = util.getComponentTypeByID(dto.getBoundType().getId());
			checkBoundTypeExists(boundCT);
			checkBoundTypeIsFromAnotherVP(dto, boundCT);
			checkNoChainBinding(dto, boundCT);
		}
	}

	private void checkBoundTypeExists(final ComponentType ct) throws FunctionalException {
		// Check if the bound type exists
		if (ct == null || util.getComponentTypeByID(ct.getId()) == null) {
			throw new FunctionalException(FunctionalException.Code.TARGET_NOT_FOUND, null, "(boundType)");
		}
	}

	private void checkNoIllegalBindingChange(final ComponentTypeDTO dto, final ComponentType target)
			throws FunctionalException {
		ComponentType currentCT = target.getBoundType();
		boolean existingCompsForChangedType = (util.getComponentsForCTID(target.getId()).size() > 0);
		// Attempt to drop the bound type
		if (isNullBinding(dto) && currentCT != null && existingCompsForChangedType) {
			throw new FunctionalException(FunctionalException.Code.CT_CANNOT_CHANGE_BINDING, null, "Current bound type="
					+ dto.getBoundType());
		}
		// Attempt to change the bound type (note that we handle the case where currentCT is null)
		if (!isNullBinding(dto) && !dto.getBoundType().getId().equals(currentCT.getId()) && existingCompsForChangedType) {
			throw new FunctionalException(FunctionalException.Code.CT_CANNOT_CHANGE_BINDING, null, "Current bound type="
					+ dto.getBoundType());
		}
	}

	private boolean isNullBinding(final ComponentTypeDTO dto) {
		return dto.getBoundType() == null || Strings.isNullOrEmpty(dto.getBoundType().getId());
	}

	/**
	 * @param dto
	 * @param boundCT
	 * @throws FunctionalException
	 */
	private void checkBoundTypeIsFromAnotherVP(final ComponentTypeDTO dto, ComponentType boundCT)
			throws FunctionalException {
		// Check that the bound type is from another VP
		ViewPoint vp = util.getViewPointByID(dto.getViewPoint().getId());
		ViewPoint vpBoundType = (ViewPoint) boundCT.eContainer();
		if (vpBoundType.equals(vp)) {
			throw new FunctionalException(FunctionalException.Code.LOCAL_BINDING, null, null);
		}
	}

	/**
	 * @param dto
	 * @param boundCT
	 * @throws FunctionalException
	 */
	private void checkNoChainBinding(final ComponentTypeDTO dto, ComponentType boundCT) throws FunctionalException {
		// Check if the bound type is not bounded itself
		if (boundCT.getBoundType() != null) {
			throw new FunctionalException(FunctionalException.Code.BOUND_TYPE_BOUND, null, "boundTypeID="
					+ dto.getBoundType().getId());
		}
	}

	private void checkReferences(final ComponentTypeDTO dto, AccessType access) throws FunctionalException {
		List<ReferenceDTO> references = dto.getReferences();
		// Check global nullity
		if (references == null) {
			throw new FunctionalException(FunctionalException.Code.NULL_ARGUMENT, null, "(references)");
		}
		for (ReferenceDTO refDTO : references) {
			refHelper.checkReferenceFormat(refDTO);
			refHelper.checkTargetsExistence(refDTO, getManagedType());
			checkTargetsAreLocal(dto, refDTO);
		}
		if (access == AccessType.UPDATE) {
			// check that we don't drop a used reference
			checkReferenceDrop(dto);
		}
	}

	/**
	 * @param dto
	 * @throws FunctionalException
	 */
	private void checkReferenceDrop(final ComponentTypeDTO dto) throws FunctionalException {
		List<Reference> dtoRefs = new ArrayList<Reference>();
		for (ReferenceDTO r : dto.getReferences()) {
			dtoRefs.add(fromDTO.newReference(r));
		}
		ComponentType ct = util.getComponentTypeByID(dto.getId());
		EList<Reference> currentRefs = ct.getReferences();
		for (Reference currentRef : currentRefs) {
			if (!refHelper.containsRef(dtoRefs, currentRef)) {
				// a reference has been dropped
				for (Component comp : util.getComponentsForCTID(dto.getId())) {
					for (Reference compRef : comp.getReferences()) {
						for (HasNameAndID target : compRef.getTargets()) {
							Component compTarget = (Component) target;
							if (currentRef.getTargets().contains(compTarget.getType())) {
								throw new FunctionalException(FunctionalException.Code.CT_REFERENCE_IN_USE, null, "component="
										+ comp.getName());
							}
						}
					}
				}
			}
		}
	}

	private void checkTargetsAreLocal(final ComponentTypeDTO dto, ReferenceDTO refDTO) throws FunctionalException {
		// check targets existence and the fact that targets types are local (in the CT VP)
		// VP can't be null, already controlled
		ViewPoint thisVP = util.getViewPointByID(dto.getViewPoint().getId());
		for (HasNameAndIdDTO target : refDTO.getTargets()) {
			ComponentType ctTarget = util.getComponentTypeByID(target.getId());
			if (!thisVP.getComponentTypes().contains(ctTarget)) {
				throw new FunctionalException(FunctionalException.Code.INVALID_REFERENCE_TYPE, null, dto.getReferences()
						.toString());
			}
		}
	}

	private void checkEnumeration(final ComponentTypeDTO dto, AccessType access) throws FunctionalException {
		Set<HasNameAndIdDTO> enumeration = dto.getEnumeration();
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
		checkNullDTO(dto);
		checkID(dto, access);
		if (dto.getBoundType() == null) {
			checkNameWhenRequired(dto, access);
		} else {
			checkNameWhenNotRequired(dto, access);
		}
		// item existence (except for creation access)
		if (access != AccessType.CREATE) {
			target = util.getComponentTypeByID(dto.getId());
			if (target == null) {
				throw new FunctionalException(FunctionalException.Code.TARGET_NOT_FOUND, null, dto.toString());
			}
		}
		if (access == AccessType.CREATE || access == AccessType.UPDATE) {
			checkVPExist(dto);
			checkComment(dto.getComment());
			checkStatus(dto.getViewPoint(), dto.getStatus());
			checkTags(dto.getTags());
			checkReferences(dto, access);
			// Bound type
			checkBoundType(dto, access, target);
			// Instantiation factor
			checkIF(dto, access, target);
			// Enumeration, the list should contain a list of component ids from bound-type type
			checkEnumeration(dto, access);
			// Description
			if (dto.getBoundType() == null) {
				checkDescriptionMandatory(dto.getDescription());
			} else {
				checkDescriptionNotMandatory(dto.getDescription());
			}
		}
	}

	/**
	 * @param dto
	 * @throws FunctionalException
	 */
	private void checkVPExist(final ComponentTypeDTO dto) throws FunctionalException {
		// Check associated viewpoint existence
		if (dto.getViewPoint() == null || dto.getViewPoint().getId() == null) {
			throw new FunctionalException(FunctionalException.Code.NULL_ARGUMENT, null, "(viewpoint)");
		}
		ViewPoint vp = util.getViewPointByID(dto.getViewPoint().getId());
		if (vp == null) {
			throw new FunctionalException(FunctionalException.Code.TARGET_NOT_FOUND, null, "viewpoint="
					+ dto.getViewPoint().getId());
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateCT(final Context context, final ComponentTypeDTO dto) throws FunctionalException {
		try {
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
			checkDTO(dto, AccessType.CREATE);
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
			checkID(dto, AccessType.DELETE);
			checkBeforeDeletion(dto, AccessType.DELETE);
			ComponentType type = util.getComponentTypeByID(dto.getId());
			ViewPoint vp = (ViewPoint) type.eContainer();
			vp.getComponentTypes().remove(type);
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
			if (id == null || Strings.isNullOrEmpty(id.trim())) {
				throw new FunctionalException(FunctionalException.Code.NULL_ARGUMENT, null, "(id)");
			}
			ComponentType ct = util.getComponentTypeByID(id);
			if (ct != null) {
				out = toDTO.getComponentTypeDTO(ct);
			}
		} catch (Exception anyError) {
			handleAnyException(anyError);
		}
		return out;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Type getManagedType() {
		return Type.COMPONENT_TYPE;
	}
}

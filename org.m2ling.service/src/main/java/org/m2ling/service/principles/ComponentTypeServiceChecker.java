/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.service.principles;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.m2ling.common.dto.core.AccessType;
import org.m2ling.common.dto.core.ComponentTypeDTO;
import org.m2ling.common.dto.core.HasNameAndIdDTO;
import org.m2ling.common.dto.core.ReferenceDTO;
import org.m2ling.common.exceptions.FunctionalException;
import org.m2ling.common.utils.Utils;
import org.m2ling.domain.core.ArchitectureItem;
import org.m2ling.domain.core.Component;
import org.m2ling.domain.core.ComponentInstance;
import org.m2ling.domain.core.ComponentType;
import org.m2ling.domain.core.HasNameAndID;
import org.m2ling.domain.core.LinkType;
import org.m2ling.domain.core.Reference;
import org.m2ling.domain.core.Type;
import org.m2ling.domain.core.View;
import org.m2ling.domain.core.ViewPoint;
import org.m2ling.persistence.PersistenceManager;
import org.m2ling.service.common.ReferenceHelper;
import org.m2ling.service.common.ServiceChecker;
import org.m2ling.service.util.DomainExplorer;
import org.m2ling.service.util.DTOConverter;

import com.google.inject.Inject;

/**
 * Check DTo before executing a service
 * 
 * @author "Bertrand Florat <bertrand@florat.net>"
 * 
 */
class ComponentTypeServiceChecker extends ServiceChecker {
	@Inject
	public ComponentTypeServiceChecker(PersistenceManager pm, DomainExplorer explorer, DTOConverter.FromDTO fromDTO,
			ReferenceHelper refHelper) {
		super(pm, explorer, fromDTO, refHelper);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Type getManagedType() {
		return Type.COMPONENT_TYPE;
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
		if (access == AccessType.DELETE) {
			ComponentType ctToDelete = explorer.getComponentTypeByID(dto.getId());
			// at this point, the CT exists (tested in checkID())
			ViewPoint vp = (ViewPoint) ctToDelete.eContainer();
			checkNoneComponentForThisCT(ctToDelete);
			checkNoneBindingToThisCT(ctToDelete);
			checkNoReferenceToThisCT(vp, ctToDelete);
			checkNoLinkTypeInvolvingThisCT(vp, ctToDelete);
		}
		else if (access == AccessType.CREATE || access == AccessType.UPDATE) {
			target = explorer.getComponentTypeByID(dto.getId());
			if (dto.getBoundType() == null) {
				checkNameWhenRequired(dto, access);
			} else {
				checkNameWhenNotRequired(dto, access);
			}
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

	void checkIF(final ComponentTypeDTO dto, AccessType access, final ComponentType ct)
			throws FunctionalException {
		int ifactor = dto.getInstantiationFactor();
		int maxNbInstances = 0;
		// Instantiation factor, -1 or any positive value is valid
		if (ifactor < 0 && ifactor != -1) {
			throw new FunctionalException(FunctionalException.Code.WRONG_IF, null, "instantiationFactor="
					+ dto.getInstantiationFactor());
		}
		if (access == AccessType.UPDATE) {
			for (Component comp : explorer.getComponentsForCTID(dto.getId())) {
				List<ComponentInstance> instances = explorer.getComponentsInstancesForComponentID(comp.getId());
				if (instances.size() > maxNbInstances) {
					maxNbInstances = instances.size();
				}
			}
			if (ifactor != -1 && ifactor < maxNbInstances) {
				throw new FunctionalException(FunctionalException.Code.CT_INSUFFISENT_IF, null, dto.toString());
			}
		}
	}

	void checkBoundType(final ComponentTypeDTO dto, AccessType access, final ComponentType target)
			throws FunctionalException {
		if (access == AccessType.UPDATE) {
			checkNoIllegalBindingChange(dto, target);
		}
		if (!isNullBinding(dto)) {
			ComponentType boundCT = explorer.getComponentTypeByID(dto.getBoundType().getId());
			checkBoundTypeExists(boundCT);
			checkBoundTypeIsFromAnotherVP(dto, boundCT);
			checkNoChainBinding(dto, boundCT);
		}
	}

	private void checkBoundTypeExists(final ComponentType ct) throws FunctionalException {
		if (ct == null || explorer.getComponentTypeByID(ct.getId()) == null) {
			throw new FunctionalException(FunctionalException.Code.TARGET_NOT_FOUND, null, "(boundType)");
		}
	}

	private void checkNoIllegalBindingChange(final ComponentTypeDTO dto, final ComponentType target)
			throws FunctionalException {
		ComponentType currentCT = target.getBoundType();
		boolean existingCompsForChangedType = (explorer.getComponentsForCTID(target.getId()).size() > 0);
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
		return dto.getBoundType() == null || Utils.isNullOrEmptyAfterTrim(dto.getBoundType().getId());
	}

	/**
	 * @param dto
	 * @param boundCT
	 * @throws FunctionalException
	 */
	private void checkBoundTypeIsFromAnotherVP(final ComponentTypeDTO dto, ComponentType boundCT)
			throws FunctionalException {
		ViewPoint vp = explorer.getViewPointByID(dto.getViewPoint().getId());
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
			refHelper.checkTargetsExistence(refDTO, Type.COMPONENT_TYPE);
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
			dtoRefs.add(fromDTO.newReference(r, Type.COMPONENT_TYPE));
		}
		ComponentType ct = explorer.getComponentTypeByID(dto.getId());
		EList<Reference> currentRefs = ct.getReferences();
		for (Reference currentRef : currentRefs) {
			if (!refHelper.containsRef(dtoRefs, currentRef)) {
				// a reference has been dropped
				for (Component comp : explorer.getComponentsForCTID(dto.getId())) {
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
		ViewPoint thisVP = explorer.getViewPointByID(dto.getViewPoint().getId());
		for (HasNameAndIdDTO target : refDTO.getTargets()) {
			ComponentType ctTarget = explorer.getComponentTypeByID(target.getId());
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
			item = explorer.getComponentByID(comp.getId());
			// unknown component ? ok, search in groups
			if (item == null) {
				item = explorer.getComponentGroupByID(comp.getId());
			}
			// still nothing ? leave in error
			if (item == null) {
				throw new FunctionalException(FunctionalException.Code.TARGET_NOT_FOUND, null, "(enumeration)");
			}
			// check that every component or group share the same CT = bound type
			ComponentType ct = explorer.getComponentTypeForArchitectureItem(item);
			if (!ct.getId().equals(dto.getBoundType().getId())) {
				throw new FunctionalException(FunctionalException.Code.INVALID_TYPE, null, "(enumeration)");
			}
		}
	}

	private void checkNoneBindingToThisCT(ComponentType type) throws FunctionalException {
		for (ViewPoint vp : pmanager.getRoot().getViewPoints()) {
			for (ComponentType ct : vp.getComponentTypes()) {
				if (!(ct.equals(type)) && type.equals(ct.getBoundType())) {
					throw new FunctionalException(FunctionalException.Code.CT_EXISTING_BINDING, null, "component type name="
							+ ct.getName());
				}
			}
		}
	}

	private void checkNoneComponentForThisCT(ComponentType type) throws FunctionalException {
		for (View view : pmanager.getRoot().getViews()) {
			for (Component comp : view.getComponents()) {
				if (comp.getType().equals(type)) {
					throw new FunctionalException(FunctionalException.Code.CT_EXISTING_COMP, null, "component name="
							+ comp.getName());
				}
			}
		}
	}

	private void checkNoReferenceToThisCT(ViewPoint vp, ComponentType ctToDelete) throws FunctionalException {
		for (ComponentType ct : vp.getComponentTypes()) {
			List<Reference> refs = ct.getReferences();
			for (Reference ref : refs) {
				if (ref.getTargets().contains(ctToDelete)) {
					throw new FunctionalException(FunctionalException.Code.CT_REFERENCE_IN_USE, null, "component type name="
							+ ct.getName());
				}
			}
		}
	}

	private void checkNoLinkTypeInvolvingThisCT(ViewPoint vp, ComponentType ctToDelete) throws FunctionalException {
		for (LinkType lt : vp.getLinkTypes()) {
			if (lt.getSourceTypes().contains(ctToDelete) || lt.getDestinationTypes().contains(ctToDelete)) {
				throw new FunctionalException(FunctionalException.Code.LINK_IN_USE, null, "Link type name=" + lt.getName());
			}
		}
	}

	/**
	 * @param dto
	 * @throws FunctionalException
	 */
	private void checkVPExist(final ComponentTypeDTO dto) throws FunctionalException {
		if (dto.getViewPoint() == null || dto.getViewPoint().getId() == null) {
			throw new FunctionalException(FunctionalException.Code.NULL_ARGUMENT, null, "(viewpoint)");
		}
		ViewPoint vp = explorer.getViewPointByID(dto.getViewPoint().getId());
		if (vp == null) {
			throw new FunctionalException(FunctionalException.Code.TARGET_NOT_FOUND, null, "viewpoint="
					+ dto.getViewPoint().getId());
		}
	}
}

/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.service.models;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.m2ling.common.dto.core.AccessType;
import org.m2ling.common.dto.core.ComponentDTO;
import org.m2ling.common.dto.core.HasNameAndIdDTO;
import org.m2ling.common.dto.core.ReferenceDTO;
import org.m2ling.common.exceptions.FunctionalException;
import org.m2ling.common.utils.Utils;
import org.m2ling.domain.core.Component;
import org.m2ling.domain.core.ComponentInstance;
import org.m2ling.domain.core.ComponentType;
import org.m2ling.domain.core.HasNameAndID;
import org.m2ling.domain.core.Link;
import org.m2ling.domain.core.Reference;
import org.m2ling.domain.core.Type;
import org.m2ling.domain.core.View;
import org.m2ling.persistence.PersistenceManager;
import org.m2ling.service.common.ReferenceHelper;
import org.m2ling.service.common.ServiceChecker;
import org.m2ling.service.util.DomainExplorer;
import org.m2ling.service.util.DTOConverter.FromDTO;

import com.google.inject.Inject;

/**
 * @author "Bertrand Florat <bertrand@florat.net>"
 * 
 */
public class ComponentServiceChecker extends ServiceChecker {
	@Inject
	protected ComponentServiceChecker(PersistenceManager pm, DomainExplorer explorer, FromDTO fromDTO, ReferenceHelper refHelper) {
		super(pm, explorer, fromDTO, refHelper);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Type getManagedType() {
		return Type.COMPONENT;
	}

	/**
	 * Centralize all service entry verifications
	 * 
	 * @param dto
	 * @param access
	 *           access type used to discriminate the check
	 * @throws FunctionalException
	 */
	void checkDTO(final ComponentDTO dto, final AccessType access) throws FunctionalException {
		Component target = null;
		checkNullDTO(dto);
		checkIdFormat(dto, access);
		checkItemExistence(dto, access);
		if (access == AccessType.DELETE) {
			Component compToDelete = explorer.getComponentByID(dto.getId());
			checkNoCIForThisComponent(compToDelete);
			checkNoBindingToThisComponent(compToDelete);
			checkNoLinkInvolvingThisComponent(compToDelete);
		} else if (access == AccessType.CREATE || access == AccessType.UPDATE) {
			if (dto.getBoundComponent() == null) {
				checkNameWhenRequired(dto, access);
			} else {
				checkNameWhenNotRequired(dto, access);
			}
			target = explorer.getComponentByID(dto.getId());
			// Check associated view existence
			View view = null;
			if (access == AccessType.CREATE) {
				checkViewIDFormat(dto);
				view = explorer.getViewByID(dto.getView().getId());
			} else {// vID is ignored for access != create
				view = explorer.getViewByItem(target);
			}
			if (view == null) {
				throw new FunctionalException(FunctionalException.Code.TARGET_NOT_FOUND, null, "(view)");
			}
			checkComment(dto.getComment());
			checkStatus(view.getViewPoint().getId(), dto.getStatus());
			checkTags(dto.getTags());
			// Type
			ComponentType ct = getCT(dto, access, target);
			if (ct == null) {
				throw new FunctionalException(FunctionalException.Code.TARGET_NOT_FOUND, null, "(component type)");
			}
			// References
			checkReferences(dto, access, target, ct);
			// Bound component
			checkBoundComponent(dto, access, target, ct);
			// Description
			checkDescriptionNotMandatory(dto.getDescription());
		}
	}

	private void checkNoLinkInvolvingThisComponent(Component compToDelete) throws FunctionalException {
		for (View view : pmanager.getRoot().getViews()) {
			for (Link link : view.getLinks()) {
				if (link.getSources().contains(compToDelete) || link.getDestinations().contains(compToDelete)) {
					throw new FunctionalException(FunctionalException.Code.LINK_IN_USE, null, "Link name=" + link.getName());
				}
			}
		}
	}

	private void checkViewIDFormat(final ComponentDTO dto) throws FunctionalException {
		if (dto.getView() == null || dto.getView().getId() == null) {
			throw new FunctionalException(FunctionalException.Code.NULL_ARGUMENT, null, "(view)");
		}
		if ("".equals(dto.getView().getId().trim())) {
			throw new FunctionalException(FunctionalException.Code.VOID_ARGUMENT, null, "(view)");
		}
	}

	private void checkNoBindingToThisComponent(Component compToDelete) throws FunctionalException {
		for (View checkedView : pmanager.getRoot().getViews()) {
			for (Component checkedComp : checkedView.getComponents()) {
				Component checkedBoundComp = checkedComp.getBoundComponent();
				if (checkedBoundComp != null && checkedBoundComp.equals(compToDelete)) {
					throw new FunctionalException(FunctionalException.Code.COMP_EXISTING_BINDING, null, "component name="
							+ checkedComp.getName());
				}
			}
		}
	}

	private void checkNoCIForThisComponent(Component compToDelete) throws FunctionalException {
		for (View view : pmanager.getRoot().getViews()) {
			for (ComponentInstance instance : view.getComponentInstances()) {
				if (instance.getComponent().equals(compToDelete)) {
					throw new FunctionalException(FunctionalException.Code.COMP_EXISTING_INSTANCE, null, "instance name="
							+ instance.getName());
				}
			}
		}
	}

	private void checkReferences(final ComponentDTO dto, final AccessType access, final Component target,
			final ComponentType ct) throws FunctionalException {
		List<ReferenceDTO> references = dto.getReferences();
		// Check global nullity
		if (references == null) {
			throw new FunctionalException(FunctionalException.Code.NULL_ARGUMENT, null, "(references)");
		}
		ComponentType thisCompType = ct;
		for (ReferenceDTO refDTO : references) {
			refHelper.checkReferenceFormat(refDTO);
			refHelper.checkTargetsExistence(refDTO, getManagedType());
			checkTargetsTypes(thisCompType, refDTO);
		}
		// check that we don't drop a used reference
		if (access == AccessType.UPDATE) {
			checkReferenceDeletion(dto, target);
		}
	}

	private void checkTargetsTypes(ComponentType thisCompType, ReferenceDTO refDTO) throws FunctionalException {
		for (HasNameAndIdDTO target : refDTO.getTargets()) {
			Component targetComp = explorer.getComponentByID(target.getId());
			ComponentType targetType = explorer.getComponentTypeByID(targetComp.getType().getId());
			// Search for a matching known reference
			boolean found = false;
			for (Reference thisCompCTReference : thisCompType.getReferences()) {
				for (HasNameAndID checkedCTTarget : thisCompCTReference.getTargets()) {
					if (checkedCTTarget.equals(targetType)
					// check also the reference type (RUNS, DEPENDS_ON...)
							&& thisCompCTReference.getType().name().equals(refDTO.getType())) {
						found = true;
						break;
					}
				}
			}
			if (!found) {
				throw new FunctionalException(FunctionalException.Code.COMP_ILLEGAL_REFERENCE, null, "Reference=" + refDTO);
			}
		}
	}

	private void checkReferenceDeletion(final ComponentDTO dto, Component thisComp) throws FunctionalException {
		List<Reference> dtoRefs = new ArrayList<Reference>();
		for (ReferenceDTO r : dto.getReferences()) {
			dtoRefs.add(fromDTO.newReference(r, Type.COMPONENT));
		}
		EList<Reference> currentRefs = thisComp.getReferences();
		for (Reference currentRef : currentRefs) {
			if (!refHelper.containsRef(dtoRefs, currentRef)) {
				// a reference has been dropped
				for (ComponentInstance instance : explorer.getComponentsInstancesForComponentID(dto.getId())) {
					for (Reference instanceRef : instance.getReferences()) {
						for (HasNameAndID target : instanceRef.getTargets()) {
							ComponentInstance instanceTarget = (ComponentInstance) target;
							if (currentRef.getTargets().contains(instanceTarget.getComponent())) {
								throw new FunctionalException(FunctionalException.Code.COMP_REF_IN_USE, null, "instance="
										+ instance.getName());
							}
						}
					}
				}
			}
		}
	}

	private void checkBoundComponent(final ComponentDTO dto, AccessType access, Component target, ComponentType ct)
			throws FunctionalException {
		checkBoundComponentLegal(dto, ct);
		checkForExistingCI(dto, access, target);
	}

	private void checkForExistingCI(final ComponentDTO dto, AccessType access, Component target)
			throws FunctionalException {
		// Check that none CI exist before actually changing a legal binding
		if (access == AccessType.UPDATE) {
			boolean existingCIForChangedComp = (explorer.getComponentsInstancesForComponentID(target.getId()).size() > 0);
			// Attempt to drop the bound component
			if (isNullBinding(dto) && target.getBoundComponent() != null && existingCIForChangedComp) {
				throw new FunctionalException(FunctionalException.Code.COMP_EXISTING_INSTANCE, null,
						"Current bound component=" + dto.getBoundComponent());
			}
			// Attempt to change the bound component (note that we handle the case where ct is null)
			if (!isNullBinding(dto) && target.getBoundComponent() != null
					&& !dto.getBoundComponent().getId().equals(target.getBoundComponent().getId())
					&& existingCIForChangedComp) {
				throw new FunctionalException(FunctionalException.Code.COMP_EXISTING_BINDING, null,
						"Current bound component=" + dto.getBoundComponent());
			}
		}
	}

	private boolean isNullBinding(final ComponentDTO dto) {
		return dto.getBoundComponent() == null || Utils.isNullOrEmptyAfterTrim(dto.getBoundComponent().getId());
	}

	private void checkBoundComponentLegal(final ComponentDTO dto, ComponentType ct) throws FunctionalException {
		if (ct.getBoundType() != null && isNullBinding(dto)) {
			throw new FunctionalException(FunctionalException.Code.MISSING_BINDING, null, "expected bound type="
					+ ct.getBoundType().getName());
		} else if (!isNullBinding(dto)) {
			// Check if the bound component exists
			Component bound = explorer.getComponentByID(dto.getBoundComponent().getId());
			if (bound == null) {
				throw new FunctionalException(FunctionalException.Code.TARGET_NOT_FOUND, null, "bound ID="
						+ dto.getBoundComponent().getId());
			}
			// Check that the bound component follows CT definition
			ComponentType expectedBoundCT = ct.getBoundType();
			ComponentType checkedBoundCT = bound.getType();
			// checkedBoundCT can't be null as it comes from the model, expectedBoundCT can be null
			if (!checkedBoundCT.equals(expectedBoundCT)) {
				throw new FunctionalException(FunctionalException.Code.COMP_ILLEGAL_BINDING, null, null);
			}
		}
	}

	private ComponentType getCT(final ComponentDTO dto, final AccessType access, final Component comp)
			throws FunctionalException {
		ComponentType ct = null;
		// We want to ignore attempt to change CT during update so in the UPDATE case, we get the type
		// from the stored component, not from the DTO.
		if (access == AccessType.CREATE) {
			if (dto.getComponentType() == null) {
				throw new FunctionalException(FunctionalException.Code.NULL_ARGUMENT, null, "(component type)");
			}
			ct = explorer.getComponentTypeByID(dto.getComponentType().getId());
		} else if (access == AccessType.UPDATE) {
			ct = comp.getType();
		}
		return ct;
	}
}

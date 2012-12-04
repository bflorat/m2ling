/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.service.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import org.eclipse.emf.common.util.EList;
import org.m2ling.common.configuration.Conf;
import org.m2ling.common.dto.core.AccessType;
import org.m2ling.common.dto.core.ComponentDTO;
import org.m2ling.common.dto.core.HasNameAndIdDTO;
import org.m2ling.common.dto.core.ReferenceDTO;
import org.m2ling.common.exceptions.FunctionalException;
import org.m2ling.common.exceptions.FunctionalException.Code;
import org.m2ling.common.soa.Context;
import org.m2ling.domain.Root;
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
import org.m2ling.service.common.ServiceImpl;
import org.m2ling.service.util.CoreUtil;
import org.m2ling.service.util.DTOConverter;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * Nominal implementation for ComponentService
 * 
 * @author "Bertrand Florat <bertrand@florat.net>"
 * 
 */
@Singleton
public class ComponentServiceImpl extends ServiceImpl implements ComponentService {
	private ReferenceHelper refHelper;

	/**
	 * Protected constructor to prevent direct instantiation
	 */
	@Inject
	protected ComponentServiceImpl(PersistenceManager pm, CoreUtil util, DTOConverter.FromDTO fromDTO,
			DTOConverter.ToDTO toDTO, Conf conf, Logger logger, ReferenceHelper refHelper) {
		super(pm, util, fromDTO, toDTO, conf, logger);
		this.refHelper = refHelper;
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
			Component targetComp = util.getComponentByID(target.getId());
			ComponentType targetType = util.getComponentTypeByID(targetComp.getType().getId());
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
			dtoRefs.add(fromDTO.newReference(r));
		}
		EList<Reference> currentRefs = thisComp.getReferences();
		for (Reference currentRef : currentRefs) {
			if (!refHelper.containsRef(dtoRefs, currentRef)) {
				// a reference has been dropped
				for (ComponentInstance instance : util.getComponentsInstancesForComponentID(dto.getId())) {
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
			boolean existingCIForChangedComp = (util.getComponentsInstancesForComponentID(target.getId()).size() > 0);
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
		return dto.getBoundComponent() == null || Strings.isNullOrEmpty(dto.getBoundComponent().getId());
	}

	private void checkBoundComponentLegal(final ComponentDTO dto, ComponentType ct) throws FunctionalException {
		if (ct.getBoundType() != null && isNullBinding(dto)) {
			throw new FunctionalException(FunctionalException.Code.MISSING_BINDING, null, "expected bound type="
					+ ct.getBoundType().getName());
		} else if (!isNullBinding(dto)) {
			if (dto.getBoundComponent().getId() == null) {
				throw new FunctionalException(FunctionalException.Code.NULL_ARGUMENT, null, "(bound ID)");
			}
			// Check if the bound component exists
			Component bound = (Component) util.getComponentByID(dto.getBoundComponent().getId());
			if (bound == null) {
				throw new FunctionalException(FunctionalException.Code.TARGET_NOT_FOUND, null, "bound ID="
						+ dto.getBoundComponent().getId());
			}
			// Check that the bound component follows CT definition (no need to check that the bound
			// component is in the same view than the component to create because the associated
			// CT controls are already done)
			ComponentType expectedBoundCT = ct.getBoundType();
			ComponentType checkedBoundCT = bound.getType();
			// checkedBoundCT can't be null as it comes from the model, expectedBoundCT can be null
			if (!checkedBoundCT.equals(expectedBoundCT)) {
				throw new FunctionalException(FunctionalException.Code.COMP_ILLEGAL_BINDING, null, null);
			}
		}
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
		checkID(dto, access);
		if (dto.getBoundComponent() == null) {
			checkNameWhenRequired(dto, access);
		} else {
			checkNameWhenNotRequired(dto, access);
		}
		// item existence (except for creation access)
		if (access != AccessType.CREATE) {
			target = util.getComponentByID(dto.getId());
			if (target == null) {
				throw new FunctionalException(FunctionalException.Code.TARGET_NOT_FOUND, null, dto.toString());
			}
		}
		if (access == AccessType.CREATE || access == AccessType.UPDATE) {
			// Check associated view existence
			View view = null;
			if (access == AccessType.CREATE) {
				checkViewIDFormat(dto);
				view = util.getViewByID(dto.getView().getId());
			} else {// vID is ignored for access != create
				view = util.getViewByItem(target);
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

	private ComponentType getCT(final ComponentDTO dto, final AccessType access, final Component comp)
			throws FunctionalException {
		ComponentType ct = null;
		// We want to ignore attempt to change CT during update so in the UPDATE case, we get the type
		// from the stored component, not from the DTO.
		if (access == AccessType.CREATE) {
			if (dto.getComponentType() == null) {
				throw new FunctionalException(FunctionalException.Code.NULL_ARGUMENT, null, "(component type)");
			}
			ct = util.getComponentTypeByID(dto.getComponentType().getId());
		} else if (access == AccessType.UPDATE) {
			ct = comp.getType();
		}
		return ct;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateComponent(final Context context, final ComponentDTO dto) throws FunctionalException {
		try {
			// Controls
			checkDTO(dto, AccessType.UPDATE);
			// Processing
			Component comp = util.getComponentByID(dto.getId());
			comp.setName(dto.getName());
			comp.setDescription(dto.getDescription());
			comp.setComment(dto.getComment());
			List<String> tags = comp.getTags();
			tags.clear();
			tags.addAll(dto.getTags());
			Component bound = null;
			if (dto.getBoundComponent() != null) {
				bound = util.getComponentByID(dto.getBoundComponent().getId());
			}
			comp.setBoundComponent(bound);
			comp.setStatus(dto.getStatus());
			pmanager.commit();
		} catch (Exception anyError) {
			handleAnyException(anyError);
		}
	}

	/**
	 * Drop component orphan references (if the reference contains no more targets, it is dropped)
	 * 
	 **/
	private void cleanOrphanReferences(final Component compToDelete) {
		// Search for component having a reference to compToDelete
		for (View view : pmanager.getRoot().getViews()) {
			for (Component comp : view.getComponents()) {
				Iterator<Reference> itRefs = comp.getReferences().iterator();
				while (itRefs.hasNext()) {
					Reference ref = itRefs.next();
					Iterator<HasNameAndID> itTargets = ref.getTargets().iterator();
					while (itTargets.hasNext()) {
						HasNameAndID target = itTargets.next();
						if (target.getId().equals(compToDelete.getId())) {
							itTargets.remove();
							if (ref.getTargets().size() == 0) {
								itRefs.remove();
							}
						}
					}
				}
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void createComponent(final Context context, final ComponentDTO dto) throws FunctionalException {
		try {
			// Controls
			checkDTO(dto, AccessType.CREATE);
			// Processing
			Component ct = fromDTO.newComponent(dto);
			// Add the item
			View view = util.getViewByID(dto.getView().getId());
			view.getComponents().add(ct);
			pmanager.commit();
		} catch (Exception anyError) {
			handleAnyException(anyError);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<ComponentDTO> getAllComponents(final Context context, final String vID) throws FunctionalException {
		List<ComponentDTO> out = Lists.newArrayList();
		try {
			// Controls
			if (util.getViewByID(vID) == null) {
				throw new FunctionalException(Code.TARGET_NOT_FOUND, null, "View ID=" + vID.toString());
			}
			Root root = pmanager.getRoot();
			for (View checked : root.getViews()) {
				if (checked.getId().equals(vID)) {
					List<Component> comps = checked.getComponents();
					for (Component comp : comps) {
						ComponentDTO dto = toDTO.getComponentDTO(comp);
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
	public void deleteComponent(final Context context, final String id) throws FunctionalException {
		try {
			// Controls
			ComponentDTO dto = new ComponentDTO.Builder(id, null, null).build();
			checkID(dto, AccessType.DELETE);
			Component compToDelete = util.getComponentByID(dto.getId());
			View view = (View) compToDelete.eContainer();
			checkNoCIForThisComponent(compToDelete);
			checkNoBindingToThisComponent(compToDelete);
			checkNoLinkInvolvingThisComponent(compToDelete);
			// Note that we don't need to check if some CI still exists with references to a CI of the
			// dropped
			// component because this is implicitly tested by checkNoCIForThisComponent(), indeed the
			// target reference
			// can't be dropped while it owns instances so when it can be dropped, the ci reference
			// issue can't exist anymore.
			view.getComponents().remove(compToDelete);
			cleanOrphanReferences(compToDelete);
			pmanager.commit();
		} catch (Exception anyError) {
			handleAnyException(anyError);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ComponentDTO getComponentByID(Context context, String id) throws FunctionalException {
		ComponentDTO out = null;
		try {
			// Controls
			if (id == null || Strings.isNullOrEmpty(id.trim())) {
				throw new FunctionalException(FunctionalException.Code.NULL_ARGUMENT, null, "(id)");
			}
			Component comp = util.getComponentByID(id);
			if (comp != null) {
				out = toDTO.getComponentDTO(comp);
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
		return Type.COMPONENT;
	}
}

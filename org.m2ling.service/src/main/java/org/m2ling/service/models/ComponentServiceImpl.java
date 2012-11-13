/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.service.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EcoreUtil.EqualityHelper;
import org.m2ling.common.configuration.Conf;
import org.m2ling.common.dto.core.AccessType;
import org.m2ling.common.dto.core.ComponentDTO;
import org.m2ling.common.dto.core.HasNameAndIdDTO;
import org.m2ling.common.dto.core.ReferenceDTO;
import org.m2ling.common.exceptions.FunctionalException;
import org.m2ling.common.exceptions.FunctionalException.Code;
import org.m2ling.common.soa.Context;
import org.m2ling.common.utils.Consts;
import org.m2ling.common.utils.Utils;
import org.m2ling.domain.Root;
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
 * Nominal implementation for ComponentService
 * 
 * @author "Bertrand Florat <bertrand@florat.net>"
 * 
 */
@Singleton
public class ComponentServiceImpl extends ServiceImpl implements ComponentService {
	/**
	 * Protected constructor to prevent direct instantiation
	 */
	@Inject
	protected ComponentServiceImpl(PersistenceManager pm, CoreUtil util, DTOConverter.FromDTO fromDTO,
			DTOConverter.ToDTO toDTO, Conf conf, Logger logger) {
		super(pm, util, fromDTO, toDTO, conf, logger);
	}

	private void checkBeforeDeletion(final ComponentDTO dto) throws FunctionalException {
		Component compToDelete = util.getComponentByID(dto.getId());
		View viewOfCompToDelete = util.getViewsByItem(compToDelete);
		// none instance for this component ?
		for (ComponentInstance instance : viewOfCompToDelete.getComponentInstances()) {
			if (instance.getComponent().equals(compToDelete)) {
				throw new FunctionalException(FunctionalException.Code.COMP_EXISTING_INSTANCE, null, "instance name="
						+ instance.getName());
			}
		}
		// none component binding against this component ?
		for (View checkedView : pmanager.getRoot().getViews()) {
			if (checkedView.equals(viewOfCompToDelete)) {
				// Local binding is not forbidden
				continue;
			}
			for (Component checkedComp : checkedView.getComponents()) {
				Component checkedBoundComp = checkedComp.getBoundComponent();
				if (checkedBoundComp != null && checkedBoundComp.equals(compToDelete)) {
					throw new FunctionalException(FunctionalException.Code.COMP_EXISTING_BINDING, null, "component name="
							+ checkedComp.getName());
				}
			}
		}
	}

	private void checkReferences(final ComponentDTO dto, AccessType access) throws FunctionalException {
		List<ReferenceDTO> references = dto.getReferences();
		// Check global nullity
		if (references == null) {
			throw new FunctionalException(FunctionalException.Code.NULL_ARGUMENT, null, "(references)");
		}
		// CT has already been checked in checkDTO() method and should exist at this
		// point
		ComponentType thisCompType = util.getComponentTypeByID(dto.getComponentType().getId());
		for (ReferenceDTO refDTO : references) {
			// check reference nullity
			if (refDTO == null) {
				throw new FunctionalException(FunctionalException.Code.NULL_ARGUMENT, null, "(references)");
			}
			// check reference type
			if (ReferenceType.get(refDTO.getType()) == null) {
				throw new FunctionalException(FunctionalException.Code.INVALID_REFERENCE_TYPE, null, dto.toString());
			}
			// check that the reference contains at least a single target
			if (refDTO.getTargets().size() == 0) {
				throw new FunctionalException(FunctionalException.Code.NONE_TARGET, null, "reference=" + refDTO.getType());
			}
			// check reference targets and type
			if (refDTO.getTargets() == null) {
				throw new FunctionalException(FunctionalException.Code.NULL_ARGUMENT, null, "(references/target)");
			}
			// check targets existence
			for (HasNameAndIdDTO target : refDTO.getTargets()) {
				if (target == null) {
					throw new FunctionalException(FunctionalException.Code.NULL_ARGUMENT, null, "(references/target)");
				}
				Component targetComp = util.getComponentByID(target.getId());
				if (targetComp == null) {
					throw new FunctionalException(FunctionalException.Code.TARGET_NOT_FOUND, null, "(references/target)");
				}
			}
			// check targets types
			for (HasNameAndIdDTO target : refDTO.getTargets()) {
				Component targetComp = util.getComponentByID(target.getId());
				if (targetComp.getType() == null) {
					throw new FunctionalException(FunctionalException.Code.NULL_ARGUMENT, null, "(references/target/type)");
				}
				ComponentType targetType = util.getComponentTypeByID(targetComp.getType().getId());
				if (targetType == null) {
					throw new FunctionalException(FunctionalException.Code.TARGET_NOT_FOUND, null,
							"(references/target/type)");
				}
				// Search for a matching known reference
				boolean found = false;
				for (Reference reference : thisCompType.getReferences()) {
					if (reference.getTargets().contains(targetType) && reference.getType().name().equals(refDTO.getType())) {
						found = true;
						break;
					}
				}
				if (!found) {
					throw new FunctionalException(FunctionalException.Code.COMP_ILLEGAL_REFERENCE, null, "Reference="
							+ refDTO);
				}
			}
		}
		// check that we don't drop a used reference (no need to check DELETE access type as we can't
		// delete a component while instances still exist)
		if (access == AccessType.UPDATE) {
			checkReferenceDeletion(dto, thisCompType);
		}
	}

	private void checkReferenceDeletion(final ComponentDTO dto, ComponentType thisCompType) throws FunctionalException {
		List<Reference> dtoRefs = new ArrayList<Reference>();
		for (ReferenceDTO r : dto.getReferences()) {
			dtoRefs.add(fromDTO.newReference(r));
		}
		EList<Reference> currentRefs = thisCompType.getReferences();
		for (Reference currentRef : currentRefs) {
			if (!containsRef(dtoRefs, currentRef)) {
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

	private void checkBoundComponent(final ComponentDTO dto, AccessType access) throws FunctionalException {
		if (dto.getBoundComponent() != null && dto.getBoundComponent().getId() != null) {
			// Check if the bound component exists
			Component bound = (Component) util.getComponentByID(dto.getBoundComponent().getId());
			if (bound == null) {
				throw new FunctionalException(FunctionalException.Code.TARGET_NOT_FOUND, null, "bound ID="
						+ dto.getBoundComponent().getId());
			}
			// Check that the bound component follows CT definition (no need to check that the bound
			// component is in the same view than the component to create because the associated
			// CT controls are already done)
			Component comp = util.getComponentByID(dto.getId());
			ComponentType ct = comp.getType();
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
	 * @param vID
	 *           the associated view ID for creation or null for others access types
	 * @param access
	 *           access type used to discriminate the check
	 * @throws FunctionalException
	 */
	void checkDTO(final ComponentDTO dto, final String vID, final AccessType access) throws FunctionalException {
		Component target = null;
		checkIdAndName(dto, access, true);
		// item existence (except for creation access)
		if (access != AccessType.CREATE) {
			target = util.getComponentByID(dto.getId());
			if (target == null) {
				throw new FunctionalException(FunctionalException.Code.TARGET_NOT_FOUND, null, dto.toString());
			}
		}
		// Check associated view existence
		View view = null;
		if (access == AccessType.CREATE) {
			if (vID == null) {
				throw new FunctionalException(FunctionalException.Code.NULL_ARGUMENT, null, "(view)");
			}
			if ("".equals(vID.trim())) {
				throw new FunctionalException(FunctionalException.Code.VOID_ARGUMENT, null, "(view)");
			}
			view = util.getViewByID(vID);
		} else if (vID == null) {// vID is null for access != create
			view = util.getViewsByItem(target);
		}
		if (view == null) {
			throw new FunctionalException(FunctionalException.Code.TARGET_NOT_FOUND, null, "(view)");
		}
		if (access == AccessType.CREATE) {
			// Check for existing item with the same id
			for (Component item : view.getComponents()) {
				if (item.getId().equals(dto.getId())) {
					throw new FunctionalException(FunctionalException.Code.DUPLICATES, null, "id=" + dto.getId());
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
			// Status (null is valid)
			ViewPoint vp = view.getViewPoint();
			if (dto.getStatus() != null && !vp.getStatusLiterals().contains(dto.getStatus())) {
				throw new FunctionalException(FunctionalException.Code.INVALID_STATUS, null, dto.toString());
			}
			// Tags
			Utils.checkTags(dto.getTags());
			// Type
			if (dto.getComponentType() == null) {
				throw new FunctionalException(FunctionalException.Code.NULL_ARGUMENT, null, "(component type)");
			}
			ComponentType ct = util.getComponentTypeByID(dto.getComponentType().getId());
			if (ct == null) {
				throw new FunctionalException(FunctionalException.Code.TARGET_NOT_FOUND, null, "(component type)");
			}
			// References
			checkReferences(dto, access);
			// Bound component
			checkBoundComponent(dto, access);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateComponent(final Context context, final ComponentDTO dto) throws FunctionalException {
		// Controls
		checkDTO(dto, null, AccessType.UPDATE);
		// Processing
		Component ct = util.getComponentByID(dto.getId());
		ct.setName(dto.getName());
		ct.setDescription(dto.getDescription());
		ct.setComment(dto.getComment());
		List<String> tags = ct.getTags();
		tags.clear();
		tags.addAll(dto.getTags());
		Component bound = null;
		if (dto.getBoundComponent() != null) {
			bound = util.getComponentByID(dto.getBoundComponent().getId());
		}
		ct.setBoundComponent(bound);
		ct.setStatus(dto.getStatus());
		pmanager.commit();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void createComponent(final Context context, final ComponentDTO dto, final String vID)
			throws FunctionalException {
		// Controls
		checkDTO(dto, vID, AccessType.CREATE);
		// Processing
		Component ct = fromDTO.newComponent(dto);
		// Add the item
		View vp = util.getViewByID(vID);
		vp.getComponents().add(ct);
		pmanager.commit();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<ComponentDTO> getAllComponents(final Context context, final String vID) throws FunctionalException {
		{// Controls
			if (util.getViewByID(vID) == null) {
				throw new FunctionalException(Code.TARGET_NOT_FOUND, null, "View ID=" + vID.toString());
			}
		}
		Root root = pmanager.getRoot();
		List<ComponentDTO> out = Lists.newArrayList();
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
		return out;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteComponent(final Context context, final ComponentDTO dto) throws FunctionalException {
		{// Controls
			checkBeforeDeletion(dto);
		}
		Component comp = util.getComponentByID(dto.getId());
		View vp = (View) comp.eContainer();
		vp.getComponents().remove(comp);
		pmanager.commit();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ComponentDTO getComponentByID(Context context, String id) throws FunctionalException {
		{// Controls
			if (id == null || Strings.isNullOrEmpty(id.trim())) {
				throw new FunctionalException(FunctionalException.Code.NULL_ARGUMENT, null, "(id)");
			}
		}
		Component comp = util.getComponentByID(id);
		if (comp == null) {
			return null;
		}
		return toDTO.getComponentDTO(comp);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Type getManagedType() {
		return Type.COMPONENT;
	}
}

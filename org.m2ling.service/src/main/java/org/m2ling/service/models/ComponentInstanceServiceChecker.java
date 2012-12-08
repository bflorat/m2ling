/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.service.models;

import java.util.List;

import org.m2ling.common.dto.core.AccessType;
import org.m2ling.common.dto.core.ComponentInstanceDTO;
import org.m2ling.common.dto.core.HasNameAndIdDTO;
import org.m2ling.common.dto.core.ReferenceDTO;
import org.m2ling.common.exceptions.FunctionalException;
import org.m2ling.common.utils.Utils;
import org.m2ling.domain.core.Component;
import org.m2ling.domain.core.ComponentInstance;
import org.m2ling.domain.core.HasNameAndID;
import org.m2ling.domain.core.LinkInstance;
import org.m2ling.domain.core.Reference;
import org.m2ling.domain.core.Type;
import org.m2ling.domain.core.View;
import org.m2ling.persistence.PersistenceManager;
import org.m2ling.service.common.ReferenceHelper;
import org.m2ling.service.common.ServiceChecker;
import org.m2ling.service.util.CoreUtil;
import org.m2ling.service.util.DTOConverter.FromDTO;

import com.google.inject.Inject;

/**
 * @author "Bertrand Florat <bertrand@florat.net>"
 * 
 */
public class ComponentInstanceServiceChecker extends ServiceChecker {
	@Inject
	protected ComponentInstanceServiceChecker(PersistenceManager pm, CoreUtil util, FromDTO fromDTO,
			ReferenceHelper refHelper) {
		super(pm, util, fromDTO, refHelper);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Type getManagedType() {
		return Type.COMPONENT_INSTANCE;
	}

	/**
	 * Centralize all service entry verifications
	 * 
	 * @param dto
	 * @param access
	 *           access type used to discriminate the check
	 * @throws FunctionalException
	 */
	void checkDTO(final ComponentInstanceDTO dto, final AccessType access) throws FunctionalException {
		ComponentInstance target = null;
		checkNullDTO(dto);
		checkID(dto, access);
		if (access == AccessType.DELETE) {
			ComponentInstance ciToDelete = util.getComponentInstanceByID(dto.getId());
			checkNoBindingToThisCI(ciToDelete);
			checkNoLinkInvolvingThisCI(ciToDelete);
		}
		if (access == AccessType.CREATE || access == AccessType.UPDATE) {
			if (dto.getBoundInstance() == null) {
				checkNameWhenRequired(dto, access);
			} else {
				checkNameWhenNotRequired(dto, access);
			}
			target = util.getComponentInstanceByID(dto.getId());
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
			Component comp = getComponent(dto, access, target);
			if (comp == null) {
				throw new FunctionalException(FunctionalException.Code.TARGET_NOT_FOUND, null, "(component type)");
			}
			// References
			checkReferences(dto, access, target, comp);
			// Bound component
			checkBindingIsLegal(dto, comp);
			// Description
			checkDescriptionNotMandatory(dto.getDescription());
		}
	}

	private void checkNoBindingToThisCI(final ComponentInstance target) throws FunctionalException {
		for (View checkedView : pmanager.getRoot().getViews()) {
			for (ComponentInstance checkedCi : checkedView.getComponentInstances()) {
				ComponentInstance checkedBoundCI = checkedCi.getBoundComponentInstance();
				if (checkedBoundCI != null && checkedBoundCI.equals(target)) {
					throw new FunctionalException(FunctionalException.Code.CI_EXISTING_BINDING, null,
							"component instance name=" + checkedCi.getName());
				}
			}
		}
	}

	private void checkReferences(final ComponentInstanceDTO dto, final AccessType access,
			final ComponentInstance target, final Component comp) throws FunctionalException {
		List<ReferenceDTO> references = dto.getReferences();
		// Check global nullity
		if (references == null) {
			throw new FunctionalException(FunctionalException.Code.NULL_ARGUMENT, null, "(references)");
		}
		Component thisComp = comp;
		for (ReferenceDTO refDTO : references) {
			refHelper.checkReferenceFormat(refDTO);
			refHelper.checkTargetsExistence(refDTO, getManagedType());
			checkTargetsFollowComponentDefinition(thisComp, refDTO);
		}
	}

	private void checkTargetsFollowComponentDefinition(Component thisComp, ReferenceDTO refDTO)
			throws FunctionalException {
		for (HasNameAndIdDTO target : refDTO.getTargets()) {
			ComponentInstance targetCI = util.getComponentInstanceByID(target.getId());
			Component targetComp = util.getComponentByID(targetCI.getComponent().getId());
			// Search for a matching known reference
			boolean found = false;
			for (Reference thisCompReference : thisComp.getReferences()) {
				for (HasNameAndID checkedCompTarget : thisCompReference.getTargets()) {
					if (checkedCompTarget.equals(targetComp)
					// check also the reference type (RUNS, DEPENDS_ON...)
							&& thisCompReference.getType().name().equals(refDTO.getType())) {
						found = true;
						break;
					}
				}
			}
			if (!found) {
				throw new FunctionalException(FunctionalException.Code.CI_ILLEGAL_REFERENCE, null, "Reference=" + refDTO);
			}
		}
	}

	private boolean isNullBinding(final ComponentInstanceDTO dto) {
		return dto.getBoundInstance() == null || Utils.isNullOrEmptyAfterTrim(dto.getBoundInstance().getId());
	}

	private void checkBindingIsLegal(final ComponentInstanceDTO dto, Component comp) throws FunctionalException {
		if (comp.getBoundComponent() == null && !isNullBinding(dto)) {
			throw new FunctionalException(FunctionalException.Code.CI_ILLEGAL_BINDING, null,
					"No binding defined by component " + comp.getName());
		}
		if (!isNullBinding(dto)) {
			ComponentInstance boundInstance = util.getComponentInstanceByID(dto.getBoundInstance().getId());
			if (boundInstance == null) {
				throw new FunctionalException(FunctionalException.Code.TARGET_NOT_FOUND, null, "bound instance ID="
						+ dto.getBoundInstance().getId());
			}
			// Check that the bound CI follows its component definition
			Component expectedBoundComp = comp.getBoundComponent();
			Component checkedBoundComp = boundInstance.getComponent();
			// checkedBoundComp can't be null as it comes from the model, expectedBoundComp can be null
			if (!checkedBoundComp.equals(expectedBoundComp)) {
				throw new FunctionalException(FunctionalException.Code.CI_ILLEGAL_BINDING, null, null);
			}
		}
	}

	private void checkNoLinkInvolvingThisCI(ComponentInstance ciToDelete) throws FunctionalException {
		for (View view : pmanager.getRoot().getViews()) {
			for (LinkInstance li : view.getLinkInstances()) {
				if (li.getSource().equals(ciToDelete) || li.getDestination().equals(ciToDelete)) {
					throw new FunctionalException(FunctionalException.Code.LINK_IN_USE, null, "Link name=" + li.getName());
				}
			}
		}
	}

	private void checkViewIDFormat(final ComponentInstanceDTO dto) throws FunctionalException {
		if (dto.getView() == null || dto.getView().getId() == null) {
			throw new FunctionalException(FunctionalException.Code.NULL_ARGUMENT, null, "(view)");
		}
		if ("".equals(dto.getView().getId().trim())) {
			throw new FunctionalException(FunctionalException.Code.VOID_ARGUMENT, null, "(view)");
		}
	}

	private Component getComponent(final ComponentInstanceDTO dto, final AccessType access, final ComponentInstance ci)
			throws FunctionalException {
		Component comp = null;
		// We want to ignore attempt to change component CT during update so in the UPDATE case, we
		// get the type from the stored component, not from the DTO.
		if (access == AccessType.CREATE) {
			if (dto.getComponent() == null) {
				throw new FunctionalException(FunctionalException.Code.NULL_ARGUMENT, null, "(component)");
			}
			comp = util.getComponentByID(dto.getComponent().getId());
		} else if (access == AccessType.UPDATE) {
			comp = ci.getComponent();
		}
		return comp;
	}
}

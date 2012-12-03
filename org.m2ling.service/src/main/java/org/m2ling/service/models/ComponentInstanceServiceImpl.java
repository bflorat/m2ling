/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.service.models;

import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

import org.m2ling.common.configuration.Conf;
import org.m2ling.common.dto.core.AccessType;
import org.m2ling.common.dto.core.ComponentInstanceDTO;
import org.m2ling.common.dto.core.HasNameAndIdDTO;
import org.m2ling.common.dto.core.ReferenceDTO;
import org.m2ling.common.exceptions.FunctionalException;
import org.m2ling.common.exceptions.FunctionalException.Code;
import org.m2ling.common.soa.Context;
import org.m2ling.domain.Root;
import org.m2ling.domain.core.Component;
import org.m2ling.domain.core.ComponentInstance;
import org.m2ling.domain.core.HasNameAndID;
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
 * Nominal implementation for ComponentInstanceService
 * 
 * @author "Bertrand Florat <bertrand@florat.net>"
 * 
 */
@Singleton
public class ComponentInstanceServiceImpl extends ServiceImpl implements ComponentInstanceService {
	private ReferenceHelper refHelper;

	/**
	 * Protected constructor to prevent direct instantiation
	 */
	@Inject
	protected ComponentInstanceServiceImpl(PersistenceManager pm, CoreUtil util, DTOConverter.FromDTO fromDTO,
			DTOConverter.ToDTO toDTO, Conf conf, Logger logger, ReferenceHelper refHelper) {
		super(pm, util, fromDTO, toDTO, conf, logger);
		this.refHelper = refHelper;
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
				throw new FunctionalException(FunctionalException.Code.COMP_ILLEGAL_REFERENCE, null, "Reference=" + refDTO);
			}
		}
	}

	private boolean isNullBinding(final ComponentInstanceDTO dto) {
		return dto.getBoundInstance() == null || Strings.isNullOrEmpty(dto.getBoundInstance().getId());
	}

	private void checkBindingIsLegal(final ComponentInstanceDTO dto, Component comp) throws FunctionalException {
		if (comp.getBoundComponent() != null && isNullBinding(dto)) {
			throw new FunctionalException(FunctionalException.Code.MISSING_BINDING, null, "expected bound type="
					+ comp.getBoundComponent().getName());
		} else if (!isNullBinding(dto)) {
			if (dto.getBoundInstance().getId() == null) {
				throw new FunctionalException(FunctionalException.Code.NULL_ARGUMENT, null, "(bound ID)");
			}
			// Check if the bound component exists
			Component bound = (Component) util.getComponentByID(dto.getBoundInstance().getId());
			if (bound == null) {
				throw new FunctionalException(FunctionalException.Code.TARGET_NOT_FOUND, null, "bound ID="
						+ dto.getBoundInstance().getId());
			}
			// Check that the bound CI follows component definition
			Component expectedBoundComp = comp.getBoundComponent();
			Component checkedBoundComp = bound.getBoundComponent();
			// checkedBoundCT can't be null as it comes from the model, expectedBoundCT can be null
			if (!checkedBoundComp.equals(expectedBoundComp)) {
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
	void checkDTO(final ComponentInstanceDTO dto, final AccessType access) throws FunctionalException {
		ComponentInstance target = null;
		checkNullDTO(dto);
		checkID(dto, access);
		if (dto.getBoundInstance() == null) {
			checkNameWhenRequired(dto, access);
		} else {
			checkNameWhenNotRequired(dto, access);
		}
		// item existence (except for creation access)
		if (access != AccessType.CREATE) {
			target = util.getComponentInstanceByID(dto.getId());
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

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateCI(final Context context, final ComponentInstanceDTO dto) throws FunctionalException {
		try {
			// Controls
			checkDTO(dto, AccessType.UPDATE);
			// Processing
			ComponentInstance ci = util.getComponentInstanceByID(dto.getId());
			ci.setName(dto.getName());
			ci.setDescription(dto.getDescription());
			ci.setComment(dto.getComment());
			List<String> tags = ci.getTags();
			tags.clear();
			tags.addAll(dto.getTags());
			ComponentInstance bound = null;
			if (dto.getBoundInstance() != null) {
				bound = util.getComponentInstanceByID(dto.getBoundInstance().getId());
			}
			ci.setBoundComponentInstance(bound);
			ci.setStatus(dto.getStatus());
			pmanager.commit();
		} catch (Exception anyError) {
			handleAnyException(anyError);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void createCI(final Context context, final ComponentInstanceDTO dto) throws FunctionalException {
		try {
			// Controls
			checkDTO(dto, AccessType.CREATE);
			// Processing
			ComponentInstance ci = fromDTO.newComponentInstance(dto);
			// Add the item
			View view = util.getViewByID(dto.getView().getId());
			view.getComponentInstances().add(ci);
			pmanager.commit();
		} catch (Exception anyError) {
			handleAnyException(anyError);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<ComponentInstanceDTO> getAllCI(final Context context, final String vID) throws FunctionalException {
		List<ComponentInstanceDTO> out = Lists.newArrayList();
		try {
			// Controls
			if (util.getViewByID(vID) == null) {
				throw new FunctionalException(Code.TARGET_NOT_FOUND, null, "View ID=" + vID.toString());
			}
			Root root = pmanager.getRoot();
			for (View checked : root.getViews()) {
				if (checked.getId().equals(vID)) {
					List<ComponentInstance> instances = checked.getComponentInstances();
					for (ComponentInstance ci : instances) {
						ComponentInstanceDTO dto = toDTO.getComponentInstanceDTO(ci);
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
	public void deleteCI(final Context context, final String id) throws FunctionalException {
		try {
			// Controls
			ComponentInstanceDTO dto = new ComponentInstanceDTO.Builder(id, null, null).build();
			checkID(dto, AccessType.DELETE);
			ComponentInstance ci = util.getComponentInstanceByID(dto.getId());
			checkNoBindingToThisCI(ci);
			View view = (View) ci.eContainer();
			view.getComponentInstances().remove(ci);
			pmanager.commit();
		} catch (Exception anyError) {
			handleAnyException(anyError);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ComponentInstanceDTO getCIByID(Context context, String id) throws FunctionalException {
		ComponentInstanceDTO out = null;
		try {
			// Controls
			if (id == null || Strings.isNullOrEmpty(id.trim())) {
				throw new FunctionalException(FunctionalException.Code.NULL_ARGUMENT, null, "(id)");
			}
			ComponentInstance ci = util.getComponentInstanceByID(id);
			if (ci != null) {
				out = toDTO.getComponentInstanceDTO(ci);
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
		return Type.COMPONENT_INSTANCE;
	}
}

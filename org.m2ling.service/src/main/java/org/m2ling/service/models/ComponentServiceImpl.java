/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.service.models;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import org.m2ling.common.configuration.Conf;
import org.m2ling.common.dto.core.AccessType;
import org.m2ling.common.dto.core.ComponentDTO;
import org.m2ling.common.dto.core.HasNameAndIdDTO;
import org.m2ling.common.exceptions.FunctionalException;
import org.m2ling.common.soa.Context;
import org.m2ling.common.utils.Utils;
import org.m2ling.domain.Root;
import org.m2ling.domain.core.Component;
import org.m2ling.domain.core.ComponentGroup;
import org.m2ling.domain.core.ComponentType;
import org.m2ling.domain.core.HasNameAndID;
import org.m2ling.domain.core.Reference;
import org.m2ling.domain.core.View;
import org.m2ling.persistence.PersistenceManager;
import org.m2ling.service.common.ServiceImpl;
import org.m2ling.service.util.DTOConverter;
import org.m2ling.service.util.DomainExplorer;

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
	private ComponentServiceChecker checker;

	/**
	 * Protected constructor to prevent direct instantiation
	 */
	@Inject
	protected ComponentServiceImpl(PersistenceManager pm, DomainExplorer explorer, DTOConverter.FromDTO fromDTO,
			DTOConverter.ToDTO toDTO, Conf conf, Logger logger, ComponentServiceChecker checker) {
		super(pm, explorer, fromDTO, toDTO, conf, logger);
		this.checker = checker;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateComponent(final Context context, final ComponentDTO dto) throws FunctionalException {
		try {
			// Controls
			checker.checkDTO(dto, AccessType.UPDATE);
			// Processing
			Component comp = explorer.getComponentByID(dto.getId());
			comp.setName(dto.getName());
			comp.setDescription(dto.getDescription());
			comp.setComment(dto.getComment());
			List<String> tags = comp.getTags();
			tags.clear();
			tags.addAll(dto.getTags());
			Component bound = null;
			if (dto.getBoundComponent() != null) {
				bound = explorer.getComponentByID(dto.getBoundComponent().getId());
			}
			comp.setBoundComponent(bound);
			comp.setStatus(dto.getStatus());
			pmanager.commit();
		} catch (Exception anyError) {
			handleAnyException(anyError);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void createComponent(final Context context, final ComponentDTO dto) throws FunctionalException {
		try {
			// Controls
			checker.checkDTO(dto, AccessType.CREATE);
			// Processing
			Component ct = fromDTO.newComponent(dto);
			// Add the item
			View view = explorer.getViewByID(dto.getView().getId());
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
	public List<ComponentDTO> getAllComponentsByView(final Context context, final String vID) throws FunctionalException {
		List<ComponentDTO> out = Lists.newArrayList();
		try {
			checker.checkViewExists(vID);
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
	public List<HasNameAndIdDTO> getComponentsAndGroupByCT(Context context, String ctID) throws FunctionalException {
		List<HasNameAndIdDTO> out = Lists.newArrayList();
		try {
			// Controls
			checker.checkCTExists(ctID);
			addComponentsResults(ctID, out);
			addComponentGroupsResults(ctID, out);
			Collections.sort(out);
		} catch (Exception anyError) {
			handleAnyException(anyError);
		}
		return out;
	}

	private void addComponentsResults(String ctID, List<HasNameAndIdDTO> out) {
		Root root = pmanager.getRoot();
		for (View view : root.getViews()) {
			for (Component comp : view.getComponents()) {
				if (comp.getType().getId().equals(ctID)) {
					HasNameAndIdDTO dto = new HasNameAndIdDTO.Builder(comp.getId(), comp.getName()).build();
					out.add(dto);
				}
			}
		}
	}

	private void addComponentGroupsResults(String ctID, List<HasNameAndIdDTO> out) {
		Root root = pmanager.getRoot();
		for (View view : root.getViews()) {
			for (ComponentGroup group : view.getComponentsGroups()) {
				List<Component> components = group.getComponents();
				if (components.size() == 0) {
					return;
				}
				// Remember : all components of a group must have the same CT
				Component firstFound = components.get(0);
				ComponentType ct = firstFound.getType();
				if (ct.getId().equals(ctID)) {
					HasNameAndIdDTO dto = new HasNameAndIdDTO.Builder(group.getId(), group.getName()).build();
					out.add(dto);
				}
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteComponent(final Context context, final String id) throws FunctionalException {
		try {
			// Controls
			ComponentDTO dto = new ComponentDTO.Builder(id, null, null).build();
			checker.checkDTO(dto, AccessType.DELETE);
			Component compToDelete = explorer.getComponentByID(dto.getId());
			View view = (View) compToDelete.eContainer();
			// Note that we don't need to check if some CI still exists with references to a CI of the
			// dropped component because this is implicitly tested by checkNoCIForThisComponent(), indeed the
			// target reference can't be dropped while it owns instances so when it can be dropped, the ci reference
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
			if (id == null || Utils.isNullOrEmptyAfterTrim(id)) {
				throw new FunctionalException(FunctionalException.Code.NULL_ARGUMENT, null, "(id)");
			}
			Component comp = explorer.getComponentByID(id);
			if (comp != null) {
				out = toDTO.getComponentDTO(comp);
			}
		} catch (Exception anyError) {
			handleAnyException(anyError);
		}
		return out;
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
}

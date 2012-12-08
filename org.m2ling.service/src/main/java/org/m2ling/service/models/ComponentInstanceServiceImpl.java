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
import org.m2ling.common.dto.core.ComponentInstanceDTO;
import org.m2ling.common.exceptions.FunctionalException;
import org.m2ling.common.exceptions.FunctionalException.Code;
import org.m2ling.common.soa.Context;
import org.m2ling.common.utils.Utils;
import org.m2ling.domain.Root;
import org.m2ling.domain.core.ComponentInstance;
import org.m2ling.domain.core.HasNameAndID;
import org.m2ling.domain.core.Reference;
import org.m2ling.domain.core.View;
import org.m2ling.persistence.PersistenceManager;
import org.m2ling.service.common.ServiceImpl;
import org.m2ling.service.util.DomainExplorer;
import org.m2ling.service.util.DTOConverter;

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
	private ComponentInstanceServiceChecker checker;

	/**
	 * Protected constructor to prevent direct instantiation
	 */
	@Inject
	protected ComponentInstanceServiceImpl(PersistenceManager pm, DomainExplorer explorer, DTOConverter.FromDTO fromDTO,
			DTOConverter.ToDTO toDTO, Conf conf, Logger logger, ComponentInstanceServiceChecker checker) {
		super(pm, explorer, fromDTO, toDTO, conf, logger);
		this.checker = checker;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateCI(final Context context, final ComponentInstanceDTO dto) throws FunctionalException {
		try {
			// Controls
			checker.checkDTO(dto, AccessType.UPDATE);
			// Processing
			ComponentInstance ci = explorer.getComponentInstanceByID(dto.getId());
			ci.setName(dto.getName());
			ci.setDescription(dto.getDescription());
			ci.setComment(dto.getComment());
			List<String> tags = ci.getTags();
			tags.clear();
			tags.addAll(dto.getTags());
			ComponentInstance bound = null;
			if (dto.getBoundInstance() != null) {
				bound = explorer.getComponentInstanceByID(dto.getBoundInstance().getId());
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
			checker.checkDTO(dto, AccessType.CREATE);
			// Processing
			ComponentInstance ci = fromDTO.newComponentInstance(dto);
			// Add the item
			View view = explorer.getViewByID(dto.getView().getId());
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
			if (explorer.getViewByID(vID) == null) {
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
			checker.checkDTO(dto, AccessType.DELETE);
			ComponentInstance ciToDelete = explorer.getComponentInstanceByID(dto.getId());
			View view = (View) ciToDelete.eContainer();
			view.getComponentInstances().remove(ciToDelete);
			cleanOrphanReferences(ciToDelete);
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
			if (id == null || Utils.isNullOrEmptyAfterTrim(id)) {
				throw new FunctionalException(FunctionalException.Code.NULL_ARGUMENT, null, "(id)");
			}
			ComponentInstance ci = explorer.getComponentInstanceByID(id);
			if (ci != null) {
				out = toDTO.getComponentInstanceDTO(ci);
			}
		} catch (Exception anyError) {
			handleAnyException(anyError);
		}
		return out;
	}

	/**
	 * Drop CI orphan references (if the reference contains no more targets, it is dropped)
	 * 
	 **/
	private void cleanOrphanReferences(final ComponentInstance ciToDelete) {
		// Search for CI having a reference to compToDelete
		for (View view : pmanager.getRoot().getViews()) {
			for (ComponentInstance ci : view.getComponentInstances()) {
				Iterator<Reference> itRefs = ci.getReferences().iterator();
				while (itRefs.hasNext()) {
					Reference ref = itRefs.next();
					Iterator<HasNameAndID> itTargets = ref.getTargets().iterator();
					while (itTargets.hasNext()) {
						HasNameAndID target = itTargets.next();
						if (target.getId().equals(ciToDelete.getId())) {
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

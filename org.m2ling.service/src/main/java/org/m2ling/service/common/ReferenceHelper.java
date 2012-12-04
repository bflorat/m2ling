/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.service.common;

import java.util.ArrayList;
import java.util.List;

import org.m2ling.common.dto.core.HasNameAndIdDTO;
import org.m2ling.common.dto.core.ReferenceDTO;
import org.m2ling.common.exceptions.FunctionalException;
import org.m2ling.domain.core.HasNameAndID;
import org.m2ling.domain.core.Reference;
import org.m2ling.domain.core.ReferenceType;
import org.m2ling.domain.core.Type;
import org.m2ling.service.util.CoreUtil;

import com.google.inject.Inject;

/**
 * 
 * Helper class for references
 * 
 * @author "Bertrand Florat <bertrand@florat.net>"
 * 
 */
public class ReferenceHelper {
	private CoreUtil util;

	@Inject
	public ReferenceHelper(CoreUtil util) {
		super();
		this.util = util;
	}

	/**
	 * Return whether the reference list contains "checked". The references may have different
	 * targets (but the same type). We consider that list contains checked if at least one ref of
	 * list contains every targets of checked for a given type exist.
	 * 
	 * @param list
	 * @param ref
	 * @return whether the reference list contains contains "checked"
	 */
	public boolean containsRef(List<Reference> list, Reference checked) {
		for (Reference ref : list) {
			if (!ref.getType().equals(checked.getType())) {
				continue;
			}
			List<String> checkedTargetsIDs = new ArrayList<String>();
			for (HasNameAndID target : checked.getTargets()) {
				checkedTargetsIDs.add(target.getId());
			}
			List<String> refTargetsIDs = new ArrayList<String>();
			for (HasNameAndID target : ref.getTargets()) {
				refTargetsIDs.add(target.getId());
			}
			if (refTargetsIDs.containsAll(checkedTargetsIDs)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Check that a reference is formally correct (nullity, size)
	 * 
	 * @throws FunctionalException
	 *            if the reference format is uncorrect
	 */
	public void checkReferenceFormat(ReferenceDTO refDTO) throws FunctionalException {
		// check reference nullity
		if (refDTO == null) {
			throw new FunctionalException(FunctionalException.Code.NULL_ARGUMENT, null, "(references)");
		}
		// check reference type
		if (ReferenceType.get(refDTO.getType()) == null) {
			throw new FunctionalException(FunctionalException.Code.INVALID_REFERENCE_TYPE, null, "(references)");
		}
		// check that the reference contains at least a single target
		if (refDTO.getTargets().size() == 0) {
			throw new FunctionalException(FunctionalException.Code.NONE_TARGET, null, "reference=" + refDTO.getType());
		}
		// check targets nullity
		if (refDTO.getTargets() == null) {
			throw new FunctionalException(FunctionalException.Code.NULL_ARGUMENT, null, "(references/target)");
		}
	}

	/**
	 * Check that all reference targets exist given a provided item type
	 * 
	 * @throws FunctionalException
	 *            if at least one target doesn't exist
	 */
	public void checkTargetsExistence(ReferenceDTO refDTO, Type type) throws FunctionalException {
		for (HasNameAndIdDTO target : refDTO.getTargets()) {
			if (target == null) {
				throw new FunctionalException(FunctionalException.Code.NULL_ARGUMENT, null, "(references/target)");
			}
			Object item = null;
			if (type == Type.COMPONENT) {
				item = util.getComponentByID(target.getId());
			} else if (type == Type.COMPONENT_INSTANCE) {
				item = util.getComponentInstanceByID(target.getId());
			} else if (type == Type.COMPONENT_TYPE) {
				item = util.getComponentTypeByID(target.getId());
			}
			if (item == null) {
				throw new FunctionalException(FunctionalException.Code.TARGET_NOT_FOUND, null, "(references/target)");
			}
		}
	}
}

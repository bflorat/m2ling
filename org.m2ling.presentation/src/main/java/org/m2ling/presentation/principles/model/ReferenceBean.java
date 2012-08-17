/**
 * Copyright (C) 2012 Bertrand Florat
 *
 * @author "Bertrand Florat <bertrand@florat.net>"
 */
package org.m2ling.presentation.principles.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import org.m2ling.common.utils.Utils;

/**
 * Mutable Reference bean
 */
@SuppressWarnings("serial")
public class ReferenceBean implements Serializable {
	/**Translated type literal */
	private String type;
	private List<String> targets;

	public ReferenceBean() {
		super();
	}

	public String toString() {
		return Utils.toString(this);
	}

	public boolean equals(Object other) {
		if (other == null || !(other instanceof ReferenceBean)) {
			return false;
		}
		ReferenceBean otherBean = (ReferenceBean) other;
		boolean sameType = (type != null && type.equals(otherBean.getType()));
		boolean sameTargets = (targets != null && targets.equals(otherBean.getTargets()));
		return sameType && sameTargets;
	}

	public int hashCode() {
		return (type + Arrays.toString(targets.toArray())).hashCode();
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *           the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the targets
	 */
	public List<String> getTargets() {
		return targets;
	}

	/**
	 * @param targets
	 *           the targets to set
	 */
	public void setTargets(List<String> targets) {
		this.targets = targets;
	}
}

/**
 * Copyright (C) 2012 Bertrand Florat
 *
 * @author "Bertrand Florat <bertrand@florat.net>"
 */
package org.m2ling.presentation.principles.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.m2ling.common.utils.Utils;

/**
 * Mutable Reference bean
 */
@SuppressWarnings("serial")
public class ReferenceBean implements Serializable {
	/** Translated type literal */
	private String type;
	private List<HasNameAndIDBean> targets = new ArrayList<HasNameAndIDBean>();

	public ReferenceBean() {
		super();
	}

	/** Deep copy constructor **/
	public ReferenceBean(ReferenceBean ref) {
		super();
		this.type = ref.getType();
		for (HasNameAndIDBean target : targets) {
			this.targets.add(new HasNameAndIDBean(target));
		}
	}

	public String toString() {
		return Utils.toString(this);
	}

	public String toTargetsString() {
		StringBuilder sb = new StringBuilder();
		for (HasNameAndIDBean target : targets) {
			sb.append(target.getName()).append(", ");
		}
		// Drop trailing comma
		if (sb.length() > 3) {
			sb.delete(sb.length() - 2, sb.length());
		}
		return sb.toString();
	}

	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
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
	public List<HasNameAndIDBean> getTargets() {
		return targets;
	}

	/**
	 * @param targets
	 *           the targets to set
	 */
	public void setTargets(List<HasNameAndIDBean> targets) {
		this.targets = targets;
	}
}

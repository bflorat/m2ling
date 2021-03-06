/**
 * Copyright (C) 2012 Bertrand Florat
 *
 * @author "Bertrand Florat <bertrand@florat.net>"
 */
package org.m2ling.presentation.principles.model;

import java.util.ArrayList;
import java.util.List;

import org.m2ling.presentation.common.model.AbstractCommonBean;

/**
 * Mutable Component Type bean
 */
@SuppressWarnings("serial")
public class ComponentTypeBean extends AbstractCommonBean {
	private HasNameAndIDBean vp;

	private String instantiationFactor = "0";

	private HasNameAndIDBean boundType;

	/** component id -> component name */
	private List<HasNameAndIDBean> enumeration = new ArrayList<HasNameAndIDBean>();

	private List<ReferenceBean> references = new ArrayList<ReferenceBean>();

	/** GUI only item used to represent the drop button **/
	private String drop = "";

	private String iconPath = "";

	public ComponentTypeBean() {
		super();
	}

	/**
	 * @return the iconPath
	 */
	public String getIconPath() {
		return iconPath;
	}

	/**
	 * @param iconPath
	 *           the iconPath to set
	 */
	public void setIconPath(String iconPath) {
		this.iconPath = iconPath;
	}

	/**
	 * @return the drop
	 */
	public String getDrop() {
		return drop;
	}

	/**
	 * @param drop
	 *           the drop to set
	 */
	public void setDrop(String drop) {
		this.drop = drop;
	}

	/**
	 * @return the instantiationFactor
	 */
	public String getInstantiationFactor() {
		return instantiationFactor;
	}

	/**
	 * @param instantiationFactor
	 *           the instantiationFactor to set
	 */
	public void setInstantiationFactor(String instantiationFactor) {
		this.instantiationFactor = instantiationFactor;
	}

	/**
	 * @return the vp
	 */
	public HasNameAndIDBean getViewPoint() {
		return vp;
	}

	/**
	 * @param vpName
	 *           the vpName to set
	 */
	public void setViewPoint(HasNameAndIDBean vp) {
		this.vp = vp;
	}

	/**
	 * @return the references
	 */
	public List<ReferenceBean> getReferences() {
		return references;
	}

	/**
	 * Return a human representation of the references
	 * 
	 * @return a human representation of the references
	 */
	public String getReferencesAsString() {
		StringBuilder sbRefs = new StringBuilder();
		for (ReferenceBean ref : references) {
			sbRefs.append(ref.getType()).append(": ");
			for (HasNameAndIDBean target : ref.getTargets()) {
				sbRefs.append(target.getName()).append(", ");
			}
			// Remove targets trailing comma
			if (sbRefs.length() > 0) {
				sbRefs.delete(sbRefs.length() - 2, sbRefs.length() - 1);
			}
			sbRefs.append("<br/>");
		}
		return sbRefs.toString();
	}

	/**
	 * @param references
	 *           the references to set
	 */
	public void setReferences(List<ReferenceBean> references) {
		this.references = references;
	}

	/**
	 * @return the boundType
	 */
	public HasNameAndIDBean getBoundType() {
		return boundType;
	}

	/**
	 * @param boundType
	 *           the boundType to set
	 */
	public void setBoundType(HasNameAndIDBean boundType) {
		this.boundType = boundType;
	}

	/**
	 * @return the enumeration
	 */
	public List<HasNameAndIDBean> getEnumeration() {
		return enumeration;
	}

	/**
	 * Return a human representation of an enumeration
	 * 
	 * @return a human representation of an enumeration
	 */
	public String getEnumerationAsString() {
		StringBuilder sb = new StringBuilder();
		for (HasNameAndIDBean comp : enumeration) {
			sb.append(comp.getName()).append(", ");
		}
		// Remove trailing comma
		if (sb.length() > 0) {
			sb.delete(sb.length() - 2, sb.length() - 1);
		}
		return sb.toString();
	}

	/**
	 * @param enumeration
	 *           the enumeration to set
	 */
	public void setEnumeration(List<HasNameAndIDBean> enumeration) {
		this.enumeration = enumeration;
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if (other == null || !(other instanceof ComponentTypeBean)) {
			return false;
		}
		return ((ComponentTypeBean) other).getId().equals(getId());
	}
}

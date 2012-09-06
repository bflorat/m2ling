/**
 * Copyright (C) 2012 Bertrand Florat
 *
 * @author "Bertrand Florat <bertrand@florat.net>"
 */
package org.m2ling.presentation.principles.model;

import java.io.Serializable;
import java.util.List;

import org.m2ling.common.utils.Utils;

/**
 * Mutable Component Type bean
 */
@SuppressWarnings("serial")
public class ComponentTypeBean implements Serializable {
	private HasNameAndIDBean vp;
	private String id = "";
	private String name = "";
	private String tags = "";
	private String description = "";
	private String comment = "";
	private String instantiationFactor = "0";
	private HasNameAndIDBean boundType;
	/** component id -> component name */
	private List<HasNameAndIDBean> enumeration;
	private List<ReferenceBean> references;
	/** GUI only item used to represent the drop button **/
	private String drop = "";

	public ComponentTypeBean() {
		super();
	}

	public String toString() {
		return Utils.toString(this);
	}

	public boolean equals(Object other) {
		if (other == null || !(other instanceof ComponentTypeBean)) {
			return false;
		}
		return ((ComponentTypeBean) other).getId().equals(getId());
	}

	public int hashCode() {
		return id.hashCode();
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
	 * @param enumeration
	 *           the enumeration to set
	 */
	public void setEnumeration(List<HasNameAndIDBean> enumeration) {
		this.enumeration = enumeration;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *           the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @param comment
	 *           the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * @param name
	 *           the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param tags
	 *           the tags to set
	 */
	public void setTags(String tags) {
		this.tags = tags;
	}

	/**
	 * @param description
	 *           the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Return a defensive copy of the tags.
	 * 
	 * @return a defensive copy of the tags
	 */
	public String getTags() {
		return tags;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
}

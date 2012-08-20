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
	private String vpID = "";
	private String id = "";
	private String name = "";
	private String tags = "";
	private String description = "";
	private String comment = "";
	private String iFactor = "0";
	private String boundTypeID = "";
	private List<String> enumeration;
	private boolean reifiable = false;
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
	 * @return the vpID
	 */
	public String getViewPointId() {
		return vpID;
	}

	/**
	 * @param vpID
	 *           the vpID to set
	 */
	public void setViewPointId(String vpID) {
		this.vpID = vpID;
	}

	/**
	 * @return the boundTypeID
	 */
	public String getBoundTypeID() {
		return boundTypeID;
	}

	/**
	 * @param boundTypeID
	 *           the boundTypeID to set
	 */
	public void setBoundTypeID(String boundTypeID) {
		this.boundTypeID = boundTypeID;
	}

	/**
	 * @return the iFactor
	 */
	public String getInstantiationFactor() {
		return iFactor;
	}

	/**
	 * @param iFactor
	 *           the iFactor to set. "n" or "*" means "any"
	 */
	public void setInstantiationFactor(String iFactor) {
		this.iFactor = iFactor;
	}

	/**
	 * @return the enumeration
	 */
	public List<String> getEnumeration() {
		return enumeration;
	}

	/**
	 * @param enumeration
	 *           the enumeration to set
	 */
	public void setEnumeration(List<String> enumeration) {
		this.enumeration = enumeration;
	}

	/**
	 * @return the reifiable
	 */
	public boolean isReifiable() {
		return reifiable;
	}

	/**
	 * @param reifiable
	 *           the reifiable to set
	 */
	public void setReifiable(boolean reifiable) {
		this.reifiable = reifiable;
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

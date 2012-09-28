/**
 * Copyright (C) 2012 Bertrand Florat
 *
 * @author "Bertrand Florat <bertrand@florat.net>"
 */
package org.m2ling.presentation.principles.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.m2ling.common.utils.Utils;
import org.m2ling.domain.core.LinkAccessType;
import org.m2ling.domain.core.LinkTemporality;

/**
 * Mutable Link Type bean
 */
@SuppressWarnings("serial")
public class LinkTypeBean implements Serializable {
	private HasNameAndIDBean vp;

	private String id = "";

	private String name = "";

	private String tags = "";

	private String description = "";

	private String comment = "";

	private String temporality = LinkTemporality.SYNC.name();

	private String accessType = LinkAccessType.READ.name();

	/** Sources */
	private List<HasNameAndIDBean> sourcesTypes = new ArrayList<HasNameAndIDBean>();

	private List<HasNameAndIDBean> targetsTypes = new ArrayList<HasNameAndIDBean>();

	/** GUI only item used to represent the drop button **/
	private String drop = "";

	private String iconPath = "";

	/**
	 * @return the temporality
	 */
	public String getTemporality() {
		return temporality;
	}

	/**
	 * @param temporality
	 *           the temporality to set
	 */
	public void setTemporality(String temporality) {
		this.temporality = temporality;
	}

	/**
	 * @return the accessType
	 */
	public String getAccessType() {
		return accessType;
	}

	/**
	 * @param accessType
	 *           the accessType to set
	 */
	public void setAccessType(String accessType) {
		this.accessType = accessType;
	}

	/**
	 * @return the sourcesTypes
	 */
	public List<HasNameAndIDBean> getSourcesTypes() {
		return sourcesTypes;
	}

	/**
	 * @param sourcesTypes
	 *           the sourcesTypes to set
	 */
	public void setSourcesTypes(List<HasNameAndIDBean> sourcesTypes) {
		this.sourcesTypes = sourcesTypes;
	}

	/**
	 * @return the targetsTypes
	 */
	public List<HasNameAndIDBean> getTargetsTypes() {
		return targetsTypes;
	}

	/**
	 * @param targetsTypes
	 *           the targetsTypes to set
	 */
	public void setTargetsTypes(List<HasNameAndIDBean> targetsTypes) {
		this.targetsTypes = targetsTypes;
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

	public LinkTypeBean() {
		super();
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

	@Override
	public String toString() {
		return Utils.toString(this);
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if (other == null || !(other instanceof LinkTypeBean)) {
			return false;
		}
		return ((LinkTypeBean) other).getId().equals(id);
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}
}

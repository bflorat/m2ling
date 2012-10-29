/**
 * Copyright (C) 2012 Bertrand Florat
 *
 * @author "Bertrand Florat <bertrand@florat.net>"
 */
package org.m2ling.presentation.principles.model;

import java.util.LinkedHashSet;
import java.util.Set;

import org.m2ling.presentation.common.model.AbstractCommonBean;
import org.m2ling.presentation.principles.LinkAccessType;
import org.m2ling.presentation.principles.LinkTemporality;

/**
 * Mutable Link Type bean
 */
@SuppressWarnings("serial")
public class LinkTypeBean extends AbstractCommonBean {
	private HasNameAndIDBean vp;

	private String linkTemporality = LinkTemporality.SYNC.name();

	private String linkAccessType = LinkAccessType.READ.name();

	private String status = "";

	/** Sources */
	private Set<HasNameAndIDBean> sourcesTypes = new LinkedHashSet<HasNameAndIDBean>();

	private Set<HasNameAndIDBean> destinationsTypes = new LinkedHashSet<HasNameAndIDBean>();

	/** GUI only item used to represent the drop button **/
	private String drop = "";

	private String iconPath = "";

	/**
	 * @return the temporality
	 */
	public String getLinkTemporality() {
		return linkTemporality;
	}

	/**
	 * @param temporality
	 *           the temporality to set
	 */
	public void setLinkTemporality(String temporality) {
		this.linkTemporality = temporality;
	}

	/**
	 * @return the accessType
	 */
	public String getLinkAccessType() {
		return linkAccessType;
	}

	/**
	 * @param accessType
	 *           the accessType to set
	 */
	public void setLinkAccessType(String accessType) {
		this.linkAccessType = accessType;
	}

	/**
	 * @return the sourcesTypes
	 */
	public Set<HasNameAndIDBean> getSourcesTypes() {
		return sourcesTypes;
	}

	/**
	 * Return a human representation of an sources types
	 * 
	 * @return a human representation of an sources types
	 */
	public String getSourcesTypesAsString() {
		StringBuilder sb = new StringBuilder();
		for (HasNameAndIDBean ct : sourcesTypes) {
			sb.append(ct.getName()).append(", ");
		}
		// Remove trailing comma
		if (sb.length() > 0) {
			sb.delete(sb.length() - 2, sb.length() - 1);
		}
		return sb.toString();
	}

	/**
	 * @param sourcesTypes
	 *           the sourcesTypes to set
	 */
	public void setSourcesTypes(Set<HasNameAndIDBean> sourcesTypes) {
		this.sourcesTypes = sourcesTypes;
	}

	/**
	 * @return the destinationsTypes
	 */
	public Set<HasNameAndIDBean> getDestinationsTypes() {
		return destinationsTypes;
	}

	/**
	 * Return a human representation of an destinations types
	 * 
	 * @return a human representation of an destinations types
	 */
	public String getDestinationsTypesAsString() {
		StringBuilder sb = new StringBuilder();
		for (HasNameAndIDBean ct : destinationsTypes) {
			sb.append(ct.getName()).append(", ");
		}
		// Remove trailing comma
		if (sb.length() > 0) {
			sb.delete(sb.length() - 2, sb.length() - 1);
		}
		return sb.toString();
	}

	/**
	 * @param destinationsTypes
	 *           the destinationsTypes to set
	 */
	public void setDestinationsTypes(Set<HasNameAndIDBean> destinationsTypes) {
		this.destinationsTypes = destinationsTypes;
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
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *           the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if (other == null || !(other instanceof LinkTypeBean)) {
			return false;
		}
		return ((LinkTypeBean) other).getId().equals(getId());
	}
}

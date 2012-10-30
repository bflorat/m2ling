/**
 * Copyright (C) 2012 Bertrand Florat
 *
 * @author "Bertrand Florat <bertrand@florat.net>"
 */
package org.m2ling.presentation.studio.model;

import org.m2ling.common.utils.Utils;
import org.m2ling.presentation.common.model.AbstractCommonBean;
import org.m2ling.presentation.principles.model.HasNameAndIDBean;

/**
 * Mutable Link instance bean
 */
@SuppressWarnings("serial")
public class LinkInstanceBean extends AbstractCommonBean {
	/** Drop */
	private String drop = "";

	private HasNameAndIDBean source;

	private HasNameAndIDBean destination;

	private HasNameAndIDBean link;

	public LinkInstanceBean() {
		super();
	}

	public String toString() {
		return Utils.toString(this);
	}

	public boolean equals(Object other) {
		if (other == null || !(other instanceof LinkInstanceBean)) {
			return false;
		}
		return ((LinkInstanceBean) other).getId().equals(getId());
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
	 * @return the link
	 */
	public HasNameAndIDBean getLink() {
		return link;
	}

	/**
	 * @param link
	 *           the link to set
	 */
	public void setLink(HasNameAndIDBean link) {
		this.link = link;
	}

	/**
	 * @return the source
	 */
	public HasNameAndIDBean getSource() {
		return source;
	}

	/**
	 * @param source
	 *           the source to set
	 */
	public void setSource(HasNameAndIDBean source) {
		this.source = source;
	}

	/**
	 * @return the destination
	 */
	public HasNameAndIDBean getDestination() {
		return destination;
	}

	/**
	 * @param destination
	 *           the destination to set
	 */
	public void setDestination(HasNameAndIDBean destination) {
		this.destination = destination;
	}
}

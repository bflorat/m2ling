/**
 * Copyright (C) 2012 Bertrand Florat
 *
 * @author "Bertrand Florat <bertrand@florat.net>"
 */
package org.m2ling.presentation.studio.model;

import java.util.LinkedHashSet;
import java.util.Set;

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

	private Set<HasNameAndIDBean> sources = new LinkedHashSet<HasNameAndIDBean>();

	private Set<HasNameAndIDBean> destinations = new LinkedHashSet<HasNameAndIDBean>();

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
	 * @return the sources
	 */
	public Set<HasNameAndIDBean> getSources() {
		return sources;
	}

	/**
	 * @param sources
	 *           the sources to set
	 */
	public void setSources(Set<HasNameAndIDBean> sources) {
		this.sources = sources;
	}

	/**
	 * @return the destinations
	 */
	public Set<HasNameAndIDBean> getDestinations() {
		return destinations;
	}

	/**
	 * @param destinations
	 *           the destinations to set
	 */
	public void setDestinations(Set<HasNameAndIDBean> destinations) {
		this.destinations = destinations;
	}
}

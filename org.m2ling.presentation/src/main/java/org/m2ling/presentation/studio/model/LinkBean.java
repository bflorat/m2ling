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
 * Mutable Link bean
 */
@SuppressWarnings("serial")
public class LinkBean extends AbstractCommonBean {
	/** Drop */
	private String drop = "";

	private int timeout = -1;

	private Set<HasNameAndIDBean> sources = new LinkedHashSet<HasNameAndIDBean>();

	private Set<HasNameAndIDBean> destinations = new LinkedHashSet<HasNameAndIDBean>();

	private HasNameAndIDBean type;

	public LinkBean() {
		super();
	}

	public String toString() {
		return Utils.toString(this);
	}

	public boolean equals(Object other) {
		if (other == null || !(other instanceof LinkBean)) {
			return false;
		}
		return ((LinkBean) other).getId().equals(getId());
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
	 * @return the type
	 */
	public HasNameAndIDBean getType() {
		return type;
	}

	/**
	 * @param type
	 *           the type to set
	 */
	public void setType(HasNameAndIDBean type) {
		this.type = type;
	}

	/**
	 * @return the timeout
	 */
	public int getTimeout() {
		return timeout;
	}

	/**
	 * @param timeout
	 *           the timeout to set
	 */
	public void setTimeout(int timeout) {
		this.timeout = timeout;
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

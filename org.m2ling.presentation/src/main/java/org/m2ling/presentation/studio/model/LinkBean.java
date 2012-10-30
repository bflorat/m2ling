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

	private Set<ComponentBean> sources = new LinkedHashSet<ComponentBean>();

	private Set<ComponentBean> destinations = new LinkedHashSet<ComponentBean>();

	private HasNameAndIDBean type;

	private LinkBean boundComponent;

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
	 * @return the boundComponent
	 */
	public LinkBean getBoundComponent() {
		return boundComponent;
	}

	/**
	 * @param boundComponent
	 *           the boundComponent to set
	 */
	public void setBoundComponent(LinkBean boundComponent) {
		this.boundComponent = boundComponent;
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
	public Set<ComponentBean> getSources() {
		return sources;
	}

	/**
	 * @param sources
	 *           the sources to set
	 */
	public void setSources(Set<ComponentBean> sources) {
		this.sources = sources;
	}

	/**
	 * @return the destinations
	 */
	public Set<ComponentBean> getDestinations() {
		return destinations;
	}

	/**
	 * @param destinations
	 *           the destinations to set
	 */
	public void setDestinations(Set<ComponentBean> destinations) {
		this.destinations = destinations;
	}
}

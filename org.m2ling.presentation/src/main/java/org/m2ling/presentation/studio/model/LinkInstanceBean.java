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

	private String status = null;

	private int timeout = -1;

	private Set<ComponentInstanceBean> sources = new LinkedHashSet<ComponentInstanceBean>();

	private Set<ComponentInstanceBean> destinations = new LinkedHashSet<ComponentInstanceBean>();

	private HasNameAndIDBean link;

	private LinkInstanceBean boundComponent;

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
	 * @return the boundComponent
	 */
	public LinkInstanceBean getBoundComponent() {
		return boundComponent;
	}

	/**
	 * @param boundComponent
	 *           the boundComponent to set
	 */
	public void setBoundComponent(LinkInstanceBean boundComponent) {
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
	public Set<ComponentInstanceBean> getSources() {
		return sources;
	}

	/**
	 * @param sources
	 *           the sources to set
	 */
	public void setSources(Set<ComponentInstanceBean> sources) {
		this.sources = sources;
	}

	/**
	 * @return the destinations
	 */
	public Set<ComponentInstanceBean> getDestinations() {
		return destinations;
	}

	/**
	 * @param destinations
	 *           the destinations to set
	 */
	public void setDestinations(Set<ComponentInstanceBean> destinations) {
		this.destinations = destinations;
	}
}

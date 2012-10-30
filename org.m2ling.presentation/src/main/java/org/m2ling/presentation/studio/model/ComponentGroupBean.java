/**
 * Copyright (C) 2012 Bertrand Florat
 *
 * @author "Bertrand Florat <bertrand@florat.net>"
 */
package org.m2ling.presentation.studio.model;

import java.util.LinkedHashSet;
import java.util.Set;

import org.m2ling.presentation.common.model.AbstractCommonBean;

/**
 * Mutable Component group bean
 */
@SuppressWarnings("serial")
public class ComponentGroupBean extends AbstractCommonBean {
	/** Drop */
	private String drop = "";

	private Set<ComponentBean> components = new LinkedHashSet<ComponentBean>(3);

	public ComponentGroupBean() {
		super();
	}

	public boolean equals(Object other) {
		if (other == null || !(other instanceof ComponentGroupBean)) {
			return false;
		}
		return ((ComponentGroupBean) other).getId().equals(getId());
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
	 * @return the components
	 */
	public Set<ComponentBean> getComponents() {
		return components;
	}

	/**
	 * @param components
	 *           the components to set
	 */
	public void setComponents(Set<ComponentBean> components) {
		this.components = components;
	}
}

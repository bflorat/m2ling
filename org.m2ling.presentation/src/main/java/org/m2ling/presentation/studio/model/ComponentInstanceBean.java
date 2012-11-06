/**
 * Copyright (C) 2012 Bertrand Florat
 *
 * @author "Bertrand Florat <bertrand@florat.net>"
 */
package org.m2ling.presentation.studio.model;

import java.util.ArrayList;
import java.util.List;

import org.m2ling.presentation.common.model.AbstractCommonBean;
import org.m2ling.presentation.principles.model.HasNameAndIDBean;
import org.m2ling.presentation.principles.model.ReferenceBean;

/**
 * Mutable Component instance bean
 */
@SuppressWarnings("serial")
public class ComponentInstanceBean extends AbstractCommonBean {
	/** Drop */
	private String drop = "";

	private List<ReferenceBean> references = new ArrayList<ReferenceBean>(2);

	private HasNameAndIDBean component;

	private HasNameAndIDBean boundInstance;

	public ComponentInstanceBean() {
		super();
	}

	public boolean equals(Object other) {
		if (other == null || !(other instanceof ComponentInstanceBean)) {
			return false;
		}
		return ((ComponentInstanceBean) other).getId().equals(getId());
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
	 * @return the associated component
	 */
	public HasNameAndIDBean getComponent() {
		return component;
	}

	/**
	 * @param component
	 *           the component to set
	 */
	public void setComponent(HasNameAndIDBean component) {
		this.component = component;
	}

	/**
	 * @return the bound instance
	 */
	public HasNameAndIDBean getBoundInstance() {
		return boundInstance;
	}

	/**
	 * @param boundInstance
	 *           the bound instance to set
	 */
	public void setBoundInstance(HasNameAndIDBean boundInstance) {
		this.boundInstance = boundInstance;
	}
}

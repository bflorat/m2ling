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
 * Mutable Component bean
 */
@SuppressWarnings("serial")
public class ComponentBean extends AbstractCommonBean {
	/** Drop */
	private String drop = "";

	private String status = null;

	private List<ReferenceBean> references = new ArrayList<ReferenceBean>(2);

	private HasNameAndIDBean type;

	private ComponentBean boundComponent;

	public ComponentBean() {
		super();
	}

	public boolean equals(Object other) {
		if (other == null || !(other instanceof ComponentBean)) {
			return false;
		}
		return ((ComponentBean) other).getId().equals(getId());
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
	public ComponentBean getBoundComponent() {
		return boundComponent;
	}

	/**
	 * @param boundComponent
	 *           the boundComponent to set
	 */
	public void setBoundComponent(ComponentBean boundComponent) {
		this.boundComponent = boundComponent;
	}
}

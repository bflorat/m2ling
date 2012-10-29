/**
 * Copyright (C) 2012 Bertrand Florat
 *
 * @author "Bertrand Florat <bertrand@florat.net>"
 */
package org.m2ling.presentation.studio.model;

import org.m2ling.presentation.common.model.AbstractCommonBean;
import org.m2ling.presentation.principles.model.HasNameAndIDBean;

/**
 * Mutable view bean
 */
@SuppressWarnings("serial")
public class ViewBean extends AbstractCommonBean {
	/** Drop */
	private String drop = "";

	private String status = null;

	private HasNameAndIDBean vp;

	public ViewBean() {
		super();
	}

	public boolean equals(Object other) {
		if (other == null || !(other instanceof ViewBean)) {
			return false;
		}
		return ((ViewBean) other).getId().equals(getId());
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
	 * @return the vpID
	 */
	public HasNameAndIDBean getViewpoint() {
		return vp;
	}

	/**
	 * @param vpID
	 *           the vpID to set
	 */
	public void setViewpoint(HasNameAndIDBean vp) {
		this.vp = vp;
	}
}

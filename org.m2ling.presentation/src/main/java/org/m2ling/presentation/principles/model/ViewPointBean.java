/**
 * Copyright (C) 2012 Bertrand Florat
 *
 * @author "Bertrand Florat <bertrand@florat.net>"
 */
package org.m2ling.presentation.principles.model;

import org.m2ling.presentation.common.model.AbstractCommonBean;

/**
 * Mutable View point bean
 */
@SuppressWarnings("serial")
public class ViewPointBean extends AbstractCommonBean {
	private String statusLiterals = "";

	private String iconPath = "";

	public ViewPointBean() {
		super();
	}

	public boolean equals(Object o) {
		if (o == null || !(o instanceof ViewPointBean)) {
			return false;
		}
		ViewPointBean other = (ViewPointBean) o;
		return other.getId().equals(getId());
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

	/**
	 * @return the statusLiterals
	 */
	public String getStatusLiterals() {
		return statusLiterals;
	}

	/**
	 * @param statusLiterals
	 *           the statusLiterals to set
	 */
	public void setStatusLiterals(String statusLiterals) {
		this.statusLiterals = statusLiterals;
	}
}

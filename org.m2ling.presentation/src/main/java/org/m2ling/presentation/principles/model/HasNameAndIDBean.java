/**
 * Copyright (C) 2012 Bertrand Florat
 *
 * @author "Bertrand Florat <bertrand@florat.net>"
 */
package org.m2ling.presentation.principles.model;

import java.io.Serializable;

import org.m2ling.common.utils.Utils;

/**
 * Mutable HasNameAndID bean
 */
@SuppressWarnings("serial")
public class HasNameAndIDBean implements Serializable {
	private String name;

	private String id;

	public HasNameAndIDBean() {
		super();
	}

	/** Static factory */
	public static HasNameAndIDBean newInstance(String id, String name) {
		HasNameAndIDBean bean = new HasNameAndIDBean();
		bean.setId(id);
		bean.setName(name);
		return bean;
	}

	public String toString() {
		return Utils.toString(this);
	}

	public boolean equals(Object other) {
		if (other == null || !(other instanceof HasNameAndIDBean)) {
			return false;
		}
		HasNameAndIDBean otherBean = (HasNameAndIDBean) other;
		return otherBean.getId().equals(getId());
	}

	public int hashCode() {
		return getId().hashCode();
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *           the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *           the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
}

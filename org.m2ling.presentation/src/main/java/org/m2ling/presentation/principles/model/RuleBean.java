/**
 * Copyright (C) 2012 Bertrand Florat
 *
 * @author "Bertrand Florat <bertrand@florat.net>"
 */
package org.m2ling.presentation.principles.model;

import java.util.Map;
import java.util.TreeMap;

import org.m2ling.presentation.common.model.AbstractCommonBean;

/**
 * Mutable Rule bean
 */
@SuppressWarnings("serial")
public class RuleBean extends AbstractCommonBean {
	private String vpID = "";

	/** Drop */
	private String drop = "";

	private String status = null;

	private int priority = 0;

	private String rationale = "";

	private String exceptions = "";

	private Map<Long, String> history = new TreeMap<Long, String>();

	public RuleBean() {
		super();
	}

	public boolean equals(Object other) {
		if (other == null || !(other instanceof RuleBean)) {
			return false;
		}
		return ((RuleBean) other).getId().equals(getId());
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
	 * @return the rationale
	 */
	public String getRationale() {
		return rationale;
	}

	/**
	 * @param rationale
	 *           the rationale to set
	 */
	public void setRationale(String rationale) {
		this.rationale = rationale;
	}

	/**
	 * @return the exceptions
	 */
	public String getExceptions() {
		return exceptions;
	}

	/**
	 * @param exceptions
	 *           the exceptions to set
	 */
	public void setExceptions(String exceptions) {
		this.exceptions = exceptions;
	}

	/**
	 * @return the history
	 */
	public Map<Long, String> getHistory() {
		return history;
	}

	/**
	 * @param history
	 *           the history to set
	 */
	public void setHistory(Map<Long, String> history) {
		this.history = history;
	}

	/**
	 * @return the priority
	 */
	public int getPriority() {
		return priority;
	}

	/**
	 * @param priority
	 *           the priority to set
	 */
	public void setPriority(int priority) {
		this.priority = priority;
	}

	/**
	 * @param id
	 *           the view point id to set
	 */
	public void setViewPointId(String id) {
		this.vpID = id;
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
	 * @return the associated viewpoint id
	 */
	public String getViewPointId() {
		return vpID;
	}
}

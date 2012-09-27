/**
 * Copyright (C) 2012 Bertrand Florat
 *
 * @author "Bertrand Florat <bertrand@florat.net>"
 */
package org.m2ling.presentation.principles.model;

import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;

import org.m2ling.common.utils.Utils;

/**
 * Mutable Rule bean
 */
@SuppressWarnings("serial")
public class RuleBean implements Serializable {
	private String vpID = "";
	private String id = "";
	private String name = "";
	/** Drop */
	private String drop = "";
	/**
	 * Comma-separated tags
	 */
	private String tags = "";
	private String description = "";
	private String comment = "";
	private String status = null;
	private int priority = 0;
	private String rationale = "";
	private String exceptions = "";
	private Map<Long, String> history = new TreeMap<Long, String>();

	public RuleBean() {
		super();
	}

	/** Deep copy constructor **/
	public RuleBean(RuleBean rule) {
		super();
		this.vpID = rule.getViewPointId();
		this.id = rule.getId();
		this.name = rule.getName();
		this.tags = rule.getTags();
		this.description = rule.getDescription();
		this.comment = rule.getComment();
		this.status = rule.getStatus();
		this.priority = rule.getPriority();
		this.rationale = rule.getRationale();
		this.exceptions = rule.getExceptions();
		// This is possible because Long and String are immutable
		this.history = new TreeMap<Long, String>(rule.getHistory());
	}

	public String toString() {
		return Utils.toString(this);
	}

	public boolean equals(Object other) {
		if (other == null || !(other instanceof RuleBean)) {
			return false;
		}
		return ((RuleBean) other).getId().equals(getId());
	}

	public int hashCode() {
		return id.hashCode();
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

	/**
	 * @param id
	 *           the view point id to set
	 */
	public void setViewPointId(String id) {
		this.vpID = id;
	}

	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @param comment
	 *           the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
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
	 * @param name
	 *           the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param tags
	 *           the tags to set
	 */
	public void setTags(String tags) {
		this.tags = tags;
	}

	/**
	 * @param description
	 *           the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Return a defensive copy of the tags.
	 * 
	 * @return a defensive copy of the tags
	 */
	public String getTags() {
		return tags;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @return the associated viewpoint id
	 */
	public String getViewPointId() {
		return vpID;
	}
}

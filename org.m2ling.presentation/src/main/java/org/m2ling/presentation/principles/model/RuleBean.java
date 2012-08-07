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
	 * Comma-separated tags
	 */
	private String tags = "";
	private String description = "";
	private String comment = "";
	private String status = null;
	// Default priority : medium
	private String priority = "";
	private String rationale = "";
	private String exceptions = "";
	private Map<Long, String> history = new TreeMap<Long, String>();

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
	public String getPriority() {
		return priority;
	}

	/**
	 * @param priority
	 *           the priority to set
	 */
	public void setPriority(String priority) {
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

	public RuleBean() {
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

	public String toString() {
		return Utils.toString(this);
	}
}

/**
 * Copyright (C) 2012 Bertrand Florat
 *
 * @author "Bertrand Florat <bertrand@florat.net>"
 */
package org.m2ling.presentation.principles.model;

import java.io.Serializable;

import org.m2ling.common.utils.Utils;

/**
 * Mutable View point bean
 */
@SuppressWarnings("serial")
public class ViewPointBean implements Serializable {

	private String id = "";
	private String name = "";
	/**
	 * Comma-separated tags
	 */
	private String tags = "";
	private String description = "";
	private String comment = "";
	private String statusLiterals = "";
	private String iconPath = "";

	/**
	 * @return the iconPath
	 */
	public String getIconPath() {
		return iconPath;
	}

	/**
	 * @param iconPath the iconPath to set
	 */
	public void setIconPath(String iconPath) {
		this.iconPath = iconPath;
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

	public ViewPointBean() {
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
	
	public String toString() {
		return Utils.toString(this);
	}
	
	

}

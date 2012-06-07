/**
 * Copyright (C) 2012 Bertrand Florat
 *
 * @author "Bertrand Florat <bertrand@florat.net>"
 */
package org.m2ling.presentation.principles.model;

import java.io.Serializable;

/**
 * Mutable View point bean
 */
public class ViewPointBean implements Serializable {

	private static final long serialVersionUID = -6166933742017493086L;

	private String name = "";
	/**
	 * Comma-separated tags
	 */
	private String tags = "";
	private String label = "";
	private String comment = "";
	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	private String statusLiterals = "";

	/**
	 * @return the statusLiterals
	 */
	public String getStatusLiterals() {
		return statusLiterals;
	}

	/**
	 * @param statusLiterals the statusLiterals to set
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
	 * @param label
	 *           the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
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
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

}

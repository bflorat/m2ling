/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.common.dto.core;

import java.util.ArrayList;
import java.util.List;

/**
 * Tag DTO object used between layers.
 * 
 * @author Bertrand Florat <bertrand@florat.net>
 */
public class ViewPointDTO {

	private final String name;
	private final List<String> tags;
	private final String label;
	private final String comment;
	private final List<String> statusLiterals;

	public static class Builder {

		// Required configuration
		private final String name;

		// Optional configuration
		private List<String> tags = null;
		private String label = null;
		private String comment = null;
		private List<String> statusLiterals;

		public Builder(String name) {
			this.name = name;
		}

		public Builder tags(List<String> tags) {
			this.tags = tags;
			return this;
		}

		public Builder label(String label) {
			this.label = label;
			return this;
		}
		
		public Builder comment(String comment) {
			this.comment = comment;
			return this;
		}
		
		public Builder statusLiterals(List<String> statusLiterals) {
			this.statusLiterals = statusLiterals;
			return this;
		}

		public ViewPointDTO build() {
			ViewPointDTO dto = new ViewPointDTO(this);
			return dto;
		}
	}

	private ViewPointDTO(Builder builder) {
		name = builder.name;
		if (builder.tags != null && builder.tags.size() > 0) {
			tags = new ArrayList<String>(builder.tags); // defensive copy
		} else {
			tags = null;
		}
		label = builder.label;
		comment = builder.comment;
		if (builder.statusLiterals != null && builder.statusLiterals.size() > 0) {
			statusLiterals = new ArrayList<String>(builder.statusLiterals); // defensive copy
		} else {
			statusLiterals = null;
		}
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
	public List<String> getTags() {
		if (tags == null) {
			return null;
		}
		return new ArrayList<String>(tags);
	}
	
	/**
	 * Return a defensive copy of the status literals.
	 * 
	 * @return a defensive copy of the status literals
	 */
	public List<String> getStatusLiterals() {
		if (statusLiterals == null) {
			return null;
		}
		return new ArrayList<String>(statusLiterals);
	}

	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}
	
	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

}

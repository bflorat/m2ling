/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.common.dto.core;

import java.util.ArrayList;
import java.util.List;

/**
 * Rule DTO object used between layers.
 * 
 * @author Bertrand Florat <bertrand@florat.net>
 */
public class RuleDTO {

	private final String id;
	private final String name;
	private final List<String> tags;
	private final String description;
	private final String comment;
	private final String status;
	private final String priority;

	public static class Builder {

		// Required configuration
		private final String name;
		private final String id;

		// Optional configuration
		private List<String> tags = null;
		private String description = null;
		private String comment = null;
		private String status = null;
		private String priority = null;

		public Builder(String id, String name) {
			this.id = id;
			this.name = name;
		}

		public Builder tags(List<String> tags) {
			this.tags = tags;
			return this;
		}

		public Builder description(String description) {
			this.description = description;
			return this;
		}

		public Builder comment(String comment) {
			this.comment = comment;
			return this;
		}

		public Builder status(String status) {
			this.status = status;
			return this;
		}

		public Builder priority(String priority) {
			this.priority = priority;
			return this;
		}

		public RuleDTO build() {
			RuleDTO dto = new RuleDTO(this);
			return dto;
		}
	}

	private RuleDTO(Builder builder) {
		id = builder.id;
		name = builder.name;
		if (builder.tags != null) {
			tags = new ArrayList<String>(builder.tags); // defensive copy
		} else {
			tags = null;
		}
		description = builder.description;
		comment = builder.comment;
		status = builder.status;
		priority = builder.priority;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
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
	 * Return the status.
	 * 
	 * @return the status literal.
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @return the priority
	 */
	public String getPriority() {
		return priority;
	}

}

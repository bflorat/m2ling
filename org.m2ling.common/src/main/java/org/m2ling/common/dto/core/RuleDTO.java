/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.common.dto.core;

import java.util.ArrayList;
import java.util.List;

import org.m2ling.common.utils.Utils;

import com.google.common.collect.ImmutableList;

/**
 * Rule DTO object used between layers.
 * 
 * @author Bertrand Florat <bertrand@florat.net>
 */
public class RuleDTO implements Comparable<RuleDTO> {
	private final String vpID;
	private final String id;
	private final String name;
	private final List<String> tags;
	private final String description;
	private final String comment;
	private final String status;
	private final int priority;
	private final String rationale;
	private final String exceptions;
	private final List<StatusEventDTO> history;

	public static class Builder {
		// Required configuration
		private final String name;
		private final String id;
		private final String vpID;
		// Optional configuration
		private List<String> tags = new ArrayList<String>(1);
		private String description = null;
		private String comment = null;
		private String status = null;
		private int priority = 0;
		private String rationale = null;
		private String exceptions = null;
		private List<StatusEventDTO> history = new ArrayList<StatusEventDTO>(1);

		public Builder(String vpID, String id, String name) {
			this.id = id;
			this.vpID = vpID;
			this.name = name;
		}

		public Builder addTag(String tag) {
			this.tags.add(tag);
			return this;
		}

		public Builder addEvent(StatusEventDTO event) {
			this.history.add(event);
			return this;
		}

		public Builder description(String description) {
			this.description = description;
			return this;
		}

		public Builder rationale(String rationale) {
			this.rationale = rationale;
			return this;
		}

		public Builder exceptions(String exceptions) {
			this.exceptions = exceptions;
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

		public Builder priority(int priority) {
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
		vpID = builder.vpID;
		tags = ImmutableList.copyOf(builder.tags); // defensive copy
		description = builder.description;
		comment = builder.comment;
		status = builder.status;
		priority = builder.priority;
		rationale = builder.rationale;
		exceptions = builder.exceptions;
		history = builder.history;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the rule id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return the associated viewpoint id
	 */
	public String getViewPointId() {
		return vpID;
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
	public int getPriority() {
		return priority;
	}

	/**
	 * @return the rationale
	 */
	public String getRationale() {
		return rationale;
	}

	/**
	 * @return the exceptions
	 */
	public String getExceptions() {
		return exceptions;
	}

	/**
	 * @return the history
	 */
	public List<StatusEventDTO> getHistory() {
		return history;
	}

	public String toString() {
		return Utils.toString(this);
	}

	public boolean equals(Object o) {
		if (o == null || !(o instanceof RuleDTO)) {
			return false;
		}
		RuleDTO other = (RuleDTO) o;
		return other.getId().equals(getId());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(RuleDTO o) {
		return o.getName().compareTo(o.getName());
	}
}

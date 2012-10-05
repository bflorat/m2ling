/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.common.dto.core;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.m2ling.common.utils.Utils;

import com.google.common.collect.ImmutableSet;

/**
 * Viewpoint DTO object used between layers.
 * 
 * @author Bertrand Florat <bertrand@florat.net>
 */
public class ViewPointDTO implements Comparable<ViewPointDTO> {
	private final String id;

	private final String name;

	private final List<String> tags;

	private final String description;

	private final String comment;

	private final Set<String> statusLiterals;

	public static class Builder {
		// Required configuration
		private final String name;

		private final String id;

		// Optional configuration
		private List<String> tags = new ArrayList<String>(1);

		private String description = "";

		private String comment = "";

		private Set<String> statusLiterals = new LinkedHashSet<String>(1);

		public Builder(String id, String name) {
			this.id = id;
			this.name = name;
		}

		public Builder addTag(String tag) {
			this.tags.add(tag);
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

		public Builder addStatusLiteral(String statusLiteral) {
			this.statusLiterals.add(statusLiteral);
			return this;
		}

		public ViewPointDTO build() {
			ViewPointDTO dto = new ViewPointDTO(this);
			return dto;
		}
	}

	private ViewPointDTO(Builder builder) {
		id = builder.id;
		name = builder.name;
		if (builder.tags != null) {
			tags = new ArrayList<String>(builder.tags); // defensive copy
		} else {
			tags = null;
		}
		description = builder.description;
		comment = builder.comment;
		statusLiterals = ImmutableSet.copyOf(builder.statusLiterals); // defensive copy
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
	 * Return a defensive copy of the status literals.
	 * 
	 * @return a defensive copy of the status literals
	 */
	public Set<String> getStatusLiterals() {
		if (statusLiterals == null) {
			return null;
		}
		return ImmutableSet.copyOf(statusLiterals);
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

	public String toString() {
		return Utils.toString(this);
	}

	public boolean equals(Object o) {
		if (o == null || !(o instanceof ViewPointDTO)) {
			return false;
		}
		ViewPointDTO other = (ViewPointDTO) o;
		return other.getId().equals(getId());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(ViewPointDTO o) {
		// Make sure this method is consistent with equals
		if (this.equals(o)) {
			return 0;
		}
		// If names are not provided, items are not correctly sorted
		// but we only have the bounded type ID and we don't want to perform
		// a service call to get details just for sorting purpose.
		if (getName() == null || o.getName() == null) {
			return -1;
		}
		return name.compareTo(o.getName());
	}
}

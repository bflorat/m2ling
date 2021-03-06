/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.common.dto.core;

import java.util.ArrayList;
import java.util.List;

import org.m2ling.common.utils.Utils;

/**
 * Mutualize common DTO fields.
 * 
 * @author Bertrand Florat <bertrand@florat.net>
 */
abstract public class AbstractCommonDTO {
	private final String id;

	private final String name;

	private final List<String> tags;

	private final String description;

	private final String comment;

	private final String status;

	public static abstract class Builder {
		// Required configuration
		private final String name;

		private final String id;

		// Optional configuration
		private List<String> tags = new ArrayList<String>(1);

		private String status;

		private String description = "";

		private String comment = "";

		public Builder(String id, String name) {
			this.id = id;
			this.name = name;
		}

		public Builder status(String status) {
			this.status = status;
			return this;
		}

		/**
		 * @return the status
		 */
		public String getStatus() {
			return status;
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
	
	}

	public AbstractCommonDTO(Builder builder) {
		id = builder.id;
		name = builder.name;
		status = builder.status;
		if (builder.tags != null) {
			tags = new ArrayList<String>(builder.tags); // defensive copy
		} else {
			tags = null;
		}
		description = builder.description;
		comment = builder.comment;
	}

	public String toString() {
		return Utils.toString(this);
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
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
}

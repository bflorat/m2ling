/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.dto.core;

import java.util.ArrayList;
import java.util.List;

/**
 * Tag DTO object used between layers.
 * 
 * @author Bertrand Florat <bertrand@florat.net>
 */
public class ViewPointDTO {

	private final String name;
	private final String baseVPName;
	private final List<String> tags;
	private final String label;

	public static class Builder {

		// Required parameters
		private final String name;

		// Optional parameters
		private List<String> tags = null;
		private String baseVPName = null;
		private String label = null;

		public Builder(String name) {
			this.name = name;
		}

		public Builder tags(List<String> tags) {
			this.tags = tags;
			return this;
		}

		public Builder base(String baseVPName) {
			this.baseVPName = baseVPName;
			return this;
		}

		public Builder label(String label) {
			this.label = label;
			return this;
		}

		public ViewPointDTO build() {
			ViewPointDTO dto = new ViewPointDTO(this);
			return dto;
		}
	}

	private ViewPointDTO(Builder builder) {
		name = builder.name;
		tags = new ArrayList<String>(builder.tags); // defensive copy
		baseVPName = builder.baseVPName;
		label = builder.label;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the baseVPName
	 */
	public String getBaseVPName() {
		return baseVPName;
	}

	/**
	 * Return a defensive copy of the tags.
	 * @return a defensive copy of the tags
	 */
	public List<String> getTags() {
		return new ArrayList<String>(tags);
	}

	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

}

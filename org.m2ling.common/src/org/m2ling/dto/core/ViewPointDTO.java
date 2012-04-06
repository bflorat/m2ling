/**
 * Copyright (C) Bertrand Florat
 */
package org.m2ling.dto.core;

/**
 * Tag DTO object used between layers.
 * 
 * @author Bertrand Florat <bertrand@florat.net>
 */
public class ViewPointDTO {

	private final String name;
	private final String baseVPName;
	private final String tags;
	private final String label;

	public static class Builder {

		// Required parameters
		private final String name;

		// Optional parameters
		private String tags = null;
		private String baseVPName = null;
		private String label = null;

		public Builder(String name) {
			this.name = name;
		}

		public Builder tags(String tags) {
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
		tags = builder.tags;
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
	 * @return the tags
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

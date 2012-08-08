/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.common.dto.core;

import java.util.ArrayList;
import java.util.List;

import org.m2ling.common.utils.Utils;

import com.google.common.collect.ImmutableList;

/**
 * Component type DTO object used between layers.
 * 
 * @author Bertrand Florat <bertrand@florat.net>
 */
public class ComponentTypeDTO implements Comparable<ComponentTypeDTO> {
	private final String vpID;
	private final String id;
	private final String name;
	private final List<String> tags;
	private final String description;
	private final String comment;
	private final List<ReferenceDTO> references;
	private final String boundTypeID;
	private final int iFactor;
	private final boolean reifiable;
	private final List<String> enumeration;

	public static class Builder {
		// Required configuration
		private final String name;
		private final String id;
		private final String vpID;
		// Optional configuration
		private List<String> tags = new ArrayList<String>(1);
		private String description = "";
		private String comment = "";
		private List<ReferenceDTO> references = new ArrayList<ReferenceDTO>(1);
		private String boundTypeID;
		private int iFactor;
		private boolean reifiable;
		private List<String> enumeration;

		public Builder(String vpID, String id, String name) {
			this.id = id;
			this.vpID = vpID;
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

		public Builder reference(ReferenceDTO reference) {
			this.references.add(reference);
			return this;
		}

		public Builder boundTypeID(String boundTypeID) {
			this.boundTypeID = boundTypeID;
			return this;
		}

		public Builder instantiationFactor(int iFactor) {
			this.iFactor = iFactor;
			return this;
		}

		public Builder reifiable(boolean reifiable) {
			this.reifiable = reifiable;
			return this;
		}

		/**
		 * Add a component ID to the enumeration of acceptable values for a component type.
		 * 
		 * @param componentID
		 * @return the builder
		 */
		public Builder enumeration(String componentID) {
			this.enumeration.add(componentID);
			return this;
		}

		public ComponentTypeDTO build() {
			ComponentTypeDTO dto = new ComponentTypeDTO(this);
			return dto;
		}
	}

	private ComponentTypeDTO(Builder builder) {
		id = builder.id;
		name = builder.name;
		vpID = builder.vpID;
		tags = ImmutableList.copyOf(builder.tags); // defensive copy
		description = builder.description;
		comment = builder.comment;
		references = builder.references;
		boundTypeID = builder.boundTypeID;
		iFactor = builder.iFactor;
		reifiable = builder.reifiable;
		enumeration = ImmutableList.copyOf(builder.enumeration);
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

	public String getBoundTypeID() {
		return boundTypeID;
	}

	public int getInstantiationFactor() {
		return iFactor;
	}

	/**
	 * @return the references
	 */
	public List<ReferenceDTO> getReferences() {
		return references;
	}

	public String toString() {
		return Utils.toString(this);
	}

	public boolean equals(Object o) {
		if (o == null || !(o instanceof ComponentTypeDTO)) {
			return false;
		}
		ComponentTypeDTO other = (ComponentTypeDTO) o;
		return other.getId().equals(getId());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(ComponentTypeDTO o) {
		return o.getName().compareTo(o.getName());
	}

	/**
	 * @return the reifiable
	 */
	public boolean isReifiable() {
		return reifiable;
	}

	/**
	 * @return the enumeration
	 */
	public List<String> getEnumeration() {
		return enumeration;
	}
}

/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.common.dto.core;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.m2ling.common.utils.Utils;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;

/**
 * Component type DTO object used between layers.
 * 
 * @author Bertrand Florat <bertrand@florat.net>
 */
public class ComponentTypeDTO implements Comparable<ComponentTypeDTO> {
	private final HasNameAndIdDTO vp;

	private final String id;

	private final String name;

	private final List<String> tags;

	private final String description;

	private final String comment;

	private final List<ReferenceDTO> references;

	private final HasNameAndIdDTO boundType;

	private final int iFactor;

	private final Set<HasNameAndIdDTO> enumeration;

	private final String status;

	public static class Builder {
		// Required configuration
		private final String name;

		private final String id;

		private final HasNameAndIdDTO vp;

		// Optional configuration
		private List<String> tags = new ArrayList<String>(1);

		private String description = null;

		private String comment = null;

		private List<ReferenceDTO> references = new ArrayList<ReferenceDTO>(1);

		private HasNameAndIdDTO boundType;

		private int iFactor = 0;

		private String status = null;

		private Set<HasNameAndIdDTO> enumeration = new LinkedHashSet<HasNameAndIdDTO>(1);

		public Builder(HasNameAndIdDTO vp, String id, String name) {
			this.id = id;
			this.vp = vp;
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

		public Builder addReference(ReferenceDTO reference) {
			this.references.add(reference);
			return this;
		}

		public Builder boundType(HasNameAndIdDTO boundType) {
			this.boundType = boundType;
			return this;
		}

		public Builder instantiationFactor(int iFactor) {
			this.iFactor = iFactor;
			return this;
		}

		public Builder status(String status) {
			this.status = status;
			return this;
		}

		/**
		 * Add component IDs to the enumeration.
		 * 
		 * @param componentIDs
		 * @return the builder
		 */
		public Builder addEnumeration(HasNameAndIdDTO component) {
			this.enumeration.add(component);
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
		vp = builder.vp;
		tags = ImmutableList.copyOf(builder.tags); // defensive copy
		description = builder.description;
		comment = builder.comment;
		references = builder.references;
		boundType = builder.boundType;
		iFactor = builder.iFactor;
		enumeration = ImmutableSet.copyOf(builder.enumeration);
		status = builder.status;
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
	public HasNameAndIdDTO getViewPoint() {
		return vp;
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

	public HasNameAndIdDTO getBoundType() {
		return boundType;
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

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @return the enumeration
	 */
	public Set<HasNameAndIdDTO> getEnumeration() {
		return enumeration;
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
		return name.compareToIgnoreCase(o.getName());
	}
}

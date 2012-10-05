/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.common.dto.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.m2ling.common.utils.Utils;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;

/**
 * Link type DTO object used between layers.
 * 
 * @author Bertrand Florat <bertrand@florat.net>
 */
public class LinkTypeDTO implements Comparable<LinkTypeDTO> {
	private final HasNameAndIdDTO vp;

	private final String id;

	private final String name;

	private final List<String> tags;

	private final String description;

	private final String comment;

	private final Set<HasNameAndIdDTO> sourcesTypes;

	private final Set<HasNameAndIdDTO> destinationsTypes;

	private String linkTemporality;

	private String linkAccessType;

	public static class Builder {
		// Required configuration
		private final String name;

		private final String id;

		private final HasNameAndIdDTO vp;

		// Optional configuration
		private List<String> tags = new ArrayList<String>(1);

		private String description = null;

		private String comment = null;

		private String linkTemporality;

		private String linkAccessType;

		private List<HasNameAndIdDTO> sourcesTypes = new ArrayList<HasNameAndIdDTO>(1);

		private List<HasNameAndIdDTO> destinationsTypes = new ArrayList<HasNameAndIdDTO>(1);

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

		public Builder linkTemporality(String linkTemporality) {
			this.linkTemporality = linkTemporality;
			return this;
		}

		public Builder linkAccessType(String linkAccessType) {
			this.linkAccessType = linkAccessType;
			return this;
		}

		public Builder addSourcesType(HasNameAndIdDTO sourcesType) {
			this.sourcesTypes.add(sourcesType);
			return this;
		}

		public Builder addDestinationsType(HasNameAndIdDTO destinationsType) {
			this.destinationsTypes.add(destinationsType);
			return this;
		}

		public LinkTypeDTO build() {
			LinkTypeDTO dto = new LinkTypeDTO(this);
			return dto;
		}
	}

	private LinkTypeDTO(Builder builder) {
		id = builder.id;
		name = builder.name;
		vp = builder.vp;
		tags = ImmutableList.copyOf(builder.tags); // defensive copy
		description = builder.description;
		comment = builder.comment;
		linkAccessType = builder.linkAccessType;
		linkTemporality = builder.linkTemporality;
		sourcesTypes = ImmutableSet.copyOf(builder.sourcesTypes);
		destinationsTypes = ImmutableSet.copyOf(builder.destinationsTypes);
	}

	public String toString() {
		return Utils.toString(this);
	}

	public boolean equals(Object o) {
		if (o == null || !(o instanceof LinkTypeDTO)) {
			return false;
		}
		LinkTypeDTO other = (LinkTypeDTO) o;
		return other.getId().equals(getId());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(LinkTypeDTO o) {
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

	/**
	 * @return the sourcesTypes
	 */
	public Set<HasNameAndIdDTO> getSourcesTypes() {
		return sourcesTypes;
	}

	/**
	 * @return the destinationsTypes
	 */
	public Set<HasNameAndIdDTO> getDestinationsTypes() {
		return destinationsTypes;
	}

	/**
	 * @return the temporality
	 */
	public String getLinkTemporality() {
		return linkTemporality;
	}

	/**
	 * @param linkTemporality
	 *           the temporality to set
	 */
	public void setLinkTemporality(String linkTemporality) {
		this.linkTemporality = linkTemporality;
	}

	/**
	 * @return the linkAccessTypeType
	 */
	public String getLinkAccessType() {
		return linkAccessType;
	}

	/**
	 * @param linkAccessType
	 *           the linkAccessType to set
	 */
	public void setLinkAccessType(String linkAccessType) {
		this.linkAccessType = linkAccessType;
	}
}

/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.common.dto.core;

import java.util.LinkedHashSet;
import java.util.Set;

import com.google.common.collect.ImmutableSet;

/**
 * Link type DTO object used between layers.
 * 
 * @author Bertrand Florat <bertrand@florat.net>
 */
public final class LinkTypeDTO extends AbstractCommonDTO implements Comparable<LinkTypeDTO> {
	private final HasNameAndIdDTO vp;

	private final Set<HasNameAndIdDTO> sourcesTypes;

	private final Set<HasNameAndIdDTO> destinationsTypes;

	private String linkTemporality;

	private String linkAccessType;

	public static class Builder extends AbstractCommonDTO.Builder {
		// Required configuration
		private final HasNameAndIdDTO vp;

		// Optional configuration
		private String linkTemporality;

		private String linkAccessType;

		private Set<HasNameAndIdDTO> sourcesTypes = new LinkedHashSet<HasNameAndIdDTO>(1);

		private Set<HasNameAndIdDTO> destinationsTypes = new LinkedHashSet<HasNameAndIdDTO>(1);

		public Builder(HasNameAndIdDTO vp, String id, String name) {
			super(id, name);
			this.vp = vp;
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
		super(builder);
		vp = builder.vp;
		linkAccessType = builder.linkAccessType;
		linkTemporality = builder.linkTemporality;
		sourcesTypes = ImmutableSet.copyOf(builder.sourcesTypes);
		destinationsTypes = ImmutableSet.copyOf(builder.destinationsTypes);
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
		return getName().compareToIgnoreCase(o.getName());
	}

	/**
	 * @return the associated viewpoint id
	 */
	public HasNameAndIdDTO getViewPoint() {
		return vp;
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
	 * @return the linkAccessTypeType
	 */
	public String getLinkAccessType() {
		return linkAccessType;
	}
}

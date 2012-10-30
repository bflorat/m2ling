/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.common.dto.core;

import java.util.Set;

/**
 * Link instance DTO object used between layers.
 * 
 * @author Bertrand Florat <bertrand@florat.net>
 */
public final class LinkInstanceDTO extends AbstractCommonDTO implements Comparable<LinkInstanceDTO> {
	private final HasNameAndIdDTO link;

	private final Set<HasNameAndIdDTO> sources;

	private final Set<HasNameAndIdDTO> destinations;

	public static class Builder extends AbstractCommonDTO.Builder {
		// Optional configuration
		private HasNameAndIdDTO link;

		private Set<HasNameAndIdDTO> sources;

		private Set<HasNameAndIdDTO> destinations;

		public Builder(String id, String name) {
			super(id, name);
		}

		public Builder link(HasNameAndIdDTO link) {
			this.link = link;
			return this;
		}

		public Builder addSource(HasNameAndIdDTO comp) {
			this.sources.add(comp);
			return this;
		}

		public Builder addDestination(HasNameAndIdDTO comp) {
			this.destinations.add(comp);
			return this;
		}

		public LinkInstanceDTO build() {
			LinkInstanceDTO dto = new LinkInstanceDTO(this);
			return dto;
		}
	}

	private LinkInstanceDTO(Builder builder) {
		super(builder);
		sources = builder.sources;
		destinations = builder.destinations;
		link = builder.link;
	}

	public boolean equals(Object o) {
		if (o == null || !(o instanceof LinkInstanceDTO)) {
			return false;
		}
		LinkInstanceDTO other = (LinkInstanceDTO) o;
		return other.getId().equals(getId());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(LinkInstanceDTO o) {
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
		return getName().compareTo(o.getName());
	}

	/**
	 * @return the associated component
	 */
	public HasNameAndIdDTO getLink() {
		return link;
	}

	/**
	 * @return the sources
	 */
	public Set<HasNameAndIdDTO> getSources() {
		return sources;
	}

	/**
	 * @return the destinations
	 */
	public Set<HasNameAndIdDTO> getDestinations() {
		return destinations;
	}
}

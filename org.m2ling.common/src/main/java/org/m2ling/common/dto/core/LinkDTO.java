/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.common.dto.core;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Link DTO object used between layers.
 * 
 * @author Bertrand Florat <bertrand@florat.net>
 */
public class LinkDTO extends AbstractCommonDTO implements Comparable<LinkDTO> {
	private final String status;

	private final int timeout;

	private final HasNameAndIdDTO type;

	private final Set<ComponentDTO> sources;

	private final Set<ComponentDTO> destinations;

	public static class Builder extends AbstractCommonDTO.Builder {
		// Optional configuration
		private String status;

		private int timeout = -1;

		private HasNameAndIdDTO type;

		private Set<ComponentDTO> sources = new LinkedHashSet<ComponentDTO>();

		private Set<ComponentDTO> destinations = new LinkedHashSet<ComponentDTO>();

		public Builder(String id, String name) {
			super(id, name);
		}

		public Builder addSource(ComponentDTO comp) {
			this.sources.add(comp);
			return this;
		}

		public Builder addDestination(ComponentDTO comp) {
			this.destinations.add(comp);
			return this;
		}

		public Builder status(String status) {
			this.status = status;
			return this;
		}

		public Builder timeout(int timeout) {
			this.timeout = timeout;
			return this;
		}

		public Builder type(HasNameAndIdDTO type) {
			this.type = type;
			return this;
		}

		public LinkDTO build() {
			LinkDTO dto = new LinkDTO(this);
			return dto;
		}
	}

	private LinkDTO(Builder builder) {
		super(builder);
		status = builder.status;
		type = builder.type;
		timeout = builder.timeout;
		sources = builder.sources;
		destinations = builder.destinations;
	}

	public boolean equals(Object o) {
		if (o == null || !(o instanceof LinkDTO)) {
			return false;
		}
		LinkDTO other = (LinkDTO) o;
		return other.getId().equals(getId());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(LinkDTO o) {
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
	 * @return the sources
	 */
	public Set<ComponentDTO> getSources() {
		return sources;
	}

	/**
	 * @return the destinations
	 */
	public Set<ComponentDTO> getDestinations() {
		return destinations;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @return the type
	 */
	public HasNameAndIdDTO getComponentType() {
		return type;
	}

	/**
	 * @return the timeout
	 */
	public int getTimeout() {
		return timeout;
	}
}

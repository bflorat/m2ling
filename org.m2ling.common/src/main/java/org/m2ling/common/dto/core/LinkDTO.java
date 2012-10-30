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
public final class LinkDTO extends AbstractCommonDTO implements Comparable<LinkDTO> {
	private final long timeoutMillis;

	private final HasNameAndIdDTO type;

	private final Set<HasNameAndIdDTO> sources;

	private final Set<HasNameAndIdDTO> destinations;

	public static class Builder extends AbstractCommonDTO.Builder {
		// Optional configuration
		private long timeoutMillis = -1;

		private HasNameAndIdDTO type;

		private Set<HasNameAndIdDTO> sources = new LinkedHashSet<HasNameAndIdDTO>();

		private Set<HasNameAndIdDTO> destinations = new LinkedHashSet<HasNameAndIdDTO>();

		public Builder(String id, String name) {
			super(id, name);
		}

		public Builder addSource(HasNameAndIdDTO comp) {
			this.sources.add(comp);
			return this;
		}

		public Builder addDestination(HasNameAndIdDTO comp) {
			this.destinations.add(comp);
			return this;
		}

		public Builder timeoutMillis(long timeoutMillis) {
			this.timeoutMillis = timeoutMillis;
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
		type = builder.type;
		timeoutMillis = builder.timeoutMillis;
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
	public Set<HasNameAndIdDTO> getSources() {
		return sources;
	}

	/**
	 * @return the destinations
	 */
	public Set<HasNameAndIdDTO> getDestinations() {
		return destinations;
	}

	/**
	 * @return the type
	 */
	public HasNameAndIdDTO getLinkType() {
		return type;
	}

	/**
	 * @return the timeout
	 */
	public long getTimeoutMillis() {
		return timeoutMillis;
	}
}

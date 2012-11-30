/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.common.dto.core;


/**
 * Link instance DTO object used between layers.
 * 
 * @author Bertrand Florat <bertrand@florat.net>
 */
public final class LinkInstanceDTO extends AbstractCommonDTO implements Comparable<LinkInstanceDTO> {
	private final HasNameAndIdDTO link;

	private final HasNameAndIdDTO source;

	private final HasNameAndIdDTO destination;
	
	private final HasNameAndIdDTO view;

	public static class Builder extends AbstractCommonDTO.Builder {
	// Mandatory items
			private HasNameAndIdDTO view;
			
		// Optional configuration
		private HasNameAndIdDTO link;

		private HasNameAndIdDTO source;

		private HasNameAndIdDTO destination;

		public Builder(String id, String name, HasNameAndIdDTO view) {
			super(id, name);
			this.view= view;
		}

		public Builder link(HasNameAndIdDTO link) {
			this.link = link;
			return this;
		}

		public Builder source(HasNameAndIdDTO comp) {
			this.source = comp;
			return this;
		}

		public Builder destination(HasNameAndIdDTO comp) {
			this.destination = comp;
			return this;
		}

		public LinkInstanceDTO build() {
			LinkInstanceDTO dto = new LinkInstanceDTO(this);
			return dto;
		}
	}

	private LinkInstanceDTO(Builder builder) {
		super(builder);
		source = builder.source;
		destination = builder.destination;
		link = builder.link;
		view = builder.view;
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
	 * @return the source
	 */
	public HasNameAndIdDTO getSource() {
		return source;
	}

	/**
	 * @return the destination
	 */
	public HasNameAndIdDTO getDestination() {
		return destination;
	}
	
	/**
	 * @return the view DTO
	 */
	public HasNameAndIdDTO getView() {
		return view;
	}
}

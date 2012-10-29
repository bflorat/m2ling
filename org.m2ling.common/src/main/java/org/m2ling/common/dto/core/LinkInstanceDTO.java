/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.common.dto.core;

import java.util.ArrayList;
import java.util.List;

/**
 * Link instance DTO object used between layers.
 * 
 * @author Bertrand Florat <bertrand@florat.net>
 */
public class LinkInstanceDTO extends AbstractCommonDTO implements Comparable<LinkInstanceDTO> {
	private final String status;

	private final ComponentDTO component;

	private final LinkInstanceDTO boundInstance;

	private final List<ReferenceDTO> references;

	public static class Builder extends AbstractCommonDTO.Builder {
		// Optional configuration
		private String status;

		private ComponentDTO component;

		private List<ReferenceDTO> references = new ArrayList<ReferenceDTO>(1);

		private LinkInstanceDTO boundInstance;

		public Builder(String id, String name) {
			super(id, name);
		}

		public Builder status(String status) {
			this.status = status;
			return this;
		}

		public Builder component(ComponentDTO component) {
			this.component = component;
			return this;
		}

		public Builder boundInstance(LinkInstanceDTO boundInstance) {
			this.boundInstance = boundInstance;
			return this;
		}

		public Builder addReference(ReferenceDTO reference) {
			this.references.add(reference);
			return this;
		}

		public LinkInstanceDTO build() {
			LinkInstanceDTO dto = new LinkInstanceDTO(this);
			return dto;
		}
	}

	private LinkInstanceDTO(Builder builder) {
		super(builder);
		status = builder.status;
		references = builder.references;
		component = builder.component;
		boundInstance = builder.boundInstance;
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
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @return the associated component
	 */
	public ComponentDTO getComponent() {
		return component;
	}

	/**
	 * @return the references
	 */
	public List<ReferenceDTO> getReferences() {
		return references;
	}

	/**
	 * @return the bound instance
	 */
	public LinkInstanceDTO getBoundInstance() {
		return boundInstance;
	}
}

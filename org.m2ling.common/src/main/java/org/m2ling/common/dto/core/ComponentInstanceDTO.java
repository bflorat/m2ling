/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.common.dto.core;

import java.util.ArrayList;
import java.util.List;

/**
 * Component instance DTO object used between layers.
 * 
 * @author Bertrand Florat <bertrand@florat.net>
 */
public final class ComponentInstanceDTO extends AbstractCommonDTO implements Comparable<ComponentInstanceDTO> {
	private final HasNameAndIdDTO component;

	private final HasNameAndIdDTO boundInstance;

	private final List<ReferenceDTO> references;

	private final HasNameAndIdDTO view;

	public static class Builder extends AbstractCommonDTO.Builder {
		private HasNameAndIdDTO view;

		private HasNameAndIdDTO component;

		private List<ReferenceDTO> references = new ArrayList<ReferenceDTO>(1);

		private HasNameAndIdDTO boundInstance;

		public Builder(String id, String name, HasNameAndIdDTO view) {
			super(id, name);
			this.view = view;
		}

		public Builder component(HasNameAndIdDTO component) {
			this.component = component;
			return this;
		}

		public Builder boundInstance(HasNameAndIdDTO boundInstance) {
			this.boundInstance = boundInstance;
			return this;
		}

		public Builder addReference(ReferenceDTO reference) {
			this.references.add(reference);
			return this;
		}

		public ComponentInstanceDTO build() {
			ComponentInstanceDTO dto = new ComponentInstanceDTO(this);
			return dto;
		}
	}

	private ComponentInstanceDTO(Builder builder) {
		super(builder);
		references = builder.references;
		component = builder.component;
		boundInstance = builder.boundInstance;
		view = builder.view;
	}

	public boolean equals(Object o) {
		if (o == null || !(o instanceof ComponentInstanceDTO)) {
			return false;
		}
		ComponentInstanceDTO other = (ComponentInstanceDTO) o;
		return other.getId().equals(getId());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(ComponentInstanceDTO o) {
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
	public HasNameAndIdDTO getComponent() {
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
	public HasNameAndIdDTO getBoundInstance() {
		return boundInstance;
	}

	/**
	 * @return the view DTO
	 */
	public HasNameAndIdDTO getView() {
		return view;
	}
}

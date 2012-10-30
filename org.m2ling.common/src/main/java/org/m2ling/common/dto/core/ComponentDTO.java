/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.common.dto.core;

import java.util.ArrayList;
import java.util.List;

/**
 * Component DTO object used between layers.
 * 
 * @author Bertrand Florat <bertrand@florat.net>
 */
public final class ComponentDTO extends AbstractCommonDTO implements Comparable<ComponentDTO> {
	private final HasNameAndIdDTO type;

	private final List<ReferenceDTO> references;

	private final ComponentDTO boundComponent;

	public static class Builder extends AbstractCommonDTO.Builder {
		private HasNameAndIdDTO type;

		private List<ReferenceDTO> references = new ArrayList<ReferenceDTO>(1);

		private ComponentDTO boundComponent;

		public Builder(String id, String name) {
			super(id, name);
		}

		public Builder boundType(ComponentDTO boundComponent) {
			this.boundComponent = boundComponent;
			return this;
		}

		public Builder type(HasNameAndIdDTO type) {
			this.type = type;
			return this;
		}

		public Builder addReference(ReferenceDTO reference) {
			this.references.add(reference);
			return this;
		}

		public ComponentDTO build() {
			ComponentDTO dto = new ComponentDTO(this);
			return dto;
		}
	}

	private ComponentDTO(Builder builder) {
		super(builder);
		references = builder.references;
		type = builder.type;
		boundComponent = builder.boundComponent;
	}

	public boolean equals(Object o) {
		if (o == null || !(o instanceof ComponentDTO)) {
			return false;
		}
		ComponentDTO other = (ComponentDTO) o;
		return other.getId().equals(getId());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(ComponentDTO o) {
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
	 * @return the type
	 */
	public HasNameAndIdDTO getType() {
		return type;
	}

	/**
	 * @return the boundComponent
	 */
	public ComponentDTO getBoundComponent() {
		return boundComponent;
	}

	/**
	 * @return the type
	 */
	public HasNameAndIdDTO getComponentType() {
		return type;
	}

	/**
	 * @return the references
	 */
	public List<ReferenceDTO> getReferences() {
		return references;
	}
}

/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.common.dto.core;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Component group DTO object used between layers.
 * 
 * @author Bertrand Florat <bertrand@florat.net>
 */
public final class ComponentGroupDTO extends AbstractCommonDTO implements Comparable<ComponentGroupDTO> {
	private final Set<ComponentDTO> components;

	public static class Builder extends AbstractCommonDTO.Builder {
		private Set<ComponentDTO> components = new LinkedHashSet<ComponentDTO>(2);

		public Builder(String id, String name) {
			super(id, name);
		}

		public Builder addComponent(ComponentDTO component) {
			this.components.add(component);
			return this;
		}

		public ComponentGroupDTO build() {
			ComponentGroupDTO dto = new ComponentGroupDTO(this);
			return dto;
		}
	}

	private ComponentGroupDTO(Builder builder) {
		super(builder);
		components = builder.components;
	}

	public boolean equals(Object o) {
		if (o == null || !(o instanceof ComponentGroupDTO)) {
			return false;
		}
		ComponentGroupDTO other = (ComponentGroupDTO) o;
		return other.getId().equals(getId());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(ComponentGroupDTO o) {
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
	 * @return the components
	 */
	public Set<ComponentDTO> getComponents() {
		return components;
	}
}

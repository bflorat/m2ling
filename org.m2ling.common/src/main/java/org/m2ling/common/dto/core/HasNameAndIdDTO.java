/**
 * Copyright (C) 2012 Bertrand Florat
 *
 * @author "Bertrand Florat <bertrand@florat.net>"
 */
package org.m2ling.common.dto.core;

import org.m2ling.common.utils.Utils;

/**
 * Inter-layer HasNameAndId communication object
 */
public final class HasNameAndIdDTO implements Comparable<HasNameAndIdDTO> {
	private final String id;

	private final String name;

	private HasNameAndIdDTO(Builder builder) {
		super();
		id = builder.id;
		name = builder.name;
	}

	@Override
	public int compareTo(HasNameAndIdDTO other) {
		if (other == null) {
			return 1;
		}
		if (getName() == null && other.getName() == null) {
			return 0;
		}
		if (other.getName() == null) {
			return 1;
		}
		if (getName() == null) {
			return -1;
		}
		return getName().compareTo(other.getName());
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	public static class Builder {
		private final String id;

		private final String name;

		public Builder(final String id, final String name) {
			this.id = id;
			this.name = name;
		}

		public HasNameAndIdDTO build() {
			HasNameAndIdDTO dto = new HasNameAndIdDTO(this);
			return dto;
		}
	}

	public String toString() {
		return Utils.toString(this);
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof HasNameAndIdDTO)) {
			return false;
		}
		return id.equals(((HasNameAndIdDTO) other).getId());
	}
}

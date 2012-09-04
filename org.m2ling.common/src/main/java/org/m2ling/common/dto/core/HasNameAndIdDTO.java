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
public class HasNameAndIdDTO {
	private final String id;
	private final String name;

	private HasNameAndIdDTO(Builder builder) {
		super();
		id = builder.id;
		name = builder.name;
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
}

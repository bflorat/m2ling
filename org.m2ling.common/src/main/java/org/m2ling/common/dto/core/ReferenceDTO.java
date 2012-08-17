/**
 * Copyright (C) 2012 Bertrand Florat
 *
 * @author "Bertrand Florat <bertrand@florat.net>"
 */
package org.m2ling.common.dto.core;

import java.util.List;

import org.m2ling.common.utils.Utils;

import com.google.common.collect.ImmutableList;

/**
 * Inter-layer reference communication object
 */
public class ReferenceDTO {
	/** Reference type literal, one of ReferenceType enum entry */
	private final String type;
	/** References list of ids */
	private final List<String> targets;

	private ReferenceDTO(Builder builder) {
		super();
		type = builder.type;
		targets = builder.targets;
	}

	public String getType() {
		return this.type;
	}

	public List<String> getTargets() {
		return this.targets;
	}

	public static class Builder {
		private final String type;
		private List<String> targets;

		public Builder(String type) {
			this.type = type;
			targets = ImmutableList.of();
		}

		public Builder addTarget(String id) {
			targets.add(id);
			return this;
		}

		public ReferenceDTO build() {
			ReferenceDTO dto = new ReferenceDTO(this);
			return dto;
		}
	}

	public String toString() {
		return Utils.toString(this);
	}
}

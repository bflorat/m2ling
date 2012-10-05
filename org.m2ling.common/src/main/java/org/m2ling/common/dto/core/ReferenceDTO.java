/**
 * Copyright (C) 2012 Bertrand Florat
 *
 * @author "Bertrand Florat <bertrand@florat.net>"
 */
package org.m2ling.common.dto.core;

import java.util.LinkedHashSet;
import java.util.Set;

import org.m2ling.common.utils.Utils;

import com.google.common.collect.ImmutableSet;

/**
 * Inter-layer reference communication object
 */
public class ReferenceDTO {
	/** Reference type literal, one of ReferenceType enum entry */
	private final String type;
	/** References list of ids */
	private final Set<HasNameAndIdDTO> targets;

	private ReferenceDTO(Builder builder) {
		super();
		type = builder.type;
		targets = ImmutableSet.copyOf(builder.targets);
	}

	public String getType() {
		return this.type;
	}

	public Set<HasNameAndIdDTO> getTargets() {
		return this.targets;
	}

	public static class Builder {
		private final String type;
		private Set<HasNameAndIdDTO> targets;

		public Builder(String type) {
			this.type = type;
			targets = new LinkedHashSet<HasNameAndIdDTO>(1);
		}

		public Builder addTarget(HasNameAndIdDTO hni) {
			targets.add(hni);
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

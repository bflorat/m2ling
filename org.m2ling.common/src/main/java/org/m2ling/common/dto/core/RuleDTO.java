/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.common.dto.core;

import java.util.LinkedHashSet;
import java.util.Set;

import org.m2ling.common.utils.Utils;

/**
 * Rule DTO object used between layers.
 * 
 * @author Bertrand Florat <bertrand@florat.net>
 */
public final class RuleDTO extends AbstractCommonDTO implements Comparable<RuleDTO> {
	private final String vpID;

	private final int priority;

	private final String rationale;

	private final String exceptions;

	private final Set<StatusEventDTO> history;

	public static class Builder extends AbstractCommonDTO.Builder {
		// Required configuration
		private final String vpID;

		// Optional configuration
		private int priority = 0;

		private String rationale = null;

		private String exceptions = null;

		private Set<StatusEventDTO> history = new LinkedHashSet<StatusEventDTO>(1);

		public Builder(String vpID, String id, String name) {
			super(id, name);
			this.vpID = vpID;
		}

		public Builder addEvent(StatusEventDTO event) {
			this.history.add(event);
			return this;
		}

		public Builder rationale(String rationale) {
			this.rationale = rationale;
			return this;
		}

		public Builder exceptions(String exceptions) {
			this.exceptions = exceptions;
			return this;
		}

		public Builder priority(int priority) {
			this.priority = priority;
			return this;
		}

		public RuleDTO build() {
			RuleDTO dto = new RuleDTO(this);
			return dto;
		}
	}

	private RuleDTO(Builder builder) {
		super(builder);
		vpID = builder.vpID;
		priority = builder.priority;
		rationale = builder.rationale;
		exceptions = builder.exceptions;
		history = builder.history;
	}

	/**
	 * @return the associated viewpoint id
	 */
	public String getViewPointId() {
		return vpID;
	}

	/**
	 * @return the priority
	 */
	public int getPriority() {
		return priority;
	}

	/**
	 * @return the rationale
	 */
	public String getRationale() {
		return rationale;
	}

	/**
	 * @return the exceptions
	 */
	public String getExceptions() {
		return exceptions;
	}

	/**
	 * @return the history
	 */
	public Set<StatusEventDTO> getHistory() {
		return history;
	}

	public String toString() {
		return Utils.toString(this);
	}

	public boolean equals(Object o) {
		if (o == null || !(o instanceof RuleDTO)) {
			return false;
		}
		RuleDTO other = (RuleDTO) o;
		return other.getId().equals(getId());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(RuleDTO o) {
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
}

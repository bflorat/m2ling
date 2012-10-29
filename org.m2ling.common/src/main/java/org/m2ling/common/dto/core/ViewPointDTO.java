/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.common.dto.core;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.m2ling.common.utils.Utils;

import com.google.common.collect.ImmutableSet;

/**
 * Viewpoint DTO object used between layers.
 * 
 * @author Bertrand Florat <bertrand@florat.net>
 */
public class ViewPointDTO extends AbstractCommonDTO implements Comparable<ViewPointDTO> {
	private final Set<String> statusLiterals;

	public static class Builder extends AbstractCommonDTO.Builder {
		// Optional configuration
		private Set<String> statusLiterals = new LinkedHashSet<String>(1);

		public Builder(String id, String name) {
			super(id, name);
		}

		public Builder addStatusLiteral(String statusLiteral) {
			this.statusLiterals.add(statusLiteral);
			return this;
		}

		public ViewPointDTO build() {
			ViewPointDTO dto = new ViewPointDTO(this);
			return dto;
		}
	}

	private ViewPointDTO(Builder builder) {
		super(builder);
		statusLiterals = ImmutableSet.copyOf(builder.statusLiterals); // defensive copy
	}

	

	/**
	 * Return a defensive copy of the status literals.
	 * 
	 * @return a defensive copy of the status literals
	 */
	public Set<String> getStatusLiterals() {
		if (statusLiterals == null) {
			return null;
		}
		return ImmutableSet.copyOf(statusLiterals);
	}

	


	
	public boolean equals(Object o) {
		if (o == null || !(o instanceof ViewPointDTO)) {
			return false;
		}
		ViewPointDTO other = (ViewPointDTO) o;
		return other.getId().equals(getId());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(ViewPointDTO o) {
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

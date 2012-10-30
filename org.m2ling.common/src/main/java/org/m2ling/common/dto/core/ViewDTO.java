/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.common.dto.core;

/**
 * View DTO object used between layers.
 * 
 * @author Bertrand Florat <bertrand@florat.net>
 */
public final class ViewDTO extends AbstractCommonDTO implements Comparable<ViewDTO> {
	private final HasNameAndIdDTO vp;

	public static class Builder extends AbstractCommonDTO.Builder {
		// Required configuration
		private final HasNameAndIdDTO vp;

		public Builder(String id, String name, HasNameAndIdDTO vp) {
			super(id, name);
			this.vp = vp;
		}

		public ViewDTO build() {
			ViewDTO dto = new ViewDTO(this);
			return dto;
		}
	}

	private ViewDTO(Builder builder) {
		super(builder);
		vp = builder.vp;
	}

	public boolean equals(Object o) {
		if (o == null || !(o instanceof ViewDTO)) {
			return false;
		}
		ViewDTO other = (ViewDTO) o;
		return other.getId().equals(getId());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(ViewDTO o) {
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
	 * @return the vpID
	 */
	public HasNameAndIdDTO getViewpoint() {
		return vp;
	}
}

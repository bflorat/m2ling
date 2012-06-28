/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.common.dto.core;

import org.m2ling.common.utils.Utils;

/**
 * Status event DTO object used between layers.
 * 
 * @author Bertrand Florat <bertrand@florat.net>
 */
public class StatusEventDTO implements Comparable<StatusEventDTO> {

	private final long date;
	private final String statusLiteral;

	public static class Builder {

		// Required configuration
		private final long date;
		private final String statusLiteral;

		public Builder(long date, String statusLiteral) {
			this.date = date;
			this.statusLiteral = statusLiteral;
		}

		public StatusEventDTO build() {
			StatusEventDTO dto = new StatusEventDTO(this);
			return dto;
		}
	}

	private StatusEventDTO(Builder builder) {
		date = builder.date;
		statusLiteral = builder.statusLiteral;
	}

	/**
	 * @return the date
	 */
	public long getDate() {
		return date;
	}

	/**
	 * @return the status literal
	 */
	public String getStatusLiteral() {
		return statusLiteral;
	}

	public String toString() {
		return Utils.toString(this);
	}

	public boolean equals(Object o) {
		if (o == null || !(o instanceof StatusEventDTO)) {
			return false;
		}
		StatusEventDTO other = (StatusEventDTO) o;
		return other.getStatusLiteral().equals(getStatusLiteral()) && other.getDate() == getDate();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(StatusEventDTO o) {
		return (int) (o.getDate() - o.getDate());
	}

}

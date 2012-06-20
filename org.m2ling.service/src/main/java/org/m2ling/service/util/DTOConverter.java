/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.service.util;

import org.m2ling.common.dto.core.ViewPointDTO;
import org.m2ling.domain.core.CoreFactory;
import org.m2ling.domain.core.ViewPoint;

import com.google.common.base.Strings;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * 
 * Convert domain classes from and to DTO associated classes.
 * 
 * @author Bertrand Florat <bertrand@florat.net>
 * 
 */
public class DTOConverter {

	private DTOConverter() {
		// Utility class, no instantiation
	}

	/**
	 * Set of utility methods to get DTO objects from model objects.
	 * 
	 * @author Bertrand Florat <bertrand@florat.net>
	 * 
	 */
	@Singleton
	public static class ToDTO {

		CoreUtil util;

		@Inject
		public ToDTO(CoreUtil util) {
			super();
			this.util = util;
		}

		public ViewPointDTO getViewPointDTO(ViewPoint vp) {
			ViewPointDTO.Builder builder = new ViewPointDTO.Builder(vp.getId(), vp.getName());
			builder.tags(vp.getTags());
			builder.comment(vp.getComment());
			builder.statusLiterals(vp.getStatusLiterals());
			builder.description(vp.getDescription());
			return builder.build();
		}
	}

	/**
	 * Set of utility methods to get model objects from DTO instances.
	 * 
	 * @author Bertrand Florat <bertrand@florat.net>
	 * 
	 */
	@Singleton
	public static class FromDTO {

		CoreUtil util;

		@Inject
		public FromDTO(CoreUtil util) {
			super();
			this.util = util;
		}

		/**
		 * Return a new ViewPoint instance given a DTO.
		 * 
		 * @param dto
		 *           the dto
		 * @return a new ViewPoint instance
		 */
		public ViewPoint newViewPoint(ViewPointDTO dto) {
			ViewPoint vp = CoreFactory.eINSTANCE.createViewPoint();
			vp.setId(dto.getId());
			vp.setName(dto.getName());
			for (String tag : dto.getTags()) {
				if (!Strings.isNullOrEmpty(tag)) {
					vp.getTags().add(tag);
				}
			}
			for (String status : dto.getStatusLiterals()) {
				if (!Strings.isNullOrEmpty(status)) {
					vp.getStatusLiterals().add(status);
				}
			}
			if (dto.getDescription() != null) {
				vp.setDescription(dto.getDescription());
			}
			vp.setComment(dto.getComment());
			return vp;
		}

		/**
		 * Return a new ViewPoint instance given a DTO or an already existing instance of any.
		 * 
		 * @param dto
		 *           the dto
		 * @return a new ViewPoint instance
		 */
		public ViewPoint getViewPoint(ViewPointDTO dto) {
			ViewPoint vp = util.getViewPointByName(dto.getName(), false);
			if (vp != null) {
				return vp;
			}
			return newViewPoint(dto);
		}

	}

}

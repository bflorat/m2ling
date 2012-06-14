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
		@Inject
		CoreUtil util;

		public static ViewPointDTO getViewPointDTO(ViewPoint vp) {
			ViewPointDTO.Builder builder = new ViewPointDTO.Builder(vp.getId(), vp.getName());
			builder.tags(vp.getTags());
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

		@Inject
		CoreUtil util;

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
			if (dto.getTags() != null) {
				for (String tag : dto.getTags()) {
					if (!Strings.isNullOrEmpty(tag)) {
						vp.getTags().add(tag);
					}
				}
			}
			if (dto.getDescription() != null) {
				vp.setDescription(dto.getDescription());
			}
			// TODO add missing setters

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

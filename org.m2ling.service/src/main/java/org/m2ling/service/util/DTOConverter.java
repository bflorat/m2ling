/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.service.util;

import org.m2ling.common.dto.core.ViewPointDTO;
import org.m2ling.domain.core.CoreFactory;
import org.m2ling.domain.core.ViewPoint;

import com.google.common.base.Strings;

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
	public static class ToDTO {

		public static ViewPointDTO getViewPointDTO(ViewPoint vp) {
			ViewPointDTO.Builder builder = new ViewPointDTO.Builder(vp.getName());
			builder.tags(vp.getTags());
			if (vp.getBaseViewpoint() != null) {
				builder.base(vp.getBaseViewpoint().getName());
			}
			return builder.build();
		}
	}

	/**
	 * Set of utility methods to get model objects from DTO instances.
	 * 
	 * @author Bertrand Florat <bertrand@florat.net>
	 * 
	 */
	public static class FromDTO {

		/**
		 * Return a new ViewPoint instance given a DTO.
		 * 
		 * @param dto
		 *           the dto
		 * @return a new ViewPoint instance
		 */
		public static ViewPoint newViewPoint(ViewPointDTO dto) {
			ViewPoint vp = CoreFactory.eINSTANCE.createViewPoint();
			vp.setName(dto.getName());
			if (dto.getBaseVPName() != null) {
				vp.setBaseViewpoint(CoreUtil.getViewPointByName(dto.getBaseVPName()));
			}
			if (dto.getTags() != null) {
				for (String tag : dto.getTags()) {
					if (!Strings.isNullOrEmpty(tag)) {
						vp.getTags().add(tag);
					}
				}
			}
			if (dto.getLabel() != null) {
				vp.setLabel(dto.getLabel());
			}
			return vp;
		}

		/**
		 * Return a new ViewPoint instance given a DTO or an already existing instance of any.
		 * 
		 * @param dto
		 *           the dto
		 * @return a new ViewPoint instance
		 */
		public static ViewPoint getViewPoint(ViewPointDTO dto) {
			ViewPoint vp = CoreUtil.getViewPointByName(dto.getName());
			if (vp != null) {
				return vp;
			}
			return newViewPoint(dto);
		}

	}

}

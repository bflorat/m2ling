/**
 * Copyright (C) Bertrand Florat
 */
package org.m2ling.service.util;

import org.m2ling.domain.core.CoreFactory;
import org.m2ling.domain.core.ViewPoint;
import org.m2ling.dto.core.ViewPointDTO;

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
			return builder.tags(vp.getTags()).base(vp.getBaseViewpoint().getName()).build();
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
			vp.setTags(dto.getTags());
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
			throw new IllegalStateException("TODO");
		}

	}

}

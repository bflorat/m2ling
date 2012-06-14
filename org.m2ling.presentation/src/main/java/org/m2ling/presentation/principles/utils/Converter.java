/**
 * Copyright (C) 2012 Bertrand Florat
 *
 * @author "Bertrand Florat <bertrand@florat.net>"
 */
package org.m2ling.presentation.principles.utils;

import java.io.File;
import java.util.List;

import org.m2ling.common.dto.core.ViewPointDTO;
import org.m2ling.common.utils.Utils;
import org.m2ling.presentation.principles.model.ViewPointBean;

/**
 * Convert from/to DTO to/from bean
 */
public class Converter {

	public static class ViewPointConverter {
		public static ViewPointDTO convertToDTO(ViewPointBean bean) {
			List<String> tags = Utils.stringListFromString(bean.getTags());
			List<String> status = Utils.stringListFromString(bean.getStatusLiterals());
			ViewPointDTO vpDTO = new ViewPointDTO.Builder(bean.getId(), bean.getName()).description(bean.getDescription())
					.tags(tags).comment(bean.getComment()).statusLiterals(status).build();
			return vpDTO;
		}

		public static ViewPointBean convertFromDTO(ViewPointDTO dto) {
			ViewPointBean bean = new ViewPointBean();
			bean.setId(dto.getId());
			if (dto.getName() != null) {
				bean.setName(dto.getName());
			} else {
				bean.setName("");
			}
			if (dto.getComment() != null) {
				bean.setComment(dto.getComment());
			} else {
				bean.setComment("");
			}
			if (dto.getDescription() != null) {
				bean.setDescription(dto.getDescription());
			} else {
				// No null value or we'll get 'null' strings in the GUI
				bean.setDescription("");
			}
			if (dto.getStatusLiterals() != null) {
				String statusLiterals = Utils.stringListAsString(dto.getStatusLiterals());
				bean.setStatusLiterals(statusLiterals);
			} else {
				bean.setStatusLiterals("");
			}
			if (dto.getTags() != null) {
				String tags = Utils.stringListAsString(dto.getTags());
				bean.setTags(tags);
			} else {
				bean.setTags("");
			}
			File icon = IconManager.getVPIconFile(bean);
			if (icon != null) {
				bean.setIconPath(icon.getAbsolutePath());
			}
			return bean;
		}
	}

}

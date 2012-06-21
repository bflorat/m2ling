/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.presentation.principles.utils;

import java.io.File;
import java.util.List;

import org.m2ling.common.dto.core.RuleDTO;
import org.m2ling.common.dto.core.ViewPointDTO;
import org.m2ling.common.utils.Utils;
import org.m2ling.presentation.principles.model.RuleBean;
import org.m2ling.presentation.principles.model.ViewPointBean;

import com.google.inject.Singleton;

/**
 * 
 * Convert presentation layer classes from and to DTO associated classes.
 * 
 * @author Bertrand Florat <bertrand@florat.net>
 * 
 */
public class DTOConverter {

	private DTOConverter() {
		// Utility class, no instantiation
	}

	/**
	 * Set of utility methods to get DTO objects from presentation objects.
	 * 
	 * @author Bertrand Florat <bertrand@florat.net>
	 * 
	 */
	@Singleton
	public static class ToDTO {

		public ViewPointDTO getViewPointDTO(ViewPointBean bean) {
			List<String> tags = Utils.stringListFromString(bean.getTags());
			List<String> status = Utils.stringListFromString(bean.getStatusLiterals());
			ViewPointDTO dto = new ViewPointDTO.Builder(bean.getId(), bean.getName()).description(bean.getDescription())
					.tags(tags).comment(bean.getComment()).statusLiterals(status).build();
			return dto;
		}

		public RuleDTO getRuleDTO(RuleBean bean) {
			List<String> tags = Utils.stringListFromString(bean.getTags());
			RuleDTO dto = new RuleDTO.Builder(bean.getId(), bean.getName()).description(bean.getDescription()).tags(tags)
					.comment(bean.getComment()).status(bean.getStatus()).priority(bean.getPriority()).build();
			return dto;
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

		/**
		 * Return a new ViewPoint instance given a DTO or an already existing instance of any.
		 * 
		 * @param dto
		 *           the dto
		 * @return a new ViewPoint instance
		 */
		public ViewPointBean getViewPointBean(ViewPointDTO dto) {
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

		/**
		 * Return a new Rule instance given a DTO or an already existing instance of any.
		 * 
		 * @param dto
		 *           the dto
		 * @return a new Rule instance
		 */
		public RuleBean getRuleBean(RuleDTO dto) {
			RuleBean bean = new RuleBean();
			bean.setId(dto.getId());
			bean.setName((dto.getName() != null) ? dto.getName() : "");
			bean.setComment((dto.getComment() != null) ? dto.getComment() : "");
			bean.setDescription((dto.getDescription() != null) ? dto.getDescription() : "");
			bean.setStatus((dto.getStatus() != null) ? dto.getStatus() : "");
			bean.setPriority((dto.getPriority() != null) ? dto.getPriority() : "");
			if (dto.getTags() != null) {
				String tags = Utils.stringListAsString(dto.getTags());
				bean.setTags(tags);
			} else {
				bean.setTags("");
			}
			return bean;
		}

	}

}

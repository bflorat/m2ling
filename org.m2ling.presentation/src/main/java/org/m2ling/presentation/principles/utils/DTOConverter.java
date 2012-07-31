/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.presentation.principles.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.m2ling.common.dto.core.RuleDTO;
import org.m2ling.common.dto.core.StatusEventDTO;
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

		/**
		 * Create a Rule DTO from provided rule bean
		 * 
		 * @param bean
		 * @return a Rule DTO from provided rule bean
		 */
		public RuleDTO getRuleDTO(RuleBean bean) {
			List<StatusEventDTO> history = getRuleHistoryDTO(bean);
			List<String> tags = Utils.stringListFromString(bean.getTags());
			RuleDTO dto = new RuleDTO.Builder(bean.getViewPointId(), bean.getId(), bean.getName())
					.description(bean.getDescription()).rationale(bean.getRationale()).exceptions(bean.getExceptions())
					.tags(tags).comment(bean.getComment()).status(bean.getStatus()).priority(bean.getPriority())
					.history(history).build();
			return dto;
		}

		/**
		 * Create and populate a DTO from a given rule history. If the history is void, a void
		 * collection is returned.
		 * 
		 * @param source
		 *           history
		 * 
		 * @return Create and populate a DTO from a given rule history.
		 */
		public List<StatusEventDTO> getRuleHistoryDTO(RuleBean bean) {
			List<StatusEventDTO> out = new ArrayList<StatusEventDTO>(3);
			Map<Long, String> history = bean.getHistory();
			for (Long date : bean.getHistory().keySet()) {
				StatusEventDTO dto = new StatusEventDTO.Builder(date, history.get(date)).build();
				out.add(dto);
			}
			return out;
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
			bean.setName((dto.getName() != null) ? dto.getName() : "");
			bean.setComment((dto.getComment() != null) ? dto.getComment() : "");
			bean.setDescription((dto.getDescription() != null) ? dto.getDescription() : "");
			String statusLiterals = Utils.stringListAsString(dto.getStatusLiterals());
			bean.setStatusLiterals(statusLiterals);
			String tags = Utils.stringListAsString(dto.getTags());
			bean.setTags(tags);
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
			bean.setViewPointId(dto.getViewPointId());
			bean.setViewPointId(dto.getViewPointId());
			bean.setName((dto.getName() != null) ? dto.getName() : "");
			bean.setComment((dto.getComment() != null) ? dto.getComment() : "");
			bean.setDescription((dto.getDescription() != null) ? dto.getDescription() : "");
			bean.setRationale((dto.getRationale() != null) ? dto.getRationale() : "");
			bean.setDescription((dto.getDescription() != null) ? dto.getDescription() : "");
			bean.setExceptions((dto.getExceptions() != null) ? dto.getExceptions() : "");
			bean.setPriority((dto.getPriority() != null) ? dto.getPriority() : "");
			bean.setStatus((dto.getStatus() != null) ? dto.getStatus() : "");
			String tags = Utils.stringListAsString(dto.getTags());
			bean.setTags(tags);
			bean.setHistory(getHistoryBean(dto));
			return bean;
		}

		/**
		 * Return a time-sorted rule history map from provided DTO
		 * 
		 * @param dto
		 *           source DTO
		 * @return a time-sorted rule history map from provided DTO
		 */
		public Map<Long, String> getHistoryBean(RuleDTO dto) {
			Map<Long, String> out = new HashMap<Long, String>(dto.getHistory().size());
			for (StatusEventDTO event : dto.getHistory()) {
				out.put(event.getDate(), event.getStatusLiteral());
			}
			return out;
		}
	}
}

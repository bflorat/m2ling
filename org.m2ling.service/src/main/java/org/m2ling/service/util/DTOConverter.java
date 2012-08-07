/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.service.util;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.m2ling.common.dto.core.RuleDTO;
import org.m2ling.common.dto.core.StatusEventDTO;
import org.m2ling.common.dto.core.ViewPointDTO;
import org.m2ling.domain.core.CoreFactory;
import org.m2ling.domain.core.Rule;
import org.m2ling.domain.core.RulePriority;
import org.m2ling.domain.core.StatusEvent;
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

		public RuleDTO getRuleDTO(Rule rule) {
			ViewPoint vp = (ViewPoint) rule.eContainer();
			RuleDTO.Builder builder = new RuleDTO.Builder(vp.getId(), rule.getId(), rule.getName());
			builder.tags(rule.getTags());
			builder.comment(rule.getComment());
			builder.status(rule.getStatus());
			builder.description(rule.getDescription());
			builder.exceptions(rule.getExceptions());
			builder.priority(rule.getPriority().getLiteral());
			builder.rationale(rule.getRationale());
			List<StatusEventDTO> history = getRuleHistoryDTO(rule);
			builder.history(history);
			return builder.build();
		}

		/**
		 * Create and populate a rule history DTO from a given rule. If the history is void, a void
		 * collection is returned.
		 * 
		 * @param rule
		 *           : source rule
		 * 
		 * @return Create and populate a DTO from a given rule history.
		 */
		public List<StatusEventDTO> getRuleHistoryDTO(Rule rule) {
			List<StatusEventDTO> out = new ArrayList<StatusEventDTO>(3);
			for (StatusEvent event : rule.getHistory()) {
				StatusEventDTO dto = new StatusEventDTO.Builder(event.getDate(), event.getStatusLiteral()).build();
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
			vp.setDescription(dto.getDescription());
			vp.setComment(dto.getComment());
			return vp;
		}

		/**
		 * Return a new rule instance given a DTO.
		 * 
		 * @param dto
		 *           the dto
		 * @return a new Rule instance
		 */
		public Rule newRule(RuleDTO dto) {
			Rule rule = CoreFactory.eINSTANCE.createRule();
			rule.setId(dto.getId());
			rule.setName(dto.getName());
			for (String tag : dto.getTags()) {
				if (!Strings.isNullOrEmpty(tag)) {
					rule.getTags().add(tag);
				}
			}
			rule.setStatus(dto.getStatus());
			rule.setPriority(RulePriority.get(dto.getPriority()));
			rule.setDescription(dto.getDescription());
			rule.setComment(dto.getComment());
			rule.setRationale(dto.getRationale());
			rule.setExceptions(dto.getExceptions());
			return rule;
		}

		/**
		 * Clear and populate a rule history from given dto
		 * 
		 * @param dto
		 *           the source dto
		 * @param rule
		 *           target rule to populate
		 * @return Clear and populate a rule history from given dto
		 */
		public void populateRuleHistory(List<StatusEventDTO> dto, Rule rule) {
			EList<StatusEvent> history = rule.getHistory();
			history.clear();
			for (StatusEventDTO event : dto) {
				StatusEvent se = CoreFactory.eINSTANCE.createStatusEvent();
				se.setDate(event.getDate());
				se.setStatusLiteral(event.getStatusLiteral());
				history.add(se);
			}
		}
	}
}

/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.service.principles.impl;

import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

import org.m2ling.common.configuration.Configuration;
import org.m2ling.common.dto.core.RuleDTO;
import org.m2ling.common.dto.core.StatusEventDTO;
import org.m2ling.common.exceptions.FunctionalException;
import org.m2ling.common.exceptions.FunctionalException.Code;
import org.m2ling.common.soa.Context;
import org.m2ling.common.utils.Consts;
import org.m2ling.common.utils.Utils;
import org.m2ling.domain.Root;
import org.m2ling.domain.core.CoreFactory;
import org.m2ling.domain.core.Rule;
import org.m2ling.domain.core.RulePriority;
import org.m2ling.domain.core.StatusEvent;
import org.m2ling.domain.core.ViewPoint;
import org.m2ling.persistence.PersistenceManager;
import org.m2ling.service.common.ServiceImpl;
import org.m2ling.service.principles.RuleService;
import org.m2ling.service.util.CoreUtil;
import org.m2ling.service.util.DTOConverter;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * Nominal implementation for RulesService
 * 
 * @author "Bertrand Florat <bertrand@florat.net>"
 * 
 */
@Singleton
public class RuleServiceImpl extends ServiceImpl implements RuleService {
	/**
	 * Protected constructor to prevent direct instantiation
	 */
	@Inject
	protected RuleServiceImpl(PersistenceManager pm, CoreUtil util, DTOConverter.FromDTO fromDTO,
			DTOConverter.ToDTO toDTO, Configuration conf, Logger logger) {
		super(pm, util, fromDTO, toDTO, conf, logger);
	}

	/**
	 * Centralize all service entry verifications
	 * 
	 * @param dto
	 * @param updateOnly
	 *           : whether we update the item or not
	 * @throws FunctionalException
	 */
	private void checkDTO(final RuleDTO dto, boolean updateOnly) throws FunctionalException {
		// Nullity
		if (dto == null) {
			throw new FunctionalException(Code.NULL_ARGUMENT, "Null item provided", null, null);
		}
		if (updateOnly) {
			// item existence
			Rule rule = util.getRuleByID(dto.getId());
			if (rule == null) {
				throw new FunctionalException(FunctionalException.Code.TARGET_NOT_FOUND, "Rule not found for provided id",
						null, dto.toString());
			}
		}
		// Name
		if (dto.getName().length() == 0) {
			throw new FunctionalException(FunctionalException.Code.NULL_ARGUMENT, "Void Name", null, dto.toString());
		}
		if (dto.getName().length() > Consts.MAX_LABEL_SIZE) {
			throw new FunctionalException(FunctionalException.Code.SIZE_EXCEEDED, "Name too long", null, null);
		}
		ViewPoint vp = util.getViewPointByID(dto.getViewPointId());
		if (vp == null) {
			throw new FunctionalException(FunctionalException.Code.TARGET_NOT_FOUND,
					"A viewpoint associated with this rule cannot be found", null, dto.toString());
		}
		if (!updateOnly) {
			// Check for existing rule with the same id
			for (Rule r : vp.getRules()) {
				if (r.getId().equals(dto.getId())) {
					throw new FunctionalException(FunctionalException.Code.DUPLICATES, "Rule already exists", null,
							dto.toString());
				}
			}
			// Check for existing rule with the same name
			for (Rule r : vp.getRules()) {
				if (r.getName().equals(dto.getName())) {
					throw new FunctionalException(FunctionalException.Code.DUPLICATES,
							"A rule already exists with the same name", null, dto.toString());
				}
			}
		}
		// Status
		boolean existing = false;
		for (String status : vp.getStatusLiterals()) {
			if (dto.getStatus().equals(status)) {
				existing = true;
			}
		}
		if (!existing) {
			throw new FunctionalException(FunctionalException.Code.TARGET_NOT_FOUND,
					"Status is not from view point valid status", null, dto.toString());
		}
		// priority
		existing = false;
		for (RulePriority pr : RulePriority.values()) {
			if (dto.getPriority().equals(pr.name())) {
				existing = true;
			}
		}
		if (!existing) {
			throw new FunctionalException(FunctionalException.Code.TARGET_NOT_FOUND, "Unknown priority", null,
					dto.toString());
		}
		// Description
		if (dto.getDescription().length() > Consts.MAX_TEXT_SIZE) {
			throw new FunctionalException(FunctionalException.Code.SIZE_EXCEEDED, "Description too long", null, null);
		}
		// Comment
		if (dto.getComment().length() > Consts.MAX_TEXT_SIZE) {
			throw new FunctionalException(FunctionalException.Code.SIZE_EXCEEDED, "Comment too long", null, null);
		}
		// Tags
		Utils.checkTags(dto.getTags());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.m2ling.service.principles.RuleService#updateRule(org.m2ling.common.dto.core.RuleDTO)
	 */
	@Override
	public void updateRule(final Context context, final RuleDTO ruleDTO) throws FunctionalException {
		// Controls
		checkDTO(ruleDTO, true);
		// Processing
		Rule rule = util.getRuleByID(ruleDTO.getId());
		rule.setName(ruleDTO.getName());
		rule.setDescription(ruleDTO.getDescription());
		rule.setPriority(RulePriority.get(ruleDTO.getPriority()));
		rule.setStatus(ruleDTO.getStatus());
		rule.setComment(ruleDTO.getComment());
		rule.setExceptions(ruleDTO.getExceptions());
		rule.setRationale(ruleDTO.getRationale());
		List<String> tags = rule.getTags();
		tags.clear();
		tags.addAll(ruleDTO.getTags());
		List<StatusEvent> history = rule.getHistory();
		history.clear();
		for (StatusEventDTO event : ruleDTO.getHistory()) {
			StatusEvent se = CoreFactory.eINSTANCE.createStatusEvent();
			se.setDate(event.getDate());
			se.setStatusLiteral(event.getStatusLiteral());
			history.add(se);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.m2ling.service.principles.RuleService#createRule( org.m2ling.common.dto.core.RuleDTO)
	 */
	@Override
	public void createRule(final Context context, final RuleDTO ruleDTO) throws FunctionalException {
		// Controls
		checkDTO(ruleDTO, false);
		// Processing
		Rule rule = fromDTO.newRule(ruleDTO);
		ViewPoint vp = util.getViewPointByID(ruleDTO.getViewPointId());
		vp.getRules().add(rule);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.m2ling.service.principles.RuleService#getAllRules(String)
	 */
	@Override
	public List<RuleDTO> getAllRules(final Context context, final String vp) throws FunctionalException {
		{// Controls
			if (util.getViewPointByID(vp) == null) {
				throw new FunctionalException(Code.TARGET_NOT_FOUND, "Viewpoint doesn't exist", null, vp.toString());
			}
		}
		Root root = pmanager.getRoot();
		List<RuleDTO> out = Lists.newArrayList();
		for (ViewPoint checked : root.getViewPoints()) {
			if (checked.getId().equals(vp)) {
				List<Rule> rules = checked.getRules();
				for (Rule rule : rules) {
					List<StatusEventDTO> history = toDTO.getRuleHistoryDTO(rule);
					RuleDTO dto = new RuleDTO.Builder(checked.getId(), rule.getId(), rule.getName())
							.comment(rule.getComment()).description(rule.getDescription())
							.priority(rule.getPriority().getLiteral()).history(history).rationale(rule.getRationale())
							.exceptions(rule.getExceptions()).status(rule.getStatus()).tags(rule.getTags()).build();
					out.add(dto);
				}
				break;
			}
		}
		Collections.sort(out);
		return out;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.m2ling.service.principles.RuleService#deleteRule(org.m2ling.common.dto.core.RuleDTO)
	 */
	@Override
	public void deleteRule(final Context context, final RuleDTO ruleDTO) throws FunctionalException {
		Rule rule = null;
		{// Controls
			if (ruleDTO == null) {
				throw new FunctionalException(Code.NULL_ARGUMENT, "Null rule provied", null, null);
			}
			rule = util.getRuleByID(ruleDTO.getId());
			if (rule == null) {
				throw new FunctionalException(Code.TARGET_NOT_FOUND, "Viewpoint doesn't exist", null, ruleDTO.toString());
			}
		}
		ViewPoint vp = (ViewPoint) rule.eContainer();
		vp.getRules().remove(rule);
	}
}

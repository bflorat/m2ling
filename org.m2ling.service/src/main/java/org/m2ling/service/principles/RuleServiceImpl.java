/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.service.principles;

import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

import org.m2ling.common.configuration.Conf;
import org.m2ling.common.dto.core.AccessType;
import org.m2ling.common.dto.core.RuleDTO;
import org.m2ling.common.exceptions.FunctionalException;
import org.m2ling.common.exceptions.FunctionalException.Code;
import org.m2ling.common.soa.Context;
import org.m2ling.common.utils.Consts;
import org.m2ling.domain.Root;
import org.m2ling.domain.core.CoreFactory;
import org.m2ling.domain.core.Rule;
import org.m2ling.domain.core.StatusEvent;
import org.m2ling.domain.core.Type;
import org.m2ling.domain.core.ViewPoint;
import org.m2ling.persistence.PersistenceManager;
import org.m2ling.service.common.ServiceImpl;
import org.m2ling.service.util.CoreUtil;
import org.m2ling.service.util.DTOConverter;

import com.google.common.base.Strings;
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
			DTOConverter.ToDTO toDTO, Conf conf, Logger logger) {
		super(pm, util, fromDTO, toDTO, conf, logger);
	}

	/**
	 * Centralize all service entry verifications
	 * 
	 * @param dto
	 * @param access
	 *           : type of access
	 * @throws FunctionalException
	 */
	void checkDTO(final RuleDTO dto, AccessType access) throws FunctionalException {
		checkIdAndName(dto, access, false);
		ViewPoint vp = util.getViewPointByID(dto.getViewPointId());
		if (vp == null) {
			throw new FunctionalException(FunctionalException.Code.TARGET_NOT_FOUND, null, "viewpoint="
					+ dto.getViewPointId());
		}
		if (access == AccessType.CREATE || access == AccessType.UPDATE) {
			checkStatus(dto.getViewPointId(), dto.getStatus());
			checkDescription(dto.getDescription(), true);
			checkRationale(dto);
			checkExceptions(dto);
			checkComment(dto.getComment());
			checkTags(dto.getTags());
		}
	}

	/**
	 * @param dto
	 * @throws FunctionalException
	 */
	private void checkExceptions(final RuleDTO dto) throws FunctionalException {
		if (dto.getExceptions() != null && dto.getExceptions().length() > Consts.MAX_TEXT_SIZE) {
			throw new FunctionalException(FunctionalException.Code.SIZE_EXCEEDED, null, "(exceptions)");
		}
	}

	/**
	 * @param dto
	 * @throws FunctionalException
	 */
	private void checkRationale(final RuleDTO dto) throws FunctionalException {
		if (dto.getRationale() == null) {
			throw new FunctionalException(FunctionalException.Code.NULL_ARGUMENT, null, "(rationale)");
		}
		if (Strings.isNullOrEmpty(dto.getRationale().trim())) {
			throw new FunctionalException(FunctionalException.Code.VOID_ARGUMENT, null, "(rationale)");
		}
		if (dto.getRationale().length() > Consts.MAX_TEXT_SIZE) {
			throw new FunctionalException(FunctionalException.Code.SIZE_EXCEEDED, null, "(rationale)");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.m2ling.service.principles.RuleService#updateRule(org.m2ling.common.dto.core.RuleDTO)
	 */
	@Override
	public void updateRule(final Context context, final RuleDTO ruleDTO) throws FunctionalException {
		// Controls
		checkDTO(ruleDTO, AccessType.UPDATE);
		// Processing
		Rule rule = util.getRuleByID(ruleDTO.getId());
		rule.setName(ruleDTO.getName());
		rule.setDescription(ruleDTO.getDescription());
		rule.setPriority(ruleDTO.getPriority());
		rule.setStatus(ruleDTO.getStatus());
		rule.setComment(ruleDTO.getComment());
		rule.setExceptions(ruleDTO.getExceptions());
		rule.setRationale(ruleDTO.getRationale());
		List<String> tags = rule.getTags();
		tags.clear();
		tags.addAll(ruleDTO.getTags());
		List<StatusEvent> history = rule.getHistory();
		StatusEvent se = CoreFactory.eINSTANCE.createStatusEvent();
		se.setDate(System.currentTimeMillis());
		se.setStatusLiteral(rule.getStatus());
		history.add(se);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.m2ling.service.principles.RuleService#createRule( org.m2ling.common.dto.core.RuleDTO)
	 */
	@Override
	public void createRule(final Context context, final RuleDTO ruleDTO) throws FunctionalException {
		// Controls
		checkDTO(ruleDTO, AccessType.CREATE);
		// Processing
		Rule rule = fromDTO.newRule(ruleDTO);
		// Set history
		List<StatusEvent> history = rule.getHistory();
		StatusEvent evt = CoreFactory.eINSTANCE.createStatusEvent();
		evt.setDate(System.currentTimeMillis());
		evt.setStatusLiteral(rule.getStatus());
		history.add(evt);
		// Add the rule
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
				throw new FunctionalException(Code.TARGET_NOT_FOUND, null, "Viewpoint=" + vp.toString());
			}
		}
		Root root = pmanager.getRoot();
		List<RuleDTO> out = Lists.newArrayList();
		for (ViewPoint checked : root.getViewPoints()) {
			if (checked.getId().equals(vp)) {
				List<Rule> rules = checked.getRules();
				for (Rule rule : rules) {
					RuleDTO dto = toDTO.getRuleDTO(rule);
					out.add(dto);
				}
				break;
			}
		}
		Collections.sort(out);
		return out;
	}

	@Override
	public void deleteRule(final Context context, final RuleDTO dto) throws FunctionalException {
		{// Controls
			checkDTO(dto, AccessType.DELETE);
		}
		Rule rule = util.getRuleByID(dto.getId());
		ViewPoint vp = (ViewPoint) rule.eContainer();
		vp.getRules().remove(rule);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.m2ling.service.common.ServiceImpl#getType()
	 */
	@Override
	protected Type getManagedType() {
		return Type.RULE;
	}
}

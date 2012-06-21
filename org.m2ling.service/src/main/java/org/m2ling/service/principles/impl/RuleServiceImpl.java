/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.service.principles.impl;

import java.util.Collections;
import java.util.List;

import org.m2ling.common.configuration.Configuration;
import org.m2ling.common.dto.core.RuleDTO;
import org.m2ling.common.dto.core.ViewPointDTO;
import org.m2ling.common.exceptions.FunctionalException;
import org.m2ling.common.exceptions.FunctionalException.Code;
import org.m2ling.domain.Root;
import org.m2ling.domain.core.Rule;
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
			DTOConverter.ToDTO toDTO, Configuration conf) {
		super();
		this.util = util;
		this.toDTO = toDTO;
		this.pmanager = pm;
		this.conf = conf;
	}

	private void checkDTO(final RuleDTO dto) throws FunctionalException {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.m2ling.service.principles.RuleService#updateRule(org.m2ling.common.dto.core.RuleDTO)
	 */
	@Override
	public void updateRule(final RuleDTO rule) throws FunctionalException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.m2ling.service.principles.RuleService#createRule(org.m2ling.common.dto.core.ViewPointDTO,
	 * org.m2ling.common.dto.core.RuleDTO)
	 */
	@Override
	public void createRule(final ViewPointDTO vp, final RuleDTO rule) throws FunctionalException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.m2ling.service.principles.RuleService#getAllRules(org.m2ling.common.dto.core.ViewPointDTO)
	 */
	@Override
	public List<RuleDTO> getAllRules(final ViewPointDTO vp) throws FunctionalException {
		{// Controls
			if (util.getViewPointByID(vp.getId()) == null) {
				throw new FunctionalException(Code.TARGET_NOT_FOUND, "Viewpoint doesn't exist", null, vp.toString());
			}
		}
		Root root = pmanager.getRoot();
		List<RuleDTO> out = Lists.newArrayList();
		for (ViewPoint checked : root.getViewPoints()) {
			if (checked.getId().equals(vp.getId())) {
				List<Rule> rules = checked.getRules();
				for (Rule rule : rules) {
					RuleDTO dto = new RuleDTO.Builder(rule.getId(), rule.getName()).comment(rule.getComment())
							.description(rule.getDescription()).priority(rule.getPriority().getLiteral())
							.status(rule.getStatus()).tags(rule.getTags()).build();
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
	public void deleteRule(final RuleDTO rule) throws FunctionalException {
		// TODO Auto-generated method stub

	}

}

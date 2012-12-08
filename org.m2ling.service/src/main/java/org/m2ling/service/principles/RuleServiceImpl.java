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
import org.m2ling.domain.Root;
import org.m2ling.domain.core.CoreFactory;
import org.m2ling.domain.core.Rule;
import org.m2ling.domain.core.StatusEvent;
import org.m2ling.domain.core.ViewPoint;
import org.m2ling.persistence.PersistenceManager;
import org.m2ling.service.common.ServiceImpl;
import org.m2ling.service.util.DomainExplorer;
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
	private RuleServiceChecker checker;

	/**
	 * Protected constructor to prevent direct instantiation
	 */
	@Inject
	protected RuleServiceImpl(PersistenceManager pm, DomainExplorer explorer, DTOConverter.FromDTO fromDTO,
			DTOConverter.ToDTO toDTO, Conf conf, Logger logger, RuleServiceChecker checker) {
		super(pm, explorer, fromDTO, toDTO, conf, logger);
		this.checker = checker;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateRule(final Context context, final RuleDTO ruleDTO) throws FunctionalException {
		try {
			// Controls
			checker.checkDTO(ruleDTO, AccessType.UPDATE);
			// Processing
			Rule rule = explorer.getRuleByID(ruleDTO.getId());
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
		} catch (Exception ex) {
			handleAnyException(ex);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void createRule(final Context context, final RuleDTO ruleDTO) throws FunctionalException {
		try {
			// Controls
			checker.checkDTO(ruleDTO, AccessType.CREATE);
			// Processing
			Rule rule = fromDTO.newRule(ruleDTO);
			// Set history
			List<StatusEvent> history = rule.getHistory();
			StatusEvent evt = CoreFactory.eINSTANCE.createStatusEvent();
			evt.setDate(System.currentTimeMillis());
			evt.setStatusLiteral(rule.getStatus());
			history.add(evt);
			// Add the rule
			ViewPoint vp = explorer.getViewPointByID(ruleDTO.getViewPointId());
			vp.getRules().add(rule);
		} catch (Exception ex) {
			handleAnyException(ex);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<RuleDTO> getAllRules(final Context context, final String vp) throws FunctionalException {
		List<RuleDTO> out = Lists.newArrayList();
		try {
			// Controls
			if (explorer.getViewPointByID(vp) == null) {
				throw new FunctionalException(Code.TARGET_NOT_FOUND, null, "Viewpoint=" + vp.toString());
			}
			Root root = pmanager.getRoot();
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
		} catch (Exception ex) {
			handleAnyException(ex);
		}
		return out;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteRule(final Context context, final String id) throws FunctionalException {
		try {
			// Controls
			RuleDTO dto = new RuleDTO.Builder(null, id, null).build();
			checker.checkDTO(dto, AccessType.DELETE);
			Rule rule = explorer.getRuleByID(dto.getId());
			ViewPoint vp = (ViewPoint) rule.eContainer();
			vp.getRules().remove(rule);
		} catch (Exception ex) {
			handleAnyException(ex);
		}
	}
}

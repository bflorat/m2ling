/**
 * Copyright (C) 2012 Bertrand Florat 
 */
package org.m2ling.service.principles;

import java.util.List;

import org.m2ling.common.dto.core.RuleDTO;
import org.m2ling.common.dto.core.ViewPointDTO;
import org.m2ling.common.exceptions.FunctionalException;

/**
 * General contract for rules services implementations.
 * <p>
 * All the methods can throw a TechnicalException in case of technical issue.
 * </p>
 * <p>
 * All the methods cab throw an IllegalAccessException if current user has not the authorization to
 * access the viewpoint.
 * </p>
 */

public interface RuleService {
	/**
	 * Update an existing rule.
	 * 
	 * @param rule
	 *           the rule
	 * @throws FunctionalException
	 *            if the rule doesn't exist or if one of the rule DTO entry is faulty
	 */
	void updateRule(RuleDTO rule) throws FunctionalException;

	/**
	 * Create a new rule for provided viewpoint.
	 * 
	 * @param vp
	 *           the view point DTO
	 * @param rule
	 *           the rule
	 * @throws FunctionalException
	 *            if the viewpoint doesn't exist
	 * @throws FunctionalException
	 *            if a rule already exist with id or name or if one of the DTO entry is faulty
	 */
	void createRule(ViewPointDTO vp, RuleDTO rule) throws FunctionalException;

	/**
	 * Return all available rules given a viewpoint. If none rules is available, a void list is
	 * returned.
	 * 
	 * <p>
	 * Rules are sorted by name.
	 * </p>
	 * 
	 * 
	 * @param viewpoint
	 * @throws FunctionalException
	 *            if the viewpoint doesn't exist
	 * @return all available rules for given viewpoint
	 */
	List<RuleDTO> getAllRules(ViewPointDTO vp) throws FunctionalException;

	/**
	 * Drop the given rule if it exists.
	 * 
	 * @param rule
	 *           the view point DTO
	 * @throws FunctionalException
	 *            if the rule doesn't exist.
	 */
	void deleteRule(RuleDTO rule) throws FunctionalException;

}

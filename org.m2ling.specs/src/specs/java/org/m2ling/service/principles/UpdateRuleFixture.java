package org.m2ling.service.principles;

import java.io.IOException;
import java.util.List;

import org.m2ling.common.dto.core.RuleDTO;
import org.m2ling.common.exceptions.FunctionalException;
import org.m2ling.presentation.principles.model.RuleBean;
import org.m2ling.presentation.principles.utils.DTOConverter;

public class UpdateRuleFixture extends AbstractRuleFixture {
	public UpdateRuleFixture() throws IOException {
		super();
	}

	/**
	 * Update a Rule from a presentation layer bean (to test it too), then search it back
	 * 
	 * @param bean
	 * @param name
	 * @return
	 * @throws FunctionalException
	 */
	public String update(String id, String vpID, String name, String description, String comment, String status,
			int priority, String rationale, String exceptions, String tags) throws FunctionalException {
		reset("Technical");
		RuleBean bean = new RuleBean();
		bean.setComment(comment);
		bean.setDescription(description);
		bean.setExceptions(exceptions);
		bean.setId(id);
		bean.setName(name);
		bean.setPriority(priority);
		bean.setRationale(rationale);
		bean.setStatus(status);
		bean.setTags(tags);
		bean.setViewPointId(vpID);
		RuleDTO dto = new DTOConverter.ToDTO().getRuleDTO(bean);
		service.updateRule(null, dto);
		List<RuleDTO> rules = service.getAllRules(null, vpID);
		for (RuleDTO rule : rules) {
			if (rule.getId().equals(bean.getId())) {
				RuleBean out = new DTOConverter.FromDTO().getRuleBean(rule);
				System.out.println(out);
				// We have to omit history here because we can't compare from HTML value as the value is
				// only created on the server side
				return out.toString().replaceAll("history=\\{.*\\}", "");
			}
		}
		return "rule not found";
	}
}

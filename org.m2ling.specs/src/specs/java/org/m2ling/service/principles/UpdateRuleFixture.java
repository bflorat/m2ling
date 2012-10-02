package org.m2ling.service.principles;

import java.io.IOException;
import java.util.List;

import org.m2ling.common.dto.core.RuleDTO;
import org.m2ling.common.exceptions.FunctionalException;
import org.m2ling.common.utils.UUT;
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
	public String update(String id, String name, String description, String comment, String tags, String status,
			int priority, String rationale, String exceptions) throws FunctionalException {
		reset("Technical");
		RuleBean bean = new RuleBean();
		bean.setComment(UUT.nul(comment));
		bean.setDescription(UUT.nul(description));
		bean.setExceptions(UUT.nul(exceptions));
		bean.setId(UUT.nul(id));
		bean.setName(UUT.nul(name));
		bean.setPriority(priority);
		bean.setRationale(UUT.nul(rationale));
		bean.setStatus(status);
		bean.setTags(UUT.nul(tags));
		bean.setViewPointId("id_vp1");
		RuleDTO dto = new DTOConverter.ToDTO().getRuleDTO(bean);
		service.updateRule(null, dto);
		List<RuleDTO> rules = service.getAllRules(null, "id_vp1");
		for (RuleDTO rule : rules) {
			if (rule.getId().equals(bean.getId())) {
				RuleBean out = new DTOConverter.FromDTO().getRuleBean(rule);
				// We have to omit history here because we can't compare from HTML value as the value is
				// only created on the server side
				return out.toString().replaceAll("history=\\{.*\\}", "");
			}
		}
		return "rule not found";
	}

	public String getRule(String id) throws FunctionalException {
		RuleBean bean = new RuleBean();
		bean.setId(id);
		List<RuleDTO> rules = service.getAllRules(null, "id_vp1");
		for (RuleDTO rule : rules) {
			if (rule.getId().equals(bean.getId())) {
				RuleBean out = new DTOConverter.FromDTO().getRuleBean(rule);
				// We have to omit history here because we can't compare from HTML value as the value is
				// only created on the server side
				return out.toString().replaceAll("history=\\{.*\\}", "");
			}
		}
		return "rule not found";
	}
}

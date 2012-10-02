package org.m2ling.service.principles;

import java.io.IOException;

import org.junit.Test;
import org.m2ling.common.dto.core.RuleDTO;
import org.m2ling.common.exceptions.FunctionalException;
import org.m2ling.presentation.principles.model.RuleBean;
import org.m2ling.presentation.principles.utils.DTOConverter;

public class DeleteRuleFixture extends AbstractRuleFixture {
	public DeleteRuleFixture() throws IOException {
		super();
	}

	@Test
	public String testDeleteWrongVP() {
		try {
			reset("Technical");
			RuleBean bean = new RuleBean();
			bean.setId("id_rulex");
			bean.setViewPointId("id_vpx");
			RuleDTO dto = new DTOConverter.ToDTO().getRuleDTO(bean);
			service.deleteRule(null, dto);
			return "PASS";
		} catch (FunctionalException fe) {
			return "FAIL with code " + fe.getCode().name();
		}
	}

	@Test
	public String testDeleteNoExistingRule() {
		try {
			reset("Technical");
			RuleBean bean = new RuleBean();
			bean.setId("id_rulex");
			bean.setViewPointId("id_vp1");
			RuleDTO dto = new DTOConverter.ToDTO().getRuleDTO(bean);
			service.deleteRule(null, dto);
			return "PASS";
		} catch (FunctionalException fe) {
			return "FAIL with code " + fe.getCode().name();
		}
	}

	@Test
	public String testDeleteExistingRule() {
		try {
			reset("Technical");
			RuleBean bean = new RuleBean();
			bean.setId("id_vp1_rule1");
			bean.setViewPointId("id_vp1");
			RuleDTO dto = new DTOConverter.ToDTO().getRuleDTO(bean);
			service.deleteRule(null, dto);
			return "PASS";
		} catch (FunctionalException fe) {
			return "FAIL with code " + fe.getCode().name();
		}
	}
}

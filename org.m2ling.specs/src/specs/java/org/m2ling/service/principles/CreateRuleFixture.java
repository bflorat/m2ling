package org.m2ling.service.principles;

import java.io.IOException;

import org.m2ling.common.dto.core.AccessType;
import org.m2ling.common.dto.core.RuleDTO;
import org.m2ling.common.exceptions.FunctionalException;
import org.m2ling.presentation.principles.model.RuleBean;
import org.m2ling.presentation.principles.utils.DTOConverter;

public class CreateRuleFixture extends AbstractRuleFixture {

	public CreateRuleFixture() throws IOException {
		super();
	}

	public String getCheckDTOVerification(String caseName, String id, String name, String description, String comment,
			String tags, String statusLiterals) {
		reset("Technical");
		try {
			// TODO, add status literals
			RuleBean bean = new RuleBean();
			bean.setComment(comment);
			bean.setDescription(description);
			bean.setId(id);
			//bean.setExceptions(exceptions);
			bean.setName(name);
			bean.setTags(tags);
			RuleDTO dto = new DTOConverter.ToDTO().getRuleDTO(bean);
			service.checkDTO(dto, AccessType.CREATE);
			return "PASS";
		} catch (FunctionalException ex) {
			return "FAIL";
		}
	}
}

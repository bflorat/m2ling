package org.m2ling.service.principles;

import java.io.IOException;

import org.m2ling.common.dto.core.AccessType;
import org.m2ling.common.dto.core.RuleDTO;
import org.m2ling.common.exceptions.FunctionalException;
import org.m2ling.common.utils.UUT;
import org.m2ling.presentation.principles.model.RuleBean;
import org.m2ling.presentation.principles.utils.DTOConverter;

public class CreateRuleFixture extends AbstractRuleFixture {
	public CreateRuleFixture() throws IOException {
		super();
	}
	public String testNullStatus() {
		return getCheckDTOVerification("Null status", "id_rulex", "rule x", "desc", "rationale", "exceptions", "comments", "", "null", "3");
	}
}

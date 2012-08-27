package org.m2ling.service.principles;

import java.io.IOException;
import java.util.List;

import org.m2ling.common.dto.core.RuleDTO;
import org.m2ling.common.exceptions.FunctionalException;

public class SearchRuleFixture extends AbstractRuleFixture {
	public SearchRuleFixture() throws IOException {
		super();
	}

	public String getAll() throws FunctionalException {
		reset("Technical");
		List<RuleDTO> list = service.getAllRules(null, "id_vp1");
		return (list.size() > 0) ? ">0" : "=0";
	}

}

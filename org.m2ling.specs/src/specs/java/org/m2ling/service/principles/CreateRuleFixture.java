package org.m2ling.service.principles;

import java.io.IOException;

public class CreateRuleFixture extends AbstractRuleFixture {
	public CreateRuleFixture() throws IOException {
		super();
	}
	public String testNullStatus() {
		return getCheckDTOVerification("Null status", "CREATE", "id_rulex", "rule x", "desc", "rationale", "exceptions", "comments", "", "null", "3");
	}
}

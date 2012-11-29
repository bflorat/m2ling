package org.m2ling.service.principles;

import java.io.IOException;

import org.m2ling.common.exceptions.FunctionalException;

public class DeleteLTFixture extends AbstractLTFixture {
	public DeleteLTFixture() throws IOException {
		super();
	}

	public String testDeleteNoExistingLink() {
		try {
			reset("Technical");
			service.deleteLT(null, "id_lt_vp1_no_link");
			return "PASS";
		} catch (FunctionalException fe) {
			return "FAIL with code " + fe.getCode().name();
		}
	}

	public String testDeleteExistingLink() {
		try {
			reset("Technical");
			service.deleteLT(null, "id_lt_vp1_link_type_1");
			return "PASS";
		} catch (FunctionalException fe) {
			return "FAIL with code " + fe.getCode().name();
		}
	}
}

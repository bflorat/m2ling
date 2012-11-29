package org.m2ling.service.models;

import java.io.IOException;

import org.m2ling.common.exceptions.FunctionalException;

public class DeleteLinkFixture extends AbstractLinkFixture {
	public DeleteLinkFixture() throws IOException {
		super();
	}

	public String testDeleteNoExistingLI() {
		try {
			reset("Technical");
			service.deleteLink(null, "id_link_vp1_v1_link1");
			return "PASS";
		} catch (FunctionalException fe) {
			return "FAIL with code " + fe.getCode().name();
		}
	}

	public String testDeleteExistingLI() {
		try {
			reset("Technical");
			service.deleteLink(null, "id_link_vp2_v2_l1");
			return "PASS";
		} catch (FunctionalException fe) {
			return "FAIL with code " + fe.getCode().name();
		}
	}
}

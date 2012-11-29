package org.m2ling.service.principles;

import java.io.IOException;

import org.m2ling.common.exceptions.FunctionalException;

public class DeleteCTFixture extends AbstractCTFixture {
	public DeleteCTFixture() throws IOException {
		super();
	}

	public String testDeleteNoExistingComp() {
		try {
			reset("Technical");
			service.deleteCT(null, "id_ct_vp1_no_comp");
			return "PASS";
		} catch (FunctionalException fe) {
			return "FAIL with code " + fe.getCode().name();
		}
	}

	public String testDeleteExistingComp() {
		try {
			reset("Technical");
			service.deleteCT(null, "id_ct_vp1_ct1");
			return "PASS";
		} catch (FunctionalException fe) {
			return "FAIL with code " + fe.getCode().name();
		}
	}

	public String testDeleteExistingBinding() {
		try {
			reset("Technical");
			service.deleteCT(null, "id_ct_vp2_bound_target");
			return "PASS";
		} catch (FunctionalException fe) {
			return "FAIL with code " + fe.getCode().name();
		}
	}
}

package org.m2ling.service.models;

import java.io.IOException;

import org.m2ling.common.dto.core.ComponentDTO;
import org.m2ling.common.exceptions.FunctionalException;

public class DeleteComponentFixture extends AbstractComponentFixture {
	public DeleteComponentFixture() throws IOException {
		super();
	}

	public String testDeleteNoExistingCI() {
		try {
			if (!noreset) {
				reset("Technical");
			}
			ComponentDTO dto = new ComponentDTO.Builder("id_comp_vp2_v2_comp5", "", null).build();
			service.deleteComponent(null, dto);
			return "PASS";
		} catch (FunctionalException fe) {
			return "FAIL with code " + fe.getCode().name();
		}
	}

	public String testDeleteExistingCI() {
		if (!noreset) {
			reset("Technical");
		}
		try {
			ComponentDTO dto = new ComponentDTO.Builder("id_comp_vp2_v2_comp3", "", null).build();
			service.deleteComponent(null, dto);
			return "PASS";
		} catch (FunctionalException fe) {
			return "FAIL with code " + fe.getCode().name();
		}
	}

	public String testDeleteExistingBinding() {
		try {
			ComponentDTO dto = new ComponentDTO.Builder("id_comp_vp1_v1_comp5", "", null).build();
			service.deleteComponent(null, dto);
			return "PASS";
		} catch (FunctionalException fe) {
			return "FAIL with code " + fe.getCode().name();
		}
	}
}

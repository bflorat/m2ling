package org.m2ling.service.models;

import java.io.IOException;

import org.m2ling.common.dto.core.ComponentDTO;
import org.m2ling.common.exceptions.FunctionalException;

public class DeleteComponentFixture extends AbstractComponentFixture {
	public DeleteComponentFixture() throws IOException {
		super();
	}

	public void setUp() {
		super.setUp();
		reset("Technical");
	}

	public String testDeleteNoExistingCI() {
		try {
			ComponentDTO dto = new ComponentDTO.Builder("id_comp_vp2_v2_comp1", "").build();
			service.deleteComponent(null, dto);
			return "PASS";
		} catch (FunctionalException fe) {
			return "FAIL with code " + fe.getCode().name();
		}
	}

	public String testDeleteExistingCI() {
		try {
			ComponentDTO dto = new ComponentDTO.Builder("id_comp_vp2_v2_comp3", "").build();
			service.deleteComponent(null, dto);
			return "PASS";
		} catch (FunctionalException fe) {
			return "FAIL with code " + fe.getCode().name();
		}
	}

	public String testDeleteExistingBinding() {
		try {
			ComponentDTO dto = new ComponentDTO.Builder("id_comp_vp1_v1_comp4", "").build();
			service.deleteComponent(null, dto);
			return "PASS";
		} catch (FunctionalException fe) {
			return "FAIL with code " + fe.getCode().name();
		}
	}
}

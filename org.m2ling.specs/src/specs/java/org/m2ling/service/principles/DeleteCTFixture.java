package org.m2ling.service.principles;

import java.io.IOException;

import org.m2ling.common.dto.core.ComponentTypeDTO;
import org.m2ling.common.dto.core.HasNameAndIdDTO;
import org.m2ling.common.exceptions.FunctionalException;

public class DeleteCTFixture extends AbstractCTFixture {
	public DeleteCTFixture() throws IOException {
		super();
	}

	public String testDeleteNoExistingComp() {
		try {
			reset("Technical");
			HasNameAndIdDTO vp = new HasNameAndIdDTO.Builder("id_vp1", "").build();
			ComponentTypeDTO dto = new ComponentTypeDTO.Builder(vp, "id_vp1_no_comp", "vp1_no_comp").build();
			service.deleteCT(null, dto);
			return "PASS";
		} catch (FunctionalException fe) {
			return "FAIL with code " + fe.getCode().name();
		}
	}

	public String testDeleteExistingComp() {
		try {
			reset("Technical");
			HasNameAndIdDTO vp = new HasNameAndIdDTO.Builder("id_vp1", "").build();
			ComponentTypeDTO dto = new ComponentTypeDTO.Builder(vp, "id_comp_type_1", "comp_type_1").build();
			service.deleteCT(null, dto);
			return "PASS";
		} catch (FunctionalException fe) {
			return "FAIL with code " + fe.getCode().name();
		}
	}

	public String testDeleteExistingBinding() {
		try {
			reset("Technical");
			HasNameAndIdDTO vp = new HasNameAndIdDTO.Builder("id_vp1", "").build();
			ComponentTypeDTO dto = new ComponentTypeDTO.Builder(vp, "id_vp1_bound_target", "vp1_bound_target").build();
			service.deleteCT(null, dto);
			return "PASS";
		} catch (FunctionalException fe) {
			return "FAIL with code " + fe.getCode().name();
		}
	}
}
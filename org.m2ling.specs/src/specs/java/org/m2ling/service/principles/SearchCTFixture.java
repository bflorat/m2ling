package org.m2ling.service.principles;

import java.io.IOException;
import java.util.List;

import org.m2ling.common.dto.core.ComponentTypeDTO;
import org.m2ling.common.exceptions.FunctionalException;

public class SearchCTFixture extends AbstractCTFixture {
	public SearchCTFixture() throws IOException {
		super();
	}

	public String testDeleteNoExistingComp() {
		try {
			reset("Technical");
			service.deleteCT(null, "id_vp1_no_comp");
			return "PASS";
		} catch (FunctionalException fe) {
			return "FAIL with code " + fe.getCode().name();
		}
	}

	public String getAll() throws FunctionalException {
		reset("Technical");
		List<ComponentTypeDTO> list = service.getAllCT(null, "id_vp1");
		return (list.size() > 0) ? ">0" : "=0";
	}

	public String getCTByID(String id) {
		reset("Technical");
		ComponentTypeDTO dto = null;
		try {
			dto = service.getCTByID(null, id);
		} catch (FunctionalException fe) {
			return "FAIL with code" + fe.getCode().name();
		}
		return dto.getName();
	}
}

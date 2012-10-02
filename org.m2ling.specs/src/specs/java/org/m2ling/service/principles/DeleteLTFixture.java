package org.m2ling.service.principles;

import java.io.IOException;

import org.m2ling.common.dto.core.HasNameAndIdDTO;
import org.m2ling.common.dto.core.LinkTypeDTO;
import org.m2ling.common.exceptions.FunctionalException;

public class DeleteLTFixture extends AbstractLTFixture {
	public DeleteLTFixture() throws IOException {
		super();
	}

	public String testDeleteNoExistingLink() {
		try {
			reset("Technical");
			HasNameAndIdDTO vp = new HasNameAndIdDTO.Builder("id_vp1", "").build();
			LinkTypeDTO dto = new LinkTypeDTO.Builder(vp, "id_lt_vp1_no_link", "lt_vp1_no_link").build();
			service.deleteLT(null, dto);
			return "PASS";
		} catch (FunctionalException fe) {
			return "FAIL with code " + fe.getCode().name();
		}
	}

	public String testDeleteExistingLink() {
		try {
			reset("Technical");
			HasNameAndIdDTO vp = new HasNameAndIdDTO.Builder("id_vp1", "").build();
			LinkTypeDTO dto = new LinkTypeDTO.Builder(vp, "id_lt_vp1_link_type_1", "lt_vp1_link_type_1").build();
			service.deleteLT(null, dto);
			return "PASS";
		} catch (FunctionalException fe) {
			return "FAIL with code " + fe.getCode().name();
		}
	}
}

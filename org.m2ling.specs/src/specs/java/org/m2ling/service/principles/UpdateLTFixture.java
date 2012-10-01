package org.m2ling.service.principles;

import java.io.IOException;

import org.m2ling.common.dto.core.HasNameAndIdDTO;
import org.m2ling.common.dto.core.LinkTypeDTO;
import org.m2ling.common.exceptions.FunctionalException;

public class UpdateLTFixture extends AbstractLTFixture {
	public UpdateLTFixture() throws IOException {
		super();
	}

	public String testUpdateLT30(String linkTypeID) {
		try {
			reset("Technical");
			HasNameAndIdDTO vp = new HasNameAndIdDTO.Builder("id_vp1", "").build();
			LinkTypeDTO dto = new LinkTypeDTO.Builder(vp, linkTypeID, "").build();
			service.updateLT(null, dto);
			return "PASS";
		} catch (FunctionalException fe) {
			return "FAIL with code " + fe.getCode().name();
		}
	}
}

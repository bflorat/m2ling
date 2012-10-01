package org.m2ling.service.principles;

import java.io.IOException;
import java.util.List;

import org.m2ling.common.dto.core.LinkTypeDTO;
import org.m2ling.common.exceptions.FunctionalException;

public class SearchLTFixture extends AbstractLTFixture {
	public SearchLTFixture() throws IOException {
		super();
	}

	public String getAll() throws FunctionalException {
		reset("Technical");
		List<LinkTypeDTO> list = service.getAllLT(null, "id_vp1");
		return (list.size() > 0) ? ">0" : "=0";
	}

	public String getCTByID(String id) {
		reset("Technical");
		LinkTypeDTO dto = null;
		try {
			dto = service.getLTByID(null, id);
		} catch (FunctionalException fe) {
			return "FAIL with code" + fe.getCode().name();
		}
		return dto.getName();
	}
}

package org.m2ling.service.models;

import java.io.IOException;
import java.util.List;

import org.m2ling.common.dto.core.LinkDTO;
import org.m2ling.common.exceptions.FunctionalException;

public class SearchLinkFixture extends AbstractLinkFixture {
	public SearchLinkFixture() throws IOException {
		super();
	}

	public String getAll() throws FunctionalException {
		reset("Technical");
		List<LinkDTO> list = service.getAllLinks(null, "id_vp1_v1");
		return (list.size() > 0) ? ">0" : "=0";
	}

	public String getLinkByID(String id) {
		reset("Technical");
		LinkDTO dto = null;
		try {
			dto = service.getLinkByID(null, id);
		} catch (FunctionalException fe) {
			return "FAIL with code" + fe.getCode().name();
		}
		return dto.getName();
	}
}

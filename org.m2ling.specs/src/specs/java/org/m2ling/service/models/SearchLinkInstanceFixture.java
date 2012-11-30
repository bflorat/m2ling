package org.m2ling.service.models;

import java.io.IOException;
import java.util.List;

import org.m2ling.common.dto.core.LinkInstanceDTO;
import org.m2ling.common.exceptions.FunctionalException;

public class SearchLinkInstanceFixture extends AbstractLinkInstanceFixture {
	public SearchLinkInstanceFixture() throws IOException {
		super();
	}

	public String getAll() throws FunctionalException {
		reset("Technical");
		List<LinkInstanceDTO> list = service.getAllLinkInstances(null, "id_vp2_v2");
		return (list.size() > 0) ? ">0" : "=0";
	} 

	public String getLIByID(String id) {
		reset("Technical");
		LinkInstanceDTO dto = null;
		try {
			dto = service.getLinkInstanceByID(null, id);
		} catch (FunctionalException fe) {
			return "FAIL with code" + fe.getCode().name();
		}
		return dto.getName();
	}
}

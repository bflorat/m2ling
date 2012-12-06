package org.m2ling.service.models;

import java.io.IOException;
import java.util.List;

import org.m2ling.common.dto.core.ComponentInstanceDTO;
import org.m2ling.common.exceptions.FunctionalException;
import org.m2ling.common.utils.UUT;

public class SearchCIFixture extends AbstractCIFixture {
	public SearchCIFixture() throws IOException {
		super(); 
	}

	public String getAll(String vID) throws FunctionalException {
		if (!noreset) {
			reset("Bikes");
		}
		List<ComponentInstanceDTO> list = service.getAllCI(null, vID);
		return (list.size() > 0) ? ">0" : "=0";
	}

	public String getCIByID(String id) {
		if (!noreset) {
			reset("Bikes");
		}
		ComponentInstanceDTO dto = null;
		try {
			dto = service.getCIByID(null, UUT.nul(id));
		} catch (FunctionalException fe) {
			return "FAIL with code " + fe.getCode().name();
		}
		if (dto == null) {
			return "unkwown component";
		}
		return dto.getName();
	}
}

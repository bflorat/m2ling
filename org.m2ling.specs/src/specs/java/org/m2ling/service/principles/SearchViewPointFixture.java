package org.m2ling.service.principles;

import java.io.IOException;
import java.util.List;

import org.m2ling.common.dto.core.ViewPointDTO;
import org.m2ling.common.exceptions.FunctionalException;
import org.m2ling.common.utils.UUT;

public class SearchViewPointFixture extends AbstractViewPointFixture {
	public SearchViewPointFixture() throws IOException {
		super();
	}

	public String getAll() throws FunctionalException {
		reset("Technical");
		List<ViewPointDTO> list = service.getAllViewPoints(null);
		return (list.size() > 0) ? ">0" : "=0";
	}

	public String getVpByID(String id) {
		reset("Technical");
		ViewPointDTO dto = null;
		try {
			dto = service.getViewPointByID(null, UUT.nul(id));
		} catch (FunctionalException fe) {
			return "FAIL with code " + fe.getCode().name();
		}
		if (dto == null) {
			return "unkwown vp";
		}
		return dto.getName();
	}

	public String getVpByName(String name) {
		reset("Technical");
		ViewPointDTO dto = null;
		try {
			dto = service.getViewPointByName(null, UUT.nul(name));
		} catch (FunctionalException fe) {
			return "FAIL with code " + fe.getCode().name();
		}
		if (dto == null) {
			return "unkwown vp";
		}
		return dto.getId();
	}
}

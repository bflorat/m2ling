package org.m2ling.service.models;

import java.io.IOException;
import java.util.List;

import org.m2ling.common.dto.core.ViewDTO;
import org.m2ling.common.exceptions.FunctionalException;
import org.m2ling.common.utils.UUT;

public class SearchViewFixture extends AbstractViewFixture {
	public SearchViewFixture() throws IOException {
		super();
	}

	public String getAll() throws FunctionalException {
		reset("Technical");
		List<ViewDTO> list = service.getAllViews(null);
		return (list.size() > 0) ? ">0" : "=0";
	}

	public String getVpByID(String id) {
		reset("Technical");
		ViewDTO dto = null;
		try {
			dto = service.getViewByID(null, UUT.nul(id));
		} catch (FunctionalException fe) {
			return "FAIL with code " + fe.getCode().name();
		}
		if (dto == null) {
			return "unkwown view";
		}
		return dto.getName();
	}
}

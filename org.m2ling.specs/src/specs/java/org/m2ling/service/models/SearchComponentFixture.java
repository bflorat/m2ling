package org.m2ling.service.models;

import java.io.IOException;
import java.util.List;

import org.m2ling.common.dto.core.ComponentDTO;
import org.m2ling.common.exceptions.FunctionalException;
import org.m2ling.common.utils.UUT;

public class SearchComponentFixture extends AbstractComponentFixture {
	public SearchComponentFixture() throws IOException {
		super();
	}
	
	public void setUp(){
		super.setUp();
		reset("Bikes");
	}

	public String getAll(String vID) throws FunctionalException {
		List<ComponentDTO> list = service.getAllComponents(null, vID);
		return (list.size() > 0) ? ">0" : "=0"; 
	}

	public String getComponentByID(String id) {
		ComponentDTO dto = null;
		try {
			dto = service.getComponentByID(null, UUT.nul(id));
		} catch (FunctionalException fe) {
			return "FAIL with code " + fe.getCode().name();
		}
		if (dto == null) {
			return "unkwown component";
		}
		return dto.getName();
	}
}

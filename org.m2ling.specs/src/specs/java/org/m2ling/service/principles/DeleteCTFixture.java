package org.m2ling.service.principles;

import java.io.IOException;

import org.m2ling.common.exceptions.FunctionalException;

public class DeleteCTFixture extends AbstractCTFixture {
	public DeleteCTFixture() throws IOException { 
		super();  
	}

	public String testDelete(String id) throws FunctionalException {
		try {
			reset("Technical"); 
			service.deleteCT(null, id);
			return "PASS";
		} catch (FunctionalException fe) {
			return "FAIL with code " + fe.getCode().name();
		}
	}
}

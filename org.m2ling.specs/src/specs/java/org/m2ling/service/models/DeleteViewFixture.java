package org.m2ling.service.models;

import java.io.IOException;

import org.m2ling.common.dto.core.ViewDTO;
import org.m2ling.common.exceptions.FunctionalException;

public class DeleteViewFixture extends AbstractViewFixture {
	public DeleteViewFixture() throws IOException {
		super();
	}

	public String delete(String idView) throws FunctionalException {
		try {
			reset("Technical");
			service.deleteView(null, idView);
			ViewDTO found = service.getViewByID(null, idView);
			return (found == null) ? "null" : found.toString();
		} catch (FunctionalException fe) {
			return "FAIL with code " + fe.getCode().name();
		}
	}
}

package org.m2ling.service.models;

import java.io.IOException;

import org.m2ling.common.dto.core.ComponentDTO;
import org.m2ling.common.dto.core.ReferenceDTO;
import org.m2ling.common.exceptions.FunctionalException;

public class DeleteComponentFixture extends AbstractComponentFixture {
	public DeleteComponentFixture() throws IOException {
		super();
	}

	public String testDelete(String compID) {
		try {
			if (!noreset) {
				reset("Technical");
			}
			service.deleteComponent(null, compID);
			return "PASS";
		} catch (FunctionalException fe) {
			return "FAIL with code " + fe.getCode().name();
		}
	}

	public String getReferenceAfterDrop(String hasRefID, String targetID, String refType) throws FunctionalException {
		try {
			if (!noreset) {
				reset("Technical");
			}
			service.deleteComponent(null, targetID);
			ComponentDTO compDTO = service.getComponentByID(null, hasRefID);
			for (ReferenceDTO ref : compDTO.getReferences()) {
				if (ref.getType().equals(refType)) {
					return ref.toString();
				}
			}
			return "null";
		} catch (FunctionalException fe) {
			return "FAIL with code " + fe.getCode().name();
		}
	}
}

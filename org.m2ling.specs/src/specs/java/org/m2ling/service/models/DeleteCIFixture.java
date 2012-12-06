package org.m2ling.service.models;

import java.io.IOException;

import org.m2ling.common.dto.core.ComponentInstanceDTO;
import org.m2ling.common.dto.core.ReferenceDTO;
import org.m2ling.common.exceptions.FunctionalException;

public class DeleteCIFixture extends AbstractCIFixture {
	public DeleteCIFixture() throws IOException {
		super();
	}

	public String testDelete(String compID) {
		try {
			if (!noreset) {
				reset("Technical");
			}
			service.deleteCI(null, compID);
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
			service.deleteCI(null, targetID);
			ComponentInstanceDTO compDTO = service.getCIByID(null, hasRefID);
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

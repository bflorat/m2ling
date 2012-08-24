package org.m2ling.service.principles;

import java.io.IOException;

import org.m2ling.common.dto.core.ViewPointDTO;
import org.m2ling.common.exceptions.FunctionalException;

public class DeleteViewPointFixture extends AbstractViewPointFixture {
	public DeleteViewPointFixture() throws IOException {
		super();
	}

	public String deleteWithoutRefs(String id) throws FunctionalException {
		try {
			reset("Technical");
			// Drop references in presets
			pm.getRoot().getViews().remove(0);
			pm.getRoot().getViews().remove(0);
			service.deleteViewPoint(null, id);
			ViewPointDTO found = service.getViewPointByID(null, id);
			return (found == null) ? "null" : found.toString();
		} catch (FunctionalException fe) {
			return "FAIL with code " + fe.getCode().name();
		}
	}

	public String deleteWithLocalComp(String id) throws FunctionalException {
		try {
			reset("Technical");
			service.deleteViewPoint(null, id);
			ViewPointDTO found = service.getViewPointByID(null, id);
			return (found == null) ? "null" : found.toString();
		} catch (FunctionalException fe) {
			return "FAIL with code " + fe.getCode().name();
		}
	}

	public String deleteWithBinding(String id) throws FunctionalException {
		try {
			reset("Technical");
			// remove view1 so we only test view2 not using vp1
			pm.getRoot().getViews().remove(0);
			service.deleteViewPoint(null, id);
			ViewPointDTO found = service.getViewPointByID(null, id);
			return (found == null) ? "null" : found.toString();
		} catch (FunctionalException fe) {
			return "FAIL with code " + fe.getCode().name();
		}
	}
}

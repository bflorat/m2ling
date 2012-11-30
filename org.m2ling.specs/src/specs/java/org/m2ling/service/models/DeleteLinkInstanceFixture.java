package org.m2ling.service.models;

import java.io.IOException;

import org.m2ling.common.exceptions.FunctionalException;

public class DeleteLinkInstanceFixture extends AbstractLinkInstanceFixture {
	public DeleteLinkInstanceFixture() throws IOException {
		super();
	}

	public String testDelete(String liID) {
		try {
			reset("Bikes");
			service.deleteLinkInstance(null, liID);
			return "PASS";
		} catch (FunctionalException fe) {
			return "FAIL with code " + fe.getCode().name();
		}
	}
}

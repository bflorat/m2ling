package org.m2ling.service.principles.impl;

import org.concordion.integration.junit3.ConcordionTestCase;
import org.m2ling.common.dto.core.ViewPointDTO;
import org.m2ling.service.principles.ViewPointService;

public class CreateViewPointFixture extends ConcordionTestCase {
	ViewPointService service;

	public CreateViewPointFixture() {
		super();
		service = new ViewPointServiceImpl();
	}

	/**
	 * Create a viewpoint and return its name
	 * 
	 * @return the new viewpoint name
	 */
	public String getViewPointName(String name) {
		ViewPointDTO dto = new ViewPointDTO.Builder(name).build();
		service.createViewPoint(dto);
		ViewPointDTO checkedDTO = service.getViewPointByName(name);
		return checkedDTO.getName();
	}
}

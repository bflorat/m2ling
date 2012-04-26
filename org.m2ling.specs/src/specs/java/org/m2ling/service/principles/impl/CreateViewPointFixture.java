package org.m2ling.service.principles.impl;

import org.m2ling.common.dto.core.ViewPointDTO;
import org.m2ling.service.principles.ViewPointService;
import org.m2ling.specs.BindedConcordionTestCase;
import org.m2ling.specs.FixturesModule;

public class CreateViewPointFixture extends BindedConcordionTestCase {
	ViewPointService service;

	public CreateViewPointFixture() {
		super();
		service = new ViewPointServiceImpl(new FixturesModule());
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

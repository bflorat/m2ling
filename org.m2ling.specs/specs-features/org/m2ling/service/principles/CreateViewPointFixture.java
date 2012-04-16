package org.m2ling.service.principles;

import org.junit.runner.RunWith;
import org.m2ling.dto.core.ViewPointDTO;
import org.m2ling.service.BindedConcordionTestCase;

import atunit.AtUnit;
import atunit.Container;
import atunit.Container.Option;
import atunit.Unit;

import com.google.inject.Inject;

@RunWith(AtUnit.class)
@Container(Option.GUICE)
public class CreateViewPointFixture extends BindedConcordionTestCase {

	public CreateViewPointFixture() {
		super();
	}

	@Inject
	@Unit
	ViewPointService service;

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

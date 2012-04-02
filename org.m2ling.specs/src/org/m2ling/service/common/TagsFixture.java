package org.m2ling.service.common;

import TagDTO;

import org.junit.runner.RunWith;
import org.m2ling.domain.core.HasTags;
import org.m2ling.dto.core.CoreDTOFactory;
import org.m2ling.dto.core.ViewPointDTO;
import org.m2ling.service.BindedConcordionTestCase;
import org.m2ling.service.principles.ViewPointService;

import atunit.AtUnit;
import atunit.Container;
import atunit.Container.Option;
import atunit.Unit;

import com.google.inject.Inject;

@RunWith(AtUnit.class)
@Container(Option.GUICE)
public class TagsFixture extends BindedConcordionTestCase {

	public TagsFixture() {
		super();
	}

	/**
	 * We need a viewpoint service to built a viewpoint, one of the HashTags implementations
	 */
	@Inject 
	@Unit
	ViewPointService serviceViewPoint;

	/**
	 * Apply given tags as text and return the new tag text.
	 * Note that the tags are actually applied against a new instance of HashTags at each call.
	 * @param the tags text
	 * @return the new tags text
	 */
	public String applyTags(String text) {
		String vpName = "foo"; 
		ViewPointDTO vpDTO = CoreDTOFactory.newViewPointDTO(vpName);
		serviceViewPoint.createViewPoint(vpDTO);
		serviceViewPoint.applyTags(text);
		ViewPointDTO 
		HasTags hasTags = serviceViewPoint.getViewPointByName(vpName);
		return null;
		
	}
}

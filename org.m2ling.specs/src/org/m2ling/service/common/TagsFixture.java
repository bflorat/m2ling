package org.m2ling.service.common;

import java.util.Iterator;
import java.util.List;

import org.junit.runner.RunWith;
import org.m2ling.domain.core.Type;
import org.m2ling.dto.core.ViewPointDTO;
import org.m2ling.service.BindedConcordionTestCase;
import org.m2ling.service.core.TagService;
import org.m2ling.service.principles.ViewPointService;
import org.m2ling.utils.Utils;

import atunit.AtUnit;
import atunit.Container;
import atunit.Container.Option;
import atunit.Unit;

import com.google.common.base.Splitter;
import com.google.common.base.Strings;
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
	ViewPointService serviceViewPoint;

	@Inject
	@Unit
	TagService serviceTag;

	/**
	 * Add given tags as text and return the new tag text. Note that the tags are actually applied
	 * against a new instance of HasTags at each call.
	 */
	public String addTags(String previousTags, String newTags) {
		// We check the tags behavior against a sample HasTags child class : ViewPoint.
		String viewpointName = "" + System.currentTimeMillis();
		ViewPointDTO vpDTO = new ViewPointDTO.Builder(viewpointName).build();
		serviceViewPoint.createViewPoint(vpDTO);
		Iterable<String> it = Splitter.on(newTags).trimResults().omitEmptyStrings().split(",");
		List<String> newTagsList = Utils.listFromIterable(it);
		serviceTag.addTags(Type.VIEWPOINT, viewpointName, newTagsList);
		List<String> result = serviceTag.getAllTags(Type.VIEWPOINT, viewpointName);
		String resultString = "";
	/*	for (result){
			
		}
		
		String result*/
		return null;
		//TODO
	}

	/**
	 * Set given tags as text and return the new tag text. Note that the tags are actually applied
	 * against a new instance of HasTags at each call.
	 */
	public String setTags(String previousTags, String newTags) {
		// We check the tags behavior against a sample HasTags child class : ViewPoint.
		String viewpointName = "" + System.currentTimeMillis();
		ViewPointDTO vpDTO = new ViewPointDTO.Builder(viewpointName).build();
		serviceViewPoint.createViewPoint(vpDTO);
		Iterable<String> it = Splitter.on(newTags).trimResults().omitEmptyStrings().split(",");
		List<String> newTagsList = Utils.listFromIterable(it);
		serviceTag.setTags(Type.VIEWPOINT, viewpointName, newTagsList);
	}
	
	
}

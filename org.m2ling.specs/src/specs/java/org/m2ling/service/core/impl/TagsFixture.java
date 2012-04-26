package org.m2ling.service.core.impl;

import java.util.Arrays;
import java.util.List;

import org.m2ling.common.dto.core.ViewPointDTO;
import org.m2ling.common.utils.Utils;
import org.m2ling.domain.core.Type;
import org.m2ling.service.core.TagService;
import org.m2ling.service.principles.ViewPointService;
import org.m2ling.service.principles.impl.ViewPointServiceImpl;
import org.m2ling.specs.BindedConcordionTestCase;
import org.m2ling.specs.FixturesModule;

public class TagsFixture extends BindedConcordionTestCase {

	/**
	 * We need a viewpoint service to built a viewpoint, one of the HashTags implementations
	 */
	ViewPointService serviceViewPoint;

	// Note that the service implementation is explicit in purpose, we don't use DI (best practice
	// for UT).
	TagService serviceTag;

	public TagsFixture() {
		super();
		serviceViewPoint = Utils.newInstance(ViewPointServiceImpl.class,null);
		serviceTag = new TagServiceImpl(new FixturesModule());
	}

	private String createViewPoint(List<String> tags) {
		// We check the tags behavior against a sample HasTags child class : ViewPoint.
		String viewpointName = "" + System.currentTimeMillis();
		ViewPointDTO vpDTO = new ViewPointDTO.Builder(viewpointName).tags(tags).build();
		serviceViewPoint.createViewPoint(vpDTO);
		return viewpointName;
	}

	/**
	 * Add given tags as text and return the new tag text. Note that the tags are actually applied
	 * against a new instance of HasTags at each call.
	 */
	public String addTags(String previousTags, String newTags) {
		String viewpointName = createViewPoint(Utils.tagsFromString(previousTags));
		List<String> newTagsList = Utils.tagsFromString(newTags);
		serviceTag.addTags(context, Type.VIEWPOINT, viewpointName, newTagsList);
		List<String> result = serviceTag.getAllTags(context, Type.VIEWPOINT, viewpointName);
		return Utils.tagsAsString(result);
	}

	/**
	 * Set given tags as text and return the new tag text. Note that the tags are actually applied
	 * against a new instance of HasTags at each call.
	 */
	public String setTags(String previousTags, String newTags) {
		String viewpointName = createViewPoint(Utils.tagsFromString(previousTags));
		List<String> newTagsList = Utils.tagsFromString(newTags);
		serviceTag.setTags(context, Type.VIEWPOINT, viewpointName, newTagsList);
		List<String> result = serviceTag.getAllTags(context, Type.VIEWPOINT, viewpointName);
		return Utils.tagsAsString(result);
	}

	public String setTagWithComa() {
		String viewpointName = createViewPoint(null);
		List<String> items = Arrays.asList(new String[] { "foo,bar" });
		try {
			// We expect an IllegalArgumentException
			serviceTag.setTags(context, Type.VIEWPOINT, viewpointName, items);
			List<String> result = serviceTag.getAllTags(context, Type.VIEWPOINT, viewpointName);
			return Utils.tagsAsString(result);
		} catch (IllegalArgumentException iae) {
			return "IllegalArgumentException";
		} catch (Exception e) {
			return "<Unexpected IllegalArgumentException>";
		}
	}

	public String setEmptyTag() {
		String viewpointName = createViewPoint(null);
		List<String> items = Arrays.asList(new String[] { "" });
		try {
			// We expect an IllegalArgumentException
			serviceTag.setTags(context, Type.VIEWPOINT, viewpointName, items);
			List<String> result = serviceTag.getAllTags(context, Type.VIEWPOINT, viewpointName);
			return Utils.tagsAsString(result);
		} catch (IllegalArgumentException iae) {
			return "IllegalArgumentException";
		} catch (Exception e) {
			return "<Unexpected IllegalArgumentException>";
		}
	}

	public String setNullTag() {
		String viewpointName = createViewPoint(null);
		List<String> items = Arrays.asList(new String[] { "foo", "bar", null });
		try {
			// We expect an IllegalArgumentException
			serviceTag.setTags(context, Type.VIEWPOINT, viewpointName, items);
			List<String> result = serviceTag.getAllTags(context, Type.VIEWPOINT, viewpointName);
			return Utils.tagsAsString(result);
		} catch (IllegalArgumentException iae) {
			return "IllegalArgumentException";
		} catch (Exception e) {
			return "<Unexpected IllegalArgumentException>";
		}
	}
}

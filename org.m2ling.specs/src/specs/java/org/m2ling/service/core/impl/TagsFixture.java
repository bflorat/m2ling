package org.m2ling.service.core.impl;

import java.util.Arrays;
import java.util.List;

import org.m2ling.common.utils.Utils;
import org.m2ling.domain.core.Type;
import org.m2ling.service.core.TagService;
import org.m2ling.specs.BindedConcordionTestCase;
import org.m2ling.specs.FixturesModule;

public class TagsFixture extends BindedConcordionTestCase {

	// Note that the service implementation is explicit in purpose, we don't use DI (best practice
	// for UT).
	TagService serviceTag;

	/** Sample viewpoints are named against this prefix and their initial tag */
	private static final String SAMPLE_VIEWPOINT_PREFIX = "viewPointTag_";

	public TagsFixture() {
		super();
		serviceTag = new TagServiceImpl(new FixturesModule("src/specs/resources/mocks/tests.m2ling"));
	}

	/**
	 * Add given tags as text and return the new tag text. Note that the tags are actually applied
	 * against a new instance of HasTags at each call.
	 */
	public String addTags(String previousTags, String newTags) {
		List<String> newTagsList = Utils.tagsFromString(newTags);
		serviceTag.addTags(context, Type.VIEWPOINT, getVPName(previousTags), newTagsList);
		List<String> result = serviceTag.getAllTags(context, Type.VIEWPOINT, getVPName(previousTags));
		return Utils.tagsAsString(result);
	}

	/**
	 * Set given tags as text and return the new tag text. Note that the tags are actually applied
	 * against a new instance of HasTags at each call.
	 */
	public String setTags(String previousTags, String newTags) {
		List<String> newTagsList = Utils.tagsFromString(newTags);
		serviceTag.setTags(context, Type.VIEWPOINT, getVPName(previousTags), newTagsList);
		List<String> result = serviceTag.getAllTags(context, Type.VIEWPOINT, getVPName(previousTags));
		return Utils.tagsAsString(result);
	}

	private String getVPName(String previousTags) {
		String packagedPrevious = previousTags.replace('.', '_').replace(',', '_');
		return SAMPLE_VIEWPOINT_PREFIX + packagedPrevious;
	}

	public String setTagWithComa() {
		List<String> items = Arrays.asList(new String[] { "foo,bar" });
		try {
			// We expect an IllegalArgumentException
			serviceTag.setTags(context, Type.VIEWPOINT, SAMPLE_VIEWPOINT_PREFIX, items);
			List<String> result = serviceTag.getAllTags(context, Type.VIEWPOINT, SAMPLE_VIEWPOINT_PREFIX);
			return Utils.tagsAsString(result);
		} catch (IllegalArgumentException iae) {
			return "IllegalArgumentException";
		} catch (Exception e) {
			return "<Unexpected IllegalArgumentException>";
		}
	}

	public String setEmptyTag() {
		List<String> items = Arrays.asList(new String[] { "" });
		try {
			// We expect an IllegalArgumentException
			serviceTag.setTags(context, Type.VIEWPOINT, SAMPLE_VIEWPOINT_PREFIX, items);
			List<String> result = serviceTag.getAllTags(context, Type.VIEWPOINT, SAMPLE_VIEWPOINT_PREFIX);
			return Utils.tagsAsString(result);
		} catch (IllegalArgumentException iae) {
			return "IllegalArgumentException";
		} catch (Exception e) {
			return "<Unexpected IllegalArgumentException>";
		}
	}

	public String setNullTag() {
		List<String> items = Arrays.asList(new String[] { "foo", "bar", null });
		try {
			// We expect an IllegalArgumentException
			serviceTag.setTags(context, Type.VIEWPOINT, SAMPLE_VIEWPOINT_PREFIX, items);
			List<String> result = serviceTag.getAllTags(context, Type.VIEWPOINT, SAMPLE_VIEWPOINT_PREFIX);
			return Utils.tagsAsString(result);
		} catch (IllegalArgumentException iae) {
			return "IllegalArgumentException";
		} catch (Exception e) {
			return "<Unexpected IllegalArgumentException>";
		}
	}
}

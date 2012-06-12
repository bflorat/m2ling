package org.m2ling.service.core.impl;

import java.util.Arrays;
import java.util.List;

import org.concordion.integration.junit3.ConcordionTestCase;
import org.junit.Test;
import org.m2ling.common.soa.Context;
import org.m2ling.common.utils.Utils;
import org.m2ling.domain.core.Type;
import org.m2ling.service.core.TagService;

public class TagsFixture extends ConcordionTestCase {

	// Note that the service implementation is explicit in purpose, we don't use DI (best practice
	// for UT).
	TagService serviceTag;

	/** Sample viewpoints are named against this prefix and their initial tag */
	private static final String SAMPLE_VIEWPOINT_PREFIX = "viewPointTag_";

	public static final Context MOCK_CONTEXT = Context.newContext(Context.Entry.USER, "hceheo").add(
			Context.Entry.PWD_HASH, "8f7d88e901a5ad3a05d8cc0de93313fd76028f8c");

	public TagsFixture() {
		super();
		serviceTag = new TagServiceImpl();
	}

	/**
	 * Add given tags as text and return the new tag text. Note that the tags are actually applied
	 * against a new instance of HasTags at each call.
	 */
	@Test
	public String addTags(String previousTags, String newTags) {
		List<String> newTagsList = Utils.tagsFromString(newTags);
		serviceTag.addTags(MOCK_CONTEXT, Type.VIEWPOINT, getVPName(previousTags), newTagsList);
		List<String> result = serviceTag.getAllTags(MOCK_CONTEXT, Type.VIEWPOINT, getVPName(previousTags));
		return Utils.tagsAsString(result);
	}

	/**
	 * Set given tags as text and return the new tag text. Note that the tags are actually applied
	 * against a new instance of HasTags at each call.
	 */
	public String setTags(String previousTags, String newTags) {
		List<String> newTagsList = Utils.tagsFromString(newTags);
		serviceTag.setTags(MOCK_CONTEXT, Type.VIEWPOINT, getVPName(previousTags), newTagsList);
		List<String> result = serviceTag.getAllTags(MOCK_CONTEXT, Type.VIEWPOINT, getVPName(previousTags));
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
			serviceTag.setTags(MOCK_CONTEXT, Type.VIEWPOINT, SAMPLE_VIEWPOINT_PREFIX, items);
			List<String> result = serviceTag.getAllTags(MOCK_CONTEXT, Type.VIEWPOINT, SAMPLE_VIEWPOINT_PREFIX);
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
			serviceTag.setTags(MOCK_CONTEXT, Type.VIEWPOINT, SAMPLE_VIEWPOINT_PREFIX, items);
			List<String> result = serviceTag.getAllTags(MOCK_CONTEXT, Type.VIEWPOINT, SAMPLE_VIEWPOINT_PREFIX);
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
			serviceTag.setTags(MOCK_CONTEXT, Type.VIEWPOINT, SAMPLE_VIEWPOINT_PREFIX, items);
			List<String> result = serviceTag.getAllTags(MOCK_CONTEXT, Type.VIEWPOINT, SAMPLE_VIEWPOINT_PREFIX);
			return Utils.tagsAsString(result);
		} catch (IllegalArgumentException iae) {
			return "IllegalArgumentException";
		} catch (Exception e) {
			return "<Unexpected IllegalArgumentException>";
		}
	}
}

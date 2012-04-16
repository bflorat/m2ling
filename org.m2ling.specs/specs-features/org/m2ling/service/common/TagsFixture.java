package org.m2ling.service.common;

import java.util.Arrays;
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
		serviceTag.addTags(Type.VIEWPOINT, viewpointName, newTagsList);
		List<String> result = serviceTag.getAllTags(Type.VIEWPOINT, viewpointName);
		return Utils.tagsAsString(result);
	}

	/**
	 * Set given tags as text and return the new tag text. Note that the tags are actually applied
	 * against a new instance of HasTags at each call.
	 */
	public String setTags(String previousTags, String newTags) {
		String viewpointName = createViewPoint(Utils.tagsFromString(previousTags));
		List<String> newTagsList = Utils.tagsFromString(newTags);
		serviceTag.setTags(Type.VIEWPOINT, viewpointName, newTagsList);
		List<String> result = serviceTag.getAllTags(Type.VIEWPOINT, viewpointName);
		return Utils.tagsAsString(result);
	}

	public String setTagWithComa() {
		String viewpointName = createViewPoint(null);
		List<String> items = Arrays.asList(new String[] { "foo,bar" });
		try {
			// We expect an IllegalArgumentException
			serviceTag.setTags(Type.VIEWPOINT, viewpointName, items);
			List<String> result = serviceTag.getAllTags(Type.VIEWPOINT, viewpointName);
			return Utils.tagsAsString(result);
		} catch (IllegalArgumentException iae) {
			return "IllegalArgumentException";
		} catch (Exception e) {
			return "<UNexpected IllegalArgumentException>";
		}
	}

	public String setEmptyTag() {
		String viewpointName = createViewPoint(null);
		List<String> items = Arrays.asList(new String[] { "" });
		try {
			// We expect an IllegalArgumentException
			serviceTag.setTags(Type.VIEWPOINT, viewpointName, items);
			List<String> result = serviceTag.getAllTags(Type.VIEWPOINT, viewpointName);
			return Utils.tagsAsString(result);
		} catch (IllegalArgumentException iae) {
			return "IllegalArgumentException";
		} catch (Exception e) {
			return "<UNexpected IllegalArgumentException>";
		}
	}

	public String setNullTag() {
		String viewpointName = createViewPoint(null);
		List<String> items = Arrays.asList(new String[] { "foo", "bar", null });
		try {
			// We expect an IllegalArgumentException
			serviceTag.setTags(Type.VIEWPOINT, viewpointName, items);
			List<String> result = serviceTag.getAllTags(Type.VIEWPOINT, viewpointName);
			return Utils.tagsAsString(result);
		} catch (IllegalArgumentException iae) {
			return "IllegalArgumentException";
		} catch (Exception e) {
			return "<UNexpected IllegalArgumentException>";
		}
	}

}

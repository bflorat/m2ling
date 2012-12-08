package org.m2ling.service.common;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.m2ling.common.configuration.Conf;
import org.m2ling.common.exceptions.FunctionalException;
import org.m2ling.common.soa.Context;
import org.m2ling.common.utils.Utils;
import org.m2ling.domain.core.Type;
import org.m2ling.persistence.PersistenceManagerXMIImpl;
import org.m2ling.service.util.CoreUtil;
import org.m2ling.service.util.DTOConverter.FromDTO;
import org.m2ling.service.util.DTOConverter.ToDTO;
import org.m2ling.specs.M2lingFixture;

public class TagsFixture extends M2lingFixture {
	// Note that the service implementation is explicit in purpose, we don't use DI (best practice
	// for UT).
	TagService serviceTag;

	/** Sample viewpoints are named against this prefix and their initial tag */
	private static final String SAMPLE_VIEWPOINT_PREFIX = "viewPointTag_";

	public static final Context MOCK_CONTEXT = Context.newContext(Context.Entry.USER, "hceheo").add(
			Context.Entry.PWD_HASH, "8f7d88e901a5ad3a05d8cc0de93313fd76028f8c");

	public TagsFixture() throws IOException {
		super();
		String sampleXMI = "src/specs/resources/mocks/Technical.m2ling";
		Properties prop = new Properties();
		prop.setProperty(PersistenceManagerXMIImpl.SpecificConfiguration.CONF_XMI_PATH, sampleXMI);
		Conf configuration = new Conf(prop, logger, null);
		PersistenceManagerXMIImpl pm = new PersistenceManagerXMIImpl(logger, configuration);
		CoreUtil util = new CoreUtil(logger, pm);
		FromDTO fromDTO = new FromDTO(util);
		ReferenceHelper refHelper = new ReferenceHelper(util);
		TagServiceChecker checker = new  TagServiceChecker(pm, util, fromDTO, refHelper);
		serviceTag = new TagServiceImpl(pm, util, new FromDTO(util), new ToDTO(util), configuration, logger,checker);
	}

	/**
	 * Add given tags as text and return the new tag text. Note that the tags are actually applied
	 * against a new instance of HasTags at each call.
	 */
	public String addTags(String previousTags, String newTags) throws FunctionalException {
		List<String> newTagsList = Utils.stringListFromString(newTags);
		serviceTag.addTags(MOCK_CONTEXT, Type.VIEWPOINT, getVPName(previousTags), newTagsList);
		List<String> result = serviceTag.getAllTags(MOCK_CONTEXT, Type.VIEWPOINT, getVPName(previousTags));
		return Utils.stringListAsString(result);
	}

	/**
	 * Set given tags as text and return the new tag text. Note that the tags are actually applied
	 * against a new instance of HasTags at each call.
	 */
	public String setTags(String previousTags, String newTags) throws FunctionalException {
		List<String> newTagsList = Utils.stringListFromString(newTags);
		serviceTag.setTags(MOCK_CONTEXT, Type.VIEWPOINT, getVPName(previousTags), newTagsList);
		List<String> result = serviceTag.getAllTags(MOCK_CONTEXT, Type.VIEWPOINT, getVPName(previousTags));
		return Utils.stringListAsString(result);
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
			return Utils.stringListAsString(result);
		} catch (FunctionalException func) {
			return "FunctionalException";
		} catch (Exception e) {
			return "<Unexpected exception>";
		}
	}

	public String setEmptyTag() {
		List<String> items = Arrays.asList(new String[] { "" });
		try {
			// We expect an IllegalArgumentException
			serviceTag.setTags(MOCK_CONTEXT, Type.VIEWPOINT, SAMPLE_VIEWPOINT_PREFIX, items);
			List<String> result = serviceTag.getAllTags(MOCK_CONTEXT, Type.VIEWPOINT, SAMPLE_VIEWPOINT_PREFIX);
			return Utils.stringListAsString(result);
		} catch (FunctionalException func) {
			return "FunctionalException";
		} catch (Exception e) {
			return "<Unexpected exception>";
		}
	}

	public String setNullTag() {
		List<String> items = Arrays.asList(new String[] { "foo", "bar", null });
		try {
			// We expect an IllegalArgumentException
			serviceTag.setTags(MOCK_CONTEXT, Type.VIEWPOINT, SAMPLE_VIEWPOINT_PREFIX, items);
			List<String> result = serviceTag.getAllTags(MOCK_CONTEXT, Type.VIEWPOINT, SAMPLE_VIEWPOINT_PREFIX);
			return Utils.stringListAsString(result);
		} catch (FunctionalException func) {
			return "FunctionalException";
		} catch (Exception e) {
			return "<Unexpected exception>";
		}
	}

	public String setNullTags() {
		try {
			// We expect an IllegalArgumentException
			serviceTag.setTags(MOCK_CONTEXT, Type.VIEWPOINT, SAMPLE_VIEWPOINT_PREFIX, null);
			return "PASS";
		} catch (FunctionalException func) {
			return "FunctionalException";
		} catch (Exception e) {
			return "<Unexpected exception>";
		}
	}
}

package org.m2ling.service.principles;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.LogRecord;

import org.m2ling.common.dto.core.ComponentTypeDTO;
import org.m2ling.common.exceptions.FunctionalException;
import org.m2ling.common.exceptions.TechnicalException;
import org.m2ling.common.utils.UUT;
import org.m2ling.common.utils.Utils;
import org.m2ling.presentation.principles.model.ComponentTypeBean;
import org.m2ling.presentation.principles.utils.DTOConverter;

import com.google.common.base.Strings;

public class CreateCTFixture extends AbstractCTFixture {
	public CreateCTFixture() throws IOException {
		super();
	}

	public String createWithIfAndReifiable(String ifactor, String reifiable) throws FunctionalException {
		return createAndGetCT("true", "CT1", "id_vp_logical", "id_new_ct_logical_servicecontainer", "ServicesContainer2",
				"", "", "", ifactor, "null", "", "", reifiable);
	}

	public String testNoBindingType() throws FunctionalException {
		return createAndGetCT("true", "CT8", "id_vp_logical", "id_new_ct_logical_servicecontainer", "ServicesContainer2",
				"", "", "", "*", "null", "", "id_comp_tech_jboss5", "true");
	}

	public String testCascadingBinding() throws FunctionalException {
		return createAndGetCT("true", "CT8", "id_vp_logical", "id_new_ct_logical_servicecontainer", "ServicesContainer2",
				"", "", "", "*", "id_ct_app_application", "", "id_comp_tech_jboss5", "true");
	}

	public String testLocalBinding() throws FunctionalException {
		return createAndGetCT("true", "CT8", "id_vp_logical", "id_new_ct_logical_servicecontainer", "ServicesContainer2",
				"", "", "", "*", "id_ct_logical_servicecontainer", "", "id_comp_tech_jboss5", "true");
	}

	public String testBoundDerivedName(String caseName, String ctAttributes, String boundCTAttributes)
			throws FunctionalException {
		try {
			String ctName = null;
			String ctTags = null;
			String ctComment = null;
			String ctDescription = null;
			String boundName = null;
			String boundTags = null;
			String boundComment = null;
			String boundDescription = null;
			StringTokenizer st = new StringTokenizer(ctAttributes, "|");
			while (st.hasMoreTokens()) {
				ctName = st.nextToken();
				ctTags = st.nextToken();
				ctComment = st.nextToken();
				ctDescription = st.nextToken();
			}
			StringTokenizer stBound = new StringTokenizer(boundCTAttributes, "|");
			while (stBound.hasMoreTokens()) {
				boundName = stBound.nextToken();
				boundTags = stBound.nextToken();
				boundComment = stBound.nextToken();
				boundDescription = stBound.nextToken();
			}
			// First create the bound CT
			String resu = createAndGetCT("true", "CT11", "id_vp_tech", "id_bound_ct_tech_servicecontainer", boundName,
					boundDescription, boundComment, boundTags, "*", "null", "", "", "true");
			logger.log(new LogRecord(Level.INFO, resu));
			// then create the new CT
			noreset = true;
			resu = createAndGetCT("true", "CT11", "id_vp_logical", "id_new_ct_logical_servicecontainer", ctName,
					ctDescription, ctComment, ctTags, "*", "id_bound_ct_tech_servicecontainer", "", "", "true");
			logger.log(new LogRecord(Level.INFO, resu));
			// Return the new CT attributes
			ComponentTypeDTO ctDTO = service.getCTByID(null, "id_new_ct_logical_servicecontainer");
			return ctDTO.getName() + "|" + ctDTO.getTags() + "|" + ctDTO.getComment() + "|" + ctDTO.getDescription();
		} finally {
			noreset = false;
		}
	}

	public String testEnumeration(String caseName, String comps, String groups) throws FunctionalException {
		String enumeration = "";
		if (!("null".equals(comps)) && !Strings.isNullOrEmpty(comps)) {
			enumeration += comps;
		}
		if (!("null".equals(groups)) && !Strings.isNullOrEmpty(groups)) {
			if (enumeration.length() > 0) {
				enumeration += "," + groups;
			} else {
				enumeration = groups;
			}
		}
		return createAndGetCT("true", caseName, "id_vp_logical", "id_new_ct_logical_servicecontainer",
				"ServicesContainer2", "", "", "", "-1", "id_ct_tech_applicationserver", "", enumeration, "true");
	}

	/**
	 * Create and return a component type from a presentation layer bean (to test it too), then
	 * search it back
	 * 
	 * @param bean
	 * @param name
	 * @return
	 * @throws FunctionalException
	 */
	public String createAndGetCT(String justCheck, String caseName, String vpID, String id, String name, String desc,
			String comment, String tags, String ifactor, String boundTypeID, String references, String enumeration,
			String reifiable) throws FunctionalException {
		if (!noreset) {
			reset("Bikes");
		}
		vpID = UUT.nul(vpID);
		id = UUT.nul(id);
		name = UUT.nul(name);
		desc = UUT.nul(desc);
		comment = UUT.nul(comment);
		tags = UUT.nul(tags);
		ifactor = UUT.nul(ifactor);
		boundTypeID = UUT.nul(boundTypeID);
		references = UUT.nul(references);
		enumeration = UUT.nul(enumeration);
		reifiable = UUT.nul(reifiable);
		try {
			ComponentTypeBean bean = new ComponentTypeBean();
			bean.setComment(comment);
			bean.setDescription(desc);
			bean.setId(id);
			bean.setName(name);
			bean.setTags(tags);
			bean.setViewPointId(vpID);
			bean.setBoundTypeID(boundTypeID);
			if (Strings.isNullOrEmpty(enumeration)) {
				bean.setEnumeration(new ArrayList<String>());
			} else {
				List<String> enumer = Utils.stringListFromString(enumeration);
				bean.setEnumeration(enumer);
			}
			bean.setInstantiationFactor(ifactor);
			setReferences(bean, references);
			bean.setReifiable(Boolean.parseBoolean(reifiable));
			ComponentTypeDTO dto = new DTOConverter.ToDTO().getComponentTypeDTO(bean);
			service.createCT(null, dto);
			List<ComponentTypeDTO> ctDTOS = service.getAllCT(null, vpID);
			for (ComponentTypeDTO ctDTO : ctDTOS) {
				if (ctDTO.getId().equals(bean.getId())) {
					ComponentTypeBean out = new DTOConverter.FromDTO().getComponentTypeBean(ctDTO);
					if (Boolean.parseBoolean(justCheck)) {
						return "PASS";
					} else {
						return out.toString();
					}
				}
			}
			return "Unknown item";
		} catch (FunctionalException ex) {
			return "FAIL with code " + ex.getCode().name();
		} catch (TechnicalException ex) {
			return "FAIL with code " + ex.getCode().name();
		}
	}
}

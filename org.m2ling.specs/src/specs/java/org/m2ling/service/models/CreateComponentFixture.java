package org.m2ling.service.models;

import java.io.IOException;
import java.util.List;

import org.m2ling.common.dto.core.AccessType;
import org.m2ling.common.dto.core.ComponentDTO;
import org.m2ling.common.dto.core.HasNameAndIdDTO;
import org.m2ling.common.dto.core.ReferenceDTO;
import org.m2ling.common.exceptions.FunctionalException;
import org.m2ling.common.exceptions.TechnicalException;
import org.m2ling.common.utils.UUT;
import org.m2ling.common.utils.Utils;
import org.m2ling.presentation.principles.ReferenceType;
import org.m2ling.presentation.principles.model.HasNameAndIDBean;
import org.m2ling.presentation.principles.utils.DTOConverter;
import org.m2ling.presentation.studio.model.ComponentBean;

public class CreateComponentFixture extends AbstractComponentFixture {
	public CreateComponentFixture() throws IOException {
		super();
	}

	public String testNullRef() throws FunctionalException {
		ComponentDTO.Builder builder = new ComponentDTO.Builder("id_foo", "Weblogic");
		builder.type(new HasNameAndIdDTO.Builder("id_ct_logical_servicecontainer", "").build());
		builder.description("desc");
		HasNameAndIdDTO nullTarget = new HasNameAndIdDTO.Builder(null, "").build();
		ReferenceDTO ref = new ReferenceDTO.Builder(ReferenceType.RUNS.name()).addTarget(nullTarget).build();
		builder.addReference(ref);
		try {
			service.createComponent(null, builder.build(), "id_view_vp_logical_Logical_BikesOnline");
			return "PASS";
		} catch (FunctionalException ex) {
			return "FAIL with code " + ex.getCode().name();
		} catch (TechnicalException ex) {
			return "FAIL with code " + ex.getCode().name();
		}
	}

	public String testWrongTargetType() throws FunctionalException {
		return checkFormat("COMP1/wrong target", "id_view_vp_logical_Logical_BikesOnline", "id_ct_logical_servicecontainer", "id_foo",
				"Weblogic", "desc", "comment", "", "null", "RUNS:id_comp_view_Logical_BikesOnline_AdminGUI", "null");
	}

	public String testWrongReferenceType() throws FunctionalException {
		return checkFormat("COMP1/wrong type", "id_view_vp_logical_Logical_BikesOnline", "id_ct_logical_servicecontainer", "id_foo",
				"Weblogic", "desc", "comment", "", "null", "DEPENDS_ON:id_comp_view_Logical_BikesOnline_AdminGUI", "null");
	}

	public String testNullBinding() throws FunctionalException {
		return checkFormat("COMP3", "id_view_vp_logical_Logical_BikesOnline", "id_ct_logical_servicecontainer", "id_foo",
				"Weblogic", "desc", "comment", "", "null", "null", "null");
	}
	
	public String testWrongBinding() throws FunctionalException {
		return checkFormat("COMP4", "id_view_vp_logical_Logical_BikesOnline", "id_ct_logical_servicecontainer", "id_foo",
				"Weblogic", "desc", "comment", "", "id_comp_tech_solaris", "null", "null");
	}

	/*
	 * Direct DTO control check (without using presentation layer)
	 */
	public String checkFormat(String caseName, String vID, String ctID, String id, String name, String desc,
			String comment, String tags, String boundID, String references, String status) throws FunctionalException {
		if (!noreset) {
			reset("Bikes");
		}
		try {
			ComponentDTO.Builder builder = new ComponentDTO.Builder(UUT.nul(id), UUT.nul(name));
			if (UUT.nul(tags) != null) {
				for (String tag : Utils.stringListFromString(tags)) {
					builder.addTag(tag);
				}
			}
			builder.comment(UUT.nul(comment));
			builder.description(UUT.nul(desc));
			builder.status(UUT.nul(status));
			setDTOReferences(builder, UUT.nul(references));
			if (UUT.nul(boundID) != null) {
				builder.boundType(new HasNameAndIdDTO.Builder(boundID, "").build());
			}
			builder.type(new HasNameAndIdDTO.Builder(ctID, "").build());
			service.checkDTO(builder.build(), UUT.nul(vID), AccessType.CREATE);
			return "PASS";
		} catch (FunctionalException ex) {
			return "FAIL with code " + ex.getCode().name();
		} catch (TechnicalException ex) {
			return "FAIL with code " + ex.getCode().name();
		}
	}

	/**
	 * Create and return a component from a presentation layer bean (to test it too), then search it
	 * back
	 * 
	 * @param bean
	 * @param name
	 * @return component toString or "Unknown item" or code failure string
	 */
	public String createAndGetComp(String justCheck, String caseName, String vID, String ctID, String id, String name,
			String desc, String comment, String tags, String boundID, String references, String status)
			throws FunctionalException {
		if (!noreset) {
			reset("Bikes");
		}
		vID = UUT.nul(vID);
		ctID = UUT.nul(ctID);
		id = UUT.nul(id);
		name = UUT.nul(name);
		desc = UUT.nul(desc);
		comment = UUT.nul(comment);
		tags = UUT.nul(tags);
		boundID = UUT.nul(boundID);
		references = UUT.nul(references);
		status = UUT.nul(status);
		try {
			ComponentBean bean = new ComponentBean();
			bean.setComment(comment);
			bean.setDescription(desc);
			bean.setId(id);
			bean.setName(name);
			bean.setTags(tags);
			bean.setType(HasNameAndIDBean.newInstance(ctID, ""));
			bean.setBoundComponent(HasNameAndIDBean.newInstance(boundID, ""));
			setBeanReferences(bean, references);
			bean.setStatus(status);
			ComponentDTO dto = new DTOConverter.ToDTO().getComponentDTO(bean);
			service.createComponent(null, dto, vID);
			List<ComponentDTO> compDTOS = service.getAllComponents(null, vID);
			for (ComponentDTO compDTO : compDTOS) {
				if (compDTO.getId().equals(bean.getId())) {
					ComponentBean out = new DTOConverter.FromDTO().getComponentBean(compDTO);
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

package org.m2ling.service.principles;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.m2ling.common.dto.core.ComponentTypeDTO;
import org.m2ling.common.dto.core.HasNameAndIdDTO;
import org.m2ling.common.exceptions.FunctionalException;
import org.m2ling.common.exceptions.TechnicalException;
import org.m2ling.common.utils.UUT;
import org.m2ling.common.utils.Utils;
import org.m2ling.presentation.principles.model.ComponentTypeBean;
import org.m2ling.presentation.principles.model.HasNameAndIDBean;
import org.m2ling.presentation.principles.utils.DTOConverter;

import com.google.common.base.Strings;

public class UpdateCTFixture extends AbstractCTFixture {
	public UpdateCTFixture() throws IOException {
		super();
	}

	@Test
	public String testUpdateIF(String caseName, String vpID, String id, String name, String ifactor)
			throws FunctionalException {
		if (!noreset)
			reset("Bikes");
		vpID = UUT.nul(vpID);
		id = UUT.nul(id);
		name = UUT.nul(name);
		ifactor = UUT.nul(ifactor);
		try {
			ComponentTypeBean bean = new ComponentTypeBean();
			bean.setComment("");
			bean.setDescription("desc");
			bean.setId(id);
			bean.setName(name);
			bean.setTags("");
			setReferences(bean, "RUNS:id_ct_deploy_OS");
			HasNameAndIDBean vp = new HasNameAndIDBean();
			vp.setId(vpID);
			bean.setViewPoint(vp);
			bean.setInstantiationFactor(ifactor);
			bean.setEnumeration(new ArrayList<HasNameAndIDBean>());
			bean.setBoundType(HasNameAndIDBean.newInstance("id_ct_physical_x86_server", ""));
			ComponentTypeDTO dto = new DTOConverter.ToDTO().getComponentTypeDTO(bean);
			service.updateCT(null, dto);
			List<ComponentTypeDTO> ctDTOS = service.getAllCT(null, vpID);
			for (ComponentTypeDTO ctDTO : ctDTOS) {
				if (ctDTO.getId().equals(bean.getId())) {
					return "PASS";
				}
			}
			return "Unknown item";
		} catch (FunctionalException ex) {
			return "FAIL with code " + ex.getCode().name();
		} catch (TechnicalException ex) {
			return "FAIL with code " + ex.getCode().name();
		}
	}

	public String testDropBinding() throws FunctionalException {
		if (!noreset)
			reset("Technical");
		try {
			HasNameAndIdDTO vpDTO = new HasNameAndIdDTO.Builder("id_vp2", "").build();
			ComponentTypeDTO.Builder builder = new ComponentTypeDTO.Builder(vpDTO, "id_ct_vp2_ct4", "ct_vp2_ct4");
			builder.boundType(null);
			builder.description("desc");
			service.updateCT(null, builder.build());
			return "PASS";
		} catch (FunctionalException ex) {
			return "FAIL with code " + ex.getCode().name();
		} catch (TechnicalException ex) {
			return "FAIL with code " + ex.getCode().name();
		}
	}

	public String testChangeBinding() throws FunctionalException {
		if (!noreset)
			reset("Technical");
		try {
			HasNameAndIdDTO vpDTO = new HasNameAndIdDTO.Builder("id_vp2", "").build();
			ComponentTypeDTO.Builder builder = new ComponentTypeDTO.Builder(vpDTO, "id_ct_vp2_ct4", "ct_vp2_ct4");
			HasNameAndIdDTO boundCTDTO = new HasNameAndIdDTO.Builder("id_ct_vp1_ct2", "").build();
			builder.boundType(boundCTDTO);
			builder.description("desc");
			service.updateCT(null, builder.build());
			return "PASS";
		} catch (FunctionalException ex) {
			return "FAIL with code " + ex.getCode().name();
		} catch (TechnicalException ex) {
			return "FAIL with code " + ex.getCode().name();
		}
	}

	public String testDropBindingNoComp() throws FunctionalException {
		if (!noreset)
			reset("Technical");
		try {
			HasNameAndIdDTO vpDTO = new HasNameAndIdDTO.Builder("id_vp2", "").build();
			ComponentTypeDTO.Builder builder = new ComponentTypeDTO.Builder(vpDTO, "id_ct_vp2_ct3", "ct_vp2_ct3");
			builder.description("desc");
			builder.boundType(null);
			service.updateCT(null, builder.build());
			return "PASS";
		} catch (FunctionalException ex) {
			return "FAIL with code " + ex.getCode().name();
		} catch (TechnicalException ex) {
			return "FAIL with code " + ex.getCode().name();
		}
	}

	public String testChangeBindingNoComp() throws FunctionalException {
		if (!noreset)
			reset("Technical");
		try {
			HasNameAndIdDTO vpDTO = new HasNameAndIdDTO.Builder("id_vp2", "").build();
			ComponentTypeDTO.Builder builder = new ComponentTypeDTO.Builder(vpDTO, "id_ct_vp2_ct3", "ct_vp2_ct3");
			HasNameAndIdDTO boundCTDTO = new HasNameAndIdDTO.Builder("id_ct_vp1_ct2", "").build();
			builder.description("desc");
			builder.boundType(boundCTDTO);
			service.updateCT(null, builder.build());
			return "PASS";
		} catch (FunctionalException ex) {
			return "FAIL with code " + ex.getCode().name();
		} catch (TechnicalException ex) {
			return "FAIL with code " + ex.getCode().name();
		}
	}

	@Test
	public String updateReference(String caseName, String sourceCTID, String references) throws FunctionalException {
		if (!noreset)
			reset("Bikes");
		try {
			ComponentTypeBean bean = new ComponentTypeBean();
			// Prepopulate CT with old values for attributes out of the scope of this test
			ComponentTypeDTO oldCTDTO = service.getCTByID(null, sourceCTID);
			bean.setComment(oldCTDTO.getComment());
			bean.setDescription(oldCTDTO.getDescription());
			bean.setId(sourceCTID);
			bean.setName(oldCTDTO.getName());
			bean.setTags(Utils.stringListAsString(oldCTDTO.getTags()));
			HasNameAndIDBean vp = new HasNameAndIDBean();
			vp.setId(oldCTDTO.getViewPoint().getId());
			bean.setViewPoint(vp);
			bean.setBoundType(HasNameAndIDBean.newInstance(oldCTDTO.getBoundType().getId(), ""));
			bean.setEnumeration(new ArrayList<HasNameAndIDBean>());
			bean.setInstantiationFactor("" + oldCTDTO.getInstantiationFactor());
			setReferences(bean, references);
			ComponentTypeDTO dto = new DTOConverter.ToDTO().getComponentTypeDTO(bean);
			service.updateCT(null, dto);
			List<ComponentTypeDTO> ctDTOS = service.getAllCT(null, vp.getId());
			for (ComponentTypeDTO ctDTO : ctDTOS) {
				if (ctDTO.getId().equals(bean.getId())) {
					return "PASS";
				}
			}
			return "Unknown item";
		} catch (FunctionalException ex) {
			return "FAIL with code " + ex.getCode().name();
		} catch (TechnicalException ex) {
			return "FAIL with code " + ex.getCode().name();
		}
	}

	public String testUpdateBound(String caseName, String vpID, String id, String name, String ifactor,
			String boundTypeID, String references, String enumeration, String description, String tags, String comment)
			throws FunctionalException {
		if (!noreset)
			reset("Bikes");
		vpID = UUT.nul(vpID);
		id = UUT.nul(id);
		name = UUT.nul(name);
		ifactor = UUT.nul(ifactor);
		boundTypeID = UUT.nul(boundTypeID);
		references = UUT.nul(references);
		enumeration = UUT.nul(enumeration);
		description = UUT.nul(description);
		comment = UUT.nul(comment);
		tags = UUT.nul(tags);
		try {
			ComponentTypeBean bean = new ComponentTypeBean();
			bean.setComment(comment);
			bean.setDescription(description);
			bean.setId(id);
			bean.setName(name);
			bean.setTags(tags);
			HasNameAndIDBean vp = new HasNameAndIDBean();
			vp.setId(vpID);
			bean.setViewPoint(vp);
			HasNameAndIDBean boundType = new HasNameAndIDBean();
			boundType.setId(boundTypeID);
			bean.setBoundType(boundType);
			if (Strings.isNullOrEmpty(enumeration)) {
				bean.setEnumeration(new ArrayList<HasNameAndIDBean>());
			} else {
				List<String> enumer = Utils.stringListFromString(enumeration);
				List<HasNameAndIDBean> enum2 = new ArrayList<HasNameAndIDBean>();
				for (String compID : enumer) {
					HasNameAndIDBean hni = new HasNameAndIDBean();
					hni.setId(compID);
					enum2.add(hni);
				}
				bean.setEnumeration(enum2);
			}
			bean.setInstantiationFactor(ifactor);
			setReferences(bean, references);
			ComponentTypeDTO dto = new DTOConverter.ToDTO().getComponentTypeDTO(bean);
			service.updateCT(null, dto);
			List<ComponentTypeDTO> ctDTOS = service.getAllCT(null, vpID);
			for (ComponentTypeDTO ctDTO : ctDTOS) {
				if (ctDTO.getId().equals(bean.getId())) {
					return "PASS";
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

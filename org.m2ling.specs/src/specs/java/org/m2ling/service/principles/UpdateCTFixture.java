package org.m2ling.service.principles;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.m2ling.common.dto.core.ComponentTypeDTO;
import org.m2ling.common.dto.core.RuleDTO;
import org.m2ling.common.exceptions.FunctionalException;
import org.m2ling.common.exceptions.TechnicalException;
import org.m2ling.common.utils.UUT;
import org.m2ling.common.utils.Utils;
import org.m2ling.presentation.principles.model.ComponentTypeBean;
import org.m2ling.presentation.principles.model.ReferenceBean;
import org.m2ling.presentation.principles.model.RuleBean;
import org.m2ling.presentation.principles.utils.DTOConverter;

import com.google.common.base.Strings;

public class UpdateCTFixture extends AbstractCTFixture {
	public UpdateCTFixture() throws IOException {
		super();
	}

	private String update(boolean justCheck, String caseName, String vpID, String id, String name, String desc,
			String comment, String tags, String ifactor, String boundTypeID, String references, String enumeration,
			boolean reifiable) throws FunctionalException {
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
			List<ReferenceBean> refs = new ArrayList<ReferenceBean>();
			if (Strings.isNullOrEmpty(references)) {
				bean.setReferences(refs);
			} else {
				StringTokenizer st = new StringTokenizer(references, ";");
				while (st.hasMoreTokens()) {
					String ref = st.nextToken();
					ReferenceBean refbean = new ReferenceBean();
					StringTokenizer st2 = new StringTokenizer(ref, ":");
					refbean.setType(st2.nextToken());
					String targs = st2.nextToken();
					StringTokenizer st3 = new StringTokenizer(targs, ",");
					List<String> targets = new ArrayList<String>();
					while (st3.hasMoreTokens()) {
						targets.add(st3.nextToken());
					}
					refbean.setTargets(targets);
					refs.add(refbean);
				}
				bean.setReferences(refs);
			}
			bean.setReifiable(reifiable);
			ComponentTypeDTO dto = new DTOConverter.ToDTO().getComponentTypeDTO(bean);
			service.updateCT(null, dto);
			List<ComponentTypeDTO> ctDTOS = service.getAllCT(null, vpID);
			for (ComponentTypeDTO ctDTO : ctDTOS) {
				if (ctDTO.getId().equals(bean.getId())) {
					ComponentTypeBean out = new DTOConverter.FromDTO().getComponentTypeBean(ctDTO);
					if (justCheck) {
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

	public String testIFChangeToOneReifiable() throws FunctionalException {
		reset("Bikes");
		return update(true, "IF change", "id_vp_deploy", "id_ct_deploy_X86", "name", "", "", "", "1", null, "", "", true);
	}
	
	public String testIFChangeToOnenonReifiable() throws FunctionalException {
		reset("Bikes");
		return update(true, "IF change", "id_vp_deploy", "id_ct_deploy_X86", "name", "", "", "", "1", null, "", "", false);
	}
}

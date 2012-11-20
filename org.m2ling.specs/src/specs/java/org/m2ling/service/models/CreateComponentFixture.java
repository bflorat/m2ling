package org.m2ling.service.models;

import java.io.IOException;
import java.util.List;

import org.m2ling.common.dto.core.ComponentDTO;
import org.m2ling.common.exceptions.FunctionalException;
import org.m2ling.common.exceptions.TechnicalException;
import org.m2ling.common.utils.UUT;
import org.m2ling.presentation.principles.model.HasNameAndIDBean;
import org.m2ling.presentation.principles.utils.DTOConverter;
import org.m2ling.presentation.studio.model.ComponentBean;

public class CreateComponentFixture extends AbstractComponentFixture {
	public CreateComponentFixture() throws IOException {
		super();
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
			setReferences(bean, references);
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

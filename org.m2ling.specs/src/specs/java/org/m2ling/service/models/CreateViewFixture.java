package org.m2ling.service.models;

import java.io.IOException;

import org.junit.Test;
import org.m2ling.common.dto.core.AccessType;
import org.m2ling.common.dto.core.HasNameAndIdDTO;
import org.m2ling.common.dto.core.ViewDTO;
import org.m2ling.common.exceptions.FunctionalException;
import org.m2ling.common.utils.UUT;
import org.m2ling.common.utils.Utils;
import org.m2ling.presentation.principles.model.HasNameAndIDBean;
import org.m2ling.presentation.principles.utils.DTOConverter;
import org.m2ling.presentation.studio.model.ViewBean;

public class CreateViewFixture extends AbstractViewFixture {
	public CreateViewFixture() throws IOException {
		super();
	}


	@Test
	public String getView(String id, String name, String vpID, String description, String comment, String tags)
			throws FunctionalException {
		reset("Technical");
		ViewBean bean = new ViewBean();
		bean.setComment(comment);
		bean.setDescription(description);
		bean.setId(id);
		bean.setName(name);
		bean.setTags(tags);
		bean.setViewpoint(HasNameAndIDBean.newInstance(vpID,""));
		ViewDTO dto = new DTOConverter.ToDTO().getViewDTO(bean);
		service.createView(null, dto);
		ViewDTO checkedDTO = service.getViewByID(null, id);
		ViewBean outBean = new DTOConverter.FromDTO().getViewBean(checkedDTO);
		return outBean.toString();
	}

	/**
	 * Return "PASS" or "FAIL" according to result of checkDTO()
	 * 
	 * @param dto
	 * @return "PASS" or "FAIL" according to result of checkDTO()
	 */
	public String getCheckDTOVerification(String caseName, String id, String vpID, String name, String description,
			String comment, String tags) {
		reset("Technical");
		try {
			HasNameAndIdDTO vpDTO = null;
			if (vpID != null) {
				vpDTO = new HasNameAndIdDTO.Builder(vpID, "").build();
			}
			ViewDTO.Builder builder = (ViewDTO.Builder) new ViewDTO.Builder(UUT.nul(id), UUT.nul(name), vpDTO)
					.description(UUT.nul(description)).comment(UUT.nul(comment));
			if (!tags.equals("null")) {
				for (String tag : Utils.stringListFromString(tags)) {
					builder.addTag(tag);
				}
			}
			service.checkDTO(builder.build(), AccessType.CREATE);
			return "PASS";
		} catch (FunctionalException ex) {
			return "FAIL with code " + ex.getCode().name();
		}
	}
}

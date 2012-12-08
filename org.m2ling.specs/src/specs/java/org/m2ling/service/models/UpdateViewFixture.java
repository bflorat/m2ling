package org.m2ling.service.models;

import java.io.IOException;
import java.util.List;

import org.m2ling.common.dto.core.AccessType;
import org.m2ling.common.dto.core.HasNameAndIdDTO;
import org.m2ling.common.dto.core.ViewDTO;
import org.m2ling.common.exceptions.FunctionalException;
import org.m2ling.common.utils.UUT;
import org.m2ling.common.utils.Utils;
import org.m2ling.presentation.principles.model.HasNameAndIDBean;
import org.m2ling.presentation.principles.utils.DTOConverter;
import org.m2ling.presentation.studio.model.ViewBean;

public class UpdateViewFixture extends AbstractViewFixture {
	public UpdateViewFixture() throws IOException {
		super();
	}

	public String update(String id, String name, String vpID, String description, String comment, String tags)
			throws FunctionalException {
		reset("Technical");
		ViewBean bean = new ViewBean();
		bean.setComment(UUT.nul(comment));
		bean.setDescription(UUT.nul(description));
		bean.setId(UUT.nul(id));
		bean.setName(UUT.nul(name));
		bean.setTags(UUT.nul(tags));
		HasNameAndIDBean vpBean = null;
		if (vpID != null) {
			vpBean = HasNameAndIDBean.newInstance(vpID, "");
		}
		bean.setViewpoint(vpBean);
		ViewDTO dto = new DTOConverter.ToDTO().getViewDTO(bean);
		service.updateView(null, dto);
		ViewDTO checkedDTO = service.getViewByID(null, id);
		ViewBean outBean = new DTOConverter.FromDTO().getViewBean(checkedDTO);
		return outBean.toString();
	}

	public String getView(String id) {
		ViewDTO dto = null;
		try {
			dto = service.getViewByID(null, id);
			ViewBean outBean = new DTOConverter.FromDTO().getViewBean(dto);
			return outBean.toString();
		} catch (FunctionalException fe) {
			return "FAIL with code " + fe.getCode().name();
		}
	}

	/**
	 * Return "PASS" or "FAIL" according to result of checkDTO()
	 * 
	 * @param dto
	 * @return "PASS" or "FAIL" according to result of checkDTO()
	 */
	public String getCheckDTOVerification(String caseDesc, String id, String name, String vpID, String description,
			String comment, String tags) {
		reset("Technical");
		try {
			List<String> tagsList = null;
			if (!tags.equals("null")) {
				tagsList = Utils.stringListFromString(tags); 
			}
			HasNameAndIdDTO vpDTO = null;
			if (UUT.nul(vpID) != null) {
				vpDTO = new HasNameAndIdDTO.Builder(UUT.nul(vpID), "").build();
			}
			ViewDTO.Builder builder = (ViewDTO.Builder) new ViewDTO.Builder(UUT.nul(id), UUT.nul(name), vpDTO)
					.description(UUT.nul(description)).comment(UUT.nul(comment));
			for (String tag : tagsList) {
				builder.addTag(tag);
			}
			checker.checkDTO(builder.build(), AccessType.UPDATE);
			return "PASS";
		} catch (FunctionalException ex) {
			return "FAIL with code " + ex.getCode();
		}
	}
}

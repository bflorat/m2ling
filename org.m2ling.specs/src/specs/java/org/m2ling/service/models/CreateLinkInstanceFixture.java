package org.m2ling.service.models;

import java.io.IOException;
import java.util.List;

import org.m2ling.common.dto.core.AccessType;
import org.m2ling.common.dto.core.HasNameAndIdDTO;
import org.m2ling.common.dto.core.LinkInstanceDTO;
import org.m2ling.common.exceptions.FunctionalException;
import org.m2ling.common.exceptions.TechnicalException;
import org.m2ling.common.utils.UUT;
import org.m2ling.common.utils.Utils;
import org.m2ling.presentation.principles.model.HasNameAndIDBean;
import org.m2ling.presentation.principles.utils.DTOConverter;
import org.m2ling.presentation.studio.model.LinkInstanceBean;

public class CreateLinkInstanceFixture extends AbstractLinkInstanceFixture {
	public CreateLinkInstanceFixture() throws IOException {
		super();
	}

	/**
	 * Create and return a LI from a presentation layer bean (to test it too), then search it back
	 */
	public String createAndGet(String caseName, String vID, String id, String linkID, String name, String desc,
			String comment, String tags, String sourceID, String destinationID, String status) throws FunctionalException {
		if (!noreset) {
			reset("Bikes");
		}
		vID = UUT.nul(vID);
		HasNameAndIDBean view = null;
		if (vID != null) {
			view = HasNameAndIDBean.newInstance(vID, "");
		}
		id = UUT.nul(id);
		name = UUT.nul(name);
		desc = UUT.nul(desc);
		comment = UUT.nul(comment);
		tags = UUT.nul(tags);
		status = UUT.nul(status);
		linkID = UUT.nul(linkID);
		sourceID = UUT.nul(sourceID);
		destinationID = UUT.nul(destinationID);
		LinkInstanceBean bean = new LinkInstanceBean();
		bean.setComment(comment);
		bean.setDescription(desc);
		bean.setId(id);
		bean.setName(name);
		HasNameAndIDBean source = HasNameAndIDBean.newInstance(sourceID, "");
		HasNameAndIDBean dest = HasNameAndIDBean.newInstance(destinationID, "");
		bean.setSource(source);
		bean.setDestination(dest);
		bean.setTags(tags);
		bean.setStatus(status);
		bean.setLink(HasNameAndIDBean.newInstance(linkID, ""));
		bean.setView(view);
		LinkInstanceDTO dto = new DTOConverter.ToDTO().getLinkInstanceDTO(bean);
		try {
			service.createLinkInstance(null, dto);
			List<LinkInstanceDTO> liDTOS = service.getAllLinkInstances(null, vID);
			for (LinkInstanceDTO liDTO : liDTOS) {
				if (liDTO.getId().equals(bean.getId())) {
					LinkInstanceBean out = new DTOConverter.FromDTO().getLinkInstanceBean(liDTO);
					return out.toString();
				}
			}
			return "Unknown item";
		} catch (FunctionalException ex) {
			return "FAIL with code " + ex.getCode().name();
		} catch (TechnicalException ex) {
			return "FAIL with code " + ex.getCode().name();
		}
	}

	public String testWrongSourceOrDestType(String sourceOrDest) {
		if (!noreset) {
			reset("Bikes");
		}
		try {
			HasNameAndIdDTO view = new HasNameAndIdDTO.Builder("id_view_deploy_bikesonline", "").build();
			HasNameAndIdDTO source = null;
			HasNameAndIdDTO dest = null;
			if ("destination".equals(sourceOrDest)) { // wrong "destination"
				source = new HasNameAndIdDTO.Builder("id_comp_deploy_prod_gui_admin_bikesonline_1", "").build();
				dest = new HasNameAndIdDTO.Builder("id_comp_deploy_prod_gui_admin_bikesonline_1", "").build();
			} else if ("source".equals(sourceOrDest)) {// Wrong source
				source = new HasNameAndIdDTO.Builder("id_comp_deploy_prod_services_admin_bikesonline_1", "").build();
				dest = new HasNameAndIdDTO.Builder("id_comp_deploy_prod_services_admin_bikesonline_1", "").build();
			}
			HasNameAndIdDTO link = new HasNameAndIdDTO.Builder("id_link_deploy_REST_admin", "").build();
			LinkInstanceDTO dto = ((LinkInstanceDTO.Builder) new LinkInstanceDTO.Builder("id_new_li", "new_li", view)
					.link(link).source(source).destination(dest).status("APPLICABLE")).build();
			checker.checkDTO(dto, AccessType.CREATE);
			return "PASS";
		} catch (FunctionalException ex) {
			return "FAIL with code " + ex.getCode().name();
		} catch (TechnicalException ex) {
			return "FAIL with code " + ex.getCode().name();
		}
	}

	public String checkFormat(String caseName, String vID, String id, String linkID, String name, String desc,
			String comment, String tags, String sourceID, String destinationID, String status) throws FunctionalException {
		if (!noreset) {
			reset("Bikes");
		}
		try {
			HasNameAndIdDTO link = new HasNameAndIdDTO.Builder(UUT.nul(linkID), "").build();
			HasNameAndIdDTO view = new HasNameAndIdDTO.Builder(UUT.nul(vID), "").build();
			LinkInstanceDTO.Builder dtoBuilder = new LinkInstanceDTO.Builder(UUT.nul(id), UUT.nul(name), view);
			if (UUT.nul(tags) != null) {
				for (String tag : Utils.stringListFromString(tags)) {
					dtoBuilder.addTag(tag);
				}
			}
			dtoBuilder.link(link);
			dtoBuilder.comment(UUT.nul(comment));
			dtoBuilder.description(UUT.nul(desc));
			HasNameAndIdDTO sourceDTO = new HasNameAndIdDTO.Builder(UUT.nul(sourceID), "").build();
			HasNameAndIdDTO destDTO = new HasNameAndIdDTO.Builder(UUT.nul(destinationID), "").build();
			dtoBuilder.source(sourceDTO);
			dtoBuilder.destination(destDTO);
			dtoBuilder.status(UUT.nul(status));
			checker.checkDTO(dtoBuilder.build(), AccessType.CREATE);
			return "PASS";
		} catch (FunctionalException ex) {
			return "FAIL with code " + ex.getCode().name();
		} catch (TechnicalException ex) {
			return "FAIL with code " + ex.getCode().name();
		}
	}
}
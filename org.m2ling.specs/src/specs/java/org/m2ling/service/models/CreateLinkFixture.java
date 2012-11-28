package org.m2ling.service.models;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.m2ling.common.dto.core.AccessType;
import org.m2ling.common.dto.core.HasNameAndIdDTO;
import org.m2ling.common.dto.core.LinkDTO;
import org.m2ling.common.exceptions.FunctionalException;
import org.m2ling.common.exceptions.TechnicalException;
import org.m2ling.common.utils.UUT;
import org.m2ling.common.utils.Utils;
import org.m2ling.presentation.principles.model.HasNameAndIDBean;
import org.m2ling.presentation.principles.utils.DTOConverter;
import org.m2ling.presentation.studio.model.LinkBean;

public class CreateLinkFixture extends AbstractLinkFixture {
	public CreateLinkFixture() throws IOException {
		super();
	}

	/**
	 * Create and return a link from a presentation layer bean (to test it too), then search it back
	 */
	public String createAndGetLink(String caseName, String vID, String id, String ltID, String name, String desc,
			String comment, String tags, String timeout, String sources, String destinations, String status)
			throws FunctionalException {
		if (!noreset) {
			reset("Bikes");
		}
		vID = UUT.nul(vID);
		HasNameAndIDBean view = null;
		if (vID != null){
			view = HasNameAndIDBean.newInstance(vID, "");
		}
		id = UUT.nul(id);
		name = UUT.nul(name);
		desc = UUT.nul(desc);
		comment = UUT.nul(comment);
		tags = UUT.nul(tags);
		timeout = UUT.nul(timeout);
		status = UUT.nul(status);
		ltID = UUT.nul(ltID);
		List<String> sourcesAsStrings = Utils.stringListFromString(UUT.nul(sources));
		Set<HasNameAndIDBean> sourcesList = new LinkedHashSet<HasNameAndIDBean>();
		for (String compID : sourcesAsStrings) {
			sourcesList.add(HasNameAndIDBean.newInstance(compID, ""));
		}
		List<String> destinationsAsStrings = Utils.stringListFromString(UUT.nul(destinations));
		Set<HasNameAndIDBean> destinationsList = new LinkedHashSet<HasNameAndIDBean>();
		for (String compID : destinationsAsStrings) {
			destinationsList.add(HasNameAndIDBean.newInstance(compID, ""));
		}
		LinkBean bean = new LinkBean();
		bean.setComment(comment);
		bean.setDescription(desc);
		bean.setId(id);
		bean.setTimeoutMillis(Long.parseLong(timeout));
		bean.setName(name);
		bean.setSources(sourcesList);
		bean.setDestinations(destinationsList);
		bean.setTags(tags);
		bean.setStatus(status);
		bean.setType(HasNameAndIDBean.newInstance(ltID, ""));
		bean.setView(view);
		LinkDTO dto = new DTOConverter.ToDTO().getLinkDTO(bean);
		try {
			service.createLink(null, dto);
			List<LinkDTO> linkDTOS = service.getAllLinks(null, vID);
			for (LinkDTO linkDTO : linkDTOS) {
				if (linkDTO.getId().equals(bean.getId())) {
					LinkBean out = new DTOConverter.FromDTO().getLinkBean(linkDTO);
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

	public String testNoneSourceOrDest(String sourceOrDest) {
		if (!noreset) {
			reset("Bikes"); 
		}
		try {
			HasNameAndIdDTO view = new HasNameAndIdDTO.Builder("id_view_vp_logical_Logical_BikesOnline", "").build();
			HasNameAndIdDTO type = new HasNameAndIdDTO.Builder("id_lt_logical_http_rest", "").build();
			HasNameAndIdDTO source = new HasNameAndIdDTO.Builder("id_comp_view_Logical_BikesOnline_AdminGUI", "").build();
			HasNameAndIdDTO dest = new HasNameAndIdDTO.Builder("id_comp_view_Logical_BikesOnline_AdminServices", "")
					.build();
			LinkDTO.Builder builder = ((LinkDTO.Builder) new LinkDTO.Builder("id_new_link", "new_link", view).type(type));
			LinkDTO dto = null;
			if ("destination".equals(sourceOrDest)) { // no "destination", we add the source
				builder.addSource(source);
			} else if ("source".equals(sourceOrDest)) {
				builder.addDestination(dest);
			}
			builder.status("APPLICABLE");
			dto = builder.build();
			service.checkDTO(dto, AccessType.CREATE);
			return "PASS";
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
			HasNameAndIdDTO view = new HasNameAndIdDTO.Builder("id_view_vp_logical_Logical_BikesOnline", "").build();
			HasNameAndIdDTO source = null;
			HasNameAndIdDTO dest = null;
			if ("destination".equals(sourceOrDest)) { // wrong "destination"
				source = new HasNameAndIdDTO.Builder("id_comp_view_Logical_BikesOnline_AdminGUI", "").build();
				dest = new HasNameAndIdDTO.Builder("id_comp_view_Logical_BikesOnline_EndUserGUI", "").build();
			} else if ("source".equals(sourceOrDest)) {// Wrong source
				source = new HasNameAndIdDTO.Builder("id_comp_view_Logical_BikesOnline_AdminServices", "").build();
				dest = new HasNameAndIdDTO.Builder("id_comp_view_Logical_BikesOnline_AdminGUI", "").build();
			}
			HasNameAndIdDTO type = new HasNameAndIdDTO.Builder("id_lt_logical_http_rest", "").build();
			LinkDTO dto = ((LinkDTO.Builder) new LinkDTO.Builder("id_new_link", "new_link",view).type(type).addSource(source)
					.addDestination(dest).status("APPLICABLE")).build();
			service.checkDTO(dto, AccessType.CREATE);
			return "PASS";
		} catch (FunctionalException ex) {
			return "FAIL with code " + ex.getCode().name();
		} catch (TechnicalException ex) {
			return "FAIL with code " + ex.getCode().name();
		}
	}

	public String checkFormat(String caseName, String vID, String id, String ltID, String name, String desc,
			String comment, String tags, String timeout, String sources, String destinations, String status)
			throws FunctionalException {
		if (!noreset) {
			reset("Bikes");
		}
		try {
			HasNameAndIdDTO type = new HasNameAndIdDTO.Builder(UUT.nul(ltID), "").build();
			HasNameAndIdDTO view = new HasNameAndIdDTO.Builder(UUT.nul(vID), "").build();
			LinkDTO.Builder dtoBuilder = new LinkDTO.Builder(UUT.nul(id), UUT.nul(name),view);
			if (UUT.nul(tags) != null) {
				for (String tag : Utils.stringListFromString(tags)) {
					dtoBuilder.addTag(tag);
				}
			}
			dtoBuilder.type(type);
			dtoBuilder.comment(UUT.nul(comment));
			dtoBuilder.description(UUT.nul(desc));
			dtoBuilder.timeoutMillis(Long.parseLong(timeout));
			List<String> sourcesAsStrings = Utils.stringListFromString(UUT.nul(sources));
			for (String compID : sourcesAsStrings) {
				dtoBuilder.addSource(new HasNameAndIdDTO.Builder(compID, "").build());
			}
			List<String> destinationsAsStrings = Utils.stringListFromString(UUT.nul(destinations));
			for (String compID : destinationsAsStrings) {
				dtoBuilder.addDestination(new HasNameAndIdDTO.Builder(compID, "").build());
			}
			dtoBuilder.status(UUT.nul(status));
			service.checkDTO(dtoBuilder.build(), AccessType.CREATE);
			return "PASS";
		} catch (FunctionalException ex) {
			return "FAIL with code " + ex.getCode().name();
		} catch (TechnicalException ex) {
			return "FAIL with code " + ex.getCode().name();
		}
	}
}
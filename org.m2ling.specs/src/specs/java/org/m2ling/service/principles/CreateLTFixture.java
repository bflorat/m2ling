package org.m2ling.service.principles;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.m2ling.common.dto.core.AccessType;
import org.m2ling.common.dto.core.HasNameAndIdDTO;
import org.m2ling.common.dto.core.LinkTypeDTO;
import org.m2ling.common.exceptions.FunctionalException;
import org.m2ling.common.exceptions.TechnicalException;
import org.m2ling.common.utils.UUT;
import org.m2ling.common.utils.Utils;
import org.m2ling.presentation.principles.model.HasNameAndIDBean;
import org.m2ling.presentation.principles.model.LinkTypeBean;
import org.m2ling.presentation.principles.utils.DTOConverter;

public class CreateLTFixture extends AbstractLTFixture {
	public CreateLTFixture() throws IOException {
		super();
	}

	/**
	 * Create and return a link type from a presentation layer bean (to test it too), then search it
	 * back
	 * 
	 * @param bean
	 * @param name
	 * @return
	 * @throws FunctionalException
	 * @throws NoSuchFieldException
	 * @throws IllegalAccessException
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 */
	public String createAndGetLT(String justCheck, String caseName, String vpID, String id, String name, String desc,
			String comment, String tags, String accessType, String temporality, String sourcesTypes,
			String destinationsTypes, String status) throws FunctionalException {
		if (!noreset) {
			reset("Bikes");
		}
		vpID = UUT.nul(vpID);
		id = UUT.nul(id);
		name = UUT.nul(name);
		desc = UUT.nul(desc);
		comment = UUT.nul(comment);
		tags = UUT.nul(tags);
		accessType = UUT.nul(accessType);
		temporality = UUT.nul(temporality);
		status = UUT.nul(status);
		List<String> sourcesTypesAsStrings = Utils.stringListFromString(UUT.nul(sourcesTypes));
		Set<HasNameAndIDBean> sourcesTypesList = new LinkedHashSet<HasNameAndIDBean>();
		for (String ctID : sourcesTypesAsStrings) {
			sourcesTypesList.add(HasNameAndIDBean.newInstance(ctID, ""));
		}
		List<String> destinationsTypesAsStrings = Utils.stringListFromString(UUT.nul(destinationsTypes));
		Set<HasNameAndIDBean> destinationsTypesList = new LinkedHashSet<HasNameAndIDBean>();
		for (String ctID : destinationsTypesAsStrings) {
			destinationsTypesList.add(HasNameAndIDBean.newInstance(ctID, ""));
		}
		LinkTypeBean bean = new LinkTypeBean();
		bean.setComment(comment);
		bean.setDescription(desc);
		bean.setDestinationsTypes(destinationsTypesList);
		bean.setId(id);
		bean.setLinkAccessType(accessType);
		bean.setName(name);
		bean.setSourcesTypes(sourcesTypesList);
		bean.setTags(tags);
		bean.setStatus(status);
		bean.setLinkTemporality(temporality);
		bean.setViewPoint(HasNameAndIDBean.newInstance(vpID, ""));
		LinkTypeDTO dto = new DTOConverter.ToDTO().getLinkTypeDTO(bean);
		try {
			service.createLT(null, dto);
			List<LinkTypeDTO> ltDTOS = service.getAllLT(null, vpID);
			for (LinkTypeDTO ltDTO : ltDTOS) {
				if (ltDTO.getId().equals(bean.getId())) {
					LinkTypeBean out = new DTOConverter.FromDTO().getLinkTypeBean(ltDTO);
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

	public String checkFormat(String caseName, String vpID, String id, String name, String desc, String comment,
			String tags, String accessType, String temporality, String sourcesTypes, String destinationsTypes,
			String status) throws FunctionalException {
		if (!noreset) {
			reset("Bikes");
		}
		try {
			HasNameAndIdDTO vp = new HasNameAndIdDTO.Builder(vpID, "").build();
			LinkTypeDTO.Builder dtoBuilder = new LinkTypeDTO.Builder(vp, UUT.nul(id), UUT.nul(name));
			if (UUT.nul(tags) != null) {
				for (String tag : Utils.stringListFromString(tags)) {
					dtoBuilder.addTag(tag);
				}
			}
			dtoBuilder.comment(UUT.nul(comment));
			dtoBuilder.description(UUT.nul(desc));
			dtoBuilder.linkAccessType(UUT.nul(accessType)).linkTemporality(UUT.nul(temporality));
			List<String> sourcesTypesAsStrings = Utils.stringListFromString(UUT.nul(sourcesTypes));
			for (String ctID : sourcesTypesAsStrings) {
				dtoBuilder.addSourcesType(new HasNameAndIdDTO.Builder(ctID, "").build());
			}
			List<String> destinationsTypesAsStrings = Utils.stringListFromString(UUT.nul(destinationsTypes));
			for (String ctID : destinationsTypesAsStrings) {
				dtoBuilder.addDestinationsType(new HasNameAndIdDTO.Builder(ctID, "").build());
			}
			dtoBuilder.status(UUT.nul(status));
			checker.checkDTO(dtoBuilder.build(), AccessType.CREATE);
			return "PASS";
		} catch (FunctionalException ex) {
			return "FAIL with code " + ex.getCode().name();
		} catch (TechnicalException ex) {
			return "FAIL with code " + ex.getCode().name();
		}
	}

	public String testNoneSource() {
		if (!noreset) {
			reset("Bikes");
		}
		try {
			HasNameAndIdDTO vp = new HasNameAndIdDTO.Builder("id_vp_logical", "").build();
			HasNameAndIdDTO dest = new HasNameAndIdDTO.Builder("id_ct_logical_servicemodule", "ct_logical_servicemodule")
					.build();
			LinkTypeDTO dto = ((LinkTypeDTO.Builder) new LinkTypeDTO.Builder(vp, "id_lt_logical_lt1", "lt1")
					.linkAccessType("RW").linkTemporality("SYNC").addDestinationsType(dest).description("desc")).build();
			service.createLT(null, dto);
			return "Unknown item";
		} catch (FunctionalException ex) {
			return "FAIL with code " + ex.getCode().name();
		} catch (TechnicalException ex) {
			return "FAIL with code " + ex.getCode().name();
		}
	}

	public String testNoneDest() {
		if (!noreset) {
			reset("Bikes");
		}
		try {
			HasNameAndIdDTO vp = new HasNameAndIdDTO.Builder("id_vp_logical", "").build();
			HasNameAndIdDTO source = new HasNameAndIdDTO.Builder("id_ct_logical_guimodule", "").build();
			LinkTypeDTO dto = ((LinkTypeDTO.Builder) (new LinkTypeDTO.Builder(vp, "id_lt_logical_lt1", "lt1").linkAccessType("RW")
					.linkTemporality("SYNC").addSourcesType(source)).description("desc")).build();
			service.createLT(null, dto);
			return "Unknown item";
		} catch (FunctionalException ex) {
			return "FAIL with code " + ex.getCode().name();
		} catch (TechnicalException ex) {
			return "FAIL with code " + ex.getCode().name();
		}
	}
}
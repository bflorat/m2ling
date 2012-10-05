package org.m2ling.service.principles;

import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.m2ling.common.dto.core.HasNameAndIdDTO;
import org.m2ling.common.dto.core.LinkTypeDTO;
import org.m2ling.common.exceptions.FunctionalException;
import org.m2ling.common.utils.UUT;
import org.m2ling.common.utils.Utils;
import org.m2ling.presentation.principles.LinkTemporality;

public class UpdateLTFixture extends AbstractLTFixture {
	public UpdateLTFixture() throws IOException {
		super();
	}

	@Test
	public String updateLT(String caseName, String id, String sourcesTypes, String destinationsTypes) {
		try {
			reset("Technical");
			// use the id as name
			HasNameAndIdDTO vp = new HasNameAndIdDTO.Builder("id_vp1", "").build();
			LinkTypeDTO.Builder dtoBuilder = new LinkTypeDTO.Builder(vp, UUT.nul(id), UUT.nul(id));
			dtoBuilder.linkAccessType(LinkAccessType.RW.name());
			dtoBuilder.linkTemporality(LinkTemporality.SYNC.name());
			dtoBuilder.description("desc");
			List<String> sourcesTypesAsStrings = Utils.stringListFromString(UUT.nul(sourcesTypes));
			for (String ctID : sourcesTypesAsStrings) {
				dtoBuilder.addSourcesType(new HasNameAndIdDTO.Builder(ctID, "").build());
			}
			List<String> destinationsTypesAsStrings = Utils.stringListFromString(UUT.nul(destinationsTypes));
			for (String ctID : destinationsTypesAsStrings) {
				dtoBuilder.addDestinationsType(new HasNameAndIdDTO.Builder(ctID, "").build());
			}
			service.updateLT(null, dtoBuilder.build());
			return "PASS";
		} catch (FunctionalException fe) {
			return "FAIL with code " + fe.getCode().name();
		}
	}
}

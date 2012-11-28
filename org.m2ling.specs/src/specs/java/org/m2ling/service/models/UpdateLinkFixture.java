package org.m2ling.service.models;

import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.m2ling.common.dto.core.HasNameAndIdDTO;
import org.m2ling.common.dto.core.LinkDTO;
import org.m2ling.common.exceptions.FunctionalException;
import org.m2ling.common.utils.UUT;
import org.m2ling.common.utils.Utils;

public class UpdateLinkFixture extends AbstractLinkFixture {
	public UpdateLinkFixture() throws IOException {
		super();
	}

	@Test
	public String updateLink(String caseName, String id, String sources, String destinations) {
		try {
			reset("Technical");
			// reuse existing values
			LinkDTO oldLink = service.getLinkByID(null, id);
			LinkDTO.Builder dtoBuilder = new LinkDTO.Builder( oldLink.getId(), oldLink.getName(), null);
			dtoBuilder.description(oldLink.getDescription());
			dtoBuilder.comment(oldLink.getComment());
			dtoBuilder.status(oldLink.getStatus());
			for (String tag : oldLink.getTags()) {
				dtoBuilder.addTag(tag);
			}
			dtoBuilder.timeoutMillis(oldLink.getTimeoutMillis());
			List<String> sourcesAsStrings = Utils.stringListFromString(UUT.nul(sources));
			for (String compID : sourcesAsStrings) {
				dtoBuilder.addSource(new HasNameAndIdDTO.Builder(compID, "").build());
			}
			List<String> destinationsAsStrings = Utils.stringListFromString(UUT.nul(destinations));
			for (String compID : destinationsAsStrings) {
				dtoBuilder.addDestination(new HasNameAndIdDTO.Builder(compID, "").build());
			}
			service.updateLink(null, dtoBuilder.build());
			return "PASS";
		} catch (FunctionalException fe) {
			return "FAIL with code " + fe.getCode().name();
		}
	}
}

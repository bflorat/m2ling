package org.m2ling.service.models;

import java.io.IOException;

import org.m2ling.common.dto.core.AccessType;
import org.m2ling.common.dto.core.ComponentInstanceDTO;
import org.m2ling.common.dto.core.HasNameAndIdDTO;
import org.m2ling.common.dto.core.ReferenceDTO;
import org.m2ling.common.exceptions.FunctionalException;
import org.m2ling.common.exceptions.TechnicalException;
import org.m2ling.common.utils.UUT;

public class UpdateCIFixture extends AbstractCIFixture {
	public UpdateCIFixture() throws IOException {
		super();
	}

	public String updateBinding(String caseName, String ciID, String boundID) {
		if (!noreset) {
			reset("Technical");
		}
		ciID = UUT.nul(ciID);
		boundID = UUT.nul(boundID);
		try {
			// Reuse existing attributes to avoid changing out-of scope attributes
			ComponentInstanceDTO ciDTO = service.getCIByID(null, ciID);
			ComponentInstanceDTO.Builder builder = new ComponentInstanceDTO.Builder(ciID, ciDTO.getName(), null);
			for (String tag : ciDTO.getTags()) {
				builder.addTag(tag);
			}
			builder.comment(ciDTO.getComment());
			builder.description(ciDTO.getDescription());
			builder.status(ciDTO.getStatus());
			for (ReferenceDTO ref : ciDTO.getReferences()) {
				builder.addReference(ref);
			}
			builder.boundInstance(new HasNameAndIdDTO.Builder(boundID, "").build());
			builder.component(ciDTO.getComponent());
			service.checkDTO(builder.build(), AccessType.UPDATE);
			return "PASS";
		} catch (FunctionalException ex) {
			return "FAIL with code " + ex.getCode().name();
		} catch (TechnicalException ex) {
			return "FAIL with code " + ex.getCode().name();
		}
	}

	public String updateReference(String sourceCiID, String references, String viewID) {
		if (!noreset) {
			reset("Technical");
		}
		try {
			// Reuse existing attributes to avoid changing out-of scope attributes
			ComponentInstanceDTO ciDTO = service.getCIByID(null, sourceCiID);
			ComponentInstanceDTO.Builder builder = new ComponentInstanceDTO.Builder(ciDTO.getId(), ciDTO.getName(), null);
			for (String tag : ciDTO.getTags()) {
				builder.addTag(tag);
			}
			builder.comment(ciDTO.getComment());
			builder.description(ciDTO.getDescription());
			builder.status(ciDTO.getStatus());
			setDTOReferences(builder, references);
			builder.component(ciDTO.getComponent());
			builder.boundInstance(ciDTO.getBoundInstance());
			service.checkDTO(builder.build(), AccessType.UPDATE);
			return "PASS";
		} catch (FunctionalException ex) {
			return "FAIL with code " + ex.getCode().name();
		} catch (TechnicalException ex) {
			return "FAIL with code " + ex.getCode().name();
		}
	}
}

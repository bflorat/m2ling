package org.m2ling.service.models;

import java.io.IOException;

import org.m2ling.common.dto.core.AccessType;
import org.m2ling.common.dto.core.ComponentDTO;
import org.m2ling.common.dto.core.HasNameAndIdDTO;
import org.m2ling.common.dto.core.ReferenceDTO;
import org.m2ling.common.exceptions.FunctionalException;
import org.m2ling.common.exceptions.TechnicalException;
import org.m2ling.common.utils.UUT;

public class UpdateComponentFixture extends AbstractComponentFixture {
	public UpdateComponentFixture() throws IOException {
		super();
	}

	public String updateBinding(String caseName, String compID, String boundID) {
		if (!noreset) {
			reset("Technical");
		}
		compID = UUT.nul(compID);
		boundID = UUT.nul(boundID);
		try {
			// Reuse existing attributes to avoid changing out-of scope attributes
			ComponentDTO compDTO = service.getComponentByID(null, compID);
			ComponentDTO.Builder builder = new ComponentDTO.Builder(compID, compDTO.getName());
			for (String tag : compDTO.getTags()) {
				builder.addTag(tag);
			}
			builder.comment(compDTO.getComment());
			builder.description(compDTO.getDescription());
			builder.status(compDTO.getStatus());
			for (ReferenceDTO ref : compDTO.getReferences()) {
				builder.addReference(ref);
			}
			builder.boundType(new HasNameAndIdDTO.Builder(boundID, "").build());
			builder.type(compDTO.getComponentType());
			service.checkDTO(builder.build(), "id_vp2_v2", AccessType.UPDATE);
			return "PASS";
		} catch (FunctionalException ex) {
			return "FAIL with code " + ex.getCode().name();
		} catch (TechnicalException ex) {
			return "FAIL with code " + ex.getCode().name();
		}
	}

	public String updateReferenceStillCI() {
		if (!noreset) {
			reset("Bikes");
		}
		try {
			// Reuse existing attributes to avoid changing out-of scope attributes
			ComponentDTO compDTO = service.getComponentByID(null, "id_comp_deploy_IBM_HS21");
			ComponentDTO.Builder builder = new ComponentDTO.Builder(compDTO.getId(), compDTO.getName());
			for (String tag : compDTO.getTags()) {
				builder.addTag(tag);
			}
			builder.comment(compDTO.getComment());
			builder.description(compDTO.getDescription());
			builder.status(compDTO.getStatus());
			// No reference set : we try to drop them
			if (compDTO.getBoundComponent() != null) {
				builder.boundType(new HasNameAndIdDTO.Builder(compDTO.getBoundComponent().getId(), "").build());
			}
			builder.type(compDTO.getComponentType());
			service.checkDTO(builder.build(), "id_vp2_v2", AccessType.UPDATE);
			return "PASS";
		} catch (FunctionalException ex) {
			return "FAIL with code " + ex.getCode().name();
		} catch (TechnicalException ex) {
			return "FAIL with code " + ex.getCode().name();
		}
	}

	public String updateReferenceNoCI() {
		if (!noreset) {
			reset("Bikes");
		}
		try {
			// Reuse existing attributes to avoid changing out-of scope attributes
			ComponentDTO compDTO = service.getComponentByID(null, "id_comp_tech_Linux3");
			ComponentDTO.Builder builder = new ComponentDTO.Builder(compDTO.getId(), compDTO.getName());
			for (String tag : compDTO.getTags()) {
				builder.addTag(tag);
			}
			builder.comment(compDTO.getComment());
			builder.description(compDTO.getDescription());
			builder.status(compDTO.getStatus());
			// No reference set : we try to drop them
			if (compDTO.getBoundComponent() != null) {
				builder.boundType(new HasNameAndIdDTO.Builder(compDTO.getBoundComponent().getId(), "").build());
			}
			builder.type(compDTO.getComponentType());
			service.checkDTO(builder.build(), "id_view_tech_catalog", AccessType.UPDATE);
			return "PASS";
		} catch (FunctionalException ex) {
			return "FAIL with code " + ex.getCode().name();
		} catch (TechnicalException ex) {
			return "FAIL with code " + ex.getCode().name();
		}
	}

	public String updateReference(String sourceCompID, String references, String viewID) {
		if (!noreset) {
			reset("Bikes");
		}
		try {
			// Reuse existing attributes to avoid changing out-of scope attributes
			ComponentDTO compDTO = service.getComponentByID(null, sourceCompID);
			ComponentDTO.Builder builder = new ComponentDTO.Builder(compDTO.getId(), compDTO.getName());
			for (String tag : compDTO.getTags()) {
				builder.addTag(tag);
			}
			builder.comment(compDTO.getComment());
			builder.description(compDTO.getDescription());
			builder.status(compDTO.getStatus());
			setDTOReferences(builder, references);
			builder.type(compDTO.getComponentType());
			builder.boundType(compDTO.getBoundComponent());
			service.checkDTO(builder.build(), viewID, AccessType.UPDATE);
			return "PASS";
		} catch (FunctionalException ex) {
			return "FAIL with code " + ex.getCode().name();
		} catch (TechnicalException ex) {
			return "FAIL with code " + ex.getCode().name();
		}
	}
}

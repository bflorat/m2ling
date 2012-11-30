package org.m2ling.service.models;

import java.io.IOException;

import org.m2ling.common.dto.core.HasNameAndIdDTO;
import org.m2ling.common.dto.core.LinkInstanceDTO;
import org.m2ling.common.exceptions.FunctionalException;
import org.m2ling.common.exceptions.TechnicalException;

public class UpdateLinkInstanceFixture extends AbstractLinkInstanceFixture {
	public UpdateLinkInstanceFixture() throws IOException {
		super();
	}

	public String testMissingSourceOrDest(String sourceOrDest) {
		if (!noreset) {
			reset("Bikes");
		}
		try {
			LinkInstanceDTO oldLIDTO = service.getLinkInstanceByID(null, "id_li_physical_cable1");
			HasNameAndIdDTO view = new HasNameAndIdDTO.Builder(oldLIDTO.getView().getId(), "").build();
			HasNameAndIdDTO source = null;
			HasNameAndIdDTO dest = null;
			if ("destination".equals(sourceOrDest)) { // no "destination"
				source = new HasNameAndIdDTO.Builder("id_li_physical_routeur1", "").build();
				dest = null;
			} else if ("source".equals(sourceOrDest)) {// no source
				source = null;
				dest = new HasNameAndIdDTO.Builder("id_li_physical_fw1", "").build();
			}
			HasNameAndIdDTO link = new HasNameAndIdDTO.Builder(oldLIDTO.getLink().getId(), "").build();
			LinkInstanceDTO dto = ((LinkInstanceDTO.Builder) new LinkInstanceDTO.Builder(oldLIDTO.getId(), oldLIDTO.getName(), view)
					.link(link).source(source).destination(dest).status(oldLIDTO.getStatus())).build();
			service.updateLinkInstance(null, dto);
			return "PASS";
		} catch (FunctionalException ex) {
			return "FAIL with code " + ex.getCode().name();
		} catch (TechnicalException ex) {
			return "FAIL with code " + ex.getCode().name();
		}
	}

	public String testWrongSourceOrDest(String sourceOrDest) {
		if (!noreset) {
			reset("Bikes");
		}
		try {
			LinkInstanceDTO oldLIDTO = service.getLinkInstanceByID(null, "id_li_physical_cable1");
			HasNameAndIdDTO view = new HasNameAndIdDTO.Builder(oldLIDTO.getView().getId(), "").build();
			HasNameAndIdDTO source = null; 
			HasNameAndIdDTO dest = null;
			if ("destination".equals(sourceOrDest)) { // wrong "destination"
				source = new HasNameAndIdDTO.Builder("id_li_physical_routeur1", "").build();
				dest = new HasNameAndIdDTO.Builder("id_ci_deploy_OS_HS21_1", "").build();
			} else if ("source".equals(sourceOrDest)) {// wrong source
				source = new HasNameAndIdDTO.Builder("id_ci_deploy_OS_HS21_1", "").build();
				dest = new HasNameAndIdDTO.Builder("id_li_physical_fw1", "").build();
			}
			HasNameAndIdDTO link = new HasNameAndIdDTO.Builder(oldLIDTO.getLink().getId(), "").build();
			LinkInstanceDTO dto = ((LinkInstanceDTO.Builder) new LinkInstanceDTO.Builder(oldLIDTO.getId(), oldLIDTO.getName(), view)
					.link(link).source(source).destination(dest).status(oldLIDTO.getStatus())).build();
			service.updateLinkInstance(null, dto); 
			return "PASS";
		} catch (FunctionalException ex) {
			return "FAIL with code " + ex.getCode().name();
		} catch (TechnicalException ex) {
			return "FAIL with code " + ex.getCode().name();
		}
	}
}

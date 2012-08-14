package org.m2ling.service.principles;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.m2ling.common.configuration.Conf;
import org.m2ling.common.dto.core.AccessType;
import org.m2ling.common.dto.core.ViewPointDTO;
import org.m2ling.common.exceptions.FunctionalException;
import org.m2ling.common.utils.UUT;
import org.m2ling.common.utils.Utils;
import org.m2ling.persistence.PersistenceManagerXMIImpl;
import org.m2ling.service.util.CoreUtil;
import org.m2ling.service.util.DTOConverter.FromDTO;
import org.m2ling.service.util.DTOConverter.ToDTO;
import org.m2ling.specs.M2lingFixture;

public class SearchViewPointFixture extends M2lingFixture {
	ViewPointServiceImpl service;

	public SearchViewPointFixture() throws IOException {
		super();
	}

	/**
	 * Make sure to instanciate a new pm at each test case so we reset the content to the
	 * Technical.m2ling content
	 */
	public void reset() {
		String sampleXMI = "src/specs/resources/mocks/Technical.m2ling";
		Properties prop = new Properties();
		prop.setProperty(PersistenceManagerXMIImpl.SpecificConfiguration.CONF_XMI_PATH, sampleXMI);
		Conf configuration = new Conf(prop, logger, null);
		PersistenceManagerXMIImpl pm;
		try {
			pm = new PersistenceManagerXMIImpl(logger, configuration);
			CoreUtil util = new CoreUtil(logger, pm);
			service = new ViewPointServiceImpl(pm, util, new FromDTO(util), new ToDTO(util), configuration, logger);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getAll() throws FunctionalException {
		reset();
		return "" + service.getAllViewPoints(null).size();
	}

	public String getVpByID(String id) {
		reset();
		return service.getViewPointByID(null, id).getName();
	}

	public String getVpByName(String name) {
		reset();
		return service.getViewPointByName(null, name).getId();
	}

	/**
	 * Return "PASS" or "FAIL" according to result of checkDTO()
	 * 
	 * @param dto
	 * @return "PASS" or "FAIL" according to result of checkDTO()
	 */
	public String getCheckDTOVerification(String id, String name, String description, String comment, String tags,
			String statusLiterals) {
		reset();
		try {
			List<String> tagsList = null;
			if (!tags.equals("null")) {
				tagsList = Utils.stringListFromString(tags);
			}
			List<String> status = null;
			if (!"null".equals(status)) {
				status = Utils.stringListFromString(statusLiterals);
			}
			ViewPointDTO dto = new ViewPointDTO.Builder(UUT.nul(id), UUT.nul(name)).description(UUT.nul(description))
					.tags(tagsList).comment(UUT.nul(comment)).statusLiterals(status).build();
			service.checkDTO(dto, AccessType.CREATE);
			return "PASS";
		} catch (FunctionalException ex) {
			return "FAIL";
		}
	}

	public String getCheckNullDTO() {
		reset();
		try {
			service.checkDTO(null, AccessType.CREATE);
			return "PASS";
		} catch (FunctionalException ex) {
			return "FAIL";
		}
	}
}

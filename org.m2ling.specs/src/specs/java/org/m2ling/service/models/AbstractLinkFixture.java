package org.m2ling.service.models;

import java.io.IOException;
import java.util.Properties;

import org.m2ling.common.configuration.Conf;
import org.m2ling.common.dto.core.AccessType;
import org.m2ling.common.exceptions.FunctionalException;
import org.m2ling.persistence.PersistenceManagerXMIImpl;
import org.m2ling.service.common.ReferenceHelper;
import org.m2ling.service.util.DomainExplorer;
import org.m2ling.service.util.DTOConverter.FromDTO;
import org.m2ling.service.util.DTOConverter.ToDTO;
import org.m2ling.specs.M2lingFixture;

public class AbstractLinkFixture extends M2lingFixture {
	LinkServiceImpl service;
	LinkServiceChecker checker;

	boolean noreset = false;

	public AbstractLinkFixture() throws IOException {
		super();
	}

	public String getCheckNullDTO() {
		reset("Technical");
		try {
			checker.checkDTO(null, AccessType.CREATE);
			return "PASS";
		} catch (FunctionalException ex) {
			return "FAIL";
		}
	}

	/**
	 * Make sure to instantiate a new pm at each test case so we reset the content
	 */
	public void reset(String model) {
		String sampleXMI = "src/specs/resources/mocks/" + model + ".m2ling";
		Properties prop = new Properties();
		prop.setProperty(PersistenceManagerXMIImpl.SpecificConfiguration.CONF_XMI_PATH, sampleXMI);
		prop.setProperty(PersistenceManagerXMIImpl.SpecificConfiguration.CONF_DISABLE_COMMITS, "true");
		Conf configuration = new Conf(prop, logger, null);
		PersistenceManagerXMIImpl pm;
		try {
			pm = new PersistenceManagerXMIImpl(logger, configuration);
			DomainExplorer explorer = new DomainExplorer(logger, pm);
			ReferenceHelper refHelper = new ReferenceHelper(explorer);
			FromDTO fromDTO = new FromDTO(explorer);
			checker = new LinkServiceChecker(pm, explorer, fromDTO, refHelper);
			service = new LinkServiceImpl(pm, explorer, new FromDTO(explorer), new ToDTO(explorer), configuration, logger, checker);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

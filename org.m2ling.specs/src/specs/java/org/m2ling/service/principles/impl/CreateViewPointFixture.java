package org.m2ling.service.principles.impl;

import java.io.IOException;
import java.util.Properties;

import org.m2ling.common.configuration.Configuration;
import org.m2ling.common.dto.core.ViewPointDTO;
import org.m2ling.common.exceptions.FunctionalException;
import org.m2ling.persistence.impl.PersistenceManagerXMIImpl;
import org.m2ling.service.principles.ViewPointService;
import org.m2ling.service.util.CoreUtil;
import org.m2ling.service.util.DTOConverter.FromDTO;
import org.m2ling.service.util.DTOConverter.ToDTO;
import org.m2ling.specs.M2lingFixture;

public class CreateViewPointFixture extends M2lingFixture {
	ViewPointService service;

	public CreateViewPointFixture() throws IOException {
		super();
		String sampleXMI = "src/specs/resources/mocks/Technical.m2ling";
		Properties prop = new Properties();
		prop.setProperty(PersistenceManagerXMIImpl.SpecificConfiguration.CONF_XMI_PATH, sampleXMI);
		Configuration configuration = new Configuration(prop, logger);
		PersistenceManagerXMIImpl pm = new PersistenceManagerXMIImpl(logger, configuration);
		CoreUtil util = new CoreUtil(logger, pm);
		service = new ViewPointServiceImpl(pm, util, new FromDTO(util), new ToDTO(util), configuration, logger);
	}

	/**
	 * Create a viewpoint and return its name
	 * 
	 * @return the new viewpoint name
	 * @throws FunctionalException
	 */
	public String getViewPointName(String id, String name) throws FunctionalException {
		ViewPointDTO dto = new ViewPointDTO.Builder(id, name).build();
		service.createViewPoint(null,dto);
		ViewPointDTO checkedDTO = service.getViewPointByName(null,name);
		return checkedDTO.getName();
	}
}

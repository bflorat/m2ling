package org.m2ling.service.principles;

import java.io.IOException;
import java.util.Properties;

import org.m2ling.common.configuration.Conf;
import org.m2ling.common.dto.core.ViewPointDTO;
import org.m2ling.common.exceptions.FunctionalException;
import org.m2ling.persistence.PersistenceManagerXMIImpl;
import org.m2ling.service.util.CoreUtil;
import org.m2ling.service.util.DTOConverter.FromDTO;
import org.m2ling.service.util.DTOConverter.ToDTO;
import org.m2ling.specs.M2lingFixture;

public class DeleteViewPointFixture extends M2lingFixture {
	ViewPointServiceImpl service;
	PersistenceManagerXMIImpl pm;

	public DeleteViewPointFixture() throws IOException {
		super();
	}

	public void reset() {
		String sampleXMI = "src/specs/resources/mocks/Technical.m2ling";
		Properties prop = new Properties();
		prop.setProperty(PersistenceManagerXMIImpl.SpecificConfiguration.CONF_XMI_PATH, sampleXMI);
		Conf configuration = new Conf(prop, logger, null);
		try {
			pm = new PersistenceManagerXMIImpl(logger, configuration);
			CoreUtil util = new CoreUtil(logger, pm);
			service = new ViewPointServiceImpl(pm, util, new FromDTO(util), new ToDTO(util), configuration, logger);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String deleteWithoutRefs(String id) throws FunctionalException {
		try {
			reset();
			// Drop references in presets
			pm.getRoot().getViews().remove(0);
			pm.getRoot().getViews().remove(0);
			service.deleteViewPoint(null, id);
			ViewPointDTO found = service.getViewPointByID(null, id);
			return (found == null) ? "null" : found.toString();
		} catch (FunctionalException fe) {
			return "FAIL with code " + fe.getCode().name();
		}
	}

	public String deleteWithLocalComp(String id) throws FunctionalException {
		try {
			reset();
			service.deleteViewPoint(null, id);
			ViewPointDTO found = service.getViewPointByID(null, id);
			return (found == null) ? "null" : found.toString();
		} catch (FunctionalException fe) {
			return "FAIL with code " + fe.getCode().name();
		}
	}

	public String deleteWithBinding(String id) throws FunctionalException {
		try {
			reset();
			// remove view1 so we only test view2 not using vp1
			pm.getRoot().getViews().remove(0);
			service.deleteViewPoint(null, id);
			ViewPointDTO found = service.getViewPointByID(null, id);
			return (found == null) ? "null" : found.toString();
		} catch (FunctionalException fe) {
			return "FAIL with code " + fe.getCode().name();
		}
	}
}

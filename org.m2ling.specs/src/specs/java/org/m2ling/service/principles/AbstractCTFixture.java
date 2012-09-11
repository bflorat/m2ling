package org.m2ling.service.principles;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.StringTokenizer;

import org.m2ling.common.configuration.Conf;
import org.m2ling.common.dto.core.AccessType;
import org.m2ling.common.dto.core.ComponentTypeDTO;
import org.m2ling.common.exceptions.FunctionalException;
import org.m2ling.common.exceptions.TechnicalException;
import org.m2ling.common.utils.UUT;
import org.m2ling.common.utils.Utils;
import org.m2ling.persistence.PersistenceManagerXMIImpl;
import org.m2ling.presentation.principles.model.ComponentTypeBean;
import org.m2ling.presentation.principles.model.HasNameAndIDBean;
import org.m2ling.presentation.principles.model.ReferenceBean;
import org.m2ling.presentation.principles.utils.DTOConverter;
import org.m2ling.service.util.CoreUtil;
import org.m2ling.service.util.DTOConverter.FromDTO;
import org.m2ling.service.util.DTOConverter.ToDTO;
import org.m2ling.specs.M2lingFixture;

import com.google.common.base.Strings;

public class AbstractCTFixture extends M2lingFixture {
	ComponentTypeServiceImpl service;
	boolean noreset = false;

	public AbstractCTFixture() throws IOException {
		super();
	}

	public String getCheckNullDTO() {
		reset("Technical");
		try {
			service.checkDTO(null, AccessType.CREATE);
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
		Conf configuration = new Conf(prop, logger, null);
		PersistenceManagerXMIImpl pm;
		try {
			pm = new PersistenceManagerXMIImpl(logger, configuration);
			CoreUtil util = new CoreUtil(logger, pm);
			service = new ComponentTypeServiceImpl(pm, util, new FromDTO(util), new ToDTO(util), configuration, logger);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void setReferences(ComponentTypeBean bean, String references) {
		List<ReferenceBean> refs = new ArrayList<ReferenceBean>();
		if (Strings.isNullOrEmpty(references)) {
			bean.setReferences(refs);
		} else {
			StringTokenizer st = new StringTokenizer(references, ";");
			while (st.hasMoreTokens()) {
				String ref = st.nextToken();
				ReferenceBean refbean = new ReferenceBean();
				StringTokenizer st2 = new StringTokenizer(ref, ":");
				refbean.setType(st2.nextToken());
				String targs = st2.nextToken();
				StringTokenizer st3 = new StringTokenizer(targs, ",");
				List<HasNameAndIDBean> targets = new ArrayList<HasNameAndIDBean>();
				while (st3.hasMoreTokens()) {
					HasNameAndIDBean hsibean = new HasNameAndIDBean();
					hsibean.setId(st3.nextToken());
					// don't need to set the actual target name in the fixture
					targets.add(hsibean);
				}
				refbean.setTargets(targets);
				refs.add(refbean);
			}
			bean.setReferences(refs);
		}
	}

	
}

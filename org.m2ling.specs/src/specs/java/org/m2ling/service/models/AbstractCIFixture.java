package org.m2ling.service.models;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.StringTokenizer;

import org.m2ling.common.configuration.Conf;
import org.m2ling.common.dto.core.AccessType;
import org.m2ling.common.dto.core.ComponentInstanceDTO;
import org.m2ling.common.dto.core.HasNameAndIdDTO;
import org.m2ling.common.dto.core.ReferenceDTO;
import org.m2ling.common.exceptions.FunctionalException;
import org.m2ling.common.utils.UUT;
import org.m2ling.common.utils.Utils;
import org.m2ling.persistence.PersistenceManagerXMIImpl;
import org.m2ling.presentation.principles.model.HasNameAndIDBean;
import org.m2ling.presentation.principles.model.ReferenceBean;
import org.m2ling.presentation.studio.model.ComponentInstanceBean;
import org.m2ling.service.common.ReferenceHelper;
import org.m2ling.service.util.DomainExplorer;
import org.m2ling.service.util.DTOConverter.FromDTO;
import org.m2ling.service.util.DTOConverter.ToDTO;
import org.m2ling.specs.M2lingFixture;

public class AbstractCIFixture extends M2lingFixture {
	ComponentInstanceServiceImpl service;

	ComponentInstanceServiceChecker checker;

	boolean noreset = false;

	public AbstractCIFixture() throws IOException {
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
			checker = new ComponentInstanceServiceChecker(pm, explorer, fromDTO, refHelper);
			service = new ComponentInstanceServiceImpl(pm, explorer, new FromDTO(explorer), new ToDTO(explorer), configuration,
					logger, checker);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected void setBeanReferences(ComponentInstanceBean bean, String references) {
		List<ReferenceBean> refs = new ArrayList<ReferenceBean>();
		if (Utils.isNullOrEmptyAfterTrim(references)) {
			bean.setReferences(refs);
		} else {
			StringTokenizer st = new StringTokenizer(references, ";");
			while (st.hasMoreTokens()) {
				String ref = st.nextToken();
				ReferenceBean refbean = new ReferenceBean();
				StringTokenizer st2 = new StringTokenizer(ref, ":");
				if (st2.hasMoreTokens()) {
					refbean.setType(UUT.nul(st2.nextToken()));
				} else {
					refbean.setType(null);
					continue;
				}
				if (st2.hasMoreTokens()) {
					String targs = st2.nextToken();
					StringTokenizer st3 = new StringTokenizer(targs, ",");
					List<HasNameAndIDBean> targets = new ArrayList<HasNameAndIDBean>();
					while (st3.hasMoreTokens()) {
						HasNameAndIDBean hsibean = new HasNameAndIDBean();
						hsibean.setId(UUT.nul(st3.nextToken()));
						// don't need to set the actual target name in the fixture
						targets.add(hsibean);
					}
					refbean.setTargets(targets);
				} else {
					refbean.setTargets(null);
				}
				refs.add(refbean);
			}
			bean.setReferences(refs);
		}
	}

	protected void setDTOReferences(ComponentInstanceDTO.Builder builder, String references) {
		if (Utils.isNullOrEmptyAfterTrim(references)) {
			return;
		} else {
			StringTokenizer st = new StringTokenizer(references, ";");
			while (st.hasMoreTokens()) {
				String ref = UUT.nul(st.nextToken());
				if (ref == null) {
					builder.addReference(new ReferenceDTO.Builder(null).build());
				} else {
					StringTokenizer st2 = new StringTokenizer(ref, ":");
					ReferenceDTO.Builder refBuilder = new ReferenceDTO.Builder(UUT.nul(st2.nextToken()));
					if (st2.hasMoreTokens()) {
						String targs = UUT.nul(st2.nextToken());
						if (targs == null) {
							refBuilder.addTarget(null);
						} else {
							StringTokenizer st3 = new StringTokenizer(targs, ",");
							while (st3.hasMoreTokens()) {
								HasNameAndIdDTO targetDTO = new HasNameAndIdDTO.Builder(UUT.nul(st3.nextToken()), "").build();
								refBuilder.addTarget(targetDTO);
							}
						}
					}
					builder.addReference(refBuilder.build());
				}
			}
		}
	}
}

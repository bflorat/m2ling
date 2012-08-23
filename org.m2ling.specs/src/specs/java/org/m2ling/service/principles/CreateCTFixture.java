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
import org.m2ling.common.utils.UUT;
import org.m2ling.common.utils.Utils;
import org.m2ling.persistence.PersistenceManagerXMIImpl;
import org.m2ling.presentation.principles.model.ComponentTypeBean;
import org.m2ling.presentation.principles.model.ReferenceBean;
import org.m2ling.presentation.principles.utils.DTOConverter;
import org.m2ling.service.util.CoreUtil;
import org.m2ling.service.util.DTOConverter.FromDTO;
import org.m2ling.service.util.DTOConverter.ToDTO;
import org.m2ling.specs.M2lingFixture;

import com.google.common.base.Strings;

public class CreateCTFixture extends M2lingFixture {
	ComponentTypeServiceImpl service;

	public CreateCTFixture() throws IOException {
		super();
	}

	/**
	 * Create and return a component type from a presentation layer bean (to test it too), then
	 * search it back
	 * 
	 * @param bean
	 * @param name
	 * @return
	 * @throws FunctionalException
	 */
	public String createAndGetCT(String justCheck, String caseName, String vpID, String id, String name, String desc,
			String comment, String tags, String ifactor, String boundTypeID, String references, String enumeration,
			String reifiable) throws FunctionalException {
		reset();
		vpID = UUT.nul(vpID);
		id = UUT.nul(id);
		name = UUT.nul(name);
		desc = UUT.nul(desc);
		comment = UUT.nul(comment);
		tags = UUT.nul(tags);
		ifactor = UUT.nul(ifactor);
		boundTypeID = UUT.nul(boundTypeID);
		references = UUT.nul(references);
		enumeration = UUT.nul(enumeration);
		reifiable = UUT.nul(reifiable);
		try {
			ComponentTypeBean bean = new ComponentTypeBean();
			bean.setComment(comment);
			bean.setDescription(desc);
			bean.setId(id);
			bean.setName(name);
			bean.setTags(tags);
			bean.setViewPointId(vpID);
			bean.setBoundTypeID(boundTypeID);
			if (Strings.isNullOrEmpty(enumeration)) {
				bean.setEnumeration(new ArrayList<String>());
			} else {
				List<String> enumer = Utils.stringListFromString(enumeration);
				bean.setEnumeration(enumer);
			}
			bean.setInstantiationFactor(ifactor);
			if (Strings.isNullOrEmpty(references)) {
				bean.setReferences(null);
			} else {
				List<ReferenceBean> refs = new ArrayList<ReferenceBean>();
				StringTokenizer st = new StringTokenizer(references, ";");
				while (st.hasMoreTokens()) {
					String ref = st.nextToken();
					ReferenceBean refbean = new ReferenceBean();
					StringTokenizer st2 = new StringTokenizer(ref, ":");
					refbean.setType(st2.nextToken());
					String targs = st2.nextToken();
					StringTokenizer st3 = new StringTokenizer(targs, ",");
					List<String> targets = new ArrayList<String>();
					while (st3.hasMoreTokens()) {
						targets.add(st3.nextToken());
					}
					refbean.setTargets(targets);
					refs.add(refbean);
				}
				bean.setReferences(refs);
			}
			bean.setReifiable(Boolean.parseBoolean(reifiable));
			ComponentTypeDTO dto = new DTOConverter.ToDTO().getComponentTypeDTO(bean);
			service.createCT(null, dto);
			List<ComponentTypeDTO> ctDTOS = service.getAllCT(null, vpID);
			for (ComponentTypeDTO ctDTO : ctDTOS) {
				if (ctDTO.getId().equals(bean.getId())) {
					ComponentTypeBean out = new DTOConverter.FromDTO().getComponentTypeBean(ctDTO);
					if (Boolean.parseBoolean(justCheck)) {
						return "PASS";
					} else {
						return out.toString();
					}
				}
			}
			return "Unknown item";
		} catch (FunctionalException ex) {
			return "FAIL with code " + ex.getCode().name();
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

	/**
	 * Make sure to instantiate a new pm at each test case so we reset the content
	 */
	public void reset() {
		String sampleXMI = "src/specs/resources/mocks/Bikes.m2ling";
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

	public void createWithIfAndReifiable(String ifactor, String reifiable) throws FunctionalException {
		createAndGetCT("", "", "ertyuyreklbjnb,n", "bis__w-CMZoWEeG71vmJ5CR-iA", "ServicesContainer2", "", "", "",
				ifactor, "", "", "", reifiable);
	}
}

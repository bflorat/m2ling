package org.m2ling.service.principles;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.m2ling.common.configuration.Conf;
import org.m2ling.common.dto.core.AccessType;
import org.m2ling.common.dto.core.RuleDTO;
import org.m2ling.common.exceptions.FunctionalException;
import org.m2ling.common.utils.UUT;
import org.m2ling.persistence.PersistenceManagerXMIImpl;
import org.m2ling.presentation.principles.model.RuleBean;
import org.m2ling.presentation.principles.utils.DTOConverter;
import org.m2ling.service.common.ReferenceHelper;
import org.m2ling.service.util.CoreUtil;
import org.m2ling.service.util.DTOConverter.FromDTO;
import org.m2ling.service.util.DTOConverter.ToDTO;
import org.m2ling.specs.M2lingFixture;

public class AbstractRuleFixture extends M2lingFixture {
	RuleServiceImpl service;

	RuleServiceChecker checker;

	CoreUtil util;

	public AbstractRuleFixture() throws IOException {
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
	 * Make sure to instantiate a new pm at each test case so we reset the content to the
	 * Technical.m2ling content
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
			util = new CoreUtil(logger, pm);
			FromDTO fromDTO = new FromDTO(util);
			ReferenceHelper refHelper = new ReferenceHelper(util);
			checker = new RuleServiceChecker(pm, util, fromDTO, refHelper);
			service = new RuleServiceImpl(pm, util, fromDTO, new ToDTO(util), configuration, logger, checker);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Create a Rule from a presentation layer bean (to test it too), then search it back
	 * 
	 * @param bean
	 * @param name
	 * @return
	 * @throws FunctionalException
	 */
	public String createAndGetRule(String id, String vpID, String name, String description, String comment,
			String status, int priority, String rationale, String exceptions, String tags) throws FunctionalException {
		reset("Technical");
		RuleBean bean = new RuleBean();
		bean.setComment(comment);
		bean.setDescription(description);
		bean.setExceptions(exceptions);
		bean.setId(id);
		bean.setName(name);
		bean.setPriority(priority);
		bean.setRationale(rationale);
		bean.setStatus(status);
		bean.setTags(tags);
		bean.setViewPointId(vpID);
		RuleDTO dto = new DTOConverter.ToDTO().getRuleDTO(bean);
		service.createRule(null, dto);
		List<RuleDTO> rules = service.getAllRules(null, vpID);
		for (RuleDTO rule : rules) {
			if (rule.getId().equals(bean.getId())) {
				RuleBean out = new DTOConverter.FromDTO().getRuleBean(rule);
				System.out.println(out);
				// We have to omit history here because we can't compare from HTML value as the value is
				// only created on the server side
				return out.toString().replaceAll("history=\\{.*\\}", "");
			}
		}
		return "rule not found";
	}

	public String getCheckDTOVerification(String caseName, String accessType, String id, String name,
			String description, String rationale, String exceptions, String comment, String tags, String status,
			String priority) {
		reset("Technical");
		id = UUT.nul(id);
		name = UUT.nul(name);
		description = UUT.nul(description);
		comment = UUT.nul(comment);
		status = UUT.nul(status);
		exceptions = UUT.nul(exceptions);
		rationale = UUT.nul(rationale);
		try {
			RuleBean bean = new RuleBean();
			bean.setComment(comment);
			bean.setDescription(description);
			bean.setId(id);
			bean.setExceptions(exceptions);
			bean.setRationale(rationale);
			bean.setName(name);
			bean.setPriority(Integer.parseInt(priority));
			bean.setStatus(status);
			bean.setTags(tags);
			bean.setViewPointId("id_vp1");
			RuleDTO dto = new DTOConverter.ToDTO().getRuleDTO(bean);
			checker.checkDTO(dto, AccessType.valueOf(accessType));
			return "PASS";
		} catch (FunctionalException ex) {
			return "FAIL with code " + ex.getCode().name();
		}
	}
}

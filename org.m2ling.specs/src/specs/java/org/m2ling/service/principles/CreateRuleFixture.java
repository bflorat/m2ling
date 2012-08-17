package org.m2ling.service.principles;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.m2ling.common.configuration.Conf;
import org.m2ling.common.dto.core.AccessType;
import org.m2ling.common.dto.core.RuleDTO;
import org.m2ling.common.exceptions.FunctionalException;
import org.m2ling.persistence.PersistenceManagerXMIImpl;
import org.m2ling.presentation.principles.model.RuleBean;
import org.m2ling.presentation.principles.utils.DTOConverter;
import org.m2ling.service.util.CoreUtil;
import org.m2ling.service.util.DTOConverter.FromDTO;
import org.m2ling.service.util.DTOConverter.ToDTO;
import org.m2ling.specs.M2lingFixture;

public class CreateRuleFixture extends M2lingFixture {
	RuleServiceImpl service;

	public CreateRuleFixture() throws IOException {
		super();
	}

	/**
	 * Create a Rule from a presentation layer bean (to test it too), then search it back
	 * 
	 * @param bean
	 * @param name
	 * @return
	 * @throws FunctionalException
	 */
	public String getRule(String id, String vpID, String name, String description, String comment, String status,
			int priority, String rationale, String exceptions, String tags) throws FunctionalException {
		reset();
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

	public String getCheckNullDTO() {
		reset();
		try {
			service.checkDTO(null, AccessType.CREATE);
			return "PASS";
		} catch (FunctionalException ex) {
			return "FAIL";
		}
	}
	
	public String getCheckDTOVerification(String id,String name,String description,String comment,String tags,String statusLiterals){
		reset();
		try {
			//TODO
			RuleBean bean = new RuleBean();
			bean.setComment(comment);
			bean.setDescription(description);
			bean.setId(id);
			bean.setName(name);
			bean.setTags(tags);
			RuleDTO dto = new DTOConverter.ToDTO().getRuleDTO(bean);
			service.checkDTO(dto, AccessType.CREATE);
			return "PASS";
		} catch (FunctionalException ex) {
			return "FAIL";
		}
		
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
			service = new RuleServiceImpl(pm, util, new FromDTO(util), new ToDTO(util), configuration, logger);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

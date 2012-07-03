package org.m2ling.service.principles.impl;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.TreeMap;

import org.junit.Test;
import org.m2ling.common.configuration.Configuration;
import org.m2ling.common.dto.core.RuleDTO;
import org.m2ling.common.exceptions.FunctionalException;
import org.m2ling.persistence.impl.PersistenceManagerXMIImpl;
import org.m2ling.presentation.principles.model.RuleBean;
import org.m2ling.presentation.principles.utils.DTOConverter;
import org.m2ling.service.principles.RuleService;
import org.m2ling.service.util.CoreUtil;
import org.m2ling.service.util.DTOConverter.FromDTO;
import org.m2ling.service.util.DTOConverter.ToDTO;
import org.m2ling.specs.M2lingFixture;

public class CreateRuleFixture extends M2lingFixture {
	RuleService service;

	public CreateRuleFixture() throws IOException {
		super();
		String sampleXMI = "src/specs/resources/mocks/Technical.m2ling";
		Properties prop = new Properties();
		prop.setProperty(PersistenceManagerXMIImpl.SpecificConfiguration.CONF_XMI_PATH, sampleXMI);
		Configuration configuration = new Configuration(prop, logger);
		PersistenceManagerXMIImpl pm = new PersistenceManagerXMIImpl(logger, configuration);
		CoreUtil util = new CoreUtil(logger, pm);
		service = new RuleServiceImpl(pm, util, new FromDTO(util), new ToDTO(util), configuration, logger);
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
			String priority, String rationale, String exceptions, String tags, String history) throws FunctionalException {
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
		StringTokenizer st = new StringTokenizer(history, ",");
		Map<Long, String> historyMap = new TreeMap<Long, String>();
		while (st.hasMoreTokens()) {
			String event = st.nextToken();
			StringTokenizer st2 = new StringTokenizer(event, ":");
			historyMap.put(Long.parseLong(st2.nextToken()), st2.nextToken());
		}
		bean.setHistory(historyMap);
		RuleDTO dto = new DTOConverter.ToDTO().getRuleDTO(bean);
		service.createRule(null, dto);
		List<RuleDTO> rules = service.getAllRules(null, "id_vp1");
		for (RuleDTO rule : rules) {
			if (rule.getId().equals(bean.getId())) {
				System.out.println(rule.toString());
				return rule.toString();
			}
		}
		return "rule not found";
	}
}

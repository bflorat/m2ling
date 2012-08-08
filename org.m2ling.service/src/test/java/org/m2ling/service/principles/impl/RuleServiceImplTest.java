/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.service.principles.impl;

import static org.junit.Assert.*;

import java.util.Properties;

import org.junit.Before;
import org.junit.Test;
import org.m2ling.common.configuration.Conf;
import org.m2ling.common.dto.core.RuleDTO;
import org.m2ling.common.exceptions.FunctionalException;
import org.m2ling.common.utils.M2lingUnitTest;
import org.m2ling.persistence.impl.PersistenceManagerXMIImpl;
import org.m2ling.service.util.CoreUtil;

/**
 * @author "Bertrand Florat <bertrand@florat.net>"
 * 
 */
public class RuleServiceImplTest extends M2lingUnitTest {
	private RuleServiceImpl service;

	@Before
	public void setUp() throws Exception {
		super.setUp();
		String sampleXMI = "src/specs/resources/mocks/Technical.m2ling";
		Properties prop = new Properties();
		prop.setProperty(PersistenceManagerXMIImpl.SpecificConfiguration.CONF_XMI_PATH, sampleXMI);
		Conf configuration = new Conf(prop, logger, null);
		PersistenceManagerXMIImpl pm = new PersistenceManagerXMIImpl(logger, configuration);
		CoreUtil util = new CoreUtil(logger, pm);
		service = new RuleServiceImpl(pm, util, null, null, configuration, logger);
	}

	@Test
	public void testCheckDTONominalUpdate() {
		RuleDTO dto = new RuleDTO.Builder("id_vp1", "id_rule1", "rule1").comment("new_comment_1")
				.description("new desc 1").rationale("new rationale 1").exceptions("new exception 1").priority("HIGH")
				.build();
		try {
			service.checkDTO(dto, true);
		} catch (FunctionalException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testCheckDTONominalCreate() {
		RuleDTO dto = new RuleDTO.Builder("id_vp1", "id_rule2", "rule2").comment("comment_2").description("desc 2")
				.rationale("rationale 2").exceptions("exception 2").priority("VERY_HIGH").build();
		try {
			service.checkDTO(dto, false);
		} catch (FunctionalException e) {
			e.printStackTrace();
			fail();
		}
	}
}

/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.service.principles;

import static org.junit.Assert.fail;

import java.util.Properties;

import org.junit.Before;
import org.junit.Test;
import org.m2ling.common.configuration.Conf;
import org.m2ling.common.dto.core.AccessType;
import org.m2ling.common.dto.core.RuleDTO;
import org.m2ling.common.exceptions.FunctionalException;
import org.m2ling.common.utils.M2lingUnitTest;
import org.m2ling.common.utils.UUT;
import org.m2ling.persistence.PersistenceManagerXMIImpl;
import org.m2ling.service.util.CoreUtil;
import org.m2ling.service.util.DTOConverter.FromDTO;
import org.m2ling.service.util.DTOConverter.ToDTO;

/**
 * @author "Bertrand Florat <bertrand@florat.net>"
 * 
 */
public class RuleServiceImplTest extends M2lingUnitTest {
	private RuleServiceImpl service;

	@Before
	public void setUp() throws Exception {
		super.setUp();
		String sampleXMI = "../org.m2ling.specs/src/specs/resources/mocks/Technical.m2ling";
		Properties prop = new Properties();
		prop.setProperty(PersistenceManagerXMIImpl.SpecificConfiguration.CONF_XMI_PATH, sampleXMI);
		Conf configuration = new Conf(prop, logger, null);
		PersistenceManagerXMIImpl pm = new PersistenceManagerXMIImpl(logger, configuration);
		CoreUtil util = new CoreUtil(logger, pm);
		service = new RuleServiceImpl(pm, util, new FromDTO(util), new ToDTO(util), configuration, logger);
	}

	@Test
	public void testCheckDTONominalUpdate() {
		RuleDTO dto = new RuleDTO.Builder("id_vp1", "id_rule1", "rule1").comment("new_comment_1")
				.description("new desc 1").rationale("new rationale 1").exceptions("new exception 1").priority(3)
				.status("VALIDATED").build();
		try {
			service.checkDTO(dto, AccessType.UPDATE);
		} catch (FunctionalException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testCheckDTONominalCreate() {
		RuleDTO dto = new RuleDTO.Builder("id_vp1", "id_rule2", "rule2").comment("comment_2").description("desc 2")
				.rationale("rationale 2").exceptions("exception 2").priority(3).status("VALIDATED").build();
		try {
			service.checkDTO(dto, AccessType.CREATE);
		} catch (FunctionalException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test(expected = FunctionalException.class)
	public void testCheckDTOFailCommentTooLongCreate() throws FunctionalException {
		String comment = UUT.getShuffleString(3000);
		RuleDTO dto = new RuleDTO.Builder("id_vp1", "id_rule2", "rule2").comment(comment).description("desc 2")
				.rationale("rationale 2").exceptions("exception 2").priority(3).status("VALIDATED").build();
		service.checkDTO(dto, AccessType.CREATE);
	}

	@Test(expected = FunctionalException.class)
	public void testCheckDTOFailCommentTooLongUpdate() throws FunctionalException {
		String comment = UUT.getShuffleString(3000);
		RuleDTO dto = new RuleDTO.Builder("id_vp1", "id_rule2", "rule2").comment(comment).description("desc 2")
				.rationale("rationale 2").exceptions("exception 2").priority(3).status("VALIDATED").build();
		service.checkDTO(dto, AccessType.UPDATE);
	}

	@Test(expected = FunctionalException.class)
	public void testCheckDTOFailNullDTO() throws FunctionalException {
		service.checkDTO(null, AccessType.CREATE);
	}

	@Test(expected = FunctionalException.class)
	public void testCheckDTOFailNullName() throws FunctionalException {
		RuleDTO dto = new RuleDTO.Builder("id_vp1", "id_rule2", null).comment("comment 2").description("desc 2")
				.rationale("rationale 2").exceptions("exception 2").priority(3).status("VALIDATED").build();
		service.checkDTO(dto, AccessType.CREATE);
	}
}

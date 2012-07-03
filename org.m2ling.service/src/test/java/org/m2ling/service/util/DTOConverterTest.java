/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.service.util;

import static junit.framework.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import org.eclipse.emf.common.util.EList;
import org.junit.Test;
import org.m2ling.common.dto.core.RuleDTO;
import org.m2ling.common.dto.core.StatusEventDTO;
import org.m2ling.common.dto.core.ViewPointDTO;
import org.m2ling.common.utils.Utils;
import org.m2ling.domain.core.CoreFactory;
import org.m2ling.domain.core.Rule;
import org.m2ling.domain.core.RulePriority;
import org.m2ling.domain.core.StatusEvent;
import org.m2ling.domain.core.ViewPoint;
import org.m2ling.persistence.PersistenceManager;
import org.m2ling.persistence.impl.PersistenceManagerInMemoryImpl;

/**
 * @author "Bertrand Florat <bertrand@florat.net>"
 * 
 */
public class DTOConverterTest {

	@Test
	public void viewpointFromDTONominal() {
		List<String> literals = Arrays.asList(new String[] { "status1", "status2" });
		List<String> tags = Arrays.asList(new String[] { "tag1", "tag2" });
		ViewPointDTO dto = new ViewPointDTO.Builder("123", "foo").comment("comment1").description("desc1")
				.statusLiterals(literals).tags(tags).build();
		PersistenceManager pm = new PersistenceManagerInMemoryImpl();
		CoreUtil util = new CoreUtil(Logger.getAnonymousLogger(), pm);
		DTOConverter.FromDTO converter = new DTOConverter.FromDTO(util);
		ViewPoint vp = converter.newViewPoint(dto);
		assertTrue(vp.getId().equals("123"));
		assertTrue(vp.getComment().equals("comment1"));
		assertTrue(vp.getDescription().equals("desc1"));
		assertTrue(vp.getName().equals("foo"));
		List<String> literals2 = dto.getStatusLiterals();
		assertTrue(literals2.size() == 2 && literals2.get(0).equals("status1"));
		List<String> tags2 = dto.getTags();
		assertTrue(tags2.size() == 2 && tags2.get(0).equals("tag1"));
	}

	@Test
	public void viewpointToDTONominal() {
		PersistenceManager pm = new PersistenceManagerInMemoryImpl();
		CoreUtil util = new CoreUtil(Logger.getAnonymousLogger(), pm);
		DTOConverter.ToDTO toDTO = new DTOConverter.ToDTO(util);
		ViewPoint vp = CoreFactory.eINSTANCE.createViewPoint();
		vp.setId("123");
		vp.setComment("comment1");
		vp.setDescription("desc1");
		vp.setName("foo");
		List<String> status = Utils.stringListFromString("status1,status2");
		vp.getStatusLiterals().addAll(status);
		List<String> tags = Utils.stringListFromString("tag1,tag2");
		vp.getTags().addAll(tags);
		ViewPointDTO dto = toDTO.getViewPointDTO(vp);
		assertTrue(dto.getId().equals("123"));
		assertTrue(dto.getComment().equals("comment1"));
		assertTrue(dto.getDescription().equals("desc1"));
		assertTrue(dto.getName().equals("foo"));
		List<String> literals = dto.getStatusLiterals();
		assertTrue(literals.size() == 2 && literals.get(0).equals("status1"));
		List<String> tags2 = dto.getTags();
		assertTrue(tags2.size() == 2 && tags2.get(0).equals("tag1"));
	}

	@Test
	public void ruleFromDTONominal() {
		List<String> tags = Arrays.asList(new String[] { "tag1", "tag2" });
		List<StatusEventDTO> events = new ArrayList<StatusEventDTO>();
		events.add(new StatusEventDTO.Builder(1340875291000l, "SUBMITTED").build());
		events.add(new StatusEventDTO.Builder(1360875291000l, "VALIDATED").build());
		RuleDTO dto = new RuleDTO.Builder("vp1", "id1", "rule 1").comment("comment1").description("desc1")
				.status("VALIDATED").exceptions("no exception !").rationale("this is it !").priority("VERY_HIGH")
				.tags(tags).history(events).build();
		PersistenceManager pm = new PersistenceManagerInMemoryImpl();
		CoreUtil util = new CoreUtil(Logger.getAnonymousLogger(), pm);
		DTOConverter.FromDTO converter = new DTOConverter.FromDTO(util);
		Rule rule = converter.newRule(dto);
		assertTrue(rule.getId().equals("id1"));
		assertTrue(rule.getName().equals("rule 1"));
		assertTrue(rule.getComment().equals("comment1"));
		assertTrue(rule.getDescription().equals("desc1"));
		assertTrue(rule.getPriority().getLiteral().equals("VERY_HIGH"));
		assertTrue(rule.getRationale().equals("this is it !"));
		assertTrue(rule.getExceptions().equals("no exception !"));
		EList<StatusEvent> evts = rule.getHistory();
		assertTrue(evts.size() == 2);
		assertTrue(evts.get(1).getDate() == 1360875291000l);
		assertTrue(evts.get(1).getStatusLiteral().equals("VALIDATED"));
		List<String> tags2 = dto.getTags();
		assertTrue(tags2.size() == 2 && tags2.get(0).equals("tag1"));
	}

	@Test
	public void ruleToDTONominal() {
		PersistenceManager pm = new PersistenceManagerInMemoryImpl();
		CoreUtil util = new CoreUtil(Logger.getAnonymousLogger(), pm);
		DTOConverter.ToDTO toDTO = new DTOConverter.ToDTO(util);
		ViewPoint vp = CoreFactory.eINSTANCE.createViewPoint();
		vp.setId("vp1");
		Rule rule = CoreFactory.eINSTANCE.createRule();
		vp.getRules().add(rule);
		rule.setId("123");
		rule.setComment("comment1");
		rule.setDescription("desc1");
		rule.setName("foo");
		rule.setStatus("VALIDATED");
		rule.setExceptions("no exception !");
		rule.setRationale("this is it !");
		rule.setPriority(RulePriority.get("VERY_HIGH"));
		List<String> tags = Utils.stringListFromString("tag1,tag2");
		List<StatusEvent> events = rule.getHistory();
		events.clear();
		StatusEvent evt = CoreFactory.eINSTANCE.createStatusEvent();
		evt.setDate(1340875291000l);
		evt.setStatusLiteral("SUBMITTED");
		events.add(evt);
		evt = CoreFactory.eINSTANCE.createStatusEvent();
		evt.setDate(1360875291000l);
		evt.setStatusLiteral("VALIDATED");
		events.add(evt);
		rule.getTags().addAll(tags);
		RuleDTO dto = toDTO.getRuleDTO(rule);
		assertTrue(dto.getViewPointId().equals(vp.getId())); 
		assertTrue(dto.getId().equals("123")); 
		assertTrue(dto.getComment().equals("comment1"));
		assertTrue(dto.getDescription().equals("desc1"));
		assertTrue(dto.getName().equals("foo"));
		assertTrue(dto.getStatus().equals("VALIDATED"));
		assertTrue(dto.getExceptions().equals("no exception !"));
		assertTrue(dto.getRationale().equals("this is it !"));
		List<StatusEventDTO> history = dto.getHistory();
		assertTrue(history.size() == 2 && history.get(1).getDate() == 1360875291000l
				&& history.get(1).getStatusLiteral().equals("VALIDATED"));
		List<String> tags2 = dto.getTags();
		assertTrue(tags2.size() == 2 && tags2.get(0).equals("tag1"));
	}
}

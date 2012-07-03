/**
 * Copyright (C) 2012 Bertrand Florat
 *
 * @author "Bertrand Florat <bertrand@florat.net>"
 */
package org.m2ling.presentation.principles.utils;

import static junit.framework.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.m2ling.common.dto.core.RuleDTO;
import org.m2ling.common.dto.core.StatusEventDTO;
import org.m2ling.common.dto.core.ViewPointDTO;
import org.m2ling.presentation.principles.model.RuleBean;
import org.m2ling.presentation.principles.model.ViewPointBean;

public class DTOConverterTest {

	@Test
	public void viewpointFromDTONominal() {
		List<String> literals = Arrays.asList(new String[] { "status1", "status2" });
		List<String> tags = Arrays.asList(new String[] { "tag1", "tag2" });
		ViewPointDTO dto = new ViewPointDTO.Builder("123", "foo").comment("comment1").description("desc1")
				.statusLiterals(literals).tags(tags).build();
		DTOConverter.FromDTO converter = new DTOConverter.FromDTO();
		ViewPointBean bean = converter.getViewPointBean(dto);
		assertTrue(bean.getId().equals("123"));
		assertTrue(bean.getComment().equals("comment1"));
		assertTrue(bean.getDescription().equals("desc1"));
		assertTrue(bean.getName().equals("foo"));
		assertTrue(bean.getStatusLiterals().equals("status1,status2"));
		assertTrue(bean.getTags().equals("tag1,tag2"));
	}

	@Test
	public void viewpointToDTONominal() {
		ViewPointBean bean = new ViewPointBean();
		bean.setId("123");
		bean.setComment("comment1");
		bean.setDescription("desc1");
		bean.setName("foo");
		bean.setStatusLiterals("status1,status2");
		bean.setTags("tag1,tag2");
		DTOConverter.ToDTO converter = new DTOConverter.ToDTO();
		ViewPointDTO dto = converter.getViewPointDTO(bean);
		assertTrue(dto.getId().equals("123"));
		assertTrue(dto.getComment().equals("comment1"));
		assertTrue(dto.getDescription().equals("desc1"));
		assertTrue(dto.getName().equals("foo"));
		List<String> literals = dto.getStatusLiterals();
		assertTrue(literals.size() == 2 && literals.get(0).equals("status1"));
		List<String> tags = dto.getTags();
		assertTrue(tags.size() == 2 && tags.get(0).equals("tag1"));
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
		DTOConverter.FromDTO converter = new DTOConverter.FromDTO();
		RuleBean rule = converter.getRuleBean(dto);
		assertTrue(rule.getId().equals("id1"));
		assertTrue(rule.getName().equals("rule 1"));
		assertTrue(rule.getComment().equals("comment1"));
		assertTrue(rule.getDescription().equals("desc1"));
		assertTrue(rule.getPriority().equals("VERY_HIGH"));
		assertTrue(rule.getRationale().equals("this is it !"));
		assertTrue(rule.getExceptions().equals("no exception !"));
		Map<Long, String> evts = rule.getHistory();
		assertTrue(evts.size() == 2);
		assertTrue(evts.get(1360875291000l).equals("VALIDATED"));
		List<String> tags2 = dto.getTags();
		assertTrue(tags2.size() == 2 && tags2.get(0).equals("tag1"));
	}

	@Test
	public void ruleToDTONominal() {
		DTOConverter.ToDTO toDTO = new DTOConverter.ToDTO();
		ViewPointBean vp = new ViewPointBean();
		vp.setId("vp1");
		RuleBean rule = new RuleBean();
		rule.setId("123");
		rule.setViewPointId(vp.getId());
		rule.setComment("comment1");
		rule.setDescription("desc1");
		rule.setName("foo");
		rule.setStatus("VALIDATED");
		rule.setExceptions("no exception !");
		rule.setRationale("this is it !");
		rule.setPriority("VERY_HIGH");
		rule.setTags("tag1,tag2");
		Map<Long,String> events = rule.getHistory();
		events.put(1340875291000l,"SUBMITTED");
		events.put(1360875291000l,"VALIDATED");
		RuleDTO dto = toDTO.getRuleDTO(rule); 
		assertTrue(dto.getViewPointId().equals(vp.getId())); 
		assertTrue(dto.getId().equals("123")); 
		assertTrue(dto.getComment().equals("comment1"));
		assertTrue(dto.getDescription().equals("desc1"));
		assertTrue(dto.getName().equals("foo"));
		assertTrue(dto.getStatus().equals("VALIDATED"));
		List<StatusEventDTO> history = dto.getHistory();
		assertTrue(history.size() == 2 && history.get(1).getDate() == 1360875291000l
				&& history.get(1).getStatusLiteral().equals("VALIDATED"));
		List<String> tags2 = dto.getTags();
		assertTrue(tags2.size() == 2 && tags2.get(0).equals("tag1"));
	}
}

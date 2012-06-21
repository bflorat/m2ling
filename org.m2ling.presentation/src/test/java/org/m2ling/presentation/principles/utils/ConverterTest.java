/**
 * Copyright (C) 2012 Bertrand Florat
 *
 * @author "Bertrand Florat <bertrand@florat.net>"
 */
package org.m2ling.presentation.principles.utils;

import static junit.framework.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.m2ling.common.dto.core.ViewPointDTO;
import org.m2ling.presentation.principles.model.ViewPointBean;

public class ConverterTest {

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
}

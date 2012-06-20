/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.service.util;

import static junit.framework.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.m2ling.common.dto.core.ViewPointDTO;
import org.m2ling.common.utils.Utils;
import org.m2ling.domain.core.CoreFactory;
import org.m2ling.domain.core.ViewPoint;

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
		DTOConverter.FromDTO converter = new DTOConverter.FromDTO(new CoreUtil());
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
		DTOConverter.ToDTO toDTO = new DTOConverter.ToDTO(new CoreUtil());
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

}

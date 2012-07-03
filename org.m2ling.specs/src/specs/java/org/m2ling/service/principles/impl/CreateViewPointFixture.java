package org.m2ling.service.principles.impl;

import java.io.IOException;
import java.util.Properties;

import org.m2ling.common.configuration.Configuration;
import org.m2ling.common.dto.core.ViewPointDTO;
import org.m2ling.common.exceptions.FunctionalException;
import org.m2ling.persistence.impl.PersistenceManagerXMIImpl;
import org.m2ling.presentation.principles.model.ViewPointBean;
import org.m2ling.presentation.principles.utils.DTOConverter;
import org.m2ling.service.principles.ViewPointService;
import org.m2ling.service.util.CoreUtil;
import org.m2ling.service.util.DTOConverter.FromDTO;
import org.m2ling.service.util.DTOConverter.ToDTO;
import org.m2ling.specs.M2lingFixture;

public class CreateViewPointFixture extends M2lingFixture {
	ViewPointService service;

	public CreateViewPointFixture() throws IOException {
		super();
		String sampleXMI = "src/specs/resources/mocks/Technical.m2ling";
		Properties prop = new Properties();
		prop.setProperty(PersistenceManagerXMIImpl.SpecificConfiguration.CONF_XMI_PATH, sampleXMI);
		Configuration configuration = new Configuration(prop, logger);
		PersistenceManagerXMIImpl pm = new PersistenceManagerXMIImpl(logger, configuration);
		CoreUtil util = new CoreUtil(logger, pm);
		service = new ViewPointServiceImpl(pm, util, new FromDTO(util), new ToDTO(util), configuration, logger);
	}

	/**
	 * Create a viewpoint and return its name
	 * 
	 * @return the new viewpoint name
	 * @throws FunctionalException
	 * 
	 * <li>id=<b concordion:set="#id">id_vp123</b></li>
			<li>id=<b concordion:set="#name">vp123</b></li>
			<li>id=<b concordion:set="#description">desc1</b></li>
			<li>id=<b concordion:set="#comment">comment1</b></li>
			<li>id=<b concordion:set="#tags">tag1,tag2</b></li>
			<li>id=<b concordion:set="#statusLiterals">SUGGESTED,VALIDATED</b>
	 */
	public String getViewPoint(String id, String name,String description,String comment,String tags,String statusLiterals) throws FunctionalException {
		ViewPointBean bean = new ViewPointBean();
		bean.setComment(comment);
		bean.setDescription(description);
		bean.setId(id);
		bean.setName(name);
		bean.setStatusLiterals(statusLiterals);
		bean.setTags(tags);
		ViewPointDTO dto = new DTOConverter.ToDTO().getViewPointDTO(bean);
		service.createViewPoint(null,dto);
		ViewPointDTO checkedDTO = service.getViewPointByName(null,name);
		System.out.println(checkedDTO.toString());
		return checkedDTO.toString();
	}
}

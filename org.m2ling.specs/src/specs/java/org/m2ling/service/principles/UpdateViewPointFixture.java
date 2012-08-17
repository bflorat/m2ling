package org.m2ling.service.principles;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.m2ling.common.configuration.Conf;
import org.m2ling.common.dto.core.AccessType;
import org.m2ling.common.dto.core.ViewPointDTO;
import org.m2ling.common.exceptions.FunctionalException;
import org.m2ling.common.utils.UUT;
import org.m2ling.common.utils.Utils;
import org.m2ling.persistence.PersistenceManagerXMIImpl;
import org.m2ling.presentation.principles.model.ViewPointBean;
import org.m2ling.presentation.principles.utils.DTOConverter;
import org.m2ling.service.util.CoreUtil;
import org.m2ling.service.util.DTOConverter.FromDTO;
import org.m2ling.service.util.DTOConverter.ToDTO;
import org.m2ling.specs.M2lingFixture;

public class UpdateViewPointFixture extends M2lingFixture {
	ViewPointServiceImpl service;

	public UpdateViewPointFixture() throws IOException {
		super();
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
			service = new ViewPointServiceImpl(pm, util, new FromDTO(util), new ToDTO(util), configuration, logger);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String update(String id, String name, String description, String comment, String tags, String statusLiterals)
			throws FunctionalException {
		reset();
		ViewPointBean bean = new ViewPointBean();
		bean.setComment(comment);
		bean.setDescription(description);
		bean.setId(id);
		bean.setName(name);
		bean.setStatusLiterals(statusLiterals);
		bean.setTags(tags);
		ViewPointDTO dto = new DTOConverter.ToDTO().getViewPointDTO(bean);
		service.updateViewPoint(null, dto);
		ViewPointDTO checkedDTO = service.getViewPointByName(null, name);
		ViewPointBean outBean = new DTOConverter.FromDTO().getViewPointBean(checkedDTO);
		return outBean.toString();
	}

	public String getViewPoint(String id) {
		ViewPointDTO dto = service.getViewPointByID(null, id);
		ViewPointBean outBean = new DTOConverter.FromDTO().getViewPointBean(dto);
		return outBean.toString();
	}

	public String updateStatusLiterals(String previousStatusLiterals, String newStatusLiterals)
			throws FunctionalException {
		reset();
		ViewPointDTO vp1DTO = service.getViewPointByName(null, "vp1");
		List<String> previousStatusLiteralsList = Utils.stringListFromString(previousStatusLiterals);
		ViewPointDTO.Builder builder = new ViewPointDTO.Builder(vp1DTO.getId(), vp1DTO.getName()).comment(
				vp1DTO.getComment()).description(vp1DTO.getDescription());
		for (String tag : vp1DTO.getTags()) {
			builder.addTag(tag);
		}
		for (String statusLiteral : previousStatusLiteralsList) {
			builder.addStatusLiteral(statusLiteral);
		}
		// Set the initial status literals
		service.updateViewPoint(null, builder.build());
		// try to set the new status literals
		builder = new ViewPointDTO.Builder(vp1DTO.getId(), vp1DTO.getName()).comment(vp1DTO.getComment()).description(
				vp1DTO.getDescription());
		for (String tag : vp1DTO.getTags()) {
			builder.addTag(tag);
		}
		for (String statusLiteral : Utils.stringListFromString(newStatusLiterals)) {
			builder.addStatusLiteral(statusLiteral);
		}
		service.updateViewPoint(null, builder.build());
		ViewPointDTO updatedVP = service.getViewPointByID(null, "id_vp1");
		String out = Utils.stringListAsString(updatedVP.getStatusLiterals());
		return out;
	}

	/**
	 * Return FAIL or PASS
	 */
	public String updateStatusWithRule(String newStatusLiterals) throws FunctionalException {
		reset();
		// We assume that we have a "rule1" rule in VALIDATED status on vp1 vp (pre-filled in the
		// technical mock)
		ViewPointDTO vp1DTO = service.getViewPointByName(null, "vp1");
		List<String> statusLiteralsList = Utils.stringListFromString(newStatusLiterals);
		ViewPointDTO.Builder builder = new ViewPointDTO.Builder(vp1DTO.getId(), vp1DTO.getName()).comment(
				vp1DTO.getComment()).description(vp1DTO.getDescription());
		for (String tag : vp1DTO.getTags()) {
			builder.addTag(tag);
		}
		for (String statusLiteral : statusLiteralsList) {
			builder.addStatusLiteral(statusLiteral);
		}
		try {
			service.updateViewPoint(null, builder.build());
		} catch (FunctionalException fe) {
			return "FAIL";
		}
		return "PASS";
	}

	/**
	 * Return "PASS" or "FAIL" according to result of checkDTO()
	 * 
	 * @param dto
	 * @return "PASS" or "FAIL" according to result of checkDTO()
	 */
	public String getCheckDTOVerification(String id, String name, String description, String comment, String tags,
			String statusLiterals) {
		reset();
		try {
			List<String> tagsList = null;
			if (!tags.equals("null")) {
				tagsList = Utils.stringListFromString(tags);
			}
			List<String> statusLiteralsList = null;
			if (!"null".equals(statusLiterals)) {
				statusLiteralsList = Utils.stringListFromString(statusLiterals);
			}
			ViewPointDTO.Builder builder = new ViewPointDTO.Builder(UUT.nul(id), UUT.nul(name)).description(
					UUT.nul(description)).comment(UUT.nul(comment));
			for (String tag : tagsList) {
				builder.addTag(tag);
			}
			for (String statusLiteral : statusLiteralsList) {
				builder.addStatusLiteral(statusLiteral);
			}
			service.checkDTO(builder.build(), AccessType.UPDATE);
			return "PASS";
		} catch (FunctionalException ex) {
			return "FAIL";
		}
	}

	public String getCheckNullDTO() {
		reset();
		try {
			service.checkDTO(null, AccessType.UPDATE);
			return "PASS";
		} catch (FunctionalException ex) {
			return "FAIL";
		}
	}
}

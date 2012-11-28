package org.m2ling.service.principles;

import java.io.IOException;

import org.junit.Test;
import org.m2ling.common.dto.core.AccessType;
import org.m2ling.common.dto.core.ViewPointDTO;
import org.m2ling.common.exceptions.FunctionalException;
import org.m2ling.common.utils.UUT;
import org.m2ling.common.utils.Utils;
import org.m2ling.presentation.principles.model.ViewPointBean;
import org.m2ling.presentation.principles.utils.DTOConverter;

public class CreateViewPointFixture extends AbstractViewPointFixture {
	public CreateViewPointFixture() throws IOException {
		super();
	}

	/**
	 * Create a viewpoint and return its name. We try to test the widest possible scope so we create
	 * a presentation layer bean and check the returned presentation bean as well.
	 * 
	 * @return the new viewpoint name
	 * @throws FunctionalException
	 * 
	 *            <li>id=<b concordion:set="#id">id_vp123</b></li> <li>id=<b
	 *            concordion:set="#name">vp123</b></li> <li>id=<b
	 *            concordion:set="#description">desc1</b></li> <li>id=<b
	 *            concordion:set="#comment">comment1</b></li> <li>id=<b
	 *            concordion:set="#tags">tag1,tag2</b></li> <li>id=<b
	 *            concordion:set="#statusLiterals">SUGGESTED,VALIDATED</b>
	 */
	@Test
	public String getViewPoint(String id, String name, String description, String comment, String tags,
			String statusLiterals) throws FunctionalException {
		reset("Technical");
		ViewPointBean bean = new ViewPointBean();
		bean.setComment(comment);
		bean.setDescription(description);
		bean.setId(id);
		bean.setName(name);
		bean.setStatusLiterals(statusLiterals);
		bean.setTags(tags);
		ViewPointDTO dto = new DTOConverter.ToDTO().getViewPointDTO(bean);
		service.createViewPoint(null, dto);
		ViewPointDTO checkedDTO = service.getViewPointByID(null, id);
		ViewPointBean outBean = new DTOConverter.FromDTO().getViewPointBean(checkedDTO);
		return outBean.toString();
	}

	/**
	 * Return "PASS" or "FAIL" according to result of checkDTO()
	 * 
	 * @param dto
	 * @return "PASS" or "FAIL" according to result of checkDTO()
	 */
	public String getCheckDTOVerification(String caseName, String id, String name, String description, String comment,
			String tags, String statusLiterals) {
		reset("Technical");
		try {
			ViewPointDTO.Builder builder = (ViewPointDTO.Builder) new ViewPointDTO.Builder(UUT.nul(id), UUT.nul(name))
					.description(UUT.nul(description)).comment(UUT.nul(comment));
			if (!tags.equals("null")) {
				for (String tag : Utils.stringListFromString(tags)) {
					builder.addTag(tag);
				}
			}
			for (String statusLiteral : Utils.stringListFromString(statusLiterals)) {
				builder.addStatusLiteral(UUT.nul(statusLiteral));
			}
			service.checkDTO(builder.build(), AccessType.CREATE);
			return "PASS";
		} catch (FunctionalException ex) {
			return "FAIL with code " + ex.getCode().name();
		}
	}
}

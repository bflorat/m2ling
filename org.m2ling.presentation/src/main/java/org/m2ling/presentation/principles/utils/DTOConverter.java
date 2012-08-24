/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.presentation.principles.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.m2ling.common.dto.core.ComponentTypeDTO;
import org.m2ling.common.dto.core.ReferenceDTO;
import org.m2ling.common.dto.core.RuleDTO;
import org.m2ling.common.dto.core.StatusEventDTO;
import org.m2ling.common.dto.core.ViewPointDTO;
import org.m2ling.common.exceptions.FunctionalException;
import org.m2ling.common.exceptions.FunctionalException.Code;
import org.m2ling.common.exceptions.TechnicalException;
import org.m2ling.common.utils.Utils;
import org.m2ling.presentation.i18n.Msg;
import org.m2ling.presentation.principles.model.ComponentTypeBean;
import org.m2ling.presentation.principles.model.ReferenceBean;
import org.m2ling.presentation.principles.model.RuleBean;
import org.m2ling.presentation.principles.model.ViewPointBean;

import com.google.inject.Singleton;

/**
 * 
 * Convert presentation layer classes from and to DTO associated classes.
 * 
 * @author Bertrand Florat <bertrand@florat.net>
 * 
 */
public class DTOConverter {
	private DTOConverter() {
		// Utility class, no instantiation
	}

	/**
	 * Set of utility methods to get DTO objects from presentation objects.
	 * 
	 * @author Bertrand Florat <bertrand@florat.net>
	 * 
	 */
	@Singleton
	public static class ToDTO {
		Msg msg;

		public ViewPointDTO getViewPointDTO(ViewPointBean bean) {
			ViewPointDTO.Builder builder = new ViewPointDTO.Builder(bean.getId(), bean.getName()).description(
					bean.getDescription()).comment(bean.getComment());
			for (String tag : Utils.stringListFromString(bean.getTags())) {
				builder.addTag(tag);
			}
			for (String statusLiteral : Utils.stringListFromString(bean.getStatusLiterals())) {
				builder.addStatusLiteral(statusLiteral);
			}
			return builder.build();
		}

		/**
		 * Create a Rule DTO from provided rule bean
		 * 
		 * @param bean
		 * @return a Rule DTO from provided rule bean
		 */
		public RuleDTO getRuleDTO(RuleBean bean) {
			// Note that we don't populate history into DTO as it is not used by the service
			RuleDTO.Builder builder = new RuleDTO.Builder(bean.getViewPointId(), bean.getId(), bean.getName())
					.description(bean.getDescription()).rationale(bean.getRationale()).exceptions(bean.getExceptions())
					.comment(bean.getComment()).status(bean.getStatus()).priority(bean.getPriority());
			for (String tag : Utils.stringListFromString(bean.getTags())) {
				builder.addTag(tag);
			}
			return builder.build();
		}

		/**
		 * Create a CT DTO from provided ct bean
		 * 
		 * @param bean
		 * @return a CT DTO from provided ct bean
		 */
		public ComponentTypeDTO getComponentTypeDTO(ComponentTypeBean bean) {
			int ifactor = 0;
			if ("*".equals(bean.getInstantiationFactor())) {
				ifactor = -1;
			} else {
				try {
					ifactor = Integer.parseInt(bean.getInstantiationFactor());
				} catch (NumberFormatException nfe) {
					// it can occur only i there is a lack in the presentation surface controls, so it is
					// a bug -> TechnicalException
					throw new TechnicalException(org.m2ling.common.exceptions.TechnicalException.Code.INVALID_FORMAT, nfe,
							"instanciation factor = " + bean.getInstantiationFactor());
				}
			}
			ComponentTypeDTO.Builder builder = new ComponentTypeDTO.Builder(bean.getViewPointId(), bean.getId(),
					bean.getName()).description(bean.getDescription()).comment(bean.getComment())
					.boundTypeID(bean.getBoundTypeID()).instantiationFactor(ifactor).reifiable(bean.isReifiable());
			for (String tag : Utils.stringListFromString(bean.getTags())) {
				builder.addTag(tag);
			}
			for (String componentID : bean.getEnumeration()) {
				builder.addEnumerationID(componentID);
			}
			for (ReferenceBean ref : bean.getReferences()) {
				ReferenceDTO refDTO = getReferenceDTO(ref);
				builder.addReference(refDTO);
			}
			return builder.build();
		}

		/**
		 * Create a reference DTO from provided reference bean
		 * 
		 * @param bean
		 * @return a reference DTO from provided reference bean
		 */
		public ReferenceDTO getReferenceDTO(ReferenceBean bean) {
			ReferenceDTO.Builder builder = new ReferenceDTO.Builder(bean.getType());
			for (String targetID : bean.getTargets()) {
				builder.addTarget(targetID);
			}
			return builder.build();
		}
	}

	/**
	 * Set of utility methods to get model objects from DTO instances.
	 * 
	 * @author Bertrand Florat <bertrand@florat.net>
	 * 
	 */
	@Singleton
	public static class FromDTO {
		/**
		 * Return a new ViewPoint instance given a DTO or an already existing instance of any.
		 * 
		 * @param dto
		 *           the dto
		 * @return a new ViewPoint instance
		 */
		public ViewPointBean getViewPointBean(ViewPointDTO dto) {
			ViewPointBean bean = new ViewPointBean();
			bean.setId(dto.getId());
			bean.setName((dto.getName() != null) ? dto.getName() : "");
			bean.setComment((dto.getComment() != null) ? dto.getComment() : "");
			bean.setDescription((dto.getDescription() != null) ? dto.getDescription() : "");
			String statusLiterals = Utils.stringListAsString(dto.getStatusLiterals());
			bean.setStatusLiterals(statusLiterals);
			String tags = Utils.stringListAsString(dto.getTags());
			bean.setTags(tags);
			File icon = IconManager.getVPIconFile(bean);
			if (icon != null) {
				bean.setIconPath(icon.getAbsolutePath());
			}
			return bean;
		}

		/**
		 * Return a new Rule instance given a DTO or an already existing instance of any.
		 * 
		 * @param dto
		 *           the dto
		 * @return a new Rule instance
		 */
		public RuleBean getRuleBean(RuleDTO dto) {
			RuleBean bean = new RuleBean();
			bean.setId(dto.getId());
			bean.setViewPointId(dto.getViewPointId());
			bean.setViewPointId(dto.getViewPointId());
			bean.setName((dto.getName() != null) ? dto.getName() : "");
			bean.setComment((dto.getComment() != null) ? dto.getComment() : "");
			bean.setDescription((dto.getDescription() != null) ? dto.getDescription() : "");
			bean.setRationale((dto.getRationale() != null) ? dto.getRationale() : "");
			bean.setDescription((dto.getDescription() != null) ? dto.getDescription() : "");
			bean.setExceptions((dto.getExceptions() != null) ? dto.getExceptions() : "");
			bean.setPriority(dto.getPriority());
			bean.setStatus((dto.getStatus() != null) ? dto.getStatus() : "");
			String tags = Utils.stringListAsString(dto.getTags());
			bean.setTags(tags);
			bean.setHistory(getHistoryBean(dto));
			return bean;
		}

		/**
		 * Return a time-sorted rule history map from provided DTO
		 * 
		 * @param dto
		 *           source DTO
		 * @return a time-sorted rule history map from provided DTO
		 */
		public Map<Long, String> getHistoryBean(RuleDTO dto) {
			Map<Long, String> out = new HashMap<Long, String>(dto.getHistory().size());
			for (StatusEventDTO event : dto.getHistory()) {
				out.put(event.getDate(), event.getStatusLiteral());
			}
			return out;
		}

		/**
		 * Return a reference bean from provided reference DTO
		 * 
		 * @param dto
		 *           the reference DTO
		 * @return a reference bean from provided reference DTO
		 */
		public ReferenceBean getReferenceBean(ReferenceDTO dto) {
			ReferenceBean bean = new ReferenceBean();
			bean.setType(dto.getType());
			bean.setTargets(new ArrayList<String>(dto.getTargets()));
			return bean;
		}

		/**
		 * Return a new CT instance given a DTO or an already existing instance of any.
		 * 
		 * @param dto
		 *           the dto
		 * @return a new CT instance
		 */
		public ComponentTypeBean getComponentTypeBean(ComponentTypeDTO dto) {
			ComponentTypeBean bean = new ComponentTypeBean();
			bean.setId(dto.getId());
			bean.setName((dto.getName() != null) ? dto.getName() : "");
			bean.setComment((dto.getComment() != null) ? dto.getComment() : "");
			bean.setDescription((dto.getDescription() != null) ? dto.getDescription() : "");
			bean.setDescription((dto.getDescription() != null) ? dto.getDescription() : "");
			String tags = Utils.stringListAsString(dto.getTags());
			bean.setTags(tags);
			bean.setBoundTypeID(dto.getBoundTypeID());
			bean.setEnumeration(dto.getEnumeration());
			String ifactor = "0";
			if (dto.getInstantiationFactor() == -1) {
				ifactor = "*";
			} else {
				ifactor = Integer.toString(dto.getInstantiationFactor());
			}
			bean.setInstantiationFactor(ifactor);
			List<ReferenceBean> refs = new ArrayList<ReferenceBean>();
			for (ReferenceDTO refDTO : dto.getReferences()) {
				refs.add(getReferenceBean(refDTO));
			}
			bean.setReferences(refs);
			bean.setReifiable(dto.isReifiable());
			bean.setViewPointId(dto.getViewPointId());
			return bean;
		}
	}
}

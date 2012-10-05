/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.presentation.principles.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.m2ling.common.dto.core.ComponentTypeDTO;
import org.m2ling.common.dto.core.HasNameAndIdDTO;
import org.m2ling.common.dto.core.LinkTypeDTO;
import org.m2ling.common.dto.core.ReferenceDTO;
import org.m2ling.common.dto.core.RuleDTO;
import org.m2ling.common.dto.core.StatusEventDTO;
import org.m2ling.common.dto.core.ViewPointDTO;
import org.m2ling.common.exceptions.TechnicalException;
import org.m2ling.common.utils.Consts;
import org.m2ling.common.utils.Utils;
import org.m2ling.presentation.i18n.Msg;
import org.m2ling.presentation.principles.model.ComponentTypeBean;
import org.m2ling.presentation.principles.model.HasNameAndIDBean;
import org.m2ling.presentation.principles.model.LinkTypeBean;
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
			HasNameAndIdDTO vp = (bean.getViewPoint() == null) ? null : new HasNameAndIdDTO.Builder(bean.getViewPoint()
					.getId(), bean.getViewPoint().getName()).build();
			HasNameAndIdDTO boundType = (bean.getBoundType() == null) ? null : new HasNameAndIdDTO.Builder(bean
					.getBoundType().getId(), bean.getBoundType().getName()).build();
			ComponentTypeDTO.Builder builder = new ComponentTypeDTO.Builder(vp, bean.getId(), bean.getName())
					.description(bean.getDescription()).comment(bean.getComment()).boundType(boundType)
					.instantiationFactor(ifactor);
			for (String tag : Utils.stringListFromString(bean.getTags())) {
				builder.addTag(tag);
			}
			for (HasNameAndIDBean component : bean.getEnumeration()) {
				HasNameAndIdDTO compDTO = new HasNameAndIdDTO.Builder(component.getId(), component.getName()).build();
				builder.addEnumeration(compDTO);
			}
			for (ReferenceBean ref : bean.getReferences()) {
				ReferenceDTO refDTO = getReferenceDTO(ref);
				builder.addReference(refDTO);
			}
			return builder.build();
		}

		/**
		 * Create a LT DTO from provided lt bean
		 * 
		 * @param bean
		 * @return a LT DTO from provided lt bean
		 */
		public LinkTypeDTO getLinkTypeDTO(LinkTypeBean bean) {
			HasNameAndIdDTO vp = (bean.getViewPoint() == null) ? null : new HasNameAndIdDTO.Builder(bean.getViewPoint()
					.getId(), bean.getViewPoint().getName()).build();
			LinkTypeDTO.Builder builder = new LinkTypeDTO.Builder(vp, bean.getId(), bean.getName())
					.description(bean.getDescription()).comment(bean.getComment()).linkTemporality(bean.getLinkTemporality())
					.linkAccessType(bean.getLinkAccessType());
			for (String tag : Utils.stringListFromString(bean.getTags())) {
				builder.addTag(tag);
			}
			for (HasNameAndIDBean ctBean : bean.getSourcesTypes()) {
				HasNameAndIdDTO ctDTO = new HasNameAndIdDTO.Builder(ctBean.getId(), ctBean.getName()).build();
				builder.addSourcesType(ctDTO);
			}
			for (HasNameAndIDBean ctBean : bean.getDestinationsTypes()) {
				HasNameAndIdDTO ctDTO = new HasNameAndIdDTO.Builder(ctBean.getId(), ctBean.getName()).build();
				builder.addDestinationsType(ctDTO);
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
			List<HasNameAndIDBean> targets = bean.getTargets();
			for (HasNameAndIDBean target : targets) {
				HasNameAndIdDTO hniDTO = getNameAndIdDTO(target);
				builder.addTarget(hniDTO);
			}
			return builder.build();
		}

		/**
		 * Create a HasNameAndID DTO from provided bean
		 * 
		 * @param bean
		 * @return a HasNameAndID DTO from provided bean
		 */
		public HasNameAndIdDTO getNameAndIdDTO(HasNameAndIDBean bean) {
			if (bean.getId() == null) {
				return null;
			}
			HasNameAndIdDTO.Builder builder = new HasNameAndIdDTO.Builder(bean.getId(), bean.getName());
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
			File icon = IconManager.getIconFile(Consts.CONF_VP_ICONS_LOCATION, bean.getId());
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
			List<HasNameAndIDBean> targets = new ArrayList<HasNameAndIDBean>();
			for (HasNameAndIdDTO hniDTO : dto.getTargets()) {
				targets.add(getHasNameAndIdBean(hniDTO));
			}
			bean.setTargets(targets);
			return bean;
		}

		/**
		 * Return a HasNameAndId bean from provided DTO
		 * 
		 * @param dto
		 *           the HasNameAndId DTO
		 * @return a HasNameAndId bean from provided DTO
		 */
		public HasNameAndIDBean getHasNameAndIdBean(HasNameAndIdDTO dto) {
			if (dto == null) {
				return null;
			}
			HasNameAndIDBean bean = new HasNameAndIDBean();
			bean.setId(dto.getId());
			bean.setName(dto.getName());
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
			String tags = Utils.stringListAsString(dto.getTags());
			bean.setTags(tags);
			HasNameAndIDBean boundBean = getHasNameAndIdBean(dto.getBoundType());
			bean.setBoundType(boundBean);
			List<HasNameAndIDBean> enumBean = new ArrayList<HasNameAndIDBean>(1);
			for (HasNameAndIdDTO compDTO : dto.getEnumeration()) {
				enumBean.add(getHasNameAndIdBean(compDTO));
			}
			bean.setEnumeration(enumBean);
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
			HasNameAndIDBean vpBean = getHasNameAndIdBean(dto.getViewPoint());
			bean.setViewPoint(vpBean);
			File icon = IconManager.getIconFile(Consts.CONF_CT_ICONS_LOCATION, bean.getId());
			if (icon != null && icon.exists()) {
				bean.setIconPath(icon.getAbsolutePath());
			}
			return bean;
		}

		/**
		 * Return a new LT instance given a DTO or an already existing instance of any.
		 * 
		 * @param dto
		 *           the dto
		 * @return a new LT instance
		 */
		public LinkTypeBean getLinkTypeBean(LinkTypeDTO dto) {
			LinkTypeBean bean = new LinkTypeBean();
			bean.setId(dto.getId());
			bean.setName((dto.getName() != null) ? dto.getName() : "");
			bean.setComment((dto.getComment() != null) ? dto.getComment() : "");
			bean.setDescription((dto.getDescription() != null) ? dto.getDescription() : "");
			String tags = Utils.stringListAsString(dto.getTags());
			bean.setTags(tags);
			bean.setLinkTemporality(dto.getLinkTemporality());
			bean.setLinkAccessType(dto.getLinkAccessType());
			Set<HasNameAndIDBean> sources = new LinkedHashSet<HasNameAndIDBean>(1);
			for (HasNameAndIdDTO ctDTO : dto.getSourcesTypes()) {
				sources.add(getHasNameAndIdBean(ctDTO));
			}
			bean.setSourcesTypes(sources);
			Set<HasNameAndIDBean> destinations = new LinkedHashSet<HasNameAndIDBean>(1);
			for (HasNameAndIdDTO ctDTO : dto.getDestinationsTypes()) {
				destinations.add(getHasNameAndIdBean(ctDTO));
			}
			bean.setDestinationsTypes(destinations);
			HasNameAndIDBean vpBean = getHasNameAndIdBean(dto.getViewPoint());
			bean.setViewPoint(vpBean);
			File icon = IconManager.getIconFile(Consts.CONF_LT_ICONS_LOCATION, bean.getId());
			if (icon != null && icon.exists()) {
				bean.setIconPath(icon.getAbsolutePath());
			}
			return bean;
		}
	}
}
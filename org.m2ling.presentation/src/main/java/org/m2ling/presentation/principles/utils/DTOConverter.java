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

import org.m2ling.common.dto.core.AbstractCommonDTO;
import org.m2ling.common.dto.core.ComponentDTO;
import org.m2ling.common.dto.core.ComponentInstanceDTO;
import org.m2ling.common.dto.core.ComponentTypeDTO;
import org.m2ling.common.dto.core.HasNameAndIdDTO;
import org.m2ling.common.dto.core.LinkDTO;
import org.m2ling.common.dto.core.LinkInstanceDTO;
import org.m2ling.common.dto.core.LinkTypeDTO;
import org.m2ling.common.dto.core.ReferenceDTO;
import org.m2ling.common.dto.core.RuleDTO;
import org.m2ling.common.dto.core.StatusEventDTO;
import org.m2ling.common.dto.core.ViewDTO;
import org.m2ling.common.dto.core.ViewPointDTO;
import org.m2ling.common.exceptions.TechnicalException;
import org.m2ling.common.utils.Consts;
import org.m2ling.common.utils.Utils;
import org.m2ling.presentation.common.model.AbstractCommonBean;
import org.m2ling.presentation.i18n.Msg;
import org.m2ling.presentation.principles.model.ComponentTypeBean;
import org.m2ling.presentation.principles.model.HasNameAndIDBean;
import org.m2ling.presentation.principles.model.LinkTypeBean;
import org.m2ling.presentation.principles.model.ReferenceBean;
import org.m2ling.presentation.principles.model.RuleBean;
import org.m2ling.presentation.principles.model.ViewPointBean;
import org.m2ling.presentation.studio.model.ComponentBean;
import org.m2ling.presentation.studio.model.ComponentInstanceBean;
import org.m2ling.presentation.studio.model.LinkBean;
import org.m2ling.presentation.studio.model.LinkInstanceBean;
import org.m2ling.presentation.studio.model.ViewBean;

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

		/**
		 * Populate a common DTO builder with data from provided bean
		 * 
		 * @param builder
		 *           the type-specific builder
		 * @param bean
		 *           the bean
		 */
		private void populateCommonBuilder(AbstractCommonDTO.Builder builder, AbstractCommonBean bean) {
			builder.description(bean.getDescription()).comment(bean.getComment());
			String status = bean.getStatus();
			if (status != null && !("".equals(status.trim()))) {
				builder.status(status);
			}
			for (String tag : Utils.stringListFromString(bean.getTags())) {
				builder.addTag(tag);
			}
		}

		public ViewPointDTO getViewPointDTO(ViewPointBean bean) {
			ViewPointDTO.Builder builder = new ViewPointDTO.Builder(bean.getId(), bean.getName());
			populateCommonBuilder(builder, bean);
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
			RuleDTO.Builder builder = new RuleDTO.Builder(bean.getViewPointId(), bean.getId(), bean.getName());
			populateCommonBuilder(builder, bean);
			builder.rationale(bean.getRationale()).exceptions(bean.getExceptions()).priority(bean.getPriority());
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
			ComponentTypeDTO.Builder builder = new ComponentTypeDTO.Builder(vp, bean.getId(), bean.getName());
			populateCommonBuilder(builder, bean);
			builder.boundType(boundType).instantiationFactor(ifactor);
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
			LinkTypeDTO.Builder builder = new LinkTypeDTO.Builder(vp, bean.getId(), bean.getName());
			populateCommonBuilder(builder, bean);
			builder.linkTemporality(bean.getLinkTemporality()).linkAccessType(bean.getLinkAccessType());
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

		public ComponentDTO getComponentDTO(ComponentBean bean) {
			HasNameAndIdDTO boundComp = getNameAndIdDTO(bean.getBoundComponent());
			HasNameAndIdDTO typeDTO = getNameAndIdDTO(bean.getType());
			ComponentDTO.Builder builder = new ComponentDTO.Builder(bean.getId(), bean.getName());
			populateCommonBuilder(builder, bean);
			builder.boundType(boundComp).type(typeDTO);
			for (ReferenceBean ref : bean.getReferences()) {
				ReferenceDTO refDTO = getReferenceDTO(ref);
				builder.addReference(refDTO);
			}
			return builder.build();
		}

		public ComponentInstanceDTO getComponentInstanceDTO(ComponentInstanceBean bean) {
			HasNameAndIdDTO boundInstance = getNameAndIdDTO(bean.getBoundInstance());
			HasNameAndIdDTO compDTO = getNameAndIdDTO(bean.getComponent());
			ComponentInstanceDTO.Builder builder = new ComponentInstanceDTO.Builder(bean.getId(), bean.getName());
			populateCommonBuilder(builder, bean);
			builder.boundInstance(boundInstance).component(compDTO);
			for (ReferenceBean ref : bean.getReferences()) {
				ReferenceDTO refDTO = getReferenceDTO(ref);
				builder.addReference(refDTO);
			}
			return builder.build();
		}

		public LinkDTO getLinkDTO(LinkBean bean) {
			HasNameAndIdDTO typeDTO = getNameAndIdDTO(bean.getType());
			LinkDTO.Builder builder = new LinkDTO.Builder(bean.getId(), bean.getName());
			builder.type(typeDTO).timeoutMillis(bean.getTimeoutMillis());
			populateCommonBuilder(builder, bean);
			for (HasNameAndIDBean sourceBean : bean.getSources()) {
				builder.addSource(getNameAndIdDTO(sourceBean));
			}
			for (HasNameAndIDBean destBean : bean.getDestinations()) {
				builder.addDestination(getNameAndIdDTO(destBean));
			}
			return builder.build();
		}

		public LinkInstanceDTO getLinkInstanceDTO(LinkInstanceBean bean) {
			LinkInstanceDTO.Builder builder = new LinkInstanceDTO.Builder(bean.getId(), bean.getName());
			builder.link(getNameAndIdDTO(bean.getLink()));
			populateCommonBuilder(builder, bean);
			builder.source(getNameAndIdDTO(bean.getSource()));
			builder.destination(getNameAndIdDTO(bean.getDestination()));
			return builder.build();
		}

		public ViewDTO getViewDTO(ViewBean bean) {
			HasNameAndIdDTO vpDTO = getNameAndIdDTO(bean.getViewpoint());
			ViewDTO.Builder builder = new ViewDTO.Builder(bean.getId(), bean.getName(), vpDTO);
			populateCommonBuilder(builder, bean);
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
		 * Populate DTO common fields with bean data
		 */
		private void populateCommonBean(AbstractCommonBean bean, AbstractCommonDTO dto) {
			bean.setId(dto.getId());
			bean.setName((dto.getName() != null) ? dto.getName() : "");
			bean.setComment((dto.getComment() != null) ? dto.getComment() : "");
			bean.setDescription((dto.getDescription() != null) ? dto.getDescription() : "");
			bean.setStatus(dto.getStatus());
			String tags = Utils.stringListAsString(dto.getTags());
			bean.setTags(tags);
		}

		/**
		 * Return a new ViewPoint instance given a DTO or an already existing instance of any.
		 * 
		 * @param dto
		 *           the dto
		 * @return a new ViewPoint instance
		 */
		public ViewPointBean getViewPointBean(ViewPointDTO dto) {
			ViewPointBean bean = new ViewPointBean();
			populateCommonBean(bean, dto);
			String statusLiterals = Utils.stringSetAsString(dto.getStatusLiterals());
			bean.setStatusLiterals(statusLiterals);
			File icon = IconManager.getIconFile(Consts.CONF_VP_ICONS_LOCATION, bean.getId());
			if (icon != null) {
				bean.setIconPath(icon.getAbsolutePath());
			}
			return bean;
		}

		/**
		 * Return a new View instance given a DTO or an already existing instance of any.
		 * 
		 * @param dto
		 *           the dto
		 * @return a new View instance
		 */
		public ViewBean getViewBean(ViewDTO dto) {
			ViewBean bean = new ViewBean();
			populateCommonBean(bean, dto);
			bean.setViewpoint(getHasNameAndIdBean(dto.getViewpoint()));
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
			populateCommonBean(bean, dto);
			bean.setViewPointId(dto.getViewPointId());
			bean.setRationale((dto.getRationale() != null) ? dto.getRationale() : "");
			bean.setExceptions((dto.getExceptions() != null) ? dto.getExceptions() : "");
			bean.setPriority(dto.getPriority());
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
			populateCommonBean(bean, dto);
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

		public ComponentBean getComponentBean(ComponentDTO dto) {
			ComponentBean bean = new ComponentBean();
			populateCommonBean(bean, dto);
			HasNameAndIDBean boundBean = getHasNameAndIdBean(dto.getBoundComponent());
			bean.setBoundComponent(boundBean);
			List<ReferenceBean> refs = new ArrayList<ReferenceBean>();
			for (ReferenceDTO refDTO : dto.getReferences()) {
				refs.add(getReferenceBean(refDTO));
			}
			bean.setReferences(refs);
			HasNameAndIDBean ctBean = getHasNameAndIdBean(dto.getComponentType());
			bean.setType(ctBean);
			return bean;
		}

		public ComponentInstanceBean getComponentBean(ComponentInstanceDTO dto) {
			ComponentInstanceBean bean = new ComponentInstanceBean();
			populateCommonBean(bean, dto);
			HasNameAndIDBean boundInstance = getHasNameAndIdBean(dto.getBoundInstance());
			bean.setBoundInstance(boundInstance);
			List<ReferenceBean> refs = new ArrayList<ReferenceBean>();
			for (ReferenceDTO refDTO : dto.getReferences()) {
				refs.add(getReferenceBean(refDTO));
			}
			bean.setReferences(refs);
			HasNameAndIDBean compBean = getHasNameAndIdBean(dto.getComponent());
			bean.setComponent(compBean);
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
			populateCommonBean(bean, dto);
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

		public LinkBean getLinkBean(LinkDTO dto) {
			LinkBean bean = new LinkBean();
			populateCommonBean(bean, dto);
			Set<HasNameAndIDBean> sources = new LinkedHashSet<HasNameAndIDBean>(1);
			for (HasNameAndIdDTO compDTO : dto.getSources()) {
				sources.add(getHasNameAndIdBean(compDTO));
			}
			bean.setSources(sources);
			Set<HasNameAndIDBean> destinations = new LinkedHashSet<HasNameAndIDBean>(1);
			for (HasNameAndIdDTO compDTO : dto.getDestinations()) {
				destinations.add(getHasNameAndIdBean(compDTO));
			}
			bean.setDestinations(destinations);
			HasNameAndIDBean ltBean = getHasNameAndIdBean(dto.getLinkType());
			bean.setType(ltBean);
			bean.setTimeoutMillis(dto.getTimeoutMillis());
			return bean;
		}

		public LinkInstanceBean getLinkInstanceBean(LinkInstanceDTO dto) {
			LinkInstanceBean bean = new LinkInstanceBean();
			populateCommonBean(bean, dto);
			bean.setSource(getHasNameAndIdBean(dto.getSource()));
			bean.setDestination(getHasNameAndIdBean(dto.getDestination()));
			bean.setLink(getHasNameAndIdBean(dto.getLink()));
			return bean;
		}
	}
}
/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.service.util;

import static org.m2ling.common.utils.Utils.nonull;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.m2ling.common.dto.core.AbstractCommonDTO;
import org.m2ling.common.dto.core.ComponentTypeDTO;
import org.m2ling.common.dto.core.HasNameAndIdDTO;
import org.m2ling.common.dto.core.LinkTypeDTO;
import org.m2ling.common.dto.core.ReferenceDTO;
import org.m2ling.common.dto.core.RuleDTO;
import org.m2ling.common.dto.core.StatusEventDTO;
import org.m2ling.common.dto.core.ViewDTO;
import org.m2ling.common.dto.core.ViewPointDTO;
import org.m2ling.domain.core.ArchitectureItem;
import org.m2ling.domain.core.Component;
import org.m2ling.domain.core.ComponentType;
import org.m2ling.domain.core.CoreFactory;
import org.m2ling.domain.core.HasComment;
import org.m2ling.domain.core.HasDescription;
import org.m2ling.domain.core.HasNameAndID;
import org.m2ling.domain.core.HasStatus;
import org.m2ling.domain.core.HasTags;
import org.m2ling.domain.core.LinkAccessType;
import org.m2ling.domain.core.LinkTemporality;
import org.m2ling.domain.core.LinkType;
import org.m2ling.domain.core.Reference;
import org.m2ling.domain.core.ReferenceType;
import org.m2ling.domain.core.Rule;
import org.m2ling.domain.core.StatusEvent;
import org.m2ling.domain.core.View;
import org.m2ling.domain.core.ViewPoint;

import com.google.common.base.Strings;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * 
 * Convert domain classes from and to DTO associated classes.
 * 
 * @author Bertrand Florat <bertrand@florat.net>
 * 
 */
public class DTOConverter {
	private DTOConverter() {
		// Utility class, no instantiation
	}

	/**
	 * Set of utility methods to get DTO objects from model objects.
	 * 
	 * @author Bertrand Florat <bertrand@florat.net>
	 * 
	 */
	@Singleton
	public static class ToDTO {
		CoreUtil util;

		@Inject
		public ToDTO(CoreUtil util) {
			super();
			this.util = util;
		}

		/**
		 * Populate a common DTO builder with data from provided item (must be an
		 * Architecture/Concept/RuntimeItem)
		 * 
		 * @param builder
		 *           the type-specific builder
		 * @param item
		 *           the business object
		 */
		private void populateCommonBuilder(AbstractCommonDTO.Builder builder, EObject item) {
			for (String tag : ((HasTags) item).getTags()) {
				builder.addTag(tag);
			}
			builder.comment(nonull(((HasComment) item).getComment()));
			builder.description(nonull(((HasDescription) item).getDescription()));
			builder.status(((HasStatus) item).getStatus());
		}

		public ViewPointDTO getViewPointDTO(ViewPoint vp) {
			ViewPointDTO.Builder builder = new ViewPointDTO.Builder(vp.getId(), vp.getName());
			populateCommonBuilder(builder, vp);
			for (String statusLiteral : vp.getStatusLiterals()) {
				builder.addStatusLiteral(statusLiteral);
			}
			return builder.build();
		}

		public RuleDTO getRuleDTO(Rule rule) {
			ViewPoint vp = (ViewPoint) rule.eContainer();
			RuleDTO.Builder builder = new RuleDTO.Builder(vp.getId(), rule.getId(), rule.getName());
			populateCommonBuilder(builder, rule);
			builder.exceptions(nonull(rule.getExceptions()));
			builder.priority(rule.getPriority());
			builder.rationale(nonull(rule.getRationale()));
			for (StatusEvent event : rule.getHistory()) {
				StatusEventDTO eventDTO = getStatusEventDTO(event);
				builder.addEvent(eventDTO);
			}
			return builder.build();
		}

		public StatusEventDTO getStatusEventDTO(StatusEvent event) {
			StatusEventDTO.Builder builder = new StatusEventDTO.Builder(event.getDate(), event.getStatusLiteral());
			return builder.build();
		}

		public ComponentTypeDTO getComponentTypeDTO(ComponentType ct) {
			ViewPoint vp = (ViewPoint) ct.eContainer();
			// If name is void or null, use bound type one
			String name = ct.getName();
			ComponentType boundType = ct.getBoundType();
			if (Strings.isNullOrEmpty(ct.getName()) && boundType != null) {
				name = boundType.getName();
			}
			HasNameAndIdDTO hniVP = new HasNameAndIdDTO.Builder(vp.getId(), vp.getName()).build();
			ComponentTypeDTO.Builder builder = new ComponentTypeDTO.Builder(hniVP, ct.getId(), name);
			populateCommonBuilder(builder, ct);
			// Add bound type tags as well
			if (boundType != null) {
				for (String tag : boundType.getTags()) {
					builder.addTag(tag);
				}
			}
			if (Strings.isNullOrEmpty(ct.getComment()) && boundType != null) {
				builder.comment(boundType.getComment());
			} else {
				builder.comment(ct.getComment());
			}
			if (Strings.isNullOrEmpty(ct.getDescription()) && boundType != null) {
				builder.description(boundType.getDescription());
			} else {
				builder.description(ct.getDescription());
			}
			for (ArchitectureItem ai : ct.getEnumeration()) {
				HasNameAndIdDTO hniComp = new HasNameAndIdDTO.Builder(ai.getId(), ai.getName()).build();
				builder.addEnumeration(hniComp);
			}
			for (Reference ref : ct.getReferences()) {
				ReferenceDTO refDTO = getReferenceDTO(ref);
				builder.addReference(refDTO);
			}
			if (ct.getBoundType() != null) {
				// returned bound type name must contain vp name as well for GUI display
				ViewPoint boundTypeVP = (ViewPoint) ct.getBoundType().eContainer();
				StringBuilder boundTypeName = new StringBuilder(boundTypeVP.getName());
				boundTypeName.append("/ ");
				boundTypeName.append(ct.getBoundType().getName());
				HasNameAndIdDTO hniBoundType = new HasNameAndIdDTO.Builder(ct.getBoundType().getId(),
						boundTypeName.toString()).build();
				builder.boundType(hniBoundType);
				builder.instantiationFactor(ct.getBoundType().getInstantiationFactor());
			} else {
				builder.instantiationFactor(ct.getInstantiationFactor());
			}
			return builder.build();
		}

		public LinkTypeDTO getLinkTypeDTO(LinkType lt) {
			ViewPoint vp = (ViewPoint) lt.eContainer();
			// If name is void or null, use bound type one
			String name = lt.getName();
			HasNameAndIdDTO hniVP = new HasNameAndIdDTO.Builder(vp.getId(), vp.getName()).build();
			LinkTypeDTO.Builder builder = new LinkTypeDTO.Builder(hniVP, lt.getId(), name);
			populateCommonBuilder(builder, lt);
			builder.linkAccessType(lt.getLinkAccessType().getLiteral());
			builder.linkTemporality(lt.getLinkTemporality().getLiteral());
			for (ComponentType ct : lt.getSourceTypes()) {
				HasNameAndIdDTO hniDTO = new HasNameAndIdDTO.Builder(ct.getId(), ct.getName()).build();
				builder.addSourcesType(hniDTO);
			}
			for (ComponentType ct : lt.getDestinationTypes()) {
				HasNameAndIdDTO hniDTO = new HasNameAndIdDTO.Builder(ct.getId(), ct.getName()).build();
				builder.addDestinationsType(hniDTO);
			}
			return builder.build();
		}

		public ReferenceDTO getReferenceDTO(Reference ref) {
			ReferenceDTO.Builder builder = new ReferenceDTO.Builder(ref.getType().name());
			for (HasNameAndID target : ref.getTargets()) {
				HasNameAndIdDTO hniDTO = new HasNameAndIdDTO.Builder(target.getId(), target.getName()).build();
				builder.addTarget(hniDTO);
			}
			return builder.build();
		}

		/**
		 * Create and populate a rule history DTO from a given rule. If the history is void, a void
		 * collection is returned.
		 * 
		 * @param rule
		 *           : source rule
		 * 
		 * @return Create and populate a DTO from a given rule history.
		 */
		public List<StatusEventDTO> getRuleHistoryDTO(Rule rule) {
			List<StatusEventDTO> out = new ArrayList<StatusEventDTO>(3);
			for (StatusEvent event : rule.getHistory()) {
				StatusEventDTO dto = new StatusEventDTO.Builder(event.getDate(), event.getStatusLiteral()).build();
				out.add(dto);
			}
			return out;
		}

		public ViewDTO getViewDTO(View view) {
			HasNameAndIdDTO vp = new HasNameAndIdDTO.Builder(view.getViewPoint().getId(), view.getViewPoint().getName())
					.build();
			ViewDTO.Builder builder = new ViewDTO.Builder(view.getId(), view.getName(), vp);
			populateCommonBuilder(builder, view);
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
		CoreUtil util;

		@Inject
		public FromDTO(CoreUtil util) {
			super();
			this.util = util;
		}

		/**
		 * Populate item fields with DTO data. Item must be an Architecture/Concept/RuntimeItem.
		 */
		private void populateCommonValues(EObject item, AbstractCommonDTO dto) {
			((HasNameAndID) item).setId(dto.getId());
			((HasNameAndID) item).setName(dto.getName());
			for (String tag : dto.getTags()) {
				if (!Strings.isNullOrEmpty(tag)) {
					((HasTags) item).getTags().add(tag);
				}
			}
			((HasStatus) item).setStatus(dto.getStatus());
			((HasDescription) item).setDescription(dto.getDescription());
			((HasComment) item).setComment(dto.getComment());
		}

		/**
		 * Return a new ViewPoint instance given a DTO.
		 * 
		 * @param dto
		 *           the dto
		 * @return a new ViewPoint instance
		 */
		public ViewPoint newViewPoint(ViewPointDTO dto) {
			ViewPoint vp = CoreFactory.eINSTANCE.createViewPoint();
			populateCommonValues(vp, dto);
			for (String status : dto.getStatusLiterals()) {
				if (!Strings.isNullOrEmpty(status)) {
					vp.getStatusLiterals().add(status);
				}
			}
			return vp;
		}

		/**
		 * Return a new rule instance given a DTO.
		 * 
		 * @param dto
		 *           the dto
		 * @return a new Rule instance
		 */
		public Rule newRule(RuleDTO dto) {
			Rule rule = CoreFactory.eINSTANCE.createRule();
			populateCommonValues(rule, dto);
			rule.setPriority(dto.getPriority());
			rule.setRationale(dto.getRationale());
			rule.setExceptions(dto.getExceptions());
			return rule;
		}

		/**
		 * Return a new reference given a DTO.
		 * 
		 * @param dto
		 *           the dto
		 * @return a new reference
		 */
		public Reference newReference(ReferenceDTO dto) {
			Reference reference = CoreFactory.eINSTANCE.createReference();
			reference.setType(ReferenceType.get(dto.getType()));
			EList<HasNameAndID> targets = reference.getTargets();
			for (HasNameAndIdDTO target : dto.getTargets()) {
				// Try component target
				Component comp = util.getComponentByID(target.getId());
				if (comp == null) {
					// OK, try component type
					ComponentType compType = util.getComponentTypeByID(target.getId());
					targets.add(compType);
				} else {
					targets.add(comp);
				}
			}
			return reference;
		}

		/**
		 * Return a new component type instance given a DTO.
		 * 
		 * @param dto
		 *           the dto
		 * @return a new component type instance
		 */
		public ComponentType newComponentType(ComponentTypeDTO dto) {
			ComponentType ct = CoreFactory.eINSTANCE.createComponentType();
			populateCommonValues(ct, dto);
			if (dto.getBoundType() != null) {
				ComponentType boundedType = util.getComponentTypeByID(dto.getBoundType().getId());
				ct.setBoundType(boundedType);
			}
			ct.setInstantiationFactor(dto.getInstantiationFactor());
			for (HasNameAndIdDTO hni : dto.getEnumeration()) {
				ArchitectureItem comp = util.getComponentByID(hni.getId());
				if (comp == null) {
					// if comp is null, should be because it is actually a comp group
					comp = util.getComponentGroupByID(hni.getId());
				}
				ct.getEnumeration().add(comp);
			}
			for (ReferenceDTO refDTO : dto.getReferences()) {
				Reference reference = newReference(refDTO);
				ct.getReferences().add(reference);
			}
			return ct;
		}

		/**
		 * Return a new link type instance given a DTO.
		 * 
		 * @param dto
		 *           the dto
		 * @return a new link type instance
		 */
		public LinkType newLinkType(LinkTypeDTO dto) {
			LinkType lt = CoreFactory.eINSTANCE.createLinkType();
			populateCommonValues(lt, dto);
			lt.setLinkAccessType(LinkAccessType.valueOf(dto.getLinkAccessType()));
			lt.setLinkTemporality(LinkTemporality.valueOf(dto.getLinkTemporality()));
			for (HasNameAndIdDTO hniDTO : dto.getSourcesTypes()) {
				ComponentType ct = util.getComponentTypeByID(hniDTO.getId());
				lt.getSourceTypes().add(ct);
			}
			for (HasNameAndIdDTO hniDTO : dto.getDestinationsTypes()) {
				ComponentType ct = util.getComponentTypeByID(hniDTO.getId());
				lt.getDestinationTypes().add(ct);
			}
			return lt;
		}

		/**
		 * Clear and populate a rule history from given dto
		 * 
		 * @param dto
		 *           the source dto
		 * @param rule
		 *           target rule to populate
		 * @return Clear and populate a rule history from given dto
		 */
		public void populateRuleHistory(List<StatusEventDTO> dto, Rule rule) {
			EList<StatusEvent> history = rule.getHistory();
			history.clear();
			for (StatusEventDTO event : dto) {
				StatusEvent se = CoreFactory.eINSTANCE.createStatusEvent();
				se.setDate(event.getDate());
				se.setStatusLiteral(event.getStatusLiteral());
				history.add(se);
			}
		}

		/**
		 * Return a new View instance given a DTO.
		 * 
		 * @param dto
		 *           the dto
		 * @return a new View instance
		 */
		public View newView(ViewDTO dto) {
			View view = CoreFactory.eINSTANCE.createView();
			populateCommonValues(view, dto);
			ViewPoint vp = util.getViewPointByID(dto.getViewpoint().getId());
			view.setViewPoint(vp);
			return view;
		}
	}
}

/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.service.util;

import static org.m2ling.common.utils.Utils.nonull;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.m2ling.common.dto.core.ComponentTypeDTO;
import org.m2ling.common.dto.core.HasNameAndIdDTO;
import org.m2ling.common.dto.core.ReferenceDTO;
import org.m2ling.common.dto.core.RuleDTO;
import org.m2ling.common.dto.core.StatusEventDTO;
import org.m2ling.common.dto.core.ViewPointDTO;
import org.m2ling.domain.core.ArchitectureItem;
import org.m2ling.domain.core.Component;
import org.m2ling.domain.core.ComponentType;
import org.m2ling.domain.core.CoreFactory;
import org.m2ling.domain.core.HasNameAndID;
import org.m2ling.domain.core.Reference;
import org.m2ling.domain.core.ReferenceType;
import org.m2ling.domain.core.Rule;
import org.m2ling.domain.core.StatusEvent;
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

		public ViewPointDTO getViewPointDTO(ViewPoint vp) {
			ViewPointDTO.Builder builder = new ViewPointDTO.Builder(vp.getId(), vp.getName());
			for (String tag : vp.getTags()) {
				builder.addTag(tag);
			}
			builder.comment(nonull(vp.getComment()));
			for (String statusLiteral : vp.getStatusLiterals()) {
				builder.addStatusLiteral(statusLiteral);
			}
			builder.description(nonull(vp.getDescription()));
			return builder.build();
		}

		public RuleDTO getRuleDTO(Rule rule) {
			ViewPoint vp = (ViewPoint) rule.eContainer();
			RuleDTO.Builder builder = new RuleDTO.Builder(vp.getId(), rule.getId(), rule.getName());
			for (String tag : rule.getTags()) {
				builder.addTag(tag);
			}
			builder.comment(nonull(rule.getComment()));
			builder.status(nonull(rule.getStatus()));
			builder.description(nonull(rule.getDescription()));
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
			for (String tag : ct.getTags()) {
				builder.addTag(tag);
			}
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
			builder.instantiationFactor(ct.getInstantiationFactor());
			for (Reference ref : ct.getReferences()) {
				ReferenceDTO refDTO = getReferenceDTO(ref);
				builder.addReference(refDTO);
			}
			if (ct.getBoundType() != null) {
				HasNameAndIdDTO hniBoundType = new HasNameAndIdDTO.Builder(ct.getBoundType().getId(), ct.getBoundType()
						.getName()).build();
				builder.boundType(hniBoundType);
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
		 * Return a new ViewPoint instance given a DTO.
		 * 
		 * @param dto
		 *           the dto
		 * @return a new ViewPoint instance
		 */
		public ViewPoint newViewPoint(ViewPointDTO dto) {
			ViewPoint vp = CoreFactory.eINSTANCE.createViewPoint();
			vp.setId(dto.getId());
			vp.setName(dto.getName());
			for (String tag : dto.getTags()) {
				if (!Strings.isNullOrEmpty(tag)) {
					vp.getTags().add(tag);
				}
			}
			for (String status : dto.getStatusLiterals()) {
				if (!Strings.isNullOrEmpty(status)) {
					vp.getStatusLiterals().add(status);
				}
			}
			vp.setDescription(dto.getDescription());
			vp.setComment(dto.getComment());
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
			rule.setId(dto.getId());
			rule.setName(dto.getName());
			for (String tag : dto.getTags()) {
				rule.getTags().add(tag);
			}
			rule.setStatus(dto.getStatus());
			rule.setPriority(dto.getPriority());
			rule.setDescription(dto.getDescription());
			rule.setComment(dto.getComment());
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
			ct.setId(dto.getId());
			ct.setName(dto.getName());
			for (String tag : dto.getTags()) {
				ct.getTags().add(tag);
			}
			ct.setDescription(dto.getDescription());
			ct.setComment(dto.getComment());
			ComponentType boundedType = util.getComponentTypeByID(dto.getBoundType().getId());
			ct.setBoundType(boundedType);
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
	}
}

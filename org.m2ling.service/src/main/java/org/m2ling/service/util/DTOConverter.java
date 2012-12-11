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
import org.m2ling.common.utils.Utils;
import org.m2ling.domain.core.ArchitectureItem;
import org.m2ling.domain.core.Component;
import org.m2ling.domain.core.ComponentInstance;
import org.m2ling.domain.core.ComponentType;
import org.m2ling.domain.core.CoreFactory;
import org.m2ling.domain.core.HasComment;
import org.m2ling.domain.core.HasDescription;
import org.m2ling.domain.core.HasNameAndID;
import org.m2ling.domain.core.HasStatus;
import org.m2ling.domain.core.HasTags;
import org.m2ling.domain.core.Link;
import org.m2ling.domain.core.LinkAccessType;
import org.m2ling.domain.core.LinkInstance;
import org.m2ling.domain.core.LinkTemporality;
import org.m2ling.domain.core.LinkType;
import org.m2ling.domain.core.Reference;
import org.m2ling.domain.core.ReferenceType;
import org.m2ling.domain.core.Rule;
import org.m2ling.domain.core.StatusEvent;
import org.m2ling.domain.core.Type;
import org.m2ling.domain.core.View;
import org.m2ling.domain.core.ViewPoint;

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
		DomainExplorer explorer;

		@Inject
		public ToDTO(DomainExplorer explorer) {
			super();
			this.explorer = explorer;
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
			HasStatus hs = (HasStatus) item;
			// Transform empty status to null in DTO
			if (hs.getStatus() != null && "".equals(hs.getStatus().trim())) {
				builder.status(null);
			} else {
				builder.status(hs.getStatus());
			}
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
			if (boundType != null && Utils.isNullOrEmptyAfterTrim(name)) {
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
			if (boundType != null && Utils.isNullOrEmptyAfterTrim(ct.getComment())) {
				builder.comment(boundType.getComment());
			} else {
				builder.comment(ct.getComment());
			}
			if (boundType != null && Utils.isNullOrEmptyAfterTrim(ct.getDescription())) {
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
				String boundStatus = ct.getBoundType().getStatus();
				if (ct.getStatus() == null && !Utils.isNullOrEmptyAfterTrim(boundStatus)
						&& vp.getStatusLiterals().contains(boundStatus)) {
					builder.status(boundStatus);
				}
			} else {
				builder.instantiationFactor(ct.getInstantiationFactor());
			}
			return builder.build();
		}

		public ComponentDTO getComponentDTO(Component comp) {
			View view = explorer.getViewByItem(comp);
			HasNameAndIdDTO viewDTO = new HasNameAndIdDTO.Builder(view.getId(), view.getName()).build();
			// If name is void or null, use bound comp one
			String name = comp.getName();
			Component boundComp = comp.getBoundComponent();
			if ((name == null || "".equals(name.trim())) && boundComp != null) {
				name = boundComp.getName();
			}
			ComponentDTO.Builder builder = new ComponentDTO.Builder(comp.getId(), name, viewDTO);
			populateCommonBuilder(builder, comp);
			// Add bound comp tags as well
			if (boundComp != null) {
				for (String tag : boundComp.getTags()) {
					builder.addTag(tag);
				}
			}
			if (boundComp != null && Utils.isNullOrEmptyAfterTrim(comp.getComment())) {
				builder.comment(boundComp.getComment());
			} else {
				builder.comment(comp.getComment());
			}
			if (boundComp != null && Utils.isNullOrEmptyAfterTrim(comp.getDescription())) {
				builder.description(boundComp.getDescription());
			} else {
				builder.description(comp.getDescription());
			}
			for (Reference ref : comp.getReferences()) {
				ReferenceDTO refDTO = getReferenceDTO(ref);
				builder.addReference(refDTO);
			}
			if (comp.getBoundComponent() != null) {
				HasNameAndIdDTO hniBoundComp = new HasNameAndIdDTO.Builder(comp.getBoundComponent().getId(), comp
						.getBoundComponent().getName()).build();
				builder.boundType(hniBoundComp);
				String boundStatus = comp.getBoundComponent().getStatus();
				ViewPoint vp = view.getViewPoint();
				if (comp.getStatus() == null && !Utils.isNullOrEmptyAfterTrim(boundStatus)
						&& vp.getStatusLiterals().contains(boundStatus)) {
					builder.status(boundStatus);
				}
			}
			HasNameAndIdDTO hniType = new HasNameAndIdDTO.Builder(comp.getType().getId(), comp.getType().getName())
					.build();
			builder.type(hniType);
			return builder.build();
		}

		public ComponentInstanceDTO getComponentInstanceDTO(ComponentInstance instance) {
			View view = explorer.getViewByItem(instance);
			HasNameAndIdDTO viewDTO = new HasNameAndIdDTO.Builder(view.getId(), view.getName()).build();
			// If name is void or null, use bound instance one
			String name = instance.getName();
			ComponentInstance boundInstance = instance.getBoundComponentInstance();
			if (boundInstance != null && Utils.isNullOrEmptyAfterTrim(instance.getName())) {
				name = boundInstance.getName();
			}
			ComponentInstanceDTO.Builder builder = new ComponentInstanceDTO.Builder(instance.getId(), name, viewDTO);
			populateCommonBuilder(builder, instance);
			// Add bound comp tags as well
			if (boundInstance != null) {
				for (String tag : boundInstance.getTags()) {
					builder.addTag(tag);
				}
			}
			if (boundInstance != null && Utils.isNullOrEmptyAfterTrim(instance.getComment())) {
				builder.comment(boundInstance.getComment());
			} else if (boundInstance != null) {
				builder.comment(instance.getComment());
			}
			if (boundInstance != null && Utils.isNullOrEmptyAfterTrim(instance.getDescription())) {
				builder.description(boundInstance.getDescription());
			} else {
				builder.description(instance.getDescription());
			}
			for (Reference ref : instance.getReferences()) {
				ReferenceDTO refDTO = getReferenceDTO(ref);
				builder.addReference(refDTO);
			}
			if (instance.getBoundComponentInstance() != null) {
				HasNameAndIdDTO hniBoundComp = new HasNameAndIdDTO.Builder(instance.getBoundComponentInstance().getId(),
						instance.getBoundComponentInstance().getName()).build();
				builder.boundInstance(hniBoundComp);
			}
			HasNameAndIdDTO hniComp = new HasNameAndIdDTO.Builder(instance.getComponent().getId(), instance.getComponent()
					.getName()).build();
			builder.component(hniComp);
			return builder.build();
		}

		public LinkTypeDTO getLinkTypeDTO(LinkType lt) {
			ViewPoint vp = (ViewPoint) lt.eContainer();
			// If name is void or null, use bound type one
			HasNameAndIdDTO hniVP = new HasNameAndIdDTO.Builder(vp.getId(), vp.getName()).build();
			LinkTypeDTO.Builder builder = new LinkTypeDTO.Builder(hniVP, lt.getId(), lt.getName());
			populateCommonBuilder(builder, lt);
			if (lt.getLinkAccessType() != LinkAccessType.UNSET) {
				builder.linkAccessType(lt.getLinkAccessType().getLiteral());
			}
			if (lt.getLinkTemporality() != LinkTemporality.UNSET) {
				builder.linkTemporality(lt.getLinkTemporality().getLiteral());
			}
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

		public LinkDTO getLinkDTO(Link link) {
			// If name is void or null, use bound type one
			View view = explorer.getViewByItem(link);
			HasNameAndIdDTO viewDTO = new HasNameAndIdDTO.Builder(view.getId(), view.getName()).build();
			LinkDTO.Builder builder = new LinkDTO.Builder(link.getId(), link.getName(), viewDTO);
			populateCommonBuilder(builder, link);
			List<Component> comps = explorer.getComponentForArchitectureItems(link.getSources());
			for (Component comp : comps) {
				HasNameAndIdDTO hniDTO = new HasNameAndIdDTO.Builder(comp.getId(), comp.getName()).build();
				builder.addSource(hniDTO);
			}
			comps = explorer.getComponentForArchitectureItems(link.getDestinations());
			for (Component comp : comps) {
				HasNameAndIdDTO hniDTO = new HasNameAndIdDTO.Builder(comp.getId(), comp.getName()).build();
				builder.addDestination(hniDTO);
			}
			builder.timeoutMillis(link.getTimeoutMillis());
			LinkType lt = link.getType();
			HasNameAndIdDTO typeDTO = new HasNameAndIdDTO.Builder(lt.getId(), lt.getName()).build();
			builder.type(typeDTO);
			return builder.build();
		}

		public LinkInstanceDTO getLinkInstanceDTO(LinkInstance instance) {
			// If name is void or null, use bound type one
			View view = explorer.getViewByItem(instance);
			HasNameAndIdDTO viewDTO = new HasNameAndIdDTO.Builder(view.getId(), view.getName()).build();
			LinkInstanceDTO.Builder builder = new LinkInstanceDTO.Builder(instance.getId(), instance.getName(), viewDTO);
			populateCommonBuilder(builder, instance);
			HasNameAndIdDTO hniSource = new HasNameAndIdDTO.Builder(instance.getSource().getId(), instance.getSource()
					.getName()).build();
			builder.source(hniSource);
			HasNameAndIdDTO hniDest = new HasNameAndIdDTO.Builder(instance.getDestination().getId(), instance
					.getDestination().getName()).build();
			builder.destination(hniDest);
			HasNameAndIdDTO hniLink = new HasNameAndIdDTO.Builder(instance.getLink().getId(), instance.getLink().getName())
					.build();
			builder.link(hniLink);
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
		DomainExplorer explorer;

		@Inject
		public FromDTO(DomainExplorer explorer) {
			super();
			this.explorer = explorer;
		}

		/**
		 * Populate item fields with DTO data. Item must be an Architecture/Concept/RuntimeItem.
		 */
		private void populateCommonValues(EObject item, AbstractCommonDTO dto) {
			((HasNameAndID) item).setId(dto.getId());
			((HasNameAndID) item).setName(dto.getName());
			for (String tag : dto.getTags()) {
				if (!Utils.isNullOrEmptyAfterTrim(tag)) {
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
				if (!Utils.isNullOrEmptyAfterTrim(status)) {
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
		 * @param itemType
		 *           : the kind of item the reference belongs to
		 * @return a new reference
		 */
		public Reference newReference(ReferenceDTO dto, Type itemType) {
			Reference reference = CoreFactory.eINSTANCE.createReference();
			reference.setType(ReferenceType.get(dto.getType()));
			EList<HasNameAndID> targets = reference.getTargets();
			for (HasNameAndIdDTO targetDTO : dto.getTargets()) {
				if (itemType == Type.COMPONENT_TYPE) {
					ComponentType compType = explorer.getComponentTypeByID(targetDTO.getId());
					targets.add(compType);
				} else if (itemType == Type.COMPONENT) {
					Component comp = explorer.getComponentByID(targetDTO.getId());
					targets.add(comp);
				} else if (itemType == Type.COMPONENT_INSTANCE) {
					ComponentInstance ci = explorer.getComponentInstanceByID(targetDTO.getId());
					targets.add(ci);
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
				ComponentType boundedType = explorer.getComponentTypeByID(dto.getBoundType().getId());
				ct.setBoundType(boundedType);
			}
			ct.setInstantiationFactor(dto.getInstantiationFactor());
			for (HasNameAndIdDTO hni : dto.getEnumeration()) {
				ArchitectureItem comp = explorer.getComponentByID(hni.getId());
				if (comp == null) {
					// if comp is null, should be because it is actually a comp group
					comp = explorer.getComponentGroupByID(hni.getId());
				}
				ct.getEnumeration().add(comp);
			}
			for (ReferenceDTO refDTO : dto.getReferences()) {
				Reference reference = newReference(refDTO, Type.COMPONENT_TYPE);
				ct.getReferences().add(reference);
			}
			return ct;
		}

		/**
		 * Return a new component given a DTO.
		 * 
		 * @param dto
		 *           the dto
		 * @return a new component
		 */
		public Component newComponent(ComponentDTO dto) {
			Component comp = CoreFactory.eINSTANCE.createComponent();
			populateCommonValues(comp, dto);
			if (dto.getBoundComponent() != null) {
				Component bounded = explorer.getComponentByID(dto.getBoundComponent().getId());
				comp.setBoundComponent(bounded);
			}
			for (ReferenceDTO refDTO : dto.getReferences()) {
				Reference reference = newReference(refDTO, Type.COMPONENT);
				comp.getReferences().add(reference);
			}
			ComponentType type = explorer.getComponentTypeByID(dto.getComponentType().getId());
			comp.setType(type);
			return comp;
		}

		/**
		 * Return a new component instance given a DTO.
		 * 
		 * @param dto
		 *           the dto
		 * @return a new component instance
		 */
		public ComponentInstance newComponentInstance(ComponentInstanceDTO dto) {
			ComponentInstance ci = CoreFactory.eINSTANCE.createComponentInstance();
			populateCommonValues(ci, dto);
			if (dto.getBoundInstance() != null) {
				ComponentInstance bounded = explorer.getComponentInstanceByID(dto.getBoundInstance().getId());
				ci.setBoundComponentInstance(bounded);
			}
			for (ReferenceDTO refDTO : dto.getReferences()) {
				Reference reference = newReference(refDTO, Type.COMPONENT_INSTANCE);
				ci.getReferences().add(reference);
			}
			Component comp = explorer.getComponentByID(dto.getComponent().getId());
			ci.setComponent(comp);
			return ci;
		}

		/**
		 * Return a new link type given a DTO.
		 * 
		 * @param dto
		 *           the dto
		 * @return a new link type
		 */
		public LinkType newLinkType(LinkTypeDTO dto) {
			LinkType lt = CoreFactory.eINSTANCE.createLinkType();
			populateCommonValues(lt, dto);
			// access ans temporality type can be null to mean 'unset'
			if (dto.getLinkAccessType() == null) {
				lt.setLinkAccessType(LinkAccessType.UNSET);
			} else {
				lt.setLinkAccessType(LinkAccessType.valueOf(dto.getLinkAccessType()));
			}
			if (dto.getLinkTemporality() == null) {
				lt.setLinkTemporality(LinkTemporality.UNSET);
			} else {
				lt.setLinkTemporality(LinkTemporality.valueOf(dto.getLinkTemporality()));
			}
			for (HasNameAndIdDTO hniDTO : dto.getSourcesTypes()) {
				ComponentType ct = explorer.getComponentTypeByID(hniDTO.getId());
				lt.getSourceTypes().add(ct);
			}
			for (HasNameAndIdDTO hniDTO : dto.getDestinationsTypes()) {
				ComponentType ct = explorer.getComponentTypeByID(hniDTO.getId());
				lt.getDestinationTypes().add(ct);
			}
			return lt;
		}

		/**
		 * Return a new link given a DTO.
		 * 
		 * @param dto
		 *           the dto
		 * @return a new link
		 */
		public Link newLink(LinkDTO dto) {
			Link link = CoreFactory.eINSTANCE.createLink();
			populateCommonValues(link, dto);
			for (HasNameAndIdDTO hniDTO : dto.getSources()) {
				Component comp = explorer.getComponentByID(hniDTO.getId());
				link.getSources().add(comp);
			}
			for (HasNameAndIdDTO hniDTO : dto.getDestinations()) {
				Component comp = explorer.getComponentByID(hniDTO.getId());
				link.getDestinations().add(comp);
			}
			link.setTimeoutMillis(dto.getTimeoutMillis());
			LinkType lt = explorer.getLinkTypeByID(dto.getLinkType().getId());
			link.setType(lt);
			return link;
		}

		/**
		 * Return a new link instance given a DTO.
		 * 
		 * @param dto
		 *           the dto
		 * @return a new link instance
		 */
		public LinkInstance newLinkInstance(LinkInstanceDTO dto) {
			LinkInstance li = CoreFactory.eINSTANCE.createLinkInstance();
			populateCommonValues(li, dto);
			ComponentInstance ci = explorer.getComponentInstanceByID(dto.getSource().getId());
			li.setSource(ci);
			ci = explorer.getComponentInstanceByID(dto.getDestination().getId());
			li.setDestination(ci);
			Link link = explorer.getLinkByID(dto.getLink().getId());
			li.setLink(link);
			return li;
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
			ViewPoint vp = explorer.getViewPointByID(dto.getViewpoint().getId());
			view.setViewPoint(vp);
			return view;
		}
	}
}

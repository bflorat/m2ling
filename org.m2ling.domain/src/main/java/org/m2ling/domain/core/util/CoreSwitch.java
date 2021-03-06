/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.domain.core.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.m2ling.domain.core.*;
import org.m2ling.domain.core.Activity;
import org.m2ling.domain.core.ActivityTransition;
import org.m2ling.domain.core.Actor;
import org.m2ling.domain.core.ArchitectureItem;
import org.m2ling.domain.core.BoundaryConstraint;
import org.m2ling.domain.core.Component;
import org.m2ling.domain.core.ComponentGroup;
import org.m2ling.domain.core.ComponentInstance;
import org.m2ling.domain.core.ComponentInstanceGroup;
import org.m2ling.domain.core.ComponentType;
import org.m2ling.domain.core.ConceptItem;
import org.m2ling.domain.core.Constraint;
import org.m2ling.domain.core.CorePackage;
import org.m2ling.domain.core.CustomProperty;
import org.m2ling.domain.core.EMailConstraint;
import org.m2ling.domain.core.FloatConstraint;
import org.m2ling.domain.core.FormatConstraint;
import org.m2ling.domain.core.HasComment;
import org.m2ling.domain.core.HasConstraints;
import org.m2ling.domain.core.HasCustomProperties;
import org.m2ling.domain.core.HasDescription;
import org.m2ling.domain.core.HasNameAndID;
import org.m2ling.domain.core.HasParameterDefinitions;
import org.m2ling.domain.core.HasParameterValues;
import org.m2ling.domain.core.HasReferences;
import org.m2ling.domain.core.HasStatus;
import org.m2ling.domain.core.HasTags;
import org.m2ling.domain.core.IntegerConstraint;
import org.m2ling.domain.core.Link;
import org.m2ling.domain.core.LinkInstance;
import org.m2ling.domain.core.LinkType;
import org.m2ling.domain.core.MaxConstraint;
import org.m2ling.domain.core.MinConstraint;
import org.m2ling.domain.core.NotNullConstraint;
import org.m2ling.domain.core.OCLConstraint;
import org.m2ling.domain.core.OrganisationalUnit;
import org.m2ling.domain.core.Reference;
import org.m2ling.domain.core.RegexpConstraint;
import org.m2ling.domain.core.Rule;
import org.m2ling.domain.core.RuntimeItem;
import org.m2ling.domain.core.Stakeholder;
import org.m2ling.domain.core.StatusEvent;
import org.m2ling.domain.core.URLConstraint;
import org.m2ling.domain.core.View;
import org.m2ling.domain.core.ViewPoint;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.m2ling.domain.core.CorePackage
 * @generated
 */
public class CoreSwitch<T> extends Switch<T> {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (C) 2012 Bertrand Florat";

	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static CorePackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoreSwitch() {
		if (modelPackage == null) {
			modelPackage = CorePackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case CorePackage.COMPONENT_TYPE: {
				ComponentType componentType = (ComponentType)theEObject;
				T result = caseComponentType(componentType);
				if (result == null) result = caseConceptItem(componentType);
				if (result == null) result = caseHasReferences(componentType);
				if (result == null) result = caseHasNameAndID(componentType);
				if (result == null) result = caseHasCustomProperties(componentType);
				if (result == null) result = caseHasComment(componentType);
				if (result == null) result = caseHasTags(componentType);
				if (result == null) result = caseHasParameterDefinitions(componentType);
				if (result == null) result = caseHasConstraints(componentType);
				if (result == null) result = caseHasDescription(componentType);
				if (result == null) result = caseHasStatus(componentType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.COMPONENT: {
				Component component = (Component)theEObject;
				T result = caseComponent(component);
				if (result == null) result = caseArchitectureItem(component);
				if (result == null) result = caseHasParameterDefinitions(component);
				if (result == null) result = caseHasReferences(component);
				if (result == null) result = caseHasNameAndID(component);
				if (result == null) result = caseHasComment(component);
				if (result == null) result = caseHasTags(component);
				if (result == null) result = caseHasConstraints(component);
				if (result == null) result = caseHasDescription(component);
				if (result == null) result = caseHasStatus(component);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.COMPONENT_INSTANCE: {
				ComponentInstance componentInstance = (ComponentInstance)theEObject;
				T result = caseComponentInstance(componentInstance);
				if (result == null) result = caseRuntimeItem(componentInstance);
				if (result == null) result = caseHasReferences(componentInstance);
				if (result == null) result = caseHasNameAndID(componentInstance);
				if (result == null) result = caseHasComment(componentInstance);
				if (result == null) result = caseHasTags(componentInstance);
				if (result == null) result = caseHasParameterValues(componentInstance);
				if (result == null) result = caseHasConstraints(componentInstance);
				if (result == null) result = caseHasDescription(componentInstance);
				if (result == null) result = caseHasStatus(componentInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.VIEW_POINT: {
				ViewPoint viewPoint = (ViewPoint)theEObject;
				T result = caseViewPoint(viewPoint);
				if (result == null) result = caseHasComment(viewPoint);
				if (result == null) result = caseHasDescription(viewPoint);
				if (result == null) result = caseHasNameAndID(viewPoint);
				if (result == null) result = caseHasTags(viewPoint);
				if (result == null) result = caseHasStatus(viewPoint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.COMPONENT_GROUP: {
				ComponentGroup componentGroup = (ComponentGroup)theEObject;
				T result = caseComponentGroup(componentGroup);
				if (result == null) result = caseArchitectureItem(componentGroup);
				if (result == null) result = caseHasParameterDefinitions(componentGroup);
				if (result == null) result = caseHasNameAndID(componentGroup);
				if (result == null) result = caseHasComment(componentGroup);
				if (result == null) result = caseHasTags(componentGroup);
				if (result == null) result = caseHasConstraints(componentGroup);
				if (result == null) result = caseHasDescription(componentGroup);
				if (result == null) result = caseHasStatus(componentGroup);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.COMPONENT_INSTANCE_GROUP: {
				ComponentInstanceGroup componentInstanceGroup = (ComponentInstanceGroup)theEObject;
				T result = caseComponentInstanceGroup(componentInstanceGroup);
				if (result == null) result = caseRuntimeItem(componentInstanceGroup);
				if (result == null) result = caseHasNameAndID(componentInstanceGroup);
				if (result == null) result = caseHasComment(componentInstanceGroup);
				if (result == null) result = caseHasTags(componentInstanceGroup);
				if (result == null) result = caseHasParameterValues(componentInstanceGroup);
				if (result == null) result = caseHasConstraints(componentInstanceGroup);
				if (result == null) result = caseHasDescription(componentInstanceGroup);
				if (result == null) result = caseHasStatus(componentInstanceGroup);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.ARCHITECTURE_ITEM: {
				ArchitectureItem architectureItem = (ArchitectureItem)theEObject;
				T result = caseArchitectureItem(architectureItem);
				if (result == null) result = caseHasNameAndID(architectureItem);
				if (result == null) result = caseHasComment(architectureItem);
				if (result == null) result = caseHasTags(architectureItem);
				if (result == null) result = caseHasConstraints(architectureItem);
				if (result == null) result = caseHasDescription(architectureItem);
				if (result == null) result = caseHasStatus(architectureItem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.CONCEPT_ITEM: {
				ConceptItem conceptItem = (ConceptItem)theEObject;
				T result = caseConceptItem(conceptItem);
				if (result == null) result = caseHasNameAndID(conceptItem);
				if (result == null) result = caseHasCustomProperties(conceptItem);
				if (result == null) result = caseHasComment(conceptItem);
				if (result == null) result = caseHasTags(conceptItem);
				if (result == null) result = caseHasParameterDefinitions(conceptItem);
				if (result == null) result = caseHasConstraints(conceptItem);
				if (result == null) result = caseHasDescription(conceptItem);
				if (result == null) result = caseHasStatus(conceptItem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.RUNTIME_ITEM: {
				RuntimeItem runtimeItem = (RuntimeItem)theEObject;
				T result = caseRuntimeItem(runtimeItem);
				if (result == null) result = caseHasNameAndID(runtimeItem);
				if (result == null) result = caseHasComment(runtimeItem);
				if (result == null) result = caseHasTags(runtimeItem);
				if (result == null) result = caseHasParameterValues(runtimeItem);
				if (result == null) result = caseHasConstraints(runtimeItem);
				if (result == null) result = caseHasDescription(runtimeItem);
				if (result == null) result = caseHasStatus(runtimeItem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.VIEW: {
				View view = (View)theEObject;
				T result = caseView(view);
				if (result == null) result = caseHasComment(view);
				if (result == null) result = caseHasDescription(view);
				if (result == null) result = caseHasNameAndID(view);
				if (result == null) result = caseHasTags(view);
				if (result == null) result = caseHasStatus(view);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.HAS_STATUS: {
				HasStatus hasStatus = (HasStatus)theEObject;
				T result = caseHasStatus(hasStatus);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.HAS_NAME_AND_ID: {
				HasNameAndID hasNameAndID = (HasNameAndID)theEObject;
				T result = caseHasNameAndID(hasNameAndID);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.HAS_TAGS: {
				HasTags hasTags = (HasTags)theEObject;
				T result = caseHasTags(hasTags);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.HAS_COMMENT: {
				HasComment hasComment = (HasComment)theEObject;
				T result = caseHasComment(hasComment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.HAS_CUSTOM_PROPERTIES: {
				HasCustomProperties hasCustomProperties = (HasCustomProperties)theEObject;
				T result = caseHasCustomProperties(hasCustomProperties);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.HAS_PARAMETER_DEFINITIONS: {
				HasParameterDefinitions hasParameterDefinitions = (HasParameterDefinitions)theEObject;
				T result = caseHasParameterDefinitions(hasParameterDefinitions);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.HAS_PARAMETER_VALUES: {
				HasParameterValues hasParameterValues = (HasParameterValues)theEObject;
				T result = caseHasParameterValues(hasParameterValues);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.HAS_DESCRIPTION: {
				HasDescription hasDescription = (HasDescription)theEObject;
				T result = caseHasDescription(hasDescription);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.HAS_CONSTRAINTS: {
				HasConstraints hasConstraints = (HasConstraints)theEObject;
				T result = caseHasConstraints(hasConstraints);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.HAS_REFERENCES: {
				HasReferences hasReferences = (HasReferences)theEObject;
				T result = caseHasReferences(hasReferences);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.CUSTOM_PROPERTY: {
				CustomProperty customProperty = (CustomProperty)theEObject;
				T result = caseCustomProperty(customProperty);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.LINK_TYPE: {
				LinkType linkType = (LinkType)theEObject;
				T result = caseLinkType(linkType);
				if (result == null) result = caseConceptItem(linkType);
				if (result == null) result = caseHasNameAndID(linkType);
				if (result == null) result = caseHasCustomProperties(linkType);
				if (result == null) result = caseHasComment(linkType);
				if (result == null) result = caseHasTags(linkType);
				if (result == null) result = caseHasParameterDefinitions(linkType);
				if (result == null) result = caseHasConstraints(linkType);
				if (result == null) result = caseHasDescription(linkType);
				if (result == null) result = caseHasStatus(linkType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.LINK: {
				Link link = (Link)theEObject;
				T result = caseLink(link);
				if (result == null) result = caseArchitectureItem(link);
				if (result == null) result = caseHasNameAndID(link);
				if (result == null) result = caseHasComment(link);
				if (result == null) result = caseHasTags(link);
				if (result == null) result = caseHasConstraints(link);
				if (result == null) result = caseHasDescription(link);
				if (result == null) result = caseHasStatus(link);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.LINK_INSTANCE: {
				LinkInstance linkInstance = (LinkInstance)theEObject;
				T result = caseLinkInstance(linkInstance);
				if (result == null) result = caseRuntimeItem(linkInstance);
				if (result == null) result = caseHasNameAndID(linkInstance);
				if (result == null) result = caseHasComment(linkInstance);
				if (result == null) result = caseHasTags(linkInstance);
				if (result == null) result = caseHasParameterValues(linkInstance);
				if (result == null) result = caseHasConstraints(linkInstance);
				if (result == null) result = caseHasDescription(linkInstance);
				if (result == null) result = caseHasStatus(linkInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.STAKEHOLDER: {
				Stakeholder stakeholder = (Stakeholder)theEObject;
				T result = caseStakeholder(stakeholder);
				if (result == null) result = caseHasNameAndID(stakeholder);
				if (result == null) result = caseHasDescription(stakeholder);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.CONSTRAINT: {
				Constraint constraint = (Constraint)theEObject;
				T result = caseConstraint(constraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.FLOAT_CONSTRAINT: {
				FloatConstraint floatConstraint = (FloatConstraint)theEObject;
				T result = caseFloatConstraint(floatConstraint);
				if (result == null) result = caseConstraint(floatConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.MIN_CONSTRAINT: {
				MinConstraint minConstraint = (MinConstraint)theEObject;
				T result = caseMinConstraint(minConstraint);
				if (result == null) result = caseBoundaryConstraint(minConstraint);
				if (result == null) result = caseConstraint(minConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.BOUNDARY_CONSTRAINT: {
				BoundaryConstraint boundaryConstraint = (BoundaryConstraint)theEObject;
				T result = caseBoundaryConstraint(boundaryConstraint);
				if (result == null) result = caseConstraint(boundaryConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.URL_CONSTRAINT: {
				URLConstraint urlConstraint = (URLConstraint)theEObject;
				T result = caseURLConstraint(urlConstraint);
				if (result == null) result = caseConstraint(urlConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.NOT_NULL_CONSTRAINT: {
				NotNullConstraint notNullConstraint = (NotNullConstraint)theEObject;
				T result = caseNotNullConstraint(notNullConstraint);
				if (result == null) result = caseConstraint(notNullConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.REGEXP_CONSTRAINT: {
				RegexpConstraint regexpConstraint = (RegexpConstraint)theEObject;
				T result = caseRegexpConstraint(regexpConstraint);
				if (result == null) result = caseConstraint(regexpConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.OCL_CONSTRAINT: {
				OCLConstraint oclConstraint = (OCLConstraint)theEObject;
				T result = caseOCLConstraint(oclConstraint);
				if (result == null) result = caseConstraint(oclConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.INTEGER_CONSTRAINT: {
				IntegerConstraint integerConstraint = (IntegerConstraint)theEObject;
				T result = caseIntegerConstraint(integerConstraint);
				if (result == null) result = caseConstraint(integerConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.MAX_CONSTRAINT: {
				MaxConstraint maxConstraint = (MaxConstraint)theEObject;
				T result = caseMaxConstraint(maxConstraint);
				if (result == null) result = caseBoundaryConstraint(maxConstraint);
				if (result == null) result = caseConstraint(maxConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.EMAIL_CONSTRAINT: {
				EMailConstraint eMailConstraint = (EMailConstraint)theEObject;
				T result = caseEMailConstraint(eMailConstraint);
				if (result == null) result = caseConstraint(eMailConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.FORMAT_CONSTRAINT: {
				FormatConstraint formatConstraint = (FormatConstraint)theEObject;
				T result = caseFormatConstraint(formatConstraint);
				if (result == null) result = caseConstraint(formatConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.ACTIVITY: {
				Activity activity = (Activity)theEObject;
				T result = caseActivity(activity);
				if (result == null) result = caseHasNameAndID(activity);
				if (result == null) result = caseHasTags(activity);
				if (result == null) result = caseHasDescription(activity);
				if (result == null) result = caseHasStatus(activity);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.ACTIVITY_TRANSITION: {
				ActivityTransition activityTransition = (ActivityTransition)theEObject;
				T result = caseActivityTransition(activityTransition);
				if (result == null) result = caseHasComment(activityTransition);
				if (result == null) result = caseHasDescription(activityTransition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.ORGANISATIONAL_UNIT: {
				OrganisationalUnit organisationalUnit = (OrganisationalUnit)theEObject;
				T result = caseOrganisationalUnit(organisationalUnit);
				if (result == null) result = caseHasComment(organisationalUnit);
				if (result == null) result = caseHasCustomProperties(organisationalUnit);
				if (result == null) result = caseHasNameAndID(organisationalUnit);
				if (result == null) result = caseHasTags(organisationalUnit);
				if (result == null) result = caseHasDescription(organisationalUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.ACTOR: {
				Actor actor = (Actor)theEObject;
				T result = caseActor(actor);
				if (result == null) result = caseHasCustomProperties(actor);
				if (result == null) result = caseHasTags(actor);
				if (result == null) result = caseHasDescription(actor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.RULE: {
				Rule rule = (Rule)theEObject;
				T result = caseRule(rule);
				if (result == null) result = caseHasNameAndID(rule);
				if (result == null) result = caseHasCustomProperties(rule);
				if (result == null) result = caseHasComment(rule);
				if (result == null) result = caseHasTags(rule);
				if (result == null) result = caseHasDescription(rule);
				if (result == null) result = caseHasStatus(rule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.REFERENCE: {
				Reference reference = (Reference)theEObject;
				T result = caseReference(reference);
				if (result == null) result = caseHasComment(reference);
				if (result == null) result = caseHasConstraints(reference);
				if (result == null) result = caseHasCustomProperties(reference);
				if (result == null) result = caseHasDescription(reference);
				if (result == null) result = caseHasStatus(reference);
				if (result == null) result = caseHasTags(reference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.STATUS_EVENT: {
				StatusEvent statusEvent = (StatusEvent)theEObject;
				T result = caseStatusEvent(statusEvent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Component Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Component Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComponentType(ComponentType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Component</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Component</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComponent(Component object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Component Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Component Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComponentInstance(ComponentInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Has Name And ID</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Has Name And ID</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHasNameAndID(HasNameAndID object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>View Point</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>View Point</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseViewPoint(ViewPoint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Component Group</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Component Group</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComponentGroup(ComponentGroup object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Component Instance Group</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Component Instance Group</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComponentInstanceGroup(ComponentInstanceGroup object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Architecture Item</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Architecture Item</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseArchitectureItem(ArchitectureItem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Concept Item</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Concept Item</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConceptItem(ConceptItem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Runtime Item</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Runtime Item</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRuntimeItem(RuntimeItem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>View</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>View</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseView(View object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Has Status</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Has Status</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHasStatus(HasStatus object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Has Tags</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Has Tags</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHasTags(HasTags object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Has Comment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Has Comment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHasComment(HasComment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Has Custom Properties</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Has Custom Properties</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHasCustomProperties(HasCustomProperties object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Custom Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Custom Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCustomProperty(CustomProperty object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Link Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Link Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLinkType(LinkType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Link</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Link</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLink(Link object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Link Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Link Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLinkInstance(LinkInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Has Parameter Definitions</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Has Parameter Definitions</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHasParameterDefinitions(HasParameterDefinitions object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Has Parameter Values</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Has Parameter Values</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHasParameterValues(HasParameterValues object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Has Description</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Has Description</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHasDescription(HasDescription object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Stakeholder</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Stakeholder</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStakeholder(Stakeholder object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConstraint(Constraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Float Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Float Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFloatConstraint(FloatConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Min Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Min Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMinConstraint(MinConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Boundary Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boundary Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBoundaryConstraint(BoundaryConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>URL Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>URL Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseURLConstraint(URLConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Not Null Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Not Null Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNotNullConstraint(NotNullConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Regexp Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Regexp Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRegexpConstraint(RegexpConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>OCL Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>OCL Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOCLConstraint(OCLConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Integer Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Integer Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIntegerConstraint(IntegerConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Max Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Max Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMaxConstraint(MaxConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EMail Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EMail Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEMailConstraint(EMailConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Format Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Format Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFormatConstraint(FormatConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Has Constraints</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Has Constraints</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHasConstraints(HasConstraints object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Has References</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Has References</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHasReferences(HasReferences object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Activity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Activity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActivity(Activity object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Activity Transition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Activity Transition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActivityTransition(ActivityTransition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Organisational Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Organisational Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOrganisationalUnit(OrganisationalUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Actor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Actor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActor(Actor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRule(Rule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReference(Reference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Status Event</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Status Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStatusEvent(StatusEvent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //CoreSwitch

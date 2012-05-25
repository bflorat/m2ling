/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.domain.core.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.m2ling.domain.core.Activity;
import org.m2ling.domain.core.ActivityTransition;
import org.m2ling.domain.core.Actor;
import org.m2ling.domain.core.AdminsReference;
import org.m2ling.domain.core.ArchitectureItem;
import org.m2ling.domain.core.BoundaryConstraint;
import org.m2ling.domain.core.Component;
import org.m2ling.domain.core.ComponentGroup;
import org.m2ling.domain.core.ComponentInstance;
import org.m2ling.domain.core.ComponentInstanceGroup;
import org.m2ling.domain.core.ComponentType;
import org.m2ling.domain.core.ConceptItem;
import org.m2ling.domain.core.Constraint;
import org.m2ling.domain.core.ContainsReference;
import org.m2ling.domain.core.CorePackage;
import org.m2ling.domain.core.CustomProperty;
import org.m2ling.domain.core.DependsOnReference;
import org.m2ling.domain.core.EMailConstraint;
import org.m2ling.domain.core.FloatConstraint;
import org.m2ling.domain.core.FormatConstraint;
import org.m2ling.domain.core.HasComment;
import org.m2ling.domain.core.HasConstraints;
import org.m2ling.domain.core.HasCustomProperties;
import org.m2ling.domain.core.HasLabel;
import org.m2ling.domain.core.HasNameAndID;
import org.m2ling.domain.core.HasParameterDefinitions;
import org.m2ling.domain.core.HasParameterValues;
import org.m2ling.domain.core.HasStatus;
import org.m2ling.domain.core.HasTags;
import org.m2ling.domain.core.InstancesLink;
import org.m2ling.domain.core.IntegerConstraint;
import org.m2ling.domain.core.Link;
import org.m2ling.domain.core.LinkType;
import org.m2ling.domain.core.MaxConstraint;
import org.m2ling.domain.core.MinConstraint;
import org.m2ling.domain.core.NotNullConstraint;
import org.m2ling.domain.core.OCLConstraint;
import org.m2ling.domain.core.OrganisationalUnit;
import org.m2ling.domain.core.Reference;
import org.m2ling.domain.core.RegexpConstraint;
import org.m2ling.domain.core.Rule;
import org.m2ling.domain.core.RunsReference;
import org.m2ling.domain.core.RuntimeItem;
import org.m2ling.domain.core.Stakeholder;
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
public class CoreSwitch<T1> extends Switch<T1> {
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
	protected T1 doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case CorePackage.COMPONENT_TYPE: {
				ComponentType componentType = (ComponentType)theEObject;
				T1 result = caseComponentType(componentType);
				if (result == null) result = caseConceptItem(componentType);
				if (result == null) result = caseHasNameAndID(componentType);
				if (result == null) result = caseHasCustomProperties(componentType);
				if (result == null) result = caseHasComment(componentType);
				if (result == null) result = caseHasTags(componentType);
				if (result == null) result = caseHasParameterDefinitions(componentType);
				if (result == null) result = caseHasConstraints(componentType);
				if (result == null) result = caseHasLabel(componentType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.COMPONENT: {
				Component component = (Component)theEObject;
				T1 result = caseComponent(component);
				if (result == null) result = caseComponentGroup(component);
				if (result == null) result = caseArchitectureItem(component);
				if (result == null) result = caseHasNameAndID(component);
				if (result == null) result = caseHasComment(component);
				if (result == null) result = caseHasTags(component);
				if (result == null) result = caseHasParameterDefinitions(component);
				if (result == null) result = caseHasConstraints(component);
				if (result == null) result = caseHasLabel(component);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.COMPONENT_INSTANCE: {
				ComponentInstance componentInstance = (ComponentInstance)theEObject;
				T1 result = caseComponentInstance(componentInstance);
				if (result == null) result = caseComponentInstanceGroup(componentInstance);
				if (result == null) result = caseRuntimeItem(componentInstance);
				if (result == null) result = caseHasNameAndID(componentInstance);
				if (result == null) result = caseHasComment(componentInstance);
				if (result == null) result = caseHasTags(componentInstance);
				if (result == null) result = caseHasParameterValues(componentInstance);
				if (result == null) result = caseHasConstraints(componentInstance);
				if (result == null) result = caseHasLabel(componentInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.VIEW_POINT: {
				ViewPoint viewPoint = (ViewPoint)theEObject;
				T1 result = caseViewPoint(viewPoint);
				if (result == null) result = caseConceptItem(viewPoint);
				if (result == null) result = caseHasNameAndID(viewPoint);
				if (result == null) result = caseHasCustomProperties(viewPoint);
				if (result == null) result = caseHasComment(viewPoint);
				if (result == null) result = caseHasTags(viewPoint);
				if (result == null) result = caseHasParameterDefinitions(viewPoint);
				if (result == null) result = caseHasConstraints(viewPoint);
				if (result == null) result = caseHasLabel(viewPoint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.COMPONENT_GROUP: {
				ComponentGroup componentGroup = (ComponentGroup)theEObject;
				T1 result = caseComponentGroup(componentGroup);
				if (result == null) result = caseArchitectureItem(componentGroup);
				if (result == null) result = caseHasNameAndID(componentGroup);
				if (result == null) result = caseHasComment(componentGroup);
				if (result == null) result = caseHasTags(componentGroup);
				if (result == null) result = caseHasParameterDefinitions(componentGroup);
				if (result == null) result = caseHasConstraints(componentGroup);
				if (result == null) result = caseHasLabel(componentGroup);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.COMPONENT_INSTANCE_GROUP: {
				ComponentInstanceGroup componentInstanceGroup = (ComponentInstanceGroup)theEObject;
				T1 result = caseComponentInstanceGroup(componentInstanceGroup);
				if (result == null) result = caseRuntimeItem(componentInstanceGroup);
				if (result == null) result = caseHasNameAndID(componentInstanceGroup);
				if (result == null) result = caseHasComment(componentInstanceGroup);
				if (result == null) result = caseHasTags(componentInstanceGroup);
				if (result == null) result = caseHasParameterValues(componentInstanceGroup);
				if (result == null) result = caseHasConstraints(componentInstanceGroup);
				if (result == null) result = caseHasLabel(componentInstanceGroup);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.ARCHITECTURE_ITEM: {
				ArchitectureItem architectureItem = (ArchitectureItem)theEObject;
				T1 result = caseArchitectureItem(architectureItem);
				if (result == null) result = caseHasNameAndID(architectureItem);
				if (result == null) result = caseHasComment(architectureItem);
				if (result == null) result = caseHasTags(architectureItem);
				if (result == null) result = caseHasParameterDefinitions(architectureItem);
				if (result == null) result = caseHasConstraints(architectureItem);
				if (result == null) result = caseHasLabel(architectureItem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.CONCEPT_ITEM: {
				ConceptItem conceptItem = (ConceptItem)theEObject;
				T1 result = caseConceptItem(conceptItem);
				if (result == null) result = caseHasNameAndID(conceptItem);
				if (result == null) result = caseHasCustomProperties(conceptItem);
				if (result == null) result = caseHasComment(conceptItem);
				if (result == null) result = caseHasTags(conceptItem);
				if (result == null) result = caseHasParameterDefinitions(conceptItem);
				if (result == null) result = caseHasConstraints(conceptItem);
				if (result == null) result = caseHasLabel(conceptItem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.RUNTIME_ITEM: {
				RuntimeItem runtimeItem = (RuntimeItem)theEObject;
				T1 result = caseRuntimeItem(runtimeItem);
				if (result == null) result = caseHasNameAndID(runtimeItem);
				if (result == null) result = caseHasComment(runtimeItem);
				if (result == null) result = caseHasTags(runtimeItem);
				if (result == null) result = caseHasParameterValues(runtimeItem);
				if (result == null) result = caseHasConstraints(runtimeItem);
				if (result == null) result = caseHasLabel(runtimeItem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.VIEW: {
				View view = (View)theEObject;
				T1 result = caseView(view);
				if (result == null) result = caseArchitectureItem(view);
				if (result == null) result = caseHasNameAndID(view);
				if (result == null) result = caseHasComment(view);
				if (result == null) result = caseHasTags(view);
				if (result == null) result = caseHasParameterDefinitions(view);
				if (result == null) result = caseHasConstraints(view);
				if (result == null) result = caseHasLabel(view);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.HAS_STATUS: {
				HasStatus hasStatus = (HasStatus)theEObject;
				T1 result = caseHasStatus(hasStatus);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.HAS_NAME_AND_ID: {
				HasNameAndID hasNameAndID = (HasNameAndID)theEObject;
				T1 result = caseHasNameAndID(hasNameAndID);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.HAS_TAGS: {
				HasTags hasTags = (HasTags)theEObject;
				T1 result = caseHasTags(hasTags);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.HAS_COMMENT: {
				HasComment hasComment = (HasComment)theEObject;
				T1 result = caseHasComment(hasComment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.HAS_CUSTOM_PROPERTIES: {
				HasCustomProperties hasCustomProperties = (HasCustomProperties)theEObject;
				T1 result = caseHasCustomProperties(hasCustomProperties);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.HAS_PARAMETER_DEFINITIONS: {
				HasParameterDefinitions hasParameterDefinitions = (HasParameterDefinitions)theEObject;
				T1 result = caseHasParameterDefinitions(hasParameterDefinitions);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.HAS_PARAMETER_VALUES: {
				HasParameterValues hasParameterValues = (HasParameterValues)theEObject;
				T1 result = caseHasParameterValues(hasParameterValues);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.CUSTOM_PROPERTY: {
				CustomProperty customProperty = (CustomProperty)theEObject;
				T1 result = caseCustomProperty(customProperty);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.LINK_TYPE: {
				LinkType linkType = (LinkType)theEObject;
				T1 result = caseLinkType(linkType);
				if (result == null) result = caseConceptItem(linkType);
				if (result == null) result = caseHasNameAndID(linkType);
				if (result == null) result = caseHasCustomProperties(linkType);
				if (result == null) result = caseHasComment(linkType);
				if (result == null) result = caseHasTags(linkType);
				if (result == null) result = caseHasParameterDefinitions(linkType);
				if (result == null) result = caseHasConstraints(linkType);
				if (result == null) result = caseHasLabel(linkType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.LINK: {
				Link link = (Link)theEObject;
				T1 result = caseLink(link);
				if (result == null) result = caseArchitectureItem(link);
				if (result == null) result = caseHasNameAndID(link);
				if (result == null) result = caseHasComment(link);
				if (result == null) result = caseHasTags(link);
				if (result == null) result = caseHasParameterDefinitions(link);
				if (result == null) result = caseHasConstraints(link);
				if (result == null) result = caseHasLabel(link);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.INSTANCES_LINK: {
				InstancesLink instancesLink = (InstancesLink)theEObject;
				T1 result = caseInstancesLink(instancesLink);
				if (result == null) result = caseRuntimeItem(instancesLink);
				if (result == null) result = caseHasNameAndID(instancesLink);
				if (result == null) result = caseHasComment(instancesLink);
				if (result == null) result = caseHasTags(instancesLink);
				if (result == null) result = caseHasParameterValues(instancesLink);
				if (result == null) result = caseHasConstraints(instancesLink);
				if (result == null) result = caseHasLabel(instancesLink);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.HAS_LABEL: {
				HasLabel hasLabel = (HasLabel)theEObject;
				T1 result = caseHasLabel(hasLabel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.STAKEHOLDER: {
				Stakeholder stakeholder = (Stakeholder)theEObject;
				T1 result = caseStakeholder(stakeholder);
				if (result == null) result = caseHasNameAndID(stakeholder);
				if (result == null) result = caseHasLabel(stakeholder);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.CONSTRAINT: {
				Constraint constraint = (Constraint)theEObject;
				T1 result = caseConstraint(constraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.FLOAT_CONSTRAINT: {
				FloatConstraint floatConstraint = (FloatConstraint)theEObject;
				T1 result = caseFloatConstraint(floatConstraint);
				if (result == null) result = caseConstraint(floatConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.MIN_CONSTRAINT: {
				MinConstraint minConstraint = (MinConstraint)theEObject;
				T1 result = caseMinConstraint(minConstraint);
				if (result == null) result = caseBoundaryConstraint(minConstraint);
				if (result == null) result = caseConstraint(minConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.BOUNDARY_CONSTRAINT: {
				BoundaryConstraint boundaryConstraint = (BoundaryConstraint)theEObject;
				T1 result = caseBoundaryConstraint(boundaryConstraint);
				if (result == null) result = caseConstraint(boundaryConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.URL_CONSTRAINT: {
				URLConstraint urlConstraint = (URLConstraint)theEObject;
				T1 result = caseURLConstraint(urlConstraint);
				if (result == null) result = caseConstraint(urlConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.NOT_NULL_CONSTRAINT: {
				NotNullConstraint notNullConstraint = (NotNullConstraint)theEObject;
				T1 result = caseNotNullConstraint(notNullConstraint);
				if (result == null) result = caseConstraint(notNullConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.REGEXP_CONSTRAINT: {
				RegexpConstraint regexpConstraint = (RegexpConstraint)theEObject;
				T1 result = caseRegexpConstraint(regexpConstraint);
				if (result == null) result = caseConstraint(regexpConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.OCL_CONSTRAINT: {
				OCLConstraint oclConstraint = (OCLConstraint)theEObject;
				T1 result = caseOCLConstraint(oclConstraint);
				if (result == null) result = caseConstraint(oclConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.INTEGER_CONSTRAINT: {
				IntegerConstraint integerConstraint = (IntegerConstraint)theEObject;
				T1 result = caseIntegerConstraint(integerConstraint);
				if (result == null) result = caseConstraint(integerConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.MAX_CONSTRAINT: {
				MaxConstraint maxConstraint = (MaxConstraint)theEObject;
				T1 result = caseMaxConstraint(maxConstraint);
				if (result == null) result = caseBoundaryConstraint(maxConstraint);
				if (result == null) result = caseConstraint(maxConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.EMAIL_CONSTRAINT: {
				EMailConstraint eMailConstraint = (EMailConstraint)theEObject;
				T1 result = caseEMailConstraint(eMailConstraint);
				if (result == null) result = caseConstraint(eMailConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.FORMAT_CONSTRAINT: {
				FormatConstraint formatConstraint = (FormatConstraint)theEObject;
				T1 result = caseFormatConstraint(formatConstraint);
				if (result == null) result = caseConstraint(formatConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.HAS_CONSTRAINTS: {
				HasConstraints hasConstraints = (HasConstraints)theEObject;
				T1 result = caseHasConstraints(hasConstraints);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.ACTIVITY: {
				Activity activity = (Activity)theEObject;
				T1 result = caseActivity(activity);
				if (result == null) result = caseHasNameAndID(activity);
				if (result == null) result = caseHasTags(activity);
				if (result == null) result = caseHasLabel(activity);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.ACTIVITY_TRANSITION: {
				ActivityTransition activityTransition = (ActivityTransition)theEObject;
				T1 result = caseActivityTransition(activityTransition);
				if (result == null) result = caseHasComment(activityTransition);
				if (result == null) result = caseHasLabel(activityTransition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.ORGANISATIONAL_UNIT: {
				OrganisationalUnit organisationalUnit = (OrganisationalUnit)theEObject;
				T1 result = caseOrganisationalUnit(organisationalUnit);
				if (result == null) result = caseHasComment(organisationalUnit);
				if (result == null) result = caseHasCustomProperties(organisationalUnit);
				if (result == null) result = caseHasNameAndID(organisationalUnit);
				if (result == null) result = caseHasTags(organisationalUnit);
				if (result == null) result = caseHasLabel(organisationalUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.ACTOR: {
				Actor actor = (Actor)theEObject;
				T1 result = caseActor(actor);
				if (result == null) result = caseHasCustomProperties(actor);
				if (result == null) result = caseHasTags(actor);
				if (result == null) result = caseHasLabel(actor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.RULE: {
				Rule rule = (Rule)theEObject;
				T1 result = caseRule(rule);
				if (result == null) result = caseHasNameAndID(rule);
				if (result == null) result = caseHasCustomProperties(rule);
				if (result == null) result = caseHasComment(rule);
				if (result == null) result = caseHasTags(rule);
				if (result == null) result = caseHasLabel(rule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.REFERENCE: {
				Reference<?> reference = (Reference<?>)theEObject;
				T1 result = caseReference(reference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.CONTAINS_REFERENCE: {
				ContainsReference<?> containsReference = (ContainsReference<?>)theEObject;
				T1 result = caseContainsReference(containsReference);
				if (result == null) result = caseReference(containsReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.RUNS_REFERENCE: {
				RunsReference<?> runsReference = (RunsReference<?>)theEObject;
				T1 result = caseRunsReference(runsReference);
				if (result == null) result = caseReference(runsReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.DEPENDS_ON_REFERENCE: {
				DependsOnReference<?> dependsOnReference = (DependsOnReference<?>)theEObject;
				T1 result = caseDependsOnReference(dependsOnReference);
				if (result == null) result = caseReference(dependsOnReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.ADMINS_REFERENCE: {
				AdminsReference<?> adminsReference = (AdminsReference<?>)theEObject;
				T1 result = caseAdminsReference(adminsReference);
				if (result == null) result = caseReference(adminsReference);
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
	public T1 caseComponentType(ComponentType object) {
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
	public T1 caseComponent(Component object) {
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
	public T1 caseComponentInstance(ComponentInstance object) {
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
	public T1 caseHasNameAndID(HasNameAndID object) {
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
	public T1 caseViewPoint(ViewPoint object) {
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
	public T1 caseComponentGroup(ComponentGroup object) {
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
	public T1 caseComponentInstanceGroup(ComponentInstanceGroup object) {
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
	public T1 caseArchitectureItem(ArchitectureItem object) {
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
	public T1 caseConceptItem(ConceptItem object) {
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
	public T1 caseRuntimeItem(RuntimeItem object) {
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
	public T1 caseView(View object) {
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
	public T1 caseHasStatus(HasStatus object) {
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
	public T1 caseHasTags(HasTags object) {
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
	public T1 caseHasComment(HasComment object) {
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
	public T1 caseHasCustomProperties(HasCustomProperties object) {
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
	public T1 caseCustomProperty(CustomProperty object) {
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
	public T1 caseLinkType(LinkType object) {
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
	public T1 caseLink(Link object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Instances Link</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Instances Link</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseInstancesLink(InstancesLink object) {
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
	public T1 caseHasParameterDefinitions(HasParameterDefinitions object) {
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
	public T1 caseHasParameterValues(HasParameterValues object) {
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
	public T1 caseStakeholder(Stakeholder object) {
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
	public T1 caseConstraint(Constraint object) {
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
	public T1 caseFloatConstraint(FloatConstraint object) {
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
	public T1 caseMinConstraint(MinConstraint object) {
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
	public T1 caseBoundaryConstraint(BoundaryConstraint object) {
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
	public T1 caseURLConstraint(URLConstraint object) {
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
	public T1 caseNotNullConstraint(NotNullConstraint object) {
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
	public T1 caseRegexpConstraint(RegexpConstraint object) {
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
	public T1 caseOCLConstraint(OCLConstraint object) {
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
	public T1 caseIntegerConstraint(IntegerConstraint object) {
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
	public T1 caseMaxConstraint(MaxConstraint object) {
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
	public T1 caseEMailConstraint(EMailConstraint object) {
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
	public T1 caseFormatConstraint(FormatConstraint object) {
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
	public T1 caseHasConstraints(HasConstraints object) {
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
	public T1 caseActivity(Activity object) {
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
	public T1 caseActivityTransition(ActivityTransition object) {
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
	public T1 caseOrganisationalUnit(OrganisationalUnit object) {
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
	public T1 caseActor(Actor object) {
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
	public T1 caseRule(Rule object) {
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
	public <T extends ComponentType & ComponentInstance & Component> T1 caseReference(Reference<T> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Contains Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Contains Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T extends Component & ComponentInstance & ComponentType> T1 caseContainsReference(ContainsReference<T> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Runs Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Runs Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T extends Component & ComponentInstance & ComponentType> T1 caseRunsReference(RunsReference<T> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Depends On Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Depends On Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T extends Component & ComponentInstance & ComponentType> T1 caseDependsOnReference(DependsOnReference<T> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Admins Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Admins Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T extends Component & ComponentInstance & ComponentType> T1 caseAdminsReference(AdminsReference<T> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Has Label</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Has Label</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseHasLabel(HasLabel object) {
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
	public T1 defaultCase(EObject object) {
		return null;
	}

} //CoreSwitch

/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.domain.core.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.m2ling.domain.core.*;
import org.m2ling.domain.core.Activity;
import org.m2ling.domain.core.ActivityTransition;
import org.m2ling.domain.core.Actor;
import org.m2ling.domain.core.Component;
import org.m2ling.domain.core.ComponentGroup;
import org.m2ling.domain.core.ComponentInstance;
import org.m2ling.domain.core.ComponentInstanceGroup;
import org.m2ling.domain.core.ComponentType;
import org.m2ling.domain.core.CoreFactory;
import org.m2ling.domain.core.CorePackage;
import org.m2ling.domain.core.CustomProperty;
import org.m2ling.domain.core.CustomPropertyType;
import org.m2ling.domain.core.EMailConstraint;
import org.m2ling.domain.core.FloatConstraint;
import org.m2ling.domain.core.FormatConstraint;
import org.m2ling.domain.core.HasComment;
import org.m2ling.domain.core.HasCustomProperties;
import org.m2ling.domain.core.HasNameAndID;
import org.m2ling.domain.core.IntegerConstraint;
import org.m2ling.domain.core.Link;
import org.m2ling.domain.core.LinkAccessType;
import org.m2ling.domain.core.LinkInstance;
import org.m2ling.domain.core.LinkTemporality;
import org.m2ling.domain.core.LinkType;
import org.m2ling.domain.core.MaxConstraint;
import org.m2ling.domain.core.MinConstraint;
import org.m2ling.domain.core.NotNullConstraint;
import org.m2ling.domain.core.OCLConstraint;
import org.m2ling.domain.core.OrganisationalUnit;
import org.m2ling.domain.core.Reference;
import org.m2ling.domain.core.ReferenceType;
import org.m2ling.domain.core.RegexpConstraint;
import org.m2ling.domain.core.Rule;
import org.m2ling.domain.core.Stakeholder;
import org.m2ling.domain.core.StatusEvent;
import org.m2ling.domain.core.Type;
import org.m2ling.domain.core.URLConstraint;
import org.m2ling.domain.core.View;
import org.m2ling.domain.core.ViewPoint;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CoreFactoryImpl extends EFactoryImpl implements CoreFactory {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (C) 2012 Bertrand Florat";

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CoreFactory init() {
		try {
			CoreFactory theCoreFactory = (CoreFactory)EPackage.Registry.INSTANCE.getEFactory("http://m2ling.org/core/0.1"); 
			if (theCoreFactory != null) {
				return theCoreFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new CoreFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoreFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case CorePackage.COMPONENT_TYPE: return createComponentType();
			case CorePackage.COMPONENT: return createComponent();
			case CorePackage.COMPONENT_INSTANCE: return createComponentInstance();
			case CorePackage.VIEW_POINT: return createViewPoint();
			case CorePackage.COMPONENT_GROUP: return createComponentGroup();
			case CorePackage.COMPONENT_INSTANCE_GROUP: return createComponentInstanceGroup();
			case CorePackage.VIEW: return createView();
			case CorePackage.HAS_NAME_AND_ID: return createHasNameAndID();
			case CorePackage.HAS_COMMENT: return createHasComment();
			case CorePackage.HAS_CUSTOM_PROPERTIES: return createHasCustomProperties();
			case CorePackage.CUSTOM_PROPERTY: return createCustomProperty();
			case CorePackage.LINK_TYPE: return createLinkType();
			case CorePackage.LINK: return createLink();
			case CorePackage.LINK_INSTANCE: return createLinkInstance();
			case CorePackage.STAKEHOLDER: return createStakeholder();
			case CorePackage.FLOAT_CONSTRAINT: return createFloatConstraint();
			case CorePackage.MIN_CONSTRAINT: return createMinConstraint();
			case CorePackage.URL_CONSTRAINT: return createURLConstraint();
			case CorePackage.NOT_NULL_CONSTRAINT: return createNotNullConstraint();
			case CorePackage.REGEXP_CONSTRAINT: return createRegexpConstraint();
			case CorePackage.OCL_CONSTRAINT: return createOCLConstraint();
			case CorePackage.INTEGER_CONSTRAINT: return createIntegerConstraint();
			case CorePackage.MAX_CONSTRAINT: return createMaxConstraint();
			case CorePackage.EMAIL_CONSTRAINT: return createEMailConstraint();
			case CorePackage.FORMAT_CONSTRAINT: return createFormatConstraint();
			case CorePackage.ACTIVITY: return createActivity();
			case CorePackage.ACTIVITY_TRANSITION: return createActivityTransition();
			case CorePackage.ORGANISATIONAL_UNIT: return createOrganisationalUnit();
			case CorePackage.ACTOR: return createActor();
			case CorePackage.RULE: return createRule();
			case CorePackage.REFERENCE: return createReference();
			case CorePackage.STATUS_EVENT: return createStatusEvent();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case CorePackage.CUSTOM_PROPERTY_TYPE:
				return createCustomPropertyTypeFromString(eDataType, initialValue);
			case CorePackage.TYPE:
				return createTypeFromString(eDataType, initialValue);
			case CorePackage.REFERENCE_TYPE:
				return createReferenceTypeFromString(eDataType, initialValue);
			case CorePackage.LINK_TEMPORALITY:
				return createLinkTemporalityFromString(eDataType, initialValue);
			case CorePackage.LINK_ACCESS_TYPE:
				return createLinkAccessTypeFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case CorePackage.CUSTOM_PROPERTY_TYPE:
				return convertCustomPropertyTypeToString(eDataType, instanceValue);
			case CorePackage.TYPE:
				return convertTypeToString(eDataType, instanceValue);
			case CorePackage.REFERENCE_TYPE:
				return convertReferenceTypeToString(eDataType, instanceValue);
			case CorePackage.LINK_TEMPORALITY:
				return convertLinkTemporalityToString(eDataType, instanceValue);
			case CorePackage.LINK_ACCESS_TYPE:
				return convertLinkAccessTypeToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentType createComponentType() {
		ComponentTypeImpl componentType = new ComponentTypeImpl();
		return componentType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Component createComponent() {
		ComponentImpl component = new ComponentImpl();
		return component;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentInstance createComponentInstance() {
		ComponentInstanceImpl componentInstance = new ComponentInstanceImpl();
		return componentInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HasNameAndID createHasNameAndID() {
		HasNameAndIDImpl hasNameAndID = new HasNameAndIDImpl();
		return hasNameAndID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ViewPoint createViewPoint() {
		ViewPointImpl viewPoint = new ViewPointImpl();
		return viewPoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentGroup createComponentGroup() {
		ComponentGroupImpl componentGroup = new ComponentGroupImpl();
		return componentGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentInstanceGroup createComponentInstanceGroup() {
		ComponentInstanceGroupImpl componentInstanceGroup = new ComponentInstanceGroupImpl();
		return componentInstanceGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public View createView() {
		ViewImpl view = new ViewImpl();
		return view;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HasComment createHasComment() {
		HasCommentImpl hasComment = new HasCommentImpl();
		return hasComment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HasCustomProperties createHasCustomProperties() {
		HasCustomPropertiesImpl hasCustomProperties = new HasCustomPropertiesImpl();
		return hasCustomProperties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CustomProperty createCustomProperty() {
		CustomPropertyImpl customProperty = new CustomPropertyImpl();
		return customProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LinkType createLinkType() {
		LinkTypeImpl linkType = new LinkTypeImpl();
		return linkType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Link createLink() {
		LinkImpl link = new LinkImpl();
		return link;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LinkInstance createLinkInstance() {
		LinkInstanceImpl linkInstance = new LinkInstanceImpl();
		return linkInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Stakeholder createStakeholder() {
		StakeholderImpl stakeholder = new StakeholderImpl();
		return stakeholder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FloatConstraint createFloatConstraint() {
		FloatConstraintImpl floatConstraint = new FloatConstraintImpl();
		return floatConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MinConstraint createMinConstraint() {
		MinConstraintImpl minConstraint = new MinConstraintImpl();
		return minConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public URLConstraint createURLConstraint() {
		URLConstraintImpl urlConstraint = new URLConstraintImpl();
		return urlConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotNullConstraint createNotNullConstraint() {
		NotNullConstraintImpl notNullConstraint = new NotNullConstraintImpl();
		return notNullConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegexpConstraint createRegexpConstraint() {
		RegexpConstraintImpl regexpConstraint = new RegexpConstraintImpl();
		return regexpConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLConstraint createOCLConstraint() {
		OCLConstraintImpl oclConstraint = new OCLConstraintImpl();
		return oclConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntegerConstraint createIntegerConstraint() {
		IntegerConstraintImpl integerConstraint = new IntegerConstraintImpl();
		return integerConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MaxConstraint createMaxConstraint() {
		MaxConstraintImpl maxConstraint = new MaxConstraintImpl();
		return maxConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMailConstraint createEMailConstraint() {
		EMailConstraintImpl eMailConstraint = new EMailConstraintImpl();
		return eMailConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FormatConstraint createFormatConstraint() {
		FormatConstraintImpl formatConstraint = new FormatConstraintImpl();
		return formatConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Activity createActivity() {
		ActivityImpl activity = new ActivityImpl();
		return activity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActivityTransition createActivityTransition() {
		ActivityTransitionImpl activityTransition = new ActivityTransitionImpl();
		return activityTransition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OrganisationalUnit createOrganisationalUnit() {
		OrganisationalUnitImpl organisationalUnit = new OrganisationalUnitImpl();
		return organisationalUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Actor createActor() {
		ActorImpl actor = new ActorImpl();
		return actor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Rule createRule() {
		RuleImpl rule = new RuleImpl();
		return rule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Reference createReference() {
		ReferenceImpl reference = new ReferenceImpl();
		return reference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StatusEvent createStatusEvent() {
		StatusEventImpl statusEvent = new StatusEventImpl();
		return statusEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CustomPropertyType createCustomPropertyTypeFromString(EDataType eDataType, String initialValue) {
		CustomPropertyType result = CustomPropertyType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCustomPropertyTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type createTypeFromString(EDataType eDataType, String initialValue) {
		Type result = Type.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReferenceType createReferenceTypeFromString(EDataType eDataType, String initialValue) {
		ReferenceType result = ReferenceType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertReferenceTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LinkTemporality createLinkTemporalityFromString(EDataType eDataType, String initialValue) {
		LinkTemporality result = LinkTemporality.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLinkTemporalityToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LinkAccessType createLinkAccessTypeFromString(EDataType eDataType, String initialValue) {
		LinkAccessType result = LinkAccessType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLinkAccessTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CorePackage getCorePackage() {
		return (CorePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static CorePackage getPackage() {
		return CorePackage.eINSTANCE;
	}

} //CoreFactoryImpl

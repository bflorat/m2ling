/**
 * Copyright (C) Bertrand Florat
 */
package org.m2ling.domain.parameters.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.m2ling.domain.core.CorePackage;
import org.m2ling.domain.core.impl.CorePackageImpl;
import org.m2ling.domain.parameters.ParamDefOverrider;
import org.m2ling.domain.parameters.ParameterDefinition;
import org.m2ling.domain.parameters.ParameterType;
import org.m2ling.domain.parameters.ParameterValue;
import org.m2ling.domain.parameters.ParametersFactory;
import org.m2ling.domain.parameters.ParametersPackage;
import org.m2ling.domain.principles.PrinciplesPackage;
import org.m2ling.domain.principles.impl.PrinciplesPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ParametersPackageImpl extends EPackageImpl implements ParametersPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (C) Bertrand Florat";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parameterValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parameterDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass paramDefOverriderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum parameterTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType eStructuralFeatureEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.m2ling.domain.parameters.ParametersPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ParametersPackageImpl() {
		super(eNS_URI, ParametersFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link ParametersPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ParametersPackage init() {
		if (isInited) return (ParametersPackage)EPackage.Registry.INSTANCE.getEPackage(ParametersPackage.eNS_URI);

		// Obtain or create and register package
		ParametersPackageImpl theParametersPackage = (ParametersPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ParametersPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ParametersPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		CorePackageImpl theCorePackage = (CorePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI) instanceof CorePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI) : CorePackage.eINSTANCE);
		PrinciplesPackageImpl thePrinciplesPackage = (PrinciplesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(PrinciplesPackage.eNS_URI) instanceof PrinciplesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(PrinciplesPackage.eNS_URI) : PrinciplesPackage.eINSTANCE);

		// Create package meta-data objects
		theParametersPackage.createPackageContents();
		theCorePackage.createPackageContents();
		thePrinciplesPackage.createPackageContents();

		// Initialize created meta-data
		theParametersPackage.initializePackageContents();
		theCorePackage.initializePackageContents();
		thePrinciplesPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theParametersPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ParametersPackage.eNS_URI, theParametersPackage);
		return theParametersPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParameterValue() {
		return parameterValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParameterValue_Parent() {
		return (EReference)parameterValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParameterValue_Definition() {
		return (EReference)parameterValueEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParameterValue_Value() {
		return (EAttribute)parameterValueEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParameterDefinition() {
		return parameterDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParameterDefinition_Parent() {
		return (EReference)parameterDefinitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParameterDefinition_Constraints() {
		return (EReference)parameterDefinitionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParameterDefinition_Type() {
		return (EAttribute)parameterDefinitionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParameterDefinition_Description() {
		return (EAttribute)parameterDefinitionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParameterDefinition_DefaultValue() {
		return (EAttribute)parameterDefinitionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParameterDefinition_ExampleValue() {
		return (EAttribute)parameterDefinitionEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParameterDefinition_DerivationExpression() {
		return (EAttribute)parameterDefinitionEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParameterDefinition_Overriders() {
		return (EReference)parameterDefinitionEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParameterDefinition_LongDescription() {
		return (EAttribute)parameterDefinitionEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParamDefOverrider() {
		return paramDefOverriderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParamDefOverrider_OverridedFeature() {
		return (EAttribute)paramDefOverriderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParamDefOverrider_Environment() {
		return (EAttribute)paramDefOverriderEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParamDefOverrider_Value() {
		return (EAttribute)paramDefOverriderEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getParameterType() {
		return parameterTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getEStructuralFeature() {
		return eStructuralFeatureEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParametersFactory getParametersFactory() {
		return (ParametersFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		parameterValueEClass = createEClass(PARAMETER_VALUE);
		createEReference(parameterValueEClass, PARAMETER_VALUE__PARENT);
		createEReference(parameterValueEClass, PARAMETER_VALUE__DEFINITION);
		createEAttribute(parameterValueEClass, PARAMETER_VALUE__VALUE);

		parameterDefinitionEClass = createEClass(PARAMETER_DEFINITION);
		createEReference(parameterDefinitionEClass, PARAMETER_DEFINITION__PARENT);
		createEReference(parameterDefinitionEClass, PARAMETER_DEFINITION__CONSTRAINTS);
		createEAttribute(parameterDefinitionEClass, PARAMETER_DEFINITION__TYPE);
		createEAttribute(parameterDefinitionEClass, PARAMETER_DEFINITION__DESCRIPTION);
		createEAttribute(parameterDefinitionEClass, PARAMETER_DEFINITION__DEFAULT_VALUE);
		createEAttribute(parameterDefinitionEClass, PARAMETER_DEFINITION__EXAMPLE_VALUE);
		createEAttribute(parameterDefinitionEClass, PARAMETER_DEFINITION__DERIVATION_EXPRESSION);
		createEReference(parameterDefinitionEClass, PARAMETER_DEFINITION__OVERRIDERS);
		createEAttribute(parameterDefinitionEClass, PARAMETER_DEFINITION__LONG_DESCRIPTION);

		paramDefOverriderEClass = createEClass(PARAM_DEF_OVERRIDER);
		createEAttribute(paramDefOverriderEClass, PARAM_DEF_OVERRIDER__OVERRIDED_FEATURE);
		createEAttribute(paramDefOverriderEClass, PARAM_DEF_OVERRIDER__ENVIRONMENT);
		createEAttribute(paramDefOverriderEClass, PARAM_DEF_OVERRIDER__VALUE);

		// Create enums
		parameterTypeEEnum = createEEnum(PARAMETER_TYPE);

		// Create data types
		eStructuralFeatureEDataType = createEDataType(ESTRUCTURAL_FEATURE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		CorePackage theCorePackage = (CorePackage)EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		parameterValueEClass.getESuperTypes().add(theCorePackage.getHasComment());
		parameterValueEClass.getESuperTypes().add(theCorePackage.getHasCustomProperties());
		parameterDefinitionEClass.getESuperTypes().add(theCorePackage.getHasComment());
		parameterDefinitionEClass.getESuperTypes().add(theCorePackage.getHasCustomProperties());
		parameterDefinitionEClass.getESuperTypes().add(theCorePackage.getHasNameAndID());
		parameterDefinitionEClass.getESuperTypes().add(theCorePackage.getHasConstraints());

		// Initialize classes and features; add operations and parameters
		initEClass(parameterValueEClass, ParameterValue.class, "ParameterValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getParameterValue_Parent(), theCorePackage.getHasParameterValues(), null, "parent", null, 1, 1, ParameterValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getParameterValue_Definition(), this.getParameterDefinition(), null, "definition", null, 1, 1, ParameterValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getParameterValue_Value(), ecorePackage.getEString(), "value", null, 0, 1, ParameterValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(parameterValueEClass, null, "getFinalValue", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(parameterDefinitionEClass, ParameterDefinition.class, "ParameterDefinition", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getParameterDefinition_Parent(), theCorePackage.getHasParameterDefinitions(), null, "parent", null, 1, 1, ParameterDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getParameterDefinition_Constraints(), theCorePackage.getConstraint(), null, "constraints", null, 0, -1, ParameterDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getParameterDefinition_Type(), this.getParameterType(), "type", null, 0, 1, ParameterDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getParameterDefinition_Description(), ecorePackage.getEString(), "description", null, 0, 1, ParameterDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getParameterDefinition_DefaultValue(), ecorePackage.getEString(), "defaultValue", null, 0, 1, ParameterDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getParameterDefinition_ExampleValue(), ecorePackage.getEString(), "exampleValue", null, 0, 1, ParameterDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getParameterDefinition_DerivationExpression(), ecorePackage.getEString(), "derivationExpression", null, 0, 1, ParameterDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getParameterDefinition_Overriders(), this.getParamDefOverrider(), null, "overriders", null, 0, -1, ParameterDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getParameterDefinition_LongDescription(), ecorePackage.getEString(), "longDescription", null, 0, 1, ParameterDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(parameterDefinitionEClass, null, "castParentAsComponent", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(parameterDefinitionEClass, null, "castParentAsEngine", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(paramDefOverriderEClass, ParamDefOverrider.class, "ParamDefOverrider", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getParamDefOverrider_OverridedFeature(), this.getEStructuralFeature(), "overridedFeature", null, 0, 1, ParamDefOverrider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getParamDefOverrider_Environment(), ecorePackage.getEString(), "environment", null, 0, 1, ParamDefOverrider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getParamDefOverrider_Value(), ecorePackage.getEString(), "value", null, 0, 1, ParamDefOverrider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(parameterTypeEEnum, ParameterType.class, "ParameterType");
		addEEnumLiteral(parameterTypeEEnum, ParameterType.BOOLEAN);
		addEEnumLiteral(parameterTypeEEnum, ParameterType.DATE);
		addEEnumLiteral(parameterTypeEEnum, ParameterType.FLOAT);
		addEEnumLiteral(parameterTypeEEnum, ParameterType.INTEGER);
		addEEnumLiteral(parameterTypeEEnum, ParameterType.STRING);

		// Initialize data types
		initEDataType(eStructuralFeatureEDataType, EStructuralFeature.class, "EStructuralFeature", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //ParametersPackageImpl

/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.domain.parameters;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.m2ling.domain.core.CorePackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.m2ling.domain.parameters.ParametersFactory
 * @model kind="package"
 * @generated
 */
public interface ParametersPackage extends EPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (C) 2012 Bertrand Florat";

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "parameters";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://m2ling.org/parameters/0.1";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "m2ling_parameters";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ParametersPackage eINSTANCE = org.m2ling.domain.parameters.impl.ParametersPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.m2ling.domain.parameters.impl.ParameterValueImpl <em>Parameter Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.m2ling.domain.parameters.impl.ParameterValueImpl
	 * @see org.m2ling.domain.parameters.impl.ParametersPackageImpl#getParameterValue()
	 * @generated
	 */
	int PARAMETER_VALUE = 0;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_VALUE__COMMENT = CorePackage.HAS_COMMENT__COMMENT;

	/**
	 * The feature id for the '<em><b>Custom Properties</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_VALUE__CUSTOM_PROPERTIES = CorePackage.HAS_COMMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_VALUE__PARENT = CorePackage.HAS_COMMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_VALUE__DEFINITION = CorePackage.HAS_COMMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_VALUE__VALUE = CorePackage.HAS_COMMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Parameter Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_VALUE_FEATURE_COUNT = CorePackage.HAS_COMMENT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.m2ling.domain.parameters.impl.ParameterDefinitionImpl <em>Parameter Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.m2ling.domain.parameters.impl.ParameterDefinitionImpl
	 * @see org.m2ling.domain.parameters.impl.ParametersPackageImpl#getParameterDefinition()
	 * @generated
	 */
	int PARAMETER_DEFINITION = 1;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_DEFINITION__COMMENT = CorePackage.HAS_COMMENT__COMMENT;

	/**
	 * The feature id for the '<em><b>Custom Properties</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_DEFINITION__CUSTOM_PROPERTIES = CorePackage.HAS_COMMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_DEFINITION__ID = CorePackage.HAS_COMMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_DEFINITION__NAME = CorePackage.HAS_COMMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_DEFINITION__TARGET = CorePackage.HAS_COMMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_DEFINITION__CONSTRAINTS = CorePackage.HAS_COMMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_DEFINITION__TYPE = CorePackage.HAS_COMMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_DEFINITION__DESCRIPTION = CorePackage.HAS_COMMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_DEFINITION__DEFAULT_VALUE = CorePackage.HAS_COMMENT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Example Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_DEFINITION__EXAMPLE_VALUE = CorePackage.HAS_COMMENT_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_DEFINITION__EXPRESSION = CorePackage.HAS_COMMENT_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Overriders</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_DEFINITION__OVERRIDERS = CorePackage.HAS_COMMENT_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Long Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_DEFINITION__LONG_DESCRIPTION = CorePackage.HAS_COMMENT_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Target Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_DEFINITION__TARGET_TYPE = CorePackage.HAS_COMMENT_FEATURE_COUNT + 12;

	/**
	 * The number of structural features of the '<em>Parameter Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_DEFINITION_FEATURE_COUNT = CorePackage.HAS_COMMENT_FEATURE_COUNT + 13;

	/**
	 * The meta object id for the '{@link org.m2ling.domain.parameters.impl.ParamDefOverriderImpl <em>Param Def Overrider</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.m2ling.domain.parameters.impl.ParamDefOverriderImpl
	 * @see org.m2ling.domain.parameters.impl.ParametersPackageImpl#getParamDefOverrider()
	 * @generated
	 */
	int PARAM_DEF_OVERRIDER = 2;

	/**
	 * The feature id for the '<em><b>Overrided Feature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM_DEF_OVERRIDER__OVERRIDED_FEATURE = 0;

	/**
	 * The feature id for the '<em><b>Environment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM_DEF_OVERRIDER__ENVIRONMENT = 1;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM_DEF_OVERRIDER__VALUE = 2;

	/**
	 * The number of structural features of the '<em>Param Def Overrider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM_DEF_OVERRIDER_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.m2ling.domain.parameters.impl.RootParametersImpl <em>Root Parameters</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.m2ling.domain.parameters.impl.RootParametersImpl
	 * @see org.m2ling.domain.parameters.impl.ParametersPackageImpl#getRootParameters()
	 * @generated
	 */
	int ROOT_PARAMETERS = 3;

	/**
	 * The feature id for the '<em><b>Definitions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_PARAMETERS__DEFINITIONS = 0;

	/**
	 * The feature id for the '<em><b>Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_PARAMETERS__VALUES = 1;

	/**
	 * The number of structural features of the '<em>Root Parameters</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_PARAMETERS_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.m2ling.domain.parameters.ParameterType <em>Parameter Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.m2ling.domain.parameters.ParameterType
	 * @see org.m2ling.domain.parameters.impl.ParametersPackageImpl#getParameterType()
	 * @generated
	 */
	int PARAMETER_TYPE = 4;

	/**
	 * The meta object id for the '<em>EStructural Feature</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EStructuralFeature
	 * @see org.m2ling.domain.parameters.impl.ParametersPackageImpl#getEStructuralFeature()
	 * @generated
	 */
	int ESTRUCTURAL_FEATURE = 5;


	/**
	 * Returns the meta object for class '{@link org.m2ling.domain.parameters.ParameterValue <em>Parameter Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter Value</em>'.
	 * @see org.m2ling.domain.parameters.ParameterValue
	 * @generated
	 */
	EClass getParameterValue();

	/**
	 * Returns the meta object for the reference '{@link org.m2ling.domain.parameters.ParameterValue#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parent</em>'.
	 * @see org.m2ling.domain.parameters.ParameterValue#getParent()
	 * @see #getParameterValue()
	 * @generated
	 */
	EReference getParameterValue_Parent();

	/**
	 * Returns the meta object for the reference '{@link org.m2ling.domain.parameters.ParameterValue#getDefinition <em>Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Definition</em>'.
	 * @see org.m2ling.domain.parameters.ParameterValue#getDefinition()
	 * @see #getParameterValue()
	 * @generated
	 */
	EReference getParameterValue_Definition();

	/**
	 * Returns the meta object for the attribute '{@link org.m2ling.domain.parameters.ParameterValue#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.m2ling.domain.parameters.ParameterValue#getValue()
	 * @see #getParameterValue()
	 * @generated
	 */
	EAttribute getParameterValue_Value();

	/**
	 * Returns the meta object for class '{@link org.m2ling.domain.parameters.ParameterDefinition <em>Parameter Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter Definition</em>'.
	 * @see org.m2ling.domain.parameters.ParameterDefinition
	 * @generated
	 */
	EClass getParameterDefinition();

	/**
	 * Returns the meta object for the reference '{@link org.m2ling.domain.parameters.ParameterDefinition#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see org.m2ling.domain.parameters.ParameterDefinition#getTarget()
	 * @see #getParameterDefinition()
	 * @generated
	 */
	EReference getParameterDefinition_Target();

	/**
	 * Returns the meta object for the containment reference list '{@link org.m2ling.domain.parameters.ParameterDefinition#getConstraints <em>Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Constraints</em>'.
	 * @see org.m2ling.domain.parameters.ParameterDefinition#getConstraints()
	 * @see #getParameterDefinition()
	 * @generated
	 */
	EReference getParameterDefinition_Constraints();

	/**
	 * Returns the meta object for the attribute '{@link org.m2ling.domain.parameters.ParameterDefinition#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.m2ling.domain.parameters.ParameterDefinition#getType()
	 * @see #getParameterDefinition()
	 * @generated
	 */
	EAttribute getParameterDefinition_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.m2ling.domain.parameters.ParameterDefinition#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.m2ling.domain.parameters.ParameterDefinition#getDescription()
	 * @see #getParameterDefinition()
	 * @generated
	 */
	EAttribute getParameterDefinition_Description();

	/**
	 * Returns the meta object for the attribute '{@link org.m2ling.domain.parameters.ParameterDefinition#getDefaultValue <em>Default Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default Value</em>'.
	 * @see org.m2ling.domain.parameters.ParameterDefinition#getDefaultValue()
	 * @see #getParameterDefinition()
	 * @generated
	 */
	EAttribute getParameterDefinition_DefaultValue();

	/**
	 * Returns the meta object for the attribute '{@link org.m2ling.domain.parameters.ParameterDefinition#getExampleValue <em>Example Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Example Value</em>'.
	 * @see org.m2ling.domain.parameters.ParameterDefinition#getExampleValue()
	 * @see #getParameterDefinition()
	 * @generated
	 */
	EAttribute getParameterDefinition_ExampleValue();

	/**
	 * Returns the meta object for the attribute '{@link org.m2ling.domain.parameters.ParameterDefinition#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Expression</em>'.
	 * @see org.m2ling.domain.parameters.ParameterDefinition#getExpression()
	 * @see #getParameterDefinition()
	 * @generated
	 */
	EAttribute getParameterDefinition_Expression();

	/**
	 * Returns the meta object for the containment reference list '{@link org.m2ling.domain.parameters.ParameterDefinition#getOverriders <em>Overriders</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Overriders</em>'.
	 * @see org.m2ling.domain.parameters.ParameterDefinition#getOverriders()
	 * @see #getParameterDefinition()
	 * @generated
	 */
	EReference getParameterDefinition_Overriders();

	/**
	 * Returns the meta object for the attribute '{@link org.m2ling.domain.parameters.ParameterDefinition#getLongDescription <em>Long Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Long Description</em>'.
	 * @see org.m2ling.domain.parameters.ParameterDefinition#getLongDescription()
	 * @see #getParameterDefinition()
	 * @generated
	 */
	EAttribute getParameterDefinition_LongDescription();

	/**
	 * Returns the meta object for the reference '{@link org.m2ling.domain.parameters.ParameterDefinition#getTargetType <em>Target Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Type</em>'.
	 * @see org.m2ling.domain.parameters.ParameterDefinition#getTargetType()
	 * @see #getParameterDefinition()
	 * @generated
	 */
	EReference getParameterDefinition_TargetType();

	/**
	 * Returns the meta object for class '{@link org.m2ling.domain.parameters.ParamDefOverrider <em>Param Def Overrider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Param Def Overrider</em>'.
	 * @see org.m2ling.domain.parameters.ParamDefOverrider
	 * @generated
	 */
	EClass getParamDefOverrider();

	/**
	 * Returns the meta object for the attribute '{@link org.m2ling.domain.parameters.ParamDefOverrider#getOverridedFeature <em>Overrided Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Overrided Feature</em>'.
	 * @see org.m2ling.domain.parameters.ParamDefOverrider#getOverridedFeature()
	 * @see #getParamDefOverrider()
	 * @generated
	 */
	EAttribute getParamDefOverrider_OverridedFeature();

	/**
	 * Returns the meta object for the attribute '{@link org.m2ling.domain.parameters.ParamDefOverrider#getEnvironment <em>Environment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Environment</em>'.
	 * @see org.m2ling.domain.parameters.ParamDefOverrider#getEnvironment()
	 * @see #getParamDefOverrider()
	 * @generated
	 */
	EAttribute getParamDefOverrider_Environment();

	/**
	 * Returns the meta object for the attribute '{@link org.m2ling.domain.parameters.ParamDefOverrider#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.m2ling.domain.parameters.ParamDefOverrider#getValue()
	 * @see #getParamDefOverrider()
	 * @generated
	 */
	EAttribute getParamDefOverrider_Value();

	/**
	 * Returns the meta object for class '{@link org.m2ling.domain.parameters.RootParameters <em>Root Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Root Parameters</em>'.
	 * @see org.m2ling.domain.parameters.RootParameters
	 * @generated
	 */
	EClass getRootParameters();

	/**
	 * Returns the meta object for the containment reference list '{@link org.m2ling.domain.parameters.RootParameters#getDefinitions <em>Definitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Definitions</em>'.
	 * @see org.m2ling.domain.parameters.RootParameters#getDefinitions()
	 * @see #getRootParameters()
	 * @generated
	 */
	EReference getRootParameters_Definitions();

	/**
	 * Returns the meta object for the containment reference list '{@link org.m2ling.domain.parameters.RootParameters#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Values</em>'.
	 * @see org.m2ling.domain.parameters.RootParameters#getValues()
	 * @see #getRootParameters()
	 * @generated
	 */
	EReference getRootParameters_Values();

	/**
	 * Returns the meta object for enum '{@link org.m2ling.domain.parameters.ParameterType <em>Parameter Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Parameter Type</em>'.
	 * @see org.m2ling.domain.parameters.ParameterType
	 * @generated
	 */
	EEnum getParameterType();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.emf.ecore.EStructuralFeature <em>EStructural Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>EStructural Feature</em>'.
	 * @see org.eclipse.emf.ecore.EStructuralFeature
	 * @model instanceClass="org.eclipse.emf.ecore.EStructuralFeature"
	 * @generated
	 */
	EDataType getEStructuralFeature();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ParametersFactory getParametersFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.m2ling.domain.parameters.impl.ParameterValueImpl <em>Parameter Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.m2ling.domain.parameters.impl.ParameterValueImpl
		 * @see org.m2ling.domain.parameters.impl.ParametersPackageImpl#getParameterValue()
		 * @generated
		 */
		EClass PARAMETER_VALUE = eINSTANCE.getParameterValue();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETER_VALUE__PARENT = eINSTANCE.getParameterValue_Parent();

		/**
		 * The meta object literal for the '<em><b>Definition</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETER_VALUE__DEFINITION = eINSTANCE.getParameterValue_Definition();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER_VALUE__VALUE = eINSTANCE.getParameterValue_Value();

		/**
		 * The meta object literal for the '{@link org.m2ling.domain.parameters.impl.ParameterDefinitionImpl <em>Parameter Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.m2ling.domain.parameters.impl.ParameterDefinitionImpl
		 * @see org.m2ling.domain.parameters.impl.ParametersPackageImpl#getParameterDefinition()
		 * @generated
		 */
		EClass PARAMETER_DEFINITION = eINSTANCE.getParameterDefinition();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETER_DEFINITION__TARGET = eINSTANCE.getParameterDefinition_Target();

		/**
		 * The meta object literal for the '<em><b>Constraints</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETER_DEFINITION__CONSTRAINTS = eINSTANCE.getParameterDefinition_Constraints();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER_DEFINITION__TYPE = eINSTANCE.getParameterDefinition_Type();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER_DEFINITION__DESCRIPTION = eINSTANCE.getParameterDefinition_Description();

		/**
		 * The meta object literal for the '<em><b>Default Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER_DEFINITION__DEFAULT_VALUE = eINSTANCE.getParameterDefinition_DefaultValue();

		/**
		 * The meta object literal for the '<em><b>Example Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER_DEFINITION__EXAMPLE_VALUE = eINSTANCE.getParameterDefinition_ExampleValue();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER_DEFINITION__EXPRESSION = eINSTANCE.getParameterDefinition_Expression();

		/**
		 * The meta object literal for the '<em><b>Overriders</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETER_DEFINITION__OVERRIDERS = eINSTANCE.getParameterDefinition_Overriders();

		/**
		 * The meta object literal for the '<em><b>Long Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER_DEFINITION__LONG_DESCRIPTION = eINSTANCE.getParameterDefinition_LongDescription();

		/**
		 * The meta object literal for the '<em><b>Target Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETER_DEFINITION__TARGET_TYPE = eINSTANCE.getParameterDefinition_TargetType();

		/**
		 * The meta object literal for the '{@link org.m2ling.domain.parameters.impl.ParamDefOverriderImpl <em>Param Def Overrider</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.m2ling.domain.parameters.impl.ParamDefOverriderImpl
		 * @see org.m2ling.domain.parameters.impl.ParametersPackageImpl#getParamDefOverrider()
		 * @generated
		 */
		EClass PARAM_DEF_OVERRIDER = eINSTANCE.getParamDefOverrider();

		/**
		 * The meta object literal for the '<em><b>Overrided Feature</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAM_DEF_OVERRIDER__OVERRIDED_FEATURE = eINSTANCE.getParamDefOverrider_OverridedFeature();

		/**
		 * The meta object literal for the '<em><b>Environment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAM_DEF_OVERRIDER__ENVIRONMENT = eINSTANCE.getParamDefOverrider_Environment();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAM_DEF_OVERRIDER__VALUE = eINSTANCE.getParamDefOverrider_Value();

		/**
		 * The meta object literal for the '{@link org.m2ling.domain.parameters.impl.RootParametersImpl <em>Root Parameters</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.m2ling.domain.parameters.impl.RootParametersImpl
		 * @see org.m2ling.domain.parameters.impl.ParametersPackageImpl#getRootParameters()
		 * @generated
		 */
		EClass ROOT_PARAMETERS = eINSTANCE.getRootParameters();

		/**
		 * The meta object literal for the '<em><b>Definitions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROOT_PARAMETERS__DEFINITIONS = eINSTANCE.getRootParameters_Definitions();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROOT_PARAMETERS__VALUES = eINSTANCE.getRootParameters_Values();

		/**
		 * The meta object literal for the '{@link org.m2ling.domain.parameters.ParameterType <em>Parameter Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.m2ling.domain.parameters.ParameterType
		 * @see org.m2ling.domain.parameters.impl.ParametersPackageImpl#getParameterType()
		 * @generated
		 */
		EEnum PARAMETER_TYPE = eINSTANCE.getParameterType();

		/**
		 * The meta object literal for the '<em>EStructural Feature</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.ecore.EStructuralFeature
		 * @see org.m2ling.domain.parameters.impl.ParametersPackageImpl#getEStructuralFeature()
		 * @generated
		 */
		EDataType ESTRUCTURAL_FEATURE = eINSTANCE.getEStructuralFeature();

	}

} //ParametersPackage

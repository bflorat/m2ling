/**
 * <copyright>
 * </copyright>
 *
 * $Id$
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
	String eNS_URI = "http://m2ling.org/parameters/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "parameters";

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
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_DEFINITION__PARENT = CorePackage.HAS_COMMENT_FEATURE_COUNT + 3;

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
	 * The feature id for the '<em><b>Derivation Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_DEFINITION__DERIVATION_EXPRESSION = CorePackage.HAS_COMMENT_FEATURE_COUNT + 9;

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
	 * The number of structural features of the '<em>Parameter Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_DEFINITION_FEATURE_COUNT = CorePackage.HAS_COMMENT_FEATURE_COUNT + 12;

	/**
	 * The meta object id for the '{@link org.m2ling.domain.parameters.impl.ParameterConstraintImpl <em>Parameter Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.m2ling.domain.parameters.impl.ParameterConstraintImpl
	 * @see org.m2ling.domain.parameters.impl.ParametersPackageImpl#getParameterConstraint()
	 * @generated
	 */
	int PARAMETER_CONSTRAINT = 2;

	/**
	 * The number of structural features of the '<em>Parameter Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_CONSTRAINT_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.m2ling.domain.parameters.impl.FloatConstraintImpl <em>Float Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.m2ling.domain.parameters.impl.FloatConstraintImpl
	 * @see org.m2ling.domain.parameters.impl.ParametersPackageImpl#getFloatConstraint()
	 * @generated
	 */
	int FLOAT_CONSTRAINT = 3;

	/**
	 * The number of structural features of the '<em>Float Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOAT_CONSTRAINT_FEATURE_COUNT = PARAMETER_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.m2ling.domain.parameters.impl.BoundaryConstraintImpl <em>Boundary Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.m2ling.domain.parameters.impl.BoundaryConstraintImpl
	 * @see org.m2ling.domain.parameters.impl.ParametersPackageImpl#getBoundaryConstraint()
	 * @generated
	 */
	int BOUNDARY_CONSTRAINT = 5;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDARY_CONSTRAINT__VALUE = PARAMETER_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Inclusive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDARY_CONSTRAINT__INCLUSIVE = PARAMETER_CONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Boundary Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDARY_CONSTRAINT_FEATURE_COUNT = PARAMETER_CONSTRAINT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.m2ling.domain.parameters.impl.MinConstraintImpl <em>Min Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.m2ling.domain.parameters.impl.MinConstraintImpl
	 * @see org.m2ling.domain.parameters.impl.ParametersPackageImpl#getMinConstraint()
	 * @generated
	 */
	int MIN_CONSTRAINT = 4;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIN_CONSTRAINT__VALUE = BOUNDARY_CONSTRAINT__VALUE;

	/**
	 * The feature id for the '<em><b>Inclusive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIN_CONSTRAINT__INCLUSIVE = BOUNDARY_CONSTRAINT__INCLUSIVE;

	/**
	 * The number of structural features of the '<em>Min Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIN_CONSTRAINT_FEATURE_COUNT = BOUNDARY_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.m2ling.domain.parameters.impl.URLConstraintImpl <em>URL Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.m2ling.domain.parameters.impl.URLConstraintImpl
	 * @see org.m2ling.domain.parameters.impl.ParametersPackageImpl#getURLConstraint()
	 * @generated
	 */
	int URL_CONSTRAINT = 6;

	/**
	 * The number of structural features of the '<em>URL Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URL_CONSTRAINT_FEATURE_COUNT = PARAMETER_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.m2ling.domain.parameters.impl.NotNullConstraintImpl <em>Not Null Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.m2ling.domain.parameters.impl.NotNullConstraintImpl
	 * @see org.m2ling.domain.parameters.impl.ParametersPackageImpl#getNotNullConstraint()
	 * @generated
	 */
	int NOT_NULL_CONSTRAINT = 7;

	/**
	 * The number of structural features of the '<em>Not Null Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_NULL_CONSTRAINT_FEATURE_COUNT = PARAMETER_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.m2ling.domain.parameters.impl.RegexpConstraintImpl <em>Regexp Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.m2ling.domain.parameters.impl.RegexpConstraintImpl
	 * @see org.m2ling.domain.parameters.impl.ParametersPackageImpl#getRegexpConstraint()
	 * @generated
	 */
	int REGEXP_CONSTRAINT = 8;

	/**
	 * The feature id for the '<em><b>Regexp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGEXP_CONSTRAINT__REGEXP = PARAMETER_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Regexp Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGEXP_CONSTRAINT_FEATURE_COUNT = PARAMETER_CONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.m2ling.domain.parameters.impl.OCLConstraintImpl <em>OCL Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.m2ling.domain.parameters.impl.OCLConstraintImpl
	 * @see org.m2ling.domain.parameters.impl.ParametersPackageImpl#getOCLConstraint()
	 * @generated
	 */
	int OCL_CONSTRAINT = 9;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_CONSTRAINT__EXPRESSION = PARAMETER_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>OCL Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_CONSTRAINT_FEATURE_COUNT = PARAMETER_CONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.m2ling.domain.parameters.impl.IntegerConstraintImpl <em>Integer Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.m2ling.domain.parameters.impl.IntegerConstraintImpl
	 * @see org.m2ling.domain.parameters.impl.ParametersPackageImpl#getIntegerConstraint()
	 * @generated
	 */
	int INTEGER_CONSTRAINT = 10;

	/**
	 * The number of structural features of the '<em>Integer Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_CONSTRAINT_FEATURE_COUNT = PARAMETER_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.m2ling.domain.parameters.impl.MaxConstraintImpl <em>Max Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.m2ling.domain.parameters.impl.MaxConstraintImpl
	 * @see org.m2ling.domain.parameters.impl.ParametersPackageImpl#getMaxConstraint()
	 * @generated
	 */
	int MAX_CONSTRAINT = 11;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAX_CONSTRAINT__VALUE = BOUNDARY_CONSTRAINT__VALUE;

	/**
	 * The feature id for the '<em><b>Inclusive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAX_CONSTRAINT__INCLUSIVE = BOUNDARY_CONSTRAINT__INCLUSIVE;

	/**
	 * The number of structural features of the '<em>Max Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAX_CONSTRAINT_FEATURE_COUNT = BOUNDARY_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.m2ling.domain.parameters.impl.EMailConstraintImpl <em>EMail Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.m2ling.domain.parameters.impl.EMailConstraintImpl
	 * @see org.m2ling.domain.parameters.impl.ParametersPackageImpl#getEMailConstraint()
	 * @generated
	 */
	int EMAIL_CONSTRAINT = 12;

	/**
	 * The number of structural features of the '<em>EMail Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMAIL_CONSTRAINT_FEATURE_COUNT = PARAMETER_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.m2ling.domain.parameters.impl.ParamDefOverriderImpl <em>Param Def Overrider</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.m2ling.domain.parameters.impl.ParamDefOverriderImpl
	 * @see org.m2ling.domain.parameters.impl.ParametersPackageImpl#getParamDefOverrider()
	 * @generated
	 */
	int PARAM_DEF_OVERRIDER = 13;

	/**
	 * The feature id for the '<em><b>Overrided Feature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM_DEF_OVERRIDER__OVERRIDED_FEATURE = 0;

	/**
	 * The feature id for the '<em><b>Profile</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM_DEF_OVERRIDER__PROFILE = 1;

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
	 * The meta object id for the '{@link org.m2ling.domain.parameters.impl.FormatConstraintImpl <em>Format Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.m2ling.domain.parameters.impl.FormatConstraintImpl
	 * @see org.m2ling.domain.parameters.impl.ParametersPackageImpl#getFormatConstraint()
	 * @generated
	 */
	int FORMAT_CONSTRAINT = 14;

	/**
	 * The number of structural features of the '<em>Format Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMAT_CONSTRAINT_FEATURE_COUNT = PARAMETER_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.m2ling.domain.parameters.ParameterType <em>Parameter Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.m2ling.domain.parameters.ParameterType
	 * @see org.m2ling.domain.parameters.impl.ParametersPackageImpl#getParameterType()
	 * @generated
	 */
	int PARAMETER_TYPE = 15;

	/**
	 * The meta object id for the '<em>EStructural Feature</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EStructuralFeature
	 * @see org.m2ling.domain.parameters.impl.ParametersPackageImpl#getEStructuralFeature()
	 * @generated
	 */
	int ESTRUCTURAL_FEATURE = 16;


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
	 * Returns the meta object for the reference '{@link org.m2ling.domain.parameters.ParameterDefinition#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parent</em>'.
	 * @see org.m2ling.domain.parameters.ParameterDefinition#getParent()
	 * @see #getParameterDefinition()
	 * @generated
	 */
	EReference getParameterDefinition_Parent();

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
	 * Returns the meta object for the attribute '{@link org.m2ling.domain.parameters.ParameterDefinition#getDerivationExpression <em>Derivation Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Derivation Expression</em>'.
	 * @see org.m2ling.domain.parameters.ParameterDefinition#getDerivationExpression()
	 * @see #getParameterDefinition()
	 * @generated
	 */
	EAttribute getParameterDefinition_DerivationExpression();

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
	 * Returns the meta object for class '{@link org.m2ling.domain.parameters.ParameterConstraint <em>Parameter Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter Constraint</em>'.
	 * @see org.m2ling.domain.parameters.ParameterConstraint
	 * @generated
	 */
	EClass getParameterConstraint();

	/**
	 * Returns the meta object for class '{@link org.m2ling.domain.parameters.FloatConstraint <em>Float Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Float Constraint</em>'.
	 * @see org.m2ling.domain.parameters.FloatConstraint
	 * @generated
	 */
	EClass getFloatConstraint();

	/**
	 * Returns the meta object for class '{@link org.m2ling.domain.parameters.MinConstraint <em>Min Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Min Constraint</em>'.
	 * @see org.m2ling.domain.parameters.MinConstraint
	 * @generated
	 */
	EClass getMinConstraint();

	/**
	 * Returns the meta object for class '{@link org.m2ling.domain.parameters.BoundaryConstraint <em>Boundary Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boundary Constraint</em>'.
	 * @see org.m2ling.domain.parameters.BoundaryConstraint
	 * @generated
	 */
	EClass getBoundaryConstraint();

	/**
	 * Returns the meta object for the attribute '{@link org.m2ling.domain.parameters.BoundaryConstraint#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.m2ling.domain.parameters.BoundaryConstraint#getValue()
	 * @see #getBoundaryConstraint()
	 * @generated
	 */
	EAttribute getBoundaryConstraint_Value();

	/**
	 * Returns the meta object for the attribute '{@link org.m2ling.domain.parameters.BoundaryConstraint#isInclusive <em>Inclusive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Inclusive</em>'.
	 * @see org.m2ling.domain.parameters.BoundaryConstraint#isInclusive()
	 * @see #getBoundaryConstraint()
	 * @generated
	 */
	EAttribute getBoundaryConstraint_Inclusive();

	/**
	 * Returns the meta object for class '{@link org.m2ling.domain.parameters.URLConstraint <em>URL Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>URL Constraint</em>'.
	 * @see org.m2ling.domain.parameters.URLConstraint
	 * @generated
	 */
	EClass getURLConstraint();

	/**
	 * Returns the meta object for class '{@link org.m2ling.domain.parameters.NotNullConstraint <em>Not Null Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Not Null Constraint</em>'.
	 * @see org.m2ling.domain.parameters.NotNullConstraint
	 * @generated
	 */
	EClass getNotNullConstraint();

	/**
	 * Returns the meta object for class '{@link org.m2ling.domain.parameters.RegexpConstraint <em>Regexp Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Regexp Constraint</em>'.
	 * @see org.m2ling.domain.parameters.RegexpConstraint
	 * @generated
	 */
	EClass getRegexpConstraint();

	/**
	 * Returns the meta object for the attribute '{@link org.m2ling.domain.parameters.RegexpConstraint#getRegexp <em>Regexp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Regexp</em>'.
	 * @see org.m2ling.domain.parameters.RegexpConstraint#getRegexp()
	 * @see #getRegexpConstraint()
	 * @generated
	 */
	EAttribute getRegexpConstraint_Regexp();

	/**
	 * Returns the meta object for class '{@link org.m2ling.domain.parameters.OCLConstraint <em>OCL Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>OCL Constraint</em>'.
	 * @see org.m2ling.domain.parameters.OCLConstraint
	 * @generated
	 */
	EClass getOCLConstraint();

	/**
	 * Returns the meta object for the attribute '{@link org.m2ling.domain.parameters.OCLConstraint#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Expression</em>'.
	 * @see org.m2ling.domain.parameters.OCLConstraint#getExpression()
	 * @see #getOCLConstraint()
	 * @generated
	 */
	EAttribute getOCLConstraint_Expression();

	/**
	 * Returns the meta object for class '{@link org.m2ling.domain.parameters.IntegerConstraint <em>Integer Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Integer Constraint</em>'.
	 * @see org.m2ling.domain.parameters.IntegerConstraint
	 * @generated
	 */
	EClass getIntegerConstraint();

	/**
	 * Returns the meta object for class '{@link org.m2ling.domain.parameters.MaxConstraint <em>Max Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Max Constraint</em>'.
	 * @see org.m2ling.domain.parameters.MaxConstraint
	 * @generated
	 */
	EClass getMaxConstraint();

	/**
	 * Returns the meta object for class '{@link org.m2ling.domain.parameters.EMailConstraint <em>EMail Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EMail Constraint</em>'.
	 * @see org.m2ling.domain.parameters.EMailConstraint
	 * @generated
	 */
	EClass getEMailConstraint();

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
	 * Returns the meta object for the attribute '{@link org.m2ling.domain.parameters.ParamDefOverrider#getProfile <em>Profile</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Profile</em>'.
	 * @see org.m2ling.domain.parameters.ParamDefOverrider#getProfile()
	 * @see #getParamDefOverrider()
	 * @generated
	 */
	EAttribute getParamDefOverrider_Profile();

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
	 * Returns the meta object for class '{@link org.m2ling.domain.parameters.FormatConstraint <em>Format Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Format Constraint</em>'.
	 * @see org.m2ling.domain.parameters.FormatConstraint
	 * @generated
	 */
	EClass getFormatConstraint();

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
		 * The meta object literal for the '<em><b>Parent</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETER_DEFINITION__PARENT = eINSTANCE.getParameterDefinition_Parent();

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
		 * The meta object literal for the '<em><b>Derivation Expression</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER_DEFINITION__DERIVATION_EXPRESSION = eINSTANCE.getParameterDefinition_DerivationExpression();

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
		 * The meta object literal for the '{@link org.m2ling.domain.parameters.impl.ParameterConstraintImpl <em>Parameter Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.m2ling.domain.parameters.impl.ParameterConstraintImpl
		 * @see org.m2ling.domain.parameters.impl.ParametersPackageImpl#getParameterConstraint()
		 * @generated
		 */
		EClass PARAMETER_CONSTRAINT = eINSTANCE.getParameterConstraint();

		/**
		 * The meta object literal for the '{@link org.m2ling.domain.parameters.impl.FloatConstraintImpl <em>Float Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.m2ling.domain.parameters.impl.FloatConstraintImpl
		 * @see org.m2ling.domain.parameters.impl.ParametersPackageImpl#getFloatConstraint()
		 * @generated
		 */
		EClass FLOAT_CONSTRAINT = eINSTANCE.getFloatConstraint();

		/**
		 * The meta object literal for the '{@link org.m2ling.domain.parameters.impl.MinConstraintImpl <em>Min Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.m2ling.domain.parameters.impl.MinConstraintImpl
		 * @see org.m2ling.domain.parameters.impl.ParametersPackageImpl#getMinConstraint()
		 * @generated
		 */
		EClass MIN_CONSTRAINT = eINSTANCE.getMinConstraint();

		/**
		 * The meta object literal for the '{@link org.m2ling.domain.parameters.impl.BoundaryConstraintImpl <em>Boundary Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.m2ling.domain.parameters.impl.BoundaryConstraintImpl
		 * @see org.m2ling.domain.parameters.impl.ParametersPackageImpl#getBoundaryConstraint()
		 * @generated
		 */
		EClass BOUNDARY_CONSTRAINT = eINSTANCE.getBoundaryConstraint();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOUNDARY_CONSTRAINT__VALUE = eINSTANCE.getBoundaryConstraint_Value();

		/**
		 * The meta object literal for the '<em><b>Inclusive</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOUNDARY_CONSTRAINT__INCLUSIVE = eINSTANCE.getBoundaryConstraint_Inclusive();

		/**
		 * The meta object literal for the '{@link org.m2ling.domain.parameters.impl.URLConstraintImpl <em>URL Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.m2ling.domain.parameters.impl.URLConstraintImpl
		 * @see org.m2ling.domain.parameters.impl.ParametersPackageImpl#getURLConstraint()
		 * @generated
		 */
		EClass URL_CONSTRAINT = eINSTANCE.getURLConstraint();

		/**
		 * The meta object literal for the '{@link org.m2ling.domain.parameters.impl.NotNullConstraintImpl <em>Not Null Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.m2ling.domain.parameters.impl.NotNullConstraintImpl
		 * @see org.m2ling.domain.parameters.impl.ParametersPackageImpl#getNotNullConstraint()
		 * @generated
		 */
		EClass NOT_NULL_CONSTRAINT = eINSTANCE.getNotNullConstraint();

		/**
		 * The meta object literal for the '{@link org.m2ling.domain.parameters.impl.RegexpConstraintImpl <em>Regexp Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.m2ling.domain.parameters.impl.RegexpConstraintImpl
		 * @see org.m2ling.domain.parameters.impl.ParametersPackageImpl#getRegexpConstraint()
		 * @generated
		 */
		EClass REGEXP_CONSTRAINT = eINSTANCE.getRegexpConstraint();

		/**
		 * The meta object literal for the '<em><b>Regexp</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REGEXP_CONSTRAINT__REGEXP = eINSTANCE.getRegexpConstraint_Regexp();

		/**
		 * The meta object literal for the '{@link org.m2ling.domain.parameters.impl.OCLConstraintImpl <em>OCL Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.m2ling.domain.parameters.impl.OCLConstraintImpl
		 * @see org.m2ling.domain.parameters.impl.ParametersPackageImpl#getOCLConstraint()
		 * @generated
		 */
		EClass OCL_CONSTRAINT = eINSTANCE.getOCLConstraint();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OCL_CONSTRAINT__EXPRESSION = eINSTANCE.getOCLConstraint_Expression();

		/**
		 * The meta object literal for the '{@link org.m2ling.domain.parameters.impl.IntegerConstraintImpl <em>Integer Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.m2ling.domain.parameters.impl.IntegerConstraintImpl
		 * @see org.m2ling.domain.parameters.impl.ParametersPackageImpl#getIntegerConstraint()
		 * @generated
		 */
		EClass INTEGER_CONSTRAINT = eINSTANCE.getIntegerConstraint();

		/**
		 * The meta object literal for the '{@link org.m2ling.domain.parameters.impl.MaxConstraintImpl <em>Max Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.m2ling.domain.parameters.impl.MaxConstraintImpl
		 * @see org.m2ling.domain.parameters.impl.ParametersPackageImpl#getMaxConstraint()
		 * @generated
		 */
		EClass MAX_CONSTRAINT = eINSTANCE.getMaxConstraint();

		/**
		 * The meta object literal for the '{@link org.m2ling.domain.parameters.impl.EMailConstraintImpl <em>EMail Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.m2ling.domain.parameters.impl.EMailConstraintImpl
		 * @see org.m2ling.domain.parameters.impl.ParametersPackageImpl#getEMailConstraint()
		 * @generated
		 */
		EClass EMAIL_CONSTRAINT = eINSTANCE.getEMailConstraint();

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
		 * The meta object literal for the '<em><b>Profile</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAM_DEF_OVERRIDER__PROFILE = eINSTANCE.getParamDefOverrider_Profile();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAM_DEF_OVERRIDER__VALUE = eINSTANCE.getParamDefOverrider_Value();

		/**
		 * The meta object literal for the '{@link org.m2ling.domain.parameters.impl.FormatConstraintImpl <em>Format Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.m2ling.domain.parameters.impl.FormatConstraintImpl
		 * @see org.m2ling.domain.parameters.impl.ParametersPackageImpl#getFormatConstraint()
		 * @generated
		 */
		EClass FORMAT_CONSTRAINT = eINSTANCE.getFormatConstraint();

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

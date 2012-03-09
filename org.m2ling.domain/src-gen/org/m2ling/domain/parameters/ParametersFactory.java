/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.m2ling.domain.parameters;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.m2ling.domain.parameters.ParametersPackage
 * @generated
 */
public interface ParametersFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ParametersFactory eINSTANCE = org.m2ling.domain.parameters.impl.ParametersFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Parameter Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Parameter Value</em>'.
	 * @generated
	 */
	ParameterValue createParameterValue();

	/**
	 * Returns a new object of class '<em>Float Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Float Constraint</em>'.
	 * @generated
	 */
	FloatConstraint createFloatConstraint();

	/**
	 * Returns a new object of class '<em>Min Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Min Constraint</em>'.
	 * @generated
	 */
	MinConstraint createMinConstraint();

	/**
	 * Returns a new object of class '<em>URL Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>URL Constraint</em>'.
	 * @generated
	 */
	URLConstraint createURLConstraint();

	/**
	 * Returns a new object of class '<em>Not Null Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Not Null Constraint</em>'.
	 * @generated
	 */
	NotNullConstraint createNotNullConstraint();

	/**
	 * Returns a new object of class '<em>Regexp Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Regexp Constraint</em>'.
	 * @generated
	 */
	RegexpConstraint createRegexpConstraint();

	/**
	 * Returns a new object of class '<em>OCL Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>OCL Constraint</em>'.
	 * @generated
	 */
	OCLConstraint createOCLConstraint();

	/**
	 * Returns a new object of class '<em>Integer Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Integer Constraint</em>'.
	 * @generated
	 */
	IntegerConstraint createIntegerConstraint();

	/**
	 * Returns a new object of class '<em>Max Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Max Constraint</em>'.
	 * @generated
	 */
	MaxConstraint createMaxConstraint();

	/**
	 * Returns a new object of class '<em>EMail Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EMail Constraint</em>'.
	 * @generated
	 */
	EMailConstraint createEMailConstraint();

	/**
	 * Returns a new object of class '<em>Param Def Overrider</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Param Def Overrider</em>'.
	 * @generated
	 */
	ParamDefOverrider createParamDefOverrider();

	/**
	 * Returns a new object of class '<em>Format Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Format Constraint</em>'.
	 * @generated
	 */
	FormatConstraint createFormatConstraint();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ParametersPackage getParametersPackage();

} //ParametersFactory

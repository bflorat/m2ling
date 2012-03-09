/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.m2ling.domain.parameters;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>OCL Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.m2ling.domain.parameters.OCLConstraint#getExpression <em>Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.m2ling.domain.parameters.ParametersPackage#getOCLConstraint()
 * @model
 * @generated
 */
public interface OCLConstraint extends ParameterConstraint {
	/**
	 * Returns the value of the '<em><b>Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression</em>' attribute.
	 * @see #setExpression(String)
	 * @see org.m2ling.domain.parameters.ParametersPackage#getOCLConstraint_Expression()
	 * @model
	 * @generated
	 */
	String getExpression();

	/**
	 * Sets the value of the '{@link org.m2ling.domain.parameters.OCLConstraint#getExpression <em>Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression</em>' attribute.
	 * @see #getExpression()
	 * @generated
	 */
	void setExpression(String value);

} // OCLConstraint

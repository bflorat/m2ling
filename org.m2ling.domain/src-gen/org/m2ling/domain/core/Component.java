/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.m2ling.domain.core;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.m2ling.domain.core.Component#getType <em>Type</em>}</li>
 *   <li>{@link org.m2ling.domain.core.Component#getSubComponents <em>Sub Components</em>}</li>
 *   <li>{@link org.m2ling.domain.core.Component#getEngine <em>Engine</em>}</li>
 *   <li>{@link org.m2ling.domain.core.Component#getParent <em>Parent</em>}</li>
 *   <li>{@link org.m2ling.domain.core.Component#getIfactor <em>Ifactor</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.m2ling.domain.core.CorePackage#getComponent()
 * @model
 * @generated
 */
public interface Component extends ComponentGroup {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(ComponentType)
	 * @see org.m2ling.domain.core.CorePackage#getComponent_Type()
	 * @model required="true"
	 * @generated
	 */
	ComponentType getType();

	/**
	 * Sets the value of the '{@link org.m2ling.domain.core.Component#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(ComponentType value);

	/**
	 * Returns the value of the '<em><b>Sub Components</b></em>' containment reference list.
	 * The list contents are of type {@link org.m2ling.domain.core.Component}.
	 * It is bidirectional and its opposite is '{@link org.m2ling.domain.core.Component#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Components</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Components</em>' containment reference list.
	 * @see org.m2ling.domain.core.CorePackage#getComponent_SubComponents()
	 * @see org.m2ling.domain.core.Component#getParent
	 * @model opposite="parent" containment="true"
	 * @generated
	 */
	EList<Component> getSubComponents();

	/**
	 * Returns the value of the '<em><b>Engine</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.m2ling.domain.core.Engine#getComponents <em>Components</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Engine</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Engine</em>' reference.
	 * @see #setEngine(Engine)
	 * @see org.m2ling.domain.core.CorePackage#getComponent_Engine()
	 * @see org.m2ling.domain.core.Engine#getComponents
	 * @model opposite="components" required="true"
	 * @generated
	 */
	Engine getEngine();

	/**
	 * Sets the value of the '{@link org.m2ling.domain.core.Component#getEngine <em>Engine</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Engine</em>' reference.
	 * @see #getEngine()
	 * @generated
	 */
	void setEngine(Engine value);

	/**
	 * Returns the value of the '<em><b>Parent</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.m2ling.domain.core.Component#getSubComponents <em>Sub Components</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' container reference.
	 * @see #setParent(Component)
	 * @see org.m2ling.domain.core.CorePackage#getComponent_Parent()
	 * @see org.m2ling.domain.core.Component#getSubComponents
	 * @model opposite="subComponents" transient="false"
	 * @generated
	 */
	Component getParent();

	/**
	 * Sets the value of the '{@link org.m2ling.domain.core.Component#getParent <em>Parent</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' container reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(Component value);

	/**
	 * Returns the value of the '<em><b>Ifactor</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Integer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ifactor</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ifactor</em>' attribute list.
	 * @see org.m2ling.domain.core.CorePackage#getComponent_Ifactor()
	 * @model
	 * @generated
	 */
	EList<Integer> getIfactor();

} // Component

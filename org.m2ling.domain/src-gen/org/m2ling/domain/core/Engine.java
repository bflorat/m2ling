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
 * A representation of the model object '<em><b>Engine</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.m2ling.domain.core.Engine#getType <em>Type</em>}</li>
 *   <li>{@link org.m2ling.domain.core.Engine#getSubEngines <em>Sub Engines</em>}</li>
 *   <li>{@link org.m2ling.domain.core.Engine#getComponents <em>Components</em>}</li>
 *   <li>{@link org.m2ling.domain.core.Engine#getParent <em>Parent</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.m2ling.domain.core.CorePackage#getEngine()
 * @model
 * @generated
 */
public interface Engine extends EngineGroup {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(EngineType)
	 * @see org.m2ling.domain.core.CorePackage#getEngine_Type()
	 * @model required="true"
	 * @generated
	 */
	EngineType getType();

	/**
	 * Sets the value of the '{@link org.m2ling.domain.core.Engine#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(EngineType value);

	/**
	 * Returns the value of the '<em><b>Sub Engines</b></em>' containment reference list.
	 * The list contents are of type {@link org.m2ling.domain.core.Engine}.
	 * It is bidirectional and its opposite is '{@link org.m2ling.domain.core.Engine#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Engines</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Engines</em>' containment reference list.
	 * @see org.m2ling.domain.core.CorePackage#getEngine_SubEngines()
	 * @see org.m2ling.domain.core.Engine#getParent
	 * @model opposite="parent" containment="true"
	 * @generated
	 */
	EList<Engine> getSubEngines();

	/**
	 * Returns the value of the '<em><b>Components</b></em>' reference list.
	 * The list contents are of type {@link org.m2ling.domain.core.Component}.
	 * It is bidirectional and its opposite is '{@link org.m2ling.domain.core.Component#getEngine <em>Engine</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Components</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Components</em>' reference list.
	 * @see org.m2ling.domain.core.CorePackage#getEngine_Components()
	 * @see org.m2ling.domain.core.Component#getEngine
	 * @model opposite="engine"
	 * @generated
	 */
	EList<Component> getComponents();

	/**
	 * Returns the value of the '<em><b>Parent</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.m2ling.domain.core.Engine#getSubEngines <em>Sub Engines</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' container reference.
	 * @see #setParent(Engine)
	 * @see org.m2ling.domain.core.CorePackage#getEngine_Parent()
	 * @see org.m2ling.domain.core.Engine#getSubEngines
	 * @model opposite="subEngines" transient="false"
	 * @generated
	 */
	Engine getParent();

	/**
	 * Sets the value of the '{@link org.m2ling.domain.core.Engine#getParent <em>Parent</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' container reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(Engine value);

} // Engine

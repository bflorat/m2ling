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
 * A representation of the model object '<em><b>Engine Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.m2ling.domain.core.EngineType#getComponentTypes <em>Component Types</em>}</li>
 *   <li>{@link org.m2ling.domain.core.EngineType#getSubTypes <em>Sub Types</em>}</li>
 *   <li>{@link org.m2ling.domain.core.EngineType#getParent <em>Parent</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.m2ling.domain.core.CorePackage#getEngineType()
 * @model
 * @generated
 */
public interface EngineType extends ConceptItem {
	/**
	 * Returns the value of the '<em><b>Component Types</b></em>' reference list.
	 * The list contents are of type {@link org.m2ling.domain.core.ComponentType}.
	 * It is bidirectional and its opposite is '{@link org.m2ling.domain.core.ComponentType#getEngineType <em>Engine Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Component Types</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Component Types</em>' reference list.
	 * @see org.m2ling.domain.core.CorePackage#getEngineType_ComponentTypes()
	 * @see org.m2ling.domain.core.ComponentType#getEngineType
	 * @model opposite="engineType"
	 * @generated
	 */
	EList<ComponentType> getComponentTypes();

	/**
	 * Returns the value of the '<em><b>Sub Types</b></em>' containment reference list.
	 * The list contents are of type {@link org.m2ling.domain.core.EngineType}.
	 * It is bidirectional and its opposite is '{@link org.m2ling.domain.core.EngineType#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Types</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Types</em>' containment reference list.
	 * @see org.m2ling.domain.core.CorePackage#getEngineType_SubTypes()
	 * @see org.m2ling.domain.core.EngineType#getParent
	 * @model opposite="parent" containment="true"
	 * @generated
	 */
	EList<EngineType> getSubTypes();

	/**
	 * Returns the value of the '<em><b>Parent</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.m2ling.domain.core.EngineType#getSubTypes <em>Sub Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' container reference.
	 * @see #setParent(EngineType)
	 * @see org.m2ling.domain.core.CorePackage#getEngineType_Parent()
	 * @see org.m2ling.domain.core.EngineType#getSubTypes
	 * @model opposite="subTypes" transient="false"
	 * @generated
	 */
	EngineType getParent();

	/**
	 * Sets the value of the '{@link org.m2ling.domain.core.EngineType#getParent <em>Parent</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' container reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(EngineType value);

} // EngineType

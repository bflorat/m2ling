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
 * A representation of the model object '<em><b>Component Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.m2ling.domain.core.ComponentType#getSubTypes <em>Sub Types</em>}</li>
 *   <li>{@link org.m2ling.domain.core.ComponentType#getEngineType <em>Engine Type</em>}</li>
 *   <li>{@link org.m2ling.domain.core.ComponentType#getParent <em>Parent</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.m2ling.domain.core.CorePackage#getComponentType()
 * @model
 * @generated
 */
public interface ComponentType extends ConceptItem {
	/**
	 * Returns the value of the '<em><b>Sub Types</b></em>' containment reference list.
	 * The list contents are of type {@link org.m2ling.domain.core.ComponentType}.
	 * It is bidirectional and its opposite is '{@link org.m2ling.domain.core.ComponentType#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Types</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Types</em>' containment reference list.
	 * @see org.m2ling.domain.core.CorePackage#getComponentType_SubTypes()
	 * @see org.m2ling.domain.core.ComponentType#getParent
	 * @model opposite="parent" containment="true"
	 * @generated
	 */
	EList<ComponentType> getSubTypes();

	/**
	 * Returns the value of the '<em><b>Engine Type</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.m2ling.domain.core.EngineType#getComponentTypes <em>Component Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Engine Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Engine Type</em>' reference.
	 * @see #setEngineType(EngineType)
	 * @see org.m2ling.domain.core.CorePackage#getComponentType_EngineType()
	 * @see org.m2ling.domain.core.EngineType#getComponentTypes
	 * @model opposite="componentTypes" required="true"
	 * @generated
	 */
	EngineType getEngineType();

	/**
	 * Sets the value of the '{@link org.m2ling.domain.core.ComponentType#getEngineType <em>Engine Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Engine Type</em>' reference.
	 * @see #getEngineType()
	 * @generated
	 */
	void setEngineType(EngineType value);

	/**
	 * Returns the value of the '<em><b>Parent</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.m2ling.domain.core.ComponentType#getSubTypes <em>Sub Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' container reference.
	 * @see #setParent(ComponentType)
	 * @see org.m2ling.domain.core.CorePackage#getComponentType_Parent()
	 * @see org.m2ling.domain.core.ComponentType#getSubTypes
	 * @model opposite="subTypes" transient="false"
	 * @generated
	 */
	ComponentType getParent();

	/**
	 * Sets the value of the '{@link org.m2ling.domain.core.ComponentType#getParent <em>Parent</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' container reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(ComponentType value);

} // ComponentType

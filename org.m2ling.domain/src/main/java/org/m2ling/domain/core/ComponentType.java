/**
 * Copyright (C) 2012 Bertrand Florat
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
 *   <li>{@link org.m2ling.domain.core.ComponentType#getBoundType <em>Bound Type</em>}</li>
 *   <li>{@link org.m2ling.domain.core.ComponentType#getEnumeration <em>Enumeration</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.m2ling.domain.core.CorePackage#getComponentType()
 * @model
 * @generated
 */
public interface ComponentType extends ConceptItem, HasParameterDefinitions {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (C) 2012 Bertrand Florat";

	/**
	 * Returns the value of the '<em><b>Sub Types</b></em>' containment reference list.
	 * The list contents are of type {@link org.m2ling.domain.core.ComponentType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Types</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Types</em>' containment reference list.
	 * @see org.m2ling.domain.core.CorePackage#getComponentType_SubTypes()
	 * @model containment="true"
	 * @generated
	 */
	EList<ComponentType> getSubTypes();

	/**
	 * Returns the value of the '<em><b>Engine Type</b></em>' reference list.
	 * The list contents are of type {@link org.m2ling.domain.core.ComponentType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Engine Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Engine Type</em>' reference list.
	 * @see org.m2ling.domain.core.CorePackage#getComponentType_EngineType()
	 * @model
	 * @generated
	 */
	EList<ComponentType> getEngineType();

	/**
	 * Returns the value of the '<em><b>Enumeration</b></em>' reference list.
	 * The list contents are of type {@link org.m2ling.domain.core.ComponentGroup}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enumeration</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enumeration</em>' reference list.
	 * @see org.m2ling.domain.core.CorePackage#getComponentType_Enumeration()
	 * @model
	 * @generated
	 */
	EList<ComponentGroup> getEnumeration();

	/**
	 * Returns the value of the '<em><b>Bound Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bound Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bound Type</em>' reference.
	 * @see #setBoundType(ComponentType)
	 * @see org.m2ling.domain.core.CorePackage#getComponentType_BoundType()
	 * @model
	 * @generated
	 */
	ComponentType getBoundType();

	/**
	 * Sets the value of the '{@link org.m2ling.domain.core.ComponentType#getBoundType <em>Bound Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bound Type</em>' reference.
	 * @see #getBoundType()
	 * @generated
	 */
	void setBoundType(ComponentType value);

} // ComponentType

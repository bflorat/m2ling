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
 *   <li>{@link org.m2ling.domain.core.ComponentType#getBindedComponentType <em>Binded Component Type</em>}</li>
 *   <li>{@link org.m2ling.domain.core.ComponentType#getEngineType <em>Engine Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.m2ling.domain.core.CorePackage#getComponentType()
 * @model
 * @generated
 */
public interface ComponentType extends ConceptItem {
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
	 * Returns the value of the '<em><b>Binded Component Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Binded Component Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Binded Component Type</em>' reference.
	 * @see #setBindedComponentType(ComponentType)
	 * @see org.m2ling.domain.core.CorePackage#getComponentType_BindedComponentType()
	 * @model
	 * @generated
	 */
	ComponentType getBindedComponentType();

	/**
	 * Sets the value of the '{@link org.m2ling.domain.core.ComponentType#getBindedComponentType <em>Binded Component Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Binded Component Type</em>' reference.
	 * @see #getBindedComponentType()
	 * @generated
	 */
	void setBindedComponentType(ComponentType value);

	/**
	 * Returns the value of the '<em><b>Engine Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Engine Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Engine Type</em>' reference.
	 * @see #setEngineType(ComponentType)
	 * @see org.m2ling.domain.core.CorePackage#getComponentType_EngineType()
	 * @model
	 * @generated
	 */
	ComponentType getEngineType();

	/**
	 * Sets the value of the '{@link org.m2ling.domain.core.ComponentType#getEngineType <em>Engine Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Engine Type</em>' reference.
	 * @see #getEngineType()
	 * @generated
	 */
	void setEngineType(ComponentType value);

} // ComponentType

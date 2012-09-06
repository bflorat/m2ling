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
 *   <li>{@link org.m2ling.domain.core.ComponentType#getBoundType <em>Bound Type</em>}</li>
 *   <li>{@link org.m2ling.domain.core.ComponentType#getEnumeration <em>Enumeration</em>}</li>
 *   <li>{@link org.m2ling.domain.core.ComponentType#getInstantiationFactor <em>Instantiation Factor</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.m2ling.domain.core.CorePackage#getComponentType()
 * @model
 * @generated
 */
public interface ComponentType extends ConceptItem, HasReferences {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (C) 2012 Bertrand Florat";

	/**
	 * Returns the value of the '<em><b>Enumeration</b></em>' reference list.
	 * The list contents are of type {@link org.m2ling.domain.core.ArchitectureItem}.
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
	EList<ArchitectureItem> getEnumeration();

	/**
	 * Returns the value of the '<em><b>Instantiation Factor</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Instantiation Factor</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instantiation Factor</em>' attribute.
	 * @see #setInstantiationFactor(int)
	 * @see org.m2ling.domain.core.CorePackage#getComponentType_InstantiationFactor()
	 * @model default="0"
	 * @generated
	 */
	int getInstantiationFactor();

	/**
	 * Sets the value of the '{@link org.m2ling.domain.core.ComponentType#getInstantiationFactor <em>Instantiation Factor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Instantiation Factor</em>' attribute.
	 * @see #getInstantiationFactor()
	 * @generated
	 */
	void setInstantiationFactor(int value);

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

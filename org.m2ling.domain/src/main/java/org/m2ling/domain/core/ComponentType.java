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
 *   <li>{@link org.m2ling.domain.core.ComponentType#getEngineTypes <em>Engine Types</em>}</li>
 *   <li>{@link org.m2ling.domain.core.ComponentType#getSubTypes <em>Sub Types</em>}</li>
 *   <li>{@link org.m2ling.domain.core.ComponentType#getBoundType <em>Bound Type</em>}</li>
 *   <li>{@link org.m2ling.domain.core.ComponentType#getEnumeration <em>Enumeration</em>}</li>
 *   <li>{@link org.m2ling.domain.core.ComponentType#getInstantiationFactor <em>Instantiation Factor</em>}</li>
 *   <li>{@link org.m2ling.domain.core.ComponentType#isReifiable <em>Reifiable</em>}</li>
 *   <li>{@link org.m2ling.domain.core.ComponentType#getReferences <em>References</em>}</li>
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
	 * Returns the value of the '<em><b>Engine Types</b></em>' reference list.
	 * The list contents are of type {@link org.m2ling.domain.core.ComponentType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Engine Types</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Engine Types</em>' reference list.
	 * @see org.m2ling.domain.core.CorePackage#getComponentType_EngineTypes()
	 * @model
	 * @generated
	 */
	EList<ComponentType> getEngineTypes();

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
	 * Returns the value of the '<em><b>Instantiation Factor</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Instantiation Factor</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instantiation Factor</em>' attribute.
	 * @see #setInstantiationFactor(int)
	 * @see org.m2ling.domain.core.CorePackage#getComponentType_InstantiationFactor()
	 * @model default="1"
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
	 * Returns the value of the '<em><b>Reifiable</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reifiable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reifiable</em>' attribute.
	 * @see #setReifiable(boolean)
	 * @see org.m2ling.domain.core.CorePackage#getComponentType_Reifiable()
	 * @model default="false"
	 * @generated
	 */
	boolean isReifiable();

	/**
	 * Sets the value of the '{@link org.m2ling.domain.core.ComponentType#isReifiable <em>Reifiable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reifiable</em>' attribute.
	 * @see #isReifiable()
	 * @generated
	 */
	void setReifiable(boolean value);

	/**
	 * Returns the value of the '<em><b>References</b></em>' containment reference list.
	 * The list contents are of type {@link org.m2ling.domain.core.Reference}&lt;?>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>References</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>References</em>' containment reference list.
	 * @see org.m2ling.domain.core.CorePackage#getComponentType_References()
	 * @model containment="true"
	 * @generated
	 */
	EList<Reference<?>> getReferences();

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

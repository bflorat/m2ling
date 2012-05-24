/**
 * Copyright (C) 2012 Bertrand Florat
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
 *   <li>{@link org.m2ling.domain.core.Component#getSubComponents <em>Sub Components</em>}</li>
 *   <li>{@link org.m2ling.domain.core.Component#getType <em>Type</em>}</li>
 *   <li>{@link org.m2ling.domain.core.Component#getEngines <em>Engines</em>}</li>
 *   <li>{@link org.m2ling.domain.core.Component#getBoundComponent <em>Bound Component</em>}</li>
 *   <li>{@link org.m2ling.domain.core.Component#getNodes <em>Nodes</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.m2ling.domain.core.CorePackage#getComponent()
 * @model
 * @generated
 */
public interface Component extends ComponentGroup {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (C) 2012 Bertrand Florat";

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
	 * Returns the value of the '<em><b>Engines</b></em>' reference list.
	 * The list contents are of type {@link org.m2ling.domain.core.Component}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Engines</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Engines</em>' reference list.
	 * @see org.m2ling.domain.core.CorePackage#getComponent_Engines()
	 * @model keys="id"
	 * @generated
	 */
	EList<Component> getEngines();

	/**
	 * Returns the value of the '<em><b>Sub Components</b></em>' containment reference list.
	 * The list contents are of type {@link org.m2ling.domain.core.Component}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Components</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Components</em>' containment reference list.
	 * @see org.m2ling.domain.core.CorePackage#getComponent_SubComponents()
	 * @model containment="true"
	 * @generated
	 */
	EList<Component> getSubComponents();

	/**
	 * Returns the value of the '<em><b>Bound Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bound Component</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bound Component</em>' reference.
	 * @see #setBoundComponent(Component)
	 * @see org.m2ling.domain.core.CorePackage#getComponent_BoundComponent()
	 * @model
	 * @generated
	 */
	Component getBoundComponent();

	/**
	 * Sets the value of the '{@link org.m2ling.domain.core.Component#getBoundComponent <em>Bound Component</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bound Component</em>' reference.
	 * @see #getBoundComponent()
	 * @generated
	 */
	void setBoundComponent(Component value);

	/**
	 * Returns the value of the '<em><b>Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link org.m2ling.domain.core.ComponentNode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nodes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nodes</em>' containment reference list.
	 * @see org.m2ling.domain.core.CorePackage#getComponent_Nodes()
	 * @model containment="true"
	 * @generated
	 */
	EList<ComponentNode> getNodes();

} // Component

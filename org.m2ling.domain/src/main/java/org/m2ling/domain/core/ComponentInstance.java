/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.domain.core;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Component Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.m2ling.domain.core.ComponentInstance#getComponent <em>Component</em>}</li>
 *   <li>{@link org.m2ling.domain.core.ComponentInstance#getBoundComponentInstance <em>Bound Component Instance</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.m2ling.domain.core.CorePackage#getComponentInstance()
 * @model
 * @generated
 */
public interface ComponentInstance extends RuntimeItem, HasReferences {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (C) 2012 Bertrand Florat";

	/**
	 * Returns the value of the '<em><b>Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Component</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Component</em>' reference.
	 * @see #setComponent(Component)
	 * @see org.m2ling.domain.core.CorePackage#getComponentInstance_Component()
	 * @model required="true"
	 * @generated
	 */
	Component getComponent();

	/**
	 * Sets the value of the '{@link org.m2ling.domain.core.ComponentInstance#getComponent <em>Component</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Component</em>' reference.
	 * @see #getComponent()
	 * @generated
	 */
	void setComponent(Component value);

	/**
	 * Returns the value of the '<em><b>Bound Component Instance</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bound Component Instance</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bound Component Instance</em>' reference.
	 * @see #setBoundComponentInstance(ComponentInstance)
	 * @see org.m2ling.domain.core.CorePackage#getComponentInstance_BoundComponentInstance()
	 * @model
	 * @generated
	 */
	ComponentInstance getBoundComponentInstance();

	/**
	 * Sets the value of the '{@link org.m2ling.domain.core.ComponentInstance#getBoundComponentInstance <em>Bound Component Instance</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bound Component Instance</em>' reference.
	 * @see #getBoundComponentInstance()
	 * @generated
	 */
	void setBoundComponentInstance(ComponentInstance value);

} // ComponentInstance

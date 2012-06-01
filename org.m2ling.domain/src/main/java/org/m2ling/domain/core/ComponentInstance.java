/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.domain.core;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Component Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.m2ling.domain.core.ComponentInstance#getComponent <em>Component</em>}</li>
 *   <li>{@link org.m2ling.domain.core.ComponentInstance#getInstances <em>Instances</em>}</li>
 *   <li>{@link org.m2ling.domain.core.ComponentInstance#getInstancesGroups <em>Instances Groups</em>}</li>
 *   <li>{@link org.m2ling.domain.core.ComponentInstance#getBoundComponentInstance <em>Bound Component Instance</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.m2ling.domain.core.CorePackage#getComponentInstance()
 * @model
 * @generated
 */
public interface ComponentInstance extends ComponentInstanceGroup, HasParameterValues {
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
	 * Returns the value of the '<em><b>Instances</b></em>' containment reference list.
	 * The list contents are of type {@link org.m2ling.domain.core.ComponentInstance}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Instances</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instances</em>' containment reference list.
	 * @see org.m2ling.domain.core.CorePackage#getComponentInstance_Instances()
	 * @model containment="true"
	 * @generated
	 */
	EList<ComponentInstance> getInstances();

	/**
	 * Returns the value of the '<em><b>Instances Groups</b></em>' containment reference list.
	 * The list contents are of type {@link org.m2ling.domain.core.ComponentInstanceGroup}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Instances Groups</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instances Groups</em>' containment reference list.
	 * @see org.m2ling.domain.core.CorePackage#getComponentInstance_InstancesGroups()
	 * @model containment="true"
	 * @generated
	 */
	EList<ComponentInstanceGroup> getInstancesGroups();

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

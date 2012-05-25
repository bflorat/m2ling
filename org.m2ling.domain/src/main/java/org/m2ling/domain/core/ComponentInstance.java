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
 *   <li>{@link org.m2ling.domain.core.ComponentInstance#getSubInstances <em>Sub Instances</em>}</li>
 *   <li>{@link org.m2ling.domain.core.ComponentInstance#getEngineInstance <em>Engine Instance</em>}</li>
 *   <li>{@link org.m2ling.domain.core.ComponentInstance#getInstances <em>Instances</em>}</li>
 *   <li>{@link org.m2ling.domain.core.ComponentInstance#getStreams <em>Streams</em>}</li>
 *   <li>{@link org.m2ling.domain.core.ComponentInstance#getInstancesGroups <em>Instances Groups</em>}</li>
 *   <li>{@link org.m2ling.domain.core.ComponentInstance#getBoundComponentInstance <em>Bound Component Instance</em>}</li>
 *   <li>{@link org.m2ling.domain.core.ComponentInstance#getReferences <em>References</em>}</li>
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
	 * Returns the value of the '<em><b>Sub Instances</b></em>' containment reference list.
	 * The list contents are of type {@link org.m2ling.domain.core.ComponentInstance}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Instances</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Instances</em>' containment reference list.
	 * @see org.m2ling.domain.core.CorePackage#getComponentInstance_SubInstances()
	 * @model containment="true"
	 * @generated
	 */
	EList<ComponentInstance> getSubInstances();

	/**
	 * Returns the value of the '<em><b>Engine Instance</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Engine Instance</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Engine Instance</em>' reference.
	 * @see #setEngineInstance(ComponentInstance)
	 * @see org.m2ling.domain.core.CorePackage#getComponentInstance_EngineInstance()
	 * @model
	 * @generated
	 */
	ComponentInstance getEngineInstance();

	/**
	 * Sets the value of the '{@link org.m2ling.domain.core.ComponentInstance#getEngineInstance <em>Engine Instance</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Engine Instance</em>' reference.
	 * @see #getEngineInstance()
	 * @generated
	 */
	void setEngineInstance(ComponentInstance value);

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
	 * Returns the value of the '<em><b>Streams</b></em>' containment reference list.
	 * The list contents are of type {@link org.m2ling.domain.core.InstancesLink}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Streams</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Streams</em>' containment reference list.
	 * @see org.m2ling.domain.core.CorePackage#getComponentInstance_Streams()
	 * @model containment="true"
	 * @generated
	 */
	EList<InstancesLink> getStreams();

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
	 * @see org.m2ling.domain.core.CorePackage#getComponentInstance_References()
	 * @model containment="true"
	 * @generated
	 */
	EList<Reference<?>> getReferences();

} // ComponentInstance

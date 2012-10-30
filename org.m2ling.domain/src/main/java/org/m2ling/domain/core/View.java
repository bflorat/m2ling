/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.domain.core;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>View</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.m2ling.domain.core.View#getComponentsGroups <em>Components Groups</em>}</li>
 *   <li>{@link org.m2ling.domain.core.View#getComponents <em>Components</em>}</li>
 *   <li>{@link org.m2ling.domain.core.View#getViewPoint <em>View Point</em>}</li>
 *   <li>{@link org.m2ling.domain.core.View#getLinks <em>Links</em>}</li>
 *   <li>{@link org.m2ling.domain.core.View#getComponentInstances <em>Component Instances</em>}</li>
 *   <li>{@link org.m2ling.domain.core.View#getInstancesGroups <em>Instances Groups</em>}</li>
 *   <li>{@link org.m2ling.domain.core.View#getLinkInstances <em>Link Instances</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.m2ling.domain.core.CorePackage#getView()
 * @model
 * @generated
 */
public interface View extends HasComment, HasDescription, HasNameAndID, HasTags, HasStatus {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (C) 2012 Bertrand Florat";

	/**
	 * Returns the value of the '<em><b>Components Groups</b></em>' containment reference list.
	 * The list contents are of type {@link org.m2ling.domain.core.ComponentGroup}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Components Groups</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Components Groups</em>' containment reference list.
	 * @see org.m2ling.domain.core.CorePackage#getView_ComponentsGroups()
	 * @model containment="true"
	 * @generated
	 */
	EList<ComponentGroup> getComponentsGroups();

	/**
	 * Returns the value of the '<em><b>Components</b></em>' containment reference list.
	 * The list contents are of type {@link org.m2ling.domain.core.Component}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Components</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Components</em>' containment reference list.
	 * @see org.m2ling.domain.core.CorePackage#getView_Components()
	 * @model containment="true" keys="id"
	 * @generated
	 */
	EList<Component> getComponents();

	/**
	 * Returns the value of the '<em><b>View Point</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>View Point</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>View Point</em>' reference.
	 * @see #setViewPoint(ViewPoint)
	 * @see org.m2ling.domain.core.CorePackage#getView_ViewPoint()
	 * @model required="true"
	 * @generated
	 */
	ViewPoint getViewPoint();

	/**
	 * Sets the value of the '{@link org.m2ling.domain.core.View#getViewPoint <em>View Point</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>View Point</em>' reference.
	 * @see #getViewPoint()
	 * @generated
	 */
	void setViewPoint(ViewPoint value);

	/**
	 * Returns the value of the '<em><b>Links</b></em>' containment reference list.
	 * The list contents are of type {@link org.m2ling.domain.core.Link}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Links</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Links</em>' containment reference list.
	 * @see org.m2ling.domain.core.CorePackage#getView_Links()
	 * @model containment="true" keys="id"
	 * @generated
	 */
	EList<Link> getLinks();

	/**
	 * Returns the value of the '<em><b>Component Instances</b></em>' containment reference list.
	 * The list contents are of type {@link org.m2ling.domain.core.ComponentInstance}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Component Instances</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Component Instances</em>' containment reference list.
	 * @see org.m2ling.domain.core.CorePackage#getView_ComponentInstances()
	 * @model containment="true"
	 * @generated
	 */
	EList<ComponentInstance> getComponentInstances();

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
	 * @see org.m2ling.domain.core.CorePackage#getView_InstancesGroups()
	 * @model containment="true"
	 * @generated
	 */
	EList<ComponentInstanceGroup> getInstancesGroups();

	/**
	 * Returns the value of the '<em><b>Link Instances</b></em>' containment reference list.
	 * The list contents are of type {@link org.m2ling.domain.core.LinkInstance}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Link Instances</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link Instances</em>' containment reference list.
	 * @see org.m2ling.domain.core.CorePackage#getView_LinkInstances()
	 * @model containment="true"
	 * @generated
	 */
	EList<LinkInstance> getLinkInstances();

} // View

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
 *   <li>{@link org.m2ling.domain.core.View#getNodes <em>Nodes</em>}</li>
 *   <li>{@link org.m2ling.domain.core.View#getNodesGroups <em>Nodes Groups</em>}</li>
 *   <li>{@link org.m2ling.domain.core.View#getStreams <em>Streams</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.m2ling.domain.core.CorePackage#getView()
 * @model
 * @generated
 */
public interface View extends ArchitectureItem {
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
	 * Returns the value of the '<em><b>Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link org.m2ling.domain.core.ComponentNode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nodes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nodes</em>' containment reference list.
	 * @see org.m2ling.domain.core.CorePackage#getView_Nodes()
	 * @model containment="true"
	 * @generated
	 */
	EList<ComponentNode> getNodes();

	/**
	 * Returns the value of the '<em><b>Nodes Groups</b></em>' containment reference list.
	 * The list contents are of type {@link org.m2ling.domain.core.ComponentNodeGroup}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nodes Groups</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nodes Groups</em>' containment reference list.
	 * @see org.m2ling.domain.core.CorePackage#getView_NodesGroups()
	 * @model containment="true"
	 * @generated
	 */
	EList<ComponentNodeGroup> getNodesGroups();

	/**
	 * Returns the value of the '<em><b>Streams</b></em>' containment reference list.
	 * The list contents are of type {@link org.m2ling.domain.core.NodesLink}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Streams</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Streams</em>' containment reference list.
	 * @see org.m2ling.domain.core.CorePackage#getView_Streams()
	 * @model containment="true"
	 * @generated
	 */
	EList<NodesLink> getStreams();

} // View

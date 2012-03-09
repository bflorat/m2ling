/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.m2ling.domain.core;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Environnement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.m2ling.domain.core.Environnement#getComponentNodes <em>Component Nodes</em>}</li>
 *   <li>{@link org.m2ling.domain.core.Environnement#getEngineNodes <em>Engine Nodes</em>}</li>
 *   <li>{@link org.m2ling.domain.core.Environnement#getComponentNodeGroups <em>Component Node Groups</em>}</li>
 *   <li>{@link org.m2ling.domain.core.Environnement#getEngineNodeGroups <em>Engine Node Groups</em>}</li>
 *   <li>{@link org.m2ling.domain.core.Environnement#getProfile <em>Profile</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.m2ling.domain.core.CorePackage#getEnvironnement()
 * @model
 * @generated
 */
public interface Environnement extends RuntimeItem {
	/**
	 * Returns the value of the '<em><b>Component Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link org.m2ling.domain.core.ComponentNode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Component Nodes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Component Nodes</em>' containment reference list.
	 * @see org.m2ling.domain.core.CorePackage#getEnvironnement_ComponentNodes()
	 * @model containment="true"
	 * @generated
	 */
	EList<ComponentNode> getComponentNodes();

	/**
	 * Returns the value of the '<em><b>Engine Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link org.m2ling.domain.core.EngineNode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Engine Nodes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Engine Nodes</em>' containment reference list.
	 * @see org.m2ling.domain.core.CorePackage#getEnvironnement_EngineNodes()
	 * @model containment="true"
	 * @generated
	 */
	EList<EngineNode> getEngineNodes();

	/**
	 * Returns the value of the '<em><b>Component Node Groups</b></em>' containment reference list.
	 * The list contents are of type {@link org.m2ling.domain.core.ComponentNodeGroup}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Component Node Groups</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Component Node Groups</em>' containment reference list.
	 * @see org.m2ling.domain.core.CorePackage#getEnvironnement_ComponentNodeGroups()
	 * @model containment="true"
	 * @generated
	 */
	EList<ComponentNodeGroup> getComponentNodeGroups();

	/**
	 * Returns the value of the '<em><b>Engine Node Groups</b></em>' containment reference list.
	 * The list contents are of type {@link org.m2ling.domain.core.EngineNodeGroup}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Engine Node Groups</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Engine Node Groups</em>' containment reference list.
	 * @see org.m2ling.domain.core.CorePackage#getEnvironnement_EngineNodeGroups()
	 * @model containment="true"
	 * @generated
	 */
	EList<EngineNodeGroup> getEngineNodeGroups();

	/**
	 * Returns the value of the '<em><b>Profile</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Profile</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Profile</em>' attribute.
	 * @see #setProfile(String)
	 * @see org.m2ling.domain.core.CorePackage#getEnvironnement_Profile()
	 * @model
	 * @generated
	 */
	String getProfile();

	/**
	 * Sets the value of the '{@link org.m2ling.domain.core.Environnement#getProfile <em>Profile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Profile</em>' attribute.
	 * @see #getProfile()
	 * @generated
	 */
	void setProfile(String value);

} // Environnement

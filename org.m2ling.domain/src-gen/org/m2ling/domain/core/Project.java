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
 * A representation of the model object '<em><b>Project</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.m2ling.domain.core.Project#getComponentsGroups <em>Components Groups</em>}</li>
 *   <li>{@link org.m2ling.domain.core.Project#getComponents <em>Components</em>}</li>
 *   <li>{@link org.m2ling.domain.core.Project#getEngines <em>Engines</em>}</li>
 *   <li>{@link org.m2ling.domain.core.Project#getEngineGroups <em>Engine Groups</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.m2ling.domain.core.CorePackage#getProject()
 * @model
 * @generated
 */
public interface Project extends ArchitectureItem {
	/**
	 * Returns the value of the '<em><b>Components Groups</b></em>' reference list.
	 * The list contents are of type {@link org.m2ling.domain.core.ComponentGroup}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Components Groups</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Components Groups</em>' reference list.
	 * @see org.m2ling.domain.core.CorePackage#getProject_ComponentsGroups()
	 * @model
	 * @generated
	 */
	EList<ComponentGroup> getComponentsGroups();

	/**
	 * Returns the value of the '<em><b>Components</b></em>' reference list.
	 * The list contents are of type {@link org.m2ling.domain.core.Component}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Components</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Components</em>' reference list.
	 * @see org.m2ling.domain.core.CorePackage#getProject_Components()
	 * @model
	 * @generated
	 */
	EList<Component> getComponents();

	/**
	 * Returns the value of the '<em><b>Engines</b></em>' reference list.
	 * The list contents are of type {@link org.m2ling.domain.core.Engine}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Engines</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Engines</em>' reference list.
	 * @see org.m2ling.domain.core.CorePackage#getProject_Engines()
	 * @model
	 * @generated
	 */
	EList<Engine> getEngines();

	/**
	 * Returns the value of the '<em><b>Engine Groups</b></em>' reference list.
	 * The list contents are of type {@link org.m2ling.domain.core.EngineGroup}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Engine Groups</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Engine Groups</em>' reference list.
	 * @see org.m2ling.domain.core.CorePackage#getProject_EngineGroups()
	 * @model
	 * @generated
	 */
	EList<EngineGroup> getEngineGroups();

} // Project

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
 * A representation of the model object '<em><b>Engine Group</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.m2ling.domain.core.EngineGroup#getEngines <em>Engines</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.m2ling.domain.core.CorePackage#getEngineGroup()
 * @model
 * @generated
 */
public interface EngineGroup extends ArchitectureItem {
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
	 * @see org.m2ling.domain.core.CorePackage#getEngineGroup_Engines()
	 * @model
	 * @generated
	 */
	EList<Engine> getEngines();

} // EngineGroup

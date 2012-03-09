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
 * A representation of the model object '<em><b>Engine Node Group</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.m2ling.domain.core.EngineNodeGroup#getEngineNodes <em>Engine Nodes</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.m2ling.domain.core.CorePackage#getEngineNodeGroup()
 * @model
 * @generated
 */
public interface EngineNodeGroup extends RuntimeItem {
	/**
	 * Returns the value of the '<em><b>Engine Nodes</b></em>' reference list.
	 * The list contents are of type {@link org.m2ling.domain.core.EngineNode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Engine Nodes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Engine Nodes</em>' reference list.
	 * @see org.m2ling.domain.core.CorePackage#getEngineNodeGroup_EngineNodes()
	 * @model
	 * @generated
	 */
	EList<EngineNode> getEngineNodes();

} // EngineNodeGroup

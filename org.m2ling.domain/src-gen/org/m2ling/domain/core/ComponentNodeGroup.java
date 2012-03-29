/**
 * Copyright (C) Bertrand Florat
 */
package org.m2ling.domain.core;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Component Node Group</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.m2ling.domain.core.ComponentNodeGroup#getComponentNodes <em>Component Nodes</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.m2ling.domain.core.CorePackage#getComponentNodeGroup()
 * @model
 * @generated
 */
public interface ComponentNodeGroup extends RuntimeItem {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (C) Bertrand Florat";

	/**
	 * Returns the value of the '<em><b>Component Nodes</b></em>' reference list.
	 * The list contents are of type {@link org.m2ling.domain.core.ComponentNode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Component Nodes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Component Nodes</em>' reference list.
	 * @see org.m2ling.domain.core.CorePackage#getComponentNodeGroup_ComponentNodes()
	 * @model
	 * @generated
	 */
	EList<ComponentNode> getComponentNodes();

} // ComponentNodeGroup

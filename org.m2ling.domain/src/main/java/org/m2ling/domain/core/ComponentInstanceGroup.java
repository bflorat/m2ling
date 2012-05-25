/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.domain.core;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Component Instance Group</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.m2ling.domain.core.ComponentInstanceGroup#getComponentInstances <em>Component Instances</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.m2ling.domain.core.CorePackage#getComponentInstanceGroup()
 * @model
 * @generated
 */
public interface ComponentInstanceGroup extends RuntimeItem {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (C) 2012 Bertrand Florat";

	/**
	 * Returns the value of the '<em><b>Component Instances</b></em>' reference list.
	 * The list contents are of type {@link org.m2ling.domain.core.ComponentInstance}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Component Instances</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Component Instances</em>' reference list.
	 * @see org.m2ling.domain.core.CorePackage#getComponentInstanceGroup_ComponentInstances()
	 * @model
	 * @generated
	 */
	EList<ComponentInstance> getComponentInstances();

} // ComponentInstanceGroup

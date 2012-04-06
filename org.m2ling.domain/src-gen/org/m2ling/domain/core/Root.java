/**
 * Copyright (C) Bertrand Florat
 */
package org.m2ling.domain.core;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.m2ling.domain.core.Root#getViewPoints <em>View Points</em>}</li>
 *   <li>{@link org.m2ling.domain.core.Root#getViews <em>Views</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.m2ling.domain.core.CorePackage#getRoot()
 * @model
 * @generated
 */
public interface Root extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (C) Bertrand Florat";

	/**
	 * Returns the value of the '<em><b>View Points</b></em>' containment reference list.
	 * The list contents are of type {@link org.m2ling.domain.core.ViewPoint}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>View Points</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>View Points</em>' containment reference list.
	 * @see org.m2ling.domain.core.CorePackage#getRoot_ViewPoints()
	 * @model containment="true"
	 * @generated
	 */
	EList<ViewPoint> getViewPoints();

	/**
	 * Returns the value of the '<em><b>Views</b></em>' containment reference list.
	 * The list contents are of type {@link org.m2ling.domain.core.View}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Views</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Views</em>' containment reference list.
	 * @see org.m2ling.domain.core.CorePackage#getRoot_Views()
	 * @model containment="true"
	 * @generated
	 */
	EList<View> getViews();

} // Root

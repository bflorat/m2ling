/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.domain.core;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Activity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.m2ling.domain.core.Activity#getAccountables <em>Accountables</em>}</li>
 *   <li>{@link org.m2ling.domain.core.Activity#getResponsibles <em>Responsibles</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.m2ling.domain.core.CorePackage#getActivity()
 * @model
 * @generated
 */
public interface Activity extends HasNameAndID, HasTags, HasDescription {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (C) 2012 Bertrand Florat";

	/**
	 * Returns the value of the '<em><b>Responsibles</b></em>' reference list.
	 * The list contents are of type {@link org.m2ling.domain.core.Stakeholder}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Responsibles</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Responsibles</em>' reference list.
	 * @see org.m2ling.domain.core.CorePackage#getActivity_Responsibles()
	 * @model
	 * @generated
	 */
	EList<Stakeholder> getResponsibles();

	/**
	 * Returns the value of the '<em><b>Accountables</b></em>' reference list.
	 * The list contents are of type {@link org.m2ling.domain.core.Stakeholder}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Accountables</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Accountables</em>' reference list.
	 * @see org.m2ling.domain.core.CorePackage#getActivity_Accountables()
	 * @model
	 * @generated
	 */
	EList<Stakeholder> getAccountables();

} // Activity

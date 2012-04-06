/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.domain.core;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Stakeholder</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.m2ling.domain.core.Stakeholder#getViews <em>Views</em>}</li>
 *   <li>{@link org.m2ling.domain.core.Stakeholder#getViewPoints <em>View Points</em>}</li>
 *   <li>{@link org.m2ling.domain.core.Stakeholder#getActors <em>Actors</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.m2ling.domain.core.CorePackage#getStakeholder()
 * @model
 * @generated
 */
public interface Stakeholder extends HasNameAndID {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (C) 2012 Bertrand Florat";

	/**
	 * Returns the value of the '<em><b>Views</b></em>' reference list.
	 * The list contents are of type {@link org.m2ling.domain.core.View}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Views</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Views</em>' reference list.
	 * @see org.m2ling.domain.core.CorePackage#getStakeholder_Views()
	 * @model
	 * @generated
	 */
	EList<View> getViews();

	/**
	 * Returns the value of the '<em><b>View Points</b></em>' reference list.
	 * The list contents are of type {@link org.m2ling.domain.core.ViewPoint}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>View Points</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>View Points</em>' reference list.
	 * @see org.m2ling.domain.core.CorePackage#getStakeholder_ViewPoints()
	 * @model
	 * @generated
	 */
	EList<ViewPoint> getViewPoints();

	/**
	 * Returns the value of the '<em><b>Actors</b></em>' reference list.
	 * The list contents are of type {@link org.m2ling.domain.core.Actor}.
	 * It is bidirectional and its opposite is '{@link org.m2ling.domain.core.Actor#getStakeholders <em>Stakeholders</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actors</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actors</em>' reference list.
	 * @see org.m2ling.domain.core.CorePackage#getStakeholder_Actors()
	 * @see org.m2ling.domain.core.Actor#getStakeholders
	 * @model opposite="stakeholders"
	 * @generated
	 */
	EList<Actor> getActors();

} // Stakeholder

/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.domain.core;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Activity Transition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.m2ling.domain.core.ActivityTransition#getDate <em>Date</em>}</li>
 *   <li>{@link org.m2ling.domain.core.ActivityTransition#getFromStatus <em>From Status</em>}</li>
 *   <li>{@link org.m2ling.domain.core.ActivityTransition#getToStatus <em>To Status</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.m2ling.domain.core.CorePackage#getActivityTransition()
 * @model
 * @generated
 */
public interface ActivityTransition extends HasComment {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (C) 2012 Bertrand Florat";

	/**
	 * Returns the value of the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Date</em>' attribute.
	 * @see #setDate(long)
	 * @see org.m2ling.domain.core.CorePackage#getActivityTransition_Date()
	 * @model
	 * @generated
	 */
	long getDate();

	/**
	 * Sets the value of the '{@link org.m2ling.domain.core.ActivityTransition#getDate <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Date</em>' attribute.
	 * @see #getDate()
	 * @generated
	 */
	void setDate(long value);

	/**
	 * Returns the value of the '<em><b>From Status</b></em>' attribute.
	 * The literals are from the enumeration {@link org.m2ling.domain.core.ActivityStatus}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>From Status</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>From Status</em>' attribute.
	 * @see org.m2ling.domain.core.ActivityStatus
	 * @see #setFromStatus(ActivityStatus)
	 * @see org.m2ling.domain.core.CorePackage#getActivityTransition_FromStatus()
	 * @model
	 * @generated
	 */
	ActivityStatus getFromStatus();

	/**
	 * Sets the value of the '{@link org.m2ling.domain.core.ActivityTransition#getFromStatus <em>From Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>From Status</em>' attribute.
	 * @see org.m2ling.domain.core.ActivityStatus
	 * @see #getFromStatus()
	 * @generated
	 */
	void setFromStatus(ActivityStatus value);

	/**
	 * Returns the value of the '<em><b>To Status</b></em>' attribute.
	 * The literals are from the enumeration {@link org.m2ling.domain.core.ActivityStatus}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>To Status</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>To Status</em>' attribute.
	 * @see org.m2ling.domain.core.ActivityStatus
	 * @see #setToStatus(ActivityStatus)
	 * @see org.m2ling.domain.core.CorePackage#getActivityTransition_ToStatus()
	 * @model
	 * @generated
	 */
	ActivityStatus getToStatus();

	/**
	 * Sets the value of the '{@link org.m2ling.domain.core.ActivityTransition#getToStatus <em>To Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>To Status</em>' attribute.
	 * @see org.m2ling.domain.core.ActivityStatus
	 * @see #getToStatus()
	 * @generated
	 */
	void setToStatus(ActivityStatus value);

} // ActivityTransition
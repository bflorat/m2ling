/**
 * Copyright (C) Bertrand Florat
 */
package org.m2ling.domain.core.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.m2ling.domain.core.ActivityStatus;
import org.m2ling.domain.core.ActivityTransition;
import org.m2ling.domain.core.CorePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Activity Transition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.m2ling.domain.core.impl.ActivityTransitionImpl#getDate <em>Date</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.ActivityTransitionImpl#getFromStatus <em>From Status</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.ActivityTransitionImpl#getToStatus <em>To Status</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ActivityTransitionImpl extends HasCommentImpl implements ActivityTransition {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (C) Bertrand Florat";

	/**
	 * The default value of the '{@link #getDate() <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDate()
	 * @generated
	 * @ordered
	 */
	protected static final long DATE_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getDate() <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDate()
	 * @generated
	 * @ordered
	 */
	protected long date = DATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getFromStatus() <em>From Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFromStatus()
	 * @generated
	 * @ordered
	 */
	protected static final ActivityStatus FROM_STATUS_EDEFAULT = ActivityStatus.TODO;

	/**
	 * The cached value of the '{@link #getFromStatus() <em>From Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFromStatus()
	 * @generated
	 * @ordered
	 */
	protected ActivityStatus fromStatus = FROM_STATUS_EDEFAULT;

	/**
	 * The default value of the '{@link #getToStatus() <em>To Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getToStatus()
	 * @generated
	 * @ordered
	 */
	protected static final ActivityStatus TO_STATUS_EDEFAULT = ActivityStatus.TODO;

	/**
	 * The cached value of the '{@link #getToStatus() <em>To Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getToStatus()
	 * @generated
	 * @ordered
	 */
	protected ActivityStatus toStatus = TO_STATUS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ActivityTransitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CorePackage.Literals.ACTIVITY_TRANSITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getDate() {
		return date;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDate(long newDate) {
		long oldDate = date;
		date = newDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.ACTIVITY_TRANSITION__DATE, oldDate, date));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActivityStatus getFromStatus() {
		return fromStatus;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFromStatus(ActivityStatus newFromStatus) {
		ActivityStatus oldFromStatus = fromStatus;
		fromStatus = newFromStatus == null ? FROM_STATUS_EDEFAULT : newFromStatus;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.ACTIVITY_TRANSITION__FROM_STATUS, oldFromStatus, fromStatus));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActivityStatus getToStatus() {
		return toStatus;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setToStatus(ActivityStatus newToStatus) {
		ActivityStatus oldToStatus = toStatus;
		toStatus = newToStatus == null ? TO_STATUS_EDEFAULT : newToStatus;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.ACTIVITY_TRANSITION__TO_STATUS, oldToStatus, toStatus));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CorePackage.ACTIVITY_TRANSITION__DATE:
				return getDate();
			case CorePackage.ACTIVITY_TRANSITION__FROM_STATUS:
				return getFromStatus();
			case CorePackage.ACTIVITY_TRANSITION__TO_STATUS:
				return getToStatus();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CorePackage.ACTIVITY_TRANSITION__DATE:
				setDate((Long)newValue);
				return;
			case CorePackage.ACTIVITY_TRANSITION__FROM_STATUS:
				setFromStatus((ActivityStatus)newValue);
				return;
			case CorePackage.ACTIVITY_TRANSITION__TO_STATUS:
				setToStatus((ActivityStatus)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case CorePackage.ACTIVITY_TRANSITION__DATE:
				setDate(DATE_EDEFAULT);
				return;
			case CorePackage.ACTIVITY_TRANSITION__FROM_STATUS:
				setFromStatus(FROM_STATUS_EDEFAULT);
				return;
			case CorePackage.ACTIVITY_TRANSITION__TO_STATUS:
				setToStatus(TO_STATUS_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case CorePackage.ACTIVITY_TRANSITION__DATE:
				return date != DATE_EDEFAULT;
			case CorePackage.ACTIVITY_TRANSITION__FROM_STATUS:
				return fromStatus != FROM_STATUS_EDEFAULT;
			case CorePackage.ACTIVITY_TRANSITION__TO_STATUS:
				return toStatus != TO_STATUS_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (date: ");
		result.append(date);
		result.append(", fromStatus: ");
		result.append(fromStatus);
		result.append(", toStatus: ");
		result.append(toStatus);
		result.append(')');
		return result.toString();
	}

} //ActivityTransitionImpl

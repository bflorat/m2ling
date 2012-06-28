/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.domain.core.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.m2ling.domain.core.CorePackage;
import org.m2ling.domain.core.StatusEvent;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Status Event</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.m2ling.domain.core.impl.StatusEventImpl#getDate <em>Date</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.StatusEventImpl#getStatusLiteral <em>Status Literal</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StatusEventImpl extends EObjectImpl implements StatusEvent {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (C) 2012 Bertrand Florat";

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
	 * The default value of the '{@link #getStatusLiteral() <em>Status Literal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatusLiteral()
	 * @generated
	 * @ordered
	 */
	protected static final String STATUS_LITERAL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStatusLiteral() <em>Status Literal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatusLiteral()
	 * @generated
	 * @ordered
	 */
	protected String statusLiteral = STATUS_LITERAL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StatusEventImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CorePackage.Literals.STATUS_EVENT;
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
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.STATUS_EVENT__DATE, oldDate, date));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getStatusLiteral() {
		return statusLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStatusLiteral(String newStatusLiteral) {
		String oldStatusLiteral = statusLiteral;
		statusLiteral = newStatusLiteral;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.STATUS_EVENT__STATUS_LITERAL, oldStatusLiteral, statusLiteral));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CorePackage.STATUS_EVENT__DATE:
				return getDate();
			case CorePackage.STATUS_EVENT__STATUS_LITERAL:
				return getStatusLiteral();
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
			case CorePackage.STATUS_EVENT__DATE:
				setDate((Long)newValue);
				return;
			case CorePackage.STATUS_EVENT__STATUS_LITERAL:
				setStatusLiteral((String)newValue);
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
			case CorePackage.STATUS_EVENT__DATE:
				setDate(DATE_EDEFAULT);
				return;
			case CorePackage.STATUS_EVENT__STATUS_LITERAL:
				setStatusLiteral(STATUS_LITERAL_EDEFAULT);
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
			case CorePackage.STATUS_EVENT__DATE:
				return date != DATE_EDEFAULT;
			case CorePackage.STATUS_EVENT__STATUS_LITERAL:
				return STATUS_LITERAL_EDEFAULT == null ? statusLiteral != null : !STATUS_LITERAL_EDEFAULT.equals(statusLiteral);
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
		result.append(", statusLiteral: ");
		result.append(statusLiteral);
		result.append(')');
		return result.toString();
	}

} //StatusEventImpl

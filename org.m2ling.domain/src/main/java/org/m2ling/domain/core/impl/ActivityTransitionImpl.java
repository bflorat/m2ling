/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.domain.core.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.m2ling.domain.core.Activity;
import org.m2ling.domain.core.ActivityStatus;
import org.m2ling.domain.core.ActivityTransition;
import org.m2ling.domain.core.Actor;
import org.m2ling.domain.core.CorePackage;
import org.m2ling.domain.core.HasDescription;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Activity Transition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.m2ling.domain.core.impl.ActivityTransitionImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.ActivityTransitionImpl#getDate <em>Date</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.ActivityTransitionImpl#getFromStatus <em>From Status</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.ActivityTransitionImpl#getToStatus <em>To Status</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.ActivityTransitionImpl#getActivity <em>Activity</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.ActivityTransitionImpl#getActor <em>Actor</em>}</li>
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
	public static final String copyright = "Copyright (C) 2012 Bertrand Florat";

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

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
	protected static final String FROM_STATUS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFromStatus() <em>From Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFromStatus()
	 * @generated
	 * @ordered
	 */
	protected String fromStatus = FROM_STATUS_EDEFAULT;

	/**
	 * The default value of the '{@link #getToStatus() <em>To Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getToStatus()
	 * @generated
	 * @ordered
	 */
	protected static final String TO_STATUS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getToStatus() <em>To Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getToStatus()
	 * @generated
	 * @ordered
	 */
	protected String toStatus = TO_STATUS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getActivity() <em>Activity</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActivity()
	 * @generated
	 * @ordered
	 */
	protected Activity activity;

	/**
	 * The cached value of the '{@link #getActor() <em>Actor</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActor()
	 * @generated
	 * @ordered
	 */
	protected EList<Actor> actor;

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
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.ACTIVITY_TRANSITION__DESCRIPTION, oldDescription, description));
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
	public String getFromStatus() {
		return fromStatus;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFromStatus(String newFromStatus) {
		String oldFromStatus = fromStatus;
		fromStatus = newFromStatus;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.ACTIVITY_TRANSITION__FROM_STATUS, oldFromStatus, fromStatus));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getToStatus() {
		return toStatus;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setToStatus(String newToStatus) {
		String oldToStatus = toStatus;
		toStatus = newToStatus;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.ACTIVITY_TRANSITION__TO_STATUS, oldToStatus, toStatus));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Activity getActivity() {
		if (activity != null && activity.eIsProxy()) {
			InternalEObject oldActivity = (InternalEObject)activity;
			activity = (Activity)eResolveProxy(oldActivity);
			if (activity != oldActivity) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CorePackage.ACTIVITY_TRANSITION__ACTIVITY, oldActivity, activity));
			}
		}
		return activity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Activity basicGetActivity() {
		return activity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActivity(Activity newActivity) {
		Activity oldActivity = activity;
		activity = newActivity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.ACTIVITY_TRANSITION__ACTIVITY, oldActivity, activity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Actor> getActor() {
		if (actor == null) {
			actor = new EObjectResolvingEList<Actor>(Actor.class, this, CorePackage.ACTIVITY_TRANSITION__ACTOR);
		}
		return actor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CorePackage.ACTIVITY_TRANSITION__DESCRIPTION:
				return getDescription();
			case CorePackage.ACTIVITY_TRANSITION__DATE:
				return getDate();
			case CorePackage.ACTIVITY_TRANSITION__FROM_STATUS:
				return getFromStatus();
			case CorePackage.ACTIVITY_TRANSITION__TO_STATUS:
				return getToStatus();
			case CorePackage.ACTIVITY_TRANSITION__ACTIVITY:
				if (resolve) return getActivity();
				return basicGetActivity();
			case CorePackage.ACTIVITY_TRANSITION__ACTOR:
				return getActor();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CorePackage.ACTIVITY_TRANSITION__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case CorePackage.ACTIVITY_TRANSITION__DATE:
				setDate((Long)newValue);
				return;
			case CorePackage.ACTIVITY_TRANSITION__FROM_STATUS:
				setFromStatus((String)newValue);
				return;
			case CorePackage.ACTIVITY_TRANSITION__TO_STATUS:
				setToStatus((String)newValue);
				return;
			case CorePackage.ACTIVITY_TRANSITION__ACTIVITY:
				setActivity((Activity)newValue);
				return;
			case CorePackage.ACTIVITY_TRANSITION__ACTOR:
				getActor().clear();
				getActor().addAll((Collection<? extends Actor>)newValue);
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
			case CorePackage.ACTIVITY_TRANSITION__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case CorePackage.ACTIVITY_TRANSITION__DATE:
				setDate(DATE_EDEFAULT);
				return;
			case CorePackage.ACTIVITY_TRANSITION__FROM_STATUS:
				setFromStatus(FROM_STATUS_EDEFAULT);
				return;
			case CorePackage.ACTIVITY_TRANSITION__TO_STATUS:
				setToStatus(TO_STATUS_EDEFAULT);
				return;
			case CorePackage.ACTIVITY_TRANSITION__ACTIVITY:
				setActivity((Activity)null);
				return;
			case CorePackage.ACTIVITY_TRANSITION__ACTOR:
				getActor().clear();
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
			case CorePackage.ACTIVITY_TRANSITION__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case CorePackage.ACTIVITY_TRANSITION__DATE:
				return date != DATE_EDEFAULT;
			case CorePackage.ACTIVITY_TRANSITION__FROM_STATUS:
				return FROM_STATUS_EDEFAULT == null ? fromStatus != null : !FROM_STATUS_EDEFAULT.equals(fromStatus);
			case CorePackage.ACTIVITY_TRANSITION__TO_STATUS:
				return TO_STATUS_EDEFAULT == null ? toStatus != null : !TO_STATUS_EDEFAULT.equals(toStatus);
			case CorePackage.ACTIVITY_TRANSITION__ACTIVITY:
				return activity != null;
			case CorePackage.ACTIVITY_TRANSITION__ACTOR:
				return actor != null && !actor.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == HasDescription.class) {
			switch (derivedFeatureID) {
				case CorePackage.ACTIVITY_TRANSITION__DESCRIPTION: return CorePackage.HAS_DESCRIPTION__DESCRIPTION;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == HasDescription.class) {
			switch (baseFeatureID) {
				case CorePackage.HAS_DESCRIPTION__DESCRIPTION: return CorePackage.ACTIVITY_TRANSITION__DESCRIPTION;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(" (description: ");
		result.append(description);
		result.append(", date: ");
		result.append(date);
		result.append(", fromStatus: ");
		result.append(fromStatus);
		result.append(", toStatus: ");
		result.append(toStatus);
		result.append(')');
		return result.toString();
	}

} //ActivityTransitionImpl

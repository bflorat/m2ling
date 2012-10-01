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
import org.m2ling.domain.core.Component;
import org.m2ling.domain.core.CorePackage;
import org.m2ling.domain.core.Link;
import org.m2ling.domain.core.LinkType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Link</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.m2ling.domain.core.impl.LinkImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.LinkImpl#getSources <em>Sources</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.LinkImpl#getDestinations <em>Destinations</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.LinkImpl#getTimeoutMillis <em>Timeout Millis</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LinkImpl extends ArchitectureItemImpl implements Link {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (C) 2012 Bertrand Florat";

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected LinkType type;

	/**
	 * The cached value of the '{@link #getSources() <em>Sources</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSources()
	 * @generated
	 * @ordered
	 */
	protected EList<Component> sources;

	/**
	 * The cached value of the '{@link #getDestinations() <em>Destinations</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDestinations()
	 * @generated
	 * @ordered
	 */
	protected EList<Component> destinations;

	/**
	 * The default value of the '{@link #getTimeoutMillis() <em>Timeout Millis</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeoutMillis()
	 * @generated
	 * @ordered
	 */
	protected static final long TIMEOUT_MILLIS_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getTimeoutMillis() <em>Timeout Millis</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeoutMillis()
	 * @generated
	 * @ordered
	 */
	protected long timeoutMillis = TIMEOUT_MILLIS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LinkImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CorePackage.Literals.LINK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LinkType getType() {
		if (type != null && type.eIsProxy()) {
			InternalEObject oldType = (InternalEObject)type;
			type = (LinkType)eResolveProxy(oldType);
			if (type != oldType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CorePackage.LINK__TYPE, oldType, type));
			}
		}
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LinkType basicGetType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(LinkType newType) {
		LinkType oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.LINK__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Component> getSources() {
		if (sources == null) {
			sources = new EObjectResolvingEList<Component>(Component.class, this, CorePackage.LINK__SOURCES);
		}
		return sources;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Component> getDestinations() {
		if (destinations == null) {
			destinations = new EObjectResolvingEList<Component>(Component.class, this, CorePackage.LINK__DESTINATIONS);
		}
		return destinations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getTimeoutMillis() {
		return timeoutMillis;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimeoutMillis(long newTimeoutMillis) {
		long oldTimeoutMillis = timeoutMillis;
		timeoutMillis = newTimeoutMillis;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.LINK__TIMEOUT_MILLIS, oldTimeoutMillis, timeoutMillis));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CorePackage.LINK__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case CorePackage.LINK__SOURCES:
				return getSources();
			case CorePackage.LINK__DESTINATIONS:
				return getDestinations();
			case CorePackage.LINK__TIMEOUT_MILLIS:
				return getTimeoutMillis();
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
			case CorePackage.LINK__TYPE:
				setType((LinkType)newValue);
				return;
			case CorePackage.LINK__SOURCES:
				getSources().clear();
				getSources().addAll((Collection<? extends Component>)newValue);
				return;
			case CorePackage.LINK__DESTINATIONS:
				getDestinations().clear();
				getDestinations().addAll((Collection<? extends Component>)newValue);
				return;
			case CorePackage.LINK__TIMEOUT_MILLIS:
				setTimeoutMillis((Long)newValue);
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
			case CorePackage.LINK__TYPE:
				setType((LinkType)null);
				return;
			case CorePackage.LINK__SOURCES:
				getSources().clear();
				return;
			case CorePackage.LINK__DESTINATIONS:
				getDestinations().clear();
				return;
			case CorePackage.LINK__TIMEOUT_MILLIS:
				setTimeoutMillis(TIMEOUT_MILLIS_EDEFAULT);
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
			case CorePackage.LINK__TYPE:
				return type != null;
			case CorePackage.LINK__SOURCES:
				return sources != null && !sources.isEmpty();
			case CorePackage.LINK__DESTINATIONS:
				return destinations != null && !destinations.isEmpty();
			case CorePackage.LINK__TIMEOUT_MILLIS:
				return timeoutMillis != TIMEOUT_MILLIS_EDEFAULT;
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
		result.append(" (timeoutMillis: ");
		result.append(timeoutMillis);
		result.append(')');
		return result.toString();
	}

} //LinkImpl

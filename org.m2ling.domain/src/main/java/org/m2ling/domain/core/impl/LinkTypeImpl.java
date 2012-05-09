/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.domain.core.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.m2ling.domain.core.ConceptItem;
import org.m2ling.domain.core.CorePackage;
import org.m2ling.domain.core.LinkType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Link Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.m2ling.domain.core.impl.LinkTypeImpl#getSourceType <em>Source Type</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.LinkTypeImpl#getDestinationType <em>Destination Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LinkTypeImpl extends ConceptItemImpl implements LinkType {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (C) 2012 Bertrand Florat";

	/**
	 * The cached value of the '{@link #getSourceType() <em>Source Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceType()
	 * @generated
	 * @ordered
	 */
	protected ConceptItem sourceType;

	/**
	 * The cached value of the '{@link #getDestinationType() <em>Destination Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDestinationType()
	 * @generated
	 * @ordered
	 */
	protected ConceptItem destinationType;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LinkTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CorePackage.Literals.LINK_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConceptItem getSourceType() {
		if (sourceType != null && sourceType.eIsProxy()) {
			InternalEObject oldSourceType = (InternalEObject)sourceType;
			sourceType = (ConceptItem)eResolveProxy(oldSourceType);
			if (sourceType != oldSourceType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CorePackage.LINK_TYPE__SOURCE_TYPE, oldSourceType, sourceType));
			}
		}
		return sourceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConceptItem basicGetSourceType() {
		return sourceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceType(ConceptItem newSourceType) {
		ConceptItem oldSourceType = sourceType;
		sourceType = newSourceType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.LINK_TYPE__SOURCE_TYPE, oldSourceType, sourceType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConceptItem getDestinationType() {
		if (destinationType != null && destinationType.eIsProxy()) {
			InternalEObject oldDestinationType = (InternalEObject)destinationType;
			destinationType = (ConceptItem)eResolveProxy(oldDestinationType);
			if (destinationType != oldDestinationType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CorePackage.LINK_TYPE__DESTINATION_TYPE, oldDestinationType, destinationType));
			}
		}
		return destinationType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConceptItem basicGetDestinationType() {
		return destinationType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDestinationType(ConceptItem newDestinationType) {
		ConceptItem oldDestinationType = destinationType;
		destinationType = newDestinationType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.LINK_TYPE__DESTINATION_TYPE, oldDestinationType, destinationType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CorePackage.LINK_TYPE__SOURCE_TYPE:
				if (resolve) return getSourceType();
				return basicGetSourceType();
			case CorePackage.LINK_TYPE__DESTINATION_TYPE:
				if (resolve) return getDestinationType();
				return basicGetDestinationType();
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
			case CorePackage.LINK_TYPE__SOURCE_TYPE:
				setSourceType((ConceptItem)newValue);
				return;
			case CorePackage.LINK_TYPE__DESTINATION_TYPE:
				setDestinationType((ConceptItem)newValue);
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
			case CorePackage.LINK_TYPE__SOURCE_TYPE:
				setSourceType((ConceptItem)null);
				return;
			case CorePackage.LINK_TYPE__DESTINATION_TYPE:
				setDestinationType((ConceptItem)null);
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
			case CorePackage.LINK_TYPE__SOURCE_TYPE:
				return sourceType != null;
			case CorePackage.LINK_TYPE__DESTINATION_TYPE:
				return destinationType != null;
		}
		return super.eIsSet(featureID);
	}

} //LinkTypeImpl

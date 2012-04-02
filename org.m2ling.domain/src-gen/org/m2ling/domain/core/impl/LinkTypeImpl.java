/**
 * Copyright (C) Bertrand Florat
 */
package org.m2ling.domain.core.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.m2ling.domain.core.ConceptItem;
import org.m2ling.domain.core.CorePackage;
import org.m2ling.domain.core.HasNameAndID;
import org.m2ling.domain.core.LinkType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Link Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.m2ling.domain.core.impl.LinkTypeImpl#getID <em>ID</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.LinkTypeImpl#getName <em>Name</em>}</li>
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
	public static final String copyright = "Copyright (C) Bertrand Florat";

	/**
	 * The default value of the '{@link #getID() <em>ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getID()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getID() <em>ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getID()
	 * @generated
	 * @ordered
	 */
	protected String iD = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * This is true if the Name attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean nameESet;

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
	public String getID() {
		return iD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		boolean oldNameESet = nameESet;
		nameESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.LINK_TYPE__NAME, oldName, name, !oldNameESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetName() {
		String oldName = name;
		boolean oldNameESet = nameESet;
		name = NAME_EDEFAULT;
		nameESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, CorePackage.LINK_TYPE__NAME, oldName, NAME_EDEFAULT, oldNameESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetName() {
		return nameESet;
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
			case CorePackage.LINK_TYPE__ID:
				return getID();
			case CorePackage.LINK_TYPE__NAME:
				return getName();
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
			case CorePackage.LINK_TYPE__NAME:
				setName((String)newValue);
				return;
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
			case CorePackage.LINK_TYPE__NAME:
				unsetName();
				return;
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
			case CorePackage.LINK_TYPE__ID:
				return ID_EDEFAULT == null ? iD != null : !ID_EDEFAULT.equals(iD);
			case CorePackage.LINK_TYPE__NAME:
				return isSetName();
			case CorePackage.LINK_TYPE__SOURCE_TYPE:
				return sourceType != null;
			case CorePackage.LINK_TYPE__DESTINATION_TYPE:
				return destinationType != null;
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
		if (baseClass == HasNameAndID.class) {
			switch (derivedFeatureID) {
				case CorePackage.LINK_TYPE__ID: return CorePackage.HAS_NAME_AND_ID__ID;
				case CorePackage.LINK_TYPE__NAME: return CorePackage.HAS_NAME_AND_ID__NAME;
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
		if (baseClass == HasNameAndID.class) {
			switch (baseFeatureID) {
				case CorePackage.HAS_NAME_AND_ID__ID: return CorePackage.LINK_TYPE__ID;
				case CorePackage.HAS_NAME_AND_ID__NAME: return CorePackage.LINK_TYPE__NAME;
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
		result.append(" (iD: ");
		result.append(iD);
		result.append(", name: ");
		if (nameESet) result.append(name); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //LinkTypeImpl

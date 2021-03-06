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
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.m2ling.domain.core.CorePackage;
import org.m2ling.domain.core.CustomProperty;
import org.m2ling.domain.core.HasConstraints;
import org.m2ling.domain.core.HasCustomProperties;
import org.m2ling.domain.core.HasDescription;
import org.m2ling.domain.core.HasNameAndID;
import org.m2ling.domain.core.HasStatus;
import org.m2ling.domain.core.HasTags;
import org.m2ling.domain.core.Reference;
import org.m2ling.domain.core.ReferenceType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.m2ling.domain.core.impl.ReferenceImpl#getCustomProperties <em>Custom Properties</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.ReferenceImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.ReferenceImpl#getStatus <em>Status</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.ReferenceImpl#getTags <em>Tags</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.ReferenceImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.ReferenceImpl#getTargets <em>Targets</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReferenceImpl extends HasCommentImpl implements Reference {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (C) 2012 Bertrand Florat";

	/**
	 * The cached value of the '{@link #getCustomProperties() <em>Custom Properties</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCustomProperties()
	 * @generated
	 * @ordered
	 */
	protected CustomProperty customProperties;

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
	 * The default value of the '{@link #getStatus() <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatus()
	 * @generated
	 * @ordered
	 */
	protected static final String STATUS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStatus() <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatus()
	 * @generated
	 * @ordered
	 */
	protected String status = STATUS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTags() <em>Tags</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTags()
	 * @generated
	 * @ordered
	 */
	protected EList<String> tags;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final ReferenceType TYPE_EDEFAULT = ReferenceType.CONTAINS;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected ReferenceType type = TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTargets() <em>Targets</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargets()
	 * @generated
	 * @ordered
	 */
	protected EList<HasNameAndID> targets;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CorePackage.Literals.REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CustomProperty getCustomProperties() {
		if (customProperties != null && customProperties.eIsProxy()) {
			InternalEObject oldCustomProperties = (InternalEObject)customProperties;
			customProperties = (CustomProperty)eResolveProxy(oldCustomProperties);
			if (customProperties != oldCustomProperties) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CorePackage.REFERENCE__CUSTOM_PROPERTIES, oldCustomProperties, customProperties));
			}
		}
		return customProperties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CustomProperty basicGetCustomProperties() {
		return customProperties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCustomProperties(CustomProperty newCustomProperties) {
		CustomProperty oldCustomProperties = customProperties;
		customProperties = newCustomProperties;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.REFERENCE__CUSTOM_PROPERTIES, oldCustomProperties, customProperties));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.REFERENCE__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStatus(String newStatus) {
		String oldStatus = status;
		status = newStatus;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.REFERENCE__STATUS, oldStatus, status));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getTags() {
		if (tags == null) {
			tags = new EDataTypeUniqueEList<String>(String.class, this, CorePackage.REFERENCE__TAGS);
		}
		return tags;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReferenceType getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(ReferenceType newType) {
		ReferenceType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.REFERENCE__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<HasNameAndID> getTargets() {
		if (targets == null) {
			targets = new EObjectResolvingEList<HasNameAndID>(HasNameAndID.class, this, CorePackage.REFERENCE__TARGETS);
		}
		return targets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CorePackage.REFERENCE__CUSTOM_PROPERTIES:
				if (resolve) return getCustomProperties();
				return basicGetCustomProperties();
			case CorePackage.REFERENCE__DESCRIPTION:
				return getDescription();
			case CorePackage.REFERENCE__STATUS:
				return getStatus();
			case CorePackage.REFERENCE__TAGS:
				return getTags();
			case CorePackage.REFERENCE__TYPE:
				return getType();
			case CorePackage.REFERENCE__TARGETS:
				return getTargets();
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
			case CorePackage.REFERENCE__CUSTOM_PROPERTIES:
				setCustomProperties((CustomProperty)newValue);
				return;
			case CorePackage.REFERENCE__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case CorePackage.REFERENCE__STATUS:
				setStatus((String)newValue);
				return;
			case CorePackage.REFERENCE__TAGS:
				getTags().clear();
				getTags().addAll((Collection<? extends String>)newValue);
				return;
			case CorePackage.REFERENCE__TYPE:
				setType((ReferenceType)newValue);
				return;
			case CorePackage.REFERENCE__TARGETS:
				getTargets().clear();
				getTargets().addAll((Collection<? extends HasNameAndID>)newValue);
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
			case CorePackage.REFERENCE__CUSTOM_PROPERTIES:
				setCustomProperties((CustomProperty)null);
				return;
			case CorePackage.REFERENCE__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case CorePackage.REFERENCE__STATUS:
				setStatus(STATUS_EDEFAULT);
				return;
			case CorePackage.REFERENCE__TAGS:
				getTags().clear();
				return;
			case CorePackage.REFERENCE__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case CorePackage.REFERENCE__TARGETS:
				getTargets().clear();
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
			case CorePackage.REFERENCE__CUSTOM_PROPERTIES:
				return customProperties != null;
			case CorePackage.REFERENCE__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case CorePackage.REFERENCE__STATUS:
				return STATUS_EDEFAULT == null ? status != null : !STATUS_EDEFAULT.equals(status);
			case CorePackage.REFERENCE__TAGS:
				return tags != null && !tags.isEmpty();
			case CorePackage.REFERENCE__TYPE:
				return type != TYPE_EDEFAULT;
			case CorePackage.REFERENCE__TARGETS:
				return targets != null && !targets.isEmpty();
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
		if (baseClass == HasConstraints.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == HasCustomProperties.class) {
			switch (derivedFeatureID) {
				case CorePackage.REFERENCE__CUSTOM_PROPERTIES: return CorePackage.HAS_CUSTOM_PROPERTIES__CUSTOM_PROPERTIES;
				default: return -1;
			}
		}
		if (baseClass == HasDescription.class) {
			switch (derivedFeatureID) {
				case CorePackage.REFERENCE__DESCRIPTION: return CorePackage.HAS_DESCRIPTION__DESCRIPTION;
				default: return -1;
			}
		}
		if (baseClass == HasStatus.class) {
			switch (derivedFeatureID) {
				case CorePackage.REFERENCE__STATUS: return CorePackage.HAS_STATUS__STATUS;
				default: return -1;
			}
		}
		if (baseClass == HasTags.class) {
			switch (derivedFeatureID) {
				case CorePackage.REFERENCE__TAGS: return CorePackage.HAS_TAGS__TAGS;
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
		if (baseClass == HasConstraints.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == HasCustomProperties.class) {
			switch (baseFeatureID) {
				case CorePackage.HAS_CUSTOM_PROPERTIES__CUSTOM_PROPERTIES: return CorePackage.REFERENCE__CUSTOM_PROPERTIES;
				default: return -1;
			}
		}
		if (baseClass == HasDescription.class) {
			switch (baseFeatureID) {
				case CorePackage.HAS_DESCRIPTION__DESCRIPTION: return CorePackage.REFERENCE__DESCRIPTION;
				default: return -1;
			}
		}
		if (baseClass == HasStatus.class) {
			switch (baseFeatureID) {
				case CorePackage.HAS_STATUS__STATUS: return CorePackage.REFERENCE__STATUS;
				default: return -1;
			}
		}
		if (baseClass == HasTags.class) {
			switch (baseFeatureID) {
				case CorePackage.HAS_TAGS__TAGS: return CorePackage.REFERENCE__TAGS;
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
		result.append(", status: ");
		result.append(status);
		result.append(", tags: ");
		result.append(tags);
		result.append(", type: ");
		result.append(type);
		result.append(')');
		return result.toString();
	}

} //ReferenceImpl

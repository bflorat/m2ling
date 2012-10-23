/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.domain.core.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.m2ling.domain.core.ArchitectureItem;
import org.m2ling.domain.core.CorePackage;
import org.m2ling.domain.core.HasComment;
import org.m2ling.domain.core.HasConstraints;
import org.m2ling.domain.core.HasDescription;
import org.m2ling.domain.core.HasStatus;
import org.m2ling.domain.core.HasTags;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Architecture Item</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.m2ling.domain.core.impl.ArchitectureItemImpl#getComment <em>Comment</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.ArchitectureItemImpl#getTags <em>Tags</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.ArchitectureItemImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.ArchitectureItemImpl#getStatus <em>Status</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ArchitectureItemImpl extends HasNameAndIDImpl implements ArchitectureItem {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (C) 2012 Bertrand Florat";

	/**
	 * The default value of the '{@link #getComment() <em>Comment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComment()
	 * @generated
	 * @ordered
	 */
	protected static final String COMMENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getComment() <em>Comment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComment()
	 * @generated
	 * @ordered
	 */
	protected String comment = COMMENT_EDEFAULT;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ArchitectureItemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CorePackage.Literals.ARCHITECTURE_ITEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComment(String newComment) {
		String oldComment = comment;
		comment = newComment;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.ARCHITECTURE_ITEM__COMMENT, oldComment, comment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getTags() {
		if (tags == null) {
			tags = new EDataTypeUniqueEList<String>(String.class, this, CorePackage.ARCHITECTURE_ITEM__TAGS);
		}
		return tags;
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
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.ARCHITECTURE_ITEM__DESCRIPTION, oldDescription, description));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.ARCHITECTURE_ITEM__STATUS, oldStatus, status));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CorePackage.ARCHITECTURE_ITEM__COMMENT:
				return getComment();
			case CorePackage.ARCHITECTURE_ITEM__TAGS:
				return getTags();
			case CorePackage.ARCHITECTURE_ITEM__DESCRIPTION:
				return getDescription();
			case CorePackage.ARCHITECTURE_ITEM__STATUS:
				return getStatus();
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
			case CorePackage.ARCHITECTURE_ITEM__COMMENT:
				setComment((String)newValue);
				return;
			case CorePackage.ARCHITECTURE_ITEM__TAGS:
				getTags().clear();
				getTags().addAll((Collection<? extends String>)newValue);
				return;
			case CorePackage.ARCHITECTURE_ITEM__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case CorePackage.ARCHITECTURE_ITEM__STATUS:
				setStatus((String)newValue);
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
			case CorePackage.ARCHITECTURE_ITEM__COMMENT:
				setComment(COMMENT_EDEFAULT);
				return;
			case CorePackage.ARCHITECTURE_ITEM__TAGS:
				getTags().clear();
				return;
			case CorePackage.ARCHITECTURE_ITEM__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case CorePackage.ARCHITECTURE_ITEM__STATUS:
				setStatus(STATUS_EDEFAULT);
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
			case CorePackage.ARCHITECTURE_ITEM__COMMENT:
				return COMMENT_EDEFAULT == null ? comment != null : !COMMENT_EDEFAULT.equals(comment);
			case CorePackage.ARCHITECTURE_ITEM__TAGS:
				return tags != null && !tags.isEmpty();
			case CorePackage.ARCHITECTURE_ITEM__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case CorePackage.ARCHITECTURE_ITEM__STATUS:
				return STATUS_EDEFAULT == null ? status != null : !STATUS_EDEFAULT.equals(status);
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
		if (baseClass == HasComment.class) {
			switch (derivedFeatureID) {
				case CorePackage.ARCHITECTURE_ITEM__COMMENT: return CorePackage.HAS_COMMENT__COMMENT;
				default: return -1;
			}
		}
		if (baseClass == HasTags.class) {
			switch (derivedFeatureID) {
				case CorePackage.ARCHITECTURE_ITEM__TAGS: return CorePackage.HAS_TAGS__TAGS;
				default: return -1;
			}
		}
		if (baseClass == HasConstraints.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == HasDescription.class) {
			switch (derivedFeatureID) {
				case CorePackage.ARCHITECTURE_ITEM__DESCRIPTION: return CorePackage.HAS_DESCRIPTION__DESCRIPTION;
				default: return -1;
			}
		}
		if (baseClass == HasStatus.class) {
			switch (derivedFeatureID) {
				case CorePackage.ARCHITECTURE_ITEM__STATUS: return CorePackage.HAS_STATUS__STATUS;
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
		if (baseClass == HasComment.class) {
			switch (baseFeatureID) {
				case CorePackage.HAS_COMMENT__COMMENT: return CorePackage.ARCHITECTURE_ITEM__COMMENT;
				default: return -1;
			}
		}
		if (baseClass == HasTags.class) {
			switch (baseFeatureID) {
				case CorePackage.HAS_TAGS__TAGS: return CorePackage.ARCHITECTURE_ITEM__TAGS;
				default: return -1;
			}
		}
		if (baseClass == HasConstraints.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == HasDescription.class) {
			switch (baseFeatureID) {
				case CorePackage.HAS_DESCRIPTION__DESCRIPTION: return CorePackage.ARCHITECTURE_ITEM__DESCRIPTION;
				default: return -1;
			}
		}
		if (baseClass == HasStatus.class) {
			switch (baseFeatureID) {
				case CorePackage.HAS_STATUS__STATUS: return CorePackage.ARCHITECTURE_ITEM__STATUS;
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
		result.append(" (comment: ");
		result.append(comment);
		result.append(", tags: ");
		result.append(tags);
		result.append(", description: ");
		result.append(description);
		result.append(", status: ");
		result.append(status);
		result.append(')');
		return result.toString();
	}

} //ArchitectureItemImpl

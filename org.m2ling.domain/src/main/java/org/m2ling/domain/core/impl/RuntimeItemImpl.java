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
import org.m2ling.domain.core.CorePackage;
import org.m2ling.domain.core.HasComment;
import org.m2ling.domain.core.HasConstraints;
import org.m2ling.domain.core.HasParameterValues;
import org.m2ling.domain.core.HasTags;
import org.m2ling.domain.core.RuntimeItem;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Runtime Item</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.m2ling.domain.core.impl.RuntimeItemImpl#getComment <em>Comment</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.RuntimeItemImpl#getTags <em>Tags</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.RuntimeItemImpl#getLabel <em>Label</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class RuntimeItemImpl extends HasNameAndIDImpl implements RuntimeItem {
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
	 * The default value of the '{@link #getLabel() <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected static final String LABEL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLabel() <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected String label = LABEL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RuntimeItemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CorePackage.Literals.RUNTIME_ITEM;
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
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.RUNTIME_ITEM__COMMENT, oldComment, comment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getTags() {
		if (tags == null) {
			tags = new EDataTypeUniqueEList<String>(String.class, this, CorePackage.RUNTIME_ITEM__TAGS);
		}
		return tags;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLabel(String newLabel) {
		String oldLabel = label;
		label = newLabel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.RUNTIME_ITEM__LABEL, oldLabel, label));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CorePackage.RUNTIME_ITEM__COMMENT:
				return getComment();
			case CorePackage.RUNTIME_ITEM__TAGS:
				return getTags();
			case CorePackage.RUNTIME_ITEM__LABEL:
				return getLabel();
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
			case CorePackage.RUNTIME_ITEM__COMMENT:
				setComment((String)newValue);
				return;
			case CorePackage.RUNTIME_ITEM__TAGS:
				getTags().clear();
				getTags().addAll((Collection<? extends String>)newValue);
				return;
			case CorePackage.RUNTIME_ITEM__LABEL:
				setLabel((String)newValue);
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
			case CorePackage.RUNTIME_ITEM__COMMENT:
				setComment(COMMENT_EDEFAULT);
				return;
			case CorePackage.RUNTIME_ITEM__TAGS:
				getTags().clear();
				return;
			case CorePackage.RUNTIME_ITEM__LABEL:
				setLabel(LABEL_EDEFAULT);
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
			case CorePackage.RUNTIME_ITEM__COMMENT:
				return COMMENT_EDEFAULT == null ? comment != null : !COMMENT_EDEFAULT.equals(comment);
			case CorePackage.RUNTIME_ITEM__TAGS:
				return tags != null && !tags.isEmpty();
			case CorePackage.RUNTIME_ITEM__LABEL:
				return LABEL_EDEFAULT == null ? label != null : !LABEL_EDEFAULT.equals(label);
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
				case CorePackage.RUNTIME_ITEM__COMMENT: return CorePackage.HAS_COMMENT__COMMENT;
				default: return -1;
			}
		}
		if (baseClass == HasTags.class) {
			switch (derivedFeatureID) {
				case CorePackage.RUNTIME_ITEM__TAGS: return CorePackage.HAS_TAGS__TAGS;
				default: return -1;
			}
		}
		if (baseClass == HasParameterValues.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == HasConstraints.class) {
			switch (derivedFeatureID) {
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
				case CorePackage.HAS_COMMENT__COMMENT: return CorePackage.RUNTIME_ITEM__COMMENT;
				default: return -1;
			}
		}
		if (baseClass == HasTags.class) {
			switch (baseFeatureID) {
				case CorePackage.HAS_TAGS__TAGS: return CorePackage.RUNTIME_ITEM__TAGS;
				default: return -1;
			}
		}
		if (baseClass == HasParameterValues.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == HasConstraints.class) {
			switch (baseFeatureID) {
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
		result.append(", label: ");
		result.append(label);
		result.append(')');
		return result.toString();
	}

} //RuntimeItemImpl

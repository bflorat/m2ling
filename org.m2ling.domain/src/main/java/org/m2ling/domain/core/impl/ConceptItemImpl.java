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
import org.m2ling.domain.core.ConceptItem;
import org.m2ling.domain.core.CorePackage;
import org.m2ling.domain.core.CustomProperty;
import org.m2ling.domain.core.HasComment;
import org.m2ling.domain.core.HasConstraints;
import org.m2ling.domain.core.HasCustomProperties;
import org.m2ling.domain.core.HasDescription;
import org.m2ling.domain.core.HasParameterDefinitions;
import org.m2ling.domain.core.HasTags;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Concept Item</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.m2ling.domain.core.impl.ConceptItemImpl#getCustomProperties <em>Custom Properties</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.ConceptItemImpl#getComment <em>Comment</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.ConceptItemImpl#getTags <em>Tags</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.ConceptItemImpl#getDescription <em>Description</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ConceptItemImpl extends HasNameAndIDImpl implements ConceptItem {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected ConceptItemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CorePackage.Literals.CONCEPT_ITEM;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CorePackage.CONCEPT_ITEM__CUSTOM_PROPERTIES, oldCustomProperties, customProperties));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.CONCEPT_ITEM__CUSTOM_PROPERTIES, oldCustomProperties, customProperties));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.CONCEPT_ITEM__COMMENT, oldComment, comment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getTags() {
		if (tags == null) {
			tags = new EDataTypeUniqueEList<String>(String.class, this, CorePackage.CONCEPT_ITEM__TAGS);
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
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.CONCEPT_ITEM__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CorePackage.CONCEPT_ITEM__CUSTOM_PROPERTIES:
				if (resolve) return getCustomProperties();
				return basicGetCustomProperties();
			case CorePackage.CONCEPT_ITEM__COMMENT:
				return getComment();
			case CorePackage.CONCEPT_ITEM__TAGS:
				return getTags();
			case CorePackage.CONCEPT_ITEM__DESCRIPTION:
				return getDescription();
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
			case CorePackage.CONCEPT_ITEM__CUSTOM_PROPERTIES:
				setCustomProperties((CustomProperty)newValue);
				return;
			case CorePackage.CONCEPT_ITEM__COMMENT:
				setComment((String)newValue);
				return;
			case CorePackage.CONCEPT_ITEM__TAGS:
				getTags().clear();
				getTags().addAll((Collection<? extends String>)newValue);
				return;
			case CorePackage.CONCEPT_ITEM__DESCRIPTION:
				setDescription((String)newValue);
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
			case CorePackage.CONCEPT_ITEM__CUSTOM_PROPERTIES:
				setCustomProperties((CustomProperty)null);
				return;
			case CorePackage.CONCEPT_ITEM__COMMENT:
				setComment(COMMENT_EDEFAULT);
				return;
			case CorePackage.CONCEPT_ITEM__TAGS:
				getTags().clear();
				return;
			case CorePackage.CONCEPT_ITEM__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
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
			case CorePackage.CONCEPT_ITEM__CUSTOM_PROPERTIES:
				return customProperties != null;
			case CorePackage.CONCEPT_ITEM__COMMENT:
				return COMMENT_EDEFAULT == null ? comment != null : !COMMENT_EDEFAULT.equals(comment);
			case CorePackage.CONCEPT_ITEM__TAGS:
				return tags != null && !tags.isEmpty();
			case CorePackage.CONCEPT_ITEM__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
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
		if (baseClass == HasCustomProperties.class) {
			switch (derivedFeatureID) {
				case CorePackage.CONCEPT_ITEM__CUSTOM_PROPERTIES: return CorePackage.HAS_CUSTOM_PROPERTIES__CUSTOM_PROPERTIES;
				default: return -1;
			}
		}
		if (baseClass == HasComment.class) {
			switch (derivedFeatureID) {
				case CorePackage.CONCEPT_ITEM__COMMENT: return CorePackage.HAS_COMMENT__COMMENT;
				default: return -1;
			}
		}
		if (baseClass == HasTags.class) {
			switch (derivedFeatureID) {
				case CorePackage.CONCEPT_ITEM__TAGS: return CorePackage.HAS_TAGS__TAGS;
				default: return -1;
			}
		}
		if (baseClass == HasParameterDefinitions.class) {
			switch (derivedFeatureID) {
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
				case CorePackage.CONCEPT_ITEM__DESCRIPTION: return CorePackage.HAS_DESCRIPTION__DESCRIPTION;
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
		if (baseClass == HasCustomProperties.class) {
			switch (baseFeatureID) {
				case CorePackage.HAS_CUSTOM_PROPERTIES__CUSTOM_PROPERTIES: return CorePackage.CONCEPT_ITEM__CUSTOM_PROPERTIES;
				default: return -1;
			}
		}
		if (baseClass == HasComment.class) {
			switch (baseFeatureID) {
				case CorePackage.HAS_COMMENT__COMMENT: return CorePackage.CONCEPT_ITEM__COMMENT;
				default: return -1;
			}
		}
		if (baseClass == HasTags.class) {
			switch (baseFeatureID) {
				case CorePackage.HAS_TAGS__TAGS: return CorePackage.CONCEPT_ITEM__TAGS;
				default: return -1;
			}
		}
		if (baseClass == HasParameterDefinitions.class) {
			switch (baseFeatureID) {
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
				case CorePackage.HAS_DESCRIPTION__DESCRIPTION: return CorePackage.CONCEPT_ITEM__DESCRIPTION;
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
		result.append(')');
		return result.toString();
	}

} //ConceptItemImpl

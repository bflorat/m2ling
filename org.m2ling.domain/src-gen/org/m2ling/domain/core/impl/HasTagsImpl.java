/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.m2ling.domain.core.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.m2ling.domain.core.CorePackage;
import org.m2ling.domain.core.HasTags;
import org.m2ling.domain.core.Tag;
import org.m2ling.domain.core.TagGroup;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Has Tags</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.m2ling.domain.core.impl.HasTagsImpl#getTags <em>Tags</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.HasTagsImpl#getTagGroups <em>Tag Groups</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class HasTagsImpl extends EObjectImpl implements HasTags {
	/**
	 * The cached value of the '{@link #getTags() <em>Tags</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTags()
	 * @generated
	 * @ordered
	 */
	protected Tag tags;

	/**
	 * The cached value of the '{@link #getTagGroups() <em>Tag Groups</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTagGroups()
	 * @generated
	 * @ordered
	 */
	protected EList<TagGroup> tagGroups;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HasTagsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CorePackage.Literals.HAS_TAGS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tag getTags() {
		if (tags != null && tags.eIsProxy()) {
			InternalEObject oldTags = (InternalEObject)tags;
			tags = (Tag)eResolveProxy(oldTags);
			if (tags != oldTags) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CorePackage.HAS_TAGS__TAGS, oldTags, tags));
			}
		}
		return tags;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tag basicGetTags() {
		return tags;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTags(Tag newTags) {
		Tag oldTags = tags;
		tags = newTags;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.HAS_TAGS__TAGS, oldTags, tags));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TagGroup> getTagGroups() {
		if (tagGroups == null) {
			tagGroups = new EObjectResolvingEList<TagGroup>(TagGroup.class, this, CorePackage.HAS_TAGS__TAG_GROUPS);
		}
		return tagGroups;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CorePackage.HAS_TAGS__TAGS:
				if (resolve) return getTags();
				return basicGetTags();
			case CorePackage.HAS_TAGS__TAG_GROUPS:
				return getTagGroups();
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
			case CorePackage.HAS_TAGS__TAGS:
				setTags((Tag)newValue);
				return;
			case CorePackage.HAS_TAGS__TAG_GROUPS:
				getTagGroups().clear();
				getTagGroups().addAll((Collection<? extends TagGroup>)newValue);
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
			case CorePackage.HAS_TAGS__TAGS:
				setTags((Tag)null);
				return;
			case CorePackage.HAS_TAGS__TAG_GROUPS:
				getTagGroups().clear();
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
			case CorePackage.HAS_TAGS__TAGS:
				return tags != null;
			case CorePackage.HAS_TAGS__TAG_GROUPS:
				return tagGroups != null && !tagGroups.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //HasTagsImpl

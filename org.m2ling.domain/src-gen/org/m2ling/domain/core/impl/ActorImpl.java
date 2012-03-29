/**
 * Copyright (C) Bertrand Florat
 */
package org.m2ling.domain.core.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.m2ling.domain.core.Actor;
import org.m2ling.domain.core.CorePackage;
import org.m2ling.domain.core.HasTags;
import org.m2ling.domain.core.OrganisationalUnit;
import org.m2ling.domain.core.Stakeholder;
import org.m2ling.domain.core.Tag;
import org.m2ling.domain.core.TagGroup;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Actor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.m2ling.domain.core.impl.ActorImpl#getTags <em>Tags</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.ActorImpl#getTagGroups <em>Tag Groups</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.ActorImpl#getStakeholders <em>Stakeholders</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.ActorImpl#getUnit <em>Unit</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.ActorImpl#getUsername <em>Username</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.ActorImpl#isAdmin <em>Admin</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.ActorImpl#getPwdHash <em>Pwd Hash</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ActorImpl extends HasCustomPropertiesImpl implements Actor {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (C) Bertrand Florat";

	/**
	 * The cached value of the '{@link #getTags() <em>Tags</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTags()
	 * @generated
	 * @ordered
	 */
	protected EList<Tag> tags;

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
	 * The cached value of the '{@link #getStakeholders() <em>Stakeholders</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStakeholders()
	 * @generated
	 * @ordered
	 */
	protected EList<Stakeholder> stakeholders;

	/**
	 * The cached value of the '{@link #getUnit() <em>Unit</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnit()
	 * @generated
	 * @ordered
	 */
	protected EList<OrganisationalUnit> unit;

	/**
	 * The default value of the '{@link #getUsername() <em>Username</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsername()
	 * @generated
	 * @ordered
	 */
	protected static final String USERNAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUsername() <em>Username</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsername()
	 * @generated
	 * @ordered
	 */
	protected String username = USERNAME_EDEFAULT;

	/**
	 * The default value of the '{@link #isAdmin() <em>Admin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAdmin()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ADMIN_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAdmin() <em>Admin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAdmin()
	 * @generated
	 * @ordered
	 */
	protected boolean admin = ADMIN_EDEFAULT;

	/**
	 * The default value of the '{@link #getPwdHash() <em>Pwd Hash</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPwdHash()
	 * @generated
	 * @ordered
	 */
	protected static final String PWD_HASH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPwdHash() <em>Pwd Hash</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPwdHash()
	 * @generated
	 * @ordered
	 */
	protected String pwdHash = PWD_HASH_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ActorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CorePackage.Literals.ACTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Tag> getTags() {
		if (tags == null) {
			tags = new EObjectResolvingEList<Tag>(Tag.class, this, CorePackage.ACTOR__TAGS);
		}
		return tags;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TagGroup> getTagGroups() {
		if (tagGroups == null) {
			tagGroups = new EObjectResolvingEList<TagGroup>(TagGroup.class, this, CorePackage.ACTOR__TAG_GROUPS);
		}
		return tagGroups;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Stakeholder> getStakeholders() {
		if (stakeholders == null) {
			stakeholders = new EObjectWithInverseResolvingEList.ManyInverse<Stakeholder>(Stakeholder.class, this, CorePackage.ACTOR__STAKEHOLDERS, CorePackage.STAKEHOLDER__ACTORS);
		}
		return stakeholders;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OrganisationalUnit> getUnit() {
		if (unit == null) {
			unit = new EObjectResolvingEList<OrganisationalUnit>(OrganisationalUnit.class, this, CorePackage.ACTOR__UNIT);
		}
		return unit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUsername(String newUsername) {
		String oldUsername = username;
		username = newUsername;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.ACTOR__USERNAME, oldUsername, username));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAdmin() {
		return admin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAdmin(boolean newAdmin) {
		boolean oldAdmin = admin;
		admin = newAdmin;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.ACTOR__ADMIN, oldAdmin, admin));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPwdHash() {
		return pwdHash;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPwdHash(String newPwdHash) {
		String oldPwdHash = pwdHash;
		pwdHash = newPwdHash;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.ACTOR__PWD_HASH, oldPwdHash, pwdHash));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CorePackage.ACTOR__STAKEHOLDERS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getStakeholders()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CorePackage.ACTOR__STAKEHOLDERS:
				return ((InternalEList<?>)getStakeholders()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CorePackage.ACTOR__TAGS:
				return getTags();
			case CorePackage.ACTOR__TAG_GROUPS:
				return getTagGroups();
			case CorePackage.ACTOR__STAKEHOLDERS:
				return getStakeholders();
			case CorePackage.ACTOR__UNIT:
				return getUnit();
			case CorePackage.ACTOR__USERNAME:
				return getUsername();
			case CorePackage.ACTOR__ADMIN:
				return isAdmin();
			case CorePackage.ACTOR__PWD_HASH:
				return getPwdHash();
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
			case CorePackage.ACTOR__TAGS:
				getTags().clear();
				getTags().addAll((Collection<? extends Tag>)newValue);
				return;
			case CorePackage.ACTOR__TAG_GROUPS:
				getTagGroups().clear();
				getTagGroups().addAll((Collection<? extends TagGroup>)newValue);
				return;
			case CorePackage.ACTOR__STAKEHOLDERS:
				getStakeholders().clear();
				getStakeholders().addAll((Collection<? extends Stakeholder>)newValue);
				return;
			case CorePackage.ACTOR__UNIT:
				getUnit().clear();
				getUnit().addAll((Collection<? extends OrganisationalUnit>)newValue);
				return;
			case CorePackage.ACTOR__USERNAME:
				setUsername((String)newValue);
				return;
			case CorePackage.ACTOR__ADMIN:
				setAdmin((Boolean)newValue);
				return;
			case CorePackage.ACTOR__PWD_HASH:
				setPwdHash((String)newValue);
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
			case CorePackage.ACTOR__TAGS:
				getTags().clear();
				return;
			case CorePackage.ACTOR__TAG_GROUPS:
				getTagGroups().clear();
				return;
			case CorePackage.ACTOR__STAKEHOLDERS:
				getStakeholders().clear();
				return;
			case CorePackage.ACTOR__UNIT:
				getUnit().clear();
				return;
			case CorePackage.ACTOR__USERNAME:
				setUsername(USERNAME_EDEFAULT);
				return;
			case CorePackage.ACTOR__ADMIN:
				setAdmin(ADMIN_EDEFAULT);
				return;
			case CorePackage.ACTOR__PWD_HASH:
				setPwdHash(PWD_HASH_EDEFAULT);
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
			case CorePackage.ACTOR__TAGS:
				return tags != null && !tags.isEmpty();
			case CorePackage.ACTOR__TAG_GROUPS:
				return tagGroups != null && !tagGroups.isEmpty();
			case CorePackage.ACTOR__STAKEHOLDERS:
				return stakeholders != null && !stakeholders.isEmpty();
			case CorePackage.ACTOR__UNIT:
				return unit != null && !unit.isEmpty();
			case CorePackage.ACTOR__USERNAME:
				return USERNAME_EDEFAULT == null ? username != null : !USERNAME_EDEFAULT.equals(username);
			case CorePackage.ACTOR__ADMIN:
				return admin != ADMIN_EDEFAULT;
			case CorePackage.ACTOR__PWD_HASH:
				return PWD_HASH_EDEFAULT == null ? pwdHash != null : !PWD_HASH_EDEFAULT.equals(pwdHash);
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
		if (baseClass == HasTags.class) {
			switch (derivedFeatureID) {
				case CorePackage.ACTOR__TAGS: return CorePackage.HAS_TAGS__TAGS;
				case CorePackage.ACTOR__TAG_GROUPS: return CorePackage.HAS_TAGS__TAG_GROUPS;
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
		if (baseClass == HasTags.class) {
			switch (baseFeatureID) {
				case CorePackage.HAS_TAGS__TAGS: return CorePackage.ACTOR__TAGS;
				case CorePackage.HAS_TAGS__TAG_GROUPS: return CorePackage.ACTOR__TAG_GROUPS;
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
		result.append(" (username: ");
		result.append(username);
		result.append(", admin: ");
		result.append(admin);
		result.append(", pwdHash: ");
		result.append(pwdHash);
		result.append(')');
		return result.toString();
	}

} //ActorImpl

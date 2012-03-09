/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.m2ling.domain.core.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.m2ling.domain.core.ComponentNode;
import org.m2ling.domain.core.ComponentNodeGroup;
import org.m2ling.domain.core.CorePackage;
import org.m2ling.domain.core.EngineNode;
import org.m2ling.domain.core.EngineNodeGroup;
import org.m2ling.domain.core.Environnement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Environnement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.m2ling.domain.core.impl.EnvironnementImpl#getComponentNodes <em>Component Nodes</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.EnvironnementImpl#getEngineNodes <em>Engine Nodes</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.EnvironnementImpl#getComponentNodeGroups <em>Component Node Groups</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.EnvironnementImpl#getEngineNodeGroups <em>Engine Node Groups</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.EnvironnementImpl#getProfile <em>Profile</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EnvironnementImpl extends RuntimeItemImpl implements Environnement {
	/**
	 * The cached value of the '{@link #getComponentNodes() <em>Component Nodes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponentNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<ComponentNode> componentNodes;

	/**
	 * The cached value of the '{@link #getEngineNodes() <em>Engine Nodes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEngineNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<EngineNode> engineNodes;

	/**
	 * The cached value of the '{@link #getComponentNodeGroups() <em>Component Node Groups</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponentNodeGroups()
	 * @generated
	 * @ordered
	 */
	protected EList<ComponentNodeGroup> componentNodeGroups;

	/**
	 * The cached value of the '{@link #getEngineNodeGroups() <em>Engine Node Groups</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEngineNodeGroups()
	 * @generated
	 * @ordered
	 */
	protected EList<EngineNodeGroup> engineNodeGroups;

	/**
	 * The default value of the '{@link #getProfile() <em>Profile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProfile()
	 * @generated
	 * @ordered
	 */
	protected static final String PROFILE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProfile() <em>Profile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProfile()
	 * @generated
	 * @ordered
	 */
	protected String profile = PROFILE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EnvironnementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CorePackage.Literals.ENVIRONNEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ComponentNode> getComponentNodes() {
		if (componentNodes == null) {
			componentNodes = new EObjectContainmentEList<ComponentNode>(ComponentNode.class, this, CorePackage.ENVIRONNEMENT__COMPONENT_NODES);
		}
		return componentNodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EngineNode> getEngineNodes() {
		if (engineNodes == null) {
			engineNodes = new EObjectContainmentEList<EngineNode>(EngineNode.class, this, CorePackage.ENVIRONNEMENT__ENGINE_NODES);
		}
		return engineNodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ComponentNodeGroup> getComponentNodeGroups() {
		if (componentNodeGroups == null) {
			componentNodeGroups = new EObjectContainmentEList<ComponentNodeGroup>(ComponentNodeGroup.class, this, CorePackage.ENVIRONNEMENT__COMPONENT_NODE_GROUPS);
		}
		return componentNodeGroups;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EngineNodeGroup> getEngineNodeGroups() {
		if (engineNodeGroups == null) {
			engineNodeGroups = new EObjectContainmentEList<EngineNodeGroup>(EngineNodeGroup.class, this, CorePackage.ENVIRONNEMENT__ENGINE_NODE_GROUPS);
		}
		return engineNodeGroups;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getProfile() {
		return profile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProfile(String newProfile) {
		String oldProfile = profile;
		profile = newProfile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.ENVIRONNEMENT__PROFILE, oldProfile, profile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CorePackage.ENVIRONNEMENT__COMPONENT_NODES:
				return ((InternalEList<?>)getComponentNodes()).basicRemove(otherEnd, msgs);
			case CorePackage.ENVIRONNEMENT__ENGINE_NODES:
				return ((InternalEList<?>)getEngineNodes()).basicRemove(otherEnd, msgs);
			case CorePackage.ENVIRONNEMENT__COMPONENT_NODE_GROUPS:
				return ((InternalEList<?>)getComponentNodeGroups()).basicRemove(otherEnd, msgs);
			case CorePackage.ENVIRONNEMENT__ENGINE_NODE_GROUPS:
				return ((InternalEList<?>)getEngineNodeGroups()).basicRemove(otherEnd, msgs);
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
			case CorePackage.ENVIRONNEMENT__COMPONENT_NODES:
				return getComponentNodes();
			case CorePackage.ENVIRONNEMENT__ENGINE_NODES:
				return getEngineNodes();
			case CorePackage.ENVIRONNEMENT__COMPONENT_NODE_GROUPS:
				return getComponentNodeGroups();
			case CorePackage.ENVIRONNEMENT__ENGINE_NODE_GROUPS:
				return getEngineNodeGroups();
			case CorePackage.ENVIRONNEMENT__PROFILE:
				return getProfile();
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
			case CorePackage.ENVIRONNEMENT__COMPONENT_NODES:
				getComponentNodes().clear();
				getComponentNodes().addAll((Collection<? extends ComponentNode>)newValue);
				return;
			case CorePackage.ENVIRONNEMENT__ENGINE_NODES:
				getEngineNodes().clear();
				getEngineNodes().addAll((Collection<? extends EngineNode>)newValue);
				return;
			case CorePackage.ENVIRONNEMENT__COMPONENT_NODE_GROUPS:
				getComponentNodeGroups().clear();
				getComponentNodeGroups().addAll((Collection<? extends ComponentNodeGroup>)newValue);
				return;
			case CorePackage.ENVIRONNEMENT__ENGINE_NODE_GROUPS:
				getEngineNodeGroups().clear();
				getEngineNodeGroups().addAll((Collection<? extends EngineNodeGroup>)newValue);
				return;
			case CorePackage.ENVIRONNEMENT__PROFILE:
				setProfile((String)newValue);
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
			case CorePackage.ENVIRONNEMENT__COMPONENT_NODES:
				getComponentNodes().clear();
				return;
			case CorePackage.ENVIRONNEMENT__ENGINE_NODES:
				getEngineNodes().clear();
				return;
			case CorePackage.ENVIRONNEMENT__COMPONENT_NODE_GROUPS:
				getComponentNodeGroups().clear();
				return;
			case CorePackage.ENVIRONNEMENT__ENGINE_NODE_GROUPS:
				getEngineNodeGroups().clear();
				return;
			case CorePackage.ENVIRONNEMENT__PROFILE:
				setProfile(PROFILE_EDEFAULT);
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
			case CorePackage.ENVIRONNEMENT__COMPONENT_NODES:
				return componentNodes != null && !componentNodes.isEmpty();
			case CorePackage.ENVIRONNEMENT__ENGINE_NODES:
				return engineNodes != null && !engineNodes.isEmpty();
			case CorePackage.ENVIRONNEMENT__COMPONENT_NODE_GROUPS:
				return componentNodeGroups != null && !componentNodeGroups.isEmpty();
			case CorePackage.ENVIRONNEMENT__ENGINE_NODE_GROUPS:
				return engineNodeGroups != null && !engineNodeGroups.isEmpty();
			case CorePackage.ENVIRONNEMENT__PROFILE:
				return PROFILE_EDEFAULT == null ? profile != null : !PROFILE_EDEFAULT.equals(profile);
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
		result.append(" (profile: ");
		result.append(profile);
		result.append(')');
		return result.toString();
	}

} //EnvironnementImpl

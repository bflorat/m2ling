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

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import org.m2ling.domain.core.ComponentType;
import org.m2ling.domain.core.CorePackage;
import org.m2ling.domain.core.EngineType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Component Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.m2ling.domain.core.impl.ComponentTypeImpl#getSubTypes <em>Sub Types</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.ComponentTypeImpl#getEngineType <em>Engine Type</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.ComponentTypeImpl#getParent <em>Parent</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ComponentTypeImpl extends ConceptItemImpl implements ComponentType {
	/**
	 * The cached value of the '{@link #getSubTypes() <em>Sub Types</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<ComponentType> subTypes;

	/**
	 * The cached value of the '{@link #getEngineType() <em>Engine Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEngineType()
	 * @generated
	 * @ordered
	 */
	protected EngineType engineType;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComponentTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CorePackage.Literals.COMPONENT_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ComponentType> getSubTypes() {
		if (subTypes == null) {
			subTypes = new EObjectContainmentWithInverseEList<ComponentType>(ComponentType.class, this, CorePackage.COMPONENT_TYPE__SUB_TYPES, CorePackage.COMPONENT_TYPE__PARENT);
		}
		return subTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EngineType getEngineType() {
		if (engineType != null && engineType.eIsProxy()) {
			InternalEObject oldEngineType = (InternalEObject)engineType;
			engineType = (EngineType)eResolveProxy(oldEngineType);
			if (engineType != oldEngineType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CorePackage.COMPONENT_TYPE__ENGINE_TYPE, oldEngineType, engineType));
			}
		}
		return engineType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EngineType basicGetEngineType() {
		return engineType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEngineType(EngineType newEngineType, NotificationChain msgs) {
		EngineType oldEngineType = engineType;
		engineType = newEngineType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CorePackage.COMPONENT_TYPE__ENGINE_TYPE, oldEngineType, newEngineType);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEngineType(EngineType newEngineType) {
		if (newEngineType != engineType) {
			NotificationChain msgs = null;
			if (engineType != null)
				msgs = ((InternalEObject)engineType).eInverseRemove(this, CorePackage.ENGINE_TYPE__COMPONENT_TYPES, EngineType.class, msgs);
			if (newEngineType != null)
				msgs = ((InternalEObject)newEngineType).eInverseAdd(this, CorePackage.ENGINE_TYPE__COMPONENT_TYPES, EngineType.class, msgs);
			msgs = basicSetEngineType(newEngineType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.COMPONENT_TYPE__ENGINE_TYPE, newEngineType, newEngineType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentType getParent() {
		if (eContainerFeatureID() != CorePackage.COMPONENT_TYPE__PARENT) return null;
		return (ComponentType)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParent(ComponentType newParent, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParent, CorePackage.COMPONENT_TYPE__PARENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParent(ComponentType newParent) {
		if (newParent != eInternalContainer() || (eContainerFeatureID() != CorePackage.COMPONENT_TYPE__PARENT && newParent != null)) {
			if (EcoreUtil.isAncestor(this, newParent))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParent != null)
				msgs = ((InternalEObject)newParent).eInverseAdd(this, CorePackage.COMPONENT_TYPE__SUB_TYPES, ComponentType.class, msgs);
			msgs = basicSetParent(newParent, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.COMPONENT_TYPE__PARENT, newParent, newParent));
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
			case CorePackage.COMPONENT_TYPE__SUB_TYPES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSubTypes()).basicAdd(otherEnd, msgs);
			case CorePackage.COMPONENT_TYPE__ENGINE_TYPE:
				if (engineType != null)
					msgs = ((InternalEObject)engineType).eInverseRemove(this, CorePackage.ENGINE_TYPE__COMPONENT_TYPES, EngineType.class, msgs);
				return basicSetEngineType((EngineType)otherEnd, msgs);
			case CorePackage.COMPONENT_TYPE__PARENT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParent((ComponentType)otherEnd, msgs);
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
			case CorePackage.COMPONENT_TYPE__SUB_TYPES:
				return ((InternalEList<?>)getSubTypes()).basicRemove(otherEnd, msgs);
			case CorePackage.COMPONENT_TYPE__ENGINE_TYPE:
				return basicSetEngineType(null, msgs);
			case CorePackage.COMPONENT_TYPE__PARENT:
				return basicSetParent(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case CorePackage.COMPONENT_TYPE__PARENT:
				return eInternalContainer().eInverseRemove(this, CorePackage.COMPONENT_TYPE__SUB_TYPES, ComponentType.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CorePackage.COMPONENT_TYPE__SUB_TYPES:
				return getSubTypes();
			case CorePackage.COMPONENT_TYPE__ENGINE_TYPE:
				if (resolve) return getEngineType();
				return basicGetEngineType();
			case CorePackage.COMPONENT_TYPE__PARENT:
				return getParent();
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
			case CorePackage.COMPONENT_TYPE__SUB_TYPES:
				getSubTypes().clear();
				getSubTypes().addAll((Collection<? extends ComponentType>)newValue);
				return;
			case CorePackage.COMPONENT_TYPE__ENGINE_TYPE:
				setEngineType((EngineType)newValue);
				return;
			case CorePackage.COMPONENT_TYPE__PARENT:
				setParent((ComponentType)newValue);
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
			case CorePackage.COMPONENT_TYPE__SUB_TYPES:
				getSubTypes().clear();
				return;
			case CorePackage.COMPONENT_TYPE__ENGINE_TYPE:
				setEngineType((EngineType)null);
				return;
			case CorePackage.COMPONENT_TYPE__PARENT:
				setParent((ComponentType)null);
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
			case CorePackage.COMPONENT_TYPE__SUB_TYPES:
				return subTypes != null && !subTypes.isEmpty();
			case CorePackage.COMPONENT_TYPE__ENGINE_TYPE:
				return engineType != null;
			case CorePackage.COMPONENT_TYPE__PARENT:
				return getParent() != null;
		}
		return super.eIsSet(featureID);
	}

} //ComponentTypeImpl

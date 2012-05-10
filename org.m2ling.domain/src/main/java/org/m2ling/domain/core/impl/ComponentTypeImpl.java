/**
 * Copyright (C) 2012 Bertrand Florat
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
import org.m2ling.domain.core.ComponentType;
import org.m2ling.domain.core.Constraint;
import org.m2ling.domain.core.CorePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Component Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.m2ling.domain.core.impl.ComponentTypeImpl#getSubTypes <em>Sub Types</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.ComponentTypeImpl#getBindedComponentType <em>Binded Component Type</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.ComponentTypeImpl#getEngineType <em>Engine Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ComponentTypeImpl extends ConceptItemImpl implements ComponentType {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (C) 2012 Bertrand Florat";

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
	 * The cached value of the '{@link #getBindedComponentType() <em>Binded Component Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBindedComponentType()
	 * @generated
	 * @ordered
	 */
	protected ComponentType bindedComponentType;

	/**
	 * The cached value of the '{@link #getEngineType() <em>Engine Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEngineType()
	 * @generated
	 * @ordered
	 */
	protected ComponentType engineType;

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
			subTypes = new EObjectContainmentEList<ComponentType>(ComponentType.class, this, CorePackage.COMPONENT_TYPE__SUB_TYPES);
		}
		return subTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentType getBindedComponentType() {
		if (bindedComponentType != null && bindedComponentType.eIsProxy()) {
			InternalEObject oldBindedComponentType = (InternalEObject)bindedComponentType;
			bindedComponentType = (ComponentType)eResolveProxy(oldBindedComponentType);
			if (bindedComponentType != oldBindedComponentType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CorePackage.COMPONENT_TYPE__BINDED_COMPONENT_TYPE, oldBindedComponentType, bindedComponentType));
			}
		}
		return bindedComponentType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentType basicGetBindedComponentType() {
		return bindedComponentType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBindedComponentType(ComponentType newBindedComponentType) {
		ComponentType oldBindedComponentType = bindedComponentType;
		bindedComponentType = newBindedComponentType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.COMPONENT_TYPE__BINDED_COMPONENT_TYPE, oldBindedComponentType, bindedComponentType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentType getEngineType() {
		if (engineType != null && engineType.eIsProxy()) {
			InternalEObject oldEngineType = (InternalEObject)engineType;
			engineType = (ComponentType)eResolveProxy(oldEngineType);
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
	public ComponentType basicGetEngineType() {
		return engineType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEngineType(ComponentType newEngineType) {
		ComponentType oldEngineType = engineType;
		engineType = newEngineType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.COMPONENT_TYPE__ENGINE_TYPE, oldEngineType, engineType));
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
			case CorePackage.COMPONENT_TYPE__SUB_TYPES:
				return getSubTypes();
			case CorePackage.COMPONENT_TYPE__BINDED_COMPONENT_TYPE:
				if (resolve) return getBindedComponentType();
				return basicGetBindedComponentType();
			case CorePackage.COMPONENT_TYPE__ENGINE_TYPE:
				if (resolve) return getEngineType();
				return basicGetEngineType();
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
			case CorePackage.COMPONENT_TYPE__BINDED_COMPONENT_TYPE:
				setBindedComponentType((ComponentType)newValue);
				return;
			case CorePackage.COMPONENT_TYPE__ENGINE_TYPE:
				setEngineType((ComponentType)newValue);
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
			case CorePackage.COMPONENT_TYPE__BINDED_COMPONENT_TYPE:
				setBindedComponentType((ComponentType)null);
				return;
			case CorePackage.COMPONENT_TYPE__ENGINE_TYPE:
				setEngineType((ComponentType)null);
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
			case CorePackage.COMPONENT_TYPE__BINDED_COMPONENT_TYPE:
				return bindedComponentType != null;
			case CorePackage.COMPONENT_TYPE__ENGINE_TYPE:
				return engineType != null;
		}
		return super.eIsSet(featureID);
	}

} //ComponentTypeImpl

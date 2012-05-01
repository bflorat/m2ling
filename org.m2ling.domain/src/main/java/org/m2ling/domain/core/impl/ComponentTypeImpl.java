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
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.m2ling.domain.core.ComponentType;
import org.m2ling.domain.core.CorePackage;
import org.m2ling.domain.core.HasNameAndID;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Component Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.m2ling.domain.core.impl.ComponentTypeImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.ComponentTypeImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.ComponentTypeImpl#getSubTypes <em>Sub Types</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.ComponentTypeImpl#getParent <em>Parent</em>}</li>
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
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

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
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.COMPONENT_TYPE__ID, oldId, id));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.COMPONENT_TYPE__NAME, oldName, name, !oldNameESet));
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
			eNotify(new ENotificationImpl(this, Notification.UNSET, CorePackage.COMPONENT_TYPE__NAME, oldName, NAME_EDEFAULT, oldNameESet));
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
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CorePackage.COMPONENT_TYPE__SUB_TYPES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSubTypes()).basicAdd(otherEnd, msgs);
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
			case CorePackage.COMPONENT_TYPE__ID:
				return getId();
			case CorePackage.COMPONENT_TYPE__NAME:
				return getName();
			case CorePackage.COMPONENT_TYPE__SUB_TYPES:
				return getSubTypes();
			case CorePackage.COMPONENT_TYPE__PARENT:
				return getParent();
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
			case CorePackage.COMPONENT_TYPE__ID:
				setId((String)newValue);
				return;
			case CorePackage.COMPONENT_TYPE__NAME:
				setName((String)newValue);
				return;
			case CorePackage.COMPONENT_TYPE__SUB_TYPES:
				getSubTypes().clear();
				getSubTypes().addAll((Collection<? extends ComponentType>)newValue);
				return;
			case CorePackage.COMPONENT_TYPE__PARENT:
				setParent((ComponentType)newValue);
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
			case CorePackage.COMPONENT_TYPE__ID:
				setId(ID_EDEFAULT);
				return;
			case CorePackage.COMPONENT_TYPE__NAME:
				unsetName();
				return;
			case CorePackage.COMPONENT_TYPE__SUB_TYPES:
				getSubTypes().clear();
				return;
			case CorePackage.COMPONENT_TYPE__PARENT:
				setParent((ComponentType)null);
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
			case CorePackage.COMPONENT_TYPE__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case CorePackage.COMPONENT_TYPE__NAME:
				return isSetName();
			case CorePackage.COMPONENT_TYPE__SUB_TYPES:
				return subTypes != null && !subTypes.isEmpty();
			case CorePackage.COMPONENT_TYPE__PARENT:
				return getParent() != null;
			case CorePackage.COMPONENT_TYPE__BINDED_COMPONENT_TYPE:
				return bindedComponentType != null;
			case CorePackage.COMPONENT_TYPE__ENGINE_TYPE:
				return engineType != null;
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
				case CorePackage.COMPONENT_TYPE__ID: return CorePackage.HAS_NAME_AND_ID__ID;
				case CorePackage.COMPONENT_TYPE__NAME: return CorePackage.HAS_NAME_AND_ID__NAME;
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
				case CorePackage.HAS_NAME_AND_ID__ID: return CorePackage.COMPONENT_TYPE__ID;
				case CorePackage.HAS_NAME_AND_ID__NAME: return CorePackage.COMPONENT_TYPE__NAME;
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
		result.append(" (id: ");
		result.append(id);
		result.append(", name: ");
		if (nameESet) result.append(name); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //ComponentTypeImpl

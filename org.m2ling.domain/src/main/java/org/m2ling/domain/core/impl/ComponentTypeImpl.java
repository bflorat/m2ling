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
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.m2ling.domain.core.ComponentGroup;
import org.m2ling.domain.core.ComponentType;
import org.m2ling.domain.core.CorePackage;
import org.m2ling.domain.core.Reference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Component Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.m2ling.domain.core.impl.ComponentTypeImpl#getEngineTypes <em>Engine Types</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.ComponentTypeImpl#getSubTypes <em>Sub Types</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.ComponentTypeImpl#getBoundType <em>Bound Type</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.ComponentTypeImpl#getEnumeration <em>Enumeration</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.ComponentTypeImpl#getInstantiationFactor <em>Instantiation Factor</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.ComponentTypeImpl#isReifiable <em>Reifiable</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.ComponentTypeImpl#getReferences <em>References</em>}</li>
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
	 * The cached value of the '{@link #getEngineTypes() <em>Engine Types</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEngineTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<ComponentType> engineTypes;

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
	 * The cached value of the '{@link #getBoundType() <em>Bound Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBoundType()
	 * @generated
	 * @ordered
	 */
	protected ComponentType boundType;

	/**
	 * The cached value of the '{@link #getEnumeration() <em>Enumeration</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnumeration()
	 * @generated
	 * @ordered
	 */
	protected EList<ComponentGroup> enumeration;

	/**
	 * The default value of the '{@link #getInstantiationFactor() <em>Instantiation Factor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstantiationFactor()
	 * @generated
	 * @ordered
	 */
	protected static final int INSTANTIATION_FACTOR_EDEFAULT = 1;

	/**
	 * The cached value of the '{@link #getInstantiationFactor() <em>Instantiation Factor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstantiationFactor()
	 * @generated
	 * @ordered
	 */
	protected int instantiationFactor = INSTANTIATION_FACTOR_EDEFAULT;

	/**
	 * The default value of the '{@link #isReifiable() <em>Reifiable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isReifiable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean REIFIABLE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isReifiable() <em>Reifiable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isReifiable()
	 * @generated
	 * @ordered
	 */
	protected boolean reifiable = REIFIABLE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getReferences() <em>References</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferences()
	 * @generated
	 * @ordered
	 */
	protected EList<Reference<?>> references;

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
	public EList<ComponentType> getEngineTypes() {
		if (engineTypes == null) {
			engineTypes = new EObjectResolvingEList<ComponentType>(ComponentType.class, this, CorePackage.COMPONENT_TYPE__ENGINE_TYPES);
		}
		return engineTypes;
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
	public EList<ComponentGroup> getEnumeration() {
		if (enumeration == null) {
			enumeration = new EObjectResolvingEList<ComponentGroup>(ComponentGroup.class, this, CorePackage.COMPONENT_TYPE__ENUMERATION);
		}
		return enumeration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getInstantiationFactor() {
		return instantiationFactor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInstantiationFactor(int newInstantiationFactor) {
		int oldInstantiationFactor = instantiationFactor;
		instantiationFactor = newInstantiationFactor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.COMPONENT_TYPE__INSTANTIATION_FACTOR, oldInstantiationFactor, instantiationFactor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isReifiable() {
		return reifiable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReifiable(boolean newReifiable) {
		boolean oldReifiable = reifiable;
		reifiable = newReifiable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.COMPONENT_TYPE__REIFIABLE, oldReifiable, reifiable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Reference<?>> getReferences() {
		if (references == null) {
			references = new EObjectContainmentEList<Reference<?>>(Reference.class, this, CorePackage.COMPONENT_TYPE__REFERENCES);
		}
		return references;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentType getBoundType() {
		if (boundType != null && boundType.eIsProxy()) {
			InternalEObject oldBoundType = (InternalEObject)boundType;
			boundType = (ComponentType)eResolveProxy(oldBoundType);
			if (boundType != oldBoundType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CorePackage.COMPONENT_TYPE__BOUND_TYPE, oldBoundType, boundType));
			}
		}
		return boundType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentType basicGetBoundType() {
		return boundType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBoundType(ComponentType newBoundType) {
		ComponentType oldBoundType = boundType;
		boundType = newBoundType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.COMPONENT_TYPE__BOUND_TYPE, oldBoundType, boundType));
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
			case CorePackage.COMPONENT_TYPE__REFERENCES:
				return ((InternalEList<?>)getReferences()).basicRemove(otherEnd, msgs);
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
			case CorePackage.COMPONENT_TYPE__ENGINE_TYPES:
				return getEngineTypes();
			case CorePackage.COMPONENT_TYPE__SUB_TYPES:
				return getSubTypes();
			case CorePackage.COMPONENT_TYPE__BOUND_TYPE:
				if (resolve) return getBoundType();
				return basicGetBoundType();
			case CorePackage.COMPONENT_TYPE__ENUMERATION:
				return getEnumeration();
			case CorePackage.COMPONENT_TYPE__INSTANTIATION_FACTOR:
				return getInstantiationFactor();
			case CorePackage.COMPONENT_TYPE__REIFIABLE:
				return isReifiable();
			case CorePackage.COMPONENT_TYPE__REFERENCES:
				return getReferences();
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
			case CorePackage.COMPONENT_TYPE__ENGINE_TYPES:
				getEngineTypes().clear();
				getEngineTypes().addAll((Collection<? extends ComponentType>)newValue);
				return;
			case CorePackage.COMPONENT_TYPE__SUB_TYPES:
				getSubTypes().clear();
				getSubTypes().addAll((Collection<? extends ComponentType>)newValue);
				return;
			case CorePackage.COMPONENT_TYPE__BOUND_TYPE:
				setBoundType((ComponentType)newValue);
				return;
			case CorePackage.COMPONENT_TYPE__ENUMERATION:
				getEnumeration().clear();
				getEnumeration().addAll((Collection<? extends ComponentGroup>)newValue);
				return;
			case CorePackage.COMPONENT_TYPE__INSTANTIATION_FACTOR:
				setInstantiationFactor((Integer)newValue);
				return;
			case CorePackage.COMPONENT_TYPE__REIFIABLE:
				setReifiable((Boolean)newValue);
				return;
			case CorePackage.COMPONENT_TYPE__REFERENCES:
				getReferences().clear();
				getReferences().addAll((Collection<? extends Reference<?>>)newValue);
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
			case CorePackage.COMPONENT_TYPE__ENGINE_TYPES:
				getEngineTypes().clear();
				return;
			case CorePackage.COMPONENT_TYPE__SUB_TYPES:
				getSubTypes().clear();
				return;
			case CorePackage.COMPONENT_TYPE__BOUND_TYPE:
				setBoundType((ComponentType)null);
				return;
			case CorePackage.COMPONENT_TYPE__ENUMERATION:
				getEnumeration().clear();
				return;
			case CorePackage.COMPONENT_TYPE__INSTANTIATION_FACTOR:
				setInstantiationFactor(INSTANTIATION_FACTOR_EDEFAULT);
				return;
			case CorePackage.COMPONENT_TYPE__REIFIABLE:
				setReifiable(REIFIABLE_EDEFAULT);
				return;
			case CorePackage.COMPONENT_TYPE__REFERENCES:
				getReferences().clear();
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
			case CorePackage.COMPONENT_TYPE__ENGINE_TYPES:
				return engineTypes != null && !engineTypes.isEmpty();
			case CorePackage.COMPONENT_TYPE__SUB_TYPES:
				return subTypes != null && !subTypes.isEmpty();
			case CorePackage.COMPONENT_TYPE__BOUND_TYPE:
				return boundType != null;
			case CorePackage.COMPONENT_TYPE__ENUMERATION:
				return enumeration != null && !enumeration.isEmpty();
			case CorePackage.COMPONENT_TYPE__INSTANTIATION_FACTOR:
				return instantiationFactor != INSTANTIATION_FACTOR_EDEFAULT;
			case CorePackage.COMPONENT_TYPE__REIFIABLE:
				return reifiable != REIFIABLE_EDEFAULT;
			case CorePackage.COMPONENT_TYPE__REFERENCES:
				return references != null && !references.isEmpty();
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
		result.append(" (instantiationFactor: ");
		result.append(instantiationFactor);
		result.append(", reifiable: ");
		result.append(reifiable);
		result.append(')');
		return result.toString();
	}

} //ComponentTypeImpl

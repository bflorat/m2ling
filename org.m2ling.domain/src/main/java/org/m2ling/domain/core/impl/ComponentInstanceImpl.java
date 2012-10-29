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
import org.m2ling.domain.core.Component;
import org.m2ling.domain.core.ComponentInstance;
import org.m2ling.domain.core.CorePackage;
import org.m2ling.domain.core.HasReferences;
import org.m2ling.domain.core.Reference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Component Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.m2ling.domain.core.impl.ComponentInstanceImpl#getReferences <em>References</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.ComponentInstanceImpl#getComponent <em>Component</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.ComponentInstanceImpl#getBoundComponentInstance <em>Bound Component Instance</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ComponentInstanceImpl extends RuntimeItemImpl implements ComponentInstance {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (C) 2012 Bertrand Florat";

	/**
	 * The cached value of the '{@link #getReferences() <em>References</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferences()
	 * @generated
	 * @ordered
	 */
	protected EList<Reference> references;

	/**
	 * The cached value of the '{@link #getComponent() <em>Component</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponent()
	 * @generated
	 * @ordered
	 */
	protected Component component;

	/**
	 * The cached value of the '{@link #getBoundComponentInstance() <em>Bound Component Instance</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBoundComponentInstance()
	 * @generated
	 * @ordered
	 */
	protected ComponentInstance boundComponentInstance;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComponentInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CorePackage.Literals.COMPONENT_INSTANCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Component getComponent() {
		if (component != null && component.eIsProxy()) {
			InternalEObject oldComponent = (InternalEObject)component;
			component = (Component)eResolveProxy(oldComponent);
			if (component != oldComponent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CorePackage.COMPONENT_INSTANCE__COMPONENT, oldComponent, component));
			}
		}
		return component;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Component basicGetComponent() {
		return component;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComponent(Component newComponent) {
		Component oldComponent = component;
		component = newComponent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.COMPONENT_INSTANCE__COMPONENT, oldComponent, component));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentInstance getBoundComponentInstance() {
		if (boundComponentInstance != null && boundComponentInstance.eIsProxy()) {
			InternalEObject oldBoundComponentInstance = (InternalEObject)boundComponentInstance;
			boundComponentInstance = (ComponentInstance)eResolveProxy(oldBoundComponentInstance);
			if (boundComponentInstance != oldBoundComponentInstance) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CorePackage.COMPONENT_INSTANCE__BOUND_COMPONENT_INSTANCE, oldBoundComponentInstance, boundComponentInstance));
			}
		}
		return boundComponentInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentInstance basicGetBoundComponentInstance() {
		return boundComponentInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBoundComponentInstance(ComponentInstance newBoundComponentInstance) {
		ComponentInstance oldBoundComponentInstance = boundComponentInstance;
		boundComponentInstance = newBoundComponentInstance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.COMPONENT_INSTANCE__BOUND_COMPONENT_INSTANCE, oldBoundComponentInstance, boundComponentInstance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Reference> getReferences() {
		if (references == null) {
			references = new EObjectContainmentEList<Reference>(Reference.class, this, CorePackage.COMPONENT_INSTANCE__REFERENCES);
		}
		return references;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CorePackage.COMPONENT_INSTANCE__REFERENCES:
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
			case CorePackage.COMPONENT_INSTANCE__REFERENCES:
				return getReferences();
			case CorePackage.COMPONENT_INSTANCE__COMPONENT:
				if (resolve) return getComponent();
				return basicGetComponent();
			case CorePackage.COMPONENT_INSTANCE__BOUND_COMPONENT_INSTANCE:
				if (resolve) return getBoundComponentInstance();
				return basicGetBoundComponentInstance();
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
			case CorePackage.COMPONENT_INSTANCE__REFERENCES:
				getReferences().clear();
				getReferences().addAll((Collection<? extends Reference>)newValue);
				return;
			case CorePackage.COMPONENT_INSTANCE__COMPONENT:
				setComponent((Component)newValue);
				return;
			case CorePackage.COMPONENT_INSTANCE__BOUND_COMPONENT_INSTANCE:
				setBoundComponentInstance((ComponentInstance)newValue);
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
			case CorePackage.COMPONENT_INSTANCE__REFERENCES:
				getReferences().clear();
				return;
			case CorePackage.COMPONENT_INSTANCE__COMPONENT:
				setComponent((Component)null);
				return;
			case CorePackage.COMPONENT_INSTANCE__BOUND_COMPONENT_INSTANCE:
				setBoundComponentInstance((ComponentInstance)null);
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
			case CorePackage.COMPONENT_INSTANCE__REFERENCES:
				return references != null && !references.isEmpty();
			case CorePackage.COMPONENT_INSTANCE__COMPONENT:
				return component != null;
			case CorePackage.COMPONENT_INSTANCE__BOUND_COMPONENT_INSTANCE:
				return boundComponentInstance != null;
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
		if (baseClass == HasReferences.class) {
			switch (derivedFeatureID) {
				case CorePackage.COMPONENT_INSTANCE__REFERENCES: return CorePackage.HAS_REFERENCES__REFERENCES;
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
		if (baseClass == HasReferences.class) {
			switch (baseFeatureID) {
				case CorePackage.HAS_REFERENCES__REFERENCES: return CorePackage.COMPONENT_INSTANCE__REFERENCES;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc --> If the component node is bound to another component node in the same
	 * or another viewpoint, we use the bound component node name if the current component node name
	 * is void and if the bound component node name is not void itself.<!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public String getName() {
		if ((name == null || "".equals(name)) && boundComponentInstance != null && boundComponentInstance.getName() != null
				&& !"".equals(boundComponentInstance)) {
			return boundComponentInstance.getName();
		} else {
			return name;
		}
	}

} //ComponentInstanceImpl

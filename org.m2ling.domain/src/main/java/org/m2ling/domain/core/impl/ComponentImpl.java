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
import org.m2ling.domain.core.Component;
import org.m2ling.domain.core.ComponentInstance;
import org.m2ling.domain.core.ComponentType;
import org.m2ling.domain.core.CorePackage;
import org.m2ling.domain.core.Reference;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Component</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.m2ling.domain.core.impl.ComponentImpl#getSubComponents <em>Sub Components</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.ComponentImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.ComponentImpl#getEngines <em>Engines</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.ComponentImpl#getBoundComponent <em>Bound Component</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.ComponentImpl#getInstances <em>Instances</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.ComponentImpl#getReferences <em>References</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ComponentImpl extends ComponentGroupImpl implements Component {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (C) 2012 Bertrand Florat";

	/**
	 * The cached value of the '{@link #getSubComponents() <em>Sub Components</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getSubComponents()
	 * @generated
	 * @ordered
	 */
	protected EList<Component> subComponents;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected ComponentType type;

	/**
	 * The cached value of the '{@link #getEngines() <em>Engines</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEngines()
	 * @generated
	 * @ordered
	 */
	protected EList<Component> engines;

	/**
	 * The cached value of the '{@link #getBoundComponent() <em>Bound Component</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getBoundComponent()
	 * @generated
	 * @ordered
	 */
	protected Component boundComponent;

	/**
	 * The cached value of the '{@link #getInstances() <em>Instances</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstances()
	 * @generated
	 * @ordered
	 */
	protected EList<ComponentInstance> instances;

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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ComponentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CorePackage.Literals.COMPONENT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentType getType() {
		if (type != null && type.eIsProxy()) {
			InternalEObject oldType = (InternalEObject)type;
			type = (ComponentType)eResolveProxy(oldType);
			if (type != oldType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CorePackage.COMPONENT__TYPE, oldType, type));
			}
		}
		return type;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentType basicGetType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc --> If the component is bound to another component in the same or another
	 * viewpoint, we use the bound component name if the current component name is void and if the
	 * bound component name is not void itself.<!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public String getName() {
		if ((name == null || "".equals(name)) && boundComponent != null && boundComponent.getName() != null
				&& !"".equals(boundComponent)) {
			return boundComponent.getName();
		} else {
			return name;
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(ComponentType newType) {
		ComponentType oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.COMPONENT__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Component> getEngines() {
		if (engines == null) {
			engines = new EObjectResolvingEList<Component>(Component.class, this, CorePackage.COMPONENT__ENGINES);
		}
		return engines;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Component> getSubComponents() {
		if (subComponents == null) {
			subComponents = new EObjectContainmentEList<Component>(Component.class, this, CorePackage.COMPONENT__SUB_COMPONENTS);
		}
		return subComponents;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Component getBoundComponent() {
		if (boundComponent != null && boundComponent.eIsProxy()) {
			InternalEObject oldBoundComponent = (InternalEObject)boundComponent;
			boundComponent = (Component)eResolveProxy(oldBoundComponent);
			if (boundComponent != oldBoundComponent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CorePackage.COMPONENT__BOUND_COMPONENT, oldBoundComponent, boundComponent));
			}
		}
		return boundComponent;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Component basicGetBoundComponent() {
		return boundComponent;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setBoundComponent(Component newBoundComponent) {
		Component oldBoundComponent = boundComponent;
		boundComponent = newBoundComponent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.COMPONENT__BOUND_COMPONENT, oldBoundComponent, boundComponent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ComponentInstance> getInstances() {
		if (instances == null) {
			instances = new EObjectContainmentEList<ComponentInstance>(ComponentInstance.class, this, CorePackage.COMPONENT__INSTANCES);
		}
		return instances;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Reference<?>> getReferences() {
		if (references == null) {
			references = new EObjectContainmentEList<Reference<?>>(Reference.class, this, CorePackage.COMPONENT__REFERENCES);
		}
		return references;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CorePackage.COMPONENT__SUB_COMPONENTS:
				return ((InternalEList<?>)getSubComponents()).basicRemove(otherEnd, msgs);
			case CorePackage.COMPONENT__INSTANCES:
				return ((InternalEList<?>)getInstances()).basicRemove(otherEnd, msgs);
			case CorePackage.COMPONENT__REFERENCES:
				return ((InternalEList<?>)getReferences()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CorePackage.COMPONENT__SUB_COMPONENTS:
				return getSubComponents();
			case CorePackage.COMPONENT__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case CorePackage.COMPONENT__ENGINES:
				return getEngines();
			case CorePackage.COMPONENT__BOUND_COMPONENT:
				if (resolve) return getBoundComponent();
				return basicGetBoundComponent();
			case CorePackage.COMPONENT__INSTANCES:
				return getInstances();
			case CorePackage.COMPONENT__REFERENCES:
				return getReferences();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CorePackage.COMPONENT__SUB_COMPONENTS:
				getSubComponents().clear();
				getSubComponents().addAll((Collection<? extends Component>)newValue);
				return;
			case CorePackage.COMPONENT__TYPE:
				setType((ComponentType)newValue);
				return;
			case CorePackage.COMPONENT__ENGINES:
				getEngines().clear();
				getEngines().addAll((Collection<? extends Component>)newValue);
				return;
			case CorePackage.COMPONENT__BOUND_COMPONENT:
				setBoundComponent((Component)newValue);
				return;
			case CorePackage.COMPONENT__INSTANCES:
				getInstances().clear();
				getInstances().addAll((Collection<? extends ComponentInstance>)newValue);
				return;
			case CorePackage.COMPONENT__REFERENCES:
				getReferences().clear();
				getReferences().addAll((Collection<? extends Reference<?>>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case CorePackage.COMPONENT__SUB_COMPONENTS:
				getSubComponents().clear();
				return;
			case CorePackage.COMPONENT__TYPE:
				setType((ComponentType)null);
				return;
			case CorePackage.COMPONENT__ENGINES:
				getEngines().clear();
				return;
			case CorePackage.COMPONENT__BOUND_COMPONENT:
				setBoundComponent((Component)null);
				return;
			case CorePackage.COMPONENT__INSTANCES:
				getInstances().clear();
				return;
			case CorePackage.COMPONENT__REFERENCES:
				getReferences().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case CorePackage.COMPONENT__SUB_COMPONENTS:
				return subComponents != null && !subComponents.isEmpty();
			case CorePackage.COMPONENT__TYPE:
				return type != null;
			case CorePackage.COMPONENT__ENGINES:
				return engines != null && !engines.isEmpty();
			case CorePackage.COMPONENT__BOUND_COMPONENT:
				return boundComponent != null;
			case CorePackage.COMPONENT__INSTANCES:
				return instances != null && !instances.isEmpty();
			case CorePackage.COMPONENT__REFERENCES:
				return references != null && !references.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} // ComponentImpl

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
import org.m2ling.domain.core.ComponentInstanceGroup;
import org.m2ling.domain.core.CorePackage;
import org.m2ling.domain.core.InstancesLink;
import org.m2ling.domain.core.Reference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Component Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.m2ling.domain.core.impl.ComponentInstanceImpl#getComponent <em>Component</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.ComponentInstanceImpl#getSubInstances <em>Sub Instances</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.ComponentInstanceImpl#getEngineInstance <em>Engine Instance</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.ComponentInstanceImpl#getInstances <em>Instances</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.ComponentInstanceImpl#getStreams <em>Streams</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.ComponentInstanceImpl#getInstancesGroups <em>Instances Groups</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.ComponentInstanceImpl#getBoundComponentInstance <em>Bound Component Instance</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.ComponentInstanceImpl#getReferences <em>References</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ComponentInstanceImpl extends ComponentInstanceGroupImpl implements ComponentInstance {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (C) 2012 Bertrand Florat";

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
	 * The cached value of the '{@link #getSubInstances() <em>Sub Instances</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubInstances()
	 * @generated
	 * @ordered
	 */
	protected EList<ComponentInstance> subInstances;

	/**
	 * The cached value of the '{@link #getEngineInstance() <em>Engine Instance</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEngineInstance()
	 * @generated
	 * @ordered
	 */
	protected ComponentInstance engineInstance;

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
	 * The cached value of the '{@link #getStreams() <em>Streams</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStreams()
	 * @generated
	 * @ordered
	 */
	protected EList<InstancesLink> streams;

	/**
	 * The cached value of the '{@link #getInstancesGroups() <em>Instances Groups</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstancesGroups()
	 * @generated
	 * @ordered
	 */
	protected EList<ComponentInstanceGroup> instancesGroups;

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
	public EList<ComponentInstance> getSubInstances() {
		if (subInstances == null) {
			subInstances = new EObjectContainmentEList<ComponentInstance>(ComponentInstance.class, this, CorePackage.COMPONENT_INSTANCE__SUB_INSTANCES);
		}
		return subInstances;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentInstance getEngineInstance() {
		if (engineInstance != null && engineInstance.eIsProxy()) {
			InternalEObject oldEngineInstance = (InternalEObject)engineInstance;
			engineInstance = (ComponentInstance)eResolveProxy(oldEngineInstance);
			if (engineInstance != oldEngineInstance) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CorePackage.COMPONENT_INSTANCE__ENGINE_INSTANCE, oldEngineInstance, engineInstance));
			}
		}
		return engineInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentInstance basicGetEngineInstance() {
		return engineInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEngineInstance(ComponentInstance newEngineInstance) {
		ComponentInstance oldEngineInstance = engineInstance;
		engineInstance = newEngineInstance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.COMPONENT_INSTANCE__ENGINE_INSTANCE, oldEngineInstance, engineInstance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ComponentInstance> getInstances() {
		if (instances == null) {
			instances = new EObjectContainmentEList<ComponentInstance>(ComponentInstance.class, this, CorePackage.COMPONENT_INSTANCE__INSTANCES);
		}
		return instances;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<InstancesLink> getStreams() {
		if (streams == null) {
			streams = new EObjectContainmentEList<InstancesLink>(InstancesLink.class, this, CorePackage.COMPONENT_INSTANCE__STREAMS);
		}
		return streams;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ComponentInstanceGroup> getInstancesGroups() {
		if (instancesGroups == null) {
			instancesGroups = new EObjectContainmentEList<ComponentInstanceGroup>(ComponentInstanceGroup.class, this, CorePackage.COMPONENT_INSTANCE__INSTANCES_GROUPS);
		}
		return instancesGroups;
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
	public EList<Reference<?>> getReferences() {
		if (references == null) {
			references = new EObjectContainmentEList<Reference<?>>(Reference.class, this, CorePackage.COMPONENT_INSTANCE__REFERENCES);
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
			case CorePackage.COMPONENT_INSTANCE__SUB_INSTANCES:
				return ((InternalEList<?>)getSubInstances()).basicRemove(otherEnd, msgs);
			case CorePackage.COMPONENT_INSTANCE__INSTANCES:
				return ((InternalEList<?>)getInstances()).basicRemove(otherEnd, msgs);
			case CorePackage.COMPONENT_INSTANCE__STREAMS:
				return ((InternalEList<?>)getStreams()).basicRemove(otherEnd, msgs);
			case CorePackage.COMPONENT_INSTANCE__INSTANCES_GROUPS:
				return ((InternalEList<?>)getInstancesGroups()).basicRemove(otherEnd, msgs);
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
			case CorePackage.COMPONENT_INSTANCE__COMPONENT:
				if (resolve) return getComponent();
				return basicGetComponent();
			case CorePackage.COMPONENT_INSTANCE__SUB_INSTANCES:
				return getSubInstances();
			case CorePackage.COMPONENT_INSTANCE__ENGINE_INSTANCE:
				if (resolve) return getEngineInstance();
				return basicGetEngineInstance();
			case CorePackage.COMPONENT_INSTANCE__INSTANCES:
				return getInstances();
			case CorePackage.COMPONENT_INSTANCE__STREAMS:
				return getStreams();
			case CorePackage.COMPONENT_INSTANCE__INSTANCES_GROUPS:
				return getInstancesGroups();
			case CorePackage.COMPONENT_INSTANCE__BOUND_COMPONENT_INSTANCE:
				if (resolve) return getBoundComponentInstance();
				return basicGetBoundComponentInstance();
			case CorePackage.COMPONENT_INSTANCE__REFERENCES:
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
			case CorePackage.COMPONENT_INSTANCE__COMPONENT:
				setComponent((Component)newValue);
				return;
			case CorePackage.COMPONENT_INSTANCE__SUB_INSTANCES:
				getSubInstances().clear();
				getSubInstances().addAll((Collection<? extends ComponentInstance>)newValue);
				return;
			case CorePackage.COMPONENT_INSTANCE__ENGINE_INSTANCE:
				setEngineInstance((ComponentInstance)newValue);
				return;
			case CorePackage.COMPONENT_INSTANCE__INSTANCES:
				getInstances().clear();
				getInstances().addAll((Collection<? extends ComponentInstance>)newValue);
				return;
			case CorePackage.COMPONENT_INSTANCE__STREAMS:
				getStreams().clear();
				getStreams().addAll((Collection<? extends InstancesLink>)newValue);
				return;
			case CorePackage.COMPONENT_INSTANCE__INSTANCES_GROUPS:
				getInstancesGroups().clear();
				getInstancesGroups().addAll((Collection<? extends ComponentInstanceGroup>)newValue);
				return;
			case CorePackage.COMPONENT_INSTANCE__BOUND_COMPONENT_INSTANCE:
				setBoundComponentInstance((ComponentInstance)newValue);
				return;
			case CorePackage.COMPONENT_INSTANCE__REFERENCES:
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
			case CorePackage.COMPONENT_INSTANCE__COMPONENT:
				setComponent((Component)null);
				return;
			case CorePackage.COMPONENT_INSTANCE__SUB_INSTANCES:
				getSubInstances().clear();
				return;
			case CorePackage.COMPONENT_INSTANCE__ENGINE_INSTANCE:
				setEngineInstance((ComponentInstance)null);
				return;
			case CorePackage.COMPONENT_INSTANCE__INSTANCES:
				getInstances().clear();
				return;
			case CorePackage.COMPONENT_INSTANCE__STREAMS:
				getStreams().clear();
				return;
			case CorePackage.COMPONENT_INSTANCE__INSTANCES_GROUPS:
				getInstancesGroups().clear();
				return;
			case CorePackage.COMPONENT_INSTANCE__BOUND_COMPONENT_INSTANCE:
				setBoundComponentInstance((ComponentInstance)null);
				return;
			case CorePackage.COMPONENT_INSTANCE__REFERENCES:
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
			case CorePackage.COMPONENT_INSTANCE__COMPONENT:
				return component != null;
			case CorePackage.COMPONENT_INSTANCE__SUB_INSTANCES:
				return subInstances != null && !subInstances.isEmpty();
			case CorePackage.COMPONENT_INSTANCE__ENGINE_INSTANCE:
				return engineInstance != null;
			case CorePackage.COMPONENT_INSTANCE__INSTANCES:
				return instances != null && !instances.isEmpty();
			case CorePackage.COMPONENT_INSTANCE__STREAMS:
				return streams != null && !streams.isEmpty();
			case CorePackage.COMPONENT_INSTANCE__INSTANCES_GROUPS:
				return instancesGroups != null && !instancesGroups.isEmpty();
			case CorePackage.COMPONENT_INSTANCE__BOUND_COMPONENT_INSTANCE:
				return boundComponentInstance != null;
			case CorePackage.COMPONENT_INSTANCE__REFERENCES:
				return references != null && !references.isEmpty();
		}
		return super.eIsSet(featureID);
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

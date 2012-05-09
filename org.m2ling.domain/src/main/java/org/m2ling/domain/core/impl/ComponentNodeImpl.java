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
import org.m2ling.domain.core.ComponentNode;
import org.m2ling.domain.core.ComponentNodeGroup;
import org.m2ling.domain.core.CorePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Component Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.m2ling.domain.core.impl.ComponentNodeImpl#getComponent <em>Component</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.ComponentNodeImpl#getSubNodes <em>Sub Nodes</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.ComponentNodeImpl#getEngine <em>Engine</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ComponentNodeImpl extends ComponentNodeGroupImpl implements ComponentNode {
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
	 * The cached value of the '{@link #getSubNodes() <em>Sub Nodes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<ComponentNode> subNodes;

	/**
	 * The cached value of the '{@link #getEngine() <em>Engine</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEngine()
	 * @generated
	 * @ordered
	 */
	protected ComponentNodeGroup engine;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComponentNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CorePackage.Literals.COMPONENT_NODE;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CorePackage.COMPONENT_NODE__COMPONENT, oldComponent, component));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.COMPONENT_NODE__COMPONENT, oldComponent, component));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ComponentNode> getSubNodes() {
		if (subNodes == null) {
			subNodes = new EObjectContainmentEList<ComponentNode>(ComponentNode.class, this, CorePackage.COMPONENT_NODE__SUB_NODES);
		}
		return subNodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentNodeGroup getEngine() {
		if (engine != null && engine.eIsProxy()) {
			InternalEObject oldEngine = (InternalEObject)engine;
			engine = (ComponentNodeGroup)eResolveProxy(oldEngine);
			if (engine != oldEngine) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CorePackage.COMPONENT_NODE__ENGINE, oldEngine, engine));
			}
		}
		return engine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentNodeGroup basicGetEngine() {
		return engine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEngine(ComponentNodeGroup newEngine) {
		ComponentNodeGroup oldEngine = engine;
		engine = newEngine;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.COMPONENT_NODE__ENGINE, oldEngine, engine));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CorePackage.COMPONENT_NODE__SUB_NODES:
				return ((InternalEList<?>)getSubNodes()).basicRemove(otherEnd, msgs);
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
			case CorePackage.COMPONENT_NODE__COMPONENT:
				if (resolve) return getComponent();
				return basicGetComponent();
			case CorePackage.COMPONENT_NODE__SUB_NODES:
				return getSubNodes();
			case CorePackage.COMPONENT_NODE__ENGINE:
				if (resolve) return getEngine();
				return basicGetEngine();
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
			case CorePackage.COMPONENT_NODE__COMPONENT:
				setComponent((Component)newValue);
				return;
			case CorePackage.COMPONENT_NODE__SUB_NODES:
				getSubNodes().clear();
				getSubNodes().addAll((Collection<? extends ComponentNode>)newValue);
				return;
			case CorePackage.COMPONENT_NODE__ENGINE:
				setEngine((ComponentNodeGroup)newValue);
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
			case CorePackage.COMPONENT_NODE__COMPONENT:
				setComponent((Component)null);
				return;
			case CorePackage.COMPONENT_NODE__SUB_NODES:
				getSubNodes().clear();
				return;
			case CorePackage.COMPONENT_NODE__ENGINE:
				setEngine((ComponentNodeGroup)null);
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
			case CorePackage.COMPONENT_NODE__COMPONENT:
				return component != null;
			case CorePackage.COMPONENT_NODE__SUB_NODES:
				return subNodes != null && !subNodes.isEmpty();
			case CorePackage.COMPONENT_NODE__ENGINE:
				return engine != null;
		}
		return super.eIsSet(featureID);
	}

} //ComponentNodeImpl

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

import org.m2ling.domain.core.Component;
import org.m2ling.domain.core.ComponentNode;
import org.m2ling.domain.core.CorePackage;
import org.m2ling.domain.core.EngineNode;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Component Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.m2ling.domain.core.impl.ComponentNodeImpl#getComponent <em>Component</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.ComponentNodeImpl#getEngineNode <em>Engine Node</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.ComponentNodeImpl#getSubNodes <em>Sub Nodes</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.ComponentNodeImpl#getParent <em>Parent</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ComponentNodeImpl extends ComponentNodeGroupImpl implements ComponentNode {
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
	 * The cached value of the '{@link #getEngineNode() <em>Engine Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEngineNode()
	 * @generated
	 * @ordered
	 */
	protected EngineNode engineNode;

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
	public EngineNode getEngineNode() {
		if (engineNode != null && engineNode.eIsProxy()) {
			InternalEObject oldEngineNode = (InternalEObject)engineNode;
			engineNode = (EngineNode)eResolveProxy(oldEngineNode);
			if (engineNode != oldEngineNode) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CorePackage.COMPONENT_NODE__ENGINE_NODE, oldEngineNode, engineNode));
			}
		}
		return engineNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EngineNode basicGetEngineNode() {
		return engineNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEngineNode(EngineNode newEngineNode, NotificationChain msgs) {
		EngineNode oldEngineNode = engineNode;
		engineNode = newEngineNode;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CorePackage.COMPONENT_NODE__ENGINE_NODE, oldEngineNode, newEngineNode);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEngineNode(EngineNode newEngineNode) {
		if (newEngineNode != engineNode) {
			NotificationChain msgs = null;
			if (engineNode != null)
				msgs = ((InternalEObject)engineNode).eInverseRemove(this, CorePackage.ENGINE_NODE__COMPONENT_NODES, EngineNode.class, msgs);
			if (newEngineNode != null)
				msgs = ((InternalEObject)newEngineNode).eInverseAdd(this, CorePackage.ENGINE_NODE__COMPONENT_NODES, EngineNode.class, msgs);
			msgs = basicSetEngineNode(newEngineNode, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.COMPONENT_NODE__ENGINE_NODE, newEngineNode, newEngineNode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ComponentNode> getSubNodes() {
		if (subNodes == null) {
			subNodes = new EObjectContainmentWithInverseEList<ComponentNode>(ComponentNode.class, this, CorePackage.COMPONENT_NODE__SUB_NODES, CorePackage.COMPONENT_NODE__PARENT);
		}
		return subNodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentNode getParent() {
		if (eContainerFeatureID() != CorePackage.COMPONENT_NODE__PARENT) return null;
		return (ComponentNode)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParent(ComponentNode newParent, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParent, CorePackage.COMPONENT_NODE__PARENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParent(ComponentNode newParent) {
		if (newParent != eInternalContainer() || (eContainerFeatureID() != CorePackage.COMPONENT_NODE__PARENT && newParent != null)) {
			if (EcoreUtil.isAncestor(this, newParent))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParent != null)
				msgs = ((InternalEObject)newParent).eInverseAdd(this, CorePackage.COMPONENT_NODE__SUB_NODES, ComponentNode.class, msgs);
			msgs = basicSetParent(newParent, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.COMPONENT_NODE__PARENT, newParent, newParent));
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
			case CorePackage.COMPONENT_NODE__ENGINE_NODE:
				if (engineNode != null)
					msgs = ((InternalEObject)engineNode).eInverseRemove(this, CorePackage.ENGINE_NODE__COMPONENT_NODES, EngineNode.class, msgs);
				return basicSetEngineNode((EngineNode)otherEnd, msgs);
			case CorePackage.COMPONENT_NODE__SUB_NODES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSubNodes()).basicAdd(otherEnd, msgs);
			case CorePackage.COMPONENT_NODE__PARENT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParent((ComponentNode)otherEnd, msgs);
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
			case CorePackage.COMPONENT_NODE__ENGINE_NODE:
				return basicSetEngineNode(null, msgs);
			case CorePackage.COMPONENT_NODE__SUB_NODES:
				return ((InternalEList<?>)getSubNodes()).basicRemove(otherEnd, msgs);
			case CorePackage.COMPONENT_NODE__PARENT:
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
			case CorePackage.COMPONENT_NODE__PARENT:
				return eInternalContainer().eInverseRemove(this, CorePackage.COMPONENT_NODE__SUB_NODES, ComponentNode.class, msgs);
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
			case CorePackage.COMPONENT_NODE__COMPONENT:
				if (resolve) return getComponent();
				return basicGetComponent();
			case CorePackage.COMPONENT_NODE__ENGINE_NODE:
				if (resolve) return getEngineNode();
				return basicGetEngineNode();
			case CorePackage.COMPONENT_NODE__SUB_NODES:
				return getSubNodes();
			case CorePackage.COMPONENT_NODE__PARENT:
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
			case CorePackage.COMPONENT_NODE__COMPONENT:
				setComponent((Component)newValue);
				return;
			case CorePackage.COMPONENT_NODE__ENGINE_NODE:
				setEngineNode((EngineNode)newValue);
				return;
			case CorePackage.COMPONENT_NODE__SUB_NODES:
				getSubNodes().clear();
				getSubNodes().addAll((Collection<? extends ComponentNode>)newValue);
				return;
			case CorePackage.COMPONENT_NODE__PARENT:
				setParent((ComponentNode)newValue);
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
			case CorePackage.COMPONENT_NODE__ENGINE_NODE:
				setEngineNode((EngineNode)null);
				return;
			case CorePackage.COMPONENT_NODE__SUB_NODES:
				getSubNodes().clear();
				return;
			case CorePackage.COMPONENT_NODE__PARENT:
				setParent((ComponentNode)null);
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
			case CorePackage.COMPONENT_NODE__ENGINE_NODE:
				return engineNode != null;
			case CorePackage.COMPONENT_NODE__SUB_NODES:
				return subNodes != null && !subNodes.isEmpty();
			case CorePackage.COMPONENT_NODE__PARENT:
				return getParent() != null;
		}
		return super.eIsSet(featureID);
	}

} //ComponentNodeImpl

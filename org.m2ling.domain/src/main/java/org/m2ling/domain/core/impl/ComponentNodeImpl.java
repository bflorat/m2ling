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
import org.m2ling.domain.core.NodesLink;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Component Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.m2ling.domain.core.impl.ComponentNodeImpl#getComponent <em>Component</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.ComponentNodeImpl#getSubNodes <em>Sub Nodes</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.ComponentNodeImpl#getEngineNode <em>Engine Node</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.ComponentNodeImpl#getNodes <em>Nodes</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.ComponentNodeImpl#getStreams <em>Streams</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.ComponentNodeImpl#getNodesGroups <em>Nodes Groups</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.ComponentNodeImpl#getBoundComponentNode <em>Bound Component Node</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ComponentNodeImpl extends ComponentNodeGroupImpl implements ComponentNode {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (C) 2012 Bertrand Florat";

	/**
	 * The cached value of the '{@link #getComponent() <em>Component</em>}' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getComponent()
	 * @generated
	 * @ordered
	 */
	protected Component component;

	/**
	 * The cached value of the '{@link #getSubNodes() <em>Sub Nodes</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getSubNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<ComponentNode> subNodes;

	/**
	 * The cached value of the '{@link #getEngineNode() <em>Engine Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEngineNode()
	 * @generated
	 * @ordered
	 */
	protected ComponentNode engineNode;

	/**
	 * The cached value of the '{@link #getNodes() <em>Nodes</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<ComponentNode> nodes;

	/**
	 * The cached value of the '{@link #getStreams() <em>Streams</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getStreams()
	 * @generated
	 * @ordered
	 */
	protected EList<NodesLink> streams;

	/**
	 * The cached value of the '{@link #getNodesGroups() <em>Nodes Groups</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getNodesGroups()
	 * @generated
	 * @ordered
	 */
	protected EList<ComponentNodeGroup> nodesGroups;

	/**
	 * The cached value of the '{@link #getBoundComponentNode() <em>Bound Component Node</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getBoundComponentNode()
	 * @generated
	 * @ordered
	 */
	protected ComponentNode boundComponentNode;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ComponentNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CorePackage.Literals.COMPONENT_NODE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Component basicGetComponent() {
		return component;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setComponent(Component newComponent) {
		Component oldComponent = component;
		component = newComponent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.COMPONENT_NODE__COMPONENT, oldComponent, component));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
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
	public ComponentNode getEngineNode() {
		if (engineNode != null && engineNode.eIsProxy()) {
			InternalEObject oldEngineNode = (InternalEObject)engineNode;
			engineNode = (ComponentNode)eResolveProxy(oldEngineNode);
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
	public ComponentNode basicGetEngineNode() {
		return engineNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEngineNode(ComponentNode newEngineNode) {
		ComponentNode oldEngineNode = engineNode;
		engineNode = newEngineNode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.COMPONENT_NODE__ENGINE_NODE, oldEngineNode, engineNode));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ComponentNode> getNodes() {
		if (nodes == null) {
			nodes = new EObjectContainmentEList<ComponentNode>(ComponentNode.class, this, CorePackage.COMPONENT_NODE__NODES);
		}
		return nodes;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NodesLink> getStreams() {
		if (streams == null) {
			streams = new EObjectContainmentEList<NodesLink>(NodesLink.class, this, CorePackage.COMPONENT_NODE__STREAMS);
		}
		return streams;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ComponentNodeGroup> getNodesGroups() {
		if (nodesGroups == null) {
			nodesGroups = new EObjectContainmentEList<ComponentNodeGroup>(ComponentNodeGroup.class, this, CorePackage.COMPONENT_NODE__NODES_GROUPS);
		}
		return nodesGroups;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentNode getBoundComponentNode() {
		if (boundComponentNode != null && boundComponentNode.eIsProxy()) {
			InternalEObject oldBoundComponentNode = (InternalEObject)boundComponentNode;
			boundComponentNode = (ComponentNode)eResolveProxy(oldBoundComponentNode);
			if (boundComponentNode != oldBoundComponentNode) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CorePackage.COMPONENT_NODE__BOUND_COMPONENT_NODE, oldBoundComponentNode, boundComponentNode));
			}
		}
		return boundComponentNode;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentNode basicGetBoundComponentNode() {
		return boundComponentNode;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setBoundComponentNode(ComponentNode newBoundComponentNode) {
		ComponentNode oldBoundComponentNode = boundComponentNode;
		boundComponentNode = newBoundComponentNode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.COMPONENT_NODE__BOUND_COMPONENT_NODE, oldBoundComponentNode, boundComponentNode));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CorePackage.COMPONENT_NODE__SUB_NODES:
				return ((InternalEList<?>)getSubNodes()).basicRemove(otherEnd, msgs);
			case CorePackage.COMPONENT_NODE__NODES:
				return ((InternalEList<?>)getNodes()).basicRemove(otherEnd, msgs);
			case CorePackage.COMPONENT_NODE__STREAMS:
				return ((InternalEList<?>)getStreams()).basicRemove(otherEnd, msgs);
			case CorePackage.COMPONENT_NODE__NODES_GROUPS:
				return ((InternalEList<?>)getNodesGroups()).basicRemove(otherEnd, msgs);
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
			case CorePackage.COMPONENT_NODE__COMPONENT:
				if (resolve) return getComponent();
				return basicGetComponent();
			case CorePackage.COMPONENT_NODE__SUB_NODES:
				return getSubNodes();
			case CorePackage.COMPONENT_NODE__ENGINE_NODE:
				if (resolve) return getEngineNode();
				return basicGetEngineNode();
			case CorePackage.COMPONENT_NODE__NODES:
				return getNodes();
			case CorePackage.COMPONENT_NODE__STREAMS:
				return getStreams();
			case CorePackage.COMPONENT_NODE__NODES_GROUPS:
				return getNodesGroups();
			case CorePackage.COMPONENT_NODE__BOUND_COMPONENT_NODE:
				if (resolve) return getBoundComponentNode();
				return basicGetBoundComponentNode();
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
			case CorePackage.COMPONENT_NODE__COMPONENT:
				setComponent((Component)newValue);
				return;
			case CorePackage.COMPONENT_NODE__SUB_NODES:
				getSubNodes().clear();
				getSubNodes().addAll((Collection<? extends ComponentNode>)newValue);
				return;
			case CorePackage.COMPONENT_NODE__ENGINE_NODE:
				setEngineNode((ComponentNode)newValue);
				return;
			case CorePackage.COMPONENT_NODE__NODES:
				getNodes().clear();
				getNodes().addAll((Collection<? extends ComponentNode>)newValue);
				return;
			case CorePackage.COMPONENT_NODE__STREAMS:
				getStreams().clear();
				getStreams().addAll((Collection<? extends NodesLink>)newValue);
				return;
			case CorePackage.COMPONENT_NODE__NODES_GROUPS:
				getNodesGroups().clear();
				getNodesGroups().addAll((Collection<? extends ComponentNodeGroup>)newValue);
				return;
			case CorePackage.COMPONENT_NODE__BOUND_COMPONENT_NODE:
				setBoundComponentNode((ComponentNode)newValue);
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
			case CorePackage.COMPONENT_NODE__COMPONENT:
				setComponent((Component)null);
				return;
			case CorePackage.COMPONENT_NODE__SUB_NODES:
				getSubNodes().clear();
				return;
			case CorePackage.COMPONENT_NODE__ENGINE_NODE:
				setEngineNode((ComponentNode)null);
				return;
			case CorePackage.COMPONENT_NODE__NODES:
				getNodes().clear();
				return;
			case CorePackage.COMPONENT_NODE__STREAMS:
				getStreams().clear();
				return;
			case CorePackage.COMPONENT_NODE__NODES_GROUPS:
				getNodesGroups().clear();
				return;
			case CorePackage.COMPONENT_NODE__BOUND_COMPONENT_NODE:
				setBoundComponentNode((ComponentNode)null);
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
			case CorePackage.COMPONENT_NODE__COMPONENT:
				return component != null;
			case CorePackage.COMPONENT_NODE__SUB_NODES:
				return subNodes != null && !subNodes.isEmpty();
			case CorePackage.COMPONENT_NODE__ENGINE_NODE:
				return engineNode != null;
			case CorePackage.COMPONENT_NODE__NODES:
				return nodes != null && !nodes.isEmpty();
			case CorePackage.COMPONENT_NODE__STREAMS:
				return streams != null && !streams.isEmpty();
			case CorePackage.COMPONENT_NODE__NODES_GROUPS:
				return nodesGroups != null && !nodesGroups.isEmpty();
			case CorePackage.COMPONENT_NODE__BOUND_COMPONENT_NODE:
				return boundComponentNode != null;
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
		if ((name == null || "".equals(name)) && boundComponentNode != null && boundComponentNode.getName() != null
				&& !"".equals(boundComponentNode)) {
			return boundComponentNode.getName();
		} else {
			return name;
		}
	}

} // ComponentNodeImpl

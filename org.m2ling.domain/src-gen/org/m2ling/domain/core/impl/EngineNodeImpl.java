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
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import org.m2ling.domain.core.ComponentNode;
import org.m2ling.domain.core.CorePackage;
import org.m2ling.domain.core.Engine;
import org.m2ling.domain.core.EngineNode;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Engine Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.m2ling.domain.core.impl.EngineNodeImpl#getEngine <em>Engine</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.EngineNodeImpl#getSubNodes <em>Sub Nodes</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.EngineNodeImpl#getComponentNodes <em>Component Nodes</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.EngineNodeImpl#getParent <em>Parent</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EngineNodeImpl extends EngineNodeGroupImpl implements EngineNode {
	/**
	 * The cached value of the '{@link #getEngine() <em>Engine</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEngine()
	 * @generated
	 * @ordered
	 */
	protected Engine engine;

	/**
	 * The cached value of the '{@link #getSubNodes() <em>Sub Nodes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<EngineNode> subNodes;

	/**
	 * The cached value of the '{@link #getComponentNodes() <em>Component Nodes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponentNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<ComponentNode> componentNodes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EngineNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CorePackage.Literals.ENGINE_NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Engine getEngine() {
		if (engine != null && engine.eIsProxy()) {
			InternalEObject oldEngine = (InternalEObject)engine;
			engine = (Engine)eResolveProxy(oldEngine);
			if (engine != oldEngine) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CorePackage.ENGINE_NODE__ENGINE, oldEngine, engine));
			}
		}
		return engine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Engine basicGetEngine() {
		return engine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEngine(Engine newEngine) {
		Engine oldEngine = engine;
		engine = newEngine;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.ENGINE_NODE__ENGINE, oldEngine, engine));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EngineNode> getSubNodes() {
		if (subNodes == null) {
			subNodes = new EObjectContainmentWithInverseEList<EngineNode>(EngineNode.class, this, CorePackage.ENGINE_NODE__SUB_NODES, CorePackage.ENGINE_NODE__PARENT);
		}
		return subNodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ComponentNode> getComponentNodes() {
		if (componentNodes == null) {
			componentNodes = new EObjectWithInverseResolvingEList<ComponentNode>(ComponentNode.class, this, CorePackage.ENGINE_NODE__COMPONENT_NODES, CorePackage.COMPONENT_NODE__ENGINE_NODE);
		}
		return componentNodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EngineNode getParent() {
		if (eContainerFeatureID() != CorePackage.ENGINE_NODE__PARENT) return null;
		return (EngineNode)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParent(EngineNode newParent, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParent, CorePackage.ENGINE_NODE__PARENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParent(EngineNode newParent) {
		if (newParent != eInternalContainer() || (eContainerFeatureID() != CorePackage.ENGINE_NODE__PARENT && newParent != null)) {
			if (EcoreUtil.isAncestor(this, newParent))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParent != null)
				msgs = ((InternalEObject)newParent).eInverseAdd(this, CorePackage.ENGINE_NODE__SUB_NODES, EngineNode.class, msgs);
			msgs = basicSetParent(newParent, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.ENGINE_NODE__PARENT, newParent, newParent));
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
			case CorePackage.ENGINE_NODE__SUB_NODES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSubNodes()).basicAdd(otherEnd, msgs);
			case CorePackage.ENGINE_NODE__COMPONENT_NODES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getComponentNodes()).basicAdd(otherEnd, msgs);
			case CorePackage.ENGINE_NODE__PARENT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParent((EngineNode)otherEnd, msgs);
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
			case CorePackage.ENGINE_NODE__SUB_NODES:
				return ((InternalEList<?>)getSubNodes()).basicRemove(otherEnd, msgs);
			case CorePackage.ENGINE_NODE__COMPONENT_NODES:
				return ((InternalEList<?>)getComponentNodes()).basicRemove(otherEnd, msgs);
			case CorePackage.ENGINE_NODE__PARENT:
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
			case CorePackage.ENGINE_NODE__PARENT:
				return eInternalContainer().eInverseRemove(this, CorePackage.ENGINE_NODE__SUB_NODES, EngineNode.class, msgs);
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
			case CorePackage.ENGINE_NODE__ENGINE:
				if (resolve) return getEngine();
				return basicGetEngine();
			case CorePackage.ENGINE_NODE__SUB_NODES:
				return getSubNodes();
			case CorePackage.ENGINE_NODE__COMPONENT_NODES:
				return getComponentNodes();
			case CorePackage.ENGINE_NODE__PARENT:
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
			case CorePackage.ENGINE_NODE__ENGINE:
				setEngine((Engine)newValue);
				return;
			case CorePackage.ENGINE_NODE__SUB_NODES:
				getSubNodes().clear();
				getSubNodes().addAll((Collection<? extends EngineNode>)newValue);
				return;
			case CorePackage.ENGINE_NODE__COMPONENT_NODES:
				getComponentNodes().clear();
				getComponentNodes().addAll((Collection<? extends ComponentNode>)newValue);
				return;
			case CorePackage.ENGINE_NODE__PARENT:
				setParent((EngineNode)newValue);
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
			case CorePackage.ENGINE_NODE__ENGINE:
				setEngine((Engine)null);
				return;
			case CorePackage.ENGINE_NODE__SUB_NODES:
				getSubNodes().clear();
				return;
			case CorePackage.ENGINE_NODE__COMPONENT_NODES:
				getComponentNodes().clear();
				return;
			case CorePackage.ENGINE_NODE__PARENT:
				setParent((EngineNode)null);
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
			case CorePackage.ENGINE_NODE__ENGINE:
				return engine != null;
			case CorePackage.ENGINE_NODE__SUB_NODES:
				return subNodes != null && !subNodes.isEmpty();
			case CorePackage.ENGINE_NODE__COMPONENT_NODES:
				return componentNodes != null && !componentNodes.isEmpty();
			case CorePackage.ENGINE_NODE__PARENT:
				return getParent() != null;
		}
		return super.eIsSet(featureID);
	}

} //EngineNodeImpl

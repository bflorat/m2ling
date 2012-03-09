/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.m2ling.domain.core.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.m2ling.domain.core.CorePackage;
import org.m2ling.domain.core.EngineNode;
import org.m2ling.domain.core.EngineNodeGroup;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Engine Node Group</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.m2ling.domain.core.impl.EngineNodeGroupImpl#getEngineNodes <em>Engine Nodes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EngineNodeGroupImpl extends RuntimeItemImpl implements EngineNodeGroup {
	/**
	 * The cached value of the '{@link #getEngineNodes() <em>Engine Nodes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEngineNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<EngineNode> engineNodes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EngineNodeGroupImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CorePackage.Literals.ENGINE_NODE_GROUP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EngineNode> getEngineNodes() {
		if (engineNodes == null) {
			engineNodes = new EObjectResolvingEList<EngineNode>(EngineNode.class, this, CorePackage.ENGINE_NODE_GROUP__ENGINE_NODES);
		}
		return engineNodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CorePackage.ENGINE_NODE_GROUP__ENGINE_NODES:
				return getEngineNodes();
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
			case CorePackage.ENGINE_NODE_GROUP__ENGINE_NODES:
				getEngineNodes().clear();
				getEngineNodes().addAll((Collection<? extends EngineNode>)newValue);
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
			case CorePackage.ENGINE_NODE_GROUP__ENGINE_NODES:
				getEngineNodes().clear();
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
			case CorePackage.ENGINE_NODE_GROUP__ENGINE_NODES:
				return engineNodes != null && !engineNodes.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //EngineNodeGroupImpl

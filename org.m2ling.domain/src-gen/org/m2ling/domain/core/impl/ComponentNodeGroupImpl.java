/**
 * Copyright (C) Bertrand Florat
 */
package org.m2ling.domain.core.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.m2ling.domain.core.ComponentNode;
import org.m2ling.domain.core.ComponentNodeGroup;
import org.m2ling.domain.core.CorePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Component Node Group</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.m2ling.domain.core.impl.ComponentNodeGroupImpl#getComponentNodes <em>Component Nodes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ComponentNodeGroupImpl extends RuntimeItemImpl implements ComponentNodeGroup {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (C) Bertrand Florat";

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
	protected ComponentNodeGroupImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CorePackage.Literals.COMPONENT_NODE_GROUP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ComponentNode> getComponentNodes() {
		if (componentNodes == null) {
			componentNodes = new EObjectResolvingEList<ComponentNode>(ComponentNode.class, this, CorePackage.COMPONENT_NODE_GROUP__COMPONENT_NODES);
		}
		return componentNodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CorePackage.COMPONENT_NODE_GROUP__COMPONENT_NODES:
				return getComponentNodes();
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
			case CorePackage.COMPONENT_NODE_GROUP__COMPONENT_NODES:
				getComponentNodes().clear();
				getComponentNodes().addAll((Collection<? extends ComponentNode>)newValue);
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
			case CorePackage.COMPONENT_NODE_GROUP__COMPONENT_NODES:
				getComponentNodes().clear();
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
			case CorePackage.COMPONENT_NODE_GROUP__COMPONENT_NODES:
				return componentNodes != null && !componentNodes.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ComponentNodeGroupImpl

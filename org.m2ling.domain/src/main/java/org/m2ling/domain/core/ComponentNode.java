/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.domain.core;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Component Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.m2ling.domain.core.ComponentNode#getComponent <em>Component</em>}</li>
 *   <li>{@link org.m2ling.domain.core.ComponentNode#getSubNodes <em>Sub Nodes</em>}</li>
 *   <li>{@link org.m2ling.domain.core.ComponentNode#getEngine <em>Engine</em>}</li>
 *   <li>{@link org.m2ling.domain.core.ComponentNode#getNodes <em>Nodes</em>}</li>
 *   <li>{@link org.m2ling.domain.core.ComponentNode#getStreams <em>Streams</em>}</li>
 *   <li>{@link org.m2ling.domain.core.ComponentNode#getNodesGroups <em>Nodes Groups</em>}</li>
 *   <li>{@link org.m2ling.domain.core.ComponentNode#getBoundComponentNode <em>Bound Component Node</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.m2ling.domain.core.CorePackage#getComponentNode()
 * @model
 * @generated
 */
public interface ComponentNode extends ComponentNodeGroup, HasParameterValues {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (C) 2012 Bertrand Florat";

	/**
	 * Returns the value of the '<em><b>Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Component</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Component</em>' reference.
	 * @see #setComponent(Component)
	 * @see org.m2ling.domain.core.CorePackage#getComponentNode_Component()
	 * @model required="true"
	 * @generated
	 */
	Component getComponent();

	/**
	 * Sets the value of the '{@link org.m2ling.domain.core.ComponentNode#getComponent <em>Component</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Component</em>' reference.
	 * @see #getComponent()
	 * @generated
	 */
	void setComponent(Component value);

	/**
	 * Returns the value of the '<em><b>Sub Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link org.m2ling.domain.core.ComponentNode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Nodes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Nodes</em>' containment reference list.
	 * @see org.m2ling.domain.core.CorePackage#getComponentNode_SubNodes()
	 * @model containment="true"
	 * @generated
	 */
	EList<ComponentNode> getSubNodes();

	/**
	 * Returns the value of the '<em><b>Engine</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Engine</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Engine</em>' reference.
	 * @see #setEngine(ComponentNode)
	 * @see org.m2ling.domain.core.CorePackage#getComponentNode_Engine()
	 * @model
	 * @generated
	 */
	ComponentNode getEngine();

	/**
	 * Sets the value of the '{@link org.m2ling.domain.core.ComponentNode#getEngine <em>Engine</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Engine</em>' reference.
	 * @see #getEngine()
	 * @generated
	 */
	void setEngine(ComponentNode value);

	/**
	 * Returns the value of the '<em><b>Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link org.m2ling.domain.core.ComponentNode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nodes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nodes</em>' containment reference list.
	 * @see org.m2ling.domain.core.CorePackage#getComponentNode_Nodes()
	 * @model containment="true"
	 * @generated
	 */
	EList<ComponentNode> getNodes();

	/**
	 * Returns the value of the '<em><b>Streams</b></em>' containment reference list.
	 * The list contents are of type {@link org.m2ling.domain.core.NodesLink}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Streams</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Streams</em>' containment reference list.
	 * @see org.m2ling.domain.core.CorePackage#getComponentNode_Streams()
	 * @model containment="true"
	 * @generated
	 */
	EList<NodesLink> getStreams();

	/**
	 * Returns the value of the '<em><b>Nodes Groups</b></em>' containment reference list.
	 * The list contents are of type {@link org.m2ling.domain.core.ComponentNodeGroup}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nodes Groups</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nodes Groups</em>' containment reference list.
	 * @see org.m2ling.domain.core.CorePackage#getComponentNode_NodesGroups()
	 * @model containment="true"
	 * @generated
	 */
	EList<ComponentNodeGroup> getNodesGroups();

	/**
	 * Returns the value of the '<em><b>Bound Component Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bound Component Node</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bound Component Node</em>' reference.
	 * @see #setBoundComponentNode(ComponentNode)
	 * @see org.m2ling.domain.core.CorePackage#getComponentNode_BoundComponentNode()
	 * @model
	 * @generated
	 */
	ComponentNode getBoundComponentNode();

	/**
	 * Sets the value of the '{@link org.m2ling.domain.core.ComponentNode#getBoundComponentNode <em>Bound Component Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bound Component Node</em>' reference.
	 * @see #getBoundComponentNode()
	 * @generated
	 */
	void setBoundComponentNode(ComponentNode value);

} // ComponentNode

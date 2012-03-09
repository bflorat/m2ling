/**
 * <copyright>
 * </copyright>
 *
 * $Id$
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
 *   <li>{@link org.m2ling.domain.core.ComponentNode#getEngineNode <em>Engine Node</em>}</li>
 *   <li>{@link org.m2ling.domain.core.ComponentNode#getSubNodes <em>Sub Nodes</em>}</li>
 *   <li>{@link org.m2ling.domain.core.ComponentNode#getParent <em>Parent</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.m2ling.domain.core.CorePackage#getComponentNode()
 * @model
 * @generated
 */
public interface ComponentNode extends ComponentNodeGroup {
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
	 * Returns the value of the '<em><b>Engine Node</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.m2ling.domain.core.EngineNode#getComponentNodes <em>Component Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Engine Node</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Engine Node</em>' reference.
	 * @see #setEngineNode(EngineNode)
	 * @see org.m2ling.domain.core.CorePackage#getComponentNode_EngineNode()
	 * @see org.m2ling.domain.core.EngineNode#getComponentNodes
	 * @model opposite="componentNodes" required="true"
	 * @generated
	 */
	EngineNode getEngineNode();

	/**
	 * Sets the value of the '{@link org.m2ling.domain.core.ComponentNode#getEngineNode <em>Engine Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Engine Node</em>' reference.
	 * @see #getEngineNode()
	 * @generated
	 */
	void setEngineNode(EngineNode value);

	/**
	 * Returns the value of the '<em><b>Sub Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link org.m2ling.domain.core.ComponentNode}.
	 * It is bidirectional and its opposite is '{@link org.m2ling.domain.core.ComponentNode#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Nodes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Nodes</em>' containment reference list.
	 * @see org.m2ling.domain.core.CorePackage#getComponentNode_SubNodes()
	 * @see org.m2ling.domain.core.ComponentNode#getParent
	 * @model opposite="parent" containment="true"
	 * @generated
	 */
	EList<ComponentNode> getSubNodes();

	/**
	 * Returns the value of the '<em><b>Parent</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.m2ling.domain.core.ComponentNode#getSubNodes <em>Sub Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' container reference.
	 * @see #setParent(ComponentNode)
	 * @see org.m2ling.domain.core.CorePackage#getComponentNode_Parent()
	 * @see org.m2ling.domain.core.ComponentNode#getSubNodes
	 * @model opposite="subNodes" transient="false"
	 * @generated
	 */
	ComponentNode getParent();

	/**
	 * Sets the value of the '{@link org.m2ling.domain.core.ComponentNode#getParent <em>Parent</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' container reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(ComponentNode value);

} // ComponentNode

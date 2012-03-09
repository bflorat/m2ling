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
 * A representation of the model object '<em><b>Engine Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.m2ling.domain.core.EngineNode#getEngine <em>Engine</em>}</li>
 *   <li>{@link org.m2ling.domain.core.EngineNode#getSubNodes <em>Sub Nodes</em>}</li>
 *   <li>{@link org.m2ling.domain.core.EngineNode#getComponentNodes <em>Component Nodes</em>}</li>
 *   <li>{@link org.m2ling.domain.core.EngineNode#getParent <em>Parent</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.m2ling.domain.core.CorePackage#getEngineNode()
 * @model
 * @generated
 */
public interface EngineNode extends EngineNodeGroup {
	/**
	 * Returns the value of the '<em><b>Engine</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Engine</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Engine</em>' reference.
	 * @see #setEngine(Engine)
	 * @see org.m2ling.domain.core.CorePackage#getEngineNode_Engine()
	 * @model required="true"
	 * @generated
	 */
	Engine getEngine();

	/**
	 * Sets the value of the '{@link org.m2ling.domain.core.EngineNode#getEngine <em>Engine</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Engine</em>' reference.
	 * @see #getEngine()
	 * @generated
	 */
	void setEngine(Engine value);

	/**
	 * Returns the value of the '<em><b>Sub Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link org.m2ling.domain.core.EngineNode}.
	 * It is bidirectional and its opposite is '{@link org.m2ling.domain.core.EngineNode#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Nodes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Nodes</em>' containment reference list.
	 * @see org.m2ling.domain.core.CorePackage#getEngineNode_SubNodes()
	 * @see org.m2ling.domain.core.EngineNode#getParent
	 * @model opposite="parent" containment="true"
	 * @generated
	 */
	EList<EngineNode> getSubNodes();

	/**
	 * Returns the value of the '<em><b>Component Nodes</b></em>' reference list.
	 * The list contents are of type {@link org.m2ling.domain.core.ComponentNode}.
	 * It is bidirectional and its opposite is '{@link org.m2ling.domain.core.ComponentNode#getEngineNode <em>Engine Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Component Nodes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Component Nodes</em>' reference list.
	 * @see org.m2ling.domain.core.CorePackage#getEngineNode_ComponentNodes()
	 * @see org.m2ling.domain.core.ComponentNode#getEngineNode
	 * @model opposite="engineNode"
	 * @generated
	 */
	EList<ComponentNode> getComponentNodes();

	/**
	 * Returns the value of the '<em><b>Parent</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.m2ling.domain.core.EngineNode#getSubNodes <em>Sub Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' container reference.
	 * @see #setParent(EngineNode)
	 * @see org.m2ling.domain.core.CorePackage#getEngineNode_Parent()
	 * @see org.m2ling.domain.core.EngineNode#getSubNodes
	 * @model opposite="subNodes" transient="false"
	 * @generated
	 */
	EngineNode getParent();

	/**
	 * Sets the value of the '{@link org.m2ling.domain.core.EngineNode#getParent <em>Parent</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' container reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(EngineNode value);

} // EngineNode

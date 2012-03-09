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
 * A representation of the model object '<em><b>Concepts</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.m2ling.domain.core.Concepts#getComponentTypes <em>Component Types</em>}</li>
 *   <li>{@link org.m2ling.domain.core.Concepts#getEngineTypes <em>Engine Types</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.m2ling.domain.core.CorePackage#getConcepts()
 * @model
 * @generated
 */
public interface Concepts extends ConceptItem {
	/**
	 * Returns the value of the '<em><b>Component Types</b></em>' containment reference list.
	 * The list contents are of type {@link org.m2ling.domain.core.ComponentType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Component Types</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Component Types</em>' containment reference list.
	 * @see org.m2ling.domain.core.CorePackage#getConcepts_ComponentTypes()
	 * @model containment="true"
	 * @generated
	 */
	EList<ComponentType> getComponentTypes();

	/**
	 * Returns the value of the '<em><b>Engine Types</b></em>' containment reference list.
	 * The list contents are of type {@link org.m2ling.domain.core.EngineType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Engine Types</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Engine Types</em>' containment reference list.
	 * @see org.m2ling.domain.core.CorePackage#getConcepts_EngineTypes()
	 * @model containment="true"
	 * @generated
	 */
	EList<EngineType> getEngineTypes();

} // Concepts

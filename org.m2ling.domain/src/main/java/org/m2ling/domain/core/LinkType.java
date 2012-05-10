/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.domain.core;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Link Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.m2ling.domain.core.LinkType#getSourceTypes <em>Source Types</em>}</li>
 *   <li>{@link org.m2ling.domain.core.LinkType#getDestinationTypes <em>Destination Types</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.m2ling.domain.core.CorePackage#getLinkType()
 * @model
 * @generated
 */
public interface LinkType extends ConceptItem {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (C) 2012 Bertrand Florat";

	/**
	 * Returns the value of the '<em><b>Source Types</b></em>' reference list.
	 * The list contents are of type {@link org.m2ling.domain.core.ComponentType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Types</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Types</em>' reference list.
	 * @see org.m2ling.domain.core.CorePackage#getLinkType_SourceTypes()
	 * @model required="true"
	 * @generated
	 */
	EList<ComponentType> getSourceTypes();

	/**
	 * Returns the value of the '<em><b>Destination Types</b></em>' reference list.
	 * The list contents are of type {@link org.m2ling.domain.core.ComponentType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Destination Types</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Destination Types</em>' reference list.
	 * @see org.m2ling.domain.core.CorePackage#getLinkType_DestinationTypes()
	 * @model required="true"
	 * @generated
	 */
	EList<ComponentType> getDestinationTypes();

} // LinkType

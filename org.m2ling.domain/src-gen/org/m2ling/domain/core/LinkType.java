/**
 * Copyright (C) Bertrand Florat
 */
package org.m2ling.domain.core;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Link Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.m2ling.domain.core.LinkType#getSourceType <em>Source Type</em>}</li>
 *   <li>{@link org.m2ling.domain.core.LinkType#getDestinationType <em>Destination Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.m2ling.domain.core.CorePackage#getLinkType()
 * @model
 * @generated
 */
public interface LinkType extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (C) Bertrand Florat";

	/**
	 * Returns the value of the '<em><b>Source Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Type</em>' reference.
	 * @see #setSourceType(ConceptItem)
	 * @see org.m2ling.domain.core.CorePackage#getLinkType_SourceType()
	 * @model required="true"
	 * @generated
	 */
	ConceptItem getSourceType();

	/**
	 * Sets the value of the '{@link org.m2ling.domain.core.LinkType#getSourceType <em>Source Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Type</em>' reference.
	 * @see #getSourceType()
	 * @generated
	 */
	void setSourceType(ConceptItem value);

	/**
	 * Returns the value of the '<em><b>Destination Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Destination Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Destination Type</em>' reference.
	 * @see #setDestinationType(ConceptItem)
	 * @see org.m2ling.domain.core.CorePackage#getLinkType_DestinationType()
	 * @model required="true"
	 * @generated
	 */
	ConceptItem getDestinationType();

	/**
	 * Sets the value of the '{@link org.m2ling.domain.core.LinkType#getDestinationType <em>Destination Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Destination Type</em>' reference.
	 * @see #getDestinationType()
	 * @generated
	 */
	void setDestinationType(ConceptItem value);

} // LinkType

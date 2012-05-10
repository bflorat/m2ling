/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.domain.core;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Link</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.m2ling.domain.core.Link#getType <em>Type</em>}</li>
 *   <li>{@link org.m2ling.domain.core.Link#getOrigin <em>Origin</em>}</li>
 *   <li>{@link org.m2ling.domain.core.Link#getDestination <em>Destination</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.m2ling.domain.core.CorePackage#getLink()
 * @model
 * @generated
 */
public interface Link extends HasComment, HasConstraints, HasCustomProperties, HasNameAndID, HasTags {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (C) 2012 Bertrand Florat";

	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(LinkType)
	 * @see org.m2ling.domain.core.CorePackage#getLink_Type()
	 * @model required="true"
	 * @generated
	 */
	LinkType getType();

	/**
	 * Sets the value of the '{@link org.m2ling.domain.core.Link#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(LinkType value);

	/**
	 * Returns the value of the '<em><b>Origin</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Origin</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Origin</em>' reference.
	 * @see #setOrigin(ArchitectureItem)
	 * @see org.m2ling.domain.core.CorePackage#getLink_Origin()
	 * @model required="true"
	 * @generated
	 */
	ArchitectureItem getOrigin();

	/**
	 * Sets the value of the '{@link org.m2ling.domain.core.Link#getOrigin <em>Origin</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Origin</em>' reference.
	 * @see #getOrigin()
	 * @generated
	 */
	void setOrigin(ArchitectureItem value);

	/**
	 * Returns the value of the '<em><b>Destination</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Destination</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Destination</em>' reference.
	 * @see #setDestination(ArchitectureItem)
	 * @see org.m2ling.domain.core.CorePackage#getLink_Destination()
	 * @model required="true"
	 * @generated
	 */
	ArchitectureItem getDestination();

	/**
	 * Sets the value of the '{@link org.m2ling.domain.core.Link#getDestination <em>Destination</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Destination</em>' reference.
	 * @see #getDestination()
	 * @generated
	 */
	void setDestination(ArchitectureItem value);

} // Link

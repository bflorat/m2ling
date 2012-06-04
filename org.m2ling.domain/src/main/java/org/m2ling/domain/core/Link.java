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
 *   <li>{@link org.m2ling.domain.core.Link#getOrigins <em>Origins</em>}</li>
 *   <li>{@link org.m2ling.domain.core.Link#getDestinations <em>Destinations</em>}</li>
 *   <li>{@link org.m2ling.domain.core.Link#getTimeoutMillis <em>Timeout Millis</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.m2ling.domain.core.CorePackage#getLink()
 * @model
 * @generated
 */
public interface Link extends ArchitectureItem {
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
	 * Returns the value of the '<em><b>Origins</b></em>' reference list.
	 * The list contents are of type {@link org.m2ling.domain.core.Component}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Origins</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Origins</em>' reference list.
	 * @see org.m2ling.domain.core.CorePackage#getLink_Origins()
	 * @model required="true"
	 * @generated
	 */
	EList<Component> getOrigins();

	/**
	 * Returns the value of the '<em><b>Destinations</b></em>' reference list.
	 * The list contents are of type {@link org.m2ling.domain.core.Component}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Destinations</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Destinations</em>' reference list.
	 * @see org.m2ling.domain.core.CorePackage#getLink_Destinations()
	 * @model required="true"
	 * @generated
	 */
	EList<Component> getDestinations();

	/**
	 * Returns the value of the '<em><b>Timeout Millis</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Timeout Millis</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Timeout Millis</em>' attribute.
	 * @see #setTimeoutMillis(long)
	 * @see org.m2ling.domain.core.CorePackage#getLink_TimeoutMillis()
	 * @model
	 * @generated
	 */
	long getTimeoutMillis();

	/**
	 * Sets the value of the '{@link org.m2ling.domain.core.Link#getTimeoutMillis <em>Timeout Millis</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Timeout Millis</em>' attribute.
	 * @see #getTimeoutMillis()
	 * @generated
	 */
	void setTimeoutMillis(long value);

} // Link

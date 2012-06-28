/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.domain.core;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Status Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.m2ling.domain.core.StatusEvent#getDate <em>Date</em>}</li>
 *   <li>{@link org.m2ling.domain.core.StatusEvent#getStatusLiteral <em>Status Literal</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.m2ling.domain.core.CorePackage#getStatusEvent()
 * @model
 * @generated
 */
public interface StatusEvent extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (C) 2012 Bertrand Florat";

	/**
	 * Returns the value of the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Date</em>' attribute.
	 * @see #setDate(long)
	 * @see org.m2ling.domain.core.CorePackage#getStatusEvent_Date()
	 * @model required="true"
	 * @generated
	 */
	long getDate();

	/**
	 * Sets the value of the '{@link org.m2ling.domain.core.StatusEvent#getDate <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Date</em>' attribute.
	 * @see #getDate()
	 * @generated
	 */
	void setDate(long value);

	/**
	 * Returns the value of the '<em><b>Status Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Status Literal</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Status Literal</em>' attribute.
	 * @see #setStatusLiteral(String)
	 * @see org.m2ling.domain.core.CorePackage#getStatusEvent_StatusLiteral()
	 * @model required="true"
	 * @generated
	 */
	String getStatusLiteral();

	/**
	 * Sets the value of the '{@link org.m2ling.domain.core.StatusEvent#getStatusLiteral <em>Status Literal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Status Literal</em>' attribute.
	 * @see #getStatusLiteral()
	 * @generated
	 */
	void setStatusLiteral(String value);

} // StatusEvent

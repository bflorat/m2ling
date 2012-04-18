/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.domain.core;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Authorization</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.m2ling.domain.core.Authorization#getType <em>Type</em>}</li>
 *   <li>{@link org.m2ling.domain.core.Authorization#getResource <em>Resource</em>}</li>
 *   <li>{@link org.m2ling.domain.core.Authorization#getStakeholders <em>Stakeholders</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.m2ling.domain.core.CorePackage#getAuthorization()
 * @model
 * @generated
 */
public interface Authorization extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (C) 2012 Bertrand Florat";

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.m2ling.domain.core.AutorizationType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see org.m2ling.domain.core.AutorizationType
	 * @see #setType(AutorizationType)
	 * @see org.m2ling.domain.core.CorePackage#getAuthorization_Type()
	 * @model
	 * @generated
	 */
	AutorizationType getType();

	/**
	 * Sets the value of the '{@link org.m2ling.domain.core.Authorization#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see org.m2ling.domain.core.AutorizationType
	 * @see #getType()
	 * @generated
	 */
	void setType(AutorizationType value);

	/**
	 * Returns the value of the '<em><b>Resource</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource</em>' reference.
	 * @see #setResource(ACResource)
	 * @see org.m2ling.domain.core.CorePackage#getAuthorization_Resource()
	 * @model required="true"
	 * @generated
	 */
	ACResource getResource();

	/**
	 * Sets the value of the '{@link org.m2ling.domain.core.Authorization#getResource <em>Resource</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resource</em>' reference.
	 * @see #getResource()
	 * @generated
	 */
	void setResource(ACResource value);

	/**
	 * Returns the value of the '<em><b>Stakeholders</b></em>' reference list.
	 * The list contents are of type {@link org.m2ling.domain.core.Stakeholder}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stakeholders</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stakeholders</em>' reference list.
	 * @see org.m2ling.domain.core.CorePackage#getAuthorization_Stakeholders()
	 * @model
	 * @generated
	 */
	EList<Stakeholder> getStakeholders();

} // Authorization

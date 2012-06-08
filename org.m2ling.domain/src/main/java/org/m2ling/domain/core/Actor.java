/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.domain.core;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Actor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.m2ling.domain.core.Actor#getStakeholders <em>Stakeholders</em>}</li>
 *   <li>{@link org.m2ling.domain.core.Actor#getUnit <em>Unit</em>}</li>
 *   <li>{@link org.m2ling.domain.core.Actor#getUsername <em>Username</em>}</li>
 *   <li>{@link org.m2ling.domain.core.Actor#isAdmin <em>Admin</em>}</li>
 *   <li>{@link org.m2ling.domain.core.Actor#getPwdHash <em>Pwd Hash</em>}</li>
 *   <li>{@link org.m2ling.domain.core.Actor#getFirstName <em>First Name</em>}</li>
 *   <li>{@link org.m2ling.domain.core.Actor#getLastName <em>Last Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.m2ling.domain.core.CorePackage#getActor()
 * @model
 * @generated
 */
public interface Actor extends HasCustomProperties, HasTags, HasDescription {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (C) 2012 Bertrand Florat";

	/**
	 * Returns the value of the '<em><b>Stakeholders</b></em>' reference list.
	 * The list contents are of type {@link org.m2ling.domain.core.Stakeholder}.
	 * It is bidirectional and its opposite is '{@link org.m2ling.domain.core.Stakeholder#getActors <em>Actors</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stakeholders</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stakeholders</em>' reference list.
	 * @see org.m2ling.domain.core.CorePackage#getActor_Stakeholders()
	 * @see org.m2ling.domain.core.Stakeholder#getActors
	 * @model opposite="actors"
	 * @generated
	 */
	EList<Stakeholder> getStakeholders();

	/**
	 * Returns the value of the '<em><b>Unit</b></em>' reference list.
	 * The list contents are of type {@link org.m2ling.domain.core.OrganisationalUnit}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit</em>' reference list.
	 * @see org.m2ling.domain.core.CorePackage#getActor_Unit()
	 * @model required="true"
	 * @generated
	 */
	EList<OrganisationalUnit> getUnit();

	/**
	 * Returns the value of the '<em><b>Username</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Username</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Username</em>' attribute.
	 * @see #setUsername(String)
	 * @see org.m2ling.domain.core.CorePackage#getActor_Username()
	 * @model id="true"
	 * @generated
	 */
	String getUsername();

	/**
	 * Sets the value of the '{@link org.m2ling.domain.core.Actor#getUsername <em>Username</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Username</em>' attribute.
	 * @see #getUsername()
	 * @generated
	 */
	void setUsername(String value);

	/**
	 * Returns the value of the '<em><b>Admin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Admin</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Admin</em>' attribute.
	 * @see #setAdmin(boolean)
	 * @see org.m2ling.domain.core.CorePackage#getActor_Admin()
	 * @model
	 * @generated
	 */
	boolean isAdmin();

	/**
	 * Sets the value of the '{@link org.m2ling.domain.core.Actor#isAdmin <em>Admin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Admin</em>' attribute.
	 * @see #isAdmin()
	 * @generated
	 */
	void setAdmin(boolean value);

	/**
	 * Returns the value of the '<em><b>Pwd Hash</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pwd Hash</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pwd Hash</em>' attribute.
	 * @see #setPwdHash(String)
	 * @see org.m2ling.domain.core.CorePackage#getActor_PwdHash()
	 * @model
	 * @generated
	 */
	String getPwdHash();

	/**
	 * Sets the value of the '{@link org.m2ling.domain.core.Actor#getPwdHash <em>Pwd Hash</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pwd Hash</em>' attribute.
	 * @see #getPwdHash()
	 * @generated
	 */
	void setPwdHash(String value);

	/**
	 * Returns the value of the '<em><b>First Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>First Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>First Name</em>' attribute.
	 * @see #setFirstName(String)
	 * @see org.m2ling.domain.core.CorePackage#getActor_FirstName()
	 * @model
	 * @generated
	 */
	String getFirstName();

	/**
	 * Sets the value of the '{@link org.m2ling.domain.core.Actor#getFirstName <em>First Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>First Name</em>' attribute.
	 * @see #getFirstName()
	 * @generated
	 */
	void setFirstName(String value);

	/**
	 * Returns the value of the '<em><b>Last Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Last Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Last Name</em>' attribute.
	 * @see #setLastName(String)
	 * @see org.m2ling.domain.core.CorePackage#getActor_LastName()
	 * @model
	 * @generated
	 */
	String getLastName();

	/**
	 * Sets the value of the '{@link org.m2ling.domain.core.Actor#getLastName <em>Last Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last Name</em>' attribute.
	 * @see #getLastName()
	 * @generated
	 */
	void setLastName(String value);

} // Actor

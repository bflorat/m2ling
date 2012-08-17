/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.domain.core;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.m2ling.domain.core.Rule#getPriority <em>Priority</em>}</li>
 *   <li>{@link org.m2ling.domain.core.Rule#getRationale <em>Rationale</em>}</li>
 *   <li>{@link org.m2ling.domain.core.Rule#getExceptions <em>Exceptions</em>}</li>
 *   <li>{@link org.m2ling.domain.core.Rule#getHistory <em>History</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.m2ling.domain.core.CorePackage#getRule()
 * @model
 * @generated
 */
public interface Rule extends HasNameAndID, HasCustomProperties, HasComment, HasTags, HasDescription, HasStatus {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (C) 2012 Bertrand Florat";

	/**
	 * Returns the value of the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Priority</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Priority</em>' attribute.
	 * @see #setPriority(int)
	 * @see org.m2ling.domain.core.CorePackage#getRule_Priority()
	 * @model
	 * @generated
	 */
	int getPriority();

	/**
	 * Sets the value of the '{@link org.m2ling.domain.core.Rule#getPriority <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Priority</em>' attribute.
	 * @see #getPriority()
	 * @generated
	 */
	void setPriority(int value);

	/**
	 * Returns the value of the '<em><b>Rationale</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rationale</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rationale</em>' attribute.
	 * @see #setRationale(String)
	 * @see org.m2ling.domain.core.CorePackage#getRule_Rationale()
	 * @model
	 * @generated
	 */
	String getRationale();

	/**
	 * Sets the value of the '{@link org.m2ling.domain.core.Rule#getRationale <em>Rationale</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rationale</em>' attribute.
	 * @see #getRationale()
	 * @generated
	 */
	void setRationale(String value);

	/**
	 * Returns the value of the '<em><b>Exceptions</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exceptions</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exceptions</em>' attribute.
	 * @see #setExceptions(String)
	 * @see org.m2ling.domain.core.CorePackage#getRule_Exceptions()
	 * @model
	 * @generated
	 */
	String getExceptions();

	/**
	 * Sets the value of the '{@link org.m2ling.domain.core.Rule#getExceptions <em>Exceptions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exceptions</em>' attribute.
	 * @see #getExceptions()
	 * @generated
	 */
	void setExceptions(String value);

	/**
	 * Returns the value of the '<em><b>History</b></em>' containment reference list.
	 * The list contents are of type {@link org.m2ling.domain.core.StatusEvent}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>History</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>History</em>' containment reference list.
	 * @see org.m2ling.domain.core.CorePackage#getRule_History()
	 * @model containment="true"
	 * @generated
	 */
	EList<StatusEvent> getHistory();

} // Rule

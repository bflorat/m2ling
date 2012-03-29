/**
 * Copyright (C) Bertrand Florat
 */
package org.m2ling.domain.principles;

import org.m2ling.domain.core.ConceptItem;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.m2ling.domain.principles.Rule#getStatus <em>Status</em>}</li>
 *   <li>{@link org.m2ling.domain.principles.Rule#getPriority <em>Priority</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.m2ling.domain.principles.PrinciplesPackage#getRule()
 * @model
 * @generated
 */
public interface Rule extends ConceptItem {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (C) Bertrand Florat";

	/**
	 * Returns the value of the '<em><b>Status</b></em>' attribute.
	 * The literals are from the enumeration {@link org.m2ling.domain.principles.RuleStatus}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Status</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Status</em>' attribute.
	 * @see org.m2ling.domain.principles.RuleStatus
	 * @see #setStatus(RuleStatus)
	 * @see org.m2ling.domain.principles.PrinciplesPackage#getRule_Status()
	 * @model
	 * @generated
	 */
	RuleStatus getStatus();

	/**
	 * Sets the value of the '{@link org.m2ling.domain.principles.Rule#getStatus <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Status</em>' attribute.
	 * @see org.m2ling.domain.principles.RuleStatus
	 * @see #getStatus()
	 * @generated
	 */
	void setStatus(RuleStatus value);

	/**
	 * Returns the value of the '<em><b>Priority</b></em>' attribute.
	 * The literals are from the enumeration {@link org.m2ling.domain.principles.Priority}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Priority</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Priority</em>' attribute.
	 * @see org.m2ling.domain.principles.Priority
	 * @see #setPriority(Priority)
	 * @see org.m2ling.domain.principles.PrinciplesPackage#getRule_Priority()
	 * @model
	 * @generated
	 */
	Priority getPriority();

	/**
	 * Sets the value of the '{@link org.m2ling.domain.principles.Rule#getPriority <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Priority</em>' attribute.
	 * @see org.m2ling.domain.principles.Priority
	 * @see #getPriority()
	 * @generated
	 */
	void setPriority(Priority value);

} // Rule

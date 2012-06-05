/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.domain.core;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.m2ling.domain.core.Rule#getPriority <em>Priority</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.m2ling.domain.core.CorePackage#getRule()
 * @model
 * @generated
 */
public interface Rule extends HasNameAndID, HasCustomProperties, HasComment, HasTags, HasLabel, HasStatus {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (C) 2012 Bertrand Florat";

	/**
	 * Returns the value of the '<em><b>Priority</b></em>' attribute.
	 * The literals are from the enumeration {@link org.m2ling.domain.core.RulePriority}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Priority</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Priority</em>' attribute.
	 * @see org.m2ling.domain.core.RulePriority
	 * @see #setPriority(RulePriority)
	 * @see org.m2ling.domain.core.CorePackage#getRule_Priority()
	 * @model
	 * @generated
	 */
	RulePriority getPriority();

	/**
	 * Sets the value of the '{@link org.m2ling.domain.core.Rule#getPriority <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Priority</em>' attribute.
	 * @see org.m2ling.domain.core.RulePriority
	 * @see #getPriority()
	 * @generated
	 */
	void setPriority(RulePriority value);

} // Rule

/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.domain.core;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Concept Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.m2ling.domain.core.ConceptItem#getStatus_literals <em>Status literals</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.m2ling.domain.core.CorePackage#getConceptItem()
 * @model abstract="true"
 * @generated
 */
public interface ConceptItem extends HasNameAndID, HasCustomProperties, HasComment, HasTags, HasParameterDefinitions, HasConstraints, HasLabel {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (C) 2012 Bertrand Florat";

	/**
	 * Returns the value of the '<em><b>Status literals</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Status literals</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Status literals</em>' attribute.
	 * @see #setStatus_literals(String)
	 * @see org.m2ling.domain.core.CorePackage#getConceptItem_Status_literals()
	 * @model required="true"
	 * @generated
	 */
	String getStatus_literals();

	/**
	 * Sets the value of the '{@link org.m2ling.domain.core.ConceptItem#getStatus_literals <em>Status literals</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Status literals</em>' attribute.
	 * @see #getStatus_literals()
	 * @generated
	 */
	void setStatus_literals(String value);

} // ConceptItem

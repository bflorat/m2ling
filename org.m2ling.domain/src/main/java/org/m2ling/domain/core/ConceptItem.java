/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.domain.core;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Concept Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.m2ling.domain.core.ConceptItem#getStatusLiterals <em>Status Literals</em>}</li>
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
	 * Returns the value of the '<em><b>Status Literals</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Status Literals</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Status Literals</em>' attribute list.
	 * @see org.m2ling.domain.core.CorePackage#getConceptItem_StatusLiterals()
	 * @model required="true"
	 * @generated
	 */
	EList<String> getStatusLiterals();

} // ConceptItem

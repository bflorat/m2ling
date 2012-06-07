/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.domain.core;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.m2ling.domain.core.Reference#getType <em>Type</em>}</li>
 *   <li>{@link org.m2ling.domain.core.Reference#getTargets <em>Targets</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.m2ling.domain.core.CorePackage#getReference()
 * @model
 * @generated
 */
public interface Reference extends HasComment, HasConstraints, HasCustomProperties, HasLabel, HasStatus, HasTags {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (C) 2012 Bertrand Florat";

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.m2ling.domain.core.ReferenceType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see org.m2ling.domain.core.ReferenceType
	 * @see #setType(ReferenceType)
	 * @see org.m2ling.domain.core.CorePackage#getReference_Type()
	 * @model
	 * @generated
	 */
	ReferenceType getType();

	/**
	 * Sets the value of the '{@link org.m2ling.domain.core.Reference#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see org.m2ling.domain.core.ReferenceType
	 * @see #getType()
	 * @generated
	 */
	void setType(ReferenceType value);

	/**
	 * Returns the value of the '<em><b>Targets</b></em>' reference list.
	 * The list contents are of type {@link org.m2ling.domain.core.HasReferences}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Targets</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Targets</em>' reference list.
	 * @see org.m2ling.domain.core.CorePackage#getReference_Targets()
	 * @model
	 * @generated
	 */
	EList<HasReferences> getTargets();

} // Reference

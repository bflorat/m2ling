/**
 * Copyright (C) Bertrand Florat
 */
package org.m2ling.domain.core;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Has Tags</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.m2ling.domain.core.HasTags#getTags <em>Tags</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.m2ling.domain.core.CorePackage#getHasTags()
 * @model abstract="true"
 * @generated
 */
public interface HasTags extends EObject {
	
	/** Tags separator **/
	char TAGS_SEPARATOR = ',';
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (C) Bertrand Florat";

	/**
	 * Returns the value of the '<em><b>Tags</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tags</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tags</em>' attribute.
	 * @see #setTags(String)
	 * @see org.m2ling.domain.core.CorePackage#getHasTags_Tags()
	 * @model default=""
	 * @generated
	 */
	String getTags();

	/**
	 * Sets the value of the '{@link org.m2ling.domain.core.HasTags#getTags <em>Tags</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tags</em>' attribute.
	 * @see #getTags()
	 * @generated
	 */
	void setTags(String value);

} // HasTags

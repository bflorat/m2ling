/**
 * Copyright (C) Bertrand Florat
 */
package org.m2ling.domain.core;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Has Custom Properties</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.m2ling.domain.core.HasCustomProperties#getCustomProperties <em>Custom Properties</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.m2ling.domain.core.CorePackage#getHasCustomProperties()
 * @model
 * @generated
 */
public interface HasCustomProperties extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (C) Bertrand Florat";

	/**
	 * Returns the value of the '<em><b>Custom Properties</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Custom Properties</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Custom Properties</em>' reference.
	 * @see #setCustomProperties(CustomProperty)
	 * @see org.m2ling.domain.core.CorePackage#getHasCustomProperties_CustomProperties()
	 * @model
	 * @generated
	 */
	CustomProperty getCustomProperties();

	/**
	 * Sets the value of the '{@link org.m2ling.domain.core.HasCustomProperties#getCustomProperties <em>Custom Properties</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Custom Properties</em>' reference.
	 * @see #getCustomProperties()
	 * @generated
	 */
	void setCustomProperties(CustomProperty value);

} // HasCustomProperties

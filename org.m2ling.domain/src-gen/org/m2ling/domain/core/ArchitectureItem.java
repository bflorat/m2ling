/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.m2ling.domain.core;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Architecture Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.m2ling.domain.core.ArchitectureItem#getVersion <em>Version</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.m2ling.domain.core.CorePackage#getArchitectureItem()
 * @model abstract="true"
 * @generated
 */
public interface ArchitectureItem extends HasName, HasParameterDefinitions {
	/**
	 * Returns the value of the '<em><b>Version</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Version</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Version</em>' attribute list.
	 * @see org.m2ling.domain.core.CorePackage#getArchitectureItem_Version()
	 * @model required="true"
	 * @generated
	 */
	EList<String> getVersion();

} // ArchitectureItem

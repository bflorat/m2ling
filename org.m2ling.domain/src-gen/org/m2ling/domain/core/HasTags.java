/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.m2ling.domain.core;

import org.eclipse.emf.common.util.EList;

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
 *   <li>{@link org.m2ling.domain.core.HasTags#getTagGroups <em>Tag Groups</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.m2ling.domain.core.CorePackage#getHasTags()
 * @model abstract="true"
 * @generated
 */
public interface HasTags extends EObject {
	/**
	 * Returns the value of the '<em><b>Tags</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tags</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tags</em>' reference.
	 * @see #setTags(Tag)
	 * @see org.m2ling.domain.core.CorePackage#getHasTags_Tags()
	 * @model
	 * @generated
	 */
	Tag getTags();

	/**
	 * Sets the value of the '{@link org.m2ling.domain.core.HasTags#getTags <em>Tags</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tags</em>' reference.
	 * @see #getTags()
	 * @generated
	 */
	void setTags(Tag value);

	/**
	 * Returns the value of the '<em><b>Tag Groups</b></em>' reference list.
	 * The list contents are of type {@link org.m2ling.domain.core.TagGroup}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tag Groups</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tag Groups</em>' reference list.
	 * @see org.m2ling.domain.core.CorePackage#getHasTags_TagGroups()
	 * @model required="true"
	 * @generated
	 */
	EList<TagGroup> getTagGroups();

} // HasTags

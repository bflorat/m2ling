/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.domain.core;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Link Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.m2ling.domain.core.LinkType#getSourceTypes <em>Source Types</em>}</li>
 *   <li>{@link org.m2ling.domain.core.LinkType#getDestinationTypes <em>Destination Types</em>}</li>
 *   <li>{@link org.m2ling.domain.core.LinkType#getLinkAccessType <em>Link Access Type</em>}</li>
 *   <li>{@link org.m2ling.domain.core.LinkType#getLinkTemporality <em>Link Temporality</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.m2ling.domain.core.CorePackage#getLinkType()
 * @model
 * @generated
 */
public interface LinkType extends ConceptItem {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (C) 2012 Bertrand Florat";

	/**
	 * Returns the value of the '<em><b>Source Types</b></em>' reference list.
	 * The list contents are of type {@link org.m2ling.domain.core.ComponentType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Types</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Types</em>' reference list.
	 * @see org.m2ling.domain.core.CorePackage#getLinkType_SourceTypes()
	 * @model required="true"
	 * @generated
	 */
	EList<ComponentType> getSourceTypes();

	/**
	 * Returns the value of the '<em><b>Destination Types</b></em>' reference list.
	 * The list contents are of type {@link org.m2ling.domain.core.ComponentType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Destination Types</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Destination Types</em>' reference list.
	 * @see org.m2ling.domain.core.CorePackage#getLinkType_DestinationTypes()
	 * @model required="true"
	 * @generated
	 */
	EList<ComponentType> getDestinationTypes();

	/**
	 * Returns the value of the '<em><b>Link Access Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.m2ling.domain.core.LinkAccessType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Link Access Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link Access Type</em>' attribute.
	 * @see org.m2ling.domain.core.LinkAccessType
	 * @see #setLinkAccessType(LinkAccessType)
	 * @see org.m2ling.domain.core.CorePackage#getLinkType_LinkAccessType()
	 * @model
	 * @generated
	 */
	LinkAccessType getLinkAccessType();

	/**
	 * Sets the value of the '{@link org.m2ling.domain.core.LinkType#getLinkAccessType <em>Link Access Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link Access Type</em>' attribute.
	 * @see org.m2ling.domain.core.LinkAccessType
	 * @see #getLinkAccessType()
	 * @generated
	 */
	void setLinkAccessType(LinkAccessType value);

	/**
	 * Returns the value of the '<em><b>Link Temporality</b></em>' attribute.
	 * The literals are from the enumeration {@link org.m2ling.domain.core.LinkTemporality}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Link Temporality</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link Temporality</em>' attribute.
	 * @see org.m2ling.domain.core.LinkTemporality
	 * @see #setLinkTemporality(LinkTemporality)
	 * @see org.m2ling.domain.core.CorePackage#getLinkType_LinkTemporality()
	 * @model
	 * @generated
	 */
	LinkTemporality getLinkTemporality();

	/**
	 * Sets the value of the '{@link org.m2ling.domain.core.LinkType#getLinkTemporality <em>Link Temporality</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link Temporality</em>' attribute.
	 * @see org.m2ling.domain.core.LinkTemporality
	 * @see #getLinkTemporality()
	 * @generated
	 */
	void setLinkTemporality(LinkTemporality value);

} // LinkType

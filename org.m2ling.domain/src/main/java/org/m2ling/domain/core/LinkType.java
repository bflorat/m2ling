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
 *   <li>{@link org.m2ling.domain.core.LinkType#isReifiable <em>Reifiable</em>}</li>
 *   <li>{@link org.m2ling.domain.core.LinkType#getAccessType <em>Access Type</em>}</li>
 *   <li>{@link org.m2ling.domain.core.LinkType#getTemporality <em>Temporality</em>}</li>
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
	 * Returns the value of the '<em><b>Reifiable</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reifiable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reifiable</em>' attribute.
	 * @see #setReifiable(boolean)
	 * @see org.m2ling.domain.core.CorePackage#getLinkType_Reifiable()
	 * @model default="false"
	 * @generated
	 */
	boolean isReifiable();

	/**
	 * Sets the value of the '{@link org.m2ling.domain.core.LinkType#isReifiable <em>Reifiable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reifiable</em>' attribute.
	 * @see #isReifiable()
	 * @generated
	 */
	void setReifiable(boolean value);

	/**
	 * Returns the value of the '<em><b>Access Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.m2ling.domain.core.LinkAccessType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Access Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Access Type</em>' attribute.
	 * @see org.m2ling.domain.core.LinkAccessType
	 * @see #setAccessType(LinkAccessType)
	 * @see org.m2ling.domain.core.CorePackage#getLinkType_AccessType()
	 * @model
	 * @generated
	 */
	LinkAccessType getAccessType();

	/**
	 * Sets the value of the '{@link org.m2ling.domain.core.LinkType#getAccessType <em>Access Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Access Type</em>' attribute.
	 * @see org.m2ling.domain.core.LinkAccessType
	 * @see #getAccessType()
	 * @generated
	 */
	void setAccessType(LinkAccessType value);

	/**
	 * Returns the value of the '<em><b>Temporality</b></em>' attribute.
	 * The literals are from the enumeration {@link org.m2ling.domain.core.LinkTemporality}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Temporality</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Temporality</em>' attribute.
	 * @see org.m2ling.domain.core.LinkTemporality
	 * @see #setTemporality(LinkTemporality)
	 * @see org.m2ling.domain.core.CorePackage#getLinkType_Temporality()
	 * @model
	 * @generated
	 */
	LinkTemporality getTemporality();

	/**
	 * Sets the value of the '{@link org.m2ling.domain.core.LinkType#getTemporality <em>Temporality</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Temporality</em>' attribute.
	 * @see org.m2ling.domain.core.LinkTemporality
	 * @see #getTemporality()
	 * @generated
	 */
	void setTemporality(LinkTemporality value);

} // LinkType

/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.domain.core;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Instances Link</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.m2ling.domain.core.InstancesLink#getSource <em>Source</em>}</li>
 *   <li>{@link org.m2ling.domain.core.InstancesLink#getDestination <em>Destination</em>}</li>
 *   <li>{@link org.m2ling.domain.core.InstancesLink#getLink <em>Link</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.m2ling.domain.core.CorePackage#getInstancesLink()
 * @model
 * @generated
 */
public interface InstancesLink extends RuntimeItem {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (C) 2012 Bertrand Florat";

	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(ComponentInstance)
	 * @see org.m2ling.domain.core.CorePackage#getInstancesLink_Source()
	 * @model required="true"
	 * @generated
	 */
	ComponentInstance getSource();

	/**
	 * Sets the value of the '{@link org.m2ling.domain.core.InstancesLink#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(ComponentInstance value);

	/**
	 * Returns the value of the '<em><b>Destination</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Destination</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Destination</em>' reference.
	 * @see #setDestination(ComponentInstance)
	 * @see org.m2ling.domain.core.CorePackage#getInstancesLink_Destination()
	 * @model required="true"
	 * @generated
	 */
	ComponentInstance getDestination();

	/**
	 * Sets the value of the '{@link org.m2ling.domain.core.InstancesLink#getDestination <em>Destination</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Destination</em>' reference.
	 * @see #getDestination()
	 * @generated
	 */
	void setDestination(ComponentInstance value);

	/**
	 * Returns the value of the '<em><b>Link</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Link</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link</em>' reference.
	 * @see #setLink(Link)
	 * @see org.m2ling.domain.core.CorePackage#getInstancesLink_Link()
	 * @model required="true"
	 * @generated
	 */
	Link getLink();

	/**
	 * Sets the value of the '{@link org.m2ling.domain.core.InstancesLink#getLink <em>Link</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link</em>' reference.
	 * @see #getLink()
	 * @generated
	 */
	void setLink(Link value);

} // InstancesLink

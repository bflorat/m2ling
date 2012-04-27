/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.domain.core;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>View Point</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.m2ling.domain.core.ViewPoint#getComponentTypes <em>Component Types</em>}</li>
 *   <li>{@link org.m2ling.domain.core.ViewPoint#getActivities <em>Activities</em>}</li>
 *   <li>{@link org.m2ling.domain.core.ViewPoint#getBaseViewpoint <em>Base Viewpoint</em>}</li>
 *   <li>{@link org.m2ling.domain.core.ViewPoint#getName <em>Name</em>}</li>
 *   <li>{@link org.m2ling.domain.core.ViewPoint#getLinkTypes <em>Link Types</em>}</li>
 *   <li>{@link org.m2ling.domain.core.ViewPoint#getRules <em>Rules</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.m2ling.domain.core.CorePackage#getViewPoint()
 * @model
 * @generated
 */
public interface ViewPoint extends ConceptItem {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (C) 2012 Bertrand Florat";

	/**
	 * Returns the value of the '<em><b>Component Types</b></em>' containment reference list.
	 * The list contents are of type {@link org.m2ling.domain.core.ComponentType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Component Types</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Component Types</em>' containment reference list.
	 * @see org.m2ling.domain.core.CorePackage#getViewPoint_ComponentTypes()
	 * @model containment="true"
	 * @generated
	 */
	EList<ComponentType> getComponentTypes();

	/**
	 * Returns the value of the '<em><b>Activities</b></em>' containment reference list.
	 * The list contents are of type {@link org.m2ling.domain.core.Activity}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Activities</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Activities</em>' containment reference list.
	 * @see org.m2ling.domain.core.CorePackage#getViewPoint_Activities()
	 * @model containment="true" keys="iD"
	 * @generated
	 */
	EList<Activity> getActivities();

	/**
	 * Returns the value of the '<em><b>Base Viewpoint</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Viewpoint</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Viewpoint</em>' reference.
	 * @see #setBaseViewpoint(ViewPoint)
	 * @see org.m2ling.domain.core.CorePackage#getViewPoint_BaseViewpoint()
	 * @model
	 * @generated
	 */
	ViewPoint getBaseViewpoint();

	/**
	 * Sets the value of the '{@link org.m2ling.domain.core.ViewPoint#getBaseViewpoint <em>Base Viewpoint</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Viewpoint</em>' reference.
	 * @see #getBaseViewpoint()
	 * @generated
	 */
	void setBaseViewpoint(ViewPoint value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.m2ling.domain.core.CorePackage#getViewPoint_Name()
	 * @model id="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.m2ling.domain.core.ViewPoint#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Link Types</b></em>' containment reference list.
	 * The list contents are of type {@link org.m2ling.domain.core.LinkType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Link Types</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link Types</em>' containment reference list.
	 * @see org.m2ling.domain.core.CorePackage#getViewPoint_LinkTypes()
	 * @model containment="true"
	 * @generated
	 */
	EList<LinkType> getLinkTypes();

	/**
	 * Returns the value of the '<em><b>Rules</b></em>' containment reference list.
	 * The list contents are of type {@link org.m2ling.domain.core.Rule}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rules</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rules</em>' containment reference list.
	 * @see org.m2ling.domain.core.CorePackage#getViewPoint_Rules()
	 * @model containment="true"
	 * @generated
	 */
	EList<Rule> getRules();

} // ViewPoint

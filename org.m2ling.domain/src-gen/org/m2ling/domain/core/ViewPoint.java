/**
 * Copyright (C) Bertrand Florat
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
 * </ul>
 * </p>
 *
 * @see org.m2ling.domain.core.CorePackage#getViewPoint()
 * @model
 * @generated
 */
public interface ViewPoint extends ConceptItem, ACResource {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (C) Bertrand Florat";

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
	 * Returns the value of the '<em><b>Activities</b></em>' reference list.
	 * The list contents are of type {@link org.m2ling.domain.core.Activity}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Activities</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Activities</em>' reference list.
	 * @see org.m2ling.domain.core.CorePackage#getViewPoint_Activities()
	 * @model
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

} // ViewPoint

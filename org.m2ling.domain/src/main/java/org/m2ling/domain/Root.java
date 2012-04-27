/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.domain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.m2ling.domain.core.View;
import org.m2ling.domain.core.ViewPoint;
import org.m2ling.domain.parameters.ParameterDefinition;
import org.m2ling.domain.parameters.ParameterValue;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.m2ling.domain.Root#getViewPoints <em>View Points</em>}</li>
 *   <li>{@link org.m2ling.domain.Root#getViews <em>Views</em>}</li>
 *   <li>{@link org.m2ling.domain.Root#getParamDefinitions <em>Param Definitions</em>}</li>
 *   <li>{@link org.m2ling.domain.Root#getParamValues <em>Param Values</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.m2ling.domain.DomainPackage#getRoot()
 * @model
 * @generated
 */
public interface Root extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (C) 2012 Bertrand Florat";

	/**
	 * Returns the value of the '<em><b>View Points</b></em>' containment reference list.
	 * The list contents are of type {@link org.m2ling.domain.core.ViewPoint}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>View Points</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>View Points</em>' containment reference list.
	 * @see org.m2ling.domain.DomainPackage#getRoot_ViewPoints()
	 * @model containment="true"
	 * @generated
	 */
	EList<ViewPoint> getViewPoints();

	/**
	 * Returns the value of the '<em><b>Views</b></em>' containment reference list.
	 * The list contents are of type {@link org.m2ling.domain.core.View}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Views</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Views</em>' containment reference list.
	 * @see org.m2ling.domain.DomainPackage#getRoot_Views()
	 * @model containment="true"
	 * @generated
	 */
	EList<View> getViews();

	/**
	 * Returns the value of the '<em><b>Param Definitions</b></em>' containment reference list.
	 * The list contents are of type {@link org.m2ling.domain.parameters.ParameterDefinition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Param Definitions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Param Definitions</em>' containment reference list.
	 * @see org.m2ling.domain.DomainPackage#getRoot_ParamDefinitions()
	 * @model containment="true"
	 * @generated
	 */
	EList<ParameterDefinition> getParamDefinitions();

	/**
	 * Returns the value of the '<em><b>Param Values</b></em>' containment reference list.
	 * The list contents are of type {@link org.m2ling.domain.parameters.ParameterValue}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Param Values</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Param Values</em>' containment reference list.
	 * @see org.m2ling.domain.DomainPackage#getRoot_ParamValues()
	 * @model containment="true"
	 * @generated
	 */
	EList<ParameterValue> getParamValues();

} // Root

/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.domain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.m2ling.domain.core.Actor;
import org.m2ling.domain.core.OrganisationalUnit;
import org.m2ling.domain.core.Stakeholder;
import org.m2ling.domain.core.View;
import org.m2ling.domain.core.ViewPoint;
import org.m2ling.domain.configuration.RootConfiguration;
import org.m2ling.domain.configuration.ParameterDefinition;
import org.m2ling.domain.configuration.ParameterValue;

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
 *   <li>{@link org.m2ling.domain.Root#getStakeholders <em>Stakeholders</em>}</li>
 *   <li>{@link org.m2ling.domain.Root#getUnits <em>Units</em>}</li>
 *   <li>{@link org.m2ling.domain.Root#getActors <em>Actors</em>}</li>
 *   <li>{@link org.m2ling.domain.Root#getConfiguration <em>Configuration</em>}</li>
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
	 * Returns the value of the '<em><b>Stakeholders</b></em>' containment reference list.
	 * The list contents are of type {@link org.m2ling.domain.core.Stakeholder}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stakeholders</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stakeholders</em>' containment reference list.
	 * @see org.m2ling.domain.DomainPackage#getRoot_Stakeholders()
	 * @model containment="true"
	 * @generated
	 */
	EList<Stakeholder> getStakeholders();

	/**
	 * Returns the value of the '<em><b>Units</b></em>' containment reference list.
	 * The list contents are of type {@link org.m2ling.domain.core.OrganisationalUnit}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Units</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Units</em>' containment reference list.
	 * @see org.m2ling.domain.DomainPackage#getRoot_Units()
	 * @model containment="true"
	 * @generated
	 */
	EList<OrganisationalUnit> getUnits();

	/**
	 * Returns the value of the '<em><b>Actors</b></em>' containment reference list.
	 * The list contents are of type {@link org.m2ling.domain.core.Actor}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actors</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actors</em>' containment reference list.
	 * @see org.m2ling.domain.DomainPackage#getRoot_Actors()
	 * @model containment="true"
	 * @generated
	 */
	EList<Actor> getActors();

	/**
	 * Returns the value of the '<em><b>Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Configuration</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Configuration</em>' containment reference.
	 * @see #setConfiguration(RootConfiguration)
	 * @see org.m2ling.domain.DomainPackage#getRoot_Configuration()
	 * @model containment="true"
	 * @generated
	 */
	RootConfiguration getConfiguration();

	/**
	 * Sets the value of the '{@link org.m2ling.domain.Root#getConfiguration <em>Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Configuration</em>' containment reference.
	 * @see #getConfiguration()
	 * @generated
	 */
	void setConfiguration(RootConfiguration value);

} // Root

/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.domain.configuration;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Root Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.m2ling.domain.configuration.RootConfiguration#getDefinitions <em>Definitions</em>}</li>
 *   <li>{@link org.m2ling.domain.configuration.RootConfiguration#getValues <em>Values</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.m2ling.domain.configuration.ConfigurationPackage#getRootConfiguration()
 * @model
 * @generated
 */
public interface RootConfiguration extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (C) 2012 Bertrand Florat";

	/**
	 * Returns the value of the '<em><b>Definitions</b></em>' containment reference list.
	 * The list contents are of type {@link org.m2ling.domain.configuration.ParameterDefinition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Definitions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Definitions</em>' containment reference list.
	 * @see org.m2ling.domain.configuration.ConfigurationPackage#getRootConfiguration_Definitions()
	 * @model containment="true"
	 * @generated
	 */
	EList<ParameterDefinition> getDefinitions();

	/**
	 * Returns the value of the '<em><b>Values</b></em>' containment reference list.
	 * The list contents are of type {@link org.m2ling.domain.configuration.ParameterValue}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Values</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Values</em>' containment reference list.
	 * @see org.m2ling.domain.configuration.ConfigurationPackage#getRootConfiguration_Values()
	 * @model containment="true"
	 * @generated
	 */
	EList<ParameterValue> getValues();

} // RootConfiguration

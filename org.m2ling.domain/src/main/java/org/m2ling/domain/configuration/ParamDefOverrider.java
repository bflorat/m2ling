/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.domain.configuration;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Param Def Overrider</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.m2ling.domain.configuration.ParamDefOverrider#getOverridedFeature <em>Overrided Feature</em>}</li>
 *   <li>{@link org.m2ling.domain.configuration.ParamDefOverrider#getEnvironment <em>Environment</em>}</li>
 *   <li>{@link org.m2ling.domain.configuration.ParamDefOverrider#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.m2ling.domain.configuration.ConfigurationPackage#getParamDefOverrider()
 * @model
 * @generated
 */
public interface ParamDefOverrider extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (C) 2012 Bertrand Florat";

	/**
	 * Returns the value of the '<em><b>Overrided Feature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Overrided Feature</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Overrided Feature</em>' attribute.
	 * @see #setOverridedFeature(EStructuralFeature)
	 * @see org.m2ling.domain.configuration.ConfigurationPackage#getParamDefOverrider_OverridedFeature()
	 * @model dataType="org.m2ling.domain.configuration.EStructuralFeature"
	 * @generated
	 */
	EStructuralFeature getOverridedFeature();

	/**
	 * Sets the value of the '{@link org.m2ling.domain.configuration.ParamDefOverrider#getOverridedFeature <em>Overrided Feature</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Overrided Feature</em>' attribute.
	 * @see #getOverridedFeature()
	 * @generated
	 */
	void setOverridedFeature(EStructuralFeature value);

	/**
	 * Returns the value of the '<em><b>Environment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Environment</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Environment</em>' attribute.
	 * @see #setEnvironment(String)
	 * @see org.m2ling.domain.configuration.ConfigurationPackage#getParamDefOverrider_Environment()
	 * @model
	 * @generated
	 */
	String getEnvironment();

	/**
	 * Sets the value of the '{@link org.m2ling.domain.configuration.ParamDefOverrider#getEnvironment <em>Environment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Environment</em>' attribute.
	 * @see #getEnvironment()
	 * @generated
	 */
	void setEnvironment(String value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see org.m2ling.domain.configuration.ConfigurationPackage#getParamDefOverrider_Value()
	 * @model
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link org.m2ling.domain.configuration.ParamDefOverrider#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

} // ParamDefOverrider

/**
 * Copyright (C) Bertrand Florat
 */
package org.m2ling.domain.parameters.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.m2ling.domain.parameters.ParamDefOverrider;
import org.m2ling.domain.parameters.ParametersPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Param Def Overrider</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.m2ling.domain.parameters.impl.ParamDefOverriderImpl#getOverridedFeature <em>Overrided Feature</em>}</li>
 *   <li>{@link org.m2ling.domain.parameters.impl.ParamDefOverriderImpl#getEnvironment <em>Environment</em>}</li>
 *   <li>{@link org.m2ling.domain.parameters.impl.ParamDefOverriderImpl#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ParamDefOverriderImpl extends EObjectImpl implements ParamDefOverrider {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (C) Bertrand Florat";

	/**
	 * The default value of the '{@link #getOverridedFeature() <em>Overrided Feature</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOverridedFeature()
	 * @generated
	 * @ordered
	 */
	protected static final EStructuralFeature OVERRIDED_FEATURE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOverridedFeature() <em>Overrided Feature</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOverridedFeature()
	 * @generated
	 * @ordered
	 */
	protected EStructuralFeature overridedFeature = OVERRIDED_FEATURE_EDEFAULT;

	/**
	 * The default value of the '{@link #getEnvironment() <em>Environment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnvironment()
	 * @generated
	 * @ordered
	 */
	protected static final String ENVIRONMENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEnvironment() <em>Environment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnvironment()
	 * @generated
	 * @ordered
	 */
	protected String environment = ENVIRONMENT_EDEFAULT;

	/**
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected static final String VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected String value = VALUE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ParamDefOverriderImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ParametersPackage.Literals.PARAM_DEF_OVERRIDER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EStructuralFeature getOverridedFeature() {
		return overridedFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOverridedFeature(EStructuralFeature newOverridedFeature) {
		EStructuralFeature oldOverridedFeature = overridedFeature;
		overridedFeature = newOverridedFeature;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ParametersPackage.PARAM_DEF_OVERRIDER__OVERRIDED_FEATURE, oldOverridedFeature, overridedFeature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEnvironment() {
		return environment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnvironment(String newEnvironment) {
		String oldEnvironment = environment;
		environment = newEnvironment;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ParametersPackage.PARAM_DEF_OVERRIDER__ENVIRONMENT, oldEnvironment, environment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(String newValue) {
		String oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ParametersPackage.PARAM_DEF_OVERRIDER__VALUE, oldValue, value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ParametersPackage.PARAM_DEF_OVERRIDER__OVERRIDED_FEATURE:
				return getOverridedFeature();
			case ParametersPackage.PARAM_DEF_OVERRIDER__ENVIRONMENT:
				return getEnvironment();
			case ParametersPackage.PARAM_DEF_OVERRIDER__VALUE:
				return getValue();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ParametersPackage.PARAM_DEF_OVERRIDER__OVERRIDED_FEATURE:
				setOverridedFeature((EStructuralFeature)newValue);
				return;
			case ParametersPackage.PARAM_DEF_OVERRIDER__ENVIRONMENT:
				setEnvironment((String)newValue);
				return;
			case ParametersPackage.PARAM_DEF_OVERRIDER__VALUE:
				setValue((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ParametersPackage.PARAM_DEF_OVERRIDER__OVERRIDED_FEATURE:
				setOverridedFeature(OVERRIDED_FEATURE_EDEFAULT);
				return;
			case ParametersPackage.PARAM_DEF_OVERRIDER__ENVIRONMENT:
				setEnvironment(ENVIRONMENT_EDEFAULT);
				return;
			case ParametersPackage.PARAM_DEF_OVERRIDER__VALUE:
				setValue(VALUE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ParametersPackage.PARAM_DEF_OVERRIDER__OVERRIDED_FEATURE:
				return OVERRIDED_FEATURE_EDEFAULT == null ? overridedFeature != null : !OVERRIDED_FEATURE_EDEFAULT.equals(overridedFeature);
			case ParametersPackage.PARAM_DEF_OVERRIDER__ENVIRONMENT:
				return ENVIRONMENT_EDEFAULT == null ? environment != null : !ENVIRONMENT_EDEFAULT.equals(environment);
			case ParametersPackage.PARAM_DEF_OVERRIDER__VALUE:
				return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (overridedFeature: ");
		result.append(overridedFeature);
		result.append(", environment: ");
		result.append(environment);
		result.append(", value: ");
		result.append(value);
		result.append(')');
		return result.toString();
	}

} //ParamDefOverriderImpl

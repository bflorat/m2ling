/**
 * <copyright>
 * </copyright>
 *
 * $Id$
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
 *   <li>{@link org.m2ling.domain.parameters.impl.ParamDefOverriderImpl#getProfile <em>Profile</em>}</li>
 *   <li>{@link org.m2ling.domain.parameters.impl.ParamDefOverriderImpl#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ParamDefOverriderImpl extends EObjectImpl implements ParamDefOverrider {
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
	 * The default value of the '{@link #getProfile() <em>Profile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProfile()
	 * @generated
	 * @ordered
	 */
	protected static final String PROFILE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProfile() <em>Profile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProfile()
	 * @generated
	 * @ordered
	 */
	protected String profile = PROFILE_EDEFAULT;

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
	public String getProfile() {
		return profile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProfile(String newProfile) {
		String oldProfile = profile;
		profile = newProfile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ParametersPackage.PARAM_DEF_OVERRIDER__PROFILE, oldProfile, profile));
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
			case ParametersPackage.PARAM_DEF_OVERRIDER__PROFILE:
				return getProfile();
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
			case ParametersPackage.PARAM_DEF_OVERRIDER__PROFILE:
				setProfile((String)newValue);
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
			case ParametersPackage.PARAM_DEF_OVERRIDER__PROFILE:
				setProfile(PROFILE_EDEFAULT);
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
			case ParametersPackage.PARAM_DEF_OVERRIDER__PROFILE:
				return PROFILE_EDEFAULT == null ? profile != null : !PROFILE_EDEFAULT.equals(profile);
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
		result.append(", profile: ");
		result.append(profile);
		result.append(", value: ");
		result.append(value);
		result.append(')');
		return result.toString();
	}

} //ParamDefOverriderImpl

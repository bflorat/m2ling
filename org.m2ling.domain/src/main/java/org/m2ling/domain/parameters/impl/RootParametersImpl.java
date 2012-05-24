/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.domain.parameters.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.m2ling.domain.parameters.ParameterDefinition;
import org.m2ling.domain.parameters.ParameterValue;
import org.m2ling.domain.parameters.ParametersPackage;
import org.m2ling.domain.parameters.RootParameters;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Root Parameters</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.m2ling.domain.parameters.impl.RootParametersImpl#getDefinitions <em>Definitions</em>}</li>
 *   <li>{@link org.m2ling.domain.parameters.impl.RootParametersImpl#getValues <em>Values</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RootParametersImpl extends EObjectImpl implements RootParameters {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (C) 2012 Bertrand Florat";

	/**
	 * The cached value of the '{@link #getDefinitions() <em>Definitions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefinitions()
	 * @generated
	 * @ordered
	 */
	protected EList<ParameterDefinition> definitions;

	/**
	 * The cached value of the '{@link #getValues() <em>Values</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValues()
	 * @generated
	 * @ordered
	 */
	protected EList<ParameterValue> values;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RootParametersImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ParametersPackage.Literals.ROOT_PARAMETERS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ParameterDefinition> getDefinitions() {
		if (definitions == null) {
			definitions = new EObjectContainmentEList<ParameterDefinition>(ParameterDefinition.class, this, ParametersPackage.ROOT_PARAMETERS__DEFINITIONS);
		}
		return definitions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ParameterValue> getValues() {
		if (values == null) {
			values = new EObjectContainmentEList<ParameterValue>(ParameterValue.class, this, ParametersPackage.ROOT_PARAMETERS__VALUES);
		}
		return values;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ParametersPackage.ROOT_PARAMETERS__DEFINITIONS:
				return ((InternalEList<?>)getDefinitions()).basicRemove(otherEnd, msgs);
			case ParametersPackage.ROOT_PARAMETERS__VALUES:
				return ((InternalEList<?>)getValues()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ParametersPackage.ROOT_PARAMETERS__DEFINITIONS:
				return getDefinitions();
			case ParametersPackage.ROOT_PARAMETERS__VALUES:
				return getValues();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ParametersPackage.ROOT_PARAMETERS__DEFINITIONS:
				getDefinitions().clear();
				getDefinitions().addAll((Collection<? extends ParameterDefinition>)newValue);
				return;
			case ParametersPackage.ROOT_PARAMETERS__VALUES:
				getValues().clear();
				getValues().addAll((Collection<? extends ParameterValue>)newValue);
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
			case ParametersPackage.ROOT_PARAMETERS__DEFINITIONS:
				getDefinitions().clear();
				return;
			case ParametersPackage.ROOT_PARAMETERS__VALUES:
				getValues().clear();
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
			case ParametersPackage.ROOT_PARAMETERS__DEFINITIONS:
				return definitions != null && !definitions.isEmpty();
			case ParametersPackage.ROOT_PARAMETERS__VALUES:
				return values != null && !values.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //RootParametersImpl

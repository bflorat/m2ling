/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.domain.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.m2ling.domain.DomainPackage;
import org.m2ling.domain.Root;
import org.m2ling.domain.core.View;
import org.m2ling.domain.core.ViewPoint;
import org.m2ling.domain.parameters.ParameterDefinition;
import org.m2ling.domain.parameters.ParameterValue;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.m2ling.domain.impl.RootImpl#getViewPoints <em>View Points</em>}</li>
 *   <li>{@link org.m2ling.domain.impl.RootImpl#getViews <em>Views</em>}</li>
 *   <li>{@link org.m2ling.domain.impl.RootImpl#getParamDefinitions <em>Param Definitions</em>}</li>
 *   <li>{@link org.m2ling.domain.impl.RootImpl#getParamValues <em>Param Values</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RootImpl extends EObjectImpl implements Root {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (C) 2012 Bertrand Florat";

	/**
	 * The cached value of the '{@link #getViewPoints() <em>View Points</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getViewPoints()
	 * @generated
	 * @ordered
	 */
	protected EList<ViewPoint> viewPoints;

	/**
	 * The cached value of the '{@link #getViews() <em>Views</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getViews()
	 * @generated
	 * @ordered
	 */
	protected EList<View> views;

	/**
	 * The cached value of the '{@link #getParamDefinitions() <em>Param Definitions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParamDefinitions()
	 * @generated
	 * @ordered
	 */
	protected EList<ParameterDefinition> paramDefinitions;

	/**
	 * The cached value of the '{@link #getParamValues() <em>Param Values</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParamValues()
	 * @generated
	 * @ordered
	 */
	protected EList<ParameterValue> paramValues;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RootImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DomainPackage.Literals.ROOT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ViewPoint> getViewPoints() {
		if (viewPoints == null) {
			viewPoints = new EObjectContainmentEList<ViewPoint>(ViewPoint.class, this, DomainPackage.ROOT__VIEW_POINTS);
		}
		return viewPoints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<View> getViews() {
		if (views == null) {
			views = new EObjectContainmentEList<View>(View.class, this, DomainPackage.ROOT__VIEWS);
		}
		return views;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ParameterDefinition> getParamDefinitions() {
		if (paramDefinitions == null) {
			paramDefinitions = new EObjectContainmentEList<ParameterDefinition>(ParameterDefinition.class, this, DomainPackage.ROOT__PARAM_DEFINITIONS);
		}
		return paramDefinitions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ParameterValue> getParamValues() {
		if (paramValues == null) {
			paramValues = new EObjectContainmentEList<ParameterValue>(ParameterValue.class, this, DomainPackage.ROOT__PARAM_VALUES);
		}
		return paramValues;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DomainPackage.ROOT__VIEW_POINTS:
				return ((InternalEList<?>)getViewPoints()).basicRemove(otherEnd, msgs);
			case DomainPackage.ROOT__VIEWS:
				return ((InternalEList<?>)getViews()).basicRemove(otherEnd, msgs);
			case DomainPackage.ROOT__PARAM_DEFINITIONS:
				return ((InternalEList<?>)getParamDefinitions()).basicRemove(otherEnd, msgs);
			case DomainPackage.ROOT__PARAM_VALUES:
				return ((InternalEList<?>)getParamValues()).basicRemove(otherEnd, msgs);
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
			case DomainPackage.ROOT__VIEW_POINTS:
				return getViewPoints();
			case DomainPackage.ROOT__VIEWS:
				return getViews();
			case DomainPackage.ROOT__PARAM_DEFINITIONS:
				return getParamDefinitions();
			case DomainPackage.ROOT__PARAM_VALUES:
				return getParamValues();
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
			case DomainPackage.ROOT__VIEW_POINTS:
				getViewPoints().clear();
				getViewPoints().addAll((Collection<? extends ViewPoint>)newValue);
				return;
			case DomainPackage.ROOT__VIEWS:
				getViews().clear();
				getViews().addAll((Collection<? extends View>)newValue);
				return;
			case DomainPackage.ROOT__PARAM_DEFINITIONS:
				getParamDefinitions().clear();
				getParamDefinitions().addAll((Collection<? extends ParameterDefinition>)newValue);
				return;
			case DomainPackage.ROOT__PARAM_VALUES:
				getParamValues().clear();
				getParamValues().addAll((Collection<? extends ParameterValue>)newValue);
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
			case DomainPackage.ROOT__VIEW_POINTS:
				getViewPoints().clear();
				return;
			case DomainPackage.ROOT__VIEWS:
				getViews().clear();
				return;
			case DomainPackage.ROOT__PARAM_DEFINITIONS:
				getParamDefinitions().clear();
				return;
			case DomainPackage.ROOT__PARAM_VALUES:
				getParamValues().clear();
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
			case DomainPackage.ROOT__VIEW_POINTS:
				return viewPoints != null && !viewPoints.isEmpty();
			case DomainPackage.ROOT__VIEWS:
				return views != null && !views.isEmpty();
			case DomainPackage.ROOT__PARAM_DEFINITIONS:
				return paramDefinitions != null && !paramDefinitions.isEmpty();
			case DomainPackage.ROOT__PARAM_VALUES:
				return paramValues != null && !paramValues.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //RootImpl

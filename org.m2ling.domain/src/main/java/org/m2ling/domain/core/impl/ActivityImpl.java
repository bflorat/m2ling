/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.domain.core.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.m2ling.domain.core.Activity;
import org.m2ling.domain.core.ActivityTransition;
import org.m2ling.domain.core.Actor;
import org.m2ling.domain.core.CorePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Activity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.m2ling.domain.core.impl.ActivityImpl#getTransitions <em>Transitions</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.ActivityImpl#getResponsibles <em>Responsibles</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.ActivityImpl#getAccountables <em>Accountables</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ActivityImpl extends HasNameAndIDImpl implements Activity {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (C) 2012 Bertrand Florat";

	/**
	 * The cached value of the '{@link #getTransitions() <em>Transitions</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransitions()
	 * @generated
	 * @ordered
	 */
	protected EList<ActivityTransition> transitions;

	/**
	 * The cached value of the '{@link #getResponsibles() <em>Responsibles</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResponsibles()
	 * @generated
	 * @ordered
	 */
	protected EList<Actor> responsibles;

	/**
	 * The cached value of the '{@link #getAccountables() <em>Accountables</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAccountables()
	 * @generated
	 * @ordered
	 */
	protected EList<Actor> accountables;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ActivityImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CorePackage.Literals.ACTIVITY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ActivityTransition> getTransitions() {
		if (transitions == null) {
			transitions = new EObjectResolvingEList<ActivityTransition>(ActivityTransition.class, this, CorePackage.ACTIVITY__TRANSITIONS);
		}
		return transitions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Actor> getResponsibles() {
		if (responsibles == null) {
			responsibles = new EObjectResolvingEList<Actor>(Actor.class, this, CorePackage.ACTIVITY__RESPONSIBLES);
		}
		return responsibles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Actor> getAccountables() {
		if (accountables == null) {
			accountables = new EObjectResolvingEList<Actor>(Actor.class, this, CorePackage.ACTIVITY__ACCOUNTABLES);
		}
		return accountables;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CorePackage.ACTIVITY__TRANSITIONS:
				return getTransitions();
			case CorePackage.ACTIVITY__RESPONSIBLES:
				return getResponsibles();
			case CorePackage.ACTIVITY__ACCOUNTABLES:
				return getAccountables();
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
			case CorePackage.ACTIVITY__TRANSITIONS:
				getTransitions().clear();
				getTransitions().addAll((Collection<? extends ActivityTransition>)newValue);
				return;
			case CorePackage.ACTIVITY__RESPONSIBLES:
				getResponsibles().clear();
				getResponsibles().addAll((Collection<? extends Actor>)newValue);
				return;
			case CorePackage.ACTIVITY__ACCOUNTABLES:
				getAccountables().clear();
				getAccountables().addAll((Collection<? extends Actor>)newValue);
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
			case CorePackage.ACTIVITY__TRANSITIONS:
				getTransitions().clear();
				return;
			case CorePackage.ACTIVITY__RESPONSIBLES:
				getResponsibles().clear();
				return;
			case CorePackage.ACTIVITY__ACCOUNTABLES:
				getAccountables().clear();
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
			case CorePackage.ACTIVITY__TRANSITIONS:
				return transitions != null && !transitions.isEmpty();
			case CorePackage.ACTIVITY__RESPONSIBLES:
				return responsibles != null && !responsibles.isEmpty();
			case CorePackage.ACTIVITY__ACCOUNTABLES:
				return accountables != null && !accountables.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ActivityImpl

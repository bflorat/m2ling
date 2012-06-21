/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.domain.core.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.m2ling.domain.core.Activity;
import org.m2ling.domain.core.ComponentType;
import org.m2ling.domain.core.CorePackage;
import org.m2ling.domain.core.LinkType;
import org.m2ling.domain.core.Rule;
import org.m2ling.domain.core.ViewPoint;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>View Point</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.m2ling.domain.core.impl.ViewPointImpl#getActivities <em>Activities</em>}</li>
 * <li>{@link org.m2ling.domain.core.impl.ViewPointImpl#getComponentTypes <em>Component Types</em>}</li>
 * <li>{@link org.m2ling.domain.core.impl.ViewPointImpl#getLinkTypes <em>Link Types</em>}</li>
 * <li>{@link org.m2ling.domain.core.impl.ViewPointImpl#getRules <em>Rules</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ViewPointImpl extends ConceptItemImpl implements ViewPoint {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final String copyright = "Copyright (C) 2012 Bertrand Florat";

	/**
	 * The cached value of the '{@link #getActivities() <em>Activities</em>}' containment reference
	 * list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getActivities()
	 * @generated
	 * @ordered
	 */
	protected EList<Activity> activities;

	/**
	 * The cached value of the '{@link #getComponentTypes() <em>Component Types</em>}' containment
	 * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getComponentTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<ComponentType> componentTypes;

	/**
	 * The cached value of the '{@link #getLinkTypes() <em>Link Types</em>}' containment reference
	 * list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getLinkTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<LinkType> linkTypes;

	/**
	 * The cached value of the '{@link #getRules() <em>Rules</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getRules()
	 * @generated
	 * @ordered
	 */
	protected EList<Rule> rules;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ViewPointImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CorePackage.Literals.VIEW_POINT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<ComponentType> getComponentTypes() {
		if (componentTypes == null) {
			componentTypes = new EObjectContainmentEList<ComponentType>(ComponentType.class, this,
					CorePackage.VIEW_POINT__COMPONENT_TYPES);
		}
		return componentTypes;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<Activity> getActivities() {
		if (activities == null) {
			activities = new EObjectContainmentEList<Activity>(Activity.class, this, CorePackage.VIEW_POINT__ACTIVITIES);
		}
		return activities;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<LinkType> getLinkTypes() {
		if (linkTypes == null) {
			linkTypes = new EObjectContainmentEList<LinkType>(LinkType.class, this, CorePackage.VIEW_POINT__LINK_TYPES);
		}
		return linkTypes;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<Rule> getRules() {
		if (rules == null) {
			rules = new EObjectContainmentEList<Rule>(Rule.class, this, CorePackage.VIEW_POINT__RULES);
		}
		return rules;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case CorePackage.VIEW_POINT__ACTIVITIES:
			return ((InternalEList<?>) getActivities()).basicRemove(otherEnd, msgs);
		case CorePackage.VIEW_POINT__COMPONENT_TYPES:
			return ((InternalEList<?>) getComponentTypes()).basicRemove(otherEnd, msgs);
		case CorePackage.VIEW_POINT__LINK_TYPES:
			return ((InternalEList<?>) getLinkTypes()).basicRemove(otherEnd, msgs);
		case CorePackage.VIEW_POINT__RULES:
			return ((InternalEList<?>) getRules()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case CorePackage.VIEW_POINT__ACTIVITIES:
			return getActivities();
		case CorePackage.VIEW_POINT__COMPONENT_TYPES:
			return getComponentTypes();
		case CorePackage.VIEW_POINT__LINK_TYPES:
			return getLinkTypes();
		case CorePackage.VIEW_POINT__RULES:
			return getRules();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case CorePackage.VIEW_POINT__ACTIVITIES:
			getActivities().clear();
			getActivities().addAll((Collection<? extends Activity>) newValue);
			return;
		case CorePackage.VIEW_POINT__COMPONENT_TYPES:
			getComponentTypes().clear();
			getComponentTypes().addAll((Collection<? extends ComponentType>) newValue);
			return;
		case CorePackage.VIEW_POINT__LINK_TYPES:
			getLinkTypes().clear();
			getLinkTypes().addAll((Collection<? extends LinkType>) newValue);
			return;
		case CorePackage.VIEW_POINT__RULES:
			getRules().clear();
			getRules().addAll((Collection<? extends Rule>) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case CorePackage.VIEW_POINT__ACTIVITIES:
			getActivities().clear();
			return;
		case CorePackage.VIEW_POINT__COMPONENT_TYPES:
			getComponentTypes().clear();
			return;
		case CorePackage.VIEW_POINT__LINK_TYPES:
			getLinkTypes().clear();
			return;
		case CorePackage.VIEW_POINT__RULES:
			getRules().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case CorePackage.VIEW_POINT__ACTIVITIES:
			return activities != null && !activities.isEmpty();
		case CorePackage.VIEW_POINT__COMPONENT_TYPES:
			return componentTypes != null && !componentTypes.isEmpty();
		case CorePackage.VIEW_POINT__LINK_TYPES:
			return linkTypes != null && !linkTypes.isEmpty();
		case CorePackage.VIEW_POINT__RULES:
			return rules != null && !rules.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} // ViewPointImpl

/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.domain.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.m2ling.domain.DomainPackage;
import org.m2ling.domain.Root;
import org.m2ling.domain.core.Actor;
import org.m2ling.domain.core.OrganisationalUnit;
import org.m2ling.domain.core.Stakeholder;
import org.m2ling.domain.core.View;
import org.m2ling.domain.core.ViewPoint;
import org.m2ling.domain.parameters.RootParameters;
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
 *   <li>{@link org.m2ling.domain.impl.RootImpl#getStakeholders <em>Stakeholders</em>}</li>
 *   <li>{@link org.m2ling.domain.impl.RootImpl#getUnits <em>Units</em>}</li>
 *   <li>{@link org.m2ling.domain.impl.RootImpl#getActors <em>Actors</em>}</li>
 *   <li>{@link org.m2ling.domain.impl.RootImpl#getParameters <em>Parameters</em>}</li>
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
	 * The cached value of the '{@link #getStakeholders() <em>Stakeholders</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStakeholders()
	 * @generated
	 * @ordered
	 */
	protected EList<Stakeholder> stakeholders;

	/**
	 * The cached value of the '{@link #getUnits() <em>Units</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnits()
	 * @generated
	 * @ordered
	 */
	protected EList<OrganisationalUnit> units;

	/**
	 * The cached value of the '{@link #getActors() <em>Actors</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActors()
	 * @generated
	 * @ordered
	 */
	protected EList<Actor> actors;

	/**
	 * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameters()
	 * @generated
	 * @ordered
	 */
	protected RootParameters parameters;

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
	public EList<Stakeholder> getStakeholders() {
		if (stakeholders == null) {
			stakeholders = new EObjectContainmentEList<Stakeholder>(Stakeholder.class, this, DomainPackage.ROOT__STAKEHOLDERS);
		}
		return stakeholders;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OrganisationalUnit> getUnits() {
		if (units == null) {
			units = new EObjectContainmentEList<OrganisationalUnit>(OrganisationalUnit.class, this, DomainPackage.ROOT__UNITS);
		}
		return units;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Actor> getActors() {
		if (actors == null) {
			actors = new EObjectContainmentEList<Actor>(Actor.class, this, DomainPackage.ROOT__ACTORS);
		}
		return actors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RootParameters getParameters() {
		return parameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParameters(RootParameters newParameters, NotificationChain msgs) {
		RootParameters oldParameters = parameters;
		parameters = newParameters;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DomainPackage.ROOT__PARAMETERS, oldParameters, newParameters);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParameters(RootParameters newParameters) {
		if (newParameters != parameters) {
			NotificationChain msgs = null;
			if (parameters != null)
				msgs = ((InternalEObject)parameters).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DomainPackage.ROOT__PARAMETERS, null, msgs);
			if (newParameters != null)
				msgs = ((InternalEObject)newParameters).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DomainPackage.ROOT__PARAMETERS, null, msgs);
			msgs = basicSetParameters(newParameters, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomainPackage.ROOT__PARAMETERS, newParameters, newParameters));
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
			case DomainPackage.ROOT__STAKEHOLDERS:
				return ((InternalEList<?>)getStakeholders()).basicRemove(otherEnd, msgs);
			case DomainPackage.ROOT__UNITS:
				return ((InternalEList<?>)getUnits()).basicRemove(otherEnd, msgs);
			case DomainPackage.ROOT__ACTORS:
				return ((InternalEList<?>)getActors()).basicRemove(otherEnd, msgs);
			case DomainPackage.ROOT__PARAMETERS:
				return basicSetParameters(null, msgs);
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
			case DomainPackage.ROOT__STAKEHOLDERS:
				return getStakeholders();
			case DomainPackage.ROOT__UNITS:
				return getUnits();
			case DomainPackage.ROOT__ACTORS:
				return getActors();
			case DomainPackage.ROOT__PARAMETERS:
				return getParameters();
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
			case DomainPackage.ROOT__STAKEHOLDERS:
				getStakeholders().clear();
				getStakeholders().addAll((Collection<? extends Stakeholder>)newValue);
				return;
			case DomainPackage.ROOT__UNITS:
				getUnits().clear();
				getUnits().addAll((Collection<? extends OrganisationalUnit>)newValue);
				return;
			case DomainPackage.ROOT__ACTORS:
				getActors().clear();
				getActors().addAll((Collection<? extends Actor>)newValue);
				return;
			case DomainPackage.ROOT__PARAMETERS:
				setParameters((RootParameters)newValue);
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
			case DomainPackage.ROOT__STAKEHOLDERS:
				getStakeholders().clear();
				return;
			case DomainPackage.ROOT__UNITS:
				getUnits().clear();
				return;
			case DomainPackage.ROOT__ACTORS:
				getActors().clear();
				return;
			case DomainPackage.ROOT__PARAMETERS:
				setParameters((RootParameters)null);
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
			case DomainPackage.ROOT__STAKEHOLDERS:
				return stakeholders != null && !stakeholders.isEmpty();
			case DomainPackage.ROOT__UNITS:
				return units != null && !units.isEmpty();
			case DomainPackage.ROOT__ACTORS:
				return actors != null && !actors.isEmpty();
			case DomainPackage.ROOT__PARAMETERS:
				return parameters != null;
		}
		return super.eIsSet(featureID);
	}

} //RootImpl

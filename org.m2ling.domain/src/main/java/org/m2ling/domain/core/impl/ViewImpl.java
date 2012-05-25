/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.domain.core.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.m2ling.domain.core.Component;
import org.m2ling.domain.core.ComponentGroup;
import org.m2ling.domain.core.ComponentInstance;
import org.m2ling.domain.core.ComponentInstanceGroup;
import org.m2ling.domain.core.CorePackage;
import org.m2ling.domain.core.InstancesLink;
import org.m2ling.domain.core.Link;
import org.m2ling.domain.core.View;
import org.m2ling.domain.core.ViewPoint;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>View</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.m2ling.domain.core.impl.ViewImpl#getComponentsGroups <em>Components Groups</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.ViewImpl#getComponents <em>Components</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.ViewImpl#getViewPoint <em>View Point</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.ViewImpl#getLinks <em>Links</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.ViewImpl#getInstances <em>Instances</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.ViewImpl#getInstancesGroups <em>Instances Groups</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.ViewImpl#getStreams <em>Streams</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ViewImpl extends ArchitectureItemImpl implements View {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (C) 2012 Bertrand Florat";

	/**
	 * The cached value of the '{@link #getComponentsGroups() <em>Components Groups</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponentsGroups()
	 * @generated
	 * @ordered
	 */
	protected EList<ComponentGroup> componentsGroups;

	/**
	 * The cached value of the '{@link #getComponents() <em>Components</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponents()
	 * @generated
	 * @ordered
	 */
	protected EList<Component> components;

	/**
	 * The cached value of the '{@link #getViewPoint() <em>View Point</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getViewPoint()
	 * @generated
	 * @ordered
	 */
	protected ViewPoint viewPoint;

	/**
	 * The cached value of the '{@link #getLinks() <em>Links</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinks()
	 * @generated
	 * @ordered
	 */
	protected EList<Link> links;

	/**
	 * The cached value of the '{@link #getInstances() <em>Instances</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstances()
	 * @generated
	 * @ordered
	 */
	protected EList<ComponentInstance> instances;

	/**
	 * The cached value of the '{@link #getInstancesGroups() <em>Instances Groups</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstancesGroups()
	 * @generated
	 * @ordered
	 */
	protected EList<ComponentInstanceGroup> instancesGroups;

	/**
	 * The cached value of the '{@link #getStreams() <em>Streams</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStreams()
	 * @generated
	 * @ordered
	 */
	protected EList<InstancesLink> streams;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ViewImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CorePackage.Literals.VIEW;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ComponentGroup> getComponentsGroups() {
		if (componentsGroups == null) {
			componentsGroups = new EObjectContainmentEList<ComponentGroup>(ComponentGroup.class, this, CorePackage.VIEW__COMPONENTS_GROUPS);
		}
		return componentsGroups;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Component> getComponents() {
		if (components == null) {
			components = new EObjectContainmentEList<Component>(Component.class, this, CorePackage.VIEW__COMPONENTS);
		}
		return components;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ViewPoint getViewPoint() {
		if (viewPoint != null && viewPoint.eIsProxy()) {
			InternalEObject oldViewPoint = (InternalEObject)viewPoint;
			viewPoint = (ViewPoint)eResolveProxy(oldViewPoint);
			if (viewPoint != oldViewPoint) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CorePackage.VIEW__VIEW_POINT, oldViewPoint, viewPoint));
			}
		}
		return viewPoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ViewPoint basicGetViewPoint() {
		return viewPoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setViewPoint(ViewPoint newViewPoint) {
		ViewPoint oldViewPoint = viewPoint;
		viewPoint = newViewPoint;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.VIEW__VIEW_POINT, oldViewPoint, viewPoint));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Link> getLinks() {
		if (links == null) {
			links = new EObjectContainmentEList<Link>(Link.class, this, CorePackage.VIEW__LINKS);
		}
		return links;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ComponentInstance> getInstances() {
		if (instances == null) {
			instances = new EObjectContainmentEList<ComponentInstance>(ComponentInstance.class, this, CorePackage.VIEW__INSTANCES);
		}
		return instances;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ComponentInstanceGroup> getInstancesGroups() {
		if (instancesGroups == null) {
			instancesGroups = new EObjectContainmentEList<ComponentInstanceGroup>(ComponentInstanceGroup.class, this, CorePackage.VIEW__INSTANCES_GROUPS);
		}
		return instancesGroups;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<InstancesLink> getStreams() {
		if (streams == null) {
			streams = new EObjectContainmentEList<InstancesLink>(InstancesLink.class, this, CorePackage.VIEW__STREAMS);
		}
		return streams;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CorePackage.VIEW__COMPONENTS_GROUPS:
				return ((InternalEList<?>)getComponentsGroups()).basicRemove(otherEnd, msgs);
			case CorePackage.VIEW__COMPONENTS:
				return ((InternalEList<?>)getComponents()).basicRemove(otherEnd, msgs);
			case CorePackage.VIEW__LINKS:
				return ((InternalEList<?>)getLinks()).basicRemove(otherEnd, msgs);
			case CorePackage.VIEW__INSTANCES:
				return ((InternalEList<?>)getInstances()).basicRemove(otherEnd, msgs);
			case CorePackage.VIEW__INSTANCES_GROUPS:
				return ((InternalEList<?>)getInstancesGroups()).basicRemove(otherEnd, msgs);
			case CorePackage.VIEW__STREAMS:
				return ((InternalEList<?>)getStreams()).basicRemove(otherEnd, msgs);
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
			case CorePackage.VIEW__COMPONENTS_GROUPS:
				return getComponentsGroups();
			case CorePackage.VIEW__COMPONENTS:
				return getComponents();
			case CorePackage.VIEW__VIEW_POINT:
				if (resolve) return getViewPoint();
				return basicGetViewPoint();
			case CorePackage.VIEW__LINKS:
				return getLinks();
			case CorePackage.VIEW__INSTANCES:
				return getInstances();
			case CorePackage.VIEW__INSTANCES_GROUPS:
				return getInstancesGroups();
			case CorePackage.VIEW__STREAMS:
				return getStreams();
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
			case CorePackage.VIEW__COMPONENTS_GROUPS:
				getComponentsGroups().clear();
				getComponentsGroups().addAll((Collection<? extends ComponentGroup>)newValue);
				return;
			case CorePackage.VIEW__COMPONENTS:
				getComponents().clear();
				getComponents().addAll((Collection<? extends Component>)newValue);
				return;
			case CorePackage.VIEW__VIEW_POINT:
				setViewPoint((ViewPoint)newValue);
				return;
			case CorePackage.VIEW__LINKS:
				getLinks().clear();
				getLinks().addAll((Collection<? extends Link>)newValue);
				return;
			case CorePackage.VIEW__INSTANCES:
				getInstances().clear();
				getInstances().addAll((Collection<? extends ComponentInstance>)newValue);
				return;
			case CorePackage.VIEW__INSTANCES_GROUPS:
				getInstancesGroups().clear();
				getInstancesGroups().addAll((Collection<? extends ComponentInstanceGroup>)newValue);
				return;
			case CorePackage.VIEW__STREAMS:
				getStreams().clear();
				getStreams().addAll((Collection<? extends InstancesLink>)newValue);
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
			case CorePackage.VIEW__COMPONENTS_GROUPS:
				getComponentsGroups().clear();
				return;
			case CorePackage.VIEW__COMPONENTS:
				getComponents().clear();
				return;
			case CorePackage.VIEW__VIEW_POINT:
				setViewPoint((ViewPoint)null);
				return;
			case CorePackage.VIEW__LINKS:
				getLinks().clear();
				return;
			case CorePackage.VIEW__INSTANCES:
				getInstances().clear();
				return;
			case CorePackage.VIEW__INSTANCES_GROUPS:
				getInstancesGroups().clear();
				return;
			case CorePackage.VIEW__STREAMS:
				getStreams().clear();
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
			case CorePackage.VIEW__COMPONENTS_GROUPS:
				return componentsGroups != null && !componentsGroups.isEmpty();
			case CorePackage.VIEW__COMPONENTS:
				return components != null && !components.isEmpty();
			case CorePackage.VIEW__VIEW_POINT:
				return viewPoint != null;
			case CorePackage.VIEW__LINKS:
				return links != null && !links.isEmpty();
			case CorePackage.VIEW__INSTANCES:
				return instances != null && !instances.isEmpty();
			case CorePackage.VIEW__INSTANCES_GROUPS:
				return instancesGroups != null && !instancesGroups.isEmpty();
			case CorePackage.VIEW__STREAMS:
				return streams != null && !streams.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ViewImpl

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
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.m2ling.domain.core.Component;
import org.m2ling.domain.core.ComponentType;
import org.m2ling.domain.core.CorePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Component</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.m2ling.domain.core.impl.ComponentImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.ComponentImpl#getSubComponents <em>Sub Components</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.ComponentImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.ComponentImpl#getEngine <em>Engine</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ComponentImpl extends ComponentGroupImpl implements Component {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (C) 2012 Bertrand Florat";

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected ComponentType type;

	/**
	 * The cached value of the '{@link #getSubComponents() <em>Sub Components</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubComponents()
	 * @generated
	 * @ordered
	 */
	protected EList<Component> subComponents;

	/**
	 * The cached value of the '{@link #getParent() <em>Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParent()
	 * @generated
	 * @ordered
	 */
	protected Component parent;

	/**
	 * The cached value of the '{@link #getEngine() <em>Engine</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEngine()
	 * @generated
	 * @ordered
	 */
	protected Component engine;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComponentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CorePackage.Literals.COMPONENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentType getType() {
		if (type != null && type.eIsProxy()) {
			InternalEObject oldType = (InternalEObject)type;
			type = (ComponentType)eResolveProxy(oldType);
			if (type != oldType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CorePackage.COMPONENT__TYPE, oldType, type));
			}
		}
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentType basicGetType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(ComponentType newType) {
		ComponentType oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.COMPONENT__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Component> getSubComponents() {
		if (subComponents == null) {
			subComponents = new EObjectWithInverseResolvingEList<Component>(Component.class, this, CorePackage.COMPONENT__SUB_COMPONENTS, CorePackage.COMPONENT__PARENT);
		}
		return subComponents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Component getParent() {
		if (parent != null && parent.eIsProxy()) {
			InternalEObject oldParent = (InternalEObject)parent;
			parent = (Component)eResolveProxy(oldParent);
			if (parent != oldParent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CorePackage.COMPONENT__PARENT, oldParent, parent));
			}
		}
		return parent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Component basicGetParent() {
		return parent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParent(Component newParent, NotificationChain msgs) {
		Component oldParent = parent;
		parent = newParent;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CorePackage.COMPONENT__PARENT, oldParent, newParent);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParent(Component newParent) {
		if (newParent != parent) {
			NotificationChain msgs = null;
			if (parent != null)
				msgs = ((InternalEObject)parent).eInverseRemove(this, CorePackage.COMPONENT__SUB_COMPONENTS, Component.class, msgs);
			if (newParent != null)
				msgs = ((InternalEObject)newParent).eInverseAdd(this, CorePackage.COMPONENT__SUB_COMPONENTS, Component.class, msgs);
			msgs = basicSetParent(newParent, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.COMPONENT__PARENT, newParent, newParent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Component getEngine() {
		if (engine != null && engine.eIsProxy()) {
			InternalEObject oldEngine = (InternalEObject)engine;
			engine = (Component)eResolveProxy(oldEngine);
			if (engine != oldEngine) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CorePackage.COMPONENT__ENGINE, oldEngine, engine));
			}
		}
		return engine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Component basicGetEngine() {
		return engine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEngine(Component newEngine) {
		Component oldEngine = engine;
		engine = newEngine;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.COMPONENT__ENGINE, oldEngine, engine));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CorePackage.COMPONENT__SUB_COMPONENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSubComponents()).basicAdd(otherEnd, msgs);
			case CorePackage.COMPONENT__PARENT:
				if (parent != null)
					msgs = ((InternalEObject)parent).eInverseRemove(this, CorePackage.COMPONENT__SUB_COMPONENTS, Component.class, msgs);
				return basicSetParent((Component)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CorePackage.COMPONENT__SUB_COMPONENTS:
				return ((InternalEList<?>)getSubComponents()).basicRemove(otherEnd, msgs);
			case CorePackage.COMPONENT__PARENT:
				return basicSetParent(null, msgs);
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
			case CorePackage.COMPONENT__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case CorePackage.COMPONENT__SUB_COMPONENTS:
				return getSubComponents();
			case CorePackage.COMPONENT__PARENT:
				if (resolve) return getParent();
				return basicGetParent();
			case CorePackage.COMPONENT__ENGINE:
				if (resolve) return getEngine();
				return basicGetEngine();
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
			case CorePackage.COMPONENT__TYPE:
				setType((ComponentType)newValue);
				return;
			case CorePackage.COMPONENT__SUB_COMPONENTS:
				getSubComponents().clear();
				getSubComponents().addAll((Collection<? extends Component>)newValue);
				return;
			case CorePackage.COMPONENT__PARENT:
				setParent((Component)newValue);
				return;
			case CorePackage.COMPONENT__ENGINE:
				setEngine((Component)newValue);
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
			case CorePackage.COMPONENT__TYPE:
				setType((ComponentType)null);
				return;
			case CorePackage.COMPONENT__SUB_COMPONENTS:
				getSubComponents().clear();
				return;
			case CorePackage.COMPONENT__PARENT:
				setParent((Component)null);
				return;
			case CorePackage.COMPONENT__ENGINE:
				setEngine((Component)null);
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
			case CorePackage.COMPONENT__TYPE:
				return type != null;
			case CorePackage.COMPONENT__SUB_COMPONENTS:
				return subComponents != null && !subComponents.isEmpty();
			case CorePackage.COMPONENT__PARENT:
				return parent != null;
			case CorePackage.COMPONENT__ENGINE:
				return engine != null;
		}
		return super.eIsSet(featureID);
	}

} //ComponentImpl

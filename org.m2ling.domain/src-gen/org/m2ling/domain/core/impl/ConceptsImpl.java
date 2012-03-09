/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.m2ling.domain.core.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.m2ling.domain.core.ComponentType;
import org.m2ling.domain.core.Concepts;
import org.m2ling.domain.core.CorePackage;
import org.m2ling.domain.core.EngineType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Concepts</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.m2ling.domain.core.impl.ConceptsImpl#getComponentTypes <em>Component Types</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.ConceptsImpl#getEngineTypes <em>Engine Types</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConceptsImpl extends ConceptItemImpl implements Concepts {
	/**
	 * The cached value of the '{@link #getComponentTypes() <em>Component Types</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponentTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<ComponentType> componentTypes;

	/**
	 * The cached value of the '{@link #getEngineTypes() <em>Engine Types</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEngineTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<EngineType> engineTypes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConceptsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CorePackage.Literals.CONCEPTS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ComponentType> getComponentTypes() {
		if (componentTypes == null) {
			componentTypes = new EObjectContainmentEList<ComponentType>(ComponentType.class, this, CorePackage.CONCEPTS__COMPONENT_TYPES);
		}
		return componentTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EngineType> getEngineTypes() {
		if (engineTypes == null) {
			engineTypes = new EObjectContainmentEList<EngineType>(EngineType.class, this, CorePackage.CONCEPTS__ENGINE_TYPES);
		}
		return engineTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CorePackage.CONCEPTS__COMPONENT_TYPES:
				return ((InternalEList<?>)getComponentTypes()).basicRemove(otherEnd, msgs);
			case CorePackage.CONCEPTS__ENGINE_TYPES:
				return ((InternalEList<?>)getEngineTypes()).basicRemove(otherEnd, msgs);
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
			case CorePackage.CONCEPTS__COMPONENT_TYPES:
				return getComponentTypes();
			case CorePackage.CONCEPTS__ENGINE_TYPES:
				return getEngineTypes();
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
			case CorePackage.CONCEPTS__COMPONENT_TYPES:
				getComponentTypes().clear();
				getComponentTypes().addAll((Collection<? extends ComponentType>)newValue);
				return;
			case CorePackage.CONCEPTS__ENGINE_TYPES:
				getEngineTypes().clear();
				getEngineTypes().addAll((Collection<? extends EngineType>)newValue);
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
			case CorePackage.CONCEPTS__COMPONENT_TYPES:
				getComponentTypes().clear();
				return;
			case CorePackage.CONCEPTS__ENGINE_TYPES:
				getEngineTypes().clear();
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
			case CorePackage.CONCEPTS__COMPONENT_TYPES:
				return componentTypes != null && !componentTypes.isEmpty();
			case CorePackage.CONCEPTS__ENGINE_TYPES:
				return engineTypes != null && !engineTypes.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ConceptsImpl

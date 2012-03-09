/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.m2ling.domain.core.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.m2ling.domain.core.Component;
import org.m2ling.domain.core.ComponentGroup;
import org.m2ling.domain.core.CorePackage;
import org.m2ling.domain.core.Engine;
import org.m2ling.domain.core.EngineGroup;
import org.m2ling.domain.core.Project;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Project</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.m2ling.domain.core.impl.ProjectImpl#getComponentsGroups <em>Components Groups</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.ProjectImpl#getComponents <em>Components</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.ProjectImpl#getEngines <em>Engines</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.ProjectImpl#getEngineGroups <em>Engine Groups</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProjectImpl extends ArchitectureItemImpl implements Project {
	/**
	 * The cached value of the '{@link #getComponentsGroups() <em>Components Groups</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponentsGroups()
	 * @generated
	 * @ordered
	 */
	protected EList<ComponentGroup> componentsGroups;

	/**
	 * The cached value of the '{@link #getComponents() <em>Components</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponents()
	 * @generated
	 * @ordered
	 */
	protected EList<Component> components;

	/**
	 * The cached value of the '{@link #getEngines() <em>Engines</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEngines()
	 * @generated
	 * @ordered
	 */
	protected EList<Engine> engines;

	/**
	 * The cached value of the '{@link #getEngineGroups() <em>Engine Groups</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEngineGroups()
	 * @generated
	 * @ordered
	 */
	protected EList<EngineGroup> engineGroups;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CorePackage.Literals.PROJECT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ComponentGroup> getComponentsGroups() {
		if (componentsGroups == null) {
			componentsGroups = new EObjectResolvingEList<ComponentGroup>(ComponentGroup.class, this, CorePackage.PROJECT__COMPONENTS_GROUPS);
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
			components = new EObjectResolvingEList<Component>(Component.class, this, CorePackage.PROJECT__COMPONENTS);
		}
		return components;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Engine> getEngines() {
		if (engines == null) {
			engines = new EObjectResolvingEList<Engine>(Engine.class, this, CorePackage.PROJECT__ENGINES);
		}
		return engines;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EngineGroup> getEngineGroups() {
		if (engineGroups == null) {
			engineGroups = new EObjectResolvingEList<EngineGroup>(EngineGroup.class, this, CorePackage.PROJECT__ENGINE_GROUPS);
		}
		return engineGroups;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CorePackage.PROJECT__COMPONENTS_GROUPS:
				return getComponentsGroups();
			case CorePackage.PROJECT__COMPONENTS:
				return getComponents();
			case CorePackage.PROJECT__ENGINES:
				return getEngines();
			case CorePackage.PROJECT__ENGINE_GROUPS:
				return getEngineGroups();
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
			case CorePackage.PROJECT__COMPONENTS_GROUPS:
				getComponentsGroups().clear();
				getComponentsGroups().addAll((Collection<? extends ComponentGroup>)newValue);
				return;
			case CorePackage.PROJECT__COMPONENTS:
				getComponents().clear();
				getComponents().addAll((Collection<? extends Component>)newValue);
				return;
			case CorePackage.PROJECT__ENGINES:
				getEngines().clear();
				getEngines().addAll((Collection<? extends Engine>)newValue);
				return;
			case CorePackage.PROJECT__ENGINE_GROUPS:
				getEngineGroups().clear();
				getEngineGroups().addAll((Collection<? extends EngineGroup>)newValue);
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
			case CorePackage.PROJECT__COMPONENTS_GROUPS:
				getComponentsGroups().clear();
				return;
			case CorePackage.PROJECT__COMPONENTS:
				getComponents().clear();
				return;
			case CorePackage.PROJECT__ENGINES:
				getEngines().clear();
				return;
			case CorePackage.PROJECT__ENGINE_GROUPS:
				getEngineGroups().clear();
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
			case CorePackage.PROJECT__COMPONENTS_GROUPS:
				return componentsGroups != null && !componentsGroups.isEmpty();
			case CorePackage.PROJECT__COMPONENTS:
				return components != null && !components.isEmpty();
			case CorePackage.PROJECT__ENGINES:
				return engines != null && !engines.isEmpty();
			case CorePackage.PROJECT__ENGINE_GROUPS:
				return engineGroups != null && !engineGroups.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ProjectImpl

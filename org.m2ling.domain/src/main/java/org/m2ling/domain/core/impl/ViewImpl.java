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
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.m2ling.domain.core.Component;
import org.m2ling.domain.core.ComponentGroup;
import org.m2ling.domain.core.ComponentInstance;
import org.m2ling.domain.core.ComponentInstanceGroup;
import org.m2ling.domain.core.CorePackage;
import org.m2ling.domain.core.HasDescription;
import org.m2ling.domain.core.HasNameAndID;
import org.m2ling.domain.core.HasTags;
import org.m2ling.domain.core.Link;
import org.m2ling.domain.core.LinkInstance;
import org.m2ling.domain.core.View;
import org.m2ling.domain.core.ViewPoint;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>View</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.m2ling.domain.core.impl.ViewImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.ViewImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.ViewImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.ViewImpl#getTags <em>Tags</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.ViewImpl#getComponentsGroups <em>Components Groups</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.ViewImpl#getComponents <em>Components</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.ViewImpl#getViewPoint <em>View Point</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.ViewImpl#getLinks <em>Links</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.ViewImpl#getComponentInstances <em>Component Instances</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.ViewImpl#getInstancesGroups <em>Instances Groups</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.ViewImpl#getLinkInstances <em>Link Instances</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ViewImpl extends HasCommentImpl implements View {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (C) 2012 Bertrand Florat";

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * This is true if the Name attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean nameESet;

	/**
	 * The cached value of the '{@link #getTags() <em>Tags</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTags()
	 * @generated
	 * @ordered
	 */
	protected EList<String> tags;

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
	 * The cached value of the '{@link #getComponentInstances() <em>Component Instances</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponentInstances()
	 * @generated
	 * @ordered
	 */
	protected EList<ComponentInstance> componentInstances;

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
	 * The cached value of the '{@link #getLinkInstances() <em>Link Instances</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinkInstances()
	 * @generated
	 * @ordered
	 */
	protected EList<LinkInstance> linkInstances;

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
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.VIEW__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.VIEW__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		boolean oldNameESet = nameESet;
		nameESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.VIEW__NAME, oldName, name, !oldNameESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetName() {
		String oldName = name;
		boolean oldNameESet = nameESet;
		name = NAME_EDEFAULT;
		nameESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, CorePackage.VIEW__NAME, oldName, NAME_EDEFAULT, oldNameESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetName() {
		return nameESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getTags() {
		if (tags == null) {
			tags = new EDataTypeUniqueEList<String>(String.class, this, CorePackage.VIEW__TAGS);
		}
		return tags;
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
	public EList<ComponentInstance> getComponentInstances() {
		if (componentInstances == null) {
			componentInstances = new EObjectContainmentEList<ComponentInstance>(ComponentInstance.class, this, CorePackage.VIEW__COMPONENT_INSTANCES);
		}
		return componentInstances;
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
	public EList<LinkInstance> getLinkInstances() {
		if (linkInstances == null) {
			linkInstances = new EObjectContainmentEList<LinkInstance>(LinkInstance.class, this, CorePackage.VIEW__LINK_INSTANCES);
		}
		return linkInstances;
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
			case CorePackage.VIEW__COMPONENT_INSTANCES:
				return ((InternalEList<?>)getComponentInstances()).basicRemove(otherEnd, msgs);
			case CorePackage.VIEW__INSTANCES_GROUPS:
				return ((InternalEList<?>)getInstancesGroups()).basicRemove(otherEnd, msgs);
			case CorePackage.VIEW__LINK_INSTANCES:
				return ((InternalEList<?>)getLinkInstances()).basicRemove(otherEnd, msgs);
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
			case CorePackage.VIEW__DESCRIPTION:
				return getDescription();
			case CorePackage.VIEW__ID:
				return getId();
			case CorePackage.VIEW__NAME:
				return getName();
			case CorePackage.VIEW__TAGS:
				return getTags();
			case CorePackage.VIEW__COMPONENTS_GROUPS:
				return getComponentsGroups();
			case CorePackage.VIEW__COMPONENTS:
				return getComponents();
			case CorePackage.VIEW__VIEW_POINT:
				if (resolve) return getViewPoint();
				return basicGetViewPoint();
			case CorePackage.VIEW__LINKS:
				return getLinks();
			case CorePackage.VIEW__COMPONENT_INSTANCES:
				return getComponentInstances();
			case CorePackage.VIEW__INSTANCES_GROUPS:
				return getInstancesGroups();
			case CorePackage.VIEW__LINK_INSTANCES:
				return getLinkInstances();
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
			case CorePackage.VIEW__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case CorePackage.VIEW__ID:
				setId((String)newValue);
				return;
			case CorePackage.VIEW__NAME:
				setName((String)newValue);
				return;
			case CorePackage.VIEW__TAGS:
				getTags().clear();
				getTags().addAll((Collection<? extends String>)newValue);
				return;
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
			case CorePackage.VIEW__COMPONENT_INSTANCES:
				getComponentInstances().clear();
				getComponentInstances().addAll((Collection<? extends ComponentInstance>)newValue);
				return;
			case CorePackage.VIEW__INSTANCES_GROUPS:
				getInstancesGroups().clear();
				getInstancesGroups().addAll((Collection<? extends ComponentInstanceGroup>)newValue);
				return;
			case CorePackage.VIEW__LINK_INSTANCES:
				getLinkInstances().clear();
				getLinkInstances().addAll((Collection<? extends LinkInstance>)newValue);
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
			case CorePackage.VIEW__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case CorePackage.VIEW__ID:
				setId(ID_EDEFAULT);
				return;
			case CorePackage.VIEW__NAME:
				unsetName();
				return;
			case CorePackage.VIEW__TAGS:
				getTags().clear();
				return;
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
			case CorePackage.VIEW__COMPONENT_INSTANCES:
				getComponentInstances().clear();
				return;
			case CorePackage.VIEW__INSTANCES_GROUPS:
				getInstancesGroups().clear();
				return;
			case CorePackage.VIEW__LINK_INSTANCES:
				getLinkInstances().clear();
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
			case CorePackage.VIEW__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case CorePackage.VIEW__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case CorePackage.VIEW__NAME:
				return isSetName();
			case CorePackage.VIEW__TAGS:
				return tags != null && !tags.isEmpty();
			case CorePackage.VIEW__COMPONENTS_GROUPS:
				return componentsGroups != null && !componentsGroups.isEmpty();
			case CorePackage.VIEW__COMPONENTS:
				return components != null && !components.isEmpty();
			case CorePackage.VIEW__VIEW_POINT:
				return viewPoint != null;
			case CorePackage.VIEW__LINKS:
				return links != null && !links.isEmpty();
			case CorePackage.VIEW__COMPONENT_INSTANCES:
				return componentInstances != null && !componentInstances.isEmpty();
			case CorePackage.VIEW__INSTANCES_GROUPS:
				return instancesGroups != null && !instancesGroups.isEmpty();
			case CorePackage.VIEW__LINK_INSTANCES:
				return linkInstances != null && !linkInstances.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == HasDescription.class) {
			switch (derivedFeatureID) {
				case CorePackage.VIEW__DESCRIPTION: return CorePackage.HAS_DESCRIPTION__DESCRIPTION;
				default: return -1;
			}
		}
		if (baseClass == HasNameAndID.class) {
			switch (derivedFeatureID) {
				case CorePackage.VIEW__ID: return CorePackage.HAS_NAME_AND_ID__ID;
				case CorePackage.VIEW__NAME: return CorePackage.HAS_NAME_AND_ID__NAME;
				default: return -1;
			}
		}
		if (baseClass == HasTags.class) {
			switch (derivedFeatureID) {
				case CorePackage.VIEW__TAGS: return CorePackage.HAS_TAGS__TAGS;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == HasDescription.class) {
			switch (baseFeatureID) {
				case CorePackage.HAS_DESCRIPTION__DESCRIPTION: return CorePackage.VIEW__DESCRIPTION;
				default: return -1;
			}
		}
		if (baseClass == HasNameAndID.class) {
			switch (baseFeatureID) {
				case CorePackage.HAS_NAME_AND_ID__ID: return CorePackage.VIEW__ID;
				case CorePackage.HAS_NAME_AND_ID__NAME: return CorePackage.VIEW__NAME;
				default: return -1;
			}
		}
		if (baseClass == HasTags.class) {
			switch (baseFeatureID) {
				case CorePackage.HAS_TAGS__TAGS: return CorePackage.VIEW__TAGS;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(" (description: ");
		result.append(description);
		result.append(", id: ");
		result.append(id);
		result.append(", name: ");
		if (nameESet) result.append(name); else result.append("<unset>");
		result.append(", tags: ");
		result.append(tags);
		result.append(')');
		return result.toString();
	}

} //ViewImpl

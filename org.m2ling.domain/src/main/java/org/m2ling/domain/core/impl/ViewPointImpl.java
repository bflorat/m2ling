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
import org.m2ling.domain.core.Activity;
import org.m2ling.domain.core.ComponentType;
import org.m2ling.domain.core.CorePackage;
import org.m2ling.domain.core.HasDescription;
import org.m2ling.domain.core.HasNameAndID;
import org.m2ling.domain.core.HasStatus;
import org.m2ling.domain.core.HasTags;
import org.m2ling.domain.core.LinkType;
import org.m2ling.domain.core.Rule;
import org.m2ling.domain.core.ViewPoint;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>View Point</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.m2ling.domain.core.impl.ViewPointImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.ViewPointImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.ViewPointImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.ViewPointImpl#getTags <em>Tags</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.ViewPointImpl#getStatus <em>Status</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.ViewPointImpl#getActivities <em>Activities</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.ViewPointImpl#getComponentTypes <em>Component Types</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.ViewPointImpl#getLinkTypes <em>Link Types</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.ViewPointImpl#getRules <em>Rules</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.ViewPointImpl#getStatusLiterals <em>Status Literals</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ViewPointImpl extends HasCommentImpl implements ViewPoint {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
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
	 * The default value of the '{@link #getStatus() <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatus()
	 * @generated
	 * @ordered
	 */
	protected static final String STATUS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStatus() <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatus()
	 * @generated
	 * @ordered
	 */
	protected String status = STATUS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getActivities() <em>Activities</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getActivities()
	 * @generated
	 * @ordered
	 */
	protected EList<Activity> activities;

	/**
	 * The cached value of the '{@link #getComponentTypes() <em>Component Types</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getComponentTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<ComponentType> componentTypes;

	/**
	 * The cached value of the '{@link #getLinkTypes() <em>Link Types</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
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
	 * The cached value of the '{@link #getStatusLiterals() <em>Status Literals</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatusLiterals()
	 * @generated
	 * @ordered
	 */
	protected EList<String> statusLiterals;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ViewPointImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CorePackage.Literals.VIEW_POINT;
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
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.VIEW_POINT__DESCRIPTION, oldDescription, description));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.VIEW_POINT__ID, oldId, id));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.VIEW_POINT__NAME, oldName, name, !oldNameESet));
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
			eNotify(new ENotificationImpl(this, Notification.UNSET, CorePackage.VIEW_POINT__NAME, oldName, NAME_EDEFAULT, oldNameESet));
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
			tags = new EDataTypeUniqueEList<String>(String.class, this, CorePackage.VIEW_POINT__TAGS);
		}
		return tags;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStatus(String newStatus) {
		String oldStatus = status;
		status = newStatus;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.VIEW_POINT__STATUS, oldStatus, status));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ComponentType> getComponentTypes() {
		if (componentTypes == null) {
			componentTypes = new EObjectContainmentEList<ComponentType>(ComponentType.class, this, CorePackage.VIEW_POINT__COMPONENT_TYPES);
		}
		return componentTypes;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
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
	 * @generated
	 */
	public EList<Rule> getRules() {
		if (rules == null) {
			rules = new EObjectContainmentEList<Rule>(Rule.class, this, CorePackage.VIEW_POINT__RULES);
		}
		return rules;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getStatusLiterals() {
		if (statusLiterals == null) {
			statusLiterals = new EDataTypeUniqueEList<String>(String.class, this, CorePackage.VIEW_POINT__STATUS_LITERALS);
		}
		return statusLiterals;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CorePackage.VIEW_POINT__ACTIVITIES:
				return ((InternalEList<?>)getActivities()).basicRemove(otherEnd, msgs);
			case CorePackage.VIEW_POINT__COMPONENT_TYPES:
				return ((InternalEList<?>)getComponentTypes()).basicRemove(otherEnd, msgs);
			case CorePackage.VIEW_POINT__LINK_TYPES:
				return ((InternalEList<?>)getLinkTypes()).basicRemove(otherEnd, msgs);
			case CorePackage.VIEW_POINT__RULES:
				return ((InternalEList<?>)getRules()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CorePackage.VIEW_POINT__DESCRIPTION:
				return getDescription();
			case CorePackage.VIEW_POINT__ID:
				return getId();
			case CorePackage.VIEW_POINT__NAME:
				return getName();
			case CorePackage.VIEW_POINT__TAGS:
				return getTags();
			case CorePackage.VIEW_POINT__STATUS:
				return getStatus();
			case CorePackage.VIEW_POINT__ACTIVITIES:
				return getActivities();
			case CorePackage.VIEW_POINT__COMPONENT_TYPES:
				return getComponentTypes();
			case CorePackage.VIEW_POINT__LINK_TYPES:
				return getLinkTypes();
			case CorePackage.VIEW_POINT__RULES:
				return getRules();
			case CorePackage.VIEW_POINT__STATUS_LITERALS:
				return getStatusLiterals();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CorePackage.VIEW_POINT__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case CorePackage.VIEW_POINT__ID:
				setId((String)newValue);
				return;
			case CorePackage.VIEW_POINT__NAME:
				setName((String)newValue);
				return;
			case CorePackage.VIEW_POINT__TAGS:
				getTags().clear();
				getTags().addAll((Collection<? extends String>)newValue);
				return;
			case CorePackage.VIEW_POINT__STATUS:
				setStatus((String)newValue);
				return;
			case CorePackage.VIEW_POINT__ACTIVITIES:
				getActivities().clear();
				getActivities().addAll((Collection<? extends Activity>)newValue);
				return;
			case CorePackage.VIEW_POINT__COMPONENT_TYPES:
				getComponentTypes().clear();
				getComponentTypes().addAll((Collection<? extends ComponentType>)newValue);
				return;
			case CorePackage.VIEW_POINT__LINK_TYPES:
				getLinkTypes().clear();
				getLinkTypes().addAll((Collection<? extends LinkType>)newValue);
				return;
			case CorePackage.VIEW_POINT__RULES:
				getRules().clear();
				getRules().addAll((Collection<? extends Rule>)newValue);
				return;
			case CorePackage.VIEW_POINT__STATUS_LITERALS:
				getStatusLiterals().clear();
				getStatusLiterals().addAll((Collection<? extends String>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case CorePackage.VIEW_POINT__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case CorePackage.VIEW_POINT__ID:
				setId(ID_EDEFAULT);
				return;
			case CorePackage.VIEW_POINT__NAME:
				unsetName();
				return;
			case CorePackage.VIEW_POINT__TAGS:
				getTags().clear();
				return;
			case CorePackage.VIEW_POINT__STATUS:
				setStatus(STATUS_EDEFAULT);
				return;
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
			case CorePackage.VIEW_POINT__STATUS_LITERALS:
				getStatusLiterals().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case CorePackage.VIEW_POINT__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case CorePackage.VIEW_POINT__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case CorePackage.VIEW_POINT__NAME:
				return isSetName();
			case CorePackage.VIEW_POINT__TAGS:
				return tags != null && !tags.isEmpty();
			case CorePackage.VIEW_POINT__STATUS:
				return STATUS_EDEFAULT == null ? status != null : !STATUS_EDEFAULT.equals(status);
			case CorePackage.VIEW_POINT__ACTIVITIES:
				return activities != null && !activities.isEmpty();
			case CorePackage.VIEW_POINT__COMPONENT_TYPES:
				return componentTypes != null && !componentTypes.isEmpty();
			case CorePackage.VIEW_POINT__LINK_TYPES:
				return linkTypes != null && !linkTypes.isEmpty();
			case CorePackage.VIEW_POINT__RULES:
				return rules != null && !rules.isEmpty();
			case CorePackage.VIEW_POINT__STATUS_LITERALS:
				return statusLiterals != null && !statusLiterals.isEmpty();
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
				case CorePackage.VIEW_POINT__DESCRIPTION: return CorePackage.HAS_DESCRIPTION__DESCRIPTION;
				default: return -1;
			}
		}
		if (baseClass == HasNameAndID.class) {
			switch (derivedFeatureID) {
				case CorePackage.VIEW_POINT__ID: return CorePackage.HAS_NAME_AND_ID__ID;
				case CorePackage.VIEW_POINT__NAME: return CorePackage.HAS_NAME_AND_ID__NAME;
				default: return -1;
			}
		}
		if (baseClass == HasTags.class) {
			switch (derivedFeatureID) {
				case CorePackage.VIEW_POINT__TAGS: return CorePackage.HAS_TAGS__TAGS;
				default: return -1;
			}
		}
		if (baseClass == HasStatus.class) {
			switch (derivedFeatureID) {
				case CorePackage.VIEW_POINT__STATUS: return CorePackage.HAS_STATUS__STATUS;
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
				case CorePackage.HAS_DESCRIPTION__DESCRIPTION: return CorePackage.VIEW_POINT__DESCRIPTION;
				default: return -1;
			}
		}
		if (baseClass == HasNameAndID.class) {
			switch (baseFeatureID) {
				case CorePackage.HAS_NAME_AND_ID__ID: return CorePackage.VIEW_POINT__ID;
				case CorePackage.HAS_NAME_AND_ID__NAME: return CorePackage.VIEW_POINT__NAME;
				default: return -1;
			}
		}
		if (baseClass == HasTags.class) {
			switch (baseFeatureID) {
				case CorePackage.HAS_TAGS__TAGS: return CorePackage.VIEW_POINT__TAGS;
				default: return -1;
			}
		}
		if (baseClass == HasStatus.class) {
			switch (baseFeatureID) {
				case CorePackage.HAS_STATUS__STATUS: return CorePackage.VIEW_POINT__STATUS;
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
		result.append(", status: ");
		result.append(status);
		result.append(", statusLiterals: ");
		result.append(statusLiterals);
		result.append(')');
		return result.toString();
	}

} // ViewPointImpl

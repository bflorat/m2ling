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
import org.m2ling.domain.core.ComponentInstance;
import org.m2ling.domain.core.CorePackage;
import org.m2ling.domain.core.HasComment;
import org.m2ling.domain.core.HasConstraints;
import org.m2ling.domain.core.HasDescription;
import org.m2ling.domain.core.HasNameAndID;
import org.m2ling.domain.core.HasReferences;
import org.m2ling.domain.core.HasTags;
import org.m2ling.domain.core.Reference;
import org.m2ling.domain.core.RuntimeItem;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Component Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.m2ling.domain.core.impl.ComponentInstanceImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.ComponentInstanceImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.ComponentInstanceImpl#getComment <em>Comment</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.ComponentInstanceImpl#getTags <em>Tags</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.ComponentInstanceImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.ComponentInstanceImpl#getStatus <em>Status</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.ComponentInstanceImpl#getReferences <em>References</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.ComponentInstanceImpl#getComponent <em>Component</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.ComponentInstanceImpl#getBoundComponentInstance <em>Bound Component Instance</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ComponentInstanceImpl extends HasParameterValuesImpl implements ComponentInstance {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (C) 2012 Bertrand Florat";

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
	 * The default value of the '{@link #getComment() <em>Comment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComment()
	 * @generated
	 * @ordered
	 */
	protected static final String COMMENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getComment() <em>Comment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComment()
	 * @generated
	 * @ordered
	 */
	protected String comment = COMMENT_EDEFAULT;

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
	 * The cached value of the '{@link #getReferences() <em>References</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferences()
	 * @generated
	 * @ordered
	 */
	protected EList<Reference> references;

	/**
	 * The cached value of the '{@link #getComponent() <em>Component</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponent()
	 * @generated
	 * @ordered
	 */
	protected Component component;

	/**
	 * The cached value of the '{@link #getBoundComponentInstance() <em>Bound Component Instance</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBoundComponentInstance()
	 * @generated
	 * @ordered
	 */
	protected ComponentInstance boundComponentInstance;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComponentInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CorePackage.Literals.COMPONENT_INSTANCE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.COMPONENT_INSTANCE__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Component getComponent() {
		if (component != null && component.eIsProxy()) {
			InternalEObject oldComponent = (InternalEObject)component;
			component = (Component)eResolveProxy(oldComponent);
			if (component != oldComponent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CorePackage.COMPONENT_INSTANCE__COMPONENT, oldComponent, component));
			}
		}
		return component;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Component basicGetComponent() {
		return component;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComponent(Component newComponent) {
		Component oldComponent = component;
		component = newComponent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.COMPONENT_INSTANCE__COMPONENT, oldComponent, component));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentInstance getBoundComponentInstance() {
		if (boundComponentInstance != null && boundComponentInstance.eIsProxy()) {
			InternalEObject oldBoundComponentInstance = (InternalEObject)boundComponentInstance;
			boundComponentInstance = (ComponentInstance)eResolveProxy(oldBoundComponentInstance);
			if (boundComponentInstance != oldBoundComponentInstance) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CorePackage.COMPONENT_INSTANCE__BOUND_COMPONENT_INSTANCE, oldBoundComponentInstance, boundComponentInstance));
			}
		}
		return boundComponentInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentInstance basicGetBoundComponentInstance() {
		return boundComponentInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBoundComponentInstance(ComponentInstance newBoundComponentInstance) {
		ComponentInstance oldBoundComponentInstance = boundComponentInstance;
		boundComponentInstance = newBoundComponentInstance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.COMPONENT_INSTANCE__BOUND_COMPONENT_INSTANCE, oldBoundComponentInstance, boundComponentInstance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Reference> getReferences() {
		if (references == null) {
			references = new EObjectContainmentEList<Reference>(Reference.class, this, CorePackage.COMPONENT_INSTANCE__REFERENCES);
		}
		return references;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CorePackage.COMPONENT_INSTANCE__REFERENCES:
				return ((InternalEList<?>)getReferences()).basicRemove(otherEnd, msgs);
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
			case CorePackage.COMPONENT_INSTANCE__ID:
				return getId();
			case CorePackage.COMPONENT_INSTANCE__NAME:
				return getName();
			case CorePackage.COMPONENT_INSTANCE__COMMENT:
				return getComment();
			case CorePackage.COMPONENT_INSTANCE__TAGS:
				return getTags();
			case CorePackage.COMPONENT_INSTANCE__DESCRIPTION:
				return getDescription();
			case CorePackage.COMPONENT_INSTANCE__STATUS:
				return getStatus();
			case CorePackage.COMPONENT_INSTANCE__REFERENCES:
				return getReferences();
			case CorePackage.COMPONENT_INSTANCE__COMPONENT:
				if (resolve) return getComponent();
				return basicGetComponent();
			case CorePackage.COMPONENT_INSTANCE__BOUND_COMPONENT_INSTANCE:
				if (resolve) return getBoundComponentInstance();
				return basicGetBoundComponentInstance();
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
			case CorePackage.COMPONENT_INSTANCE__ID:
				setId((String)newValue);
				return;
			case CorePackage.COMPONENT_INSTANCE__NAME:
				setName((String)newValue);
				return;
			case CorePackage.COMPONENT_INSTANCE__COMMENT:
				setComment((String)newValue);
				return;
			case CorePackage.COMPONENT_INSTANCE__TAGS:
				getTags().clear();
				getTags().addAll((Collection<? extends String>)newValue);
				return;
			case CorePackage.COMPONENT_INSTANCE__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case CorePackage.COMPONENT_INSTANCE__STATUS:
				setStatus((String)newValue);
				return;
			case CorePackage.COMPONENT_INSTANCE__REFERENCES:
				getReferences().clear();
				getReferences().addAll((Collection<? extends Reference>)newValue);
				return;
			case CorePackage.COMPONENT_INSTANCE__COMPONENT:
				setComponent((Component)newValue);
				return;
			case CorePackage.COMPONENT_INSTANCE__BOUND_COMPONENT_INSTANCE:
				setBoundComponentInstance((ComponentInstance)newValue);
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
			case CorePackage.COMPONENT_INSTANCE__ID:
				setId(ID_EDEFAULT);
				return;
			case CorePackage.COMPONENT_INSTANCE__NAME:
				unsetName();
				return;
			case CorePackage.COMPONENT_INSTANCE__COMMENT:
				setComment(COMMENT_EDEFAULT);
				return;
			case CorePackage.COMPONENT_INSTANCE__TAGS:
				getTags().clear();
				return;
			case CorePackage.COMPONENT_INSTANCE__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case CorePackage.COMPONENT_INSTANCE__STATUS:
				setStatus(STATUS_EDEFAULT);
				return;
			case CorePackage.COMPONENT_INSTANCE__REFERENCES:
				getReferences().clear();
				return;
			case CorePackage.COMPONENT_INSTANCE__COMPONENT:
				setComponent((Component)null);
				return;
			case CorePackage.COMPONENT_INSTANCE__BOUND_COMPONENT_INSTANCE:
				setBoundComponentInstance((ComponentInstance)null);
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
			case CorePackage.COMPONENT_INSTANCE__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case CorePackage.COMPONENT_INSTANCE__NAME:
				return isSetName();
			case CorePackage.COMPONENT_INSTANCE__COMMENT:
				return COMMENT_EDEFAULT == null ? comment != null : !COMMENT_EDEFAULT.equals(comment);
			case CorePackage.COMPONENT_INSTANCE__TAGS:
				return tags != null && !tags.isEmpty();
			case CorePackage.COMPONENT_INSTANCE__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case CorePackage.COMPONENT_INSTANCE__STATUS:
				return STATUS_EDEFAULT == null ? status != null : !STATUS_EDEFAULT.equals(status);
			case CorePackage.COMPONENT_INSTANCE__REFERENCES:
				return references != null && !references.isEmpty();
			case CorePackage.COMPONENT_INSTANCE__COMPONENT:
				return component != null;
			case CorePackage.COMPONENT_INSTANCE__BOUND_COMPONENT_INSTANCE:
				return boundComponentInstance != null;
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
		if (baseClass == HasNameAndID.class) {
			switch (derivedFeatureID) {
				case CorePackage.COMPONENT_INSTANCE__ID: return CorePackage.HAS_NAME_AND_ID__ID;
				case CorePackage.COMPONENT_INSTANCE__NAME: return CorePackage.HAS_NAME_AND_ID__NAME;
				default: return -1;
			}
		}
		if (baseClass == HasComment.class) {
			switch (derivedFeatureID) {
				case CorePackage.COMPONENT_INSTANCE__COMMENT: return CorePackage.HAS_COMMENT__COMMENT;
				default: return -1;
			}
		}
		if (baseClass == HasTags.class) {
			switch (derivedFeatureID) {
				case CorePackage.COMPONENT_INSTANCE__TAGS: return CorePackage.HAS_TAGS__TAGS;
				default: return -1;
			}
		}
		if (baseClass == HasConstraints.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == HasDescription.class) {
			switch (derivedFeatureID) {
				case CorePackage.COMPONENT_INSTANCE__DESCRIPTION: return CorePackage.HAS_DESCRIPTION__DESCRIPTION;
				default: return -1;
			}
		}
		if (baseClass == RuntimeItem.class) {
			switch (derivedFeatureID) {
				case CorePackage.COMPONENT_INSTANCE__STATUS: return CorePackage.RUNTIME_ITEM__STATUS;
				default: return -1;
			}
		}
		if (baseClass == HasReferences.class) {
			switch (derivedFeatureID) {
				case CorePackage.COMPONENT_INSTANCE__REFERENCES: return CorePackage.HAS_REFERENCES__REFERENCES;
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
		if (baseClass == HasNameAndID.class) {
			switch (baseFeatureID) {
				case CorePackage.HAS_NAME_AND_ID__ID: return CorePackage.COMPONENT_INSTANCE__ID;
				case CorePackage.HAS_NAME_AND_ID__NAME: return CorePackage.COMPONENT_INSTANCE__NAME;
				default: return -1;
			}
		}
		if (baseClass == HasComment.class) {
			switch (baseFeatureID) {
				case CorePackage.HAS_COMMENT__COMMENT: return CorePackage.COMPONENT_INSTANCE__COMMENT;
				default: return -1;
			}
		}
		if (baseClass == HasTags.class) {
			switch (baseFeatureID) {
				case CorePackage.HAS_TAGS__TAGS: return CorePackage.COMPONENT_INSTANCE__TAGS;
				default: return -1;
			}
		}
		if (baseClass == HasConstraints.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == HasDescription.class) {
			switch (baseFeatureID) {
				case CorePackage.HAS_DESCRIPTION__DESCRIPTION: return CorePackage.COMPONENT_INSTANCE__DESCRIPTION;
				default: return -1;
			}
		}
		if (baseClass == RuntimeItem.class) {
			switch (baseFeatureID) {
				case CorePackage.RUNTIME_ITEM__STATUS: return CorePackage.COMPONENT_INSTANCE__STATUS;
				default: return -1;
			}
		}
		if (baseClass == HasReferences.class) {
			switch (baseFeatureID) {
				case CorePackage.HAS_REFERENCES__REFERENCES: return CorePackage.COMPONENT_INSTANCE__REFERENCES;
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
		result.append(" (id: ");
		result.append(id);
		result.append(", name: ");
		if (nameESet) result.append(name); else result.append("<unset>");
		result.append(", comment: ");
		result.append(comment);
		result.append(", tags: ");
		result.append(tags);
		result.append(", description: ");
		result.append(description);
		result.append(", status: ");
		result.append(status);
		result.append(')');
		return result.toString();
	}

	/**
	 * <!-- begin-user-doc --> If the component node is bound to another component node in the same
	 * or another viewpoint, we use the bound component node name if the current component node name
	 * is void and if the bound component node name is not void itself.<!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public String getName() {
		if ((name == null || "".equals(name)) && boundComponentInstance != null && boundComponentInstance.getName() != null
				&& !"".equals(boundComponentInstance)) {
			return boundComponentInstance.getName();
		} else {
			return name;
		}
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
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.COMPONENT_INSTANCE__NAME, oldName, name, !oldNameESet));
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
			eNotify(new ENotificationImpl(this, Notification.UNSET, CorePackage.COMPONENT_INSTANCE__NAME, oldName, NAME_EDEFAULT, oldNameESet));
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
	public String getComment() {
		return comment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComment(String newComment) {
		String oldComment = comment;
		comment = newComment;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.COMPONENT_INSTANCE__COMMENT, oldComment, comment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getTags() {
		if (tags == null) {
			tags = new EDataTypeUniqueEList<String>(String.class, this, CorePackage.COMPONENT_INSTANCE__TAGS);
		}
		return tags;
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
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.COMPONENT_INSTANCE__DESCRIPTION, oldDescription, description));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.COMPONENT_INSTANCE__STATUS, oldStatus, status));
	}

} //ComponentInstanceImpl

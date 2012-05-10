/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.domain.core.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.m2ling.domain.core.ComponentType;
import org.m2ling.domain.core.Constraint;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.m2ling.domain.core.ConceptItem;
import org.m2ling.domain.core.CorePackage;
import org.m2ling.domain.core.LinkType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Link Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.m2ling.domain.core.impl.LinkTypeImpl#getSourceTypes <em>Source Types</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.LinkTypeImpl#getDestinationTypes <em>Destination Types</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LinkTypeImpl extends ConceptItemImpl implements LinkType {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (C) 2012 Bertrand Florat";

	/**
	 * The cached value of the '{@link #getSourceTypes() <em>Source Types</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<ComponentType> sourceTypes;

	/**
	 * The cached value of the '{@link #getDestinationTypes() <em>Destination Types</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDestinationTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<ComponentType> destinationTypes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LinkTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CorePackage.Literals.LINK_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ComponentType> getSourceTypes() {
		if (sourceTypes == null) {
			sourceTypes = new EObjectResolvingEList<ComponentType>(ComponentType.class, this, CorePackage.LINK_TYPE__SOURCE_TYPES);
		}
		return sourceTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ComponentType> getDestinationTypes() {
		if (destinationTypes == null) {
			destinationTypes = new EObjectResolvingEList<ComponentType>(ComponentType.class, this, CorePackage.LINK_TYPE__DESTINATION_TYPES);
		}
		return destinationTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CorePackage.LINK_TYPE__SOURCE_TYPES:
				return getSourceTypes();
			case CorePackage.LINK_TYPE__DESTINATION_TYPES:
				return getDestinationTypes();
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
			case CorePackage.LINK_TYPE__SOURCE_TYPES:
				getSourceTypes().clear();
				getSourceTypes().addAll((Collection<? extends ComponentType>)newValue);
				return;
			case CorePackage.LINK_TYPE__DESTINATION_TYPES:
				getDestinationTypes().clear();
				getDestinationTypes().addAll((Collection<? extends ComponentType>)newValue);
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
			case CorePackage.LINK_TYPE__SOURCE_TYPES:
				getSourceTypes().clear();
				return;
			case CorePackage.LINK_TYPE__DESTINATION_TYPES:
				getDestinationTypes().clear();
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
			case CorePackage.LINK_TYPE__SOURCE_TYPES:
				return sourceTypes != null && !sourceTypes.isEmpty();
			case CorePackage.LINK_TYPE__DESTINATION_TYPES:
				return destinationTypes != null && !destinationTypes.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //LinkTypeImpl

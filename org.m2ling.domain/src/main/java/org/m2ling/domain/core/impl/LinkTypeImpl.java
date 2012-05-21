/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.domain.core.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.m2ling.domain.core.ComponentType;
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
 *   <li>{@link org.m2ling.domain.core.impl.LinkTypeImpl#isReifiable <em>Reifiable</em>}</li>
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
	 * The default value of the '{@link #isReifiable() <em>Reifiable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isReifiable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean REIFIABLE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isReifiable() <em>Reifiable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isReifiable()
	 * @generated
	 * @ordered
	 */
	protected boolean reifiable = REIFIABLE_EDEFAULT;

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
	public boolean isReifiable() {
		return reifiable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReifiable(boolean newReifiable) {
		boolean oldReifiable = reifiable;
		reifiable = newReifiable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.LINK_TYPE__REIFIABLE, oldReifiable, reifiable));
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
			case CorePackage.LINK_TYPE__REIFIABLE:
				return isReifiable();
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
			case CorePackage.LINK_TYPE__REIFIABLE:
				setReifiable((Boolean)newValue);
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
			case CorePackage.LINK_TYPE__REIFIABLE:
				setReifiable(REIFIABLE_EDEFAULT);
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
			case CorePackage.LINK_TYPE__REIFIABLE:
				return reifiable != REIFIABLE_EDEFAULT;
		}
		return super.eIsSet(featureID);
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
		result.append(" (reifiable: ");
		result.append(reifiable);
		result.append(')');
		return result.toString();
	}

} //LinkTypeImpl

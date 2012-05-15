/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.domain.core.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.m2ling.domain.core.Activity;
import org.m2ling.domain.core.CorePackage;
import org.m2ling.domain.core.HasLabel;
import org.m2ling.domain.core.HasTags;
import org.m2ling.domain.core.Stakeholder;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Activity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.m2ling.domain.core.impl.ActivityImpl#getTags <em>Tags</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.ActivityImpl#getLabel <em>Label</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.ActivityImpl#getAccountables <em>Accountables</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.ActivityImpl#getResponsibles <em>Responsibles</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ActivityImpl extends HasNameAndIDImpl implements Activity {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (C) 2012 Bertrand Florat";

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
	 * The default value of the '{@link #getLabel() <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected static final String LABEL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLabel() <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected String label = LABEL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAccountables() <em>Accountables</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAccountables()
	 * @generated
	 * @ordered
	 */
	protected EList<Stakeholder> accountables;

	/**
	 * The cached value of the '{@link #getResponsibles() <em>Responsibles</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResponsibles()
	 * @generated
	 * @ordered
	 */
	protected EList<Stakeholder> responsibles;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ActivityImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CorePackage.Literals.ACTIVITY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getTags() {
		if (tags == null) {
			tags = new EDataTypeUniqueEList<String>(String.class, this, CorePackage.ACTIVITY__TAGS);
		}
		return tags;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLabel(String newLabel) {
		String oldLabel = label;
		label = newLabel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.ACTIVITY__LABEL, oldLabel, label));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Stakeholder> getResponsibles() {
		if (responsibles == null) {
			responsibles = new EObjectResolvingEList<Stakeholder>(Stakeholder.class, this, CorePackage.ACTIVITY__RESPONSIBLES);
		}
		return responsibles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Stakeholder> getAccountables() {
		if (accountables == null) {
			accountables = new EObjectResolvingEList<Stakeholder>(Stakeholder.class, this, CorePackage.ACTIVITY__ACCOUNTABLES);
		}
		return accountables;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CorePackage.ACTIVITY__TAGS:
				return getTags();
			case CorePackage.ACTIVITY__LABEL:
				return getLabel();
			case CorePackage.ACTIVITY__ACCOUNTABLES:
				return getAccountables();
			case CorePackage.ACTIVITY__RESPONSIBLES:
				return getResponsibles();
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
			case CorePackage.ACTIVITY__TAGS:
				getTags().clear();
				getTags().addAll((Collection<? extends String>)newValue);
				return;
			case CorePackage.ACTIVITY__LABEL:
				setLabel((String)newValue);
				return;
			case CorePackage.ACTIVITY__ACCOUNTABLES:
				getAccountables().clear();
				getAccountables().addAll((Collection<? extends Stakeholder>)newValue);
				return;
			case CorePackage.ACTIVITY__RESPONSIBLES:
				getResponsibles().clear();
				getResponsibles().addAll((Collection<? extends Stakeholder>)newValue);
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
			case CorePackage.ACTIVITY__TAGS:
				getTags().clear();
				return;
			case CorePackage.ACTIVITY__LABEL:
				setLabel(LABEL_EDEFAULT);
				return;
			case CorePackage.ACTIVITY__ACCOUNTABLES:
				getAccountables().clear();
				return;
			case CorePackage.ACTIVITY__RESPONSIBLES:
				getResponsibles().clear();
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
			case CorePackage.ACTIVITY__TAGS:
				return tags != null && !tags.isEmpty();
			case CorePackage.ACTIVITY__LABEL:
				return LABEL_EDEFAULT == null ? label != null : !LABEL_EDEFAULT.equals(label);
			case CorePackage.ACTIVITY__ACCOUNTABLES:
				return accountables != null && !accountables.isEmpty();
			case CorePackage.ACTIVITY__RESPONSIBLES:
				return responsibles != null && !responsibles.isEmpty();
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
		if (baseClass == HasTags.class) {
			switch (derivedFeatureID) {
				case CorePackage.ACTIVITY__TAGS: return CorePackage.HAS_TAGS__TAGS;
				default: return -1;
			}
		}
		if (baseClass == HasLabel.class) {
			switch (derivedFeatureID) {
				case CorePackage.ACTIVITY__LABEL: return CorePackage.HAS_LABEL__LABEL;
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
		if (baseClass == HasTags.class) {
			switch (baseFeatureID) {
				case CorePackage.HAS_TAGS__TAGS: return CorePackage.ACTIVITY__TAGS;
				default: return -1;
			}
		}
		if (baseClass == HasLabel.class) {
			switch (baseFeatureID) {
				case CorePackage.HAS_LABEL__LABEL: return CorePackage.ACTIVITY__LABEL;
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
		result.append(" (tags: ");
		result.append(tags);
		result.append(", label: ");
		result.append(label);
		result.append(')');
		return result.toString();
	}

} //ActivityImpl

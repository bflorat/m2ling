/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.domain.core.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.m2ling.domain.core.CorePackage;
import org.m2ling.domain.core.CustomProperty;
import org.m2ling.domain.core.HasComment;
import org.m2ling.domain.core.HasCustomProperties;
import org.m2ling.domain.core.HasDescription;
import org.m2ling.domain.core.HasStatus;
import org.m2ling.domain.core.HasTags;
import org.m2ling.domain.core.Rule;
import org.m2ling.domain.core.RulePriority;
import org.m2ling.domain.core.StatusEvent;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.m2ling.domain.core.impl.RuleImpl#getCustomProperties <em>Custom Properties</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.RuleImpl#getComment <em>Comment</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.RuleImpl#getTags <em>Tags</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.RuleImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.RuleImpl#getStatus <em>Status</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.RuleImpl#getPriority <em>Priority</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.RuleImpl#getRationale <em>Rationale</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.RuleImpl#getExceptions <em>Exceptions</em>}</li>
 *   <li>{@link org.m2ling.domain.core.impl.RuleImpl#getHistory <em>History</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RuleImpl extends HasNameAndIDImpl implements Rule {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (C) 2012 Bertrand Florat";

	/**
	 * The cached value of the '{@link #getCustomProperties() <em>Custom Properties</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCustomProperties()
	 * @generated
	 * @ordered
	 */
	protected CustomProperty customProperties;

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
	 * The default value of the '{@link #getPriority() <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPriority()
	 * @generated
	 * @ordered
	 */
	protected static final RulePriority PRIORITY_EDEFAULT = RulePriority.VERY_LOW;

	/**
	 * The cached value of the '{@link #getPriority() <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPriority()
	 * @generated
	 * @ordered
	 */
	protected RulePriority priority = PRIORITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getRationale() <em>Rationale</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRationale()
	 * @generated
	 * @ordered
	 */
	protected static final String RATIONALE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRationale() <em>Rationale</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRationale()
	 * @generated
	 * @ordered
	 */
	protected String rationale = RATIONALE_EDEFAULT;

	/**
	 * The default value of the '{@link #getExceptions() <em>Exceptions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExceptions()
	 * @generated
	 * @ordered
	 */
	protected static final String EXCEPTIONS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getExceptions() <em>Exceptions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExceptions()
	 * @generated
	 * @ordered
	 */
	protected String exceptions = EXCEPTIONS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getHistory() <em>History</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHistory()
	 * @generated
	 * @ordered
	 */
	protected EList<StatusEvent> history;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RuleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CorePackage.Literals.RULE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CustomProperty getCustomProperties() {
		if (customProperties != null && customProperties.eIsProxy()) {
			InternalEObject oldCustomProperties = (InternalEObject)customProperties;
			customProperties = (CustomProperty)eResolveProxy(oldCustomProperties);
			if (customProperties != oldCustomProperties) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CorePackage.RULE__CUSTOM_PROPERTIES, oldCustomProperties, customProperties));
			}
		}
		return customProperties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CustomProperty basicGetCustomProperties() {
		return customProperties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCustomProperties(CustomProperty newCustomProperties) {
		CustomProperty oldCustomProperties = customProperties;
		customProperties = newCustomProperties;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.RULE__CUSTOM_PROPERTIES, oldCustomProperties, customProperties));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.RULE__COMMENT, oldComment, comment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getTags() {
		if (tags == null) {
			tags = new EDataTypeUniqueEList<String>(String.class, this, CorePackage.RULE__TAGS);
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
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.RULE__DESCRIPTION, oldDescription, description));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.RULE__STATUS, oldStatus, status));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RulePriority getPriority() {
		return priority;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPriority(RulePriority newPriority) {
		RulePriority oldPriority = priority;
		priority = newPriority == null ? PRIORITY_EDEFAULT : newPriority;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.RULE__PRIORITY, oldPriority, priority));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRationale() {
		return rationale;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRationale(String newRationale) {
		String oldRationale = rationale;
		rationale = newRationale;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.RULE__RATIONALE, oldRationale, rationale));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getExceptions() {
		return exceptions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExceptions(String newExceptions) {
		String oldExceptions = exceptions;
		exceptions = newExceptions;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.RULE__EXCEPTIONS, oldExceptions, exceptions));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<StatusEvent> getHistory() {
		if (history == null) {
			history = new EObjectResolvingEList<StatusEvent>(StatusEvent.class, this, CorePackage.RULE__HISTORY);
		}
		return history;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CorePackage.RULE__CUSTOM_PROPERTIES:
				if (resolve) return getCustomProperties();
				return basicGetCustomProperties();
			case CorePackage.RULE__COMMENT:
				return getComment();
			case CorePackage.RULE__TAGS:
				return getTags();
			case CorePackage.RULE__DESCRIPTION:
				return getDescription();
			case CorePackage.RULE__STATUS:
				return getStatus();
			case CorePackage.RULE__PRIORITY:
				return getPriority();
			case CorePackage.RULE__RATIONALE:
				return getRationale();
			case CorePackage.RULE__EXCEPTIONS:
				return getExceptions();
			case CorePackage.RULE__HISTORY:
				return getHistory();
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
			case CorePackage.RULE__CUSTOM_PROPERTIES:
				setCustomProperties((CustomProperty)newValue);
				return;
			case CorePackage.RULE__COMMENT:
				setComment((String)newValue);
				return;
			case CorePackage.RULE__TAGS:
				getTags().clear();
				getTags().addAll((Collection<? extends String>)newValue);
				return;
			case CorePackage.RULE__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case CorePackage.RULE__STATUS:
				setStatus((String)newValue);
				return;
			case CorePackage.RULE__PRIORITY:
				setPriority((RulePriority)newValue);
				return;
			case CorePackage.RULE__RATIONALE:
				setRationale((String)newValue);
				return;
			case CorePackage.RULE__EXCEPTIONS:
				setExceptions((String)newValue);
				return;
			case CorePackage.RULE__HISTORY:
				getHistory().clear();
				getHistory().addAll((Collection<? extends StatusEvent>)newValue);
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
			case CorePackage.RULE__CUSTOM_PROPERTIES:
				setCustomProperties((CustomProperty)null);
				return;
			case CorePackage.RULE__COMMENT:
				setComment(COMMENT_EDEFAULT);
				return;
			case CorePackage.RULE__TAGS:
				getTags().clear();
				return;
			case CorePackage.RULE__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case CorePackage.RULE__STATUS:
				setStatus(STATUS_EDEFAULT);
				return;
			case CorePackage.RULE__PRIORITY:
				setPriority(PRIORITY_EDEFAULT);
				return;
			case CorePackage.RULE__RATIONALE:
				setRationale(RATIONALE_EDEFAULT);
				return;
			case CorePackage.RULE__EXCEPTIONS:
				setExceptions(EXCEPTIONS_EDEFAULT);
				return;
			case CorePackage.RULE__HISTORY:
				getHistory().clear();
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
			case CorePackage.RULE__CUSTOM_PROPERTIES:
				return customProperties != null;
			case CorePackage.RULE__COMMENT:
				return COMMENT_EDEFAULT == null ? comment != null : !COMMENT_EDEFAULT.equals(comment);
			case CorePackage.RULE__TAGS:
				return tags != null && !tags.isEmpty();
			case CorePackage.RULE__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case CorePackage.RULE__STATUS:
				return STATUS_EDEFAULT == null ? status != null : !STATUS_EDEFAULT.equals(status);
			case CorePackage.RULE__PRIORITY:
				return priority != PRIORITY_EDEFAULT;
			case CorePackage.RULE__RATIONALE:
				return RATIONALE_EDEFAULT == null ? rationale != null : !RATIONALE_EDEFAULT.equals(rationale);
			case CorePackage.RULE__EXCEPTIONS:
				return EXCEPTIONS_EDEFAULT == null ? exceptions != null : !EXCEPTIONS_EDEFAULT.equals(exceptions);
			case CorePackage.RULE__HISTORY:
				return history != null && !history.isEmpty();
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
		if (baseClass == HasCustomProperties.class) {
			switch (derivedFeatureID) {
				case CorePackage.RULE__CUSTOM_PROPERTIES: return CorePackage.HAS_CUSTOM_PROPERTIES__CUSTOM_PROPERTIES;
				default: return -1;
			}
		}
		if (baseClass == HasComment.class) {
			switch (derivedFeatureID) {
				case CorePackage.RULE__COMMENT: return CorePackage.HAS_COMMENT__COMMENT;
				default: return -1;
			}
		}
		if (baseClass == HasTags.class) {
			switch (derivedFeatureID) {
				case CorePackage.RULE__TAGS: return CorePackage.HAS_TAGS__TAGS;
				default: return -1;
			}
		}
		if (baseClass == HasDescription.class) {
			switch (derivedFeatureID) {
				case CorePackage.RULE__DESCRIPTION: return CorePackage.HAS_DESCRIPTION__DESCRIPTION;
				default: return -1;
			}
		}
		if (baseClass == HasStatus.class) {
			switch (derivedFeatureID) {
				case CorePackage.RULE__STATUS: return CorePackage.HAS_STATUS__STATUS;
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
		if (baseClass == HasCustomProperties.class) {
			switch (baseFeatureID) {
				case CorePackage.HAS_CUSTOM_PROPERTIES__CUSTOM_PROPERTIES: return CorePackage.RULE__CUSTOM_PROPERTIES;
				default: return -1;
			}
		}
		if (baseClass == HasComment.class) {
			switch (baseFeatureID) {
				case CorePackage.HAS_COMMENT__COMMENT: return CorePackage.RULE__COMMENT;
				default: return -1;
			}
		}
		if (baseClass == HasTags.class) {
			switch (baseFeatureID) {
				case CorePackage.HAS_TAGS__TAGS: return CorePackage.RULE__TAGS;
				default: return -1;
			}
		}
		if (baseClass == HasDescription.class) {
			switch (baseFeatureID) {
				case CorePackage.HAS_DESCRIPTION__DESCRIPTION: return CorePackage.RULE__DESCRIPTION;
				default: return -1;
			}
		}
		if (baseClass == HasStatus.class) {
			switch (baseFeatureID) {
				case CorePackage.HAS_STATUS__STATUS: return CorePackage.RULE__STATUS;
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
		result.append(" (comment: ");
		result.append(comment);
		result.append(", tags: ");
		result.append(tags);
		result.append(", description: ");
		result.append(description);
		result.append(", status: ");
		result.append(status);
		result.append(", priority: ");
		result.append(priority);
		result.append(", rationale: ");
		result.append(rationale);
		result.append(", exceptions: ");
		result.append(exceptions);
		result.append(')');
		return result.toString();
	}

} //RuleImpl

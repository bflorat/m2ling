/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.m2ling.domain.parameters.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.m2ling.domain.core.CorePackage;
import org.m2ling.domain.core.CustomProperty;
import org.m2ling.domain.core.HasCustomProperties;
import org.m2ling.domain.core.HasName;
import org.m2ling.domain.core.HasParameterDefinitions;

import org.m2ling.domain.core.impl.HasCommentImpl;

import org.m2ling.domain.parameters.ParamDefOverrider;
import org.m2ling.domain.parameters.ParameterConstraint;
import org.m2ling.domain.parameters.ParameterDefinition;
import org.m2ling.domain.parameters.ParameterType;
import org.m2ling.domain.parameters.ParametersPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Parameter Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.m2ling.domain.parameters.impl.ParameterDefinitionImpl#getCustomProperties <em>Custom Properties</em>}</li>
 *   <li>{@link org.m2ling.domain.parameters.impl.ParameterDefinitionImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.m2ling.domain.parameters.impl.ParameterDefinitionImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.m2ling.domain.parameters.impl.ParameterDefinitionImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link org.m2ling.domain.parameters.impl.ParameterDefinitionImpl#getConstraints <em>Constraints</em>}</li>
 *   <li>{@link org.m2ling.domain.parameters.impl.ParameterDefinitionImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.m2ling.domain.parameters.impl.ParameterDefinitionImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.m2ling.domain.parameters.impl.ParameterDefinitionImpl#getDefaultValue <em>Default Value</em>}</li>
 *   <li>{@link org.m2ling.domain.parameters.impl.ParameterDefinitionImpl#getExampleValue <em>Example Value</em>}</li>
 *   <li>{@link org.m2ling.domain.parameters.impl.ParameterDefinitionImpl#getDerivationExpression <em>Derivation Expression</em>}</li>
 *   <li>{@link org.m2ling.domain.parameters.impl.ParameterDefinitionImpl#getOverriders <em>Overriders</em>}</li>
 *   <li>{@link org.m2ling.domain.parameters.impl.ParameterDefinitionImpl#getLongDescription <em>Long Description</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ParameterDefinitionImpl extends HasCommentImpl implements ParameterDefinition {
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
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

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
	 * The cached value of the '{@link #getParent() <em>Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParent()
	 * @generated
	 * @ordered
	 */
	protected HasParameterDefinitions parent;

	/**
	 * The cached value of the '{@link #getConstraints() <em>Constraints</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstraints()
	 * @generated
	 * @ordered
	 */
	protected EList<ParameterConstraint> constraints;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final ParameterType TYPE_EDEFAULT = ParameterType.BOOLEAN;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected ParameterType type = TYPE_EDEFAULT;

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
	 * The default value of the '{@link #getDefaultValue() <em>Default Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultValue()
	 * @generated
	 * @ordered
	 */
	protected static final String DEFAULT_VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDefaultValue() <em>Default Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultValue()
	 * @generated
	 * @ordered
	 */
	protected String defaultValue = DEFAULT_VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getExampleValue() <em>Example Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExampleValue()
	 * @generated
	 * @ordered
	 */
	protected static final String EXAMPLE_VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getExampleValue() <em>Example Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExampleValue()
	 * @generated
	 * @ordered
	 */
	protected String exampleValue = EXAMPLE_VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDerivationExpression() <em>Derivation Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDerivationExpression()
	 * @generated
	 * @ordered
	 */
	protected static final String DERIVATION_EXPRESSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDerivationExpression() <em>Derivation Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDerivationExpression()
	 * @generated
	 * @ordered
	 */
	protected String derivationExpression = DERIVATION_EXPRESSION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOverriders() <em>Overriders</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOverriders()
	 * @generated
	 * @ordered
	 */
	protected EList<ParamDefOverrider> overriders;

	/**
	 * The default value of the '{@link #getLongDescription() <em>Long Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLongDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String LONG_DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLongDescription() <em>Long Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLongDescription()
	 * @generated
	 * @ordered
	 */
	protected String longDescription = LONG_DESCRIPTION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ParameterDefinitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ParametersPackage.Literals.PARAMETER_DEFINITION;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ParametersPackage.PARAMETER_DEFINITION__CUSTOM_PROPERTIES, oldCustomProperties, customProperties));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ParametersPackage.PARAMETER_DEFINITION__CUSTOM_PROPERTIES, oldCustomProperties, customProperties));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ParametersPackage.PARAMETER_DEFINITION__ID, oldId, id));
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
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ParametersPackage.PARAMETER_DEFINITION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HasParameterDefinitions getParent() {
		if (parent != null && parent.eIsProxy()) {
			InternalEObject oldParent = (InternalEObject)parent;
			parent = (HasParameterDefinitions)eResolveProxy(oldParent);
			if (parent != oldParent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ParametersPackage.PARAMETER_DEFINITION__PARENT, oldParent, parent));
			}
		}
		return parent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HasParameterDefinitions basicGetParent() {
		return parent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParent(HasParameterDefinitions newParent) {
		HasParameterDefinitions oldParent = parent;
		parent = newParent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ParametersPackage.PARAMETER_DEFINITION__PARENT, oldParent, parent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ParameterConstraint> getConstraints() {
		if (constraints == null) {
			constraints = new EObjectContainmentEList<ParameterConstraint>(ParameterConstraint.class, this, ParametersPackage.PARAMETER_DEFINITION__CONSTRAINTS);
		}
		return constraints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParameterType getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(ParameterType newType) {
		ParameterType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ParametersPackage.PARAMETER_DEFINITION__TYPE, oldType, type));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ParametersPackage.PARAMETER_DEFINITION__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDefaultValue() {
		return defaultValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultValue(String newDefaultValue) {
		String oldDefaultValue = defaultValue;
		defaultValue = newDefaultValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ParametersPackage.PARAMETER_DEFINITION__DEFAULT_VALUE, oldDefaultValue, defaultValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getExampleValue() {
		return exampleValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExampleValue(String newExampleValue) {
		String oldExampleValue = exampleValue;
		exampleValue = newExampleValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ParametersPackage.PARAMETER_DEFINITION__EXAMPLE_VALUE, oldExampleValue, exampleValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDerivationExpression() {
		return derivationExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDerivationExpression(String newDerivationExpression) {
		String oldDerivationExpression = derivationExpression;
		derivationExpression = newDerivationExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ParametersPackage.PARAMETER_DEFINITION__DERIVATION_EXPRESSION, oldDerivationExpression, derivationExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ParamDefOverrider> getOverriders() {
		if (overriders == null) {
			overriders = new EObjectContainmentEList<ParamDefOverrider>(ParamDefOverrider.class, this, ParametersPackage.PARAMETER_DEFINITION__OVERRIDERS);
		}
		return overriders;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLongDescription() {
		return longDescription;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLongDescription(String newLongDescription) {
		String oldLongDescription = longDescription;
		longDescription = newLongDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ParametersPackage.PARAMETER_DEFINITION__LONG_DESCRIPTION, oldLongDescription, longDescription));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void castParentAsComponent() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void castParentAsEngine() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ParametersPackage.PARAMETER_DEFINITION__CONSTRAINTS:
				return ((InternalEList<?>)getConstraints()).basicRemove(otherEnd, msgs);
			case ParametersPackage.PARAMETER_DEFINITION__OVERRIDERS:
				return ((InternalEList<?>)getOverriders()).basicRemove(otherEnd, msgs);
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
			case ParametersPackage.PARAMETER_DEFINITION__CUSTOM_PROPERTIES:
				if (resolve) return getCustomProperties();
				return basicGetCustomProperties();
			case ParametersPackage.PARAMETER_DEFINITION__ID:
				return getId();
			case ParametersPackage.PARAMETER_DEFINITION__NAME:
				return getName();
			case ParametersPackage.PARAMETER_DEFINITION__PARENT:
				if (resolve) return getParent();
				return basicGetParent();
			case ParametersPackage.PARAMETER_DEFINITION__CONSTRAINTS:
				return getConstraints();
			case ParametersPackage.PARAMETER_DEFINITION__TYPE:
				return getType();
			case ParametersPackage.PARAMETER_DEFINITION__DESCRIPTION:
				return getDescription();
			case ParametersPackage.PARAMETER_DEFINITION__DEFAULT_VALUE:
				return getDefaultValue();
			case ParametersPackage.PARAMETER_DEFINITION__EXAMPLE_VALUE:
				return getExampleValue();
			case ParametersPackage.PARAMETER_DEFINITION__DERIVATION_EXPRESSION:
				return getDerivationExpression();
			case ParametersPackage.PARAMETER_DEFINITION__OVERRIDERS:
				return getOverriders();
			case ParametersPackage.PARAMETER_DEFINITION__LONG_DESCRIPTION:
				return getLongDescription();
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
			case ParametersPackage.PARAMETER_DEFINITION__CUSTOM_PROPERTIES:
				setCustomProperties((CustomProperty)newValue);
				return;
			case ParametersPackage.PARAMETER_DEFINITION__ID:
				setId((String)newValue);
				return;
			case ParametersPackage.PARAMETER_DEFINITION__NAME:
				setName((String)newValue);
				return;
			case ParametersPackage.PARAMETER_DEFINITION__PARENT:
				setParent((HasParameterDefinitions)newValue);
				return;
			case ParametersPackage.PARAMETER_DEFINITION__CONSTRAINTS:
				getConstraints().clear();
				getConstraints().addAll((Collection<? extends ParameterConstraint>)newValue);
				return;
			case ParametersPackage.PARAMETER_DEFINITION__TYPE:
				setType((ParameterType)newValue);
				return;
			case ParametersPackage.PARAMETER_DEFINITION__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case ParametersPackage.PARAMETER_DEFINITION__DEFAULT_VALUE:
				setDefaultValue((String)newValue);
				return;
			case ParametersPackage.PARAMETER_DEFINITION__EXAMPLE_VALUE:
				setExampleValue((String)newValue);
				return;
			case ParametersPackage.PARAMETER_DEFINITION__DERIVATION_EXPRESSION:
				setDerivationExpression((String)newValue);
				return;
			case ParametersPackage.PARAMETER_DEFINITION__OVERRIDERS:
				getOverriders().clear();
				getOverriders().addAll((Collection<? extends ParamDefOverrider>)newValue);
				return;
			case ParametersPackage.PARAMETER_DEFINITION__LONG_DESCRIPTION:
				setLongDescription((String)newValue);
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
			case ParametersPackage.PARAMETER_DEFINITION__CUSTOM_PROPERTIES:
				setCustomProperties((CustomProperty)null);
				return;
			case ParametersPackage.PARAMETER_DEFINITION__ID:
				setId(ID_EDEFAULT);
				return;
			case ParametersPackage.PARAMETER_DEFINITION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ParametersPackage.PARAMETER_DEFINITION__PARENT:
				setParent((HasParameterDefinitions)null);
				return;
			case ParametersPackage.PARAMETER_DEFINITION__CONSTRAINTS:
				getConstraints().clear();
				return;
			case ParametersPackage.PARAMETER_DEFINITION__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case ParametersPackage.PARAMETER_DEFINITION__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case ParametersPackage.PARAMETER_DEFINITION__DEFAULT_VALUE:
				setDefaultValue(DEFAULT_VALUE_EDEFAULT);
				return;
			case ParametersPackage.PARAMETER_DEFINITION__EXAMPLE_VALUE:
				setExampleValue(EXAMPLE_VALUE_EDEFAULT);
				return;
			case ParametersPackage.PARAMETER_DEFINITION__DERIVATION_EXPRESSION:
				setDerivationExpression(DERIVATION_EXPRESSION_EDEFAULT);
				return;
			case ParametersPackage.PARAMETER_DEFINITION__OVERRIDERS:
				getOverriders().clear();
				return;
			case ParametersPackage.PARAMETER_DEFINITION__LONG_DESCRIPTION:
				setLongDescription(LONG_DESCRIPTION_EDEFAULT);
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
			case ParametersPackage.PARAMETER_DEFINITION__CUSTOM_PROPERTIES:
				return customProperties != null;
			case ParametersPackage.PARAMETER_DEFINITION__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case ParametersPackage.PARAMETER_DEFINITION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ParametersPackage.PARAMETER_DEFINITION__PARENT:
				return parent != null;
			case ParametersPackage.PARAMETER_DEFINITION__CONSTRAINTS:
				return constraints != null && !constraints.isEmpty();
			case ParametersPackage.PARAMETER_DEFINITION__TYPE:
				return type != TYPE_EDEFAULT;
			case ParametersPackage.PARAMETER_DEFINITION__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case ParametersPackage.PARAMETER_DEFINITION__DEFAULT_VALUE:
				return DEFAULT_VALUE_EDEFAULT == null ? defaultValue != null : !DEFAULT_VALUE_EDEFAULT.equals(defaultValue);
			case ParametersPackage.PARAMETER_DEFINITION__EXAMPLE_VALUE:
				return EXAMPLE_VALUE_EDEFAULT == null ? exampleValue != null : !EXAMPLE_VALUE_EDEFAULT.equals(exampleValue);
			case ParametersPackage.PARAMETER_DEFINITION__DERIVATION_EXPRESSION:
				return DERIVATION_EXPRESSION_EDEFAULT == null ? derivationExpression != null : !DERIVATION_EXPRESSION_EDEFAULT.equals(derivationExpression);
			case ParametersPackage.PARAMETER_DEFINITION__OVERRIDERS:
				return overriders != null && !overriders.isEmpty();
			case ParametersPackage.PARAMETER_DEFINITION__LONG_DESCRIPTION:
				return LONG_DESCRIPTION_EDEFAULT == null ? longDescription != null : !LONG_DESCRIPTION_EDEFAULT.equals(longDescription);
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
				case ParametersPackage.PARAMETER_DEFINITION__CUSTOM_PROPERTIES: return CorePackage.HAS_CUSTOM_PROPERTIES__CUSTOM_PROPERTIES;
				default: return -1;
			}
		}
		if (baseClass == HasName.class) {
			switch (derivedFeatureID) {
				case ParametersPackage.PARAMETER_DEFINITION__ID: return CorePackage.HAS_NAME__ID;
				case ParametersPackage.PARAMETER_DEFINITION__NAME: return CorePackage.HAS_NAME__NAME;
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
				case CorePackage.HAS_CUSTOM_PROPERTIES__CUSTOM_PROPERTIES: return ParametersPackage.PARAMETER_DEFINITION__CUSTOM_PROPERTIES;
				default: return -1;
			}
		}
		if (baseClass == HasName.class) {
			switch (baseFeatureID) {
				case CorePackage.HAS_NAME__ID: return ParametersPackage.PARAMETER_DEFINITION__ID;
				case CorePackage.HAS_NAME__NAME: return ParametersPackage.PARAMETER_DEFINITION__NAME;
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
		result.append(name);
		result.append(", type: ");
		result.append(type);
		result.append(", description: ");
		result.append(description);
		result.append(", defaultValue: ");
		result.append(defaultValue);
		result.append(", exampleValue: ");
		result.append(exampleValue);
		result.append(", derivationExpression: ");
		result.append(derivationExpression);
		result.append(", longDescription: ");
		result.append(longDescription);
		result.append(')');
		return result.toString();
	}

} //ParameterDefinitionImpl

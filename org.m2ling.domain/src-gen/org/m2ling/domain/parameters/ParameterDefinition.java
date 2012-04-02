/**
 * Copyright (C) Bertrand Florat
 */
package org.m2ling.domain.parameters;

import org.eclipse.emf.common.util.EList;
import org.m2ling.domain.core.Constraint;
import org.m2ling.domain.core.HasComment;
import org.m2ling.domain.core.HasConstraints;
import org.m2ling.domain.core.HasCustomProperties;
import org.m2ling.domain.core.HasNameAndID;
import org.m2ling.domain.core.HasParameterDefinitions;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parameter Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.m2ling.domain.parameters.ParameterDefinition#getParent <em>Parent</em>}</li>
 *   <li>{@link org.m2ling.domain.parameters.ParameterDefinition#getConstraints <em>Constraints</em>}</li>
 *   <li>{@link org.m2ling.domain.parameters.ParameterDefinition#getType <em>Type</em>}</li>
 *   <li>{@link org.m2ling.domain.parameters.ParameterDefinition#getDescription <em>Description</em>}</li>
 *   <li>{@link org.m2ling.domain.parameters.ParameterDefinition#getDefaultValue <em>Default Value</em>}</li>
 *   <li>{@link org.m2ling.domain.parameters.ParameterDefinition#getExampleValue <em>Example Value</em>}</li>
 *   <li>{@link org.m2ling.domain.parameters.ParameterDefinition#getDerivationExpression <em>Derivation Expression</em>}</li>
 *   <li>{@link org.m2ling.domain.parameters.ParameterDefinition#getOverriders <em>Overriders</em>}</li>
 *   <li>{@link org.m2ling.domain.parameters.ParameterDefinition#getLongDescription <em>Long Description</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.m2ling.domain.parameters.ParametersPackage#getParameterDefinition()
 * @model abstract="true"
 * @generated
 */
public interface ParameterDefinition extends HasComment, HasCustomProperties, HasNameAndID, HasConstraints {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (C) Bertrand Florat";

	/**
	 * Returns the value of the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' reference.
	 * @see #setParent(HasParameterDefinitions)
	 * @see org.m2ling.domain.parameters.ParametersPackage#getParameterDefinition_Parent()
	 * @model required="true"
	 * @generated
	 */
	HasParameterDefinitions getParent();

	/**
	 * Sets the value of the '{@link org.m2ling.domain.parameters.ParameterDefinition#getParent <em>Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(HasParameterDefinitions value);

	/**
	 * Returns the value of the '<em><b>Constraints</b></em>' containment reference list.
	 * The list contents are of type {@link org.m2ling.domain.core.Constraint}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraints</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraints</em>' containment reference list.
	 * @see org.m2ling.domain.parameters.ParametersPackage#getParameterDefinition_Constraints()
	 * @model containment="true"
	 * @generated
	 */
	EList<Constraint> getConstraints();

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.m2ling.domain.parameters.ParameterType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see org.m2ling.domain.parameters.ParameterType
	 * @see #setType(ParameterType)
	 * @see org.m2ling.domain.parameters.ParametersPackage#getParameterDefinition_Type()
	 * @model
	 * @generated
	 */
	ParameterType getType();

	/**
	 * Sets the value of the '{@link org.m2ling.domain.parameters.ParameterDefinition#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see org.m2ling.domain.parameters.ParameterType
	 * @see #getType()
	 * @generated
	 */
	void setType(ParameterType value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see org.m2ling.domain.parameters.ParametersPackage#getParameterDefinition_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.m2ling.domain.parameters.ParameterDefinition#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Default Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Value</em>' attribute.
	 * @see #setDefaultValue(String)
	 * @see org.m2ling.domain.parameters.ParametersPackage#getParameterDefinition_DefaultValue()
	 * @model
	 * @generated
	 */
	String getDefaultValue();

	/**
	 * Sets the value of the '{@link org.m2ling.domain.parameters.ParameterDefinition#getDefaultValue <em>Default Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Value</em>' attribute.
	 * @see #getDefaultValue()
	 * @generated
	 */
	void setDefaultValue(String value);

	/**
	 * Returns the value of the '<em><b>Example Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Example Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Example Value</em>' attribute.
	 * @see #setExampleValue(String)
	 * @see org.m2ling.domain.parameters.ParametersPackage#getParameterDefinition_ExampleValue()
	 * @model
	 * @generated
	 */
	String getExampleValue();

	/**
	 * Sets the value of the '{@link org.m2ling.domain.parameters.ParameterDefinition#getExampleValue <em>Example Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Example Value</em>' attribute.
	 * @see #getExampleValue()
	 * @generated
	 */
	void setExampleValue(String value);

	/**
	 * Returns the value of the '<em><b>Derivation Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Derivation Expression</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Derivation Expression</em>' attribute.
	 * @see #setDerivationExpression(String)
	 * @see org.m2ling.domain.parameters.ParametersPackage#getParameterDefinition_DerivationExpression()
	 * @model
	 * @generated
	 */
	String getDerivationExpression();

	/**
	 * Sets the value of the '{@link org.m2ling.domain.parameters.ParameterDefinition#getDerivationExpression <em>Derivation Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Derivation Expression</em>' attribute.
	 * @see #getDerivationExpression()
	 * @generated
	 */
	void setDerivationExpression(String value);

	/**
	 * Returns the value of the '<em><b>Overriders</b></em>' containment reference list.
	 * The list contents are of type {@link org.m2ling.domain.parameters.ParamDefOverrider}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Overriders</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Overriders</em>' containment reference list.
	 * @see org.m2ling.domain.parameters.ParametersPackage#getParameterDefinition_Overriders()
	 * @model containment="true"
	 * @generated
	 */
	EList<ParamDefOverrider> getOverriders();

	/**
	 * Returns the value of the '<em><b>Long Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Long Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Long Description</em>' attribute.
	 * @see #setLongDescription(String)
	 * @see org.m2ling.domain.parameters.ParametersPackage#getParameterDefinition_LongDescription()
	 * @model
	 * @generated
	 */
	String getLongDescription();

	/**
	 * Sets the value of the '{@link org.m2ling.domain.parameters.ParameterDefinition#getLongDescription <em>Long Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Long Description</em>' attribute.
	 * @see #getLongDescription()
	 * @generated
	 */
	void setLongDescription(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Helper method that allows to cast the parent as a component (to be used with component parameter descriptions)
	 * 
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	void castParentAsComponent();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Helper method that allows to cast the parent as a component (to be used with engine parameter descriptions)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	void castParentAsEngine();

} // ParameterDefinition

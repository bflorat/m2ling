/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.domain.parameters;

import org.eclipse.emf.common.util.EList;
import org.m2ling.domain.core.ComponentType;
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
 *   <li>{@link org.m2ling.domain.parameters.ParameterDefinition#getTarget <em>Target</em>}</li>
 *   <li>{@link org.m2ling.domain.parameters.ParameterDefinition#getConstraints <em>Constraints</em>}</li>
 *   <li>{@link org.m2ling.domain.parameters.ParameterDefinition#getType <em>Type</em>}</li>
 *   <li>{@link org.m2ling.domain.parameters.ParameterDefinition#getDescription <em>Description</em>}</li>
 *   <li>{@link org.m2ling.domain.parameters.ParameterDefinition#getDefaultValue <em>Default Value</em>}</li>
 *   <li>{@link org.m2ling.domain.parameters.ParameterDefinition#getExampleValue <em>Example Value</em>}</li>
 *   <li>{@link org.m2ling.domain.parameters.ParameterDefinition#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.m2ling.domain.parameters.ParameterDefinition#getOverriders <em>Overriders</em>}</li>
 *   <li>{@link org.m2ling.domain.parameters.ParameterDefinition#getLongDescription <em>Long Description</em>}</li>
 *   <li>{@link org.m2ling.domain.parameters.ParameterDefinition#getTargetType <em>Target Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.m2ling.domain.parameters.ParametersPackage#getParameterDefinition()
 * @model
 * @generated
 */
public interface ParameterDefinition extends HasComment, HasCustomProperties, HasNameAndID, HasConstraints {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (C) 2012 Bertrand Florat";

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(HasParameterDefinitions)
	 * @see org.m2ling.domain.parameters.ParametersPackage#getParameterDefinition_Target()
	 * @model required="true"
	 * @generated
	 */
	HasParameterDefinitions getTarget();

	/**
	 * Sets the value of the '{@link org.m2ling.domain.parameters.ParameterDefinition#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(HasParameterDefinitions value);

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
	 * Returns the value of the '<em><b>Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression</em>' attribute.
	 * @see #setExpression(String)
	 * @see org.m2ling.domain.parameters.ParametersPackage#getParameterDefinition_Expression()
	 * @model
	 * @generated
	 */
	String getExpression();

	/**
	 * Sets the value of the '{@link org.m2ling.domain.parameters.ParameterDefinition#getExpression <em>Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression</em>' attribute.
	 * @see #getExpression()
	 * @generated
	 */
	void setExpression(String value);

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
	 * Returns the value of the '<em><b>Target Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Type</em>' reference.
	 * @see #setTargetType(ComponentType)
	 * @see org.m2ling.domain.parameters.ParametersPackage#getParameterDefinition_TargetType()
	 * @model
	 * @generated
	 */
	ComponentType getTargetType();

	/**
	 * Sets the value of the '{@link org.m2ling.domain.parameters.ParameterDefinition#getTargetType <em>Target Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Type</em>' reference.
	 * @see #getTargetType()
	 * @generated
	 */
	void setTargetType(ComponentType value);

} // ParameterDefinition

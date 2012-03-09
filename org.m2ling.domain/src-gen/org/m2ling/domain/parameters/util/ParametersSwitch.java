/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.m2ling.domain.parameters.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.m2ling.domain.core.HasComment;
import org.m2ling.domain.core.HasCustomProperties;
import org.m2ling.domain.core.HasName;

import org.m2ling.domain.parameters.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.m2ling.domain.parameters.ParametersPackage
 * @generated
 */
public class ParametersSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ParametersPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParametersSwitch() {
		if (modelPackage == null) {
			modelPackage = ParametersPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case ParametersPackage.PARAMETER_VALUE: {
				ParameterValue parameterValue = (ParameterValue)theEObject;
				T result = caseParameterValue(parameterValue);
				if (result == null) result = caseHasComment(parameterValue);
				if (result == null) result = caseHasCustomProperties(parameterValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ParametersPackage.PARAMETER_DEFINITION: {
				ParameterDefinition parameterDefinition = (ParameterDefinition)theEObject;
				T result = caseParameterDefinition(parameterDefinition);
				if (result == null) result = caseHasComment(parameterDefinition);
				if (result == null) result = caseHasCustomProperties(parameterDefinition);
				if (result == null) result = caseHasName(parameterDefinition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ParametersPackage.PARAMETER_CONSTRAINT: {
				ParameterConstraint parameterConstraint = (ParameterConstraint)theEObject;
				T result = caseParameterConstraint(parameterConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ParametersPackage.FLOAT_CONSTRAINT: {
				FloatConstraint floatConstraint = (FloatConstraint)theEObject;
				T result = caseFloatConstraint(floatConstraint);
				if (result == null) result = caseParameterConstraint(floatConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ParametersPackage.MIN_CONSTRAINT: {
				MinConstraint minConstraint = (MinConstraint)theEObject;
				T result = caseMinConstraint(minConstraint);
				if (result == null) result = caseBoundaryConstraint(minConstraint);
				if (result == null) result = caseParameterConstraint(minConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ParametersPackage.BOUNDARY_CONSTRAINT: {
				BoundaryConstraint boundaryConstraint = (BoundaryConstraint)theEObject;
				T result = caseBoundaryConstraint(boundaryConstraint);
				if (result == null) result = caseParameterConstraint(boundaryConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ParametersPackage.URL_CONSTRAINT: {
				URLConstraint urlConstraint = (URLConstraint)theEObject;
				T result = caseURLConstraint(urlConstraint);
				if (result == null) result = caseParameterConstraint(urlConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ParametersPackage.NOT_NULL_CONSTRAINT: {
				NotNullConstraint notNullConstraint = (NotNullConstraint)theEObject;
				T result = caseNotNullConstraint(notNullConstraint);
				if (result == null) result = caseParameterConstraint(notNullConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ParametersPackage.REGEXP_CONSTRAINT: {
				RegexpConstraint regexpConstraint = (RegexpConstraint)theEObject;
				T result = caseRegexpConstraint(regexpConstraint);
				if (result == null) result = caseParameterConstraint(regexpConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ParametersPackage.OCL_CONSTRAINT: {
				OCLConstraint oclConstraint = (OCLConstraint)theEObject;
				T result = caseOCLConstraint(oclConstraint);
				if (result == null) result = caseParameterConstraint(oclConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ParametersPackage.INTEGER_CONSTRAINT: {
				IntegerConstraint integerConstraint = (IntegerConstraint)theEObject;
				T result = caseIntegerConstraint(integerConstraint);
				if (result == null) result = caseParameterConstraint(integerConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ParametersPackage.MAX_CONSTRAINT: {
				MaxConstraint maxConstraint = (MaxConstraint)theEObject;
				T result = caseMaxConstraint(maxConstraint);
				if (result == null) result = caseBoundaryConstraint(maxConstraint);
				if (result == null) result = caseParameterConstraint(maxConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ParametersPackage.EMAIL_CONSTRAINT: {
				EMailConstraint eMailConstraint = (EMailConstraint)theEObject;
				T result = caseEMailConstraint(eMailConstraint);
				if (result == null) result = caseParameterConstraint(eMailConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ParametersPackage.PARAM_DEF_OVERRIDER: {
				ParamDefOverrider paramDefOverrider = (ParamDefOverrider)theEObject;
				T result = caseParamDefOverrider(paramDefOverrider);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ParametersPackage.FORMAT_CONSTRAINT: {
				FormatConstraint formatConstraint = (FormatConstraint)theEObject;
				T result = caseFormatConstraint(formatConstraint);
				if (result == null) result = caseParameterConstraint(formatConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parameter Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameter Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParameterValue(ParameterValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parameter Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameter Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParameterDefinition(ParameterDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parameter Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameter Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParameterConstraint(ParameterConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Float Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Float Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFloatConstraint(FloatConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Min Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Min Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMinConstraint(MinConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Boundary Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boundary Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBoundaryConstraint(BoundaryConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>URL Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>URL Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseURLConstraint(URLConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Not Null Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Not Null Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNotNullConstraint(NotNullConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Regexp Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Regexp Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRegexpConstraint(RegexpConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>OCL Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>OCL Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOCLConstraint(OCLConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Integer Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Integer Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIntegerConstraint(IntegerConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Max Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Max Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMaxConstraint(MaxConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EMail Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EMail Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEMailConstraint(EMailConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Param Def Overrider</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Param Def Overrider</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParamDefOverrider(ParamDefOverrider object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Format Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Format Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFormatConstraint(FormatConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Has Comment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Has Comment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHasComment(HasComment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Has Custom Properties</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Has Custom Properties</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHasCustomProperties(HasCustomProperties object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Has Name</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Has Name</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHasName(HasName object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //ParametersSwitch

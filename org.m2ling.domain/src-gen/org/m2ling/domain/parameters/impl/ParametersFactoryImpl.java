/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.m2ling.domain.parameters.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.m2ling.domain.parameters.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ParametersFactoryImpl extends EFactoryImpl implements ParametersFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ParametersFactory init() {
		try {
			ParametersFactory theParametersFactory = (ParametersFactory)EPackage.Registry.INSTANCE.getEFactory("http://m2ling.org/parameters/1.0"); 
			if (theParametersFactory != null) {
				return theParametersFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ParametersFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParametersFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ParametersPackage.PARAMETER_VALUE: return createParameterValue();
			case ParametersPackage.FLOAT_CONSTRAINT: return createFloatConstraint();
			case ParametersPackage.MIN_CONSTRAINT: return createMinConstraint();
			case ParametersPackage.URL_CONSTRAINT: return createURLConstraint();
			case ParametersPackage.NOT_NULL_CONSTRAINT: return createNotNullConstraint();
			case ParametersPackage.REGEXP_CONSTRAINT: return createRegexpConstraint();
			case ParametersPackage.OCL_CONSTRAINT: return createOCLConstraint();
			case ParametersPackage.INTEGER_CONSTRAINT: return createIntegerConstraint();
			case ParametersPackage.MAX_CONSTRAINT: return createMaxConstraint();
			case ParametersPackage.EMAIL_CONSTRAINT: return createEMailConstraint();
			case ParametersPackage.PARAM_DEF_OVERRIDER: return createParamDefOverrider();
			case ParametersPackage.FORMAT_CONSTRAINT: return createFormatConstraint();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case ParametersPackage.PARAMETER_TYPE:
				return createParameterTypeFromString(eDataType, initialValue);
			case ParametersPackage.ESTRUCTURAL_FEATURE:
				return createEStructuralFeatureFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case ParametersPackage.PARAMETER_TYPE:
				return convertParameterTypeToString(eDataType, instanceValue);
			case ParametersPackage.ESTRUCTURAL_FEATURE:
				return convertEStructuralFeatureToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParameterValue createParameterValue() {
		ParameterValueImpl parameterValue = new ParameterValueImpl();
		return parameterValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FloatConstraint createFloatConstraint() {
		FloatConstraintImpl floatConstraint = new FloatConstraintImpl();
		return floatConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MinConstraint createMinConstraint() {
		MinConstraintImpl minConstraint = new MinConstraintImpl();
		return minConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public URLConstraint createURLConstraint() {
		URLConstraintImpl urlConstraint = new URLConstraintImpl();
		return urlConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotNullConstraint createNotNullConstraint() {
		NotNullConstraintImpl notNullConstraint = new NotNullConstraintImpl();
		return notNullConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegexpConstraint createRegexpConstraint() {
		RegexpConstraintImpl regexpConstraint = new RegexpConstraintImpl();
		return regexpConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLConstraint createOCLConstraint() {
		OCLConstraintImpl oclConstraint = new OCLConstraintImpl();
		return oclConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntegerConstraint createIntegerConstraint() {
		IntegerConstraintImpl integerConstraint = new IntegerConstraintImpl();
		return integerConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MaxConstraint createMaxConstraint() {
		MaxConstraintImpl maxConstraint = new MaxConstraintImpl();
		return maxConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMailConstraint createEMailConstraint() {
		EMailConstraintImpl eMailConstraint = new EMailConstraintImpl();
		return eMailConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParamDefOverrider createParamDefOverrider() {
		ParamDefOverriderImpl paramDefOverrider = new ParamDefOverriderImpl();
		return paramDefOverrider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FormatConstraint createFormatConstraint() {
		FormatConstraintImpl formatConstraint = new FormatConstraintImpl();
		return formatConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParameterType createParameterTypeFromString(EDataType eDataType, String initialValue) {
		ParameterType result = ParameterType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertParameterTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EStructuralFeature createEStructuralFeatureFromString(EDataType eDataType, String initialValue) {
		return (EStructuralFeature)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEStructuralFeatureToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParametersPackage getParametersPackage() {
		return (ParametersPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ParametersPackage getPackage() {
		return ParametersPackage.eINSTANCE;
	}

} //ParametersFactoryImpl

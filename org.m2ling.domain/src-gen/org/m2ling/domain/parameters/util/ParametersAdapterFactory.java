/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.m2ling.domain.parameters.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.m2ling.domain.core.HasComment;
import org.m2ling.domain.core.HasCustomProperties;
import org.m2ling.domain.core.HasName;

import org.m2ling.domain.parameters.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.m2ling.domain.parameters.ParametersPackage
 * @generated
 */
public class ParametersAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ParametersPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParametersAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ParametersPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ParametersSwitch<Adapter> modelSwitch =
		new ParametersSwitch<Adapter>() {
			@Override
			public Adapter caseParameterValue(ParameterValue object) {
				return createParameterValueAdapter();
			}
			@Override
			public Adapter caseParameterDefinition(ParameterDefinition object) {
				return createParameterDefinitionAdapter();
			}
			@Override
			public Adapter caseParameterConstraint(ParameterConstraint object) {
				return createParameterConstraintAdapter();
			}
			@Override
			public Adapter caseFloatConstraint(FloatConstraint object) {
				return createFloatConstraintAdapter();
			}
			@Override
			public Adapter caseMinConstraint(MinConstraint object) {
				return createMinConstraintAdapter();
			}
			@Override
			public Adapter caseBoundaryConstraint(BoundaryConstraint object) {
				return createBoundaryConstraintAdapter();
			}
			@Override
			public Adapter caseURLConstraint(URLConstraint object) {
				return createURLConstraintAdapter();
			}
			@Override
			public Adapter caseNotNullConstraint(NotNullConstraint object) {
				return createNotNullConstraintAdapter();
			}
			@Override
			public Adapter caseRegexpConstraint(RegexpConstraint object) {
				return createRegexpConstraintAdapter();
			}
			@Override
			public Adapter caseOCLConstraint(OCLConstraint object) {
				return createOCLConstraintAdapter();
			}
			@Override
			public Adapter caseIntegerConstraint(IntegerConstraint object) {
				return createIntegerConstraintAdapter();
			}
			@Override
			public Adapter caseMaxConstraint(MaxConstraint object) {
				return createMaxConstraintAdapter();
			}
			@Override
			public Adapter caseEMailConstraint(EMailConstraint object) {
				return createEMailConstraintAdapter();
			}
			@Override
			public Adapter caseParamDefOverrider(ParamDefOverrider object) {
				return createParamDefOverriderAdapter();
			}
			@Override
			public Adapter caseFormatConstraint(FormatConstraint object) {
				return createFormatConstraintAdapter();
			}
			@Override
			public Adapter caseHasComment(HasComment object) {
				return createHasCommentAdapter();
			}
			@Override
			public Adapter caseHasCustomProperties(HasCustomProperties object) {
				return createHasCustomPropertiesAdapter();
			}
			@Override
			public Adapter caseHasName(HasName object) {
				return createHasNameAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.m2ling.domain.parameters.ParameterValue <em>Parameter Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.m2ling.domain.parameters.ParameterValue
	 * @generated
	 */
	public Adapter createParameterValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.m2ling.domain.parameters.ParameterDefinition <em>Parameter Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.m2ling.domain.parameters.ParameterDefinition
	 * @generated
	 */
	public Adapter createParameterDefinitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.m2ling.domain.parameters.ParameterConstraint <em>Parameter Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.m2ling.domain.parameters.ParameterConstraint
	 * @generated
	 */
	public Adapter createParameterConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.m2ling.domain.parameters.FloatConstraint <em>Float Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.m2ling.domain.parameters.FloatConstraint
	 * @generated
	 */
	public Adapter createFloatConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.m2ling.domain.parameters.MinConstraint <em>Min Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.m2ling.domain.parameters.MinConstraint
	 * @generated
	 */
	public Adapter createMinConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.m2ling.domain.parameters.BoundaryConstraint <em>Boundary Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.m2ling.domain.parameters.BoundaryConstraint
	 * @generated
	 */
	public Adapter createBoundaryConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.m2ling.domain.parameters.URLConstraint <em>URL Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.m2ling.domain.parameters.URLConstraint
	 * @generated
	 */
	public Adapter createURLConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.m2ling.domain.parameters.NotNullConstraint <em>Not Null Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.m2ling.domain.parameters.NotNullConstraint
	 * @generated
	 */
	public Adapter createNotNullConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.m2ling.domain.parameters.RegexpConstraint <em>Regexp Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.m2ling.domain.parameters.RegexpConstraint
	 * @generated
	 */
	public Adapter createRegexpConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.m2ling.domain.parameters.OCLConstraint <em>OCL Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.m2ling.domain.parameters.OCLConstraint
	 * @generated
	 */
	public Adapter createOCLConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.m2ling.domain.parameters.IntegerConstraint <em>Integer Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.m2ling.domain.parameters.IntegerConstraint
	 * @generated
	 */
	public Adapter createIntegerConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.m2ling.domain.parameters.MaxConstraint <em>Max Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.m2ling.domain.parameters.MaxConstraint
	 * @generated
	 */
	public Adapter createMaxConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.m2ling.domain.parameters.EMailConstraint <em>EMail Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.m2ling.domain.parameters.EMailConstraint
	 * @generated
	 */
	public Adapter createEMailConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.m2ling.domain.parameters.ParamDefOverrider <em>Param Def Overrider</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.m2ling.domain.parameters.ParamDefOverrider
	 * @generated
	 */
	public Adapter createParamDefOverriderAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.m2ling.domain.parameters.FormatConstraint <em>Format Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.m2ling.domain.parameters.FormatConstraint
	 * @generated
	 */
	public Adapter createFormatConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.m2ling.domain.core.HasComment <em>Has Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.m2ling.domain.core.HasComment
	 * @generated
	 */
	public Adapter createHasCommentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.m2ling.domain.core.HasCustomProperties <em>Has Custom Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.m2ling.domain.core.HasCustomProperties
	 * @generated
	 */
	public Adapter createHasCustomPropertiesAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.m2ling.domain.core.HasName <em>Has Name</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.m2ling.domain.core.HasName
	 * @generated
	 */
	public Adapter createHasNameAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //ParametersAdapterFactory

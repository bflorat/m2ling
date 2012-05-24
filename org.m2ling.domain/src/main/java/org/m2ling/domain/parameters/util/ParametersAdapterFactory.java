/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.domain.parameters.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.m2ling.domain.core.HasComment;
import org.m2ling.domain.core.HasConstraints;
import org.m2ling.domain.core.HasCustomProperties;
import org.m2ling.domain.core.HasNameAndID;
import org.m2ling.domain.parameters.*;
import org.m2ling.domain.parameters.ParamDefOverrider;
import org.m2ling.domain.parameters.ParameterDefinition;
import org.m2ling.domain.parameters.ParameterValue;
import org.m2ling.domain.parameters.ParametersPackage;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (C) 2012 Bertrand Florat";

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
			public Adapter caseParamDefOverrider(ParamDefOverrider object) {
				return createParamDefOverriderAdapter();
			}
			@Override
			public Adapter caseRootParameters(RootParameters object) {
				return createRootParametersAdapter();
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
			public Adapter caseHasNameAndID(HasNameAndID object) {
				return createHasNameAndIDAdapter();
			}
			@Override
			public Adapter caseHasConstraints(HasConstraints object) {
				return createHasConstraintsAdapter();
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
	 * Creates a new adapter for an object of class '{@link org.m2ling.domain.parameters.RootParameters <em>Root Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.m2ling.domain.parameters.RootParameters
	 * @generated
	 */
	public Adapter createRootParametersAdapter() {
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
	 * Creates a new adapter for an object of class '{@link org.m2ling.domain.core.HasNameAndID <em>Has Name And ID</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.m2ling.domain.core.HasNameAndID
	 * @generated
	 */
	public Adapter createHasNameAndIDAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.m2ling.domain.core.HasConstraints <em>Has Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.m2ling.domain.core.HasConstraints
	 * @generated
	 */
	public Adapter createHasConstraintsAdapter() {
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

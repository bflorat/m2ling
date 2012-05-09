/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.domain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.m2ling.domain.DomainFactory
 * @model kind="package"
 * @generated
 */
public interface DomainPackage extends EPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (C) 2012 Bertrand Florat";

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "domain";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://m2ling.org/0.1";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "m2ling_domain";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DomainPackage eINSTANCE = org.m2ling.domain.impl.DomainPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.m2ling.domain.impl.RootImpl <em>Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.m2ling.domain.impl.RootImpl
	 * @see org.m2ling.domain.impl.DomainPackageImpl#getRoot()
	 * @generated
	 */
	int ROOT = 0;

	/**
	 * The feature id for the '<em><b>View Points</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT__VIEW_POINTS = 0;

	/**
	 * The feature id for the '<em><b>Views</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT__VIEWS = 1;

	/**
	 * The feature id for the '<em><b>Param Definitions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT__PARAM_DEFINITIONS = 2;

	/**
	 * The feature id for the '<em><b>Param Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT__PARAM_VALUES = 3;

	/**
	 * The feature id for the '<em><b>Stakeholders</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT__STAKEHOLDERS = 4;

	/**
	 * The feature id for the '<em><b>Units</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT__UNITS = 5;

	/**
	 * The feature id for the '<em><b>Actors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT__ACTORS = 6;

	/**
	 * The number of structural features of the '<em>Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_FEATURE_COUNT = 7;


	/**
	 * Returns the meta object for class '{@link org.m2ling.domain.Root <em>Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Root</em>'.
	 * @see org.m2ling.domain.Root
	 * @generated
	 */
	EClass getRoot();

	/**
	 * Returns the meta object for the containment reference list '{@link org.m2ling.domain.Root#getViewPoints <em>View Points</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>View Points</em>'.
	 * @see org.m2ling.domain.Root#getViewPoints()
	 * @see #getRoot()
	 * @generated
	 */
	EReference getRoot_ViewPoints();

	/**
	 * Returns the meta object for the containment reference list '{@link org.m2ling.domain.Root#getViews <em>Views</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Views</em>'.
	 * @see org.m2ling.domain.Root#getViews()
	 * @see #getRoot()
	 * @generated
	 */
	EReference getRoot_Views();

	/**
	 * Returns the meta object for the containment reference list '{@link org.m2ling.domain.Root#getParamDefinitions <em>Param Definitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Param Definitions</em>'.
	 * @see org.m2ling.domain.Root#getParamDefinitions()
	 * @see #getRoot()
	 * @generated
	 */
	EReference getRoot_ParamDefinitions();

	/**
	 * Returns the meta object for the containment reference list '{@link org.m2ling.domain.Root#getParamValues <em>Param Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Param Values</em>'.
	 * @see org.m2ling.domain.Root#getParamValues()
	 * @see #getRoot()
	 * @generated
	 */
	EReference getRoot_ParamValues();

	/**
	 * Returns the meta object for the containment reference list '{@link org.m2ling.domain.Root#getStakeholders <em>Stakeholders</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Stakeholders</em>'.
	 * @see org.m2ling.domain.Root#getStakeholders()
	 * @see #getRoot()
	 * @generated
	 */
	EReference getRoot_Stakeholders();

	/**
	 * Returns the meta object for the containment reference list '{@link org.m2ling.domain.Root#getUnits <em>Units</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Units</em>'.
	 * @see org.m2ling.domain.Root#getUnits()
	 * @see #getRoot()
	 * @generated
	 */
	EReference getRoot_Units();

	/**
	 * Returns the meta object for the containment reference list '{@link org.m2ling.domain.Root#getActors <em>Actors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Actors</em>'.
	 * @see org.m2ling.domain.Root#getActors()
	 * @see #getRoot()
	 * @generated
	 */
	EReference getRoot_Actors();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DomainFactory getDomainFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.m2ling.domain.impl.RootImpl <em>Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.m2ling.domain.impl.RootImpl
		 * @see org.m2ling.domain.impl.DomainPackageImpl#getRoot()
		 * @generated
		 */
		EClass ROOT = eINSTANCE.getRoot();

		/**
		 * The meta object literal for the '<em><b>View Points</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROOT__VIEW_POINTS = eINSTANCE.getRoot_ViewPoints();

		/**
		 * The meta object literal for the '<em><b>Views</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROOT__VIEWS = eINSTANCE.getRoot_Views();

		/**
		 * The meta object literal for the '<em><b>Param Definitions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROOT__PARAM_DEFINITIONS = eINSTANCE.getRoot_ParamDefinitions();

		/**
		 * The meta object literal for the '<em><b>Param Values</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROOT__PARAM_VALUES = eINSTANCE.getRoot_ParamValues();

		/**
		 * The meta object literal for the '<em><b>Stakeholders</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROOT__STAKEHOLDERS = eINSTANCE.getRoot_Stakeholders();

		/**
		 * The meta object literal for the '<em><b>Units</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROOT__UNITS = eINSTANCE.getRoot_Units();

		/**
		 * The meta object literal for the '<em><b>Actors</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROOT__ACTORS = eINSTANCE.getRoot_Actors();

	}

} //DomainPackage

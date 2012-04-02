/**
 * Copyright (C) Bertrand Florat
 */
package org.m2ling.domain.principles;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.m2ling.domain.core.CorePackage;

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
 * @see org.m2ling.domain.principles.PrinciplesFactory
 * @model kind="package"
 * @generated
 */
public interface PrinciplesPackage extends EPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (C) Bertrand Florat";

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "principles";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://m2ling.org/principles/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "principles";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PrinciplesPackage eINSTANCE = org.m2ling.domain.principles.impl.PrinciplesPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.m2ling.domain.principles.impl.RuleImpl <em>Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.m2ling.domain.principles.impl.RuleImpl
	 * @see org.m2ling.domain.principles.impl.PrinciplesPackageImpl#getRule()
	 * @generated
	 */
	int RULE = 0;

	/**
	 * The feature id for the '<em><b>Custom Properties</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__CUSTOM_PROPERTIES = CorePackage.CONCEPT_ITEM__CUSTOM_PROPERTIES;

	/**
	 * The feature id for the '<em><b>Tags</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__TAGS = CorePackage.CONCEPT_ITEM__TAGS;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__LABEL = CorePackage.CONCEPT_ITEM__LABEL;

	/**
	 * The feature id for the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__STATUS = CorePackage.CONCEPT_ITEM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__PRIORITY = CorePackage.CONCEPT_ITEM_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_FEATURE_COUNT = CorePackage.CONCEPT_ITEM_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.m2ling.domain.principles.RuleStatus <em>Rule Status</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.m2ling.domain.principles.RuleStatus
	 * @see org.m2ling.domain.principles.impl.PrinciplesPackageImpl#getRuleStatus()
	 * @generated
	 */
	int RULE_STATUS = 1;

	/**
	 * The meta object id for the '{@link org.m2ling.domain.principles.Priority <em>Priority</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.m2ling.domain.principles.Priority
	 * @see org.m2ling.domain.principles.impl.PrinciplesPackageImpl#getPriority()
	 * @generated
	 */
	int PRIORITY = 2;


	/**
	 * Returns the meta object for class '{@link org.m2ling.domain.principles.Rule <em>Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rule</em>'.
	 * @see org.m2ling.domain.principles.Rule
	 * @generated
	 */
	EClass getRule();

	/**
	 * Returns the meta object for the attribute '{@link org.m2ling.domain.principles.Rule#getStatus <em>Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Status</em>'.
	 * @see org.m2ling.domain.principles.Rule#getStatus()
	 * @see #getRule()
	 * @generated
	 */
	EAttribute getRule_Status();

	/**
	 * Returns the meta object for the attribute '{@link org.m2ling.domain.principles.Rule#getPriority <em>Priority</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Priority</em>'.
	 * @see org.m2ling.domain.principles.Rule#getPriority()
	 * @see #getRule()
	 * @generated
	 */
	EAttribute getRule_Priority();

	/**
	 * Returns the meta object for enum '{@link org.m2ling.domain.principles.RuleStatus <em>Rule Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Rule Status</em>'.
	 * @see org.m2ling.domain.principles.RuleStatus
	 * @generated
	 */
	EEnum getRuleStatus();

	/**
	 * Returns the meta object for enum '{@link org.m2ling.domain.principles.Priority <em>Priority</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Priority</em>'.
	 * @see org.m2ling.domain.principles.Priority
	 * @generated
	 */
	EEnum getPriority();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	PrinciplesFactory getPrinciplesFactory();

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
		 * The meta object literal for the '{@link org.m2ling.domain.principles.impl.RuleImpl <em>Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.m2ling.domain.principles.impl.RuleImpl
		 * @see org.m2ling.domain.principles.impl.PrinciplesPackageImpl#getRule()
		 * @generated
		 */
		EClass RULE = eINSTANCE.getRule();

		/**
		 * The meta object literal for the '<em><b>Status</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RULE__STATUS = eINSTANCE.getRule_Status();

		/**
		 * The meta object literal for the '<em><b>Priority</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RULE__PRIORITY = eINSTANCE.getRule_Priority();

		/**
		 * The meta object literal for the '{@link org.m2ling.domain.principles.RuleStatus <em>Rule Status</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.m2ling.domain.principles.RuleStatus
		 * @see org.m2ling.domain.principles.impl.PrinciplesPackageImpl#getRuleStatus()
		 * @generated
		 */
		EEnum RULE_STATUS = eINSTANCE.getRuleStatus();

		/**
		 * The meta object literal for the '{@link org.m2ling.domain.principles.Priority <em>Priority</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.m2ling.domain.principles.Priority
		 * @see org.m2ling.domain.principles.impl.PrinciplesPackageImpl#getPriority()
		 * @generated
		 */
		EEnum PRIORITY = eINSTANCE.getPriority();

	}

} //PrinciplesPackage

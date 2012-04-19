/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package m2ling_glossary;

import org.eclipse.emf.ecore.EAttribute;
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
 * @see m2ling_glossary.M2ling_glossaryFactory
 * @model kind="package"
 * @generated
 */
public interface M2ling_glossaryPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "m2ling_glossary";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://m2ling.org/glossary/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "m2ling_glossary";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	M2ling_glossaryPackage eINSTANCE = m2ling_glossary.impl.M2ling_glossaryPackageImpl.init();

	/**
	 * The meta object id for the '{@link m2ling_glossary.impl.glossaryImpl <em>glossary</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see m2ling_glossary.impl.glossaryImpl
	 * @see m2ling_glossary.impl.M2ling_glossaryPackageImpl#getglossary()
	 * @generated
	 */
	int GLOSSARY = 0;

	/**
	 * The feature id for the '<em><b>Contents</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOSSARY__CONTENTS = 0;

	/**
	 * The number of structural features of the '<em>glossary</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOSSARY_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link m2ling_glossary.impl.termImpl <em>term</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see m2ling_glossary.impl.termImpl
	 * @see m2ling_glossary.impl.M2ling_glossaryPackageImpl#getterm()
	 * @generated
	 */
	int TERM = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM__NAME = 0;

	/**
	 * The feature id for the '<em><b>Internal definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM__INTERNAL_DEFINITION = 1;

	/**
	 * The feature id for the '<em><b>User definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM__USER_DEFINITION = 2;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM__COMMENT = 3;

	/**
	 * The number of structural features of the '<em>term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM_FEATURE_COUNT = 4;


	/**
	 * Returns the meta object for class '{@link m2ling_glossary.glossary <em>glossary</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>glossary</em>'.
	 * @see m2ling_glossary.glossary
	 * @generated
	 */
	EClass getglossary();

	/**
	 * Returns the meta object for the containment reference list '{@link m2ling_glossary.glossary#getContents <em>Contents</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Contents</em>'.
	 * @see m2ling_glossary.glossary#getContents()
	 * @see #getglossary()
	 * @generated
	 */
	EReference getglossary_Contents();

	/**
	 * Returns the meta object for class '{@link m2ling_glossary.term <em>term</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>term</em>'.
	 * @see m2ling_glossary.term
	 * @generated
	 */
	EClass getterm();

	/**
	 * Returns the meta object for the attribute '{@link m2ling_glossary.term#getInternal_definition <em>Internal definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Internal definition</em>'.
	 * @see m2ling_glossary.term#getInternal_definition()
	 * @see #getterm()
	 * @generated
	 */
	EAttribute getterm_Internal_definition();

	/**
	 * Returns the meta object for the attribute '{@link m2ling_glossary.term#getUser_definition <em>User definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>User definition</em>'.
	 * @see m2ling_glossary.term#getUser_definition()
	 * @see #getterm()
	 * @generated
	 */
	EAttribute getterm_User_definition();

	/**
	 * Returns the meta object for the attribute '{@link m2ling_glossary.term#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see m2ling_glossary.term#getName()
	 * @see #getterm()
	 * @generated
	 */
	EAttribute getterm_Name();

	/**
	 * Returns the meta object for the attribute '{@link m2ling_glossary.term#getComment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comment</em>'.
	 * @see m2ling_glossary.term#getComment()
	 * @see #getterm()
	 * @generated
	 */
	EAttribute getterm_Comment();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	M2ling_glossaryFactory getM2ling_glossaryFactory();

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
		 * The meta object literal for the '{@link m2ling_glossary.impl.glossaryImpl <em>glossary</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see m2ling_glossary.impl.glossaryImpl
		 * @see m2ling_glossary.impl.M2ling_glossaryPackageImpl#getglossary()
		 * @generated
		 */
		EClass GLOSSARY = eINSTANCE.getglossary();

		/**
		 * The meta object literal for the '<em><b>Contents</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GLOSSARY__CONTENTS = eINSTANCE.getglossary_Contents();

		/**
		 * The meta object literal for the '{@link m2ling_glossary.impl.termImpl <em>term</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see m2ling_glossary.impl.termImpl
		 * @see m2ling_glossary.impl.M2ling_glossaryPackageImpl#getterm()
		 * @generated
		 */
		EClass TERM = eINSTANCE.getterm();

		/**
		 * The meta object literal for the '<em><b>Internal definition</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TERM__INTERNAL_DEFINITION = eINSTANCE.getterm_Internal_definition();

		/**
		 * The meta object literal for the '<em><b>User definition</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TERM__USER_DEFINITION = eINSTANCE.getterm_User_definition();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TERM__NAME = eINSTANCE.getterm_Name();

		/**
		 * The meta object literal for the '<em><b>Comment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TERM__COMMENT = eINSTANCE.getterm_Comment();

	}

} //M2ling_glossaryPackage

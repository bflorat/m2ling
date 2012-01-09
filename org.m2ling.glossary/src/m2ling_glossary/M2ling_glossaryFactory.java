/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package m2ling_glossary;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see m2ling_glossary.M2ling_glossaryPackage
 * @generated
 */
public interface M2ling_glossaryFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	M2ling_glossaryFactory eINSTANCE = m2ling_glossary.impl.M2ling_glossaryFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>glossary</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>glossary</em>'.
	 * @generated
	 */
	glossary createglossary();

	/**
	 * Returns a new object of class '<em>term</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>term</em>'.
	 * @generated
	 */
	term createterm();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	M2ling_glossaryPackage getM2ling_glossaryPackage();

} //M2ling_glossaryFactory

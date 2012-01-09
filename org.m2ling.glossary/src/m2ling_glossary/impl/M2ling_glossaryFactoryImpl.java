/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package m2ling_glossary.impl;

import m2ling_glossary.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class M2ling_glossaryFactoryImpl extends EFactoryImpl implements M2ling_glossaryFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static M2ling_glossaryFactory init() {
		try {
			M2ling_glossaryFactory theM2ling_glossaryFactory = (M2ling_glossaryFactory)EPackage.Registry.INSTANCE.getEFactory("http://m2ling.org/glossary/1.0"); 
			if (theM2ling_glossaryFactory != null) {
				return theM2ling_glossaryFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new M2ling_glossaryFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public M2ling_glossaryFactoryImpl() {
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
			case M2ling_glossaryPackage.GLOSSARY: return createglossary();
			case M2ling_glossaryPackage.TERM: return createterm();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public glossary createglossary() {
		glossaryImpl glossary = new glossaryImpl();
		return glossary;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public term createterm() {
		termImpl term = new termImpl();
		return term;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public M2ling_glossaryPackage getM2ling_glossaryPackage() {
		return (M2ling_glossaryPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static M2ling_glossaryPackage getPackage() {
		return M2ling_glossaryPackage.eINSTANCE;
	}

} //M2ling_glossaryFactoryImpl

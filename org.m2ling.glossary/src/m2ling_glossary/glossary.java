/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package m2ling_glossary;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>glossary</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link m2ling_glossary.glossary#getContents <em>Contents</em>}</li>
 * </ul>
 * </p>
 *
 * @see m2ling_glossary.M2ling_glossaryPackage#getglossary()
 * @model
 * @generated
 */
public interface glossary extends EObject {
	/**
	 * Returns the value of the '<em><b>Contents</b></em>' containment reference list.
	 * The list contents are of type {@link m2ling_glossary.term}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contents</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contents</em>' containment reference list.
	 * @see m2ling_glossary.M2ling_glossaryPackage#getglossary_Contents()
	 * @model containment="true"
	 * @generated
	 */
	EList<term> getContents();

} // glossary

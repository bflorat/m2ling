/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package m2ling_glossary;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>term</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link m2ling_glossary.term#getName <em>Name</em>}</li>
 *   <li>{@link m2ling_glossary.term#getInternal_definition <em>Internal definition</em>}</li>
 *   <li>{@link m2ling_glossary.term#getUser_definition <em>User definition</em>}</li>
 *   <li>{@link m2ling_glossary.term#getComment <em>Comment</em>}</li>
 * </ul>
 * </p>
 *
 * @see m2ling_glossary.M2ling_glossaryPackage#getterm()
 * @model
 * @generated
 */
public interface term extends EObject {
	/**
	 * Returns the value of the '<em><b>Internal definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Internal definition</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Internal definition</em>' attribute.
	 * @see #setInternal_definition(String)
	 * @see m2ling_glossary.M2ling_glossaryPackage#getterm_Internal_definition()
	 * @model
	 * @generated
	 */
	String getInternal_definition();

	/**
	 * Sets the value of the '{@link m2ling_glossary.term#getInternal_definition <em>Internal definition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Internal definition</em>' attribute.
	 * @see #getInternal_definition()
	 * @generated
	 */
	void setInternal_definition(String value);

	/**
	 * Returns the value of the '<em><b>User definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>User definition</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>User definition</em>' attribute.
	 * @see #setUser_definition(String)
	 * @see m2ling_glossary.M2ling_glossaryPackage#getterm_User_definition()
	 * @model
	 * @generated
	 */
	String getUser_definition();

	/**
	 * Sets the value of the '{@link m2ling_glossary.term#getUser_definition <em>User definition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>User definition</em>' attribute.
	 * @see #getUser_definition()
	 * @generated
	 */
	void setUser_definition(String value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see m2ling_glossary.M2ling_glossaryPackage#getterm_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link m2ling_glossary.term#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Comment</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Comment</em>' attribute.
	 * @see #setComment(String)
	 * @see m2ling_glossary.M2ling_glossaryPackage#getterm_Comment()
	 * @model
	 * @generated
	 */
	String getComment();

	/**
	 * Sets the value of the '{@link m2ling_glossary.term#getComment <em>Comment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Comment</em>' attribute.
	 * @see #getComment()
	 * @generated
	 */
	void setComment(String value);

} // term

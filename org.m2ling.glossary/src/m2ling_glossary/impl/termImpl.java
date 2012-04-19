/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package m2ling_glossary.impl;

import m2ling_glossary.M2ling_glossaryPackage;
import m2ling_glossary.term;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>term</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link m2ling_glossary.impl.termImpl#getName <em>Name</em>}</li>
 *   <li>{@link m2ling_glossary.impl.termImpl#getInternal_definition <em>Internal definition</em>}</li>
 *   <li>{@link m2ling_glossary.impl.termImpl#getUser_definition <em>User definition</em>}</li>
 *   <li>{@link m2ling_glossary.impl.termImpl#getComment <em>Comment</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class termImpl extends EObjectImpl implements term {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getInternal_definition() <em>Internal definition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInternal_definition()
	 * @generated
	 * @ordered
	 */
	protected static final String INTERNAL_DEFINITION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInternal_definition() <em>Internal definition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInternal_definition()
	 * @generated
	 * @ordered
	 */
	protected String internal_definition = INTERNAL_DEFINITION_EDEFAULT;

	/**
	 * The default value of the '{@link #getUser_definition() <em>User definition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUser_definition()
	 * @generated
	 * @ordered
	 */
	protected static final String USER_DEFINITION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUser_definition() <em>User definition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUser_definition()
	 * @generated
	 * @ordered
	 */
	protected String user_definition = USER_DEFINITION_EDEFAULT;

	/**
	 * The default value of the '{@link #getComment() <em>Comment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComment()
	 * @generated
	 * @ordered
	 */
	protected static final String COMMENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getComment() <em>Comment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComment()
	 * @generated
	 * @ordered
	 */
	protected String comment = COMMENT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected termImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return M2ling_glossaryPackage.Literals.TERM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInternal_definition() {
		return internal_definition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInternal_definition(String newInternal_definition) {
		String oldInternal_definition = internal_definition;
		internal_definition = newInternal_definition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, M2ling_glossaryPackage.TERM__INTERNAL_DEFINITION, oldInternal_definition, internal_definition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUser_definition() {
		return user_definition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUser_definition(String newUser_definition) {
		String oldUser_definition = user_definition;
		user_definition = newUser_definition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, M2ling_glossaryPackage.TERM__USER_DEFINITION, oldUser_definition, user_definition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, M2ling_glossaryPackage.TERM__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComment(String newComment) {
		String oldComment = comment;
		comment = newComment;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, M2ling_glossaryPackage.TERM__COMMENT, oldComment, comment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case M2ling_glossaryPackage.TERM__NAME:
				return getName();
			case M2ling_glossaryPackage.TERM__INTERNAL_DEFINITION:
				return getInternal_definition();
			case M2ling_glossaryPackage.TERM__USER_DEFINITION:
				return getUser_definition();
			case M2ling_glossaryPackage.TERM__COMMENT:
				return getComment();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case M2ling_glossaryPackage.TERM__NAME:
				setName((String)newValue);
				return;
			case M2ling_glossaryPackage.TERM__INTERNAL_DEFINITION:
				setInternal_definition((String)newValue);
				return;
			case M2ling_glossaryPackage.TERM__USER_DEFINITION:
				setUser_definition((String)newValue);
				return;
			case M2ling_glossaryPackage.TERM__COMMENT:
				setComment((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case M2ling_glossaryPackage.TERM__NAME:
				setName(NAME_EDEFAULT);
				return;
			case M2ling_glossaryPackage.TERM__INTERNAL_DEFINITION:
				setInternal_definition(INTERNAL_DEFINITION_EDEFAULT);
				return;
			case M2ling_glossaryPackage.TERM__USER_DEFINITION:
				setUser_definition(USER_DEFINITION_EDEFAULT);
				return;
			case M2ling_glossaryPackage.TERM__COMMENT:
				setComment(COMMENT_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case M2ling_glossaryPackage.TERM__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case M2ling_glossaryPackage.TERM__INTERNAL_DEFINITION:
				return INTERNAL_DEFINITION_EDEFAULT == null ? internal_definition != null : !INTERNAL_DEFINITION_EDEFAULT.equals(internal_definition);
			case M2ling_glossaryPackage.TERM__USER_DEFINITION:
				return USER_DEFINITION_EDEFAULT == null ? user_definition != null : !USER_DEFINITION_EDEFAULT.equals(user_definition);
			case M2ling_glossaryPackage.TERM__COMMENT:
				return COMMENT_EDEFAULT == null ? comment != null : !COMMENT_EDEFAULT.equals(comment);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", internal_definition: ");
		result.append(internal_definition);
		result.append(", user_definition: ");
		result.append(user_definition);
		result.append(", comment: ");
		result.append(comment);
		result.append(')');
		return result.toString();
	}

} //termImpl

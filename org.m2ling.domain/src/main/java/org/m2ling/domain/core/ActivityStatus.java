/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.domain.core;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Activity Status</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.m2ling.domain.core.CorePackage#getActivityStatus()
 * @model
 * @generated
 */
public enum ActivityStatus implements Enumerator {
	/**
	 * The '<em><b>TODO</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TODO_VALUE
	 * @generated
	 * @ordered
	 */
	TODO(1, "TODO", "TODO"),

	/**
	 * The '<em><b>CANCELED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CANCELED_VALUE
	 * @generated
	 * @ordered
	 */
	CANCELED(0, "CANCELED", "CANCELED"),

	/**
	 * The '<em><b>VALIDATED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VALIDATED_VALUE
	 * @generated
	 * @ordered
	 */
	VALIDATED(2, "VALIDATED", "VALIDATED"),

	/**
	 * The '<em><b>WAITING FOR VALIDATION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WAITING_FOR_VALIDATION_VALUE
	 * @generated
	 * @ordered
	 */
	WAITING_FOR_VALIDATION(3, "WAITING_FOR_VALIDATION", "WAITING_FOR_VALIDATION");

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (C) 2012 Bertrand Florat";

	/**
	 * The '<em><b>TODO</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TODO</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TODO
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TODO_VALUE = 1;

	/**
	 * The '<em><b>CANCELED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CANCELED</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CANCELED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CANCELED_VALUE = 0;

	/**
	 * The '<em><b>VALIDATED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>VALIDATED</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #VALIDATED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int VALIDATED_VALUE = 2;

	/**
	 * The '<em><b>WAITING FOR VALIDATION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>WAITING FOR VALIDATION</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #WAITING_FOR_VALIDATION
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int WAITING_FOR_VALIDATION_VALUE = 3;

	/**
	 * An array of all the '<em><b>Activity Status</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ActivityStatus[] VALUES_ARRAY =
		new ActivityStatus[] {
			TODO,
			CANCELED,
			VALIDATED,
			WAITING_FOR_VALIDATION,
		};

	/**
	 * A public read-only list of all the '<em><b>Activity Status</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<ActivityStatus> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Activity Status</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ActivityStatus get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ActivityStatus result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Activity Status</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ActivityStatus getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ActivityStatus result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Activity Status</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ActivityStatus get(int value) {
		switch (value) {
			case TODO_VALUE: return TODO;
			case CANCELED_VALUE: return CANCELED;
			case VALIDATED_VALUE: return VALIDATED;
			case WAITING_FOR_VALIDATION_VALUE: return WAITING_FOR_VALIDATION;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private ActivityStatus(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
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
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //ActivityStatus

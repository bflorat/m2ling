/**
 * Copyright (C) Bertrand Florat
 */
package org.m2ling.domain.principles;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Priority</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.m2ling.domain.principles.PrinciplesPackage#getPriority()
 * @model
 * @generated
 */
public enum Priority implements Enumerator {
	/**
	 * The '<em><b>VERY LOW</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VERY_LOW_VALUE
	 * @generated
	 * @ordered
	 */
	VERY_LOW(0, "VERY_LOW", "VERY_LOW"),

	/**
	 * The '<em><b>LOW</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LOW_VALUE
	 * @generated
	 * @ordered
	 */
	LOW(1, "LOW", "LOW"),

	/**
	 * The '<em><b>MEDIUM</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MEDIUM_VALUE
	 * @generated
	 * @ordered
	 */
	MEDIUM(2, "MEDIUM", "MEDIUM"),

	/**
	 * The '<em><b>HIGH</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HIGH_VALUE
	 * @generated
	 * @ordered
	 */
	HIGH(3, "HIGH", "HIGH"),

	/**
	 * The '<em><b>VERY HIGH</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VERY_HIGH_VALUE
	 * @generated
	 * @ordered
	 */
	VERY_HIGH(4, "VERY_HIGH", "VERY_HIGH");

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (C) Bertrand Florat";

	/**
	 * The '<em><b>VERY LOW</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>VERY LOW</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #VERY_LOW
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int VERY_LOW_VALUE = 0;

	/**
	 * The '<em><b>LOW</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LOW</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LOW
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LOW_VALUE = 1;

	/**
	 * The '<em><b>MEDIUM</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MEDIUM</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MEDIUM
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MEDIUM_VALUE = 2;

	/**
	 * The '<em><b>HIGH</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>HIGH</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HIGH
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int HIGH_VALUE = 3;

	/**
	 * The '<em><b>VERY HIGH</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>VERY HIGH</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #VERY_HIGH
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int VERY_HIGH_VALUE = 4;

	/**
	 * An array of all the '<em><b>Priority</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final Priority[] VALUES_ARRAY =
		new Priority[] {
			VERY_LOW,
			LOW,
			MEDIUM,
			HIGH,
			VERY_HIGH,
		};

	/**
	 * A public read-only list of all the '<em><b>Priority</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<Priority> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Priority</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Priority get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Priority result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Priority</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Priority getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Priority result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Priority</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Priority get(int value) {
		switch (value) {
			case VERY_LOW_VALUE: return VERY_LOW;
			case LOW_VALUE: return LOW;
			case MEDIUM_VALUE: return MEDIUM;
			case HIGH_VALUE: return HIGH;
			case VERY_HIGH_VALUE: return VERY_HIGH;
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
	private Priority(int value, String name, String literal) {
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
	
} //Priority

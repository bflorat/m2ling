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
 * A representation of the literals of the enumeration '<em><b>Rule Status</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.m2ling.domain.core.CorePackage#getRuleStatus()
 * @model
 * @generated
 */
public enum RuleStatus implements Enumerator {
	/**
	 * The '<em><b>TO BE STUDIED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TO_BE_STUDIED_VALUE
	 * @generated
	 * @ordered
	 */
	TO_BE_STUDIED(0, "TO_BE_STUDIED", "TO_BE_STUDIED"),

	/**
	 * The '<em><b>STUDIED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STUDIED_VALUE
	 * @generated
	 * @ordered
	 */
	STUDIED(1, "STUDIED", "STUDIED"),

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
	 * The '<em><b>REFUSED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REFUSED_VALUE
	 * @generated
	 * @ordered
	 */
	REFUSED(3, "REFUSED", "REFUSED"),

	/**
	 * The '<em><b>OBSOLETE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OBSOLETE_VALUE
	 * @generated
	 * @ordered
	 */
	OBSOLETE(4, "OBSOLETE", "OBSOLETE");

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (C) 2012 Bertrand Florat";

	/**
	 * The '<em><b>TO BE STUDIED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TO BE STUDIED</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TO_BE_STUDIED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TO_BE_STUDIED_VALUE = 0;

	/**
	 * The '<em><b>STUDIED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>STUDIED</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #STUDIED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int STUDIED_VALUE = 1;

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
	 * The '<em><b>REFUSED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>REFUSED</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #REFUSED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int REFUSED_VALUE = 3;

	/**
	 * The '<em><b>OBSOLETE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OBSOLETE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OBSOLETE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int OBSOLETE_VALUE = 4;

	/**
	 * An array of all the '<em><b>Rule Status</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final RuleStatus[] VALUES_ARRAY =
		new RuleStatus[] {
			TO_BE_STUDIED,
			STUDIED,
			VALIDATED,
			REFUSED,
			OBSOLETE,
		};

	/**
	 * A public read-only list of all the '<em><b>Rule Status</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<RuleStatus> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Rule Status</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static RuleStatus get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			RuleStatus result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Rule Status</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static RuleStatus getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			RuleStatus result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Rule Status</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static RuleStatus get(int value) {
		switch (value) {
			case TO_BE_STUDIED_VALUE: return TO_BE_STUDIED;
			case STUDIED_VALUE: return STUDIED;
			case VALIDATED_VALUE: return VALIDATED;
			case REFUSED_VALUE: return REFUSED;
			case OBSOLETE_VALUE: return OBSOLETE;
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
	private RuleStatus(int value, String name, String literal) {
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
	
} //RuleStatus

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
 * A representation of the literals of the enumeration '<em><b>Link Temporality</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.m2ling.domain.core.CorePackage#getLinkTemporality()
 * @model
 * @generated
 */
public enum LinkTemporality implements Enumerator {
	/**
	 * The '<em><b>SYNC</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SYNC_VALUE
	 * @generated
	 * @ordered
	 */
	SYNC(0, "SYNC", "SYNC"),

	/**
	 * The '<em><b>ASYNC PULL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ASYNC_PULL_VALUE
	 * @generated
	 * @ordered
	 */
	ASYNC_PULL(1, "ASYNC_PULL", "ASYNC_PULL"),

	/**
	 * The '<em><b>ASYNC PUSH</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ASYNC_PUSH_VALUE
	 * @generated
	 * @ordered
	 */
	ASYNC_PUSH(2, "ASYNC_PUSH", "ASYNC_PUSH");

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (C) 2012 Bertrand Florat";

	/**
	 * The '<em><b>SYNC</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SYNC</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SYNC
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SYNC_VALUE = 0;

	/**
	 * The '<em><b>ASYNC PULL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ASYNC PULL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ASYNC_PULL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ASYNC_PULL_VALUE = 1;

	/**
	 * The '<em><b>ASYNC PUSH</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ASYNC PUSH</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ASYNC_PUSH
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ASYNC_PUSH_VALUE = 2;

	/**
	 * An array of all the '<em><b>Link Temporality</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final LinkTemporality[] VALUES_ARRAY =
		new LinkTemporality[] {
			SYNC,
			ASYNC_PULL,
			ASYNC_PUSH,
		};

	/**
	 * A public read-only list of all the '<em><b>Link Temporality</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<LinkTemporality> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Link Temporality</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static LinkTemporality get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			LinkTemporality result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Link Temporality</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static LinkTemporality getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			LinkTemporality result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Link Temporality</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static LinkTemporality get(int value) {
		switch (value) {
			case SYNC_VALUE: return SYNC;
			case ASYNC_PULL_VALUE: return ASYNC_PULL;
			case ASYNC_PUSH_VALUE: return ASYNC_PUSH;
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
	private LinkTemporality(int value, String name, String literal) {
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
	
} //LinkTemporality

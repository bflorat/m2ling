/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.domain.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import junit.textui.TestRunner;

import org.m2ling.domain.configuration.tests.ConfigurationTests;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>M2ling</b></em>' model.
 * <!-- end-user-doc -->
 * @generated
 */
public class M2lingAllTests extends TestSuite {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (C) 2012 Bertrand Florat";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(suite());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Test suite() {
		TestSuite suite = new M2lingAllTests("M2ling Tests");
		suite.addTest(ConfigurationTests.suite());
		return suite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public M2lingAllTests(String name) {
		super(name);
	}

} //M2lingAllTests

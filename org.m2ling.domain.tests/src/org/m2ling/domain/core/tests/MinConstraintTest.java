/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.domain.core.tests;

import junit.textui.TestRunner;

import org.m2ling.domain.core.CoreFactory;
import org.m2ling.domain.core.MinConstraint;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Min Constraint</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class MinConstraintTest extends BoundaryConstraintTest {

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
		TestRunner.run(MinConstraintTest.class);
	}

	/**
	 * Constructs a new Min Constraint test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MinConstraintTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Min Constraint test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected MinConstraint getFixture() {
		return (MinConstraint)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(CoreFactory.eINSTANCE.createMinConstraint());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

} //MinConstraintTest

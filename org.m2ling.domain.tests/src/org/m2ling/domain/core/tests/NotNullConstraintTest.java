/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.domain.core.tests;

import junit.textui.TestRunner;

import org.m2ling.domain.core.CoreFactory;
import org.m2ling.domain.core.NotNullConstraint;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Not Null Constraint</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class NotNullConstraintTest extends ConstraintTest {

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
		TestRunner.run(NotNullConstraintTest.class);
	}

	/**
	 * Constructs a new Not Null Constraint test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotNullConstraintTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Not Null Constraint test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected NotNullConstraint getFixture() {
		return (NotNullConstraint)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(CoreFactory.eINSTANCE.createNotNullConstraint());
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

} //NotNullConstraintTest

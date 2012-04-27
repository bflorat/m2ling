/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.domain.core.tests;

import junit.textui.TestRunner;

import org.m2ling.domain.core.ActivityTransition;
import org.m2ling.domain.core.CoreFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Activity Transition</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ActivityTransitionTest extends HasCommentTest {

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
		TestRunner.run(ActivityTransitionTest.class);
	}

	/**
	 * Constructs a new Activity Transition test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActivityTransitionTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Activity Transition test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected ActivityTransition getFixture() {
		return (ActivityTransition)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(CoreFactory.eINSTANCE.createActivityTransition());
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

} //ActivityTransitionTest

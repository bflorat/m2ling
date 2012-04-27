/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.domain.parameters.tests;

import junit.textui.TestRunner;

import org.m2ling.domain.core.tests.HasCommentTest;

import org.m2ling.domain.parameters.ParameterValue;
import org.m2ling.domain.parameters.ParametersFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Parameter Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link org.m2ling.domain.parameters.ParameterValue#getFinalValue() <em>Get Final Value</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class ParameterValueTest extends HasCommentTest {

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
		TestRunner.run(ParameterValueTest.class);
	}

	/**
	 * Constructs a new Parameter Value test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParameterValueTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Parameter Value test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected ParameterValue getFixture() {
		return (ParameterValue)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(ParametersFactory.eINSTANCE.createParameterValue());
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

	/**
	 * Tests the '{@link org.m2ling.domain.parameters.ParameterValue#getFinalValue() <em>Get Final Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.m2ling.domain.parameters.ParameterValue#getFinalValue()
	 * @generated
	 */
	public void testGetFinalValue() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

} //ParameterValueTest

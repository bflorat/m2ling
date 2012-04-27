/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.domain.parameters.tests;

import junit.textui.TestRunner;
import org.m2ling.domain.core.tests.HasCommentTest;

import org.m2ling.domain.parameters.ParameterDefinition;
import org.m2ling.domain.parameters.ParametersFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Parameter Definition</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ParameterDefinitionTest extends HasCommentTest {

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
		TestRunner.run(ParameterDefinitionTest.class);
	}

	/**
	 * Constructs a new Parameter Definition test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParameterDefinitionTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Parameter Definition test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected ParameterDefinition getFixture() {
		return (ParameterDefinition)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(ParametersFactory.eINSTANCE.createParameterDefinition());
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

} //ParameterDefinitionTest

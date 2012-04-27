/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.domain.core.tests;

import junit.textui.TestRunner;

import org.m2ling.domain.core.ComponentNodeGroup;
import org.m2ling.domain.core.CoreFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Component Node Group</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ComponentNodeGroupTest extends RuntimeItemTest {

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
		TestRunner.run(ComponentNodeGroupTest.class);
	}

	/**
	 * Constructs a new Component Node Group test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentNodeGroupTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Component Node Group test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected ComponentNodeGroup getFixture() {
		return (ComponentNodeGroup)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(CoreFactory.eINSTANCE.createComponentNodeGroup());
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

} //ComponentNodeGroupTest

/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.domain.core.tests;

import junit.textui.TestRunner;

import org.m2ling.domain.core.ComponentType;
import org.m2ling.domain.core.CoreFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Component Type</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ComponentTypeTest extends ConceptItemTest {

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
		TestRunner.run(ComponentTypeTest.class);
	}

	/**
	 * Constructs a new Component Type test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentTypeTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Component Type test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected ComponentType getFixture() {
		return (ComponentType)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(CoreFactory.eINSTANCE.createComponentType());
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

} //ComponentTypeTest

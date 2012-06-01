/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.domain.configuration.tests;

import junit.framework.TestCase;
import junit.textui.TestRunner;

import org.m2ling.domain.configuration.ConfigurationFactory;
import org.m2ling.domain.configuration.RootConfiguration;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Root Configuration</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class RootConfigurationTest extends TestCase {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (C) 2012 Bertrand Florat";

	/**
	 * The fixture for this Root Configuration test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RootConfiguration fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(RootConfigurationTest.class);
	}

	/**
	 * Constructs a new Root Configuration test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RootConfigurationTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Root Configuration test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(RootConfiguration fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Root Configuration test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RootConfiguration getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(ConfigurationFactory.eINSTANCE.createRootConfiguration());
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

} //RootConfigurationTest

/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.domain.core.tests;

import junit.textui.TestRunner;

import org.m2ling.domain.core.CoreFactory;
import org.m2ling.domain.core.OrganisationalUnit;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Organisational Unit</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class OrganisationalUnitTest extends HasCommentTest {

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
		TestRunner.run(OrganisationalUnitTest.class);
	}

	/**
	 * Constructs a new Organisational Unit test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OrganisationalUnitTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Organisational Unit test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected OrganisationalUnit getFixture() {
		return (OrganisationalUnit)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(CoreFactory.eINSTANCE.createOrganisationalUnit());
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

} //OrganisationalUnitTest

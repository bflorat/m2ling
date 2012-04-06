/**
 * Copyright (C) Bertrand Florat
 */
package org.m2ling.service;

import org.concordion.integration.junit3.ConcordionTestCase;
import org.junit.Test;

import com.google.inject.Binder;
import com.google.inject.Module;

/**
 * Parent class for all m2ling fixtures. Perform integration between atunit/guice and
 * Concordion. Concordion test cases have to extends the ConcordionTestCase class
 * so they cannot extends AbstractModule Guice class binding interfaces and implementations.
 * atUnit needs : 
 * <li>the fixture to implements Module to allow binding. We simply call the real module class : FixturesModule.</li> 
 * <li>At least one test method. Concordion has to call testProcessSpecification() test so we simply route it 
 * through a boilerplate test method</li> 
 * Note that an alternative is to use a explicit default binding in the interface like @ImplementedBy(ViewPointServiceImpl.class)
 * to avoid this module binding but it would be then impossible to change the implementation used by Concordion though it may be useful
 *  
 * @author Bertrand Florat <bertrand@florat.net>
 *
 */
public class BindedConcordionTestCase extends ConcordionTestCase implements Module {

	private FixturesModule module = new FixturesModule();

	protected BindedConcordionTestCase() {
		super();
	}

	@Test
	public void testProcessSpecification() throws java.lang.Throwable {
		super.testProcessSpecification();
	}

	@Override
	public void configure(Binder arg0) {
		module.configure(arg0);
	}

}

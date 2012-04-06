/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.service;

import com.google.inject.AbstractModule;

/**
 * @author Bertrand Florat <bertrand@florat.net>
 * 
 */
public abstract class AbstractTestCase extends AbstractModule {

	/**
	 * Set here all static class-implementation bindings common between all tests. For specific
	 * implementation choices in test, simply use new <instance of your choice> when dealing with
	 * constructor injections (can't be done for field injections).
	 * 
	 * @see com.google.inject.AbstractModule#configure()
	 **/
	@Override
	protected void configure() {
	}

}

/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.specs;

import org.concordion.integration.junit3.ConcordionTestCase;
import org.junit.Test;
import org.m2ling.common.soa.Context;

/**
 * Parent class for all m2ling fixtures.
 * 
 * @author Bertrand Florat <bertrand@florat.net>
 * 
 */
public class BindedConcordionTestCase extends ConcordionTestCase {

	protected Context context;

	public BindedConcordionTestCase() {
		super();
		context = Context.newContext(Context.Entry.USER, "hceheo").add(Context.Entry.PWD_HASH,
				"8f7d88e901a5ad3a05d8cc0de93313fd76028f8c");
	}

	@Test
	public void testProcessSpecification() throws java.lang.Throwable {
		super.testProcessSpecification();
	}

}

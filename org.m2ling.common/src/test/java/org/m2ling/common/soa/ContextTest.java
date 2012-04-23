/**
 * Copyright (C) 2012 Bertrand Florat
 *
 * @author "Bertrand Florat <bertrand@florat.net>"
 */
package org.m2ling.common.soa;

import org.junit.Test;
import org.m2ling.common.soa.Context;
import org.m2ling.common.soa.Context.Entry;

import java.lang.IllegalArgumentException;

/**
 * Tests for Context
 */
public class ContextTest {

	@Test(expected = IllegalArgumentException.class)
	public void nullEntryConstructor() {
		Context.newContext(null, "");
	}

	@Test(expected = IllegalArgumentException.class)
	public void nullEntryAdd() {
		Context context = Context.newContext(Context.Entry.USER, "foo");
		context.add(null, "foo");
	}

	@Test(expected = IllegalArgumentException.class)
	public void nullValueConstructor() {
		Context.newContext(Context.Entry.USER, null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void nullValueAdd() {
		Context context = Context.newContext(Context.Entry.USER, "foo");
		context.add(Context.Entry.PWD_HASH, null);
	}

}

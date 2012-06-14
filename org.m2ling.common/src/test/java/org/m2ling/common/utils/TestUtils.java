/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.common.utils;

import static junit.framework.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * Various unit tests for Utils class.
 * 
 * @author "Bertrand Florat <bertrand@florat.net>"
 * 
 */
public class TestUtils {
	
	@Test
	public void tagsAsStringEmptyList() {
		ArrayList<String> tags = new ArrayList<String>();
		assertTrue(Utils.stringListAsString(tags).equals(""));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void tagsAsStringNullList() {
		Utils.stringListAsString(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void tagsAsStringOneNullItem() {
		ArrayList<String> tags = new ArrayList<String>();
		tags.add(null);
		Utils.stringListAsString(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void listFromIterableNull() {
		Utils.listFromIterable(null);
	}

	@Test
	public void listFromIterableVoid() {
		Iterable<String> it = new ArrayList<String>();
		List<String> list = Utils.listFromIterable(it);
		assertTrue(list.size() == 0);
	}

	@Test
	public void listFromIterableNominal() {
		Iterable<String> it = new ArrayList<String>();
		((List<String>) it).addAll(Arrays.asList(new String[] { "foo", "bar" }));
		List<String> list = Utils.listFromIterable(it);
		assertTrue(list.size() == 2);
		assertTrue(list.get(0).equals("foo"));
		assertTrue(list.get(1).equals("bar"));
	}

}

/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.service.principles;

import org.junit.runner.RunWith;
import org.m2ling.service.AbstractTestCase;

import atunit.AtUnit;
import atunit.Container;
import atunit.Container.Option;
import atunit.Unit;

import com.google.inject.Inject;

/**
 * @author Bertrand Florat <bertrand@florat.net>
 * 
 */
@RunWith(AtUnit.class)
@Container(Option.GUICE)
public class TestViewPointService extends AbstractTestCase {

	@Unit @Inject
	private ViewPointService service;
	
}

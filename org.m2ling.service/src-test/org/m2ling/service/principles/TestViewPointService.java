/**
 * Copyright (C) Bertrand Florat
 */
package org.m2ling.service.principles;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.m2ling.domain.core.ViewPoint;
import org.m2ling.service.AbstractTestCase;

import atunit.AtUnit;
import atunit.Container;
import atunit.Container.Option;
import atunit.Unit;

import com.google.inject.Inject;

/**
 * @author bflorat
 * 
 */
@RunWith(AtUnit.class)
@Container(Option.GUICE)
public class TestViewPointService extends AbstractTestCase {

	@Unit @Inject
	private ViewPointService service;

	@Test
	public void test() {
		List<ViewPoint> vps = service.getAllViewPoints();
		System.out.println(vps);
		
	}
	
}

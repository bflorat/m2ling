/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.persistence.impl;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

import java.io.IOException;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipselabs.emfpath.base.EObjects;
import org.junit.Test;
import org.m2ling.domain.core.ViewPoint;
import org.m2ling.service.AbstractTestCase;

import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;

/**
 * @author "Bertrand Florat <bertrand@florat.net>"
 * 
 */
public class PersistenceManagerTeneoImplTest extends AbstractTestCase {

	/**
	 * Copy a full mock collection into a fresh database and retrieve some items
	 * 
	 * @throws IOException
	 */
	@Test
	public void testCopyMockToDatabase() throws IOException {
		populateDatabase("Technical");
		ViewPoint vp1 = (ViewPoint) resource.getEObject("vp1");
		assertFalse(vp1 == null);
		assertEquals(vp1.getName(), "vp1");
		resource.save(null);
	}

	@Test
	public void testEClassMultiMap() throws IOException {
		populateDatabase("Technical");
		Multimap<EClass, EObject> decendantsByClass = Multimaps.index(resource.getAllContents(), EObjects.eClass);
		assertTrue(decendantsByClass.keySet().size() == 3);
	}

}

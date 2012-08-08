/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.service;

import static junit.framework.Assert.fail;

import java.io.IOException;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.junit.After;
import org.junit.Before;
import org.m2ling.common.configuration.Conf;
import org.m2ling.common.utils.Consts;
import org.m2ling.common.utils.M2lingUnitTest;
import org.m2ling.domain.DomainFactory;
import org.m2ling.domain.DomainPackage;
import org.m2ling.domain.Root;
import org.m2ling.persistence.impl.PersistenceManagerTeneoImpl;

/**
 * Parent class for all unit tests.
 * 
 * <p>
 * Factorizes Guice modules configuration and junit code.
 * </p>
 * 
 * 
 * @author Bertrand Florat <bertrand@florat.net>
 * 
 */
public class ServiceTestCase extends M2lingUnitTest{

	
	/** Convenient helper attribute to get mock root object, populated by a populateMock() call. */
	protected Root mockRoot;

	/**
	 * Convenient helper attribute to get final resource root object. Populated by a
	 * populateDatabase() call.
	 */
	protected Root root;

	/** Mock resource (XMI file). Populated by a populateMock() call. */
	protected Resource mockResource;

	/** final database resource. Populated by a populateDatabase() call. */
	protected Resource resource;

	protected PersistenceManagerTeneoImpl pm;

	/**
	 * Populate the XMI mock in memory to store it back into the database
	 * 
	 * @param mockName
	 *           name (full file should be located at org.m2ling.specs/src/specs/resources/mocks/ and
	 *           have a ".m2ling" extension.
	 */
	public void populateMock(String mockName) {
		try {
			mockResource = getXMIMockResource(mockName);
			mockResource.load(null);
			mockRoot = (Root) mockResource.getContents().get(0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
	}

	/**
	 * Populate the database with content from provided mock. Don't commit content, keeps the session
	 * opened.
	 * 
	 * @param mockName
	 * @throws IOException
	 */
	public void populateDatabase(String mockName) throws IOException {
		Conf conf = new Conf(null, logger,null);
		pm = new PersistenceManagerTeneoImpl(conf, logger);
		// Load the resource
		populateMock(mockName);
		resource = pm.getResource();
		// create the root is it doesn't exist yet
		if (resource.getContents().size() == 0) {
			root = DomainFactory.eINSTANCE.createRoot();
			resource.getContents().add(root);
		}
		// Start the copy from mock to fresh database
		root.getViewPoints().addAll(mockRoot.getViewPoints());
		root.getViews().addAll(mockRoot.getViews());
		resource.save(null);
	}

	/**
	 * Default setup code
	 * @throws Exception 
	 */
	@Before
	public void setUp() throws Exception {
		super.setUp();
	}

	/**
	 * Default tear down code
	 */
	@After
	public void tearDown() {

	}

	/**
	 * Return the XMI mock resource (full m2ling mock). *
	 * 
	 * @param mockName
	 *           name (full file should be located at org.m2ling.specs/src/specs/resources/mocks/ and
	 *           have a ".m2ling" extension.
	 * 
	 * @return the XMI mock resource
	 */
	public Resource getXMIMockResource(String mockName) {
		EPackage.Registry.INSTANCE.put(DomainPackage.eNS_URI, DomainPackage.eINSTANCE);
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put(Consts.XMI_EXTENSION, new XMIResourceFactoryImpl());
		ResourceSet rs = new ResourceSetImpl();
		URI uri = URI.createFileURI("../org.m2ling.specs/src/specs/resources/mocks/" + mockName + ".m2ling");
		Resource result = rs.createResource(uri);
		return result;
	}
}

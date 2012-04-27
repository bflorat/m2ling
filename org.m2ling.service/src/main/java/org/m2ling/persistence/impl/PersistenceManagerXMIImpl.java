/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.persistence.impl;

import java.io.IOException;
import java.util.logging.Logger;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceFactoryImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.m2ling.domain.DomainPackage;
import org.m2ling.domain.Root;
import org.m2ling.persistence.PersistenceManager;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

/**
 * Persistence Manager bringing XMI implementation (load/store from a XMI XML file on filesystem).
 * 
 * @author Bertrand Florat <bertrand@florat.net>
 * 
 */
@Singleton
public class PersistenceManagerXMIImpl implements PersistenceManager {

	/** Resource root element */
	private Root root;

	private final Logger logger;

	@Inject
	protected PersistenceManagerXMIImpl(@Named("XMI_FILE") URI mainXMLfileURI, Logger logger) throws IOException {
		this.logger = logger;
		ResourceSet rset = new ResourceSetImpl();
		// Init the top ecore package (will load transitively sub packages)
		@SuppressWarnings("unused")
		DomainPackage domainPackage = DomainPackage.eINSTANCE;
		ResourceFactoryImpl resourceFactory = new XMIResourceFactoryImpl();
		rset.getResourceFactoryRegistry().getExtensionToFactoryMap().put("m2ling", resourceFactory);
		Resource resource = rset.createResource(mainXMLfileURI);
		resource.load(null);
		this.logger.info("Loaded successfuly resource : " + mainXMLfileURI);
		// Root is always the first element in the resource
		root = (Root) resource.getContents().get(0);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.m2ling.persistence.PersistenceManager#getRoot()
	 */
	public Root getRoot() {
		return root;
	}

}

/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.persistence.impl;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceFactoryImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.m2ling.common.configuration.Conf;
import org.m2ling.domain.DomainPackage;
import org.m2ling.domain.Root;
import org.m2ling.persistence.PersistenceManager;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * Persistence Manager bringing XMI implementation (load/store from a XMI XML file on filesystem).
 * 
 * @author Bertrand Florat <bertrand@florat.net>
 * 
 */
@Singleton
public class PersistenceManagerXMIImpl implements PersistenceManager {
	private final Resource resource;

	/**
	 * List of available properties for this implementation and default connfiguration
	 * 
	 * @author "Bertrand Florat <bertrand@florat.net>"
	 * 
	 */
	@Singleton
	public static class SpecificConfiguration implements Conf.SpecificConfiguration {
		public static final String CONF_XMI_PATH = "org.m2ling.persistence.xmi.path";

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.m2ling.service.util.ServiceConfiguration.SpecificConfiguration#getDefaultConfiguration
		 * ()
		 */
		public Properties getDefaultConfiguration() {
			Properties result = new Properties();
			// Currently no property default as this persistence implementation is only used in test
			// mode.
			return result;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.m2ling.service.util.ServiceConfiguration.SpecificConfiguration#getDefaultTestConfiguration
		 * ()
		 */
		public Properties getDefaultDebugConfiguration() {
			Properties result = new Properties();
			// Search by default a mock file located at /tmp/sample.m2ling
			result.setProperty(CONF_XMI_PATH, System.getProperty("java.io.tmpdir") + "/sample.m2ling");
			return result;
		}
	}

	/** Resource root element */
	private Root root;
	private Logger logger;
	private Conf configuration;

	@Inject
	public PersistenceManagerXMIImpl(Logger logger, Conf configuration) throws IOException {
		this.configuration = configuration;
		this.logger = logger;
		// Add this specific configuration to the global service configuration
		configuration.register(new SpecificConfiguration());
		URI mainXMLfileURI = getFileURI();
		ResourceSet rset = new ResourceSetImpl();
		// Init the top ecore package (will load transitively sub packages)
		@SuppressWarnings("unused")
		DomainPackage domainPackage = DomainPackage.eINSTANCE;
		ResourceFactoryImpl resourceFactory = new XMIResourceFactoryImpl();
		rset.getResourceFactoryRegistry().getExtensionToFactoryMap().put("m2ling", resourceFactory);
		resource = rset.createResource(mainXMLfileURI);
		resource.load(null);
		logger.info("Loaded successfuly resource : " + mainXMLfileURI);
		// Root is always the first element in the resource
		root = (Root) resource.getContents().get(0);
	}

	/**
	 * Build XMI target file from configuration
	 * 
	 * @return XMI target file from configuration
	 * @throw TechnicalException if XMI file path is malformed
	 */
	private URI getFileURI() {
		URI out = null;
		String filePath = configuration.getSystemProperty(SpecificConfiguration.CONF_XMI_PATH);
		// Can throw a IllegalArgumentException if URI build fails
		out = URI.createFileURI(filePath);
		return out;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.m2ling.persistence.PersistenceManager#getRoot()
	 */
	public Root getRoot() {
		return root;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.m2ling.persistence.PersistenceManager#commit()
	 */
	@Override
	public void commit() throws Exception {
		resource.save(null);
	}
}

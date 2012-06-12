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
import org.m2ling.domain.DomainPackage;
import org.m2ling.domain.Root;
import org.m2ling.persistence.PersistenceManager;
import org.m2ling.service.util.ServiceConfiguration;

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

	/**
	 * List of available properties for this implementation and default connfiguration
	 * 
	 * @author "Bertrand Florat <bertrand@florat.net>"
	 * 
	 */
	@Singleton
	public static class SpecificConfiguration implements ServiceConfiguration.SpecificConfiguration {

		public static final String CONF_XMI_PATH = "org.m2ling.persistence.xmi.path";
		@Inject(optional = true)
		@Named(CONF_XMI_PATH)
		public String CONF_XMI_PATH_VALUE;

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
			String value = CONF_XMI_PATH_VALUE;
			result.setProperty(CONF_XMI_PATH,
					(value == null) ? "../org.m2ling.specs/src/specs/resources/mocks/Technical.m2ling" : value);
			return result;
		}
	}

	/** Resource root element */
	private Root root;

	@Inject
	private Logger logger;
	
	@Inject
	private ServiceConfiguration configuration;

	@Inject
	private SpecificConfiguration specific;


	@Inject
	protected PersistenceManagerXMIImpl() throws IOException {
		configuration.register(specific);
		URI mainXMLfileURI = getFileURI();
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

	/**
	 * Build XMI target file from configuration
	 * 
	 * @return XMI target file from configuration
	 * @throw IllegalArgumentException if XMI file path is malformed
	 * @thow IllegalStateException if XMI file path is not set in configuration
	 */
	private URI getFileURI() {
		URI out = null;
		String filePath = configuration.getSystemProperty(SpecificConfiguration.CONF_XMI_PATH);
		if (configuration == null) {
			throw new IllegalStateException("None XMI file path set in configuration");
		}
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

}

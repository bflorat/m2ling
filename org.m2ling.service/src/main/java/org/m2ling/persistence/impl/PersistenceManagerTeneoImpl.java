/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.persistence.impl;

import java.io.File;
import java.util.HashMap;
import java.util.Properties;
import java.util.logging.Logger;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.teneo.PersistenceOptions;
import org.eclipse.emf.teneo.hibernate.HbDataStore;
import org.eclipse.emf.teneo.hibernate.HbHelper;
import org.eclipse.emf.teneo.hibernate.resource.HibernateResource;
import org.hibernate.Session;
import org.hibernate.cfg.Environment;
import org.m2ling.common.utils.Consts;
import org.m2ling.domain.DomainPackage;
import org.m2ling.domain.Root;
import org.m2ling.persistence.PersistenceManager;
import org.m2ling.service.util.Configuration;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * Persistence Manager bringing Teneo implementation (load/store from a RDBMS).
 * 
 * @author Bertrand Florat <bertrand@florat.net>
 * 
 */
@Singleton
public class PersistenceManagerTeneoImpl implements PersistenceManager {

	/**
	 * List of available properties for this implementation
	 * 
	 * @author "Bertrand Florat <bertrand@florat.net>"
	 * 
	 */
	public static class SpecificConfiguration  {
		public static final String CONF_TENEO_DRIVER = Environment.DRIVER;
		public static final String CONF_TENEO_USER = Environment.USER;
		public static final String CONF_TENEO_URL = Environment.URL;
		public static final String CONF_TENEO_PASS = Environment.PASS;
		public static final String CONF_TENEO_DIALECT = Environment.DIALECT;
		public static final String CONF_TENEO_CASCADE_POLICY = PersistenceOptions.CASCADE_POLICY_ON_NON_CONTAINMENT;
		public static final String CONF_TENEO_HBM2DDL_AUTO = Environment.HBM2DDL_AUTO;

	
		/* (non-Javadoc)
		 * @see org.m2ling.service.util.Configuration#getDefaultConfiguration()
		 */
		public Properties getDefaultConfiguration() {
			Properties result = new Properties();
			result.put(CONF_TENEO_DRIVER, "org.h2.Driver");
			result.put(CONF_TENEO_USER, "sa");
			result.put(CONF_TENEO_URL, "jdbc:h2:" + Consts.M2LING_HOME_DEFAULT_ABS_PATH + File.separator
					+ Consts.DATABASE_NAME);
			result.put(CONF_TENEO_PASS, "");
			result.put(CONF_TENEO_DIALECT, org.hibernate.dialect.H2Dialect.class.getName());
			result.put(CONF_TENEO_CASCADE_POLICY, "REFRESH,PERSIST,MERGE");
			return result;
		}

		
		/* (non-Javadoc)
		 * @see org.m2ling.service.util.Configuration#getDefaultTestConfiguration()
		 */
		public Properties getDefaultTestConfiguration() {
			Properties result = new Properties();
			result.put(CONF_TENEO_DRIVER, "org.h2.Driver");
			result.put(CONF_TENEO_USER, "sa");
			result.put(CONF_TENEO_URL, "jdbc:h2:" + Consts.M2LING_HOME_DEFAULT_ABS_PATH + File.separator
					+ Consts.DATABASE_NAME + ";TRACE_LEVEL_FILE=3");
			result.put(CONF_TENEO_PASS, "");
			result.put(CONF_TENEO_CASCADE_POLICY, org.hibernate.dialect.H2Dialect.class.getName());
			result.put(PersistenceOptions.CASCADE_POLICY_ON_NON_CONTAINMENT, "REFRESH,PERSIST,MERGE");
			// Force schema drop
			result.put(CONF_TENEO_HBM2DDL_AUTO, "create");
			return result;
		}

	}

	/** M2ling model root element */
	private Root root;

	private final Configuration conf;

	private final Logger logger;

	private final HbDataStore dataStore;

	private static final String DATA_STORE_NAME = Consts.DATABASE_NAME + "_datastore";

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.m2ling.persistence.PersistenceManager#getRoot()
	 */
	public Root getRoot() {
		return root;
	}

	/**
	 * Build a Teneo-based persistence manager.
	 */
	@Inject
	public PersistenceManagerTeneoImpl(Configuration conf, Logger logger) {
		this.conf = conf;
		this.logger = logger;
		// the name of the session factory

		// create the HbDataStore using the name
		dataStore = HbHelper.INSTANCE.createRegisterDataStore(DATA_STORE_NAME);

		// set the properties
		dataStore.setDataStoreProperties(conf.getSystemProperties());

		// sets its epackages stored in this datastore (it also processes recursively sub-packages)
		dataStore.setEPackages(new EPackage[] { DomainPackage.eINSTANCE });

		// initialize, also creates the database tables
		try {
			dataStore.initialize();
		} finally {
			// print the generated mapping for debugging purpose
			logger.finest(dataStore.getMappingXML());
		}
	}

	/**
	 * Return a new hibernate session
	 * 
	 * @return a new hibernate session
	 */
	public Session newHibernateSession() {
		return dataStore.getSessionFactory().openSession();
	}

	/**
	 * Return an (unloaded) hibernate resource for the m2ling database.
	 * 
	 * @return an hibernate resource for the m2ling database
	 */
	public Resource getResource() {
		String uriStr = "hibernate://?" + HibernateResource.DS_NAME_PARAM + "=" + DATA_STORE_NAME;
		final URI uri = URI.createURI(uriStr);
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.createResource(uri);
		((ResourceImpl) resource).setIntrinsicIDToEObjectMap(new HashMap());
		return resource;
	}

}

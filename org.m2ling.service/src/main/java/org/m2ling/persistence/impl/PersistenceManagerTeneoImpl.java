/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.persistence.impl;

import java.util.logging.Logger;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.teneo.hibernate.HbDataStore;
import org.eclipse.emf.teneo.hibernate.HbHelper;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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

	/** M2ling model root element */
	private Root root;

	private final Configuration conf;

	private final Logger logger;

	private final SessionFactory sessionFactory;

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
		String hbName = "m2ling";
		// create the HbDataStore using the name
		final HbDataStore hbds = HbHelper.INSTANCE.createRegisterDataStore(hbName);

		// set the properties
		hbds.setProperties(conf.getSystemProperties());

		// sets its epackages stored in this datastore
		hbds.setEPackages(new EPackage[] { DomainPackage.eINSTANCE });

		// initialize, also creates the database tables
		try {
			hbds.initialize();
		} finally {
			// print the generated mapping
			logger.finest(hbds.getMappingXML());
		}
		sessionFactory = hbds.getSessionFactory();
	}

	/**
	 * Return a new hinernate session
	 * 
	 * @return a new hinernate session
	 */
	public Session newHibernateSession() {
		return sessionFactory.openSession();
	}
}

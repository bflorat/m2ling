/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.persistence.impl;

import java.util.logging.Logger;

import org.m2ling.domain.DomainFactory;
import org.m2ling.domain.Root;
import org.m2ling.persistence.PersistenceManager;

import com.google.inject.Singleton;

/**
 * Persistence Manager bringing in-memory implementation. Model must be created in memory by the
 * caller (probably an UT).
 * 
 * @author Bertrand Florat <bertrand@florat.net>
 * 
 */
@Singleton
public class PersistenceManagerInMemoryImpl implements PersistenceManager {

	/**M2ling model root element */
	private Root root = DomainFactory.eINSTANCE.createRoot();

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.m2ling.persistence.PersistenceManager#getRoot()
	 */
	public Root getRoot() {
		return root;
	}

	/* (non-Javadoc)
	 * @see org.m2ling.persistence.PersistenceManager#commit()
	 */
	@Override
	public void commit() {
		Logger.getAnonymousLogger().warning("This implementation doesn't support commit.");
		
	}

}

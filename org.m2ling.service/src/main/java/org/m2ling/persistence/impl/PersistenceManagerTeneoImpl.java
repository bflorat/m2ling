/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.persistence.impl;

import org.m2ling.domain.Root;
import org.m2ling.persistence.PersistenceManager;

import com.google.inject.Singleton;

/**
 * Persistence Manager bringing Teneo implementation (load/store from a RDBMS).
 * 
 * @author Bertrand Florat <bertrand@florat.net>
 * 
 */
@Singleton
public class PersistenceManagerTeneoImpl implements PersistenceManager {

	/**M2ling model root element */
	private Root root;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.m2ling.persistence.PersistenceManager#getRoot()
	 */
	public Root getRoot() {
		//TODO
		return root;
	}

}

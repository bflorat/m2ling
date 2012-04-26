/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.persistence.impl;

import org.m2ling.domain.core.CoreFactory;
import org.m2ling.domain.core.Root;
import org.m2ling.persistence.PersistenceManager;

/**
 * Persistence Manager bringing Teneo implementation (load/store from a RDBMS).
 * 
 * @author Bertrand Florat <bertrand@florat.net>
 * 
 */
public class PersistenceManagerTeneoImpl implements PersistenceManager {

	private static Root root = CoreFactory.eINSTANCE.createRoot();

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

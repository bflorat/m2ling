/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.persistence;

import org.m2ling.domain.Root;

/**
 * Provide a model root
 * 
 * @author Bertrand Florat <bertrand@florat.net>
 * 
 */
public interface PersistenceManager {

	/**
	 * Return the model root
	 * @return the model root
	 */
	public Root getRoot();
	
	/**
	 * Commit data to the underlying resource
	 */
	public void commit() throws Exception;

}

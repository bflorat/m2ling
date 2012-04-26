/**
 * Copyright (C) 2012 Bertrand Florat
 *
 * @author "Bertrand Florat <bertrand@florat.net>"
 */
package org.m2ling.persistence;

/**
 * List persistence supported to load/store domain data
 */
public enum PersistenceType {

	/**
	 * In memory storage (tests purposes), none persistence supported, the entire tree has to be
	 * created from tests
	 */
	IN_MEMORY,
	/** XMI storage (tests purposes), load/store data from XMI files created using the EMF editor */
	XML_XMI,
	/** RDBMS storage (production purpose), load/store data using Teneo into a RDBMS like H2 */
	RDBMS_TENEO
}

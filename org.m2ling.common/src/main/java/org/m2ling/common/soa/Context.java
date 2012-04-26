/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.common.soa;

import java.util.Properties;

/**
 * Contains optional context items when calling services. Known context keys are stored in the Entry
 * enum bellow.
 * 
 * Sample creation : Context.newContext(Context.Entry.USER,"hceheo").add(Context.Entry.PWD_HASH,
 * "8f7d88e901a5ad3a05d8cc0de93313fd76028f8c");
 * 
 * 
 * @author "Bertrand Florat <bertrand@florat.net>"
 * 
 */

public class Context {

	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;

	/** Internal properties storage */
	private Properties properties;

	/**
	 * List of available context entries
	 * 
	 */
	public enum Entry {
		/** User name. */
		USER,
		/** SHA1 hash of user password. */
		PWD_HASH,
		/**
		 * Resource type to load/store domain data, value should be one literal from
		 * org.m2ling.persistence.PersistenceType.
		 */
		PERSISTENCE_TYPE
	}

	/**
	 * Create a new context with initial entry and value
	 * 
	 * @param entry
	 *           One of the Context.Entry enum literal
	 * @param value
	 *           a string representation of the mapped value
	 * @return Create a new context with initial entry and value
	 */
	public static Context newContext(Entry entry, String value) {
		return new Context(entry, value);
	}

	/**
	 * Build a context
	 * 
	 * @param entry
	 *           One of the Context.Entry enum literal
	 * @param value
	 *           a string representation of the mapped value
	 * @throws IllegalArgumentException
	 *            if the value is null
	 */
	public Context(Entry entry, String value) {
		properties = new Properties();
		checkNullity(entry, value);
		properties.setProperty(entry.name(), value);
	}

	/**
	 * Add a context entry
	 * 
	 * @param entry
	 *           One of the Context.Entry enum literal
	 * @param value
	 *           a string representation of the mapped value
	 * @throws IllegalArgumentException
	 *            if the value is null
	 */
	public Context add(Entry entry, String value) {
		checkNullity(entry, value);
		properties.setProperty(entry.name(), value);
		return this;
	}

	/**
	 * Get a value for given entry
	 * 
	 * @param entry
	 *           One of the Context.Entry enum literal
	 * @return a value for given entry
	 * @throws IllegalArgumentException
	 *            if the value is null
	 */
	public String get(Entry entry) {
		return properties.getProperty(entry.name());
	}

	private void checkNullity(Entry entry, String value) {
		if (entry == null || value == null) {
			throw new IllegalArgumentException("Values can't be null");
		}
	}

}

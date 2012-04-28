/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.specs;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.eclipse.emf.common.util.URI;
import org.hibernate.cfg.Environment;
import org.m2ling.persistence.PersistenceManager;
import org.m2ling.persistence.impl.PersistenceManagerXMIImpl;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

/**
 * 
 * Default fixtures specific bindings to be injected into services
 * 
 * @author Bertrand Florat <bertrand@florat.net>
 * 
 */
public class FixturesModule extends AbstractModule {

	/** Default sample model XMI file */
	private String sampleURI = "src/specs/resources/mocks/Bikes.m2ling";

	public FixturesModule() {
	}

	/**
	 * Build a fixture module
	 * 
	 * @param sampleURI
	 *           sample m2ling model file
	 */
	public FixturesModule(String sampleURI) {
		this.sampleURI = sampleURI;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.inject.AbstractModule#configure()
	 */
	@Override
	protected void configure() {
		{// Injection bindings
			// Persistence manager choice
			bind(PersistenceManager.class).to(PersistenceManagerXMIImpl.class);

			// Mock model URI
			File file = new File(sampleURI);
			URI uri = null;
			try {
				uri = URI.createURI("file://" + file.getCanonicalPath());
			} catch (IOException e) {
				e.printStackTrace();
			}
			bind(URI.class).annotatedWith(Names.named("XMI_FILE")).toInstance(uri);
		}
	}

	/**
	 * Return a set of default configuration values.
	 * 
	 * @return
	 */
	public Properties getDefaultConfiguration() {
		String home = System.getProperty("user.home");
		Properties result = new Properties();
		result.put(Environment.DRIVER, "org.h2.Driver");
		result.put(Environment.USER, "admin");
		result.put(Environment.URL, "jdbc:h2:" + home + "/databases/m2ling");
		result.put(Environment.PASS, "changeoninstall");
		result.put(Environment.DIALECT, org.hibernate.dialect.H2Dialect.class.getName());
		return result;
	}

}

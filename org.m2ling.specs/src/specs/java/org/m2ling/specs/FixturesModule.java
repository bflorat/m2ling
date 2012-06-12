/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.specs;

import java.io.File;
import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.m2ling.persistence.PersistenceManager;
import org.m2ling.persistence.impl.PersistenceManagerXMIImpl;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.name.Names;
import com.google.inject.util.Modules;

/**
 * 
 * Default fixtures specific bindings to be injected into services
 * 
 * @author Bertrand Florat <bertrand@florat.net>
 * 
 */
public class FixturesModule extends AbstractModule{

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
	
	/**
	 * Return an injected instance of T using default test bindings
	 * 
	 * @param clazz
	 * @return an injected instance of T using default test bindings
	 */
	protected <T> T getInstance(Class<T> clazz) {
		Module finalModule = Modules.override(this).with(this);
		Injector inj = Guice.createInjector(finalModule);
		return inj.getInstance(clazz);
	}

	/**
	 * Return an injected instance of T using default test bindings
	 * 
	 * @param clazz
	 * @param overridingModule
	 * @return an injected instance of T using default test bindings
	 */
	protected <T> T getInstanceWithModule(Class<T> clazz, Module overridingModule) {
		Module finalModule = Modules.override(this).with(overridingModule);
		Injector inj = Guice.createInjector(finalModule);
		return inj.getInstance(clazz);
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

}

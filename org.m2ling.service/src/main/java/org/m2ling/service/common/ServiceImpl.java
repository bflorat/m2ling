/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.service.common;

import org.m2ling.persistence.PersistenceManager;
import org.m2ling.service.util.CoreUtil;
import org.m2ling.service.util.DTOConverter;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.util.Modules;

/**
 * @author "Bertrand Florat <bertrand@florat.net>"
 * 
 *         Common services code and top of the injection tree for service layer.
 * 
 *         <p>
 *         Each service can override or extend the Guice bindings by instantiating in a static bloc
 *         the <code>specificBindings</code> field.
 *         </p>
 * 
 *         </p>Example :</p>
 * 
 *         <pre>
 *  {@code
 * static {
 * 	specificBindings = new AbstractModule() {
 * 		{@literal @Override}
 * 			protected void configure() {
 * 				bind(PersistenceManager.class).to(PersistenceManagerXMIImpl.class).in(Singleton.class);
 * 			}
 * 		};
 * 	}
 * }
 * </pre>
 */
public class ServiceImpl {

	/**
	 * Production project-specific bindings.
	 * 
	 * @see ServiceImpl
	 */
	protected static Module specificBindings;

	/** List of service layer modules common to all projects */
	private static final Module[] PRODUCTION_BINDINGS = { new CommonGuiceModule() };

	/** Service layer sole Guice injector */
	private static Injector serviceLayerInjector = Guice.createInjector(PRODUCTION_BINDINGS);

	/** The persistence manager bringing persistence features to the services */
	@Inject
	protected PersistenceManager pmanager;

	/** DTO to domain object converter */
	@Inject
	protected DTOConverter.FromDTO fromDTO;

	/** Domain object to DTO converter */
	@Inject
	protected DTOConverter.ToDTO toDTO;

	/** Utilities class */
	@Inject
	protected CoreUtil util;
	
	/**
	 * Instantiate top level required dependencies using serviceLayerInjector injector.
	 */
	private void populateDependencies() {
		pmanager = serviceLayerInjector.getInstance(PersistenceManager.class);
		fromDTO = serviceLayerInjector.getInstance(DTOConverter.FromDTO.class);
		toDTO = serviceLayerInjector.getInstance(DTOConverter.ToDTO.class);
		util = serviceLayerInjector.getInstance(CoreUtil.class);
	}

	/**
	 * Build a ServiceImpl with optional overridden modules
	 * 
	 * @param additionalTestModules
	 *           : test-specific modules configuration overriding production one
	 */
	protected ServiceImpl(Module... additionalTestModules) {
		super();
		// Override production bindings, create a new injector for the service layer and instantiate
		// Required classes.
		if (additionalTestModules != null) {
			Module mergedModule = Modules.override(PRODUCTION_BINDINGS).with(additionalTestModules);
			serviceLayerInjector = Guice.createInjector(mergedModule);
		}
		populateDependencies();
	}

	/**
	 * Return the persistence manager. We assume that pmanager has already been initiated in static
	 * blocs or services constructor.
	 * 
	 * @return the pmanager
	 */
	public PersistenceManager getPersistenceManager() {
		return pmanager;
	}

}

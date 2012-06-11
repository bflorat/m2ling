/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.service.common;

import org.m2ling.persistence.PersistenceManager;
import org.m2ling.service.util.ServiceConfiguration;
import org.m2ling.service.util.CoreUtil;
import org.m2ling.service.util.DTOConverter;

import com.google.inject.Inject;

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

	/** Configuration */
	@Inject
	protected ServiceConfiguration conf;

	
	/**
	 * Build a ServiceImpl with optional overridden modules
	 * 
	 * @param additionalTestModules
	 *           : test-specific modules configuration overriding production one
	 */
	protected ServiceImpl() {
		super();
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

/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.service.common;

import org.m2ling.common.configuration.Configuration;
import org.m2ling.persistence.PersistenceManager;
import org.m2ling.service.util.CoreUtil;
import org.m2ling.service.util.DTOConverter;

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
abstract public class ServiceImpl {

	/** The persistence manager bringing persistence features to the services */
	protected PersistenceManager pmanager;

	/** DTO to domain object converter */
	protected DTOConverter.FromDTO fromDTO;

	/** Domain object to DTO converter */
	protected DTOConverter.ToDTO toDTO;

	/** Utilities class */
	protected CoreUtil util;

	/** Configuration */
	protected Configuration conf;

}

/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.service.common;

import java.util.logging.Logger;

import org.m2ling.common.configuration.Conf;
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
	protected Conf conf;
	/** the logger */
	protected java.util.logging.Logger logger;

	protected ServiceImpl(PersistenceManager pm, CoreUtil util, DTOConverter.FromDTO fromDTO, DTOConverter.ToDTO toDTO,
			Conf conf, Logger logger) {
		this.util = util;
		this.fromDTO = fromDTO;
		this.toDTO = toDTO;
		this.pmanager = pm;
		this.conf = conf;
		this.logger = logger;
	}
}

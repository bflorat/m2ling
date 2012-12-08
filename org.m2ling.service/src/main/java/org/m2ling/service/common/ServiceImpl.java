/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.service.common;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.m2ling.common.configuration.Conf;
import org.m2ling.common.exceptions.FunctionalException;
import org.m2ling.common.exceptions.TechnicalException;
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

	/**
	 * Final method called when exiting a service on any error
	 * 
	 * @param ex
	 *           the initial exception
	 * @throws FunctionalException
	 *            if a functional exception occurred bellow
	 * @throws TechnicalException
	 *            if any exception (especially runtime exception) occurred bellow
	 */
	protected void handleAnyException(Exception ex) throws FunctionalException, TechnicalException {
		if (ex instanceof FunctionalException) {
			logger.log(Level.FINE, "Error when processing the service", ex);
			throw (FunctionalException) ex;
		} else if (ex instanceof TechnicalException) {
			logger.log(Level.FINE, "Error when processing the service", ex);
			throw (TechnicalException) ex;
		} else {
			logger.log(Level.FINE, "Error when processing the service", ex);
			// Wrap any uncatched exception into a new TechnicalException
			throw new TechnicalException(org.m2ling.common.exceptions.TechnicalException.Code.UNKNOWN, ex, null);
		}
	}

	/**
	 * Final method called when exiting a service that may may only throw technical errors
	 * 
	 * @param ex
	 *           the initial exception
	 * @throws TechnicalException
	 *            if any exception (especially runtime exception) occurred bellow
	 */
	protected void handleTechException(Exception ex) throws TechnicalException {
		if (ex instanceof TechnicalException) {
			logger.log(Level.FINE, "Error when processing the service", ex);
			throw (TechnicalException) ex;
		} else {
			logger.log(Level.FINE, "Error when processing the service", ex);
			// Wrap any uncatched exception into a new TechnicalException
			throw new TechnicalException(org.m2ling.common.exceptions.TechnicalException.Code.UNKNOWN, ex, null);
		}
	}
}

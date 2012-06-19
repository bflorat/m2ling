/**
 * Copyright (C) 2012 Bertrand Florat
 */

package org.m2ling.presentation.events;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Logger;

import com.google.inject.Inject;
import com.google.inject.servlet.SessionScoped;

/**
 * This is a mediator managing relationships between subjects and observers
 * <p>
 * All notification methods are synchronized to assure event order.
 */
@SessionScoped
public final class ObservationManager {

	/** one event -> list of components. */
	private ObserverRegistry observerRegistry;

	/** Last event for a given subject (used for new objects that just registrated to this subject). */
	private Map<Events, Properties> hLastEventBySubject = new HashMap<Events, Properties>(10);

	/**
	 * The queue itself. Must be synchronized, so we use a ConcurrentLinkedQueue which is thread-safe
	 */
	private BlockingQueue<Event> queue = new LinkedBlockingQueue<Event>();

	private Logger logger;

	/**
	 * Empty constructor to avoid instantiating this utility class.
	 */
	@Inject
	private ObservationManager(Logger logger, ObserverRegistry registry) {
		this.logger = logger;
		this.observerRegistry = registry;
	}

	/**
	 * Register a component for a list of subjects. This calls the interface @see
	 * Observer.getRegistrationKeys() to retrieve a list of events which the Observer is interested
	 * in.
	 * 
	 * @param observer
	 *           The Observer to register.
	 */
	public synchronized void register(Observer observer) {
		Set<Events> eventSubjectSet = observer.getRegistrationKeys();
		for (Events subject : eventSubjectSet) {
			logger.finest("Register: \"" + subject + "\" by: " + observer);
			observerRegistry.register(subject, observer);
		}
	}

	/**
	 * Unregister a component for a list of subjects.
	 * 
	 * @param observer
	 *           The Observer to unregister.
	 * 
	 * @see Observer.getRegistrationKeys() is called on the Observer to get the list of events.
	 */
	public synchronized void unregister(Observer observer) {
		Set<Events> eventSubjectSet = observer.getRegistrationKeys();

		// can return null if no keys are registered
		if (eventSubjectSet == null) {
			return;
		}

		for (Events subject : eventSubjectSet) {
			boolean bRemoved = observerRegistry.unregister(subject, observer);
			if (bRemoved) {
				logger.finest("Unregister: \"" + subject + "\" from: " + observer);
			}
		}
	}

	/**
	 * Notify synchronously all components having registered for the given subject.
	 * 
	 * @param event
	 *           The event that is triggered including any additional data that is of interest as
	 *           part of the event.
	 */
	public void notifySync(Event event) {
		Events subject = event.getSubject();
		logger.finest("Notify: " + subject);
		// save last event
		hLastEventBySubject.put(subject, event.getDetails());
		observerRegistry.notifySync(event);
	}

	/**
	 * Return whether the event already occurred at least once.
	 * 
	 * @param subject
	 *           The type of event to check for.
	 * 
	 * @return true, if contains event, false otherwise.
	 */
	public boolean containsEvent(Events subject) {
		return hLastEventBySubject.containsKey(subject);
	}

	/**
	 * Return the details for last event of the given subject, or null if there is no details.
	 * 
	 * @param subject
	 *           The type of event to check for.
	 * @param sDetailName
	 *           The detailed piece of information to fetch.
	 * 
	 * @return the detail as an object or null if the event or the detail doesn't exist
	 */
	public Object getDetailLastOccurence(Events subject, String sDetailName) {
		Properties pDetails = hLastEventBySubject.get(subject);
		if (pDetails != null) {
			return pDetails.get(sDetailName);
		}
		return null;
	}

	/**
	 * Return the details for an event, or null if there is no details.
	 * 
	 * @param event
	 *           The event to retrieve the detail from.
	 * @param sDetailName
	 *           The detailed piece of information to fetch.
	 * 
	 * @return the detail as an object or null if the event or the detail doesn't exist
	 */
	public Object getDetail(Event event, String sDetailName) {
		Properties pDetails = event.getDetails();
		if (pDetails != null) {
			return pDetails.get(sDetailName);
		}
		return null;
	}

	/**
	 * Return the details for an event, or null if there is no details.
	 * 
	 * @param subject
	 *           The event to query for.
	 * 
	 * @return the details or null there are not details
	 */
	public Properties getDetailsLastOccurence(Events subject) {
		return hLastEventBySubject.get(subject);
	}

	/**
	 * Remove all registered Observers. This is mainly used in Unit Tests to get a clean state again.
	 */
	public void clear() {
		hLastEventBySubject.clear();
		queue.clear();
		observerRegistry.clear();
	}
}

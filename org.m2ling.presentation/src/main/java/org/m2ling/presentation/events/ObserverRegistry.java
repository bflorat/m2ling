/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.presentation.events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.inject.Inject;
import com.google.inject.servlet.SessionScoped;

/**
 * Registry of Observers for each of the Events. Used by ObservationManager to handle informing
 * observers about events happening in other objects.
 */
@SessionScoped
class ObserverRegistry {
	/** The list of Observers per Events. */
	private final Map<Events, List<Observer>> hEventComponents = new Hashtable<Events, List<Observer>>(10);
	/** Number of current executions for a given event. */
	private Map<Event, Integer> canals = new HashMap<Event, Integer>(10);
	private Logger logger;

	@Inject
	public ObserverRegistry(Logger logger) {
		super();
		this.logger = logger;
	}

	/**
	 * Calls the update method for each observer <br>
	 * We manage execution canals to limit the number of concurrent executions for a given event
	 * type. This allow to avoid thread number explosion in some error cases
	 * 
	 * @param event
	 *           The event to execute
	 */
	@SuppressWarnings("unchecked")
	void notifySync(Event event) {
		// do the synchronization on canals in two parts to do the "update" without
		// holding the lock
		synchronized (canals) {
			int numberOfExecutions = 0;
			if (canals.containsKey(event)) {
				numberOfExecutions = canals.get(event);
			}
			if (numberOfExecutions > 10) {
				logger.warning("Event overflow for : " + event);
				return;
			}
			canals.put(event, numberOfExecutions + 1);
		}
		try {
			Events subject = event.getSubject();
			List<Observer> observers = hEventComponents.get(subject);
			if (observers == null) {
				return;
			}
			// Iterate on a cloned list to avoid concurrent exceptions
			observers = (List<Observer>) ((ArrayList<Observer>) observers).clone();
			Iterator<Observer> it = observers.iterator();
			while (it.hasNext()) {
				Observer obs = it.next();
				if (obs != null) {
					try {
						obs.update(event);
					} catch (Throwable t) {
						logger.log(Level.SEVERE, "Error computing an event : " + obs, t);
					}
				}
			}
		} finally {
			synchronized (canals) {
				int numberOfExecutions = canals.get(event);
				assert (numberOfExecutions > 0);
				canals.put(event, numberOfExecutions - 1);
				// to avoid adding more and more memory via the canals-map, we should remove items when
				// they
				// reach zero again
				// the effect on memory is rather small, but it shows up after some time in memory
				// profiles
				// nevertheless.
				if (canals.get(event) == 0) {
					canals.remove(event);
				}
			}
		}
	}

	/**
	 * Register an Observer for an event.
	 * 
	 * @param subject
	 *           The event to register for.
	 * @param observer
	 *           The Observer that should be informed about the event as soon as it is reported
	 *           somewhere else.
	 */
	synchronized void register(Events subject, Observer observer) {
		List<Observer> observers = hEventComponents.get(subject);
		if (observers == null) {
			observers = new ArrayList<Observer>(1);
			hEventComponents.put(subject, observers);
		}
		// Add the observer, if it is a high priority observer, put it first in
		// queue
		if (!observers.contains(observer)) {
			observers.add(observer);
		}
	}

	/**
	 * Unregister the Observer from an event.
	 * 
	 * @param subject
	 *           The event to unregister from.
	 * @param observer
	 *           The Observer that is no longer interested in this event.
	 * 
	 * @return true if the event was unregistered, false if it was not registered (any more) and thus
	 *         did not need to be removed
	 */
	synchronized boolean unregister(Events subject, Observer observer) {
		List<Observer> alComponents = hEventComponents.get(subject);
		if (alComponents != null) {
			return alComponents.remove(observer);
		}
		return false;
	}

	/**
	 * Remove any registered item. This is mainly used in UnitTests to get a clean state again.
	 */
	synchronized public void clear() {
		hEventComponents.clear();
		synchronized (canals) {
			canals.clear();
		}
	}
}

/**
 * Copyright (C) 2012 Bertrand Florat
 */

package org.m2ling.presentation.events;

import java.util.Set;

/**
 * GoF Observer pattern Observer.
 */
public interface Observer {

  /**
   * Action to be done when receiving an event with this ID.
   * 
   * @param event The Event maps a subject and details of the event
   */
  void update(Event event);

  /**
   * Used by @see ObservationManager to retrieve all the events on which
   * the Observer wants to listen to.
   * 
   * @return A set of Events on which the Observer would like to listen.
   */
  Set<Events> getRegistrationKeys();
}

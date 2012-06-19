/**
 * Copyright (C) 2012 Bertrand Florat
 */

package org.m2ling.presentation.events;

import java.util.Properties;

/**
 * Event (Observer pattern).
 */
public class Event {

  /** Event subject. */
  private final Events subject;

  /** Event properties. */
  private Properties pDetails;

  /**
   * Event constructor.
   *
   * @param subject 
   * @param pDetails 
   */
  public Event(Events subject, Properties pDetails) {
    this.subject = subject;
    if (pDetails != null) {
      this.pDetails = pDetails;
    }
  }

  /**
   * Event constructor.
   * 
   * @param subject 
   */
  public Event(Events subject) {
    this(subject, null);
  }

  /**
   * Gets the details.
   * 
   * @return Returns the pDetails.
   */
  public Properties getDetails() {
    return pDetails;
  }

  /**
   * Gets the subject.
   * 
   * @return Returns the sSubject.
   */
  public Events getSubject() {
    return subject;
  }

  /**
   * ToString method.
   * 
   * @return the string
   */
  @Override
  public String toString() {
    // Do not display details, that can cause severe performance issue
    if (pDetails == null) {
      return subject + " no details";
    } else {
      return subject.toString();
    }
  }

  /**
   * event equals method.
   * 
   * @param obj 
   * 
   * @return true, if equals
   */
  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof Event)) {
      return false;
    }
    Event event = (Event) obj;
    boolean bOut = false;
    if (this.subject.equals(event.getSubject())) {
      if (this.pDetails == null && event.pDetails == null) {
        bOut = true;
      } else if (this.pDetails != null && event.pDetails != null
          && this.pDetails.equals(event.getDetails())) {
        bOut = true;
      }
    }
    return bOut;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    // very simple implementation, needs to be revisited if this object is used
    // heavily in HashMaps/HashSets
    // for now just combine name and id to a hashcode
    // idea taken from
    // http://www.geocities.com/technofundo/tech/java/equalhash.html
    int hash = 7;
    hash = 31 * hash + subject.hashCode();
    if (pDetails != null) {
      // Use only properties size, not hashcode because it is too heavy for large selection
      // in properties and causes concurrent modification exceptions
      hash = 31 * hash + pDetails.size();
    }
    return hash;
  }

}

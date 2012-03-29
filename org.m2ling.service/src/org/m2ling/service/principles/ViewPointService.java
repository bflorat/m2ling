package org.m2ling.service.principles;

import java.util.List;

import org.m2ling.domain.core.ViewPoint;

/**
 * Copyright (C) Bertrand Florat
 * General contract for viewpoints services implementations 
 */
public interface ViewPointService {
	/**
	 * Given a view point given a name and return it. 
	 * Note that some uncatched exceptions can occur for example if the viewpoint cannot be persisted.
	 * The method require the associated authorization to be called.
	 * @param name the view point name
	 * @return a new created viewpoint.
	 * @throws IllegalStateException if the viewpoint already exist.
	 * @throws SecurityException if the caller has not required authorization to call this method.
	 */
	ViewPoint createViewPoint(String name);
	
	/**
	 * Return all available viewpoints given user authorization and realm.
	 * If none viewpoints are available, a void list is returned.
	 * @return all available viewpoints for current user.
	 */
	List<ViewPoint> getAllViewPoints();	
	
	/**
	 * Return a viewpoint given a name if it exist, null otherwise.
	 * @throws SecurityException if current user has not the authorization to access the viewpoint. 
	 */
	ViewPoint getViewpointByName(String name);
}

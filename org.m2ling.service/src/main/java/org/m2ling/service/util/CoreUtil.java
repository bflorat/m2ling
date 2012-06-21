/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.service.util;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Logger;

import org.m2ling.common.exceptions.FunctionalException;
import org.m2ling.domain.Root;
import org.m2ling.domain.core.HasTags;
import org.m2ling.domain.core.Type;
import org.m2ling.domain.core.ViewPoint;
import org.m2ling.persistence.PersistenceManager;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * 
 * Set of M2ling core package helpers methods.
 * 
 * @author Bertrand Florat <bertrand@florat.net>
 * 
 */
@Singleton
public class CoreUtil {

	private Logger logger;

	private PersistenceManager pmanager;

	@Inject
	public CoreUtil(Logger logger, PersistenceManager pm) {
		super();
		this.logger = logger;
		this.pmanager = pm;
	}

	/**
	 * Return a viewpoint denoted by the given name or null if none matches.
	 * 
	 * @param name
	 *           the searched viewpoint name
	 * @param throwError
	 *           whether we throw an exception if the viewpoint doesn't exist
	 * @return a viewpoint denoted by the given name or null if none matches
	 * @throws IllegalArgumentException
	 *            if the viewpoint doesn't exist
	 */
	public ViewPoint getViewPointByName(String name, boolean throwError) {
		ViewPoint vp = null;
		Root root = pmanager.getRoot();
		for (ViewPoint v : root.getViewPoints()) {
			if (name.equals(v.getName())) {
				vp = v;
			}
		}
		if (vp == null) {
			throw new IllegalArgumentException("Viewpoint doesn't exist : " + name);
		}
		return vp;
	}

	/**
	 * Return a viewpoint denoted by the given id or null if none matches.
	 * 
	 * @param id
	 *           the searched viewpoint id
	 * @return a viewpoint denoted by the given name or null if none matches
	 */
	public ViewPoint getViewPointByID(String id) {
		ViewPoint vp = null;
		Root root = pmanager.getRoot();
		for (ViewPoint v : root.getViewPoints()) {
			if (id.equals(v.getId())) {
				vp = v;
			}
		}
		return vp;
	}

	/**
	 * Return any object matching provided type and ID. Note that the item ID is not necessary a "iD"
	 * attribute. This method can return null of the throwError value is false.
	 * 
	 * @param type
	 *           the HasTags item type
	 * @param itemID
	 *           the item ID to set tag to. * @param throwError throw an exception if the item
	 *           doesn't exist
	 * @return any object matching provided type and ID or null if none found
	 **/
	public Object getItemByTypeAndID(Type type, String itemID, boolean throwError) {
		if (type == Type.VIEWPOINT) {
			// For view points, the id is the name
			return getViewPointByName(itemID, throwError);
		} else {
			if (throwError) {
				// TODO
				throw new UnsupportedOperationException("Not yet implemented");
			} else {
				return null;
			}
		}
	}

	/**
	 * Return any HasTags item matching provided type and ID. Note that the item ID is not necessary
	 * a "iD" attribute.
	 * 
	 * @param type
	 *           the HasTags item type
	 * @param itemID
	 *           the item ID to set tag to.
	 * @return any object matching provided type and ID or null if none found
	 **/
	public HasTags getHasTagsByTypeAndID(Type type, String itemID) throws FunctionalException {
		Object o = getItemByTypeAndID(type, itemID, true);
		if (o != null && o instanceof HasTags) {
			return (HasTags) o;
		} else {
			String msg = "Item found but is does not support Tags: " + o;
			logger.warning(msg);
			throw new FunctionalException(FunctionalException.Code.TARGET_NOT_FOUND,
					"Item found but is does not support Tags", null, "Item : " + o);
		}
	}

	/**
	 * Return a list of comma-separated tags as an array
	 * 
	 * @param tags
	 *           the comma-separated tags
	 * @return a list of tags as an array
	 */
	public String[] getTagsArray(String tags) {
		StringTokenizer st = new StringTokenizer(",");
		List<String> result = new ArrayList<String>(5);
		while (st.hasMoreTokens()) {
			result.add(st.nextToken());
		}
		return (String[]) result.toArray();
	}

}

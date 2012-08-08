/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.service.util;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Logger;

import org.m2ling.common.exceptions.TechnicalException;
import org.m2ling.common.exceptions.TechnicalException.Code;
import org.m2ling.domain.Root;
import org.m2ling.domain.core.Component;
import org.m2ling.domain.core.ComponentType;
import org.m2ling.domain.core.Rule;
import org.m2ling.domain.core.Type;
import org.m2ling.domain.core.View;
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
	 * Return a viewpoint denoted by the given id or null if none matches.
	 * 
	 * @param id
	 *           the searched viewpoint id
	 * @return a viewpoint denoted by the given id or null if none matches
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
	 * Return a rule denoted by the given id or null if none matches.
	 * 
	 * @param id
	 *           the searched id
	 * @return an item denoted by the given id or null if none matches
	 */
	public Rule getRuleByID(String id) {
		Root root = pmanager.getRoot();
		for (ViewPoint v : root.getViewPoints()) {
			List<Rule> rules = v.getRules();
			for (Rule rule : rules) {
				if (id.equals(rule.getId())) {
					return rule;
				}
			}
		}
		return null;
	}

	/**
	 * Return a component type denoted by the given id or null if none matches.
	 * 
	 * @param id
	 *           the searched id
	 * @return an item denoted by the given id or null if none matches
	 */
	public ComponentType getComponentTypeByID(String id) {
		Root root = pmanager.getRoot();
		for (ViewPoint v : root.getViewPoints()) {
			List<ComponentType> cts = v.getComponentTypes();
			for (ComponentType ct : cts) {
				if (id.equals(ct.getId())) {
					return ct;
				}
			}
		}
		return null;
	}

	/**
	 * Return a component denoted by the given id or null if none matches.
	 * 
	 * @param id
	 *           the searched id
	 * @return an item denoted by the given id or null if none matches
	 */
	public Component getComponentByID(String id) {
		Root root = pmanager.getRoot();
		for (View v : root.getViews()) {
			List<Component> comps = v.getComponents();
			for (Component comp : comps) {
				if (id.equals(comp.getId())) {
					return comp;
				}
			}
		}
		return null;
	}

	/**
	 * Return any object matching provided type and ID or null if none matches. Note that the item ID
	 * is not necessary a "iD" attribute.
	 * 
	 * @param type
	 *           the HasTags item type
	 * @param itemID
	 *           the item ID to set tag to.
	 * @return any object matching provided type and ID or null if none found
	 **/
	public Object getItemByTypeAndID(Type type, String itemID) {
		if (type == Type.VIEWPOINT) {
			return getViewPointByID(itemID);
		} else if (type == Type.RULE) {
			return getRuleByID(itemID);
		} else if (type == Type.COMPONENT_TYPE) {
			return getComponentTypeByID(itemID);
		} else if (type == Type.COMPONENT) {
			return getComponentByID(itemID);
		} else {
			throw new TechnicalException(Code.NOT_YET_IMPLEMENTED, null, type.toString());
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

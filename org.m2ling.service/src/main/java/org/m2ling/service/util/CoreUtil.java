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
import org.m2ling.domain.core.ArchitectureItem;
import org.m2ling.domain.core.Component;
import org.m2ling.domain.core.ComponentGroup;
import org.m2ling.domain.core.ComponentInstance;
import org.m2ling.domain.core.ComponentType;
import org.m2ling.domain.core.Link;
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
		Root root = pmanager.getRoot();
		for (ViewPoint v : root.getViewPoints()) {
			if (id.equals(v.getId())) {
				return v;
			}
		}
		return null;
	}

	/**
	 * Return whether at least one HasStatus item from the given viewpoint id uses the provided
	 * status literal.
	 * 
	 * @param id
	 *           associated viewpoint id
	 * @param searched
	 *           status literal
	 * @return whether at least one HasStatus item from the given viewpoint id uses the provided
	 *         status literal
	 */
	public boolean containsStatusLiteral(String id, String statusLiteral) {
		boolean out = false;
		Root root = pmanager.getRoot();
		for (ViewPoint v : root.getViewPoints()) {
			if (id.equals(v.getId())) {
				for (Rule rule : v.getRules()) {
					if (statusLiteral.equals(rule.getStatus())) {
						return true;
					}
				}
				for (View view : root.getViews()) {
					for (Component comp : view.getComponents()) {
						if (statusLiteral.equals(comp.getStatus())) {
							return true;
						}
					}
					for (Link link : view.getLinks()) {
						if (statusLiteral.equals(link.getStatus())) {
							return true;
						}
					}
				}
			}
		}
		return out;
	}

	/**
	 * Return a rule denoted by the given id or null if none matches.
	 * 
	 * @param id
	 *           the searched id
	 * @return an item denoted by the given id or null if none matches
	 */
	public Rule getRuleByID(String id) {
		if (id == null) {
			return null;
		}
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
		if (id == null) {
			return null;
		}
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
		if (id == null) {
			return null;
		}
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
	 * Return a group denoted by the given id or null if none matches.
	 * 
	 * @param id
	 *           the searched id
	 * @return an item denoted by the given id or null if none matches
	 */
	public ComponentGroup getGroupByID(String id) {
		if (id == null) {
			return null;
		}
		Root root = pmanager.getRoot();
		for (View v : root.getViews()) {
			List<ComponentGroup> groups = v.getComponentsGroups();
			for (ComponentGroup group : groups) {
				if (id.equals(group.getId())) {
					return group;
				}
			}
		}
		return null;
	}

	/**
	 * Return a component or a group denoted by the given id or null if none matches.
	 * 
	 * @param id
	 *           the searched id
	 * @return an item denoted by the given id or null if none matches
	 */
	public ArchitectureItem getComponentOrGroupByID(String id) {
		Component comp = getComponentByID(id);
		if (comp != null) {
			return comp;
		} else {
			return getGroupByID(id);
		}
	}

	/**
	 * Return a component group denoted by the given id or null if none matches.
	 * 
	 * @param id
	 *           the searched id
	 * @return an item denoted by the given id or null if none matches
	 */
	public ComponentGroup getComponentGroupByID(String id) {
		if (id == null) {
			return null;
		}
		Root root = pmanager.getRoot();
		for (View v : root.getViews()) {
			List<ComponentGroup> groups = v.getComponentsGroups();
			for (ComponentGroup group : groups) {
				if (id.equals(group.getId())) {
					return group;
				}
			}
		}
		return null;
	}

	/**
	 * Return the component type of an architectural item. If the provided item is a group, the type
	 * of the first contained item is returned. If the item is null or if the group is void, null is
	 * returned.
	 * 
	 * @param item
	 * @return the component type of the architectural item
	 */
	public ComponentType getComponentTypeForArchitectureItem(ArchitectureItem item) {
		if (item == null) {
			return null;
		}
		if (item instanceof Component) {
			return ((Component) item).getType();
		}
		if (item instanceof ComponentGroup) {
			if (((ComponentGroup) item).getComponents().size() == 0) {
				return null;
			}
			return ((ComponentGroup) item).getComponents().get(0).getType();
		}
		return null;
	}

	/**
	 * Return all components for a given component type ID. If it contains none component, a void
	 * list is returned. If the ID is null, null is returned.
	 * 
	 * @param item
	 * @return all components for a given component type
	 */
	public List<Component> getComponentsForCTID(String ctID) {
		if (ctID == null) {
			return null;
		}
		List<Component> result = new ArrayList<Component>();
		Root root = pmanager.getRoot();
		for (View v : root.getViews()) {
			List<Component> comps = v.getComponents();
			for (Component comp : comps) {
				if (ctID.equals(comp.getType().getId())) {
					result.add(comp);
				}
			}
		}
		return result;
	}

	/**
	 * Return all components instances for a given component ID. If it contains none component, a
	 * void list is returned. If the ID is null, null is returned.
	 * 
	 * @param item
	 * @return all components instances for a given component type
	 */
	public List<ComponentInstance> getComponentsInstancesForComponentID(String ctID) {
		if (ctID == null) {
			return null;
		}
		List<ComponentInstance> result = new ArrayList<ComponentInstance>();
		Root root = pmanager.getRoot();
		for (View v : root.getViews()) {
			List<ComponentInstance> instances = v.getInstances();
			for (ComponentInstance instance : instances) {
				if (ctID.equals(instance.getComponent().getId())) {
					result.add(instance);
				}
			}
		}
		return result;
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
		if (itemID == null) {
			return null;
		}
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

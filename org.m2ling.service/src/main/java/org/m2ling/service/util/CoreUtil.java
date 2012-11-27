/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.service.util;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Logger;

import org.m2ling.common.exceptions.FunctionalException;
import org.m2ling.common.exceptions.TechnicalException;
import org.m2ling.common.exceptions.TechnicalException.Code;
import org.m2ling.domain.Root;
import org.m2ling.domain.core.ArchitectureItem;
import org.m2ling.domain.core.Component;
import org.m2ling.domain.core.ComponentGroup;
import org.m2ling.domain.core.ComponentInstance;
import org.m2ling.domain.core.ComponentInstanceGroup;
import org.m2ling.domain.core.ComponentType;
import org.m2ling.domain.core.HasNameAndID;
import org.m2ling.domain.core.Link;
import org.m2ling.domain.core.LinkInstance;
import org.m2ling.domain.core.LinkType;
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
	@SuppressWarnings("unused")
	private Logger logger;

	private PersistenceManager pmanager;

	@Inject
	public CoreUtil(Logger logger, PersistenceManager pm) {
		super();
		this.logger = logger;
		this.pmanager = pm;
	}

	/**
	 * Return a viewpoint denoted by the given id or null if none matches. Null is returned if id is
	 * null.
	 * 
	 * @param id
	 *           the searched viewpoint id
	 * @return a viewpoint denoted by the given id or null if none matches
	 */
	public ViewPoint getViewPointByID(String id) {
		if (id == null) {
			return null;
		}
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
	 * Return a rule denoted by the given id or null if none matches. Null is returned if id is null.
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
	 * Return a component type denoted by the given id or null if none matches. Null is returned if
	 * id is null.
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
	 * Return a link type denoted by the given id or null if none matches. Null is returned if id is
	 * null.
	 * 
	 * @param id
	 *           the searched id
	 * @return an item denoted by the given id or null if none matches
	 */
	public LinkType getLinkTypeByID(String id) {
		if (id == null) {
			return null;
		}
		Root root = pmanager.getRoot();
		for (ViewPoint v : root.getViewPoints()) {
			List<LinkType> lts = v.getLinkTypes();
			for (LinkType lt : lts) {
				if (id.equals(lt.getId())) {
					return lt;
				}
			}
		}
		return null;
	}

	/**
	 * Return a link denoted by the given id or null if none matches. Null is returned if id is null.
	 * 
	 * @param id
	 *           the searched id
	 * @return an item denoted by the given id or null if none matches
	 */
	public Link getLinkByID(String id) {
		if (id == null) {
			return null;
		}
		Root root = pmanager.getRoot();
		for (View v : root.getViews()) {
			List<Link> links = v.getLinks();
			for (Link link : links) {
				if (id.equals(link.getId())) {
					return link;
				}
			}
		}
		return null;
	}

	/**
	 * Return a link instance denoted by the given id or null if none matches. Null is returned if id
	 * is null.
	 * 
	 * @param id
	 *           the searched id
	 * @return an item denoted by the given id or null if none matches
	 */
	public LinkInstance getLinkInstanceByID(String id) {
		if (id == null) {
			return null;
		}
		Root root = pmanager.getRoot();
		for (View v : root.getViews()) {
			List<LinkInstance> lis = v.getLinkInstances();
			for (LinkInstance li : lis) {
				if (id.equals(li.getId())) {
					return li;
				}
			}
		}
		return null;
	}

	/**
	 * Return a component denoted by the given id or null if none matches. Null is returned if id is
	 * null.
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
	 * Return a component instance denoted by the given id or null if none matches. Null is returned
	 * if id is null.
	 * 
	 * @param id
	 *           the searched id
	 * @return an item denoted by the given id or null if none matches
	 */
	public ComponentInstance getComponentInstanceByID(String id) {
		if (id == null) {
			return null;
		}
		Root root = pmanager.getRoot();
		for (View v : root.getViews()) {
			List<ComponentInstance> cis = v.getComponentInstances();
			for (ComponentInstance ci : cis) {
				if (id.equals(ci.getId())) {
					return ci;
				}
			}
		}
		return null;
	}

	/**
	 * Return all views for a given viewpoint.
	 * <p>
	 * The list may be void if none view is of the provided vp type
	 * </p>
	 * <p>
	 * the list is not ordered
	 * </p>
	 * 
	 * @param id
	 *           the searched id
	 * @return all views for a given viewpoint.
	 * @throws FunctionalException
	 *            if the id is not associated with an existing VP
	 * @throws FunctionalException
	 *            if the provided if is null
	 */
	public List<View> getViewsByVPID(String id) throws FunctionalException {
		if (id == null) {
			throw new FunctionalException(org.m2ling.common.exceptions.FunctionalException.Code.NULL_ARGUMENT, null,
					"null vp id");
		}
		List<View> out = new ArrayList<View>(3);
		Root root = pmanager.getRoot();
		for (View v : root.getViews()) {
			if (v.getViewPoint().getId().equals(id)) {
				out.add(v);
			}
		}
		return out;
	}

	/**
	 * Return the view associated with an item or null if none.
	 * 
	 * @param item
	 *           the item
	 * @return associated view
	 */
	public View getViewByItem(Object item) {
		Root root = pmanager.getRoot();
		for (View v : root.getViews()) {
			if (item instanceof Component && v.getComponents().contains(item)) {
				return v;
			} else if (item instanceof Link && v.getLinks().contains(item)) {
				return v;
			} else if (item instanceof ComponentGroup && v.getComponentsGroups().contains(item)) {
				return v;
			} else if (item instanceof ComponentInstance && v.getComponentInstances().contains(item)) {
				return v;
			} else if (item instanceof ComponentInstanceGroup && v.getInstancesGroups().contains(item)) {
				return v;
			} else if (item instanceof LinkInstance && v.getLinkInstances().contains(item)) {
				return v;
			}
		}
		return null;
	}

	/**
	 * Return a group denoted by the given id or null if none matches. Null is returned if id is
	 * null.
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
	 * Return a component or a group denoted by the given id or null if none matches. Null is
	 * returned if id is null.
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
	 * Return a list of components for a list of architecture items.
	 * 
	 * @param items
	 *           the architecture item list
	 * @return a set of components for a list of architecture items.
	 */
	public List<Component> getComponentForArchitectureItems(List<ArchitectureItem> items) {
		List<Component> result = new ArrayList<Component>(items.size());
		for (ArchitectureItem ai : items) {
			if (ai instanceof Component) {
				result.add((Component) ai);
			} else if (ai instanceof ComponentGroup) {
				ComponentGroup group = (ComponentGroup) ai;
				result.addAll(group.getComponents());
			}
		}
		return result;
	}

	/**
	 * Return a component group denoted by the given id or null if none matches. If id is null, null
	 * is returned.
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
			List<ComponentInstance> instances = v.getComponentInstances();
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
	 * is not necessary a "iD" attribute. Null is returned if id is null.
	 * 
	 * @param type
	 *           the HasTags item type
	 * @param itemID
	 *           the item ID to set tag to.
	 * @return any object matching provided type and ID or null if none found
	 **/
	public HasNameAndID getItemByTypeAndID(Type type, String itemID) {
		if (itemID == null) {
			return null;
		}
		if (type == Type.VIEWPOINT) {
			return getViewPointByID(itemID);
		} else if (type == Type.VIEW) {
			return getViewByID(itemID);
		} else if (type == Type.RULE) {
			return getRuleByID(itemID);
		} else if (type == Type.COMPONENT_TYPE) {
			return getComponentTypeByID(itemID);
		} else if (type == Type.COMPONENT) {
			return getComponentByID(itemID);
		} else if (type == Type.COMPONENT_INSTANCE) {
			return getComponentInstanceByID(itemID);
		} else if (type == Type.LINK_TYPE) {
			return getLinkTypeByID(itemID);
		} else if (type == Type.LINK) {
			return getLinkByID(itemID);
		} else if (type == Type.LINK_INSTANCE) {
			return getLinkInstanceByID(itemID);
		} else {
			throw new TechnicalException(Code.NOT_YET_IMPLEMENTED, null, type.toString());
		}
	}

	/**
	 * Return the first item matching provided name or null if none matches. Null is returned if id
	 * is null.
	 * 
	 * @param type
	 *           the HasTags item type
	 * @param name
	 *           the item name to search for.
	 * @return the first item matching provided name or null if none matches.
	 **/
	public HasNameAndID getItemByTypeAndName(Type type, String name) {
		if (name == null) {
			return null;
		}
		if (type == Type.VIEWPOINT) {
			for (ViewPoint vp : pmanager.getRoot().getViewPoints()) {
				if (vp.getName().equals(name)) {
					return vp;
				}
			}
		} else if (type == Type.VIEW) {
			for (View v : pmanager.getRoot().getViews()) {
				if (v.getName().equals(name)) {
					return v;
				}
			}
		} else if (type == Type.RULE) {
			for (ViewPoint v : pmanager.getRoot().getViewPoints()) {
				for (Rule rule : v.getRules()) {
					if (rule.getName().equals(name)) {
						return rule;
					}
				}
			}
		} else if (type == Type.COMPONENT_TYPE) {
			for (ViewPoint v : pmanager.getRoot().getViewPoints()) {
				for (ComponentType ct : v.getComponentTypes()) {
					if (ct.getName().equals(name)) {
						return ct;
					}
				}
			}
		} else if (type == Type.LINK_TYPE) {
			for (ViewPoint v : pmanager.getRoot().getViewPoints()) {
				for (LinkType lt : v.getLinkTypes()) {
					if (lt.getName().equals(name)) {
						return lt;
					}
				}
			}
		} else if (type == Type.COMPONENT) {
			for (View v : pmanager.getRoot().getViews()) {
				for (Component comp : v.getComponents()) {
					if (comp.getName().equals(name)) {
						return comp;
					}
				}
			}
		} else if (type == Type.LINK) {
			for (View v : pmanager.getRoot().getViews()) {
				for (Link link : v.getLinks()) {
					if (link.getName().equals(name)) {
						return link;
					}
				}
			}
		} else if (type == Type.COMPONENT_INSTANCE) {
			for (View v : pmanager.getRoot().getViews()) {
				for (ComponentInstance ci : v.getComponentInstances()) {
					if (ci.getName().equals(name)) {
						return ci;
					}
				}
			}
		} else if (type == Type.LINK_INSTANCE) {
			for (View v : pmanager.getRoot().getViews()) {
				for (LinkInstance li : v.getLinkInstances()) {
					if (li.getName().equals(name)) {
						return li;
					}
				}
			}
		} else {
			throw new TechnicalException(Code.NOT_YET_IMPLEMENTED, null, type.toString());
		}
		return null;
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

	/**
	 * Return a view denoted by the given id or null if none matches. Null is returned if id is null.
	 * 
	 * @param id
	 *           the searched view id
	 * @return a view denoted by the given id or null if none matches
	 */
	public View getViewByID(String id) {
		if (id == null) {
			return null;
		}
		Root root = pmanager.getRoot();
		for (View v : root.getViews()) {
			if (id.equals(v.getId())) {
				return v;
			}
		}
		return null;
	}
}

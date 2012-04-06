/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.service.util;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.m2ling.domain.core.HasTags;
import org.m2ling.domain.core.Root;
import org.m2ling.domain.core.Type;
import org.m2ling.domain.core.ViewPoint;
import org.m2ling.persistence.ModelFactory;

/**
 * 
 * Helper classes to deal with tags.
 * 
 * @author Bertrand Florat <bertrand@florat.net>
 * 
 */
public class TagUtil {

	public void applyTags(Type type, String id, String... tags) {
		Root root = ModelFactory.getRoot();
		HasTags htags = null;
		// Find the HasTags instance associated with the provided id
		if (type == Type.VIEWPOINT) {
			for (ViewPoint v : root.getViewPoints()) {
				if (id.equals(v.getName())) {
					htags = v;
				}
			}
		}
		else {
			new ResourceImpl();
		}
		
		//TODO : manage security
		// Manage the none item found case
		if (htags == null) {
			throw new IllegalArgumentException("Viewpoint doesn't exist : "
					+ id);
		}
		// Actually set the tags
		htags.setTags(tags);
	}

}

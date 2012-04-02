/**
 * Copyright (C) Bertrand Florat
 */
package org.m2ling.service.util;

import org.m2ling.domain.core.Type;
import org.m2ling.domain.core.ViewPoint;

/**
 * 
 * Helper classes to deal with tags.
 * @author bflorat
 *
 */
public class TagUtil {
	
	public void applyTags(Type type,String id, String... tags) {
		
		
		ViewPoint vp = null;
		for (ViewPoint v : root.getViewpoints()) {
			if (name.equals(v.getName())) {
				vp = v;
			}
		}
		if (vp == null) {
			throw new IllegalArgumentException("Viewpoint doesn't exist : "
					+ name);
		}
		vp.setTags(tags);

}

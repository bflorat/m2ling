package org.m2ling.service.core.impl;

/**
 * Copyright (C) Bertrand Florat
 */

import java.util.Arrays;
import java.util.logging.Logger;

import org.m2ling.domain.core.HasTags;
import org.m2ling.domain.core.Type;
import org.m2ling.service.core.TagService;
import org.m2ling.service.util.CoreUtil;

import com.google.inject.Inject;



/**
 * 
 * Default implementation of the TagService interface.
 * 
 * @author Bertrand Florat <bertrand@florat.net>
 * 
 */
public class TagServiceImpl implements TagService {
	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.m2ling.service.core.TagService#addTags(org.m2ling.domain.core.Type, java.lang.String,
	 * java.lang.String[])
	 */
	@Override
	public void addTags(Type type, String itemID, String[] tags) {
		// Controls
		checkTypeAndID(type, itemID);
		if (tags == null || tags.length == 0) {
			throw new IllegalArgumentException("Invalid tags : " + Arrays.asList(tags));
		}
		// ---
		HasTags htags = CoreUtil.getHasTagsByTypeAndID(type, itemID);
		String currentTags = htags.getTags();
		htags.setTags(currentTags + HasTags.TAGS_SEPARATOR + tags);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.m2ling.service.core.TagService#setTags(org.m2ling.domain.core.Type, java.lang.String,
	 * java.lang.String[])
	 */
	@Override
	public void setTags(Type type, String itemID, String[] tags) {
		checkTypeAndID(type, itemID);
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.m2ling.service.core.TagService#removeTag(org.m2ling.domain.core.Type,
	 * java.lang.String, java.lang.String)
	 */
	@Override
	public void removeTag(Type type, String itemID, String text) {
		// TODO Auto-generated method stub
		checkTypeAndID(type, itemID);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.m2ling.service.core.TagService#getAllTags(org.m2ling.domain.core.Type,
	 * java.lang.String)
	 */
	@Override
	public String[] getAllTags(Type type, String itemID) {
		checkTypeAndID(type, itemID);
		// TODO Auto-generated method stub
		return null;
	}

	private void checkTypeAndID(Type type, String itemID) {
		if (type == null) {
			throw new IllegalArgumentException("Provided type is null");
		}
		if (itemID == null) {
			throw new IllegalArgumentException("Provided ID is null");
		}
	}

}

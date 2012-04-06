package org.m2ling.service.core.impl;

/**
 * Copyright (C) 2012 Bertrand Florat
 */

import java.util.List;
import java.util.logging.Level;

import org.m2ling.domain.core.HasTags;
import org.m2ling.domain.core.Type;
import org.m2ling.exceptions.NotFoundException;
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
public final class TagServiceImpl implements TagService {

	@Inject
	private java.util.logging.Logger logger;

	private void checkTypeAndID(Type type, String itemID) {
		if (type == null) {
			throw new IllegalArgumentException("Provided type is null");
		}
		if (itemID == null) {
			throw new IllegalArgumentException("Provided ID is null");
		}
	}

	private void checkTagsList(List<String> tags) {
		if (tags == null || tags.size() == 0) {
			throw new IllegalArgumentException("Invalid tags : " + tags);
		}
		for (String tag : tags) {
			if (tag.contains(",")) {
				throw new IllegalArgumentException("A tag can't contain the separator value : " + tag);
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.m2ling.service.core.TagService#addTags(org.m2ling.domain.core.Type, java.lang.String,
	 * java.util.List)
	 */
	@Override
	public void addTags(Type type, String itemID, List<String> tags) {
		{ // Controls
			checkTypeAndID(type, itemID);
			checkTagsList(tags);
		}
		HasTags htags = CoreUtil.getHasTagsByTypeAndID(type, itemID);
		htags.getTags().addAll(tags);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.m2ling.service.core.TagService#setTags(org.m2ling.domain.core.Type, java.lang.String,
	 * java.util.List)
	 */
	@Override
	public void setTags(Type type, String itemID, List<String> tags) {
		{ // Controls
			checkTypeAndID(type, itemID);
			checkTagsList(tags);
		}
		HasTags htags = CoreUtil.getHasTagsByTypeAndID(type, itemID);
		// We clear and reuse the existing list to endorse defensive copy.
		htags.getTags().clear();
		htags.getTags().addAll(tags);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.m2ling.service.core.TagService#removeTag(org.m2ling.domain.core.Type,
	 * java.lang.String, java.lang.String)
	 */
	@Override
	public void removeTag(Type type, String itemID, String tag) {
		List<String> tags = null;
		{ // Controls
			checkTypeAndID(type, itemID);
			HasTags htags = CoreUtil.getHasTagsByTypeAndID(type, itemID);
			tags = htags.getTags();
			if (!tags.contains(tag)) {
				throw new NotFoundException("Tag didn't exist previsously : " + tag + " for item : " + htags);
			}
		}
		tags.remove(tag);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.m2ling.service.core.TagService#getAllTags(org.m2ling.domain.core.Type,
	 * java.lang.String)
	 */
	@Override
	public List<String> getAllTags(Type type, String itemID) {
		checkTypeAndID(type, itemID);
		HasTags htags = CoreUtil.getHasTagsByTypeAndID(type, itemID);
		List<String> tags = htags.getTags();
		if (tags == null) {
			String msg = "The tags list is null for item : " + htags;
			logger.log(Level.SEVERE, msg);
			throw new IllegalStateException(msg);
		}
		return null;
	}

}

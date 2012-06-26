package org.m2ling.service.core.impl;

/**
 * Copyright (C) 2012 Bertrand Florat
 */

import java.util.List;
import java.util.logging.Level;

import org.m2ling.common.exceptions.FunctionalException;
import org.m2ling.common.security.ACResource;
import org.m2ling.common.soa.Context;
import org.m2ling.domain.core.HasTags;
import org.m2ling.domain.core.Type;
import org.m2ling.service.common.ServiceImpl;
import org.m2ling.service.core.TagService;

import com.google.common.base.Strings;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * 
 * Default implementation of the TagService interface.
 * 
 * @author Bertrand Florat <bertrand@florat.net>
 * 
 */
@ACResource
@Singleton
public class TagServiceImpl extends ServiceImpl implements TagService {

	@Inject
	private java.util.logging.Logger logger;

	/**
	 * @see ServiceImpl
	 */
	protected TagServiceImpl() {
		super();
	}

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
			if (Strings.isNullOrEmpty(tag)) {
				throw new IllegalArgumentException("A tag can't be null or void : " + tag);
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.m2ling.service.core.TagService#addTags(org.m2ling.service.common.CallContext,
	 * org.m2ling.domain.core.Type, java.lang.String, java.util.List)
	 */
	@Override
	public void addTags(Context context, Type type, String itemID, List<String> tags) throws FunctionalException {
		{ // Controls
			checkTypeAndID(type, itemID);
			checkTagsList(tags);
		}
		HasTags htags = (HasTags) util.getItemByTypeAndID(type, itemID);
		htags.getTags().addAll(tags);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.m2ling.service.core.TagService#setTags(org.m2ling.service.common.CallContext,
	 * org.m2ling.domain.core.Type, java.lang.String, java.util.List)
	 */
	@Override
	@ACResource
	public void setTags(Context context, Type type, String itemID, List<String> tags) throws FunctionalException {
		{ // Controls
			checkTypeAndID(type, itemID);
			checkTagsList(tags);
		}
		HasTags htags = (HasTags) util.getItemByTypeAndID(type, itemID);
		// We clear and reuse the existing list to endorse defensive copy.
		htags.getTags().clear();
		htags.getTags().addAll(tags);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.m2ling.service.core.TagService#removeTag(org.m2ling.service.common.CallContext,
	 * org.m2ling.domain.core.Type, java.lang.String, java.lang.String)
	 */
	@Override
	public void removeTag(Context context, Type type, String itemID, String tag) throws FunctionalException {
		List<String> tags = null;
		{ // Controls
			checkTypeAndID(type, itemID);
			HasTags htags = (HasTags) util.getItemByTypeAndID(type, itemID);
			tags = htags.getTags();
			if (!tags.contains(tag)) {
				throw new FunctionalException(FunctionalException.Code.TARGET_NOT_FOUND, "Tag didn't exist previsously",
						null, " tag=" + tag + " for item : " + htags);
			}
		}
		tags.remove(tag);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.m2ling.service.core.TagService#getAllTags(org.m2ling.service.common.CallContext,
	 * org.m2ling.domain.core.Type, java.lang.String)
	 */
	@Override
	public List<String> getAllTags(Context context, Type type, String itemID) throws FunctionalException {
		checkTypeAndID(type, itemID);
		HasTags htags = (HasTags) util.getItemByTypeAndID(type, itemID);
		List<String> tags = htags.getTags();
		if (tags == null) {
			String msg = "The tags list is null for item : " + htags;
			logger.log(Level.SEVERE, msg);
			throw new IllegalStateException(msg);
		}
		return tags;
	}

}

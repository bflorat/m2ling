package org.m2ling.service.common;

/**
 * Copyright (C) 2012 Bertrand Florat
 */
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.m2ling.common.configuration.Conf;
import org.m2ling.common.exceptions.FunctionalException;
import org.m2ling.common.exceptions.FunctionalException.Code;
import org.m2ling.common.security.ACResource;
import org.m2ling.common.soa.Context;
import org.m2ling.common.utils.Utils;
import org.m2ling.domain.core.HasTags;
import org.m2ling.domain.core.Type;
import org.m2ling.persistence.PersistenceManager;
import org.m2ling.service.util.DomainExplorer;
import org.m2ling.service.util.DTOConverter;

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
	private TagServiceChecker checker;

	/**
	 * @see ServiceImpl
	 */
	@Inject
	protected TagServiceImpl(PersistenceManager pm, DomainExplorer explorer, DTOConverter.FromDTO fromDTO,
			DTOConverter.ToDTO toDTO, Conf conf, Logger logger, TagServiceChecker checker) {
		super(pm, explorer, fromDTO, toDTO, conf, logger);
		this.checker = checker;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.m2ling.service.core.TagService#addTags(org.m2ling.service.common.CallContext,
	 * org.m2ling.domain.core.Type, java.lang.String, java.util.List)
	 */
	@Override
	public void addTags(Context context, Type type, String id, List<String> tags) throws FunctionalException {
		{ // Controls
			checker.checkTypeAndID(type, id);
			checker.checkTagsList(tags);
		}
		HasTags htags = (HasTags) explorer.getViewPointByID(id);
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
			checker.checkTypeAndID(type, itemID);
			checker.checkTagsList(tags);
		}
		HasTags htags = (HasTags) explorer.getItemByTypeAndID(type, itemID);
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
			checker.checkTypeAndID(type, itemID);
			HasTags htags = (HasTags) explorer.getItemByTypeAndID(type, itemID);
			tags = htags.getTags();
			if (!tags.contains(tag)) {
				throw new FunctionalException(FunctionalException.Code.TARGET_NOT_FOUND, null, " tag=" + tag
						+ " for item : " + htags);
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
		checker.checkTypeAndID(type, itemID);
		HasTags htags = (HasTags) explorer.getItemByTypeAndID(type, itemID);
		List<String> tags = htags.getTags();
		if (tags == null) {
			String msg = "The tags list is null for item : " + htags;
			logger.log(Level.SEVERE, msg);
			throw new IllegalStateException(msg);
		}
		return tags;
	}
}

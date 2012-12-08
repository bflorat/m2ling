/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.service.common;

import java.util.List;

import org.m2ling.common.exceptions.FunctionalException;
import org.m2ling.common.exceptions.FunctionalException.Code;
import org.m2ling.common.utils.Utils;
import org.m2ling.domain.core.HasTags;
import org.m2ling.domain.core.Type;
import org.m2ling.persistence.PersistenceManager;
import org.m2ling.service.util.DomainExplorer;
import org.m2ling.service.util.DTOConverter.FromDTO;

import com.google.inject.Inject;

/**
 * @author "Bertrand Florat <bertrand@florat.net>"
 *
 */
class TagServiceChecker extends ServiceChecker {
	
	@Inject
	protected TagServiceChecker(PersistenceManager pm, DomainExplorer explorer, FromDTO fromDTO, ReferenceHelper refHelper) {
		super(pm, explorer, fromDTO, refHelper);
	}

	void checkTypeAndID(Type type, String itemID) throws FunctionalException {
		if (type == null) {
			throw new FunctionalException(Code.NULL_ARGUMENT, null, "type");
		}
		if (Utils.isNullOrEmptyAfterTrim(itemID)) {
			throw new FunctionalException(Code.NULL_ARGUMENT, null, "id=" + itemID);
		}
		// check the item existence
		Object item = explorer.getItemByTypeAndID(type, itemID);
		if (item == null) {
			throw new FunctionalException(Code.TARGET_NOT_FOUND, null, "id=" + itemID);
		}
		if (!(item instanceof HasTags)) {
			throw new FunctionalException(Code.TAGS_NOT_SUPPORTED, null, itemID);
		}
	}

	void checkTagsList(List<String> tags) throws FunctionalException {
		if (tags == null || tags.size() == 0) {
			throw new FunctionalException(Code.NULL_ARGUMENT, null, "tags=" + tags);
		}
		for (String tag : tags) {
			if (tag.contains(",")) {
				throw new FunctionalException(Code.TAGS_SEPARATOR, null, tag);
			}
			if (Utils.isNullOrEmptyAfterTrim(tag)) {
				throw new FunctionalException(Code.NULL_ARGUMENT, null, "tag=" + tag);
			}
		}
	}

	/**
	 * {@inheritDoc} 
	 */
	@Override
	protected Type getManagedType() {
		return null;
	}
}

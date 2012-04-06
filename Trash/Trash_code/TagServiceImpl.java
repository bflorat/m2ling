package org.m2ling.service.core.impl;
/**
 * Copyright (C) Bertrand Florat
 */


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.m2ling.domain.core.Component;
import org.m2ling.domain.core.CoreFactory;
import org.m2ling.domain.core.HasTags;
import org.m2ling.domain.core.Tag;
import org.m2ling.service.common.TagService;

/**
 * 
 * Default implementation of the TagService interface.
 * 
 * @author Bertrand Florat <bertrand@florat.net>
 * 
 */
public class TagServiceImpl implements TagService {

	// TODO
	Component component = CoreFactory.eINSTANCE.createComponent();

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.m2ling.service.common.TagService#addTag(java.lang.String, java.lang.String)
	 */
	@Override
	public void addTag(final String itemID, final String text) {
		// Try to get the item by ID
		// TODO
		HasTags item = component;

		// Check if the item already owns this tag
		for (Tag t : item.getTags()) {
			if (t.getText().equals(text)) {
				return;
			}
		}
		// Create the new tag and apply it
		Tag t = CoreFactory.eINSTANCE.createTag();
		t.setText(text);
		item.getTags().add(t);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.m2ling.service.common.TagService#clearTags(java.lang.String)
	 */
	@Override
	public void clearTags(String itemID) {
		// TODO
		HasTags item = component;
		item.getTags().clear();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.m2ling.service.common.TagService#removeTag(java.lang.String, java.lang.String)
	 */
	@Override
	public void removeTag(String itemID, String text) {
		// TODO
		HasTags item = component;
		for (Iterator<Tag> it = item.getTags().iterator(); it.hasNext();) {
			Tag tag = it.next();
			if (tag.getText().equals(text)) {
				it.remove();
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.m2ling.service.common.TagService#getAllTags(java.lang.String)
	 */
	@Override
	public List<String> getAllTags(String itemID) {
		// TODO
		HasTags item = component;
		List<String> tagsAsText = new ArrayList<String>();
		for (Tag t : item.getTags()) {
			tagsAsText.add(t.getText());
		}
		return tagsAsText;
	}

}

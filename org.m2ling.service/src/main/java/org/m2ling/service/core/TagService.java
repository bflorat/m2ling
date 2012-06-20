/*
 * Copyright (C) 2012 Bertrand Florat
 */

package org.m2ling.service.core;

import java.util.List;

import org.m2ling.common.exceptions.FunctionalException;
import org.m2ling.common.soa.Context;
import org.m2ling.domain.core.Type;

/**
 * General contract for Tag services implementations.
 * 
 * <p>
 * Every method takes a CallContext argument
 * </p>
 * 
 * <p>
 * Every method can throw these runtime exceptions :
 * </p>
 * 
 * <li>IllegalAccessException if the caller has not required authorization to call this method</li>
 * 
 * <li>TechnicalException in case of technical issue.</li>
 * 
 * 
 * <br>
 * 
 * @author Bertrand Florat <bertrand@florat.net>
 */

public interface TagService {

	/**
	 * Add one ore more tags to a HasTags item identified by its ID. If the tag already exist, the
	 * service does nothing and none error is returned.
	 * 
	 * @param type
	 *           the HasTags item type
	 * @param itemID
	 *           the item ID to add tag to
	 * @param tags
	 *           the tags values to add.
	 * @throws FunctionalException
	 *            if a list element contains a comma or if the list is null or empty
	 */
	void addTags(Context context, Type type, String itemID, List<String> tags) throws FunctionalException;

	/**
	 * Set one or tags to a HasTag item.
	 * 
	 * @param type
	 *           the HasTags item type
	 * @param itemID
	 *           the item ID to set tag to. Note that the item ID is not necessary a "iD" attribute.
	 * @param tags
	 *           the tags values to set. If the list is empty, all pre-existing tags are cleared.
	 * @throws FunctionalException
	 *            if a list element contains a comma or if the list is null
	 */
	void setTags(Context context, Type type, String itemID, List<String> tags) throws FunctionalException;

	/**
	 * Remove a single from aHasTags item. If the tag doesn't exist, an
	 * <code>IllegalStateException</code> runtime exception is thrown.
	 * 
	 * @param type
	 *           the HasTags item type
	 * @param itemID
	 *           the item ID to remove tag from
	 * @param tag
	 *           the tag to remove
	 * @throws FunctionalException
	 *            if tag is null or if the tag didn't exist previously
	 */
	void removeTag(Context context, Type type, String itemID, String tag) throws FunctionalException;

	/**
	 * Return a list of all the tags attached to the provided item.
	 * 
	 * @param type
	 *           the HasTags item type
	 * @param itemID
	 *           the item ID to get tags from
	 * @return a list of all the tags attached to the provided item. If the item has none tags, a
	 *         void list is returned.
	 * @throws FunctionalException
	 *            if the tags list is null
	 */
	List<String> getAllTags(Context context, Type type, String itemID) throws FunctionalException;
}

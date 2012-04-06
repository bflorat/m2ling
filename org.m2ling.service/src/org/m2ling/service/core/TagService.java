/*
 * Copyright (C) Bertrand Florat
 */

package org.m2ling.service.core;

import org.m2ling.domain.core.Type;

/**
 * General contract for Tag services implementations.
 * 
 * <p>Every method can throw these runtime exceptions :</p>
 * 
 * <li>IllegalAccessException if the caller has not required authorization to call this method</li>
 * 
 * <li>NotFoundException if the item can't be found</li>
 * 
 * <li>UnsupportedOperationException if the item doesn't support tags</li>
 * 
 * <li>IllegalArgumentException if provided arguments are null are invalid</li>
 * 
 * <br>  
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
	 * @param text
	 *           the tags values to add. If a single array element contain a comma, it is split
	 *           automatically into several tags.
	 */
	void addTags(Type type, String itemID, String[] tags);

	/**
	 * Set one or tags to a HasTag item.
	 * 
	 * @param type
	 *           the HasTags item type
	 * @param itemID
	 *           the item ID to set tag to. Note that the item ID is not necessary a "iD" attribute.
	 * @param text
	 *           the tags values to set. If a single array element contain a comma, it is split
	 *           automatically. If tags is null, all pre-existing tags are cleared.
	 */
	void setTags(Type type, String itemID, String[] tags);

	/**
	 * Remove a single from aHasTags item. If the tag doesn't exist, an
	 * <code>IllegalStateException</code> runtime exception is thrown.
	 * 
	 * @param type
	 *           the HasTags item type
	 * @param itemID
	 *           the item ID to remove tag from
	 * @param text
	 */
	void removeTag(Type type, String itemID, String text);

	/**
	 * Return a list of all the tags attached to the provided item.
	 * 
	 * @param type
	 *           the HasTags item type
	 * @param itemID
	 *           the item ID to get tags from
	 * @return a list of all the tags attached to the provided item. If the item has none tags, a
	 *         void array is returned.
	 */
	String[] getAllTags(Type type, String itemID);
}

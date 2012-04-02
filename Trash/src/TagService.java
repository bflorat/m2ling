

import java.util.List;

/**
 * Copyright (C) Bertrand Florat General contract for Tag services implementations
 */

public interface TagService {

	/**
	 * Add a tag to a HasTags item identified by its ID. If the tag already exist, the service does
	 * nothing and none error is returned.
	 * 
	 * @param itemID
	 *            the item ID to add tag to
	 * @param text
	 *            the tag literal value to set
	 */
	void addTag(String itemID, String text);

	/**
	 * Clear all existing tags from a HasTags item. After this call, <code>getAllTags()</code>
	 * method call should return a void list.
	 * 
	 * @param itemID
	 *            the item ID to add tag t
	 */
	void clearTags(String itemID);

	/**
	 * Remove a single from aHasTags item. If the tag doesn't exist, an
	 * <code>IllegalStateException</code> runtime exception is thrown.
	 * 
	 * @param itemID
	 *            the item ID to remove tag from
	 * @param text
	 *            the tag literal value identifying the tag.
	 */
	void removeTag(String itemID, String text);

	/**
	 * Return a list of all the tags attached to the provided item. If the item has none tags, a
	 * void list is returned.
	 * 
	 * @param itemID
	 *            the item ID to get tags from
	 * @return a list of all the tags attached to the provided item
	 */
	List<String> getAllTags(String itemID);
}

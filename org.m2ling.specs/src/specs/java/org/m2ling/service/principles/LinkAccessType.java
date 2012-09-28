/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.service.principles;


/**
 * Valid access types for link types
 * 
 * <p>
 * CAUTION:
 * </p>
 * : MUST BE SYNCHRONIZED with the org.m2ling.domain.core.LinkAccessType class </p>
 */
public enum LinkAccessType {
	CREATE,
	READ,
	UPDATE,
	DELETE,
	RW,
	RO,
	SEARCH,
	SEARCH_INDEX_OUTPUT,
	EVENT;
}

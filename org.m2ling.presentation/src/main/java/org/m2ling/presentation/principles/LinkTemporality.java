/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.presentation.principles;


/**
 * Valid access types for link types
 * 
 * <p>
 * CAUTION:
 * </p>
 * : MUST BE SYNCHRONIZED with the org.m2ling.domain.core.LinkTemporality class </p>
 */
public enum LinkTemporality {
	SYNC,
	ASYNC_PULL,
	ASYNC_PUSH;
}

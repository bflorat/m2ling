/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.presentation.principles;


/**
 * Valid temporality for link types
 * 
 * <p>
 * CAUTION:
 * </p>
 * : MUST BE SYNCHRONIZED with the org.m2ling.domain.core.LinkTemporality enum </p>
 */
public enum LinkTemporality {
	SYNC,
	ASYNC_PULL,
	ASYNC_PUSH;
}

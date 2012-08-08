/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.presentation.principles;

/**
 * Component reference types. <br>
 * Keep this enum up-to-date with domain ReferenceType class as this is a raw duplication created to
 * avoid direct dependency between presentation and domain layers.
 */
public enum ReferenceType {
	CONTAINS, RUNS, DEPENDS_ON, ADMINS;
}
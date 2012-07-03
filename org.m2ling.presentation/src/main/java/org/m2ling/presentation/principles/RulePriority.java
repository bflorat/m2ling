/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.presentation.principles;

/**
 * Rules priority. <br>
 * Keep this enum up-to-date with domain RulePriority class as this is a raw duplication created to
 * avoid direct dependency between presentation and domain layers.
 */
public enum RulePriority {
	VERY_LOW, LOW, MEDIUM, HIGH, VERY_HIGH;
}
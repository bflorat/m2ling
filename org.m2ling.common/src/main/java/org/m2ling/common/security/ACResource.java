/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.common.security;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Access Controlled method or class annotation
 * 
 * @author "Bertrand Florat <bertrand@florat.net>"
 * 
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.METHOD })
public @interface ACResource {
}

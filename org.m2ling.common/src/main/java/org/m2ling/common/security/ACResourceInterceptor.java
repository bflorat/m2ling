/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.common.security;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Access Control intercepter
 * 
 * @author "Bertrand Florat <bertrand@florat.net>"
 * 
 */
public interface ACResourceInterceptor extends MethodInterceptor {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.aopalliance.intercept.MethodInterceptor#invoke(org.aopalliance.intercept.MethodInvocation)
	 */
	@Override
	public Object invoke(MethodInvocation arg0) throws Throwable;

}

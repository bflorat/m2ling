/**
 * Copyright (C) 2012 Bertrand Florat
 *
 * @author "Bertrand Florat <bertrand@florat.net>"
 */
package org.m2ling.common.utils;

import org.aopalliance.intercept.MethodInvocation;
import org.m2ling.common.security.ACResourceInterceptor;
import org.m2ling.common.soa.Context;

/**
 * Mocked implementation of access control, check in-memory credentials.
 */
public class ACResourceInterceptorMockImpl implements ACResourceInterceptor {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.m2ling.security.ACResourceInterceptor#invoke(org.aopalliance.intercept.MethodInvocation)
	 */
	@Override
	public Object invoke(MethodInvocation mi) throws Throwable {
		// First argument is always the context
		Context context = (Context) mi.getArguments()[0];
		String user = context.get(Context.Entry.USER);
		// It is the CEO ! in this mock implementation, we simply proceed...
		if ("hceheo".equals(user)) {
			return mi.proceed();
		} else {
			throw new IllegalAccessError("User doesn't have suffisent privileges to call this service");
		}
	}

}

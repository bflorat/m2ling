/**
 * Copyright (C) 2012 Bertrand Florat
 *
 * @author "Bertrand Florat <bertrand@florat.net>"
 */
package org.m2ling.common.dto.binding;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

/**
 * Additional Guice bindings that can be set on debug. Only token into account when
 * Consts.M2LING_DEBUG_VARIABLE_NAME environment variable is set to true.
 */
public abstract class M2lingGuiceModule extends AbstractModule {

	protected void bindConst(String key, String value) {
		bindConstant().annotatedWith(Names.named(key)).to(value);
	}

}

/**
 * Copyright (C) 2012 Bertrand Florat
 *
 * @author "Bertrand Florat <bertrand@florat.net>"
 */
package org.m2ling.common.configuration;

import java.util.Properties;

public class SpecificConfigurationMock implements Conf.SpecificConfiguration {
	public static final String param1 = "param1";
	public static final String param2 = "param2";

	public Properties getDefaultConfiguration() {
		Properties result = new Properties();
		result.put(param1, "value_param1");
		result.put(param2, "value_param2");
		return result;
	}

	public Properties getDefaultDebugConfiguration() {
		Properties result = new Properties();
		result.put(param1, "value_param1_debug");
		result.put(param2, "value_param2_debug");
		return result;
	}

}

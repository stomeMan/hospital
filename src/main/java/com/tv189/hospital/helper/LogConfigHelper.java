package com.tv189.hospital.helper;

import tools.DynamicResource;

public class LogConfigHelper {

//	private static final String configName = "config/LogConfig_online.properties";
	private static final String configName = "config/LogConfig.properties";
	public static String getLogRootPath() {
		return DynamicResource.getResource(configName).getString(
				"Log_Root_PATH");
	}

	public static String getLogExtentionType() {
		return DynamicResource.getResource(configName).getString("Log_Type");
	}

	public static String getApiAccessLog() {
		return DynamicResource.getResource(configName).getString(
				"Api_access_log");
	}
	public static String getUpdateCardInfoLog() { return DynamicResource.getResource(configName)
			.getString("UpdateCardInfoLog");
	}
	public static String getUpdateCardUserLog() { return DynamicResource.getResource(configName)
			.getString("UpdateCardUserLog");
	}
	public static String getHttpLog() { return DynamicResource.getResource(configName)
			.getString("HttpLog");
	}
	public static String getProxyHttpLog() { return DynamicResource.getResource(configName)
			.getString("ProxyHttpLog");
}


}

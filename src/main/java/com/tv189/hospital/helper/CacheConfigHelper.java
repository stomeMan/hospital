package com.tv189.hospital.helper;

import tools.DynamicResource;

public class CacheConfigHelper {

	private static final String configName = "config/CacheConfig.properties";

	public static String getCacheIP() {
		return DynamicResource.getResource(configName).getString("CacheIP");
	}

	public static Integer getCachePort() {
		return Integer.parseInt(DynamicResource.getResource(configName).getString("CachePort"));
	}

	public static Integer getCacheTimeOut() {
		return Integer.parseInt(DynamicResource.getResource(configName).getString("CacheTimeOut")) * 60;
	}

//	public static Integer getAuthTokenTimeout() {
//		return Integer.parseInt(DynamicResource.getResource(configName).getString("AuthTokenTimeOut"));
//	}
//
//	public static Integer getHeartTimeOut() {
//		return Integer.parseInt(DynamicResource.getResource(configName).getString("HeartTimeOut"));
//	}
//	
//	public static Integer getOttTokenTimeOut() {
//		return Integer.parseInt(DynamicResource.getResource(configName).getString("OttTokenTimeOut"));
//	}
//	
//	public static Integer getUserInfoTimeOut() {
//		return Integer.parseInt(DynamicResource.getResource(configName).getString("UserInfoTimeOut"));
//	}
//	
//	public static Integer getClientInfoTimeOut() {
//		return Integer.parseInt(DynamicResource.getResource(configName).getString("ClientInfoTimeOut"));
//	}
//	
//	public static Integer getAppTokenTimeOut() {
//		return Integer.parseInt(DynamicResource.getResource(configName).getString("AppTokenTimeOut"));
//	}
//
//	public static Integer getMessageTimeOut() {
//		return Integer.parseInt(DynamicResource.getResource(configName).getString("MessageTimeOut"));
//	}
//	public static Integer getAmsInfoTimeOut() {
//		return Integer.parseInt(DynamicResource.getResource(configName).getString("AmsInfoTimeOut"));
//	}	
	
	public static void main(String... args){
	}
}

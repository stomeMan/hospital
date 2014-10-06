package com.tv189.hospital.helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import tools.DynamicResource;

public class PermitedIPConfigHelper {
	private static List<String> list=new ArrayList<String>();
	private static final String configName = "config/PermitedIP.properties";
	public static List<String> getPermitedIps() {
		if(list.size()==0){
			String [] ips=DynamicResource.getResource(configName).getString(
					"permitedIPs").split(",");
			list.addAll(Arrays.asList(ips));
		}
		return  list;
	}




}

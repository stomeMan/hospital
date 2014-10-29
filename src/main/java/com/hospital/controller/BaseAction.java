package com.hospital.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class BaseAction {
	
	
	public static HttpServletRequest getRequest(){
		HttpServletRequest httpServletRequest=null;
		if(httpServletRequest==null){
			try {
				httpServletRequest=((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return httpServletRequest;
	}
	
}

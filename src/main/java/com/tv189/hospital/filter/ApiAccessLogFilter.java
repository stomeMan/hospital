package com.tv189.hospital.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;


import com.tv189.hospital.logic.LoggerLogic;



public class ApiAccessLogFilter extends BaseFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest hsr= (HttpServletRequest)arg0;
		String hrsss=hsr.getRemoteHost()+hsr.getRequestURI()+"?"+hsr.getQueryString();
		System.out.println(hrsss);
		LoggerLogic.apiAccessLog(hsr.getRemoteHost()+hsr.getRequestURI(),hsr.getQueryString());
		arg2.doFilter(arg0, arg1);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
}

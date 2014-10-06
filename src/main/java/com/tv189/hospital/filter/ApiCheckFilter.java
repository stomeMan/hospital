package com.tv189.hospital.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.tv189.hospital.constant.Constant;
import com.tv189.hospital.helper.PermitedIPConfigHelper;
import com.tv189.hospital.pojo.ResponseObject;



public class ApiCheckFilter extends BaseFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		String host=request.getRemoteHost();
		List<String> ips =PermitedIPConfigHelper.getPermitedIps();
//		if(ips.contains(host)){
//			filterChain.doFilter(request, response);
//		}else{
//			response.setCharacterEncoding("UTF-8");
//			outJSON("此IP无权限访问", (HttpServletResponse)response, (HttpServletRequest)request);
//			return ;
//		}
		System.out.println(host);
		filterChain.doFilter(request, response);
//		HttpServletRequest hsr= (HttpServletRequest)request;
//		String hrsss=hsr.getRemoteHost()+hsr.getRequestURI()+hsr.getQueryString();
//		System.out.println(hrsss);
//		LoggerLogic.apiAccessLog(hsr.getRemoteHost()+hsr.getRequestURI(),hsr.getQueryString());
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	@SuppressWarnings("unused")
	private ResponseObject checkTimeOutLimit(String time) {
		ResponseObject result = new ResponseObject();
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			Date requestDate = sdf.parse(time);
			long requestTime = requestDate.getTime();
			long now = Calendar.getInstance().getTimeInMillis();
			int interval = (int) (Math.abs(now/1000 - requestTime/1000));
			Integer timeLimit = Constant.timeLimit;
			if(interval < 0 || interval > timeLimit){
				result.setMessage("请求超时");
				result.setCode(1);
				return result;
			}
			return null;
		} catch (Exception e) {
		 
		}
		return null;
	}
}

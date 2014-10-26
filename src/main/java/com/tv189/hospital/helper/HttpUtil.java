package com.tv189.hospital.helper;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSON;

/**
 * @author gaohailiang
 *
 * 2014-3-26
 */

public class HttpUtil{
	private static final String POST = "POST";
	private static final String GET = "GET";

	
	
	/**
	 * 获得当前，请求本地接口的url,记日志的时候使用，因为功能比较独立从原来的 reponse2Bean 方法中抽取出来
	 */
	public static String getLocalURL(HttpServletRequest httpServletRequest){
		if(httpServletRequest==null){
			try {
//				httpServletRequest =ServletActionContext.getRequest();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		String localUrl=null;
		if(httpServletRequest!=null){
			if(httpServletRequest.getRequestURL()==null||httpServletRequest.getRequestURL().length()==0){
				return null;
			}
		localUrl=httpServletRequest.getRequestURL().toString();
		localUrl+="?";
		localUrl+=httpServletRequest.getQueryString();
		}
		return localUrl;
	}
	
	public static String urlEncode(String inputURL){
		String ENCODING="UTF-8";

		String outputURL = null;
		try {
			outputURL = URLEncoder.encode(inputURL, ENCODING);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return outputURL;
	}
	
	public static String urlDecode(String str){//中文处理
		String outStr = null;
		/*try {
			outStr = new String(str.getBytes("ISO8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		String ENCODING="utf-8";
		try {
			outStr = URLDecoder.decode(str,ENCODING);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return outStr;
	}
	
	public static String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		// 可是，如果通过了多级反向代理的话，X-Forwarded-For的值并不止一个，而是一串Ｉｐ值
		// 是取X-Forwarded-For中第一个非unknown的有效IP字符串
		String[] str = ip.split(",");
		if (str != null && str.length > 1) {
			ip = str[0];
		}
		return ip;
	}
	
	
}



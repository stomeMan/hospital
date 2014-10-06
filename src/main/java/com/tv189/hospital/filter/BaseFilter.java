package com.tv189.hospital.filter;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.tv189.hospital.helper.LogConfigHelper;
import com.tv189.hospital.logger.LogInfo;
import com.tv189.hospital.logger.LogThread;


public class BaseFilter {
	private static Logger logger = Logger.getLogger(BaseFilter.class);
	
	protected void outJSON(String str,HttpServletResponse response,HttpServletRequest request) {
		//上线的时候,以JSON的方式进行传输.
		try {
//			Object requestUUID = request.getAttribute(Constant.PARA_REQUEST_UUID);
			response.setHeader("Pragma", "no-cache");
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expires", 0);
			response.setContentType("text/javascript;charset=utf-8");
			this.addResponseLog(str, "");
		} finally {
			outSTR(str,response,request);
		}
	}
	
	/**
	 * 输出数据
	 * 
	 * @param str 数据
	 */
	private final void outSTR(String str,HttpServletResponse response,HttpServletRequest request) {
		this.cleanStream(request);
		PrintWriter out = null;
		try {
			out = response.getWriter();{
				out.write(str);
			}
		} catch (IOException e) {
			logger.error("输出异常", e);
		} finally {
			if (out != null) {
				out.flush();
				out.close();
			}
		}
	}
	
	public void cleanStream(HttpServletRequest request){
		byte[] buffer = new byte[1024];
		InputStream inputStream = null;
		try {
			inputStream = request.getInputStream();
			while (inputStream.read(buffer) > 0) {
			}
		} catch (IOException e) {
			e.printStackTrace();
			return ;
		}finally{
			if(inputStream != null){
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
					return ;
				}
			}
		}
	}
	
	public void addResponseLog(String responseInfo, String requestUUID) {
		String resLogInfo = requestUUID + "    response INFO={" + responseInfo + "}";
//		LogInfo logger = new LogInfo(LogConfigHelper.getProxyHttpLog(), resLogInfo);
//		LogThread.addLogInfo(logger);
	}
}

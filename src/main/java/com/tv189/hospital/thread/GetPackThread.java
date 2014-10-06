package com.tv189.hospital.thread;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tv189.hospital.helper.JsonHelper;
import com.tv189.hospital.logic.LoggerLogic;
import com.tv189.hospital.logic.PackLogic;
import com.tv189.hospital.pojo.RequestObject;
import com.tv189.hospital.pojo.ResponseObject;

public class GetPackThread extends Thread {
	
	private LoggerLogic loggerLogic;
	private PackLogic packLogic;
	private RequestObject requestObject;
	private ResponseObject responseObject;
	private HttpServletRequest httpServletRequest;
	private HttpServletResponse httpServletResponse;
    public LoggerLogic getLoggerLogic() {
		return loggerLogic;
	}
	public GetPackThread(LoggerLogic loggerLogic, PackLogic packLogic,RequestObject requestObject,ResponseObject ro,HttpServletRequest request,HttpServletResponse response) {
		super();
		this.loggerLogic = loggerLogic;
		this.packLogic = packLogic;
		this.requestObject=requestObject;
		this.responseObject=ro;
		this.httpServletRequest=request;
		this.httpServletResponse=response;
	}
	
	public HttpServletRequest getHttpServletRequest() {
		return httpServletRequest;
	}
	public void setHttpServletRequest(HttpServletRequest httpServletRequest) {
		this.httpServletRequest = httpServletRequest;
	}
	public HttpServletResponse getHttpServletResponse() {
		return httpServletResponse;
	}
	public void setHttpServletResponse(HttpServletResponse httpServletResponse) {
		this.httpServletResponse = httpServletResponse;
	}
	public void setLoggerLogic(LoggerLogic loggerLogic) {
		this.loggerLogic = loggerLogic;
	}
	public PackLogic getPackLogic() {
		return packLogic;
	}
	public void setPackLogic(PackLogic packLogic) {
		this.packLogic = packLogic;
	}
	public RequestObject getRequestObject() {
		return requestObject;
	}

	public void setRequestObject(RequestObject requestObject) {
		this.requestObject = requestObject;
	}

	public ResponseObject getResponseObject() {
		return responseObject;
	}
	public void setResponseObject(ResponseObject responseObject) {
		this.responseObject = responseObject;
	}
	@Override
    public void run() {
		 responseObject=packLogic.gethospital(requestObject);
		 String responseStr=JsonHelper.toJsonStr(responseObject);
		 try {
			httpServletResponse.getWriter().write(responseStr);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}

package com.tv189.hospital.logger;

import org.springframework.stereotype.Repository;

import com.tv189.hospital.constant.Constant;


/**
 * @author xuezhiyu
 *
 * 2014-6-18
 */
@Repository
public class LogInfo {
	private String logType;
	private String logContent;
	private String logNameType =Constant.DAILY;

	public LogInfo(){
		
	}
	public String getLogType() {
		return logType;
	}

	public void setLogType(String logType) {
		this.logType = logType;
	}

	public String getLogContent() {
		return logContent;
	}

	public void setLogContent(String logContent) {
		this.logContent = logContent;
	}

	public LogInfo(String logType,String logContent,String logNameType){
		this.logType = logType;
		this.logContent=logContent;
		this.logNameType = logNameType;
	}

	public LogInfo(String resLogInfo) {
		// TODO Auto-generated constructor stub
		this.logContent=resLogInfo;
	}

	public String getLogNameType() {
		return logNameType;
	}

	public void setLogNameType(String logNameType) {
		this.logNameType = logNameType;
	}
	
}

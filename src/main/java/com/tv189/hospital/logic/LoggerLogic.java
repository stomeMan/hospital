package com.tv189.hospital.logic;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.tv189.hospital.constant.Constant;
import com.tv189.hospital.helper.LogConfigHelper;
import com.tv189.hospital.logger.LogInfo;
import com.tv189.hospital.logger.LogThread;


@Repository
public class LoggerLogic {
	
	/**
	 * 
	 * @param appid
	 * @param channelId
	 */
	public static void apiAccessLog(String url,String queryString){
		if(queryString==null){
			queryString="";
		}
		String logInfo=url+"?"+queryString;
		LogInfo logger = new LogInfo(LogConfigHelper.getApiAccessLog(), logInfo, Constant.DAILY);
		LogThread.addLogInfo(logger);
	}
	/**
	 * 
	 * @param logInfo
	 */
	public static void updateCardInfoLog(String logInfo){		
		LogInfo logger = new LogInfo(LogConfigHelper.getUpdateCardInfoLog(), logInfo, Constant.DAILY);
		LogThread.addLogInfo(logger);
	}
	
	public static void updateCardUserLog(String logInfo){		
		LogInfo logger = new LogInfo(LogConfigHelper.getUpdateCardUserLog(), logInfo, Constant.DAILY);
		LogThread.addLogInfo(logger);
	}
	/**
	 * 
	 * @param appid
	 * @param channelId
	 */
	public static void httpLog(String logInfo){		
		LogInfo logger = new LogInfo(LogConfigHelper.getHttpLog(), logInfo, Constant.DAILY);
		LogThread.addLogInfo(logger);
	}
	public static void addProxyHttpLog(String localurl,String startTime, String url, String queryStr, String responseStr) {
		String loginfo="----start----"+startTime+"\n"+localurl+"\nrequest:"+url + "?"+ queryStr + "\nmsresponse:" + responseStr+"\n----end----";
		if(queryStr!=null){
			loginfo="----start----"+startTime+"\n"+localurl+"\nrequest:"+url + "?"+ queryStr + "\nmsresponse:" + responseStr+"\n----end----";
		}else{
			loginfo="----start----"+startTime+"\n"+localurl+"\nrequest:"+url+ "\nmsresponse:" + responseStr+"\n----end----";
		}
		LogInfo logger = new LogInfo(LogConfigHelper.getProxyHttpLog(),loginfo,Constant.DAILY);
		LogThread.addLogInfo(logger);
	}
}

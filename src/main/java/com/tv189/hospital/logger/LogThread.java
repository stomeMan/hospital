package com.tv189.hospital.logger;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.apache.log4j.Appender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;

import com.tv189.hospital.constant.Constant;
import com.tv189.hospital.helper.DateHelper;
import com.tv189.hospital.helper.LogConfigHelper;

/**
 * @author xuezhiyu
 * 2014-6-18
 */
public class LogThread extends Thread {
	private static Queue<LogInfo> logObjects = new ConcurrentLinkedQueue<LogInfo>();
	
	public static void addLogInfo(LogInfo logInfo) {
		logObjects.add(logInfo);
	}
	private Map<String, String> prefixMap = new HashMap<String,String>();
	public void run() {
		System.out.println("************************日志线程启动**************************");
		while(true){
			Integer size = logObjects.size();
			for (Integer i = 0; i < size; i++) {
				LogInfo log = logObjects.poll();
				if(null != log){
					System.out.println("log type--------------------------- "+log.getLogType());
					Logger logger = Logger.getLogger(log.getLogType());
					Appender appender = logger.getAppender(log.getLogType());
					if (appender instanceof FileAppender) {
		                FileAppender fappender = (FileAppender) appender;
		                String logFileName = fappender.getFile();
		                if(logFileName.lastIndexOf(".") == -1) {
		                	prefixMap.put(log.getLogType(), logFileName);
		                } 
		                System.out.println("logFileName------------------------------------>"+logFileName);
		                String dir = DateHelper.getDateToday();
		                String todayhourStr = DateHelper.getDateTimeByNowyyyyMMddHHmmss();
		                if(Constant.HOUR.equals(log.getLogNameType())) {
	                		/**
	                		 * 小时交付文件名：clientaction_log_yyyymmddhh.txt，每小时交付一次上一个小时的数据（例：9：00交付，8：00-8:59:59秒的数据）
	                		 */
		                	todayhourStr = todayhourStr.substring(0, 10);
		                } else {
	                		/**
	                		 * 按天交付
	                		 */
		                	todayhourStr = dir;
		                }
                		String fullName = LogConfigHelper.getLogRootPath()+dir+"/"+prefixMap.get(log.getLogType())+todayhourStr+LogConfigHelper.getLogExtentionType();//每小时保持一次
                		System.out.println("fullName--------------------------------------->"+fullName);
                		
	                	if(logFileName.lastIndexOf(".") != -1) {
		                	if(!logFileName.equals(fullName)) {
			                	fappender.setFile(fullName);
			                	fappender.activateOptions();
		                	}
	                	} else {
		                	fappender.setFile(fullName);
		                	fappender.activateOptions();
	                	}
		            }
					logger.info(log.getLogContent());
					LogThread.printInfo("log-------------------------------->"+log.getLogContent());
				}
			}
			Integer sleepTime = 30*1000;			//30秒写一次
			try {
				sleep(sleepTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	private static Integer tempNum = 1;
	public void initThread(){
		if(tempNum == 1){
			Thread th = new LogThread();
			th.start();
			tempNum++;
		}
	}
	public static void printInfo(Object... info){
//		else{
			if(info.length == 2 && info[1] != null){
				try{
					Logger logger = (Logger) info[1];
					logger.error(info[1]);
				}catch(Exception e){
					e.printStackTrace();
				}
			}
//		}
	}
}

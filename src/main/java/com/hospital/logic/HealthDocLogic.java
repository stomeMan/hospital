package com.hospital.logic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hospital.mybatis.dao.CheckProjectDetailDao;
import com.hospital.mybatis.dao.CheckProjectInfoDao;
import com.hospital.mybatis.dao.UserDao;
import com.hospital.mybatis.model.CheckProjectDetail;
import com.hospital.mybatis.model.CheckProjectInfo;
import com.hospital.pojo.ResponseObject;

@Repository
public class HealthDocLogic {
	@Autowired
	private UserDao userDao;
	@Autowired
	private CheckProjectInfoDao checkProjectInfoDao;
	@Autowired
	private CheckProjectDetailDao checkProjectDetailDao;
	/**
	 * 获取最近一次体检报告摘要信息展示
	 * @param userName
	 * @return
	 */
	public ResponseObject getSimpleHealthReport(String userName){
		ResponseObject ro= new ResponseObject();
		Map<String,String> param=new HashMap<String, String>();
		param.put("userName", userName);
		param.put("healthyFlag","N");
		List<CheckProjectInfo> cpsis=this.getSimpleHealthReport(param);
		if(cpsis!=null){
			ro.setCode(0);
			ro.setMessage("ok");
	    }else{
	    	ro.setCode(9);
			ro.setMessage("近期无体检记录");
	    }
		ro.setInfo(cpsis);
		return ro;
	}
	
	public ResponseObject getDetailHealthReport(String userName){
		ResponseObject ro= new ResponseObject();
		Map<String,String> param=new HashMap<String, String>();
		param.put("userName", userName);
		param.put("healthyFlag","N");
		List<CheckProjectInfo> cps=this.getSimpleHealthReport(param);
		for(CheckProjectInfo cp:cps){
			 List<CheckProjectDetail> checkProjectDetails=checkProjectDetailDao.selectByProjectName(cp.getProjectName());
			 System.out.println(cp.getProjectName());
			 cp.setCheckProjectDetails(checkProjectDetails);
		}
	   if(cps!=null){
		   	ro.setCode(0);
			ro.setInfo(cps);
			ro.setMessage("ok");
	   }
	    
		
	   return ro;
	}
	/**
	 *  获取最近一次体检报告摘要信息展示
	 * @param param
	 * @return
	 */
	public List<CheckProjectInfo> getSimpleHealthReport(Map<String,String> param){
		 List<CheckProjectInfo> cpis=checkProjectInfoDao.selectListByUserName(param);
		    if(cpis!=null){
		    	String latestSignNumber="";
		    	for(int i=cpis.size();i>0;i--){
		    		CheckProjectInfo cpi=cpis.get(i-1);
		    		if(cpi!=null){
		    			if(i!=cpis.size()){
		    				if(!latestSignNumber.equals(cpi.getSignNumber())){
		    					cpis.remove(i-1);
		    				}
		    			}else{
		    				latestSignNumber=cpi.getSignNumber();
		    			}
		    			
		    		}
		    	}
		    }
		return cpis;
	}
	public ResponseObject getSimpleHealthReportByTime(String userName){
		ResponseObject ro= new ResponseObject();
	    CheckProjectInfo cp=checkProjectInfoDao.selectByUserName(userName);
		ro.setCode(0);
		ro.setInfo(cp);
		ro.setMessage("ok");
		return ro;
	}
	public ResponseObject getSimpleHealthReportBySubject(String userName){
		ResponseObject ro= new ResponseObject();
	    CheckProjectInfo cp=checkProjectInfoDao.selectByUserName(userName);
		ro.setCode(0);
		ro.setInfo(cp);
		ro.setMessage("ok");
		return ro;
	}
public ResponseObject getBadHealthReport(String userName){
		ResponseObject ro= new ResponseObject();
	    CheckProjectInfo cp=checkProjectInfoDao.selectByUserName(userName);
		ro.setCode(0);
		ro.setInfo(cp);
		ro.setMessage("ok");
		return ro;
	}
}

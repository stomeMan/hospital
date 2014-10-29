package com.hospital.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hospital.mybatis.dao.CheckProjectInfoDao;
import com.hospital.mybatis.dao.UserDao;
import com.hospital.mybatis.model.CheckProjectInfo;
import com.hospital.pojo.ResponseObject;

@Repository
public class HealthDocLogic {
	@Autowired
	private UserDao userDao;
	@Autowired
	private CheckProjectInfoDao checkProjectInfoDao;
	
	
	public ResponseObject getSimpleHealthReport(String userName){
		ResponseObject ro= new ResponseObject();
	    CheckProjectInfo cp=checkProjectInfoDao.selectByUserName(userName);
		ro.setCode(0);
		ro.setInfo(cp);
		ro.setMessage("ok");
		return ro;
	}
	
	public ResponseObject getDetailHealthReport(String userName){
		ResponseObject ro= new ResponseObject();
	    CheckProjectInfo cp=checkProjectInfoDao.selectByUserName(userName);
		ro.setCode(0);
		ro.setInfo(cp);
		ro.setMessage("ok");
		return ro;
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

package com.hospital.logic;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hospital.helper.DateHelper;
import com.hospital.mybatis.dao.CheckProjectDetailDao;
import com.hospital.mybatis.dao.CheckProjectInfoDao;
import com.hospital.mybatis.dao.CheckReservationDao;
import com.hospital.mybatis.dao.UserDao;
import com.hospital.mybatis.model.CheckReservation;
import com.hospital.pojo.ResponseObject;

@Repository
public class HealthReservationLogic {
	@Autowired
	private UserDao userDao;
	@Autowired
	private CheckProjectInfoDao checkProjectInfoDao;
	@Autowired
	private CheckProjectDetailDao checkProjectDetailDao;
	@Autowired
	private CheckReservationDao healthReservationDao;
	
	
	
	public ResponseObject addCheckReservation(CheckReservation cr){
		ResponseObject ro=new ResponseObject();
		ro.setInfo(cr);
		ro.setCode(0);
		ro.setMessage("添加成功");
		healthReservationDao.insert(cr);
		return ro;
	}
	public ResponseObject updateCheckReservation(CheckReservation cr){
		ResponseObject ro=new ResponseObject();
		CheckReservation newcr= healthReservationDao.selectByUserName(cr.getUserName());
		newcr.setPhone(cr.getPhone());
		newcr.setReservationTime(cr.getReservationTime());
		newcr.setUpdateTime(DateHelper.getDateTimeByNow());
		healthReservationDao.updateReservation(newcr);
		ro.setInfo(cr);
		ro.setCode(0);
		ro.setMessage("修改成功");
		return ro;
	}
	public ResponseObject selectCheckReservation(String name){
		ResponseObject ro=new ResponseObject();
		CheckReservation cr= healthReservationDao.selectByUserName(name);
		ro.setInfo(cr);
		ro.setCode(0);
		ro.setMessage("ok");
		return ro;
	}
	public ResponseObject selectCheckReservationByPhone(String phone){
		ResponseObject ro=new ResponseObject();
		CheckReservation cr= healthReservationDao.selectByPhone(phone);
		ro.setInfo(cr);
		ro.setCode(0);
		ro.setMessage("ok");
		return ro;
	}
}

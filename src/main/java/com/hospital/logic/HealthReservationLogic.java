package com.hospital.logic;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hospital.mybatis.dao.CheckProjectDetailDao;
import com.hospital.mybatis.dao.CheckProjectInfoDao;
import com.hospital.mybatis.dao.CheckReservationDao;
import com.hospital.mybatis.dao.UserDao;

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
	
}

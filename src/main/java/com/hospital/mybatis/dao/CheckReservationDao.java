package com.hospital.mybatis.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hospital.mybatis.model.CheckReservation;

@Repository
public interface CheckReservationDao extends ISqlDao{
	@Autowired
	
  

    public int insert(CheckReservation checkReservation);
    public CheckReservation selectByPrimaryKey(Integer id);
    public CheckReservation selectByUserName(String name);
    public CheckReservation selectByPhone(String phone);
    public int deleteByPrimaryKey(Integer id);
    public void updateReservation(CheckReservation checkReservation);

}
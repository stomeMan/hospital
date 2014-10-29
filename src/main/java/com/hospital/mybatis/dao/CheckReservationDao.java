package com.hospital.mybatis.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hospital.mybatis.model.User;

@Repository
public interface CheckReservationDao extends ISqlDao{
	@Autowired
	
    public int deleteByPrimaryKey(Integer id);

    public int insert(User record);
    public User selectByPrimaryKey(Integer id);
    public User selectByName(String name);
    public User selectByPhone(String phone);
    public int insertUsers(List<User> users);
    public List<User> selectByStatus(Integer status);
    public int updateUser(User user);

}
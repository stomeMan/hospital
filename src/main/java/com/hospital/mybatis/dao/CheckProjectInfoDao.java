package com.hospital.mybatis.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hospital.mybatis.model.CheckProjectInfo;
import com.hospital.mybatis.model.User;

@Repository
public interface CheckProjectInfoDao extends ISqlDao{
	@Autowired
	
    public int deleteByPrimaryKey(Integer id);

    public int insert(User record);
    public CheckProjectInfo selectByPrimaryKey(Integer id);
    public List<CheckProjectInfo> selectListByUserName(Map<String,String> name);
    public CheckProjectInfo selectByUserName(String name);
    public CheckProjectInfo selectByPhone(String phone);
    public int insertUsers(List<User> users);
    public List<CheckProjectInfo> selectByStatus(Integer name);
    public int updateUser(User user);

}
package com.tv189.hospital.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tv189.hospital.helper.DateHelper;
import com.tv189.hospital.mybatis.dao.UserDao;
import com.tv189.hospital.mybatis.model.User;
import com.tv189.hospital.pojo.ResponseObject;

/**
 * @author gaohailiang
 *
 * 2014-6-17
 */
@Service("userLogic")  
public class UserLogic {
	@Autowired
	private UserDao userDao;
	@Autowired LoggerLogic loggerLogic;
	
	
	
	
	/**
	 * 
	 * @param name 登录名
	 * @param password
	 * @param nickName
	 * @return
	 */
	public ResponseObject register(String name,String password,String nickName){
		ResponseObject ro=null;
		User user =userDao.selectByName(name);
		if(user!=null){
			ro=new ResponseObject(0005, "该用户名："+user.getName()+"已经存在请重新选择", "");
			return ro;
		}
		user=new User(name,password);
		user.setRegisterTime(DateHelper.getDateTimeByNow());
		user=this.insertUser(user);
		if(user!=null){
			ro=new ResponseObject(0,"注册成功，请注意保存用户名密码",user);
			return ro;
		}
		return ro=new ResponseObject(000001,"未知错误",user);
	}
	
	
	/**
	 * 
	 * @param user
	 * @return
	 */
	public User insertUser(User user){
		userDao.insert(user);
		return userDao.selectByName(user.getName());
	}
	
	
}

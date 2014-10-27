package com.hospital.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.helper.DateHelper;
import com.hospital.helper.HttpHelper;
import com.hospital.helper.StringHelper;
import com.hospital.mybatis.dao.UserDao;
import com.hospital.mybatis.model.User;
import com.hospital.pojo.ResponseObject;

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
	 * @param name 用户名
	 * @param password
	 * @param nickName
	 * @return
	 */
	public ResponseObject register(String userName,String password,String nickName){
		ResponseObject ro=null;
		User user =userDao.selectByName(userName);
		if(user!=null){
			ro=new ResponseObject(0005, "该用户名："+user.getUserName()+"已经存在请重新选择", "");
			return ro;
		}
		user=new User(userName,password);
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
	 * 获取手机验证码
	 * @param phone 
	 * @return
	 */
	public ResponseObject getCode(String phone){
		ResponseObject ro=new ResponseObject();
		ro.setCode(0);
		ro.setMessage("请注意查收验证码");
		String code=StringHelper.getRadomSixBitNum();
		ro.setResult(HttpHelper.doGet("", "?code="+code));
		return ro;
	}
	/**
	 * 
	 * @param name 用户名
	 * @param password
	 * @param nickName
	 * @return
	 */
	public ResponseObject codeRegister(String password,String phone,String code){
		ResponseObject ro=null;
		User user =userDao.selectByName(phone);
		if(user!=null){
			ro=new ResponseObject(0005, "该手机号已注册："+user.getPhone()+"已经存在请重新选择", "");
			return ro;
		}
		user=new User(null,password);
		user.setRegisterTime(DateHelper.getDateTimeByNow());
		user.setUserName(phone);
		user=this.insertUser(user);
		if(user!=null){
			ro=new ResponseObject(0,"注册成功，请注意保存用户名密码",user);
			return ro;
		}
		return ro=new ResponseObject(000001,"未知错误",user);
	}
	
	/**
	 * 
	 * @param name 登录名
	 * @param password
	 * @param nickName
	 * @return
	 */
	public ResponseObject login(String userName,String password,String nickName){
		ResponseObject ro=null;
		User user =userDao.selectByName(userName);
		if(user!=null){
			if(user.getPassword().equals(password)){
				ro=new ResponseObject(0,"登录成功",user);
				return ro;
			}else{
				ro=new ResponseObject(005,"密码错误","");
				return ro;
			}
		
		}
		return ro=new ResponseObject(000001,"用户未注册，或用户名错误",null);
	}
	
	/**
	 * 
	 * @param user
	 * @return
	 */
	public User insertUser(User user){
		userDao.insert(user);
		return userDao.selectByName(user.getUserName());
	}
	public User getUserByName(String name){
		return userDao.selectByName(name);
	}
	
	
}

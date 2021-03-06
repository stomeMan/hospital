package com.hospital.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.hospital.helper.StringHelper;
import com.hospital.logic.LoggerLogic;
import com.hospital.logic.UserLogic;
import com.hospital.mybatis.model.User;
import com.hospital.pojo.ResponseObject;

/**
 * @author gaohailiang
 * 后台管理
 * 2014-08-29
 */
@Controller
@RequestMapping("/user")
public class UserAction {
	@Autowired
	private UserLogic userLogic;
	@Autowired
	private LoggerLogic loggerLogic;
	
	
	@RequestMapping("/login")
	@ResponseBody
	public String login(HttpServletRequest request,HttpServletResponse response){
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String nickName=request.getParameter("nickName");
		ResponseObject ro=null;
		if(name==null||name.length()==0){
			ro=new ResponseObject(000001,"用户名不能为空","");
			return JSON.toJSONString(ro);
		}
		if(password==null||password.length()==0){
			ro=new ResponseObject(000002,"密码不能为空","");
			return JSON.toJSONString(ro);
		}
		ro=userLogic.login(name, password, nickName);
		if(ro.getInfo() instanceof User){
			request.setAttribute("user", (User)ro.getInfo());
		}
		return JSON.toJSONString(ro);
	}
	
	/*
	 * 
	 */
	@RequestMapping("/register")
	@ResponseBody
	public String register(HttpServletRequest request,HttpServletResponse response){
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String password1=request.getParameter("password1");
		String nickName=request.getParameter("nickName");
		ResponseObject ro=null;
		if(name==null||name.length()==0){
			ro=new ResponseObject(000001,"用户名不能为空","");
			return JSON.toJSONString(ro);
		}
		if(password==null||password.length()==0){
			ro=new ResponseObject(000002,"密码不能为空","");
			return JSON.toJSONString(ro);
		}
		if(password1==null||password1.length()==0||password.indexOf(password1)==-1){
			ro=new ResponseObject(000002,"请确保两次输入密码相同","");
			return JSON.toJSONString(ro);
		}
		ro=userLogic.register(name, password, nickName);
		
		return JSON.toJSONString(ro);
	}
	/*
	 * 
	 */
	@RequestMapping("/code_register")
	@ResponseBody
	public String codeRegister(HttpServletRequest request,HttpServletResponse response){
		String password=request.getParameter("password");
		String password1=request.getParameter("password1");
//		String nickName=request.getParameter("nickName");
		String code=request.getParameter("code");
		String phone=request.getParameter("phone");
		ResponseObject ro=null;
	
		if(password==null||password.length()==0){
			ro=new ResponseObject(000002,"密码不能为空","");
			return JSON.toJSONString(ro);
		}
		if(password1==null||password1.length()==0||password.indexOf(password1)==-1){
			ro=new ResponseObject(000002,"请确保两次输入密码相同","");
			return JSON.toJSONString(ro);
		}
		ro=userLogic.codeRegister(phone, password, code);
		
		return JSON.toJSONString(ro);
	}
	/**
	 * 
	 * @return
	 */
	@RequestMapping("/get_code")
	@ResponseBody
	public String getCode(HttpServletRequest request,HttpServletResponse response){
		String phone=request.getParameter("phone");
		ResponseObject ro=null;
		if(StringHelper.isPhoneNumber(phone)){
			ro=userLogic.getCode(phone);
		}
		return JSON.toJSONString(ro);
	}
	
	
	
	/**
	 * 修改密码
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/update_user_password")
	@ResponseBody
	public String updateUserPassword(HttpServletRequest request,HttpServletResponse response){
		String old_password=request.getParameter("old_password");
		String newpassword1=request.getParameter("newpassword1");
		String newpassword2=request.getParameter("newpassword2");
		String name=request.getParameter("name");
		ResponseObject ro=null;
	
		if(old_password==null||old_password.length()==0||newpassword1==null||newpassword1.length()==0||newpassword2==null||newpassword2.length()==0){
			ro=new ResponseObject(000002,"新旧密码均不能为空","");
			return JSON.toJSONString(ro);
		}
		if(newpassword1.equals(newpassword2)){
			ro=new ResponseObject(000002,"请确保两次新密码输入密码相同","");
			return JSON.toJSONString(ro);
		}
		User user=userLogic.getUserByName(name);
		if(user==null){
			ro=new ResponseObject(000002,"用户名错误","");
			return JSON.toJSONString(ro);
		}
		if(old_password.equals(user.getPassword())){
			userLogic.updateUser(user);
			ro=new ResponseObject(0,"ok","");
			return JSON.toJSONString(ro);
		}else{
			ro=new ResponseObject(6,"旧密码错误",old_password);
		}
		return JSON.toJSONString(ro);
	}
	/**
	 * 
	 * @return
	 */
	@RequestMapping("/datagrid_data2")
	@ResponseBody
	public String gethospital(){
		String ss="{\"total\":28,\"rows\":[{\"productid\":\"FI-SW-01\",\"unitcost\":10.00,\"status\":\"P\",\"listprice\":36.50,\"attr1\":\"Large\",\"itemid\":\"EST-1\"},{\"productid\":\"K9-DL-01\",\"unitcost\":12.00,\"status\":\"P\",\"listprice\":18.50,\"attr1\":\"Spotted Adult Female\",\"itemid\":\"EST-10\"},{\"productid\":\"RP-SN-01\",\"unitcost\":12.00,\"status\":\"P\",\"listprice\":28.50,\"attr1\":\"Venomless\",\"itemid\":\"EST-11\"},{\"productid\":\"RP-SN-01\",\"unitcost\":12.00,\"status\":\"P\",\"listprice\":26.50,\"attr1\":\"Rattleless\",\"itemid\":\"EST-12\"},{\"productid\":\"RP-LI-02\",\"unitcost\":12.00,\"status\":\"P\",\"listprice\":35.50,\"attr1\":\"Green Adult\",\"itemid\":\"EST-13\"},{\"productid\":\"FL-DSH-01\",\"unitcost\":12.00,\"status\":\"P\",\"listprice\":158.50,\"attr1\":\"Tailless\",\"itemid\":\"EST-14\"},{\"productid\":\"FL-DSH-01\",\"unitcost\":12.00,\"status\":\"P\",\"listprice\":83.50,\"attr1\":\"With tail\",\"itemid\":\"EST-15\"},{\"productid\":\"FL-DLH-02\",\"unitcost\":12.00,\"status\":\"P\",\"listprice\":63.50,\"attr1\":\"Adult Female\",\"itemid\":\"EST-16\"},{\"productid\":\"FL-DLH-02\",\"unitcost\":12.00,\"status\":\"P\",\"listprice\":89.50,\"attr1\":\"Adult Male\",\"itemid\":\"EST-17\"},{\"productid\":\"AV-CB-01\",\"unitcost\":92.00,\"status\":\"P\",\"listprice\":63.50,\"attr1\":\"Adult Male\",\"itemid\":\"EST-18\"}],\"footer\":[{\"unitcost\":19.80,\"listprice\":60.40,\"productid\":\"Average:\"},{\"unitcost\":198.00,\"listprice\":604.00,\"productid\":\"Total:\"}]}";
		System.out.println(ss);
		return ss;
	}
}

package com.tv189.hospital.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.tv189.hospital.logic.LoggerLogic;
import com.tv189.hospital.logic.UserLogic;
import com.tv189.hospital.pojo.ResponseObject;

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
		if(ro.getResult() instanceof Object){
			request.setAttribute("user", ro.getResult());
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

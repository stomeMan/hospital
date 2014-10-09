package com.tv189.hospital.controller;




import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.tv189.hospital.logic.LoggerLogic;
import com.tv189.hospital.logic.PackLogic;
import com.tv189.hospital.pojo.ResponseObject;

/**
 * @author gaohailiang
 *
 * 2014-08-29
 */
@Controller
@RequestMapping("/user")
public class UserAction {
	@Autowired
	private PackLogic packLogic;
	@Autowired
	private LoggerLogic loggerLogic;
	
	
	@RequestMapping(value="/toMain")
	public ModelAndView login(HttpServletRequest request,HttpServletResponse response){
		String userName=request.getParameter("username");
		String password=request.getParameter("password");
		System.out.println("username:"+userName);
		System.out.println("password:"+password);
		
		ModelAndView mv=new ModelAndView();
		mv.setViewName("main");  
		return mv;
	}
}

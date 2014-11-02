package com.hospital.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.hospital.logic.HealthDocLogic;
import com.hospital.pojo.ResponseObject;
/**
 * 
 * @author gaohailiang
 *
 */
@Controller
@RequestMapping("/health_manager")
public class HealthManagerAction extends BaseAction{

	@Autowired
	private HealthDocLogic healthDocLogic;
	/**
	 * 获取最近一次体检报告体检报告摘要信息展示
	 * @return
	 */
	@RequestMapping("/get_simple_health_report")
	@ResponseBody
	public String getSimpleHealthReport(HttpServletRequest request,HttpServletResponse response){
		String name=request.getParameter("name");
		ResponseObject ro=null;
		if(name!=null){
			ro=healthDocLogic.getSimpleHealthReport(name);
		}
		return JSON.toJSONString(ro);
	}
	
}

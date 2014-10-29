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
@RequestMapping("/healthy_doc")
public class HealthDocAction extends BaseAction{

	@Autowired
	private HealthDocLogic healthDocLogic;
	/**
	 * 体检报告摘要信息展示
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
	
	/**
	 * 体检报告明细展示
	 * @return
	 */
	@RequestMapping("/get_detail_health_report")
	@ResponseBody
	public String getDetailHealthReport(HttpServletRequest request,HttpServletResponse response){
		String name=request.getParameter("name");
		ResponseObject ro=null;
		if(name!=null){
			ro=healthDocLogic.getDetailHealthReport(name);
		}
		return JSON.toJSONString(ro);
	}
	
	
	/**
	 * 体检报告按时间维度展示
	 * @return
	 */
	@RequestMapping("/get_simple_health_report_by_time")
	@ResponseBody
	public String getSimpleHealthReportByTime(HttpServletRequest request,HttpServletResponse response){
		String name=request.getParameter("name");
		ResponseObject ro=null;
		if(name!=null){
			ro=healthDocLogic.getSimpleHealthReportByTime(name);
		}
		return JSON.toJSONString(ro);
	}
	
	/**
	 * 体检报告按科目维护展示
	 * @return
	 */
	@RequestMapping("/get_simple_health_report_by_subject")
	@ResponseBody
	public String getSimpleHealthReportBySubject(HttpServletRequest request,HttpServletResponse response){
		String name=request.getParameter("name");
		ResponseObject ro=null;
		if(name!=null){
			ro=healthDocLogic.getSimpleHealthReportBySubject(name);
		}
		return JSON.toJSONString(ro);
	}
	
	/**
	 * 体征预警信息展示
	 * @return
	 */
	@RequestMapping("/get_bad_health_report")
	@ResponseBody
	public String getBadHealthReport(HttpServletRequest request,HttpServletResponse response){
		String name=request.getParameter("name");
		ResponseObject ro=null;
		if(name!=null){
			ro=healthDocLogic.getBadHealthReport(name);
		}
		return JSON.toJSONString(ro);
	}
	
}

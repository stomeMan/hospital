package com.hospital.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.hospital.logic.HealthDocLogic;
import com.hospital.mybatis.model.CheckReservation;
import com.hospital.pojo.ResponseObject;
/**
 * 
 * @author gaohailiang
 *
 */
@Controller
@RequestMapping("/reservation")
public class ReservationAction extends BaseAction{

	@Autowired
	private HealthDocLogic healthDocLogic;
	
	
	/**
	 * 获取最近一次体检报告体检报告摘要信息展示
	 * @return
	 */
	@RequestMapping("/get_reservation_Info")
	@ResponseBody
	public String getReservationInfo(HttpServletRequest request,HttpServletResponse response){
		String name=request.getParameter("name");
		ResponseObject ro=null;
		if(name!=null){
			ro=healthDocLogic.getSimpleHealthReport(name);
		}
		return JSON.toJSONString(ro);
	}
	
	
	/**
	 * 获取最近一次体检报告体检报告摘要信息展示
	 * @return
	 */
	@RequestMapping("/get_reservation_Info")
	@ResponseBody
	public String addReservationInfo(HttpServletRequest request,HttpServletResponse response){
		String name=request.getParameter("name");
		String reservationTime=request.getParameter("reservationTime");
		String phone=request.getParameter("phone");
		CheckReservation cr=new CheckReservation();
		cr.setReservationTime(reservationTime);
		cr.setUserName(name);
		cr.setPhone(phone);
		ResponseObject ro=null;
		if(name!=null){
			ro=healthDocLogic.getSimpleHealthReport(name);
		}
		return JSON.toJSONString(ro);
	}
	
	
}

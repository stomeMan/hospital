package com.hospital.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.hospital.helper.DateHelper;
import com.hospital.logic.HealthReservationLogic;
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
	private HealthReservationLogic healthReservationLogic;
	
	
	
	
	/**
	 * 获取最近一次体检报告体检报告摘要信息展示
	 * @return
	 */
	@RequestMapping("/add_reservation_Info")
	@ResponseBody
	public String addReservationInfo(HttpServletRequest request,HttpServletResponse response){
		String name=request.getParameter("name");
		String reservationTime=request.getParameter("reservationTime");
		String phone=request.getParameter("phone");
		CheckReservation cr=new CheckReservation();
		cr.setReservationTime(reservationTime);
		cr.setUserName(name);
		cr.setPhone(phone);
		cr.setUpdateTime(DateHelper.getNowDateTimeyyyyMMddHHmmss());
		ResponseObject ro=null;
		if(name!=null){
			ro=healthReservationLogic.addCheckReservation(cr);
		}
		return JSON.toJSONString(ro);
	}
	/**
	 * 获取最近一次体检报告体检报告摘要信息展示
	 * @return
	 */
	@RequestMapping("/update_reservation")
	@ResponseBody
	public String updateReservationInfo(HttpServletRequest request,HttpServletResponse response){
		String name=request.getParameter("name");
		String reservationTime=request.getParameter("reservationTime");
		String phone=request.getParameter("phone");
		CheckReservation cr=new CheckReservation();
		cr.setReservationTime(reservationTime);
		cr.setUserName(name);
		cr.setPhone(phone);
		cr.setUpdateTime(DateHelper.getNowDateTimeyyyyMMddHHmmss());
		ResponseObject ro=null;
		if(name!=null){
			ro=healthReservationLogic.updateCheckReservation(cr);
		}
		return JSON.toJSONString(ro);
	}
	/**
	 * 获取最近一次体检报告体检报告摘要信息展示
	 * @return
	 */
	@RequestMapping("/select_reservation_by_name")
	@ResponseBody
	public String selectReservationInfo(HttpServletRequest request,HttpServletResponse response){
		String name=request.getParameter("name");
		ResponseObject ro=null;
		if(name!=null){
			ro=healthReservationLogic.selectCheckReservation(name);
		}
		return JSON.toJSONString(ro);
	}

}

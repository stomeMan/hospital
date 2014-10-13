package com.tv189.hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.tv189.hospital.logic.LoggerLogic;
import com.tv189.hospital.logic.PackLogic;
import com.tv189.hospital.pojo.RequestObject;
import com.tv189.hospital.pojo.ResponseObject;

/**
 * @author gaohailiang
 *
 * 2014-08-29
 */
@Controller
@RequestMapping("/pack")
public class PackAction {
	@Autowired
	private PackLogic packLogic;
	@Autowired
	private LoggerLogic loggerLogic;
	
	@RequestMapping("/sayhello")
	@ResponseBody
	public String sayHello(){
		ResponseObject ro=new ResponseObject(0,"ok",null);
		return JSON.toJSONString(ro);
	}
	
	
	
	
	@RequestMapping("/getpack")
	@ResponseBody
	public String gethospital(@RequestParam String user_id){
		ResponseObject ro=new ResponseObject();
		RequestObject requestObject=new RequestObject(user_id);
		ro = packLogic.gethospital(requestObject);//packLogic.gethospital(uId);
		return JSON.toJSONString(ro);
	}
}

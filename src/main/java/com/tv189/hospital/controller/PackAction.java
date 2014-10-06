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
	@RequestMapping("/getpack")
	@ResponseBody
	public String gethospital(@RequestParam String user_id){
		ResponseObject ro=new ResponseObject();
//		String generateToken=Md5Helper.encode(time_stamp+"_"+user_id);
		RequestObject requestObject=new RequestObject(user_id);
//		if(token!=null&&token.equals(generateToken)){
//			GetPackTreadPool gtp=GetPackTreadPool.getInstance();
//			GetPackThread gt=new GetPackThread(loggerLogic, packLogic, requestObject,ro,request,response);
//			gtp.execute(gt);
//			Object data=gt.getResponseObject().getResult();
			ro = packLogic.gethospital(requestObject);//packLogic.gethospital(uId);
//			if(data==null){
//				ro=new ResponseObject(1,"对不起，红包已被抢光了",null);
//			}else{
////				ro=new ResponseObject(0,"恭喜你领取红包成功，请记住卡号和密码",gt.getCardView());
//				ro=new ResponseObject(0,"恭喜你领取红包成功，请记住卡号和密码",data);
//			}
//		}else{
//			ro=new ResponseObject(101,"token失效",null);
//		}

		
		return JSON.toJSONString(ro);
	}
}

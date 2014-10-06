package com.tv189.hospital.helper;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.sf.json.xml.XMLSerializer;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class JsonHelper {
	private static Logger logger = Logger.getLogger(JsonHelper.class);
	
	public static String toJsonStr(Object obj) {
		try{
			return JSON.toJSONString(obj, SerializerFeature.WriteDateUseDateFormat);
		}catch(Exception e){
			logger.error(obj+" toJsonStr fail"+e.getMessage());
			return null;
		}
	}

	public static <T> T toJSONObject(String jsonStr,Class<T> type){
		try{
			return JSON.parseObject(jsonStr,type);
		}catch(Exception e){
			logger.error(jsonStr +","+type+" toJSONObject fail"+e.getMessage());
			return null;
		}
		
	}
	
	public static  <T> List<T> toObjectList(String jsonStr,Class<T> type){
		try{
			return JSON.parseArray(jsonStr, type);
		}catch(Exception e){
			logger.error(jsonStr +","+type+" toObjectList fail"+e.getMessage());
			return null;
		}
	}

	public static <T> T toJSONObjectSlash(String jsonStr,Class<T> type){
		String reInfo = StringHelper.Empty;
		if(StringHelper.isNotEmpty(jsonStr)){
			String temp = jsonStr.replaceAll("\\\\", StringHelper.Empty);
			reInfo = temp.substring(1, temp.length()-1);
		}
		return JSON.parseObject(reInfo,type);
	}
	
	public static <T> T xmlToJson(String xmlInfo,Class<T> type){
		net.sf.json.JSON json = new XMLSerializer().read(xmlInfo);
		String temp = json.toString().replaceAll("@", "");
		if(temp.startsWith("[") && temp.endsWith("]")){
			temp = temp.substring(1, temp.length()-1);
		}
		System.out.println(temp);
		return JsonHelper.toJSONObject(temp, type);
	}
	
	
	
	public static void main(String... args){
//		UserInfo user = new UserInfo();
//		user.setAccountNo("aaaaa");
//		user.setAlipayId("DDDDD");
//		user.setBind("1");
//		String str = JsonHelper.toJson(user);
//		System.out.println(str);
//		UserInfo use = JsonHelper.toJSONObject(str, UserInfo.class);
//		System.out.println(use);
//		System.out.println(JsonHelper.toJson(use));
		String temp = "Francis X. Bushman	,";
		Pattern p = Pattern.compile("\t");
		Matcher m = p.matcher(temp);
		String dest = m.replaceAll("");

		temp.replaceAll("\\t", "");
		System.out.println(dest);
//		String ss = HttpHelper.doGet("http://180.168.69.56:9798/service/program/get_static_info", "appid=10470003000&devid=000021&path=/100183564/2889_100183564_utf8.inc&time=20130626111318&sign=7c40496ef9e8c359686d03696a0f8f37", "utf-8", false);
//		ResultProxy result = JsonHelper.toJSONObject(ss, ResultProxy.class);
//		System.out.println(result.getInfo());
		
		
	}
	
	
}

package com.tv189.hospital.helper;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



import java.util.Collections;


public class StringHelper {
	
	public static final String Empty = "";
	public static final String URL_CONCAT="&";
	public static final String URL_BEGIN="?";
	public static final String PARA_EQUAL="=";
	public static final String SPLITE="|";
	public static final String SLASH = "\\";
	public static final String ENTER="\r\n";
	public static final String EMAIL_SIGN="@";
	public static final String COMMA=",";
	public static final String FULL_COMMA="，";
	public static final String LBRAKETS = "(";
	public static final String RBRAKETS = ")";
	public static final String SPACE = " ";
	public static final String OR = "OR";
	public static final String AND = "AND";
	public static final String DASH = "-";
	public static final String RISK = ":";
	public static final String POINT = ".";
	public static final String NOT = "!";

	public static Boolean isNullOrEmpty(String value) {
		return value == null || StringHelper.Empty.equals(value);
	}

	public static String getNumberString(String number, Integer count,
			String spot) {
		String temp = number;
		for (Integer i = temp.length(); i < count; i++) {
			temp = spot + temp;
		}
		return temp;
	}
	public static Boolean isEmailAddress(String str){
		return str.matches("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$");
	}
	public static Boolean isInStringArr(String search, String[] target){
		Boolean bool = false;
		for(String t : target){
			if(t.equals(search)){
				bool = true;
				break;
			}
		}
		return bool;
	}
	
	public static Boolean isInStringArr(String search, List<String> target){
		Boolean bool = false;
		if(target != null){
			for(String t : target){
				if(search.equals(t)){
					bool = true;
					break;
				}
			}
		}
		return bool;
	}

	public static String getEmptyByNull(Object obj) {
		if (null == obj) {
			return Empty;
		}
		return obj.toString();
	}

	public static String getURIEncodingParam(String urlParam, String encoding) {
		try {
			return new String(urlParam.getBytes("ISO-8859-1"), encoding);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return "";
		}
	}

	public static boolean isNotEmpty(String o) {
		return !isNullOrEmpty(o);
	}

	public static String removeHtmlTag(String html) {
		String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式
		Pattern p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
		Matcher m_html = p_html.matcher(html);
		html = m_html.replaceAll(""); // 过滤html标签

		return html.trim(); // 返回文本字符串
	}

	public static List<String> toList(String str){
		if(str==null){
			return new ArrayList<String>();
		}
		return Arrays.asList(str.split("[,，| ]"));
	}
	
	public static String isNullToEmpty(Object s){
		if(null == s){
			return StringHelper.Empty;
		}
		return s.toString();
	}
	
	public static Integer getRandom(Integer min, Integer max){
		return  (int)(Math.random()*(max-min)+min);
	}
	
	public static String getRandomPass(Integer length){
		Random randGen = new Random();
		char[] numbersAndLetters = ("0123456789").toCharArray();
		char [] randBuffer = new char[length];
        for (Integer i=0; i<randBuffer.length; i++) {
            randBuffer[i] = numbersAndLetters[randGen.nextInt(10)];
        }
        return new String(randBuffer);		
	}
	
	public static Integer getIntegerByStr(String str){
		try{
			Integer temp = Integer.parseInt(str);
			return temp;
		}catch (Exception e) {
			return null;
		}
	}
	
	public static Double getDoubleByStr(String str){
		try{
			Double temp = Double.parseDouble(str);
			return temp;
		}catch (Exception e) {
			return null;
		}
	}
	
	
	public static boolean isNumeric(String str){
		if(isNullOrEmpty(str)) return false;
	    Pattern pattern = Pattern.compile("[0-9]*");
	    return pattern.matcher(str).matches();   
	 } 


	
	/**
	 * 根据传入的参数,进行组合生成参数名称=参数值的字符串
	 * 奇数为参数名称,偶数为参数值
	 * @param paraNameAndValues
	 */
	public static String getParaErrorMsgInfo(String... paraNameAndValues){
		StringBuffer buffer = new StringBuffer();
		for (Integer i = 0; i < paraNameAndValues.length; i+=2) {
			buffer.append(paraNameAndValues[i]).append(StringHelper.PARA_EQUAL).append(paraNameAndValues[i+1]).append(StringHelper.COMMA);
		}
		String errorInfo = buffer.toString();
		return errorInfo.substring(0, errorInfo.length()-1);
	}

	public static boolean isStrInOtherStr(String srcStr,String destStr){
		boolean flag = false;
		if(StringHelper.isNotEmpty(srcStr) && StringHelper.isNotEmpty(destStr)){
			String[] destArr = destStr.split(StringHelper.COMMA);
			String[] srcArr = srcStr.split(StringHelper.COMMA);
			for (String src : srcArr) {
				flag = false;
				for (String dest : destArr) {
					if(dest.equals(src)){
						flag = true;
						break;
					}
				}
				if(!flag){
					return false;
				}
			}
		}
		return flag;
	}
	
	public static String reversString(String s){
		char[] arr = s.toCharArray();
		int end = s.length();
		end = end -1;
		int start = 0;
		while(start < end){
         char temp = arr[start];  
            arr[start] = arr[end];  
            arr[end] = temp;  
            start++;  
            end--;  			
		}
		
		return String.copyValueOf(arr);
	}
	
	/**
	 * 混淆uid
	 */
	public static String resolveUid(String uid, String devid){
		if(uid.length()<17){
			return uid;
		} else {
			String pre = uid.substring(0, 4);
			StringBuffer result = new StringBuffer();
			
			String phone = uid.substring(4, 16);
			String end = uid.substring(16);
			
			int[] p_arr = {StringHelper.getIntegerByStr(phone.substring(0,3)).intValue(),StringHelper.getIntegerByStr(phone.substring(3,6)).intValue(),
					StringHelper.getIntegerByStr(phone.substring(6,9)).intValue(),StringHelper.getIntegerByStr(phone.substring(9)).intValue()};
			
			int dlen = devid.length()-1;
			int[] d_arr = {StringHelper.getIntegerByStr(devid.substring(dlen)).intValue(),StringHelper.getIntegerByStr(devid.substring(dlen-1,dlen)).intValue(),
					StringHelper.getIntegerByStr(devid.substring(dlen-2,dlen-1)).intValue(),StringHelper.getIntegerByStr(devid.substring(dlen-3,dlen-2)).intValue()};
			String fill = "9";
			
			int[] t_arr1 = {8,6,4,2};
			int[] t_arr2 = {1,8,4,2};
			for(int i=0;i<=3;i++){
				String temp;
				if(d_arr[i] == 1){
					temp = String.valueOf(t_arr1[i]*p_arr[i]);
				} else if(d_arr[i] == 0){
					temp = String.valueOf(t_arr2[i]*p_arr[i]);
				} else {
					temp = String.valueOf(p_arr[i] / d_arr[i]) + String.valueOf(p_arr[i] % d_arr[i]);
				}
				int len = temp.length();
				for(int j=1;j<=4-len;j++){
					temp = temp + fill;
				}
				result.append(temp);
			}
			
			return pre+StringHelper.reversString(result.toString())+end;
		}
	}
	
	/**
	 * 反混淆uid
	 */	
	public static String unresolveUid(String uid, String devid){
		if(uid.length()<17){
			return uid;
		} else {
			String pre = uid.substring(0, 4);
			StringBuffer result = new StringBuffer();
			char fill = '9';
			
			String phone = StringHelper.reversString(uid.substring(4, 20));
			String end = uid.substring(20);
			
			String[] pt_arr = {phone.substring(0,4),phone.substring(4,8),phone.substring(8,12),phone.substring(12)};
			int[] p_arr = {0,0,0,0};
			for(int i=0;i<=3;i++){
				for(int j=3;j>=0;j--){
					if(pt_arr[i].charAt(j) == fill){
						pt_arr[i] = pt_arr[i].substring(0, pt_arr[i].length()-1);
					} else {
						break;
					}
				}
				p_arr[i] = StringHelper.getIntegerByStr(pt_arr[i]);
			}
			
			int dlen = devid.length()-1;
			int[] d_arr = {StringHelper.getIntegerByStr(devid.substring(dlen)).intValue(),StringHelper.getIntegerByStr(devid.substring(dlen-1,dlen)).intValue(),
					StringHelper.getIntegerByStr(devid.substring(dlen-2,dlen-1)).intValue(),StringHelper.getIntegerByStr(devid.substring(dlen-3,dlen-2)).intValue()};
			
			
			int[] t_arr1 = {8,6,4,2};
			int[] t_arr2 = {1,8,4,2};
			for(int i=0;i<=3;i++){
				String temp;
				if(d_arr[i] == 1){
					temp = String.valueOf(p_arr[i] / t_arr1[i]);
				} else if(d_arr[i] == 0){
					temp = String.valueOf(p_arr[i] / t_arr2[i]);
				} else {
					temp = String.valueOf((p_arr[i] / 10)*d_arr[i] + p_arr[i]%10);
				}
				for(int t=3-temp.length();t>0;t--){
					temp = "0"+temp;
				}
				result.append(temp);
			}
			
			return pre+result.toString()+end;
		}
	}
	/***
	 * 字符串转码 UTF_8
	 * @param str
	 * @return
	 */
	public static String encode(String str){
	    String reStr=StringHelper.Empty;
	    if (!StringHelper.isNullOrEmpty(str)){
		try {
	            reStr=URLEncoder.encode(str,"UTF-8");
                } catch (Exception e) {
	            // TODO Auto-generated catch block
	           // e.printStackTrace();
                }
	    } 
	    return reStr;
	}
	
	public static void main(String... args){
//		String r = StringHelper.resolveSecret("80260010300","000012","E02EEBF7D8FB40B08ACB1E89F43061CD");
//		System.out.println(r);
//		String b = StringHelper.deResolveSecret("80260010300", "000012", r);
		//                      104320710704990092110509
//		System.out.println(b);  104320710704990096980509    
		String b = StringHelper.resolveUid("104318964800145120509", "000012");
		System.out.println(b);
		String r = StringHelper.unresolveUid(b,"000012");
		System.out.println(r);
	}
	
}

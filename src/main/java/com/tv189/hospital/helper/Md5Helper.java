package com.tv189.hospital.helper;

import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.digest.DigestUtils;


public class Md5Helper {
	public static String encode(String value) {  
        if (value == null) {  
            return null;  
        }  
        return DigestUtils.md5Hex(value);
    }
	
	
	public static String encode(byte[] value) {  
        if (value == null) {  
            return null;  
        }  
        return DigestUtils.md5Hex(value);
    }
	
	
	public static void main(String...args) throws UnsupportedEncodingException{
		DigestUtils.md5Hex("");
//		String string = "1000000049";
//		String string = "asdfsadfsasadf爱上";
//		String md5 = encode(string.getBytes("utf-8"));
//		System.out.println(md5);
//		MyLoggerManager.printInfo(md5);
//		MyLoggerManager.printInfo("D2B2B45B6C8AADEC7C0E078C26272B5A");
//		MyLoggerManager.printInfo(System.currentTimeMillis());
	}
}

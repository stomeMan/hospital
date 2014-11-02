package com.hospital.constant;

public enum ErrorObject {
	USER_NAME_NOTFOUNT("00001","用户名不能为空");
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private final String code;
	private final String name;
	ErrorObject(String code,String name){
		this.code = code;
		this.name=name;
	}
	public String getName() {
		return name;
	}
	public String getCode(){
		return code;
	}
	 
	 
	 
	 
	 
	 
	 
	 
}

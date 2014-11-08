package com.hospital.pojo;

public class ResponseObject {
	private String code;
	private String message;
	private Object info;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public Object getInfo() {
		return info;
	}
	public void setInfo(Object info) {
		this.info = info;
	}
	public ResponseObject(String code, String message, Object info) {
		super();
		this.code = code;
		this.message = message;
		this.info = info;
	}
	public ResponseObject(){
		
	}
	
	
	
	
}

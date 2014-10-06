package com.tv189.hospital.pojo;

import java.io.Serializable;


public class RequestObject implements Serializable{
	
	private static final long serialVersionUID = -2362774473931332311L;
	private String cardnumber;
	private String password;
	private String userId;
	private String requestTime;
	private String token;
	private String time_stamp;
	public RequestObject(){
		
	}
	public RequestObject(String userId){
		this.userId=userId;
	}
	public RequestObject(String cardnumber, String password, String userId,
			String requestTime) {
		super();
		this.cardnumber = cardnumber;
		this.password = password;
		this.userId = userId;
		this.requestTime = requestTime;
	}
	public String getCardnumber() {
		return cardnumber;
	}
	public void setCardnumber(String cardnumber) {
		this.cardnumber = cardnumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getRequestTime() {
		return requestTime;
	}
	public void setRequestTime(String requestTime) {
		this.requestTime = requestTime;
	}
	
	
}
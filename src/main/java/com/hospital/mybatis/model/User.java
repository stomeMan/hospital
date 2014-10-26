package com.hospital.mybatis.model;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

@Repository
public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -922144682743203644L;
	private int  id;
	private String userName;
	private String password;
	private String nickName;
	private String registerTime;
	private String age;
	private String gender;
	
	public User(){
		
	}
	
	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	
	
	
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getRegisterTime() {
		return registerTime;
	}
	public void setRegisterTime(String registerTime) {
		this.registerTime = registerTime;
	}
	public void setId(int id) {
		this.id = id;
	}



	public String getAge() {
		return age;
	}



	public void setAge(String age) {
		this.age = age;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}
	
}

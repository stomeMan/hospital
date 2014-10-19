package com.tv189.hospital.mybatis.model;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

@Repository
public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -922144682743203644L;
	private int  id;
	private String name;
	private String password;
	private String nickName;
	private String registerTime;
	private String age;
	private String gender;
	
	public User(){
		
	}
	
	public User(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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

package com.tv189.hospital.mybatis.model;

import java.io.Serializable;

import org.springframework.stereotype.Repository;
@Repository
public class CardView implements Serializable{
	
	private static final long serialVersionUID = -2362774473931332311L;
	private String cardnumber;
	private String password;
	public CardView(){
		
	}
	public CardView(String cardnumber,String password) {
		super();
		this.cardnumber = cardnumber;
		this.password = password;
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
	
	
}
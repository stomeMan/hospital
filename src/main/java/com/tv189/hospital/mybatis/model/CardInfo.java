package com.tv189.hospital.mybatis.model;

import java.io.Serializable;


import org.springframework.stereotype.Repository;

@Repository
public class CardInfo implements Serializable{
	
	private static final long serialVersionUID = -2362774473931332311L;

	private Integer id;
	private String updateTime;
	private Integer status;
	private String cardNumber;
	private String password;
	public CardInfo(){
		
	}
	public CardInfo(Integer id, String cardNumber, String updateTime,
			String password, Integer status) {
		this.id = id;
		this.updateTime = updateTime;
		this.status = status;
		this.cardNumber=cardNumber;
		this.updateTime=updateTime;
	}
	
	public CardInfo(String updateTime, Integer status, String cardNumber,
			String password) {
		super();
		this.updateTime = updateTime;
		this.status = status;
		this.cardNumber = cardNumber;
		this.password = password;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "CardInfo [id=" + id + ", updateTime=" + updateTime
				+ ", status=" + status + ", cardNumber=" + cardNumber
				+ ", password=" + password + "]";
	}
	
	
}
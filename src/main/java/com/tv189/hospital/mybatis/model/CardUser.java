package com.tv189.hospital.mybatis.model;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

@Repository
public class CardUser implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2026634509771449922L;
	private Integer id;
	private String cardNumber;
	private String updateTime;
	private String userId;
	public CardUser(String cardNumber, String updateTime, String userId) {
		super();
		this.cardNumber = cardNumber;
		this.updateTime = updateTime;
		this.userId = userId;
	}
	public CardUser(){
		
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "CardUser [id=" + id + ", cardNumber=" + cardNumber
				+ ", updateTime=" + updateTime + ", userId=" + userId + "]";
	}
	

}
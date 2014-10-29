package com.hospital.mybatis.model;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

@Repository
public class CheckReservation implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 273869179709348911L;
	/**
	 * 
	 */
	private Integer id;
	private String userName;
	private String updateTime;
	private String phone;
	private String reservationTime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getReservationTime() {
		return reservationTime;
	}
	public void setReservationTime(String reservationTime) {
		this.reservationTime = reservationTime;
	}

}
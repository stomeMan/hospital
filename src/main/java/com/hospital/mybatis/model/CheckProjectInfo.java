package com.hospital.mybatis.model;

import java.io.Serializable;

import org.springframework.stereotype.Repository;
import java.util.List;
/**
 * 
 * @author gaohailiang
 *
 */
@Repository
public class CheckProjectInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5797410701040562326L;
	private int  id;
	private String projectNumber;
	private String projectName;
	private String userName;
	private String signNumber;
	private String doctorName;
	private String doctorNumber;
	private String checkDate;
	private String officeSummary;
	private String officeAdvice;
	private String healthyFlag;
	private List<CheckProjectDetail> checkProjectDetails;
	
	public CheckProjectInfo(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProjectNumber() {
		return projectNumber;
	}

	public void setProjectNumber(String projectNumber) {
		this.projectNumber = projectNumber;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSignNumber() {
		return signNumber;
	}

	public void setSignNumber(String signNumber) {
		this.signNumber = signNumber;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getDoctorNumber() {
		return doctorNumber;
	}

	public void setDoctorNumber(String doctorNumber) {
		this.doctorNumber = doctorNumber;
	}

	public String getCheckDate() {
		return checkDate;
	}

	public void setCheckDate(String checkDate) {
		this.checkDate = checkDate;
	}

	public String getOfficeSummary() {
		return officeSummary;
	}

	public void setOfficeSummary(String officeSummary) {
		this.officeSummary = officeSummary;
	}

	

	public String getOfficeAdvice() {
		return officeAdvice;
	}

	public void setOfficeAdvice(String officeAdvice) {
		this.officeAdvice = officeAdvice;
	}

	public String getHealthyFlag() {
		return healthyFlag;
	}

	public void setHealthyFlag(String healthyFlag) {
		this.healthyFlag = healthyFlag;
	}

	public List<CheckProjectDetail> getCheckProjectDetails() {
		return checkProjectDetails;
	}

	public void setCheckProjectDetails(List<CheckProjectDetail> checkProjectDetails) {
		this.checkProjectDetails = checkProjectDetails;
	}
	

		
	
	
}

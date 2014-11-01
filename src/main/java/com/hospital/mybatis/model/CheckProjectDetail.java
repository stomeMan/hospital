package com.hospital.mybatis.model;

import java.io.Serializable;

import org.springframework.stereotype.Repository;
/**
 * 
 * @author gaohailiang
 *
 */
@Repository
public class CheckProjectDetail implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5797410701040562326L;
	private int  id;
	private String projectName;
	private String singleProjectName;
	private String projectResult;
	private String projectUnit;
	private String projectReferenceRange;
	private String projectTips;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getSingleProjectName() {
		return singleProjectName;
	}
	public void setSingleProjectName(String singleProjectName) {
		this.singleProjectName = singleProjectName;
	}
	public String getProjectResult() {
		return projectResult;
	}
	public void setProjectResult(String projectResult) {
		this.projectResult = projectResult;
	}
	public String getProjectUnit() {
		return projectUnit;
	}
	public void setProjectUnit(String projectUnit) {
		this.projectUnit = projectUnit;
	}
	public String getProjectReferenceRange() {
		return projectReferenceRange;
	}
	public void setProjectReferenceRange(String projectReferenceRange) {
		this.projectReferenceRange = projectReferenceRange;
	}
	public String getProjectTips() {
		return projectTips;
	}
	public void setProjectTips(String projectTips) {
		this.projectTips = projectTips;
	}
	
	
}

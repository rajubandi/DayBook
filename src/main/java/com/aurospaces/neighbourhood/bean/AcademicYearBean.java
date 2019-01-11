package com.aurospaces.neighbourhood.bean;

import java.util.Date;

public class AcademicYearBean {

	 private int id=0,status;
	 private String startYear,endYear,name;
	 protected Date createdTime ;
	 protected Date updatedTime ;
	 
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "AcademicYearBean [id=" + id + ", startYear=" + startYear + ", endYear=" + endYear + ", name=" + name
				+ ", status=" + status + ", createdTime=" + createdTime + ", updatedTime=" + updatedTime + "]";
	}
	public String getStartYear() {
		return startYear;
	}
	public void setStartYear(String startYear) {
		this.startYear = startYear;
	}
	public String getEndYear() {
		return endYear;
	}
	public void setEndYear(String endYear) {
		this.endYear = endYear;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public Date getUpdatedTime() {
		return updatedTime;
	}
	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}

	
}

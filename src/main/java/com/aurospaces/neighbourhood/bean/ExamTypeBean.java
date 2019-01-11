package com.aurospaces.neighbourhood.bean;

import java.util.Date;

public class ExamTypeBean {
	
	
	protected int id=0;
	protected String examType;
	protected Date createdTime ;
	 protected Date updatedTime ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getExamType() {
		return examType;
	}
	public void setExamType(String examType) {
		this.examType = examType;
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
	@Override
	public String toString() {
		return "ExamTypeBean [id=" + id + ", examType=" + examType + ", createdTime=" + createdTime + ", updatedTime="
				+ updatedTime + "]";
	}
	
	

}

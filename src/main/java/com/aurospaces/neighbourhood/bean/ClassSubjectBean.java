package com.aurospaces.neighbourhood.bean;

import java.util.Date;

public class ClassSubjectBean {

	 private int id=0;
	 private String boardId;
	 protected Date createdTime ;
	 protected Date updatedTime ;
	 private String classId;
	 private String subjectId,boardName,className,subjectName;
	 
	 
	 
	public String getBoardName() {
		return boardName;
	}
	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public String getBoardId() {
		return boardId;
	}
	public void setBoardId(String boardId) {
		this.boardId = boardId;
	}
	public String getClassId() {
		return classId;
	}
	public void setClassId(String classId) {
		this.classId = classId;
	}
	public String getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "ClassSubjectBean [id=" + id + ", boardId=" + boardId + ", createdTime=" + createdTime + ", updatedTime="
				+ updatedTime + ", classId=" + classId + ", subjectId=" + subjectId + ", boardName=" + boardName
				+ ", className=" + className + ", subjectName=" + subjectName + "]";
	}
	
	

	
}

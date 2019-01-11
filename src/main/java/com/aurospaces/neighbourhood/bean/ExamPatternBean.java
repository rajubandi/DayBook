package com.aurospaces.neighbourhood.bean;

import java.util.Date;

public class ExamPatternBean {
	
		
	protected String subjectId,subjectName;
	protected String boardId,boardName;
	protected String examTypeId,examType;
	protected String classId, className;
	protected String sectionId,sectionname;
	protected Date createdTime,updatedTime;
	protected String maxMarks;
	protected int id;
	protected String medium,mediumId,randomnum;
	
	
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public String getBoardName() {
		return boardName;
	}
	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}
	public String getExamType() {
		return examType;
	}
	public void setExamType(String examType) {
		this.examType = examType;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getMediumId() {
		return mediumId;
	}
	public void setMediumId(String mediumId) {
		this.mediumId = mediumId;
	}
	
	
	
	public ExamPatternBean() {
		super();
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
	public String getMaxMarks() {
		return maxMarks;
	}
	public void setMaxMarks(String maxMarks) {
		this.maxMarks = maxMarks;
	}
	public String getMedium() {
		return medium;
	}
	public void setMedium(String medium) {
		this.medium = medium;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSectionname() {
		return sectionname;
	}
	public void setSectionname(String sectionname) {
		this.sectionname = sectionname;
	}
	public String getSectionId() {
		return sectionId;
	}
	public void setSectionId(String sectionId) {
		this.sectionId = sectionId;
	}
	public String getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}
	public String getClassId() {
		return classId;
	}
	public void setClassId(String classId) {
		this.classId = classId;
	}
	
	public String getRandomnum() {
		return randomnum;
	}
	public void setRandomnum(String randomnum) {
		this.randomnum = randomnum;
	}
	public String getSubjectI() {
		return subjectId;
	}
	public void setSubjectI(String subjectI) {
		this.subjectId = subjectI;
	}
	public String getBoardId() {
		return boardId;
	}
	public void setBoardId(String boardId) {
		this.boardId = boardId;
	}
	public String getExamTypeId() {
		return examTypeId;
	}
	public void setExamTypeId(String examTypeId) {
		this.examTypeId = examTypeId;
	}
	@Override
	public String toString() {
		return "ExamPatternBean [subjectId=" + subjectId + ", subjectName=" + subjectName + ", boardId=" + boardId
				+ ", boardName=" + boardName + ", examTypeId=" + examTypeId + ", examType=" + examType + ", classId="
				+ classId + ", className=" + className + ", sectionId=" + sectionId + ", sectionname=" + sectionname
				+ ", createdTime=" + createdTime + ", updatedTime=" + updatedTime + ", maxMarks=" + maxMarks + ", id="
				+ id + ", medium=" + medium + ", mediumId=" + mediumId + "]";
	}
	
	
	
	
	

}

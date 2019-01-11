package com.aurospaces.neighbourhood.bean;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class ExamScheduleBean {
 protected String  boardId,medium,classId,section,boardName,mediumId,ClassName,sectionId;
 protected int id   = 0,academicYearId;
 protected String  fromTime,toTime,examTypeId,examTypeName;
 protected String subjectName,subjectId,examDate,randomnum,academicYear;
 protected Date createdTime ;
 protected Date updatedTime ;

public String getAcademicYear() {
	return academicYear;
}

public String getSubjectName() {
	return subjectName;
}

public void setSubjectName(String subjectName) {
	this.subjectName = subjectName;
}

public void setAcademicYear(String acadamicYear) {
	this.academicYear = acadamicYear;
}

public String getRandomnum() {
	return randomnum;
}

public void setRandomnum(String randomnum) {
	this.randomnum = randomnum;
}

public void setExamDate(String examDate) {
	this.examDate = examDate;
}

public String getExamDate() {
	return examDate;
}

public String getExamTypeId() {
	return examTypeId;
}

public void setExamTypeId(String examTypeId) {
	this.examTypeId = examTypeId;
}

public String getExamTypeName() {
	return examTypeName;
}

public void setExamTypeName(String examTypeName) {
	this.examTypeName = examTypeName;
}

public String getBoardName() {
	return boardName;
}

public void setBoardName(String boardName) {
	this.boardName = boardName;
}

public String getMediumId() {
	return mediumId;
}

public void setMediumId(String mediumId) {
	this.mediumId = mediumId;
}

public String getClassName() {
	return ClassName;
}

public void setClassName(String className) {
	ClassName = className;
}

public String getSectionId() {
	return sectionId;
}

public void setSectionId(String sectionId) {
	this.sectionId = sectionId;
}

public int getAcademicYearId() {
	return academicYearId;
}

public void setAcademicYearId(int acadamicYearId) {
	this.academicYearId = acadamicYearId;
}

public String getBoardId() {
	return boardId;
}

public void setBoardId(String boardId) {
	this.boardId = boardId;
}

public String getMedium() {
	return medium;
}

public void setMedium(String medium) {
	this.medium = medium;
}

public String getClassId() {
	return classId;
}

public void setClassId(String classId) {
	this.classId = classId;
}

public String getSection() {
	return section;
}

public void setSection(String section) {
	this.section = section;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getFromTime() {
	return fromTime;
}

public void setFromTime(String fromTime) {
	this.fromTime = fromTime;
}

public String getToTime() {
	return toTime;
}

public void setToTime(String toTime) {
	this.toTime = toTime;
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

@Override
public String toString() {
	return "ExamScheduleBean [boardId=" + boardId + ", medium=" + medium + ", classId=" + classId + ", section="
			+ section + ", boardName=" + boardName + ", mediumId=" + mediumId + ", ClassName=" + ClassName
			+ ", sectionId=" + sectionId + ", id=" + id + ", fromTime=" + fromTime + ", toTime=" + toTime
			+ ", examTypeId=" + examTypeId + ", examTypeName=" + examTypeName + ", subjectName=" + subjectName
			+ ", subjectId=" + subjectId + ", acadamicYearId=" + academicYearId + ", examDate=" + examDate
			+ ", randomnum=" + randomnum + ", acadamicYear=" + academicYear + ", createdTime=" + createdTime
			+ ", updatedTime=" + updatedTime + "]";
}





}

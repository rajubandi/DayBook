package com.aurospaces.neighbourhood.bean;

import java.util.Date;

public class StudentMarksBean {
	
	protected String studentId ,studentName, studentMarks,totalStudentMarks,fatherName,mobileNumber;
	
	protected String subjectId,subjectTitle, subjectMaxMarks, totalSubjectMarks;
	protected String boardId,boardName;
	protected String examTypeId, examTypeName,academicYear;
	protected String classId,className;
	protected String sectionId,sectionName;
	protected Date createdTime,examConductedDate;
	protected Date updatedTime;
	protected String medium;
	protected int id;
	private int academicYearId;

	public int getAcademicYearId() {
		return academicYearId;
	}
	public void setAcademicYearId(int academicYearId) {
		this.academicYearId = academicYearId;
	}
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
	public String getSectionName() {
		return sectionName;
	}
	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}
	public String getSubjectTitle() {
		return subjectTitle;
	}
	public void setSubjectTitle(String subjectTitle) {
		this.subjectTitle = subjectTitle;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getAcademicYear() {
		return academicYear;
	}
	public void setAcademicYear(String academicYearId) {
		this.academicYear = academicYearId;
	}
	public Date getExamConductedDate() {
		return examConductedDate;
	}
	public void setExamConductedDate(Date examConductedDate) {
		this.examConductedDate = examConductedDate;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getTotalStudentMarks() {
		return totalStudentMarks;
	}
	public void setTotalStudentMarks(String totalStudentMarks) {
		this.totalStudentMarks = totalStudentMarks;
	}
	public String getTotalSubjectMarks() {
		return totalSubjectMarks;
	}
	public void setTotalSubjectMarks(String totalSubjectMarks) {
		this.totalSubjectMarks = totalSubjectMarks;
	}
	public String getExamTypeName() {
		return examTypeName;
	}
	public void setExamTypeName(String examTypeName) {
		this.examTypeName = examTypeName;
	}
	
	
	
	
	public Date getCreatedTime() {
		return createdTime;
	}
	public Date getUpdatedTime() {
		return updatedTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}
	public String getStudentMarks() {
		return studentMarks;
	}
	public String getSubjectMaxMarks() {
		return subjectMaxMarks;
	}
	public void setStudentMarks(String studentMarks) {
		this.studentMarks = studentMarks;
	}
	public void setSubjectMaxMarks(String subjectMaxMarks) {
		this.subjectMaxMarks = subjectMaxMarks;
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
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
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
		return "StudentMarksBean [studentId=" + studentId + ", studentName=" + studentName + ", studentMarks="
				+ studentMarks + ", totalStudentMarks=" + totalStudentMarks + ", fatherName=" + fatherName
				+ ", mobileNumber=" + mobileNumber + ", subjectId=" + subjectId + ", subjectTitle=" + subjectTitle
				+ ", subjectMaxMarks=" + subjectMaxMarks + ", totalSubjectMarks=" + totalSubjectMarks + ", boardId="
				+ boardId + ", boardName=" + boardName + ", examTypeId=" + examTypeId + ", examTypeName=" + examTypeName
				+ ", academicYear=" + academicYear + ", classId=" + classId + ", className=" + className
				+ ", sectionId=" + sectionId + ", sectionName=" + sectionName + ", createdTime=" + createdTime
				+ ", examConductedDate=" + examConductedDate + ", updatedTime=" + updatedTime + ", medium=" + medium
				+ ", id=" + id + ", academicYearId=" + academicYearId + "]";
	}
	
	
	
	
	

}

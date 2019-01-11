package com.aurospaces.neighbourhood.bean;

public class FilterBean {
private int id;
private String className;
private String boardName;
private String sectionName;
private String mediumName;
String studentName;
public String getStudentName() {
	return studentName;
}
public void setStudentName(String studentName) {
	this.studentName = studentName;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getClassName() {
	return className;
}
public void setClassName(String className) {
	this.className = className;
}
public String getBoardName() {
	return boardName;
}
public void setBoardName(String boardName) {
	this.boardName = boardName;
}
public String getSectionName() {
	return sectionName;
}
public void setSectionName(String sectionName) {
	this.sectionName = sectionName;
}
public String getMediumName() {
	return mediumName;
}
public void setMediumName(String mediumName) {
	this.mediumName = mediumName;
}


}

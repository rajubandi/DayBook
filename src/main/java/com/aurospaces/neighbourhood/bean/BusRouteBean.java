package com.aurospaces.neighbourhood.bean;

import java.util.Date;

public class BusRouteBean {

	 protected String  boardName,medium,className,section;
	 protected String  boardId,mediumId,classId,sectionId;
	 private int id;
	 private String routeName,routeId;
	 private double busFee;
	 protected Date createdTime ;
	 protected Date updatedTime;
	
	
	public String getRouteId() {
		return routeId;
	}

	public void setRouteId(String routeId) {
		this.routeId = routeId;
	}

	@Override
	public String toString() {
		return "BusRouteBean [boardName=" + boardName + ", medium=" + medium + ", className=" + className + ", section="
				+ section + ", boardId=" + boardId + ", mediumId=" + mediumId + ", classId=" + classId + ", sectionId="
				+ sectionId + ", id=" + id + ", routeName=" + routeName + ", routeId=" + routeId + ", busFee=" + busFee
				+ ", createdTime=" + createdTime + ", updatedTime=" + updatedTime + "]";
	}

	public String getBoardName() {
		return boardName;
	}

	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}

	public String getMedium() {
		return medium;
	}

	public void setMedium(String medium) {
		this.medium = medium;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getBoardId() {
		return boardId;
	}

	public void setBoardId(String boardId) {
		this.boardId = boardId;
	}

	public String getMediumId() {
		return mediumId;
	}

	public void setMediumId(String mediumId) {
		this.mediumId = mediumId;
	}

	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	public String getSectionId() {
		return sectionId;
	}

	public void setSectionId(String sectionId) {
		this.sectionId = sectionId;
	}

	public String getRouteName() {
		return routeName;
	}
	
	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}
	public double getBusFee() {
		return busFee;
	}
	public void setBusFee(double busFee) {
		this.busFee = busFee;
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

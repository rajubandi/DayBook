package com.aurospaces.neighbourhood.bean;

import java.util.Date;

public class AddAccountHeadBean {
	 private int id;
	 private String name,accountHead;
	 public String getAccountHead() {
		return accountHead;
	}
	public void setAccountHead(String accountHead) {
		this.accountHead = accountHead;
	}
	protected Date createdTime ;
	 protected Date updatedTime,monthPicker;
	
	public Date getMonthPicker() {
		return monthPicker;
	}
	public void setMonthPicker(Date monthPicker) {
		this.monthPicker = monthPicker;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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

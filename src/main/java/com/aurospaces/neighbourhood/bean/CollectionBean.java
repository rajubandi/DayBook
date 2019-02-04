package com.aurospaces.neighbourhood.bean;

import java.util.Date;

public class CollectionBean {

	private int id,clientid;
	private Date date,duedate;
	private String client,description,fullamount,paidamount,dueamount;
	
	public Date getDate() {
		return date;
	}

	public int getClientid() {
		return clientid;
	}

	public void setClientid(int clientid) {
		this.clientid = clientid;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getDuedate() {
		return duedate;
	}

	public void setDuedate(Date duedate) {
		this.duedate = duedate;
	}	
	
	public String getDueamount() {
		return dueamount;
	}

	public void setDueamount(String dueamount) {
		this.dueamount = dueamount;
	}	

	public String getPaidamount() {
		return paidamount;
	}

	public void setPaidamount(String paidamount) {
		this.paidamount = paidamount;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}	
	
	public String getClient() {
		return client;
	}
	
	public void setClient(String client) {
		this.client = client;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getFullamount() {
		return fullamount;
	}

	public void setFullamount(String fullamount) {
		this.fullamount = fullamount;
	}

	public void setDescription(String description) {
		this.description = description;
	}	
	
}
package com.aurospaces.neighbourhood.bean;

import java.util.Date;

public class DFCBean {
	
	private Date from;
	private Date to;
	private String amount,createdTime;
	private String total;
	
	public String getCreatedTime() {
		return createdTime;
	}


	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}


	public String getAmount() {
		return amount;
	}


	public void setAmount(String amount) {
		this.amount = amount;
	}


	public String getTotal() {
		return total;
	}


	public void setTotal(String total) {
		this.total = total;
	}


	@Override
	public String toString() {
		return "DFCBean [from=" + from + ", to=" + to + ", createdTime=" + createdTime + ", amount=" + amount
				+ ", total=" + total + "]";
	}


	public Date getFrom() {
		return from;
	}
	
	
	public DFCBean() {
		super();
	}


	public void setFrom(Date from) {
		this.from = from;
	}
	public Date getTo() {
		return to;
	}
	public void setTo(Date to) {
		this.to = to;
	}
	

}

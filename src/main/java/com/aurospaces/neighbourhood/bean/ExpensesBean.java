package com.aurospaces.neighbourhood.bean;

import java.util.Date;

public class ExpensesBean {
	private int id;
	private Date dairydate,createdTime, updatedTime;
	private String discription,accountHead,accountHeadId,accountHead1;
	private String amount;
	private String total,strDate;
	private Date from;
	private Date to;
	private String academicYear;
	
	public String getAcademicYear() {
		return academicYear;
	}

	public void setAcademicYear(String academicYear) {
		this.academicYear = academicYear;
	}

	public String getAccountHead1() {
		return accountHead1;
	}

	public void setAccountHead1(String accountHead1) {
		this.accountHead1 = accountHead1;
	}

	public String getAccountHead() {
		return accountHead;
	}

	public void setAccountHead(String accountHead) {
		this.accountHead = accountHead;
	}

	public String getAccountHeadId() {
		return accountHeadId;
	}

	public void setAccountHeadId(String accountHeadId) {
		this.accountHeadId = accountHeadId;
	}

	public Date getFrom() {
		return from;
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

	public String getStrDate() {
		return strDate;
	}

	public void setStrDate(String strDate) {
		this.strDate = strDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDairydate() {
		return dairydate;
	}

	public void setDairydate(Date dairydate) {
		this.dairydate = dairydate;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public Date getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}	
	
	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date date) {
		this.createdTime = date;
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
		return "ExpensesBean [id=" + id + ",  dairydate=" + dairydate
				+ ", createdTime=" + createdTime + ", updatedTime=" + updatedTime + ", discription=" + discription
				+ ", accountHead=" + accountHead + ", accountHeadId=" + accountHeadId + ", accountHead1=" + accountHead1
				+ ", amount=" + amount + ", total=" + total + ", strDate=" + strDate + ", from=" + from + ", to=" + to
				+ ", academicYear=" + academicYear + "]";
	}
}
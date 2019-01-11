package com.aurospaces.neighbourhood.db.model;

public class Reports {
	private String count;
	private String sumofNetAmount;
	private String monthName;
	private String year;
	private String clientNmae;
	private String serviceName;
	private String vendorName;
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public String getClientNmae() {
		return clientNmae;
	}
	public void setClientNmae(String clientNmae) {
		this.clientNmae = clientNmae;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public String getSumofNetAmount() {
		return sumofNetAmount;
	}
	public void setSumofNetAmount(String sumofNetAmount) {
		this.sumofNetAmount = sumofNetAmount;
	}
	public String getMonthName() {
		return monthName;
	}
	public void setMonthName(String monthName) {
		this.monthName = monthName;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	
   
}

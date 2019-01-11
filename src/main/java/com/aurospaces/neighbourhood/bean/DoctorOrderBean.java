package com.aurospaces.neighbourhood.bean;

import java.util.List;



public class DoctorOrderBean {
	private String doctortypeId;
	private String doctortypeName;
	private String doctortypeDesc;
	private String contactEmail;
	private String orderAddress;
	private String appointmentDate;
	private String contactNo;
	private String orderId;
	private String symptomsDesc;
	private String statusId;
	private String customerId;
	private String serviceId;
	private String password;
	private String totalPrice;
	private String totalDiscount;
	private String netAmount;
	private String bookedDate;
	private String orderDescription;
	private String timeName;
	private String locationId;
	private String scheduleName;
	private boolean isNewCustomer;
	
	
	public boolean isNewCustomer() {
		return isNewCustomer;
	}
	public void setNewCustomer(boolean isNewCustomer) {
		this.isNewCustomer = isNewCustomer;
	}
	public String getScheduleName() {
		return scheduleName;
	}
	public void setScheduleName(String scheduleName) {
		this.scheduleName = scheduleName;
	}
	public String getLocationId() {
		return locationId;
	}
	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}
	public String getTimeName() {
		return timeName;
	}
	public void setTimeName(String timeName) {
		this.timeName = timeName;
	}
	public String getOrderDescription() {
		return orderDescription;
	}
	public void setOrderDescription(String orderDescription) {
		this.orderDescription = orderDescription;
	}
	public String getBookedDate() {
		return bookedDate;
	}
	public void setBookedDate(String bookedDate) {
		this.bookedDate = bookedDate;
	}
	public String getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getTotalDiscount() {
		return totalDiscount;
	}
	public void setTotalDiscount(String totalDiscount) {
		this.totalDiscount = totalDiscount;
	}
	public String getNetAmount() {
		return netAmount;
	}
	public void setNetAmount(String netAmount) {
		this.netAmount = netAmount;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getServiceId() {
		return serviceId;
	}
	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}
	
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getStatusId() {
		return statusId;
	}
	public void setStatusId(String statusId) {
		this.statusId = statusId;
	}
	public String getSymptomsDesc() {
		return symptomsDesc;
	}
	public void setSymptomsDesc(String symptomsDesc) {
		this.symptomsDesc = symptomsDesc;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	private String appointmentSlotId;
	private List<SymptomsBean> listSymptomsBean;
	
	public List<SymptomsBean> getListSymptomsBean() {
		return listSymptomsBean;
	}
	public void setListSymptomsBean(List<SymptomsBean> listSymptomsBean) {
		this.listSymptomsBean = listSymptomsBean;
	}
	public String getDoctortypeId() {
		return doctortypeId;
	}
	public void setDoctortypeId(String doctortypeId) {
		this.doctortypeId = doctortypeId;
	}
	public String getDoctortypeName() {
		return doctortypeName;
	}
	public void setDoctortypeName(String doctortypeName) {
		this.doctortypeName = doctortypeName;
	}
	public String getDoctortypeDesc() {
		return doctortypeDesc;
	}
	public void setDoctortypeDesc(String doctortypeDesc) {
		this.doctortypeDesc = doctortypeDesc;
	}
	public String getContactEmail() {
		return contactEmail;
	}
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}
	public String getOrderAddress() {
		return orderAddress;
	}
	public void setOrderAddress(String orderAddress) {
		this.orderAddress = orderAddress;
	}
	public String getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	public String getAppointmentSlotId() {
		return appointmentSlotId;
	}
	public void setAppointmentSlotId(String appointmentSlotId) {
		this.appointmentSlotId = appointmentSlotId;
	}
	

}

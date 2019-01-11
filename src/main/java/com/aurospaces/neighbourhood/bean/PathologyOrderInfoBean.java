package com.aurospaces.neighbourhood.bean;

import java.util.List;

public class PathologyOrderInfoBean {

	private String orderId;
	private String bookedDate;
	private String appointmentDate;
	private String appointmentSlotId;
	private String contactNo;
	private String contactEmail;
	private String orderAddress;
	private String TotalPrice;
	private String TotalDiscount;
	private String NetAmount;
	private String password;
	private String customerId;
	private String serviceId;
	private String mobileNumber;
	private String emailId;
	private String address;
	private String orderDescription;
	private String timeName;
	private String locationId;
	private String isOthersID;
	private String isPackageID;
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

	public String getIsOthersID() {
		return isOthersID;
	}

	public void setIsOthersID(String isOthersID) {
		this.isOthersID = isOthersID;
	}

	public String getIsPackageID() {
		return isPackageID;
	}

	public void setIsPackageID(String isPackageID) {
		this.isPackageID = isPackageID;
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

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	private List<PathologyTestsBean> listPathologyTestsBeans;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<PathologyTestsBean> getListPathologyTestsBeans() {
		return listPathologyTestsBeans;
	}

	public void setListPathologyTestsBeans(
			List<PathologyTestsBean> listPathologyTestsBeans) {
		this.listPathologyTestsBeans = listPathologyTestsBeans;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getBookedDate() {
		return bookedDate;
	}

	public void setBookedDate(String bookedDate) {
		this.bookedDate = bookedDate;
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

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
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

	public String getTotalPrice() {
		return TotalPrice;
	}

	public void setTotalPrice(String totalPrice) {
		TotalPrice = totalPrice;
	}

	public String getTotalDiscount() {
		return TotalDiscount;
	}

	public void setTotalDiscount(String totalDiscount) {
		TotalDiscount = totalDiscount;
	}

	public String getNetAmount() {
		return NetAmount;
	}

	public void setNetAmount(String netAmount) {
		NetAmount = netAmount;
	}

}
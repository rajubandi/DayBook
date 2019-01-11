package com.aurospace.nbd.model;

import com.google.gson.annotations.SerializedName;

public class OtherBooking {

	@SerializedName("problem_desc")
	private String problemDescription;

	@SerializedName("selected_day_slot")
	private String selectedDaySlot;

	@SerializedName("selected_time_slot")
	private String selectedTimeSlot;

	@SerializedName("customer_email_address")
	private String customerEmailAddress;

	@SerializedName("cPhone")
	private String customerPhoneNumber;

	@SerializedName("cPassword")
	private String password;

	@SerializedName("cAddress")
	private String customerServicingAddress;

	public String getProblemDescription() {
		return problemDescription;
	}

	public void setProblemDescription(String problemDescription) {
		this.problemDescription = problemDescription;
	}

	public String getSelectedDaySlot() {
		return selectedDaySlot;
	}

	public void setSelectedDaySlot(String selectedDaySlot) {
		this.selectedDaySlot = selectedDaySlot;
	}

	public String getSelectedTimeSlot() {
		return selectedTimeSlot;
	}

	public void setSelectedTimeSlot(String selectedTimeSlot) {
		this.selectedTimeSlot = selectedTimeSlot;
	}

	public String getCustomerEmailAddress() {
		return customerEmailAddress;
	}

	public void setCustomerEmailAddress(String customerEmailAddress) {
		this.customerEmailAddress = customerEmailAddress;
	}

	public String getCustomerPhoneNumber() {
		return customerPhoneNumber;
	}

	public void setCustomerPhoneNumber(String customerPhoneNumber) {
		this.customerPhoneNumber = customerPhoneNumber;
	}

	public String getCustomerServicingAddress() {
		return customerServicingAddress;
	}

	public void setCustomerServicingAddress(String customerServicingAddress) {
		this.customerServicingAddress = customerServicingAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}

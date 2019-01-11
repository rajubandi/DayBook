package com.aurospace.nbd.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class PathologyBooking {

	@SerializedName("pathology_data")
	private List<PathologyModel> pathologyData;

	@SerializedName("selected_day_slot")
	private String selectedDaySlot;

	@SerializedName("selected_time_slot")
	private String selectedTimeSlot;

	@SerializedName("customer_email_address")
	private String customerEmailAddress;

	@SerializedName("customer_mobile_number")
	private String customerPhoneNumber;

	@SerializedName("customer_password")
	private String password;

	@SerializedName("customer_servicing_address")
	private String customerServicingAddress;

	public List<PathologyModel> getPathologyData() {
		return pathologyData;
	}

	public void setPathologyData(List<PathologyModel> pathologyData) {
		this.pathologyData = pathologyData;
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

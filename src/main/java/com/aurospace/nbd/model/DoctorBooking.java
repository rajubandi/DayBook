package com.aurospace.nbd.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class DoctorBooking {

	@SerializedName("doctor_type")
	private DoctorTypeModel doctorType;

	@SerializedName("symptoms")
	private List<String> symptomsData;

	@SerializedName("selected_day_slot")
	private String selectedDaySlot;

	@SerializedName("selected_time_slot")
	private String selectedTimeSlot;

	@SerializedName("customer_email_address")
	private String customerEmailAddress;

	@SerializedName("customer_mobile_number")
	private String customerPhoneNumber;

	@SerializedName("customer_servicing_address")
	private String customerServicingAddress;

	@SerializedName("customer_password")
	private String password;

	public DoctorTypeModel getDoctorType() {
		return doctorType;
	}
	

	public void setDoctorType(DoctorTypeModel doctorType) {
		this.doctorType = doctorType;
	}

	public List<String> getSymptomsData() {
		return symptomsData;
	}

	public void setSymptomsData(List<String> symptomsData) {
		this.symptomsData = symptomsData;
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
